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
#include <fastrtps/rtps/history/ReaderHistory.h>

#include "fastrtpsexception.h"
#include "nativeparticipantimpl.h"
#include "commonfunctions.h"
#include "sampleinfomarshaller.h"
#include <fastrtps/rtps/reader/RTPSReader.h>
#include <fastrtps/rtps/reader/ReaderListener.h>
#include <fastrtps/rtps/history/ReaderHistory.h>
#include <mutex>
using namespace eprosima::fastrtps::rtps;

namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

    typedef std::pair<InstanceHandle_t,std::vector<CacheChange_t*>> t_p_I_Change;
    typedef std::vector<t_p_I_Change> t_v_Inst_Caches;

    class NativeSubscriberListener
    {
    public:
        virtual void onReaderMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow) {}
        virtual void onNewCacheChangeAdded() {}
        virtual bool getKey(int64_t cacheChangePtr, int16_t encoding, int32_t dataLength) { return false; }
        virtual ~NativeSubscriberListener() {}
    };


    class NativeSubscriberImpl : public ReaderHistory
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

        void registerReader(TopicAttributes* topic,
                            ReaderQos* qos) throw(FastRTPSException);

        int64_t getGuidLow()
        {
            return guidUnion.primitive.low;
        }

        int64_t getGuidHigh()
        {
            return guidUnion.primitive.high;
        }


        void lock();
        void unlock();

        int64_t readnextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);
        int64_t takeNextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);
        void getData(int64_t cacheChangePtr, int32_t maxDataLength, unsigned char* data);
        void updateKey(int64_t cacheChangePtr, unsigned char* key);
        bool received_change(CacheChange_t* a_change, size_t unknown_missing_changes_up_to);
        bool remove_change_sub(CacheChange_t* change,t_v_Inst_Caches::iterator* vit=nullptr);
        bool remove_change_sub_swig(int64_t change);
        void waitForUnreadMessage();
        bool isInCleanState();



        inline void increaseUnreadCount()
        {
            ++m_unreadCacheCount;
        }

        inline void decreaseUnreadCount()
        {
            if(m_unreadCacheCount>0)
                --m_unreadCacheCount;
        }

        inline int64_t getUnreadCount()
        {
            return m_unreadCacheCount;
        }


        virtual ~NativeSubscriberImpl();
    private:
        class SubscriberReaderListener : public ReaderListener
        {
        public:
            SubscriberReaderListener(NativeSubscriberImpl* s): subscriberImpl(s){}
            virtual ~SubscriberReaderListener(){}
            void onReaderMatched(RTPSReader* reader,MatchingInfo& info);
            void onNewCacheChangeAdded(RTPSReader * reader,const CacheChange_t* const change);
            NativeSubscriberImpl* subscriberImpl;
        }readerListener;

        uint64_t m_unreadCacheCount;
        t_v_Inst_Caches m_keyedChanges;
        HistoryQosPolicy m_historyQos;
        ResourceLimitsQosPolicy m_resourceLimitsQos;


        RTPSReader* mp_reader;
        RTPSParticipant* rtpsParticipant;
        TopicKind_t topicKind;
        HistoryQosPolicyKind historyQosKind;
        NativeSubscriberListener* listener;
        std::string topicName;


        GUID_t guid;
        GuidUnion guidUnion;

        void updateMarshaller(SampleInfoMarshaller* marshaller, CacheChange_t* change, WriterProxy* wp, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind);
        bool find_Key(CacheChange_t* a_change,t_v_Inst_Caches::iterator* vecPairIterrator);



    };
}}}}}
#endif // NATIVESUBSCRIBERIMPL_H
