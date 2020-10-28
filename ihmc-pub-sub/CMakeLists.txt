cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/")
set(CMAKE_BUILD_TYPE Release)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(ament_cmake QUIET)

if(ament_cmake_FOUND)
    set(STANDALONE_PLUGIN OFF CACHE BOOL "Build as a static library to be included from the classpath.")
else()
    set(STANDALONE_PLUGIN ON CACHE BOOL "Build as a dynamic library to be installed. Used in combination with ROS2.")
endif()

include(FindOrDownloadJDK)
include_directories(${JNI_INCLUDE_DIRS})

if(STANDALONE_PLUGIN)
    include(ExternalProject)

    if(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
    set(CMAKE_INSTALL_PREFIX
        ${CMAKE_SOURCE_DIR} CACHE PATH "IHMC Pub Sub install prefix" FORCE
        )
    endif(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)

    SET(LIBRARY_RESOURCES_DIRECTORY "src/main/resources/us/ihmc/rtps/impl/fastRTPS")

    set(FOONATHAN_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-install")
    message(STATUS "Foonathan memory prefix: ${FOONATHAN_INSTALL_PREFIX}")

    ExternalProject_Add(FoonathanMemory
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/foonathan_memory_vendor/"
        BINARY_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-build"
        STAMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-stamp"
        DOWNLOAD_COMMAND ""
        UPDATE_COMMAND ""
        INSTALL_DIR "${FOONATHAN_INSTALL_PREFIX}"
        TMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/foonathan_memory-tmp"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS  
            "-DCMAKE_INSTALL_PREFIX=${FOONATHAN_INSTALL_PREFIX}"
        )

    set(FAST_RTPS_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-install")
    message(STATUS "FastRTPS Install Prefix: ${FAST_RTPS_INSTALL_PREFIX}")

	if(WIN32)
		SET(foonathan_memory_DIR "${FOONATHAN_INSTALL_PREFIX}/share/foonathan_memory/cmake/")
	else()
		SET(foonathan_memory_DIR "${FOONATHAN_INSTALL_PREFIX}/lib/foonathan_memory/cmake/")
	endif()

    ExternalProject_Add(FastRTPS
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/Fast-RTPS"
        BINARY_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-build"
        STAMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-stamp"
        DOWNLOAD_COMMAND ""
        #UPDATE_COMMAND "${CMAKE_COMMAND}" -E chdir "${PROJECT_SOURCE_DIR}" git submodule update --recursive --init "thirdparty/Fast-RTPS"
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        TMP_DIR "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-tmp"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS
        "-DEPROSIMA_BUILD=OFF"
        "-DCMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}"
        "-DCOMPILE_EXAMPLES=OFF"
        "-DINTERNAL_DEBUG=ON"
        "-DBUILD_SHARED_LIBS=OFF"
        "-DBUILD_TESTING=OFF"
        "-DTHIRDPARTY=ON"
        "-DTHIRDPARTY_fastcdr=ON"
        "-DTINYXML2_FROM_SOURCE=ON"
        "-DNO_TLS=ON"
        "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        "-DCMAKE_POSITION_INDEPENDENT_CODE=true"
        "-Dfoonathan_memory_DIR=${foonathan_memory_DIR}"
        "-DCMAKE_INSTALL_RPATH=${CMAKE_INSTALL_RPATH}"
    )
    ExternalProject_Add_StepDependencies(FastRTPS build FoonathanMemory)

    link_directories("${FAST_RTPS_INSTALL_PREFIX}/lib" "${FOONATHAN_INSTALL_PREFIX}/lib")
    include_directories("${FAST_RTPS_INSTALL_PREFIX}/include")
    if(WIN32)
        set(FastRTPS_LIBRARIES libfastrtps-1.9 libfastcdr-1.0 foonathan_memory-0.6.2 Iphlpapi Shlwapi)
    else()
        set(FastRTPS_LIBRARIES fastrtps fastcdr foonathan_memory-0.6.2 dl)
    endif()

else(STANDALONE_PLUGIN)
    find_package(fastrtps REQUIRED)
    
    link_directories("${fastrtps_LIB_DIR}")
    include_directories("${fastrtps_INCLUDE_DIR}")
    
    set(FastRTPS_LIBRARIES fastcdr fastrtps)
    add_custom_target(FastRTPS)
endif(STANDALONE_PLUGIN)

add_subdirectory(cppsrc/FastRTPS)
add_subdirectory(swig/FastRTPS)

if(NOT STANDALONE_PLUGIN)
    if(ament_cmake_FOUND)
        # This is a ROS2 build
        ament_export_libraries(FastRTPSWrapper)
        ament_package()
    endif()
endif()
