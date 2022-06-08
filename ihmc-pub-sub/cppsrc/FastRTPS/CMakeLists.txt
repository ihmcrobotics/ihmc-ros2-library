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

if(WIN32)
    target_link_libraries(FastRTPSNativeImpl ${FastRTPS_LIBRARIES})
else()
    target_link_libraries(FastRTPSNativeImpl ${FastRTPS_LIBRARIES} pthread rt)
endif()

add_dependencies(FastRTPSNativeImpl FastRTPS)

#set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)
