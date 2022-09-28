cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/")

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


SET(CMAKE_INSTALL_RPATH "\$ORIGIN")


if(STANDALONE_PLUGIN)
    include(ExternalProject)

    if(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
        message(STATUS "Setting initial default cmake install prefix path: ${CMAKE_SOURCE_DIR}")
        set(CMAKE_INSTALL_PREFIX ${CMAKE_SOURCE_DIR} CACHE PATH "IHMC Pub Sub install prefix" FORCE)
    endif()
    message(STATUS "CMake install prefix: ${CMAKE_INSTALL_PREFIX}")
    message(STATUS "CMake current binary directory: ${CMAKE_CURRENT_BINARY_DIR}")

    
    SET(ARCH_PKG "${CMAKE_SYSTEM_NAME}/${CMAKE_SYSTEM_PROCESSOR}")
    
    SET(LIBRARY_RESOURCES_DIRECTORY "src/main/resources/us/ihmc/rtps/impl/fastRTPS/${ARCH_PKG}")
    
    

    set(FAST_RTPS_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-install")
    list( APPEND CMAKE_FIND_ROOT_PATH "${FAST_RTPS_INSTALL_PREFIX}" )
    
    ExternalProject_Add(FoonathanMemory
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/foonathan_memory_vendor/"
        DOWNLOAD_COMMAND ""
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS  
            "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
            "-DCMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}"
            "-DCMAKE_TOOLCHAIN_FILE=${CMAKE_TOOLCHAIN_FILE}"
        )
    
    if(WIN32)
    	SET(FASTRTPS_INSTALL_TARGET "install")
    else()
    	SET(FASTRTPS_INSTALL_TARGET "install/strip")
    endif()
    
    if(WIN32)
        SET(foonathan_memory_DIR "${FAST_RTPS_INSTALL_PREFIX}/share/foonathan_memory/cmake/")
    else()
        SET(foonathan_memory_DIR "${FAST_RTPS_INSTALL_PREFIX}/lib/foonathan_memory/cmake/")
    endif()

        
        
    set(FAST_RTPS_INSTALL_PREFIX "${CMAKE_CURRENT_BINARY_DIR}/thirdparty/Fast-RTPS-install")
    message(STATUS "FastRTPS install prefix: ${FAST_RTPS_INSTALL_PREFIX}")
    ExternalProject_Add(FastRTPS
        SOURCE_DIR "${PROJECT_SOURCE_DIR}/thirdparty/Fast-RTPS"
        DOWNLOAD_COMMAND ""
        #UPDATE_COMMAND "${CMAKE_COMMAND}" -E chdir "${PROJECT_SOURCE_DIR}" git submodule update --recursive --init "thirdparty/Fast-RTPS"
        UPDATE_COMMAND ""
        INSTALL_DIR "${FAST_RTPS_INSTALL_PREFIX}"
        CMAKE_GENERATOR "${CMAKE_GENERATOR}"
        CMAKE_ARGS
        "-DTHIRDPARTY=FORCE"
        "-DCMAKE_BUILD_TYPE=${CMAKE_BUILD_TYPE}"
        "-DCOMPILE_EXAMPLES=OFF"
        "-DBUILD_TESTING=OFF"
		"-DNO_TLS=ON"
		"-DSHM_TRANSPORT_DEFAULT=ON"
		"-DSTRICT_REALTIME=ON"
        "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
        "-DCMAKE_INSTALL_RPATH=${CMAKE_INSTALL_RPATH}"
        "-DCMAKE_TOOLCHAIN_FILE=${CMAKE_TOOLCHAIN_FILE}"
        "-Dfoonathan_memory_DIR=${foonathan_memory_DIR}"
        # Custom install command to install the stripped configuration on Linux, saving about 400MB
        INSTALL_COMMAND
            "${CMAKE_COMMAND}"
            --build .
            --target ${FASTRTPS_INSTALL_TARGET}
            --config $<CONFIG>
    )

    ExternalProject_Add_StepDependencies(FastRTPS build FoonathanMemory)
    link_directories("${FAST_RTPS_INSTALL_PREFIX}/lib")
    include_directories("${FAST_RTPS_INSTALL_PREFIX}/include")
    
    # Enable dynamic linking for building FastRTPS. If this is not set, the defaultlib for the windows compilation is prefixed by lib and the build fails. 
	add_compile_definitions("FASTRTPS_DYN_LINK")
    
    
    
    ### UPDATE FASTDDS VERSIONS HERE ### 
    if(WIN32)
    	# Automatic linking is already enabled for FastRTPS
        set(FastRTPS_LIBRARIES)
        
        
    	FILE(GLOB FASTRTPS_DEPENDENCY_LIBRARIES "${FAST_RTPS_INSTALL_PREFIX}/bin/*.dll")
        INSTALL(FILES ${FASTRTPS_DEPENDENCY_LIBRARIES}
              DESTINATION ${LIBRARY_RESOURCES_DIRECTORY})

        
    else()
        set(FastRTPS_LIBRARIES fastrtps fastcdr)
        
        
        # Annoying rename for the install here, because of the version suffix
        INSTALL(FILES "${FAST_RTPS_INSTALL_PREFIX}/lib/libfastrtps.so.2.6.0"
              DESTINATION ${LIBRARY_RESOURCES_DIRECTORY} RENAME "libfastrtps.so.2.6")
            
        INSTALL(FILES "${FAST_RTPS_INSTALL_PREFIX}/lib/libfastcdr.so.1.0.24"
              DESTINATION ${LIBRARY_RESOURCES_DIRECTORY} RENAME "libfastcdr.so.1")
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
