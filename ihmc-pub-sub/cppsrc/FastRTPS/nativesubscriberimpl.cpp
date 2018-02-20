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
#include <fastrtps/rtps/reader/WriterProxy.h>

using namespace us::ihmc::rtps::impl::fastRTPS;

inline bool sort_ReaderHistoryCache(CacheChange_t*c1,CacheChange_t*c2)
{
    return c1->sequenceNumber < c2->sequenceNumber;
}

NativeSubscriberImpl::NativeSubscriberImpl(int32_t entityId,
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
                                           NativeSubscriberListener* listener) throw(FastRTPSException) :
    ReaderHistory(HistoryAttributes(memoryManagementPolicy, maximumPayloadSize,topic->resourceLimitsQos.allocated_samples,topic->resourceLimitsQos.max_samples)),
    readerListener(this),
    m_unreadCacheCount(0),
    m_historyQos(topic->historyQos),
    m_resourceLimitsQos(topic->resourceLimitsQos),
    rtpsParticipant(participant->getParticipant()),
    topicKind(topic->topicKind),
    historyQosKind(topic->historyQos.kind),
    listener(listener),
    topicName(topic->getTopicName())
{
    ReaderAttributes ratt;
    ratt.endpoint.durabilityKind = qos->m_durability.kind == VOLATILE_DURABILITY_QOS ? VOLATILE : TRANSIENT_LOCAL;
    ratt.endpoint.endpointKind = READER;
    ratt.endpoint.multicastLocatorList = *multicastLocatorList;
    ratt.endpoint.reliabilityKind = qos->m_reliability.kind == RELIABLE_RELIABILITY_QOS ? RELIABLE : BEST_EFFORT;
    ratt.endpoint.topicKind = topic->topicKind;
    ratt.endpoint.unicastLocatorList = *unicastLocatorList;
    ratt.endpoint.outLocatorList = *outLocatorList;
    ratt.expectsInlineQos = expectsInlineQos;
    if(entityId>0)
        ratt.endpoint.setEntityID((uint8_t)entityId);
    if(userDefinedID>0)
        ratt.endpoint.setUserDefinedID((uint8_t)userDefinedID);
    ratt.times = *times;

    mp_reader = RTPSDomain::createRTPSReader(participant->getParticipant(),
            ratt,
            (ReaderHistory*)this,
            (ReaderListener*)&readerListener);
    if(mp_reader == nullptr)
    {
        throw FastRTPSException("Problem creating associated reader");
    }


    CommonFunctions::guidcpy(mp_reader->getGuid(), &guidUnion);
    logInfo(SUBSCRIBER, "Guid: " << mp_writer->getGuid());



}

void NativeSubscriberImpl::registerReader(TopicAttributes *topic, ReaderQos *qos) throw(FastRTPSException)
{
    //REGISTER THE READER
    rtpsParticipant->registerReader(mp_reader,*topic,*qos);
}

bool NativeSubscriberImpl::isInCleanState()
{
    return mp_reader->isInCleanState();
}

void NativeSubscriberImpl::waitForUnreadMessage()
{
    if(getUnreadCount()==0)
    {
        do
        {
            waitSemaphore();
        }
        while(getUnreadCount() == 0);
    }
}


