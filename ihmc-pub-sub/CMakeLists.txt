cmake_minimum_required(VERSION 3.1)
project(IHMCPubSub)

set(CMAKE_MODULE_PATH ${CMAKE_MODULE_PATH} "${CMAKE_SOURCE_DIR}/cmake/Modules/")
set(CMAKE_BUILD_TYPE Release)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

if(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)
  set(CMAKE_INSTALL_PREFIX
    ${CMAKE_SOURCE_DIR} CACHE PATH "IHMC Pub Sub install prefix" FORCE
    )
endif(CMAKE_INSTALL_PREFIX_INITIALIZED_TO_DEFAULT)

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

SET(LIBRARY_RESOURCES_DIRECTORY "src/main/resources/us/ihmc/rtps/impl/fastRTPS")


if(APPLE)
    set(CMAKE_INSTALL_RPATH "@rpath")
elseif(UNIX)
    set(CMAKE_INSTALL_RPATH "\$ORIGIN")
endif()


include(ExternalProject)
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
    "-DBUILD_SHARED_LIBS=ON"
    "-DBUILD_TESTING=OFF"
    "-DTHIRDPARTY=ON"
    "-DTHIRDPARTY_fastcdr=ON"
    "-DTINYXML2_FROM_SOURCE=ON"
    "-DNO_TLS=ON"
    "-DCMAKE_INSTALL_PREFIX=${FAST_RTPS_INSTALL_PREFIX}"
    "-DCMAKE_POSITION_INDEPENDENT_CODE=true"
    "-Dfoonathan_memory_DIR=${FOONATHAN_INSTALL_PREFIX}/lib/foonathan_memory/cmake/"
    "-DCMAKE_INSTALL_RPATH=${CMAKE_INSTALL_RPATH}"
)
ExternalProject_Add_StepDependencies(FastRTPS build FoonathanMemory)

link_directories("${FAST_RTPS_INSTALL_PREFIX}/lib" "${FOONATHAN_INSTALL_PREFIX}/lib")
include_directories("${FAST_RTPS_INSTALL_PREFIX}/include")
if(WIN32)
	set(FastRTPS_LIBRARIES libfastrtps-1.9 Iphlpapi Shlwapi)
else()
	set(FastRTPS_LIBRARIES fastrtps)
endif()



if(WIN32)
    

elseif(APPLE)

else()

    # Use configure_file instead of install(FILE ...) or FILE(copy ...) to avoid copying the symlink but copy the data itself
    install(CODE "configure_file(\"${FAST_RTPS_INSTALL_PREFIX}/lib/libfastcdr.so.1\" \"${CMAKE_INSTALL_PREFIX}/${LIBRARY_RESOURCES_DIRECTORY}/libfastcdr.so.1\" COPYONLY)")
    install(CODE "configure_file(\"${FAST_RTPS_INSTALL_PREFIX}/lib/libfastrtps.so.1\" \"${CMAKE_INSTALL_PREFIX}/${LIBRARY_RESOURCES_DIRECTORY}/libfastrtps.so.1\" COPYONLY)")
    
endif()



add_subdirectory(cppsrc/FastRTPS)
add_subdirectory(swig/FastRTPS)
