// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
// Copyright 2017 Florida Institute for Human and Machine Cognition
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

#include "publisherhistory.h"

#include "nativepublisherimpl.h"


extern ::rtps::WriteParams WRITE_PARAM_DEFAULT;

using namespace us::ihmc::rtps::impl::fastRTPS;

NativePublisherHistory::NativePublisherHistory(NativePublisherImpl* pimpl,int32_t payloadMaxSize,HistoryQosPolicy& history,
        ResourceLimitsQosPolicy& resource,MemoryManagementPolicy_t mempolicy):
                                        WriterHistory(HistoryAttributes(mempolicy, payloadMaxSize,resource.allocated_samples,resource.max_samples)),
                                        m_historyQos(history),
                                        m_resourceLimitsQos(resource),
                                        mp_pubImpl(pimpl)
{
    // TODO Auto-generated constructor stub

}

NativePublisherHistory::~NativePublisherHistory() {
    // TODO Auto-generated destructor stub
}



bool NativePublisherHistory::add_pub_change(CacheChange_t* change) throw(FastRTPSException) //, WriteParams &wparams)
{

    if(mp_writer == nullptr || mp_mutex == nullptr)
    {
        throw FastRTPSException("You need to create a Writer with this History before using it");
    }

    std::lock_guard<std::recursive_mutex> guard(*this->mp_mutex);
    if(m_isHistoryFull && !this->mp_pubImpl->clean_history(1))
    {
        return false;
    }

    bool returnedValue = false;

    //NO KEY HISTORY
    if(mp_pubImpl->getTopicKind() == NO_KEY)
    {
        if(this->add_change(change))
        {
            if(m_historyQos.kind == KEEP_ALL_HISTORY_QOS)
            {
                if((int32_t)m_changes.size()>=m_resourceLimitsQos.max_samples)
                    m_isHistoryFull = true;
            }
            else
            {
                //KEEP_LAST_HISTORY_QoS
                if((int32_t)m_changes.size()>=m_historyQos.depth)
                    m_isHistoryFull = true;
            }

            returnedValue = true;
        }
    }
    //HISTORY WITH KEY
    else if(mp_pubImpl->getTopicKind() == WITH_KEY)
    {
        t_v_Inst_Caches::iterator vit;
        if(find_Key(change,&vit))
        {
            logInfo(RTPS_HISTORY,"Found key: "<< vit->first);
            bool add = false;
            if(m_historyQos.kind == KEEP_ALL_HISTORY_QOS)
            {
                if((int32_t)vit->second.size() < m_resourceLimitsQos.max_samples_per_instance)
                {
                    add = true;
                }
                else
                    logWarning(RTPS_HISTORY,"Change not added due to maximum number of samples per instance"<<endl;);
            }
            else if (m_historyQos.kind == KEEP_LAST_HISTORY_QOS)
            {
                if(vit->second.size()< (size_t)m_historyQos.depth)
                {
                    add = true;
                }
                else
                {
                    if(remove_change_pub(vit->second.front(),&vit))
                    {
                        add = true;
                    }
                }
            }

            if(add)
            {
                if(this->add_change(change))
                {
                    vit->second.push_back(change);
                    if(m_historyQos.kind == KEEP_ALL_HISTORY_QOS)
                    {
                        if((int32_t)m_changes.size()==m_resourceLimitsQos.max_samples)
                            m_isHistoryFull = true;
                    }
                    else
                    {
                        if((int32_t)m_changes.size()==m_historyQos.depth*m_resourceLimitsQos.max_instances)
                            m_isHistoryFull = true;
                    }

                    returnedValue =  true;
                }
            }
        }
    }

    // Updated sample identity
//    if(returnedValue && &wparams != &WRITE_PARAM_DEFAULT)
//    {
//        wparams.sample_identity().writer_guid(change->writerGUID);
//        wparams.sample_identity().sequence_number(change->sequenceNumber);
//    }


    return returnedValue;
}

bool NativePublisherHistory::find_Key(CacheChange_t* a_change,t_v_Inst_Caches::iterator* vit_out)
{
    t_v_Inst_Caches::iterator vit;
    bool found = false;
    for(vit= m_keyedChanges.begin();vit!=m_keyedChanges.end();++vit)
    {
        if(a_change->instanceHandle == vit->first)
        {
            *vit_out = vit;
            return true;
        }
    }
    if(!found)
    {
        if((int)m_keyedChanges.size() < m_resourceLimitsQos.max_instances)
        {
            t_p_I_Change newpair;
            newpair.first = a_change->instanceHandle;
            m_keyedChanges.push_back(newpair);
            *vit_out = m_keyedChanges.end()-1;
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
            logWarning(SUBSCRIBER, "History has reached the maximum number of instances" << endl;)
        }
    }
    return false;
}


bool NativePublisherHistory::removeAllChange(size_t* removed)
{

    size_t rem = 0;
    std::lock_guard<std::recursive_mutex> guard(*this->mp_mutex);

    while(m_changes.size()>0)
    {
        if(remove_change_pub(m_changes.front()))
            ++rem;
        else
            break;
    }
    if(removed!=nullptr)
        *removed = rem;
    if (rem>0)
        return true;
    return false;
}


bool NativePublisherHistory::removeMinChange() throw(FastRTPSException)
{
    if(mp_writer == nullptr || mp_mutex == nullptr)
    {
        throw FastRTPSException("You need to create a Writer with this History before using it");
    }

    std::lock_guard<std::recursive_mutex> guard(*this->mp_mutex);
    if(m_changes.size()>0)
        return remove_change_pub(m_changes.front());
    return false;
}

bool NativePublisherHistory::remove_change_pub(CacheChange_t* change,t_v_Inst_Caches::iterator* vit_in) throw(FastRTPSException)
{

    if(mp_writer == nullptr || mp_mutex == nullptr)
    {
        throw FastRTPSException("You need to create a Writer with this History before using it");
    }

    std::lock_guard<std::recursive_mutex> guard(*this->mp_mutex);
    if(mp_pubImpl->getTopicKind() == NO_KEY)
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
            if( ((*chit)->sequenceNumber == change->sequenceNumber)
                && ((*chit)->writerGUID == change->writerGUID) )
            {
                if(remove_change(change))
                {
                    vit->second.erase(chit);
                                        m_isHistoryFull = false;
                    return true;
                }
            }
        }
        throw FastRTPSException("Change not found, something is wrong");
    }
    return false;
}

bool NativePublisherHistory::remove_change_g(CacheChange_t* a_change)
{
    return remove_change_pub(a_change);
}
