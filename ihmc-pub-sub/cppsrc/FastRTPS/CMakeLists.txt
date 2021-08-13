cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl
            nativeparticipantimpl
            nativepublisherimpl
            nativesubscriberimpl
            rawtopicdatatype
            loglevel
            ${HEADER_FILES}
)
target_link_libraries(FastRTPSNativeImpl ${FastRTPS_LIBRARIES} rt)

add_executable(PublisherExample publisherexample)
add_executable(SubscriberExample subscriberexample)

if(WIN32)
    target_link_libraries(PublisherExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} rt)
    target_link_libraries(SubscriberExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} rt)
else()
    target_link_libraries(PublisherExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread rt)
    target_link_libraries(SubscriberExample FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread rt)
endif()

add_dependencies(FastRTPSNativeImpl FastRTPS)

set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)
