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
#ifndef NATIVEPUBLISHERIMPL_H
#define NATIVEPUBLISHERIMPL_H

#include <fastrtps/attributes/PublisherAttributes.h>
#include "fastrtpsexception.h"
#include "nativeparticipantimpl.h"
#include "publisherhistory.h"
#include "commonfunctions.h"

#include <fastrtps/rtps/writer/RTPSWriter.h>
#include <fastrtps/rtps/writer/WriterListener.h>

using namespace eprosima::fastrtps;
using namespace eprosima::fastrtps::rtps;


namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

    class NativePublisherListener
    {
    public:
        virtual void onWriterMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow) {}
        virtual ~NativePublisherListener() {}
    };

    class NativePublisherImpl
    {
    public:
        NativePublisherImpl(
                int32_t entityId,
                int32_t userDefinedID,
                int32_t maximumPayloadSize,
                MemoryManagementPolicy_t memoryManagementPolicy,
                TopicAttributes* topic,
                WriterQos* qos,
                WriterTimes* times,
                LocatorList_t* unicastLocatorList,
                LocatorList_t* multicastLocatorList,
                LocatorList_t* outLocatorList,
                ThroughputControllerDescriptor* throughputController,
                NativeParticipantImpl* participant,
                NativePublisherListener* listener) throw(FastRTPSException);
        void registerWriter(TopicAttributes* topic,
                            WriterQos* qos) throw(FastRTPSException);
        virtual ~NativePublisherImpl();

        void create_new_change(ChangeKind_t changeKind, unsigned char* data, int32_t dataLength, int16_t encapsulation, octet* key) throw(FastRTPSException);
        TopicKind_t getTopicKind();
        const GUID_t& getGuid();
        bool clean_history(unsigned int max);
        int32_t removeAllChange();
        bool wait_for_all_acked(const Time_t& max_wait);
        int64_t getGuidLow();
        int64_t getGuidHigh();

    private:
        RTPSWriter* mp_writer;

        ThroughputControllerDescriptor* throughputController;
        RTPSParticipant* rtpsParticipant;
        class PublisherWriterListener: public WriterListener
        {
            public:
                PublisherWriterListener(NativePublisherImpl* p):publisherImpl(p){}
                virtual ~PublisherWriterListener(){}
                void onWriterMatched(RTPSWriter* writer,MatchingInfo& info);
                NativePublisherImpl* publisherImpl;
        }writerListener;


        NativePublisherHistory publisherhistory;

        TopicKind_t topicKind;
        PublishModeQosPolicyKind publishModeKind;
        HistoryQosPolicyKind historyQosKind;

        uint32_t high_mark_for_frag_;
        NativePublisherListener* listener;

        GuidUnion guid;
    };
}}}}}
#endif // NATIVEPUBLISHERIMPL_H
