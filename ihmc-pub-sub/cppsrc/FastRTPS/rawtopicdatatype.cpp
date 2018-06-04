#include "rawtopicdatatype.h"
#include "fastrtpsexception.h"

using namespace us::ihmc::rtps::impl::fastRTPS;

RawTopicDataType::RawTopicDataType(std::string name, int32_t maximumDataSize, bool hasKey)
{
    setName(name.c_str());
    m_typeSize = static_cast<uint32_t>(maximumDataSize);
    m_isGetKeyDefined = hasKey;
}

bool RawTopicDataType::serialize(void *data, eprosima::fastrtps::rtps::SerializedPayload_t *payload)
{
    RawDataWrapper* dataWrapper = static_cast<RawDataWrapper*>(data);

    payload->encapsulation = dataWrapper->encapsulation;
    payload->length = dataWrapper->length;

    if(payload->max_size < dataWrapper->length)
    {
        std::cerr << "[rawtopicdatatype.cpp] In function serialize(): Payload max size " << std::to_string(payload->max_size) << " exceeds datawrapper max size" << std::to_string(dataWrapper->length) << std::endl;
        return false;
    }

    memcpy(payload->data, dataWrapper->data, dataWrapper->length);
    return true;
}

bool RawTopicDataType::deserialize(eprosima::fastrtps::rtps::SerializedPayload_t *payload, void *data)
{
    RawDataWrapper* dataWrapper = static_cast<RawDataWrapper*>(data);
    dataWrapper->encapsulation = payload->encapsulation; // Don't trust the encapsulation value here
    dataWrapper->length = payload->length;

    if(payload->length > dataWrapper->length)
    {
        std::cerr << "[rawtopicdatatype.cpp] In function deserialize(): Payload max size " << std::to_string(payload->max_size) << " exceeds datawrapper max size"  << std::to_string(dataWrapper->length) << std::endl;
        return false;
    }

    memcpy(dataWrapper->data, payload->data, payload->length);
    dataWrapper->length = payload->length;

    return true;
}

std::function<uint32_t ()> RawTopicDataType::getSerializedSizeProvider(void *data)
{
    return [data]() -> uint32_t
    {
        return static_cast<RawDataWrapper*>(data)->length;
    };
}

void *RawTopicDataType::createData()
{
    return (void *) new RawDataWrapper(m_typeSize, CDR_LE);
}

void RawTopicDataType::deleteData(void *data)
{
    delete((RawDataWrapper*) data);
}

bool RawTopicDataType::getKey(void *data, eprosima::fastrtps::rtps::InstanceHandle_t *ihandle)
{
    if(!m_isGetKeyDefined)
    {
        return false;
    }


    RawDataWrapper* dataWrapper = static_cast<RawDataWrapper*>(data);
    if(dataWrapper->key_length == 0 || dataWrapper->key_length > 16)
    {
        return false;
    }

    memcpy(ihandle->value, dataWrapper->key, dataWrapper->key_length);

    return true;
}


