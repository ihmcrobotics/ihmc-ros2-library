cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/")
set(CMAKE_BUILD_TYPE Debug)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(ament_cmake QUIET)

if(ament_cmake_FOUND)
    set(STANDALONE_PLUGIN OFF CACHE BOOL "Build as a dynamic library to be installed. Used in combination with ROS2.")
else()
    set(STANDALONE_PLUGIN ON CACHE BOOL "Build as a static library to be included from the classpath.")
endif()
message(STATUS "Standalone plugin mode: ${STANDALONE_PLUGIN}")

include(FindOrDownloadJDK)
include_directories(${JNI_INCLUDE_DIRS})

if(STANDALONE_PLUGIN)
    include(ExternalProject)

    if(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
        message(STATUS "Setting initial default cmake install prefix path: ${CMAKE_SOURCE_DIR}")
        set(CMAKE_INSTALL_PREFIX ${CMAKE_SOURCE_DIR} CACHE PATH "IHMC Pub Sub install prefix" FORCE)
    endif()
    message(STATUS "CMake install prefix: ${CMAKE_INSTALL_PREFIX}")
    message(STATUS "CMake current binary directory: ${CMAKE_CURRENT_BINARY_DIR}")

    SET(LIBRARY_RESOURCES_DIRECTORY "src/main/resources/us/ihmc/rtps/impl/fastRTPS")

    set(FAST_RTPS_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-install")
    
    ExternalProject_Add(FoonathanMemory
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/foonathan_memory_vendor/"
        BINARY_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-build"
        STAMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-stamp"
        DOWNLOAD_COMMAND ""
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        TMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-tmp"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS  
            "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        )
        
    ExternalProject_Add(FastCDR
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/Fast-CDR/"    
        DOWNLOAD_COMMAND ""
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS  
            "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        ) 
        
        ExternalProject_Add(tinyxml2
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/tinyxml2/"    
        DOWNLOAD_COMMAND ""
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS  
            "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        ) 
        
    set(FAST_RTPS_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-install")
    message(STATUS "FastRTPS install prefix: ${FAST_RTPS_INSTALL_PREFIX}")
    ExternalProject_Add(FastRTPS
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/Fast-RTPS"
        DOWNLOAD_COMMAND ""
        #UPDATE_COMMAND "${CMAKE_COMMAND}" -E chdir "${PROJECT_SOURCE_DIR}" git submodule update --recursive --init "thirdparty/Fast-RTPS"
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        TMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-tmp"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS
        "-DCMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}"
        "-DCOMPILE_EXAMPLES=OFF"
        "-DBUILD_TESTING=OFF"
        "-DAsio_INCLUDE_DIR=${PROJECT_SOURCE_DIR}/thirdparty/asio/asio/include"
		"-DNO_TLS=ON"
		"-DSHM_TRANSPORT_DEFAULT=ON"
		"-DSTRICT_REALTIME=ON"
        "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        "-DCMAKE_INSTALL_RPATH=${CMAKE_INSTALL_RPATH}"
    )

    ExternalProject_Add_StepDependencies(FastRTPS build FoonathanMemory FastCDR tinyxml2)
    link_directories("${FAST_RTPS_INSTALL_PREFIX}/lib")
    include_directories("${FAST_RTPS_INSTALL_PREFIX}/include")
    
	add_compile_definitions("FASTRTPS_DYN_LINK")
    
    if(WIN32)
        set(FastRTPS_LIBRARIES Iphlpapi Shlwapi)
    else()
        set(FastRTPS_LIBRARIES fastrtps fastcdr foonathan_memory-0.7.1 dl)
    endif()
else()
    message(STATUS "Including fastrtps from ROS 2 build")
    find_package(fastrtps REQUIRED)
    
    link_directories("${fastrtps_LIB_DIR}")
    include_directories("${fastrtps_INCLUDE_DIR}")
    
    set(FastRTPS_LIBRARIES fastcdr fastrtps)
    add_custom_target(FastRTPS)
endif()

add_subdirectory(cppsrc/FastRTPS)
#add_subdirectory(cppsrc/test) # Add when tests are fixed
add_subdirectory(swig/FastRTPS)

if(NOT STANDALONE_PLUGIN)
    if(ament_cmake_FOUND)
        # This is a ROS2 build
        ament_export_libraries(FastRTPSWrapper)
        ament_package()
    endif()
endif()
