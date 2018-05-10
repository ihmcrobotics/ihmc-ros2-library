#ifndef RAWTOPICDATATYPE_H
#define RAWTOPICDATATYPE_H

#include <vector>
#include <fastrtps/TopicDataType.h>

namespace us{
namespace ihmc{
namespace rtps{
namespace impl{
namespace fastRTPS{

struct RawDataWrapper
{
    RawDataWrapper(unsigned char* data, int32_t size, uint16_t encapsulation, unsigned char* key, uint32_t key_length) :
        data(data), length(size), encapsulation(encapsulation), key(key), key_length(key_length), managed(false)
    {

    }


    RawDataWrapper(unsigned char *data, int32_t size) :
        data(data),
        length(size),
        encapsulation(0x0),
        key(nullptr),
        key_length(0),
        managed(false)
    {

    }

    RawDataWrapper(int32_t size, uint16_t encapsulation) :
        data((unsigned char*)malloc(size)), length(size), encapsulation(encapsulation), key((unsigned char*)malloc(16)), key_length(16), managed(true)
    {

    }

    virtual ~RawDataWrapper()
    {
        if(managed)
        {
            free(data);
            free(key);
        }
    }

    // Use a std::vector here to avoid having to do manual memory management
    unsigned char* data;
    uint32_t length;
    uint16_t encapsulation;

    unsigned char* key;
    uint32_t key_length;

    bool managed;
};


class RawTopicDataType : public eprosima::fastrtps::TopicDataType
{
public:
    RawTopicDataType(std::string name, int32_t maximumDataSize, bool hasKey);

    /**
     * Serialize method, it should be implemented by the user, since it is abstract.
     * It is VERY IMPORTANT that the user sets the serializedPaylaod length correctly.
     * @param[in] data Pointer to the data
     * @param[out] payload Pointer to the payload
     * @return True if correct.
     */
    virtual bool serialize(void* data, eprosima::fastrtps::rtps::SerializedPayload_t* payload);

    /**
     * Deserialize method, it should be implemented by the user, since it is abstract.
     * @param[in] payload Pointer to the payload
     * @param[out] data Pointer to the data
     * @return True if correct.
     */
    virtual bool deserialize(eprosima::fastrtps::rtps::SerializedPayload_t* payload, void* data);

    virtual std::function<uint32_t()> getSerializedSizeProvider(void* data);

    /**
     * Create a Data Type.
     * @return Void pointer to the created object.
     */
    virtual void * createData();
    /**
     * Remove a previously created object.
     * @param data Pointer to the created Data.
     */
    virtual void deleteData(void * data);

    /**
     * Get the key associated with the data.
     * @param[in] data Pointer to the data.
     * @param[out] ihandle Pointer to the Handle.
     * @return True if correct.
     */
    virtual bool getKey(void* data, eprosima::fastrtps::rtps::InstanceHandle_t* ihandle);



private:
};
}}}}}
#endif // RAWTOPICDATATYPE_H
