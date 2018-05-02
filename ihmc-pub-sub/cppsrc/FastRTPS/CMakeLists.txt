cmake_minimum_required(VERSION 3.1)
project(IHMCPubSub)

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl nativeparticipantimpl nativepublisherimpl nativesubscriberimpl rawtopicdatatype loglevel ${HEADER_FILES})
target_link_libraries(FastRTPSNativeImpl ${FastRTPS_LIBRARIES})

add_executable(PublisherExample publisherexample)
target_link_libraries(PublisherExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread)

add_dependencies(FastRTPSNativeImpl FastRTPS)

set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)