void NativeSubscriberImpl::updateMarshaller(SampleInfoMarshaller* marshaller, CacheChange_t* change, WriterProxy* wp, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{
    GuidUnion guid;
    CommonFunctions::guidcpy(change->writerGUID, &guid);
    marshaller->sampleIdentity_GuidHigh = guid.primitive.high;
    marshaller->sampleIdentity_GuidLow = guid.primitive.low;
    marshaller->sampleIdentity_sequenceNumberHigh = change->sequenceNumber.high;
    marshaller->sampleIdentity_sequenceNumberLow = change->sequenceNumber.low;
    marshaller->time_seconds = change->sourceTimestamp.seconds;
    marshaller->time_fraction = change->sourceTimestamp.fraction;


    if(ownerShipQosKind == EXCLUSIVE_OWNERSHIP_QOS)
    {
        marshaller->ownershipStrength = wp->m_att.ownershipStrength;
    }
    else
    {
        marshaller->ownershipStrength = -1;
    }

    memcpy(marshaller->instanceHandle_value, change->instanceHandle.value, 16);
    if(topicKind == WITH_KEY &&
            change->instanceHandle == c_InstanceHandle_Unknown &&
            change->kind == ALIVE)
    {
        marshaller->updateKey = true;
    }
    else
    {
        marshaller->updateKey = false;
    }


    SampleIdentity& relatedSampleIdentity = change->write_params.sample_identity();
    CommonFunctions::guidcpy(relatedSampleIdentity.writer_guid(), &guid);
    marshaller->relatedSampleIdentity_GuidHigh = guid.primitive.high;
    marshaller->relatedSampleIdentity_GuidLow = guid.primitive.low;
    SequenceNumber_t& relatedSequenceNumber = relatedSampleIdentity.sequence_number();
    marshaller->relatedSampleIdentity_sequenceNumberHigh = relatedSequenceNumber.high;
    marshaller->relatedSampleIdentity_sequenceNumberLow = relatedSequenceNumber.low;
}

int64_t NativeSubscriberImpl::readnextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{
    CacheChange_t* change;
    WriterProxy * wp;

    if(this->mp_reader->nextUnreadCache(&change,&wp))
    {
        change->isRead = true;
        decreaseUnreadCount();

        marshaller->changeKind = (int32_t) change->kind;

        if(change->kind == ALIVE)
        {
            size_t length = change->serializedPayload.length;
            if(length > maxDataLength)
            {
                length = maxDataLength;
            }
            marshaller->encapsulation = change->serializedPayload.encapsulation;
            marshaller->dataLength = change->serializedPayload.length;
            memcpy(data, change->serializedPayload.data, length);
        }

        updateMarshaller(marshaller, change, wp, topicKind, ownerShipQosKind);


        return (int64_t) change;
    }
    return 0;
}

int64_t NativeSubscriberImpl::takeNextData(int32_t maxDataLength, unsigned char* data, SampleInfoMarshaller* marshaller, TopicKind_t topicKind, OwnershipQosPolicyKind ownerShipQosKind)
{
    CacheChange_t* change;
    WriterProxy * wp;


    if(this->mp_reader->nextUntakenCache(&change,&wp))
    {
        if(!change->isRead)
        {
            decreaseUnreadCount();
        }
        change->isRead = true;

        marshaller->changeKind = (int32_t) change->kind;

        if(change->kind == ALIVE)
        {
            marshaller->encapsulation = change->serializedPayload.encapsulation;
            marshaller->dataLength = change->serializedPayload.length;

            size_t length = change->serializedPayload.length;
            if(length > maxDataLength)
            {
                length = maxDataLength;
            }
            memcpy(data, change->serializedPayload.data, length);
        }

        updateMarshaller(marshaller, change, wp, topicKind, ownerShipQosKind);

        return (int64_t) change;
    }
}

void NativeSubscriberImpl::lock()
{
    mp_mutex->lock();
}
void NativeSubscriberImpl::unlock()
{
    mp_mutex->unlock();
}

void NativeSubscriberImpl::updateKey(int64_t cacheChangePtr, unsigned char *key)
{
    CacheChange_t* change = (CacheChange_t*) cacheChangePtr;
    memcpy(change->instanceHandle.value, key, 16);
}

void NativeSubscriberImpl::getData(int64_t cacheChangePtr, int32_t maxDataLength, unsigned char *data)
{
    CacheChange_t* change = (CacheChange_t*) cacheChangePtr;

    size_t length = change->serializedPayload.length;
    if(length > maxDataLength)
    {
        length = maxDataLength;
    }
    memcpy(data, change->serializedPayload.data, change->serializedPayload.length);
}

bool NativeSubscriberImpl::received_change(CacheChange_t* a_change, size_t unknown_missing_changes_up_to)
{

    if(mp_reader == nullptr)
    {
        logError(RTPS_HISTORY,"You need to create a Reader with this History before using it");
        return false;
    }

    std::lock_guard<std::recursive_mutex> guard(*mp_mutex);

    //NO KEY HISTORY
    if(topicKind == NO_KEY)
    {
        bool add = false;
        if(m_historyQos.kind == KEEP_ALL_HISTORY_QOS)
        {
                    if(m_changes.size() + unknown_missing_changes_up_to < (size_t)m_resourceLimitsQos.max_samples)
                        add = true;
        }
        else if(m_historyQos.kind == KEEP_LAST_HISTORY_QOS)
        {
            if(m_changes.size()<(size_t)m_historyQos.depth)
            {
                add = true;
            }
            else
            {
                        // Try to substitude a older samples.
                        auto older_sample = m_changes.rend();
                        for(auto it = m_changes.rbegin(); it != m_changes.rend(); ++it)
                        {

                                if((*it)->writerGUID == a_change->writerGUID)
                                {
                                    if((*it)->sequenceNumber < a_change->sequenceNumber)
                                        older_sample = it;
                                    // Already received
                                    else if((*it)->sequenceNumber == a_change->sequenceNumber)
                                        return false;
                                }
                        }

                    if(older_sample != m_changes.rend())
                    {
                            bool read = (*older_sample)->isRead;

                            if(this->remove_change_sub(*older_sample))
                            {
                                if(!read)
                                {
                                        this->decreaseUnreadCount();
                                }
                                add = true;
                            }
                    }
                    // Not discard, but not store and set as received.
                    else
                            return true;
            }
        }

        if(add)
        {
                    if(m_isHistoryFull)
                    {
                        // Discarting the sample.
                        logWarning(SUBSCRIBER,"Attempting to add Data to Full ReaderHistory: "<<this->guid.entityId);
                        return false;
                    }

            if(this->add_change(a_change))
            {
                increaseUnreadCount();
                if(a_change->sequenceNumber < mp_maxSeqCacheChange->sequenceNumber)
                    sortCacheChanges();
                updateMaxMinSeqNum();
                if((int32_t)m_changes.size()==m_resourceLimitsQos.max_samples)
                    m_isHistoryFull = true;
                logInfo(SUBSCRIBER,this->guid.entityId
                        <<": Change "<< a_change->sequenceNumber << " added from: "
                        << a_change->writerGUID;);
                //print_changes_seqNum();
                return true;
            }
        }
    }
    //HISTORY WITH KEY
    else if(topicKind == WITH_KEY)
    {
        if(!a_change->instanceHandle.isDefined())
        {
            logInfo(RTPS_HISTORY,"Getting Key of change with no Key transmitted")
            if(!listener->getKey((int64_t) a_change, a_change->serializedPayload.encapsulation, a_change->serializedPayload.length))
            {
                return false;
            }

        }
        else if(!a_change->instanceHandle.isDefined())
        {
            logWarning(RTPS_HISTORY,"NO KEY in topic: "<< this->topicName
                    << " and no method to obtain it";);
            return false;
        }
        t_v_Inst_Caches::iterator vit;
        if(find_Key(a_change,&vit))
        {
            //logInfo(RTPS_EDP,"Trying to add change with KEY: "<< vit->first << endl;);
            bool add = false;
            if(m_historyQos.kind == KEEP_ALL_HISTORY_QOS)
            {
                if((int32_t)vit->second.size() < m_resourceLimitsQos.max_samples_per_instance)
                {
                    add = true;
                }
                else
                {
                    logWarning(SUBSCRIBER,"Change not added due to maximum number of samples per instance";);
                    return false;
                }
            }
            else if (m_historyQos.kind == KEEP_LAST_HISTORY_QOS)
            {
                if(vit->second.size()< (size_t)m_historyQos.depth)
                {
                    add = true;
                }
                else
                {
                    // Try to substitude a older samples.
                    auto older_sample = m_changes.rend();
                    for(auto it = m_changes.rbegin(); it != m_changes.rend(); ++it)
                    {

                        if((*it)->writerGUID == a_change->writerGUID)
                        {
                            if((*it)->sequenceNumber < a_change->sequenceNumber)
                                older_sample = it;
                            // Already received
                            else if((*it)->sequenceNumber == a_change->sequenceNumber)
                                return false;
                        }
                    }

                    if(older_sample != m_changes.rend())
                    {
                        bool read = (*older_sample)->isRead;

                        if(this->remove_change_sub(*older_sample, &vit))
                        {
                            if(!read)
                            {
                                this->decreaseUnreadCount();
                            }
                            add = true;
                        }
                    }
                    // Not discard, but not store and set as received.
                    else
                        return true;
                }
            }

            if(add)
            {
                if(m_isHistoryFull)
                {
                    // Discarting the sample.
                    logWarning(SUBSCRIBER,"Attempting to add Data to Full ReaderHistory: "<<this->guid.entityId);
                    return false;
                }

                if(this->add_change(a_change))
                {
                    increaseUnreadCount();
                    if(a_change->sequenceNumber < mp_maxSeqCacheChange->sequenceNumber)
                        sortCacheChanges();
                    updateMaxMinSeqNum();
                    if((int32_t)m_changes.size()==m_resourceLimitsQos.max_samples)
                        m_isHistoryFull = true;
                    //ADD TO KEY VECTOR
                    if(vit->second.size() == 0)
                    {
                        vit->second.push_back(a_change);
                    }
                    else if(vit->second.back()->sequenceNumber < a_change->sequenceNumber)
                    {
                        vit->second.push_back(a_change);
                    }
                    else
                    {
                        vit->second.push_back(a_change);
                        std::sort(vit->second.begin(),vit->second.end(),sort_ReaderHistoryCache);
                    }
                    logInfo(SUBSCRIBER,this->mp_reader->getGuid().entityId
                            <<": Change "<< a_change->sequenceNumber << " added from: "
                            << a_change->writerGUID<< " with KEY: "<< a_change->instanceHandle;);
                    //	print_changes_seqNum();
                    return true;
                }
            }
        }
    }

    return false;
}


bool NativeSubscriberImpl::find_Key(CacheChange_t* a_change, t_v_Inst_Caches::iterator* vit_out)
{
    t_v_Inst_Caches::iterator vit;
    bool found = false;
    for (vit = m_keyedChanges.begin(); vit != m_keyedChanges.end(); ++vit)
    {
        if (a_change->instanceHandle == vit->first)
        {
            *vit_out = vit;
            return true;
        }
    }
    if (!found)
    {
        if ((int)m_keyedChanges.size() < m_resourceLimitsQos.max_instances)
        {
            t_p_I_Change newpair;
            newpair.first = a_change->instanceHandle;
            m_keyedChanges.push_back(newpair);
            *vit_out = m_keyedChanges.end() - 1;
            return true;
        }
        else
        {
            for (vit = m_keyedChanges.begin(); vit != m_keyedChanges.end(); ++vit)
            {
                if (vit->second.size() == 0)
                {
                    m_keyedChanges.erase(vit);
                    t_p_I_Change newpair;
                    newpair.first = a_change->instanceHandle;
                    m_keyedChanges.push_back(newpair);
                    *vit_out = m_keyedChanges.end() - 1;
                    return true;
                }
            }
            logWarning(SUBSCRIBER, "History has reached the maximum number of instances" << std::endl;)
        }

    }
    return false;
}

bool NativeSubscriberImpl::remove_change_sub_swig(int64_t change)
{
    CacheChange_t* cChange = (CacheChange_t*) change;
    return remove_change_sub(cChange);
}


bool NativeSubscriberImpl::remove_change_sub(CacheChange_t* change,t_v_Inst_Caches::iterator* vit_in)
{

    if(mp_reader == nullptr)
    {
        logError(RTPS_HISTORY,"You need to create a Reader with this History before using it");
        return false;
    }

    std::lock_guard<std::recursive_mutex> guard(*mp_mutex);
    if(this->topicKind == NO_KEY)
    {
        if(this->remove_change(change))
        {
            m_isHistoryFull = false;
            return true;
        }
        return false;
    }
    else
    {
        t_v_Inst_Caches::iterator vit;
        if(vit_in!=nullptr)
            vit = *vit_in;
        else if(this->find_Key(change,&vit))
        {

        }
        else
            return false;
        for(auto chit = vit->second.begin();
                chit!= vit->second.end();++chit)
        {
            if((*chit)->sequenceNumber == change->sequenceNumber
                    && (*chit)->writerGUID == change->writerGUID)
            {
                if(remove_change(change))
                {
                    vit->second.erase(chit);
                    m_isHistoryFull = false;
                    return true;
                }
            }
        }
        logError(SUBSCRIBER,"Change not found, something is wrong");
    }
    return false;
}

NativeSubscriberImpl::~NativeSubscriberImpl()
{
    RTPSDomain::removeRTPSReader(mp_reader);
}

void NativeSubscriberImpl::SubscriberReaderListener::onReaderMatched(RTPSReader* reader,MatchingInfo& info)
{
    logInfo(PUBLISHER, "Remote writer Guid: " << info.remoteEndpointGuid);
    GuidUnion retGuid;
    CommonFunctions::guidcpy(info.remoteEndpointGuid, &retGuid);
    subscriberImpl->listener->onReaderMatched(info.status, retGuid.primitive.high, retGuid.primitive.low);
}

void NativeSubscriberImpl::SubscriberReaderListener::onNewCacheChangeAdded(RTPSReader * reader,const CacheChange_t* const change)
{
    subscriberImpl->listener->onNewCacheChangeAdded();
}

