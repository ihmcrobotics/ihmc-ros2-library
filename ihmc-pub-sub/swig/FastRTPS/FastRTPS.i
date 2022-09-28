/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

%module(directors="1") FastRTPS
%javaconst(1);
%include "typemaps.i"
%include "various.i"
%include "stdint.i"
%include "std_string.i"
%include "std_vector.i"
%include "carrays.i"

%array_functions(unsigned char, charArray);

%include <fastrtps/config.h>

// Disable detachedment of threads in the director. This avoids a memory leak due to spinning up a lot of Java threads
%insert("runtime") %{
#define SWIG_JAVA_NO_DETACH_CURRENT_THREAD
#define SWIG_JAVA_ATTACH_CURRENT_THREAD_AS_DAEMON
%}

%apply unsigned char *NIOBUFFER { unsigned char* };

namespace std {
    %template(octetVector) vector<unsigned char>;
    %template(stringVector) vector<std::string>;
}

%array_functions(unsigned char, octetArray)

%ignore operator=;
%ignore operator==;
%ignore operator<<;



%{
#include <fastrtps/rtps/common/Time_t.h>
%}

#define RTPS_DllAPI
namespace eprosima{
namespace fastrtps{

namespace rtps{
    typedef unsigned char octet;
}


    struct Time_t{
        int32_t seconds;
        uint32_t nanosec;
        
        Time_t();
        
        Time_t(
            int32_t sec,
            uint32_t nsec);
        
        
        
        // For supporting older code
        void fraction(uint32_t frac);
        
        %extend { 
            inline void setFraction(uint32_t value)
            {
                $self->fraction(value);
            }    
        
        }


    };
    using Duration_t = Time_t;


}}




%typemap(throws, throws="java.io.IOException") FastRTPSException {
  jclass excep = jenv->FindClass("java/io/IOException");
  if (excep)
    jenv->ThrowNew(excep, $1.what());
  return $null;
}

%feature("director") NativeParticipantListener;
%feature("director") NativePublisherListener;
%feature("director") NativeSubscriberListener;
%feature("director") NativeParticipantPublisherEDPListener;
%feature("director") NativeParticipantSubscriberEDPListener;

namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{
%ignore NativeParticipantImpl::getParticipant;
%ignore NativePublisherImpl::getGuid();
%ignore NativePublisherImpl::getTopicKind;
%ignore NativeSubscriberImpl::remove_change_sub;
%ignore NativeParticipantPublisherEDPListener::getReaderListener;
%ignore NativeParticipantSubscriberEDPListener::getReaderListener;
}}}}}
%{
#include "nativeparticipantimpl.h"
#include "nativepublisherimpl.h"
#include "nativesubscriberimpl.h"
#include "loglevel.h"
#include "sampleinfomarshaller.h"

void setRemoteServerAttributesDefaultGUIDPrefix(eprosima::fastdds::rtps::RemoteServerAttributes& attributes, int serverId)
{
    get_server_client_default_guidPrefix(serverId, attributes.guidPrefix);
}

void pushRemoteServerAttributes(eprosima::fastdds::rtps::RemoteServerList_t& list, eprosima::fastdds::rtps::RemoteServerAttributes& attributes)
{
    list.push_back(attributes);
}


using namespace us::ihmc::rtps::impl::fastRTPS;
%}

%include "sampleinfomarshaller.h"
%include "nativeparticipantimpl.h"
%include "nativepublisherimpl.h"
%include "nativesubscriberimpl.h"
%include "loglevel.h"
