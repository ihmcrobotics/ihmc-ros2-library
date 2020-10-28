cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

find_package(SWIG REQUIRED)

include(${SWIG_USE_FILE})
set(CMAKE_SWIG_OUTDIR "${CMAKE_CURRENT_SOURCE_DIR}/generated/us/ihmc/rtps/impl/fastRTPS")

include_directories("${CMAKE_CURRENT_SOURCE_DIR}/../../cppsrc/FastRTPS")

set_source_files_properties(FastRTPS.i PROPERTIES CPLUSPLUS ON)
set_property(SOURCE FastRTPS.i PROPERTY SWIG_FLAGS "-package" "us.ihmc.rtps.impl.fastRTPS")

set(SWIG_OPT_LINKER_FLAGS "")

swig_add_module(FastRTPSWrapper java FastRTPS.i)
add_dependencies(FastRTPSWrapper FastRTPSNativeImpl JDK)
swig_link_libraries(FastRTPSWrapper FastRTPSNativeImpl ${SWIG_OPT_LINKER_FLAGS})

if(STANDALONE_PLUGIN)
    # Install in classpath
    install(TARGETS FastRTPSWrapper RUNTIME DESTINATION ${LIBRARY_RESOURCES_DIRECTORY} LIBRARY DESTINATION ${LIBRARY_RESOURCES_DIRECTORY})
else()
    # Install in library
    install(TARGETS FastRTPSWrapper RUNTIME DESTINATION bin LIBRARY DESTINATION lib)
endif()
