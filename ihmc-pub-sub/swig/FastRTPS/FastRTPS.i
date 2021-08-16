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


namespace eprosima{
namespace fastdds{
namespace dds{
 %ignore GenericDataQosPolicy;
 %ignore UserDataQosPolicy;
 %ignore GroupDataQosPolicy;
 %ignore TopicDataQosPolicy;
}
namespace rtps{
 %ignore ParticipantType;
}

}}


// Support for RTPSParticipantAttributes
namespace eprosima{
namespace fastrtps{
    namespace rtps{
    
        // Empty declaration of RemoteLocatorList to allow getting locators using helper functions
        struct RemoteLocatorList
        {
            private:
                RemoteLocatorList();
        };
    
        %ignore LocatorList_t::begin;
        %ignore LocatorList_t::end;
        %ignore RTPSParticipantAttributes::throughputController;
        %ignore RTPSParticipantAttributes::userTransports;

        %ignore ThroughputController::mAssociatedParticipant;
        %ignore ThroughputController::mAssociatedWriter;

        %ignore Locator_t::Locator_t(const Locator_t& loc);
        %ignore LocatorList_t::LocatorList_t(const LocatorList_t& list);

        %ignore ThroughputController;
        %ignore FlowController;
        %ignore RemoteReaderAttributes::guid;
        %ignore RemoteWriterAttributes::guid;
        %ignore GUID_t;
        
        
    }
    %ignore TopicAttributes::getTopicDiscoveryKind;
    %ignore TopicAttributes::getTopicKind;
    %ignore TopicAttributes::getTopicName;
    %ignore TopicAttributes::getTopicDataType;

}}

%ignore operator=;
%ignore operator==;
%ignore operator<<;



