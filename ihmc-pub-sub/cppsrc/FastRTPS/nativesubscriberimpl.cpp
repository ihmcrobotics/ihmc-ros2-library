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

#include "nativesubscriberimpl.h"

#include <fastrtps/Domain.h>
#include <fastrtps/subscriber/SampleInfo.h>

using namespace eprosima::fastrtps;
using namespace eprosima::fastrtps::rtps;

using namespace us::ihmc::rtps::impl::fastRTPS;


NativeSubscriberImpl::NativeSubscriberImpl(int32_t entityId,
                                           int32_t userDefinedID,
                                           int32_t maximumPayloadSize,
                                           MemoryManagementPolicy_t memoryManagementPolicy,
                                           TopicAttributes* topic,
                                           ReaderQos* qos,
                                           ReaderTimes* times,
                                           LocatorList_t* unicastLocatorList,
                                           LocatorList_t* multicastLocatorList,
                                           LocatorList_t* remoteLocatorList,
                                           bool expectsInlineQos,
                                           NativeParticipantImpl* participant,
                                           NativeSubscriberListener* listener) throw(FastRTPSException) :
    readerListener(this),
    fastrtpsParticipant(participant->getParticipant()),
    listener(listener),
    topicName(topic->getTopicName())
{

    attr.historyMemoryPolicy = memoryManagementPolicy;
    attr.qos = *qos;
    attr.multicastLocatorList = *multicastLocatorList;
    attr.topic = *topic;
    attr.unicastLocatorList = *unicastLocatorList;
    attr.remoteLocatorList = *remoteLocatorList;
    attr.expectsInlineQos = expectsInlineQos;
    if(entityId>0)
        attr.setEntityID((uint8_t)entityId);
    if(userDefinedID>0)
        attr.setUserDefinedID((uint8_t)userDefinedID);
    attr.times = *times;
}

NativeSubscriberImpl::NativeSubscriberImpl(NativeParticipantImpl *participant,
                                           NativeSubscriberListener *listener) throw(FastRTPSException) :
        fastrtpsParticipant(participant->getParticipant()),
        readerListener(this),
        listener(listener)
{}

bool NativeSubscriberImpl::createSubscriber()
{
    try
    {
        subscriber = Domain::createSubscriber(fastrtpsParticipant, attr, &readerListener);

    }
    catch(const std::exception &e)
    {
        return false;
    }

    if(subscriber == nullptr)
    {
        return false;
    }

    CommonFunctions::guidcpy(subscriber->getGuid(), &guidUnion);
    logInfo(SUBSCRIBER, "Guid: " << mp_writer->getGuid());
    return true;
}

bool NativeSubscriberImpl::createSubscriber(std::string profile)
{
    try
    {
        subscriber = Domain::createSubscriber(fastrtpsParticipant, profile, &readerListener);

    }
    catch(const std::exception &e)
    {
        return false;
    }

    if(subscriber == nullptr)
    {
        return false;
    }

    CommonFunctions::guidcpy(subscriber->getGuid(), &guidUnion);
    logInfo(SUBSCRIBER, "Guid: " << mp_writer->getGuid());
    return true;
}

bool NativeSubscriberImpl::isInCleanState()
{
    return subscriber->isInCleanState();
}

TopicKind_t NativeSubscriberImpl::getTopicKind(){
    return subscriber->getAttributes().topic.topicKind;
}

OwnershipQosPolicyKind NativeSubscriberImpl::getOwnershipQosKind() {
    return subscriber->getAttributes().qos.m_ownership.kind;
}

int64_t NativeSubscriberImpl::getUnreadCount()
{
    return subscriber->getUnreadCount();
}

void NativeSubscriberImpl::waitForUnreadMessage()
{
    subscriber->waitForUnreadMessage();
}


void NativeSubscriberImpl::updateMarshaller(SampleInfoMarshaller* marshaller, SampleInfo_t& sampleInfo, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{
    GuidUnion guid;
    CommonFunctions::guidcpy(sampleInfo.sample_identity.writer_guid(), &guid);
    marshaller->sampleIdentity_GuidHigh = guid.primitive.high;
    marshaller->sampleIdentity_GuidLow = guid.primitive.low;
    marshaller->sampleIdentity_sequenceNumberHigh = sampleInfo.sample_identity.sequence_number().high;
    marshaller->sampleIdentity_sequenceNumberLow = sampleInfo.sample_identity.sequence_number().low;
    marshaller->time_seconds = sampleInfo.sourceTimestamp.seconds();
    marshaller->time_nsec = sampleInfo.sourceTimestamp.nanosec();


    if(ownerShipQosKind == EXCLUSIVE_OWNERSHIP_QOS)
    {
        marshaller->ownershipStrength = sampleInfo.ownershipStrength;
    }
    else
    {
        marshaller->ownershipStrength = -1;
    }


    memcpy(marshaller->instanceHandle_value, sampleInfo.iHandle.value, 16);

    CommonFunctions::guidcpy(sampleInfo.related_sample_identity.writer_guid(), &guid);

    marshaller->relatedSampleIdentity_GuidHigh = guid.primitive.high;
    marshaller->relatedSampleIdentity_GuidLow = guid.primitive.low;
    SequenceNumber_t& relatedSequenceNumber = sampleInfo.related_sample_identity.sequence_number();
    marshaller->relatedSampleIdentity_sequenceNumberHigh = relatedSequenceNumber.high;
    marshaller->relatedSampleIdentity_sequenceNumberLow = relatedSequenceNumber.low;
}

bool NativeSubscriberImpl::readnextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{

    RawDataWrapper dataWrapper(data, maxDataLength);
    SampleInfo_t sampleInfo;
    if(subscriber->readNextData(&dataWrapper, &sampleInfo))
    {
        marshaller->changeKind = sampleInfo.sampleKind;

        marshaller->encapsulation = dataWrapper.encapsulation;
        marshaller->dataLength = dataWrapper.length;


        updateMarshaller(marshaller, sampleInfo, topicKind, ownerShipQosKind);
        return true;

    }
    std::cerr << "[nativesubscriberimpl.cpp] In function readnextData: Cannot read next data from subscriber" << std::endl;
    return false;
}

bool NativeSubscriberImpl::takeNextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{
    RawDataWrapper dataWrapper(data, maxDataLength);
    SampleInfo_t sampleInfo;
    if(subscriber->takeNextData(&dataWrapper, &sampleInfo))
    {
        marshaller->changeKind = sampleInfo.sampleKind;

        marshaller->encapsulation = dataWrapper.encapsulation;
        marshaller->dataLength = dataWrapper.length;


        updateMarshaller(marshaller, sampleInfo, topicKind, ownerShipQosKind);
        return true;

    }
    std::cerr << "[nativesubscriberimpl.cpp] In function takeNextData: Cannot read next data from subscriber" << std::endl;
    return false;

}


NativeSubscriberImpl::~NativeSubscriberImpl()
{
    Domain::removeSubscriber(subscriber);
}

void NativeSubscriberImpl::SubscriberReaderListener::onSubscriptionMatched(Subscriber* reader,MatchingInfo& info)
{
    logInfo(PUBLISHER, "Remote writer Guid: " << info.remoteEndpointGuid);
    GuidUnion retGuid;
    CommonFunctions::guidcpy(info.remoteEndpointGuid, &retGuid);
    subscriberImpl->listener->onSubscriptionMatched(info.status, retGuid.primitive.high, retGuid.primitive.low);
}

void NativeSubscriberImpl::SubscriberReaderListener::onNewDataMessage(Subscriber * reader)
{
    subscriberImpl->listener->onNewDataMessage();
}

