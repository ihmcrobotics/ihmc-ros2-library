cmake_minimum_required(VERSION 3.1)
project(IHMCPubSub)

find_package(SWIG REQUIRED)

include(${SWIG_USE_FILE})
set(CMAKE_SWIG_OUTDIR "${CMAKE_CURRENT_SOURCE_DIR}/generated/us/ihmc/rtps/impl/fastRTPS")

include_directories("${CMAKE_CURRENT_SOURCE_DIR}/../../cppsrc/FastRTPS")

set_source_files_properties(FastRTPS.i PROPERTIES CPLUSPLUS ON)
set_property(SOURCE FastRTPS.i PROPERTY SWIG_FLAGS "-package" "us.ihmc.rtps.impl.fastRTPS")

set(SWIG_OPT_LINKER_FLAGS "")

swig_add_module(FastRTPSWrapper java FastRTPS.i)
add_dependencies(FastRTPSWrapper FastRTPSNativeImpl)
swig_link_libraries(FastRTPSWrapper FastRTPSNativeImpl ${SWIG_OPT_LINKER_FLAGS})
install(TARGETS FastRTPSWrapper RUNTIME DESTINATION src/main/resources/us/ihmc/rtps/impl/fastRTPS LIBRARY DESTINATION src/main/resources/us/ihmc/rtps/impl/fastRTPS)
if(APPLE)
    set_target_properties(FastRTPSWrapper PROPERTIES SUFFIX ".dylib")
endif(APPLE)
