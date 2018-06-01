cmake_minimum_required(VERSION 3.1)
project(IHMCPubSub)

FIND_PACKAGE(SWIG REQUIRED)

INCLUDE(${SWIG_USE_FILE})
SET(CMAKE_SWIG_OUTDIR "${CMAKE_CURRENT_SOURCE_DIR}/generated/us/ihmc/rtps/impl/fastRTPS")

INCLUDE_DIRECTORIES("${CMAKE_CURRENT_SOURCE_DIR}/../../cppsrc/FastRTPS")


SET_SOURCE_FILES_PROPERTIES(FastRTPS.i PROPERTIES CPLUSPLUS ON)
SET_PROPERTY(SOURCE FastRTPS.i PROPERTY SWIG_FLAGS "-package" "us.ihmc.rtps.impl.fastRTPS")

SET(SWIG_OPT_LINKER_FLAGS "")

SWIG_ADD_MODULE(FastRTPSWrapper java FastRTPS.i)
ADD_DEPENDENCIES(FastRTPSWrapper FastRTPSNativeImpl)
SWIG_LINK_LIBRARIES(FastRTPSWrapper FastRTPSNativeImpl ${SWIG_OPT_LINKER_FLAGS})
INSTALL(TARGETS FastRTPSWrapper RUNTIME DESTINATION src/main/resources/us/ihmc/rtps/impl/fastRTPS LIBRARY DESTINATION src/main/resources/us/ihmc/rtps/impl/fastRTPS)
if(APPLE)
    set_target_properties(FastRTPSWrapper PROPERTIES SUFFIX ".dylib")
endif(APPLE)
