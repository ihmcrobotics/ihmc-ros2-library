cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl OBJECT
            nativeparticipantimpl
            nativepublisherimpl
            nativesubscriberimpl
            rawtopicdatatype
            loglevel
            ${HEADER_FILES}
)

add_dependencies(FastRTPSNativeImpl FastRTPS)

set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE 1)


