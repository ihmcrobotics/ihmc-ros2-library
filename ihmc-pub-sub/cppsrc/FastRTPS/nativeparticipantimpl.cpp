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
#include "nativeparticipantimpl.h"
#include <fastrtps/log/Log.h>

#include <fastrtps/Domain.h>
#include <fastrtps/attributes/ParticipantAttributes.h>

#include <fastrtps/rtps/builtin/data/WriterProxyData.h>
#include <fastrtps/rtps/builtin/data/ReaderProxyData.h>


using namespace us::ihmc::rtps::impl::fastRTPS;

NativeParticipantImpl::NativeParticipantImpl(RTPSParticipantAttributes& rtps, NativeParticipantListener* listener) throw(FastRTPSException) :
    listener(listener),
    m_rtps_listener(this)
{

    ParticipantAttributes attributes;
    attributes.rtps = rtps;



	try
	{
        part = Domain::createParticipant(attributes, &m_rtps_listener);
	}
	catch(const std::exception &e)
	{
		std::cerr << "[ERROR]" << e.what() << std::endl;
		throw FastRTPSException("Problem creating RTPSParticipant");
		return;
	}
	

    if(part == nullptr)
    {
        throw FastRTPSException("Problem creating RTPSParticipant");
        return;
    }

    logInfo(PARTICIPANT,"Guid: " << part->getGuid());
    CommonFunctions::guidcpy(part->getGuid(), &guid);


}

NativeParticipantImpl::~NativeParticipantImpl()
{

    Domain::removeParticipant(part);
}

int64_t NativeParticipantImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativeParticipantImpl::getGuidHigh()
{
    return guid.primitive.high;
}

Participant* NativeParticipantImpl::getParticipant()
{
    return part;
}

void NativeParticipantImpl::registerType(std::string name, int32_t maximumDataSize, bool hasKey)
{
    // This functions adds registered types to a vector of shared ptrs, so they get destroyed when this class gets destructed
    std::shared_ptr<RawTopicDataType> topicDataType = std::make_shared<RawTopicDataType>(name, maximumDataSize, hasKey);
    Domain::registerType(part, topicDataType.get());
    registeredTypes.push_back(topicDataType);
}

void NativeParticipantImpl::MyRTPSParticipantListener::onRTPSParticipantDiscovery(Participant* part, ParticipantDiscoveryInfo info)
{
    if(this->mp_participantimpl->listener!=nullptr)
    {

        RTPSParticipantDiscoveryInfo& rtpsinfo = info.rtps;

        logInfo(PARTICIPANT,"Remote participant Guid: " << rtpsinfo.m_guid);
        GuidUnion retGuid;
        CommonFunctions::guidcpy(rtpsinfo.m_guid, &retGuid);

        this->mp_participantimpl->listener->onParticipantDiscovery((int64_t)&rtpsinfo, retGuid.primitive.high, retGuid.primitive.low, rtpsinfo.m_status);
    }
}


std::string NativeParticipantListener::getName(int64_t infoPtr)
{
    return ((RTPSParticipantDiscoveryInfo*) infoPtr)->m_RTPSParticipantName;
}

void NativeParticipantImpl::registerEDPReaderListeners(NativeParticipantPublisherEDPListener *publisherListener, NativeParticipantSubscriberEDPListener *subscriberListener) throw(FastRTPSException)
{
    std::pair<StatefulReader*,StatefulReader*> EDP_Readers = this->part->getEDPReaders();
    if(EDP_Readers.first == nullptr || EDP_Readers.second == nullptr)
    {
        throw FastRTPSException("No Endpoint Discovery Protocol Readers provided, Participant is connected in static mode.");
    }

    if(publisherListener != nullptr)
    {
        EDP_Readers.second->setListener(publisherListener->getReaderListener());
    }
    if(subscriberListener != nullptr)
    {
        EDP_Readers.first->setListener(subscriberListener->getReaderListener());
    }
}

void NativeParticipantPublisherEDPListener::MyRTPSReaderListener::onNewCacheChangeAdded(RTPSReader *reader, const CacheChange_t * const change_in)
{
    CacheChange_t* change = (CacheChange_t*) change_in;
    if(change->kind == ALIVE){

        WriterProxyData proxyData;
        CDRMessage_t tempMsg;
        tempMsg.msg_endian = change->serializedPayload.encapsulation == PL_CDR_BE ? BIGEND:LITTLEEND;
        tempMsg.length = change->serializedPayload.length;
        memcpy(tempMsg.buffer,change->serializedPayload.data,tempMsg.length);
        if(proxyData.readFromCDRMessage(&tempMsg)){

            GuidUnion guid;
            CommonFunctions::guidcpy(proxyData.guid(), &guid);
            GuidUnion participantGuid;
            CommonFunctions::guidcpy(proxyData.RTPSParticipantKey(), &participantGuid);

            mp_listener->publisherTopicChange(proxyData.isAlive(), guid.primitive.high, guid.primitive.low, &proxyData.unicastLocatorList(), &proxyData.multicastLocatorList(), participantGuid.primitive.high, participantGuid.primitive.low,
                                              proxyData.typeName(), proxyData.topicName(), proxyData.userDefinedId(), proxyData.typeMaxSerialized(), proxyData.topicKind(), &proxyData.m_qos);
        }
    }
}

void NativeParticipantSubscriberEDPListener::MyRTPSReaderListener::onNewCacheChangeAdded(RTPSReader* reader, const CacheChange_t* const change_in)
{
    CacheChange_t* change = (CacheChange_t*) change_in;
    if(change->kind == ALIVE){

        ReaderProxyData proxyData;
        CDRMessage_t tempMsg;
        tempMsg.msg_endian = change->serializedPayload.encapsulation == PL_CDR_BE ? BIGEND:LITTLEEND;
        tempMsg.length = change->serializedPayload.length;
        memcpy(tempMsg.buffer,change->serializedPayload.data,tempMsg.length);
        if(proxyData.readFromCDRMessage(&tempMsg)){
            GuidUnion guid;
            CommonFunctions::guidcpy(proxyData.guid(), &guid);
            GuidUnion participantGuid;
            CommonFunctions::guidcpy(proxyData.RTPSParticipantKey(), &participantGuid);

            mp_listener->subscriberTopicChange(proxyData.isAlive(), guid.primitive.high, guid.primitive.low, proxyData.m_expectsInlineQos, &proxyData.unicastLocatorList(), &proxyData.multicastLocatorList(), participantGuid.primitive.high, participantGuid.primitive.low,
                                               proxyData.typeName(), proxyData.topicName(), proxyData.userDefinedId(), proxyData.topicKind(), &proxyData.m_qos);
        }
    }
}