%{
#include <fastdds/rtps/common/Locator.h>
#include <fastdds/rtps/common/LocatorList.hpp>
#include <fastdds/dds/core/policy/QosPolicies.hpp>

#include <fastrtps/rtps/common/Time_t.h>
#include <fastrtps/rtps/flowcontrol/ThroughputControllerDescriptor.h>
#include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>
#include <fastdds/rtps/attributes/ServerAttributes.h>


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

%include <fastdds/rtps/common/Locator.h>
%include <fastdds/rtps/common/LocatorList.hpp>
%include <fastrtps/rtps/attributes/RTPSParticipantAttributes.h>
%include <fastdds/rtps/attributes/RTPSParticipantAttributes.h>
%include <fastdds/rtps/attributes/ServerAttributes.h>

// Support for PublisherAttributes and SubscriberAttributes
%{
#include <fastrtps/attributes/PublisherAttributes.h>
#include <fastrtps/attributes/SubscriberAttributes.h>
%}

namespace eprosima{
namespace fastrtps{
namespace rtps{


    struct ParticipantDiscoveryInfo
    {
    
        enum DISCOVERY_STATUS
        {
            DISCOVERED_PARTICIPANT,
            CHANGED_QOS_PARTICIPANT,
            REMOVED_PARTICIPANT,
            DROPPED_PARTICIPANT
        };
        
        private:
            ParticipantDiscoveryInfo();
    };
    
    struct WriterDiscoveryInfo
    {
        enum  DISCOVERY_STATUS
        {
            DISCOVERED_WRITER,
            CHANGED_QOS_WRITER,
            REMOVED_WRITER
        };
        
        private:
            WriterDiscoveryInfo();
    };
    
    
    struct ReaderDiscoveryInfo
    {
        enum DISCOVERY_STATUS
        {
            DISCOVERED_READER,
            CHANGED_QOS_READER,
            REMOVED_READER
        };
        
        private:
            ReaderDiscoveryInfo();
    };


    //!Reliability enum used for internal purposes
    //!@ingroup COMMON_MODULE
    typedef enum ReliabilityKind_t{
        RELIABLE,
        BEST_EFFORT
    }ReliabilityKind_t;

    //!Durability kind
    //!@ingroup COMMON_MODULE
    typedef enum DurabilityKind_t
    {
        VOLATILE,
        TRANSIENT_LOCAL
    }DurabilityKind_t;

    //!Endpoint kind
    //!@ingroup COMMON_MODULE
    typedef enum EndpointKind_t{
        READER,
        WRITER
    }EndpointKind_t;

    //!Topic kind
    typedef enum TopicKind_t{
        NO_KEY,
        WITH_KEY
    }TopicKind_t;

    typedef enum TopicDiscoveryKind_t
    {
        NO_CHECK,
        MINIMAL,
        COMPLETE
    }TopicDiscoveryKind_t;

    enum ChangeKind_t{
        ALIVE,                //!< ALIVE
        NOT_ALIVE_DISPOSED,   //!< NOT_ALIVE_DISPOSED
        NOT_ALIVE_UNREGISTERED,//!< NOT_ALIVE_UNREGISTERED
        NOT_ALIVE_DISPOSED_UNREGISTERED //!<NOT_ALIVE_DISPOSED_UNREGISTERED
    };

    enum MatchingStatus{
    MATCHED_MATCHING,//!< MATCHED_MATCHING, new publisher/subscriber found
    REMOVED_MATCHING //!< REMOVED_MATCHING, publisher/subscriber removed

    };


}}}

%include <fastrtps/rtps/flowcontrol/ThroughputControllerDescriptor.h>
%include <fastdds/rtps/flowcontrol/ThroughputControllerDescriptor.h>
%include <fastrtps/qos/QosPolicies.h>
%include <fastdds/dds/core/policy/QosPolicies.hpp>


%include <fastrtps/qos/WriterQos.h>
%include <fastdds/dds/publisher/qos/WriterQos.hpp>
%include <fastrtps/qos/ReaderQos.h>
%include <fastdds/dds/subscriber/qos/ReaderQos.hpp>

%include <fastrtps/rtps/resources/ResourceManagement.h>
%include <fastdds/rtps/resources/ResourceManagement.h>
%include <fastrtps/attributes/TopicAttributes.h>
%include <fastrtps/rtps/attributes/EndpointAttributes.h>
%include <fastdds/rtps/attributes/EndpointAttributes.h>
%include <fastrtps/rtps/attributes/WriterAttributes.h>
%include <fastdds/rtps/attributes/WriterAttributes.h>
%include <fastrtps/attributes/PublisherAttributes.h>
%include <fastrtps/rtps/attributes/ReaderAttributes.h>
%include <fastdds/rtps/attributes/ReaderAttributes.h>
%include <fastrtps/attributes/SubscriberAttributes.h>


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


octet getLocatorOctet(int octet, Locator_t* locator)
{
    return locator->address[octet];
}

void setLocatorOctet(Locator_t* locator, int oct, octet value)
{
    locator->address[oct] = value;
}

Locator_t* getLocator(LocatorList_t* list, int index)
{
    if(index > list->size() || index < 0)
    {
        return nullptr;
    }
    LocatorListIterator element = list->begin() + index;
    std::advance(element, index);
    return &(*element);
}


Locator_t* getRemoteUnicastLocator(eprosima::fastrtps::rtps::RemoteLocatorList* list, int index)
{
    if(index > list->unicast.size() || index < 0)
    {
        return nullptr;
    }
    
    return &(list->unicast.at(index));
}

Locator_t* getRemoteMulticastLocator(eprosima::fastrtps::rtps::RemoteLocatorList* list, int index)
{
    if(index > list->multicast.size() || index < 0)
    {
        return nullptr;
    }
    
    return &(list->multicast.at(index));
}

int getRemoteMulticastLocatorSize(eprosima::fastrtps::rtps::RemoteLocatorList* list)
{
    return list->multicast.size();
}

int getRemoteUnicastLocatorSize(eprosima::fastrtps::rtps::RemoteLocatorList* list)
{
    return list->unicast.size();
}


using namespace us::ihmc::rtps::impl::fastRTPS;
%}

%include "sampleinfomarshaller.h"
%include "nativeparticipantimpl.h"
%include "nativepublisherimpl.h"
%include "nativesubscriberimpl.h"
%include "loglevel.h"

octet getLocatorOctet(int octet, Locator_t* locator);
void setLocatorOctet(Locator_t* locator, int oct, octet value);
Locator_t* getLocator(LocatorList_t* list, int index);
Locator_t* getRemoteUnicastLocator(eprosima::fastrtps::rtps::RemoteLocatorList* list, int index);
Locator_t* getRemoteMulticastLocator(eprosima::fastrtps::rtps::RemoteLocatorList* list, int index);
int getRemoteMulticastLocatorSize(eprosima::fastrtps::rtps::RemoteLocatorList* list);
int getRemoteUnicastLocatorSize(eprosima::fastrtps::rtps::RemoteLocatorList* list);
