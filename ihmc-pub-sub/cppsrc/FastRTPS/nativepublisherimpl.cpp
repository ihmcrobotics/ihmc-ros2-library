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
#include "nativepublisherimpl.h"
#include "rawtopicdatatype.h"

using namespace eprosima::fastrtps::rtps;
using namespace us::ihmc::rtps::impl::fastRTPS;

NativePublisherImpl::NativePublisherImpl(
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
        NativePublisherListener* listener) throw(FastRTPSException) :
        fastrtpsParticipant(participant->getParticipant()),
        publisherListener(this),
        listener(listener)
{



    attr.throughputController = *throughputController;
    attr.qos = *qos;
    attr.multicastLocatorList = *multicastLocatorList;
    attr.unicastLocatorList = *unicastLocatorList;
    attr.outLocatorList = *outLocatorList;
    attr.topic = *topic;
    attr.historyMemoryPolicy = memoryManagementPolicy;
    if(entityId>0)
        attr.setEntityID((uint8_t)entityId);
    if(userDefinedID>0)
        attr.setUserDefinedID((uint8_t)userDefinedID);

    attr.times = *times;

}



NativePublisherImpl::~NativePublisherImpl()
{
    Domain::removePublisher(publisher);
}

bool NativePublisherImpl::createPublisher()
{
    try
    {
        publisher = Domain::createPublisher(fastrtpsParticipant, attr, &publisherListener);
    }
    catch(const std::exception &e)
    {
        return false;
    }


    if(publisher == nullptr)
    {
        return false;
    }

    CommonFunctions::guidcpy(publisher->getGuid(), &guid);

    logInfo(PUBLISHER, "Guid: " << publisher->getGuid());
    return true;

}

void NativePublisherImpl::write(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char* key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);
    if(!publisher->write(&dataWrapper))
    {
        std::cerr << "[nativepublisherimpl.cpp] In function write(): Cannot write data" << std::endl;
    }
}

void NativePublisherImpl::dispose(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char* key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);
    if(!publisher->dispose(&dataWrapper))
    {
        std::cerr << "[nativepublisherimpl.cpp] In function dispose(): Cannot dispose data" << std::endl;
    }

}

void NativePublisherImpl::unregister(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char *key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);
    if(!publisher->unregister(&dataWrapper))
    {
        std::cerr << "[nativepublisherimpl.cpp] In function unregister(): Cannot unregister data" << std::endl;

    }
}

void NativePublisherImpl::dispose_and_unregister(unsigned char *data, int32_t dataLength, int16_t encapsulation, unsigned char *key, int32_t keyLength)
{
    RawDataWrapper dataWrapper(data, dataLength, (uint16_t)encapsulation, key, keyLength);
    if(!publisher->dispose_and_unregister(&dataWrapper))
    {
        std::cerr << "[nativepublisherimpl.cpp] In function dispose_and_unregister(): Cannot dispose_and_unregister data" << std::endl;
    }
}

int32_t NativePublisherImpl::removeAllChange()
{
    size_t retVal;
    if(publisher->removeAllChange(&retVal))
    {
        return retVal;
    }
    else
    {
        return -1;
    }
}

bool NativePublisherImpl::wait_for_all_acked(const Time_t &max_wait)
{
    return publisher->wait_for_all_acked(max_wait);
}

int64_t NativePublisherImpl::getGuidLow()
{
    return guid.primitive.low;
}

int64_t NativePublisherImpl::getGuidHigh()
{
    return guid.primitive.high;
}

const GUID_t& NativePublisherImpl::getGuid()
{
    return publisher->getGuid();
}

void NativePublisherImpl::PublisherWriterListener::onPublicationMatched(Publisher *publisher, MatchingInfo &info)
{
    logInfo(PUBLISHER, "Remote reader Guid: " << info.remoteEndpointGuid);
    GuidUnion retGuid;
    CommonFunctions::guidcpy(info.remoteEndpointGuid, &retGuid);
    publisherImpl->listener->onWriterMatched(info.status, retGuid.primitive.high, retGuid.primitive.low);
}
