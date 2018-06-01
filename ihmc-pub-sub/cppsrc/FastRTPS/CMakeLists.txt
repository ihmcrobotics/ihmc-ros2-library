cmake_minimum_required(VERSION 3.1)
project(IHMCPubSub)

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl nativeparticipantimpl nativepublisherimpl nativesubscriberimpl rawtopicdatatype loglevel ${HEADER_FILES})
target_link_libraries(FastRTPSNativeImpl ${FastRTPS_LIBRARIES})

add_executable(PublisherExample publisherexample)


add_executable(SubscriberExample subscriberexample)

if(WIN32)
target_link_libraries(PublisherExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES})
target_link_libraries(SubscriberExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES})

else()
target_link_libraries(PublisherExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread)
target_link_libraries(SubscriberExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread)
endif()

add_dependencies(FastRTPSNativeImpl FastRTPS)

set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)

