// Copyright 2017 Florida Institute for Human and Machine Cognition
// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

#ifndef NATIVESUBSCRIBERIMPL_H
#define NATIVESUBSCRIBERIMPL_H

#include <fastrtps/attributes/SubscriberAttributes.h>
#include <fastrtps/subscriber/Subscriber.h>
#include <fastrtps/subscriber/SubscriberListener.h>

#include "fastrtpsexception.h"
#include "nativeparticipantimpl.h"
#include "commonfunctions.h"
#include "sampleinfomarshaller.h"



namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

    class NativeSubscriberListener
    {
    public:
        virtual void onSubscriptionMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow) {}
        virtual void onNewDataMessage() {}
        virtual ~NativeSubscriberListener() {}
    };


    class NativeSubscriberImpl
    {
    public:
        NativeSubscriberImpl(
                int32_t entityId,
                int32_t userDefinedID,
                int32_t maximumPayloadSize,
                MemoryManagementPolicy_t memoryManagementPolicy,
                TopicAttributes* topic,
                ReaderQos* qos,
                ReaderTimes* times,
                LocatorList_t* unicastLocatorList,
                LocatorList_t* multicastLocatorList,
                LocatorList_t* outLocatorList,
                bool expectsInlineQos,
                NativeParticipantImpl* participant,
                NativeSubscriberListener* listener) throw(FastRTPSException);


        bool createSubscriber();

        int64_t getGuidLow()
        {
            return guidUnion.primitive.low;
        }

        int64_t getGuidHigh()
        {
            return guidUnion.primitive.high;
        }


        void waitForUnreadMessage();

        bool readnextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);
        bool takeNextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);

        bool isInCleanState();
        int64_t getUnreadCount();


        virtual ~NativeSubscriberImpl();
    private:
        class SubscriberReaderListener : public SubscriberListener
        {
        public:
            SubscriberReaderListener(NativeSubscriberImpl* s): subscriberImpl(s){}
            virtual ~SubscriberReaderListener(){}
            void onSubscriptionMatched(Subscriber* subscriber,MatchingInfo& info);
            void onNewDataMessage(Subscriber* subscriber);
            NativeSubscriberImpl* subscriberImpl;
        }readerListener;

        Participant* fastrtpsParticipant;

        NativeSubscriberListener* listener;
        std::string topicName;

        Subscriber* subscriber;

        GUID_t guid;
        GuidUnion guidUnion;
        SubscriberAttributes attr;


        void updateMarshaller(SampleInfoMarshaller* marshaller, SampleInfo_t& sampleInfo, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);

    };
}}}}}
#endif // NATIVESUBSCRIBERIMPL_H
