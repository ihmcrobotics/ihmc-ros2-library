cmake_minimum_required(VERSION 3.5)
project(ihmc-pub-sub)

if(WIN32)
# Somehow a wrong library gets dragged in (libfastrtps2.5.lib, which does not exist). Not sure where it comes from, just ignore it
	set (CMAKE_SHARED_LINKER_FLAGS "/verbose /nodefaultlib")
endif()

set(HEADER_FILES commonfunctions.h fastrtpsexception.h sampleinfomarshaller.h)
add_library(FastRTPSNativeImpl SHARED
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

#add_dependencies(FastRTPSNativeImpl FastRTPS)

#set_property(TARGET FastRTPSNativeImpl PROPERTY POSITION_INDEPENDENT_CODE TRUE)
