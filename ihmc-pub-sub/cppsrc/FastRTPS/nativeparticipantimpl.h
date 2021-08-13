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
#ifndef NATIVEPARTICIPANTIMPL_H
#define NATIVEPARTICIPANTIMPL_H

#include <memory>
#include <vector>


#include <fastrtps/attributes/ParticipantAttributes.h>

#include <fastrtps/participant/Participant.h>
#include <fastrtps/participant/ParticipantListener.h>
#include <fastrtps/qos/WriterQos.h>
#include <fastrtps/qos/ReaderQos.h>

#include <fastrtps/rtps/reader/ReaderListener.h>


#include "rawtopicdatatype.h"

#include "fastrtpsexception.h"
#include "commonfunctions.h"


using namespace eprosima::fastrtps;
using namespace eprosima::fastrtps::rtps;

namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

    class NativeParticipantListener
    {
    public:
        virtual void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, ParticipantDiscoveryInfo::DISCOVERY_STATUS status) {}

        virtual void onPublisherDiscovery(WriterDiscoveryInfo::DISCOVERY_STATUS discovery_status, int64_t guidHigh, int64_t guidLow, const RemoteLocatorList* remoteLocatorList, int64_t participantGuidHigh, int64_t participantGuidLow,
                                          std::string typeName, std::string topicName, int32_t userDefinedId, int64_t typeMaxSerialized,  TopicKind_t topicKind, const WriterQos* writerQoS) {}

        virtual void onSubscriberDiscovery(ReaderDiscoveryInfo::DISCOVERY_STATUS discovery_status, int64_t guidHigh, int64_t guidLow, bool expectsInlineQos, const RemoteLocatorList* remoteLocatorList, int64_t participantGuidHigh, int64_t participantGuidLow,
                                           std::string typeName, std::string topicName, int32_t userDefinedId, TopicKind_t topicKind, const ReaderQos* readerQoS) {}


        std::string getName(int64_t infoPtr);
        virtual ~NativeParticipantListener() {}
    };


    class NativeParticipantImpl
    {
    public:
        NativeParticipantImpl(int domainId, RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException);
        int64_t getGuidLow();
        int64_t getGuidHigh();
        Participant* getParticipant();
        void registerType(std::string name, int32_t maximumDataSize, bool hasKey);
        virtual ~NativeParticipantImpl();

    private:
        Participant* part;
        NativeParticipantListener* listener;
        GuidUnion guid;
        std::vector<std::shared_ptr<RawTopicDataType>> registeredTypes;

        class MyParticipantListener : public eprosima::fastrtps::ParticipantListener
        {
            public:
                MyParticipantListener(NativeParticipantImpl* impl): mp_participantimpl(impl){}
                virtual ~MyParticipantListener(){}

                void onParticipantDiscovery(Participant* participant, eprosima::fastrtps::rtps::ParticipantDiscoveryInfo&& info) override;

                void onSubscriberDiscovery(
                        eprosima::fastrtps::Participant * participant,
                        eprosima::fastrtps::rtps::ReaderDiscoveryInfo && info) override;

                void onPublisherDiscovery(
                        eprosima::fastrtps::Participant * participant,
                        eprosima::fastrtps::rtps::WriterDiscoveryInfo  && info) override;

                NativeParticipantImpl* mp_participantimpl;
        } m_rtps_listener;



    };

}}}}}
#endif // NATIVEPARTICIPANTIMPL_H
