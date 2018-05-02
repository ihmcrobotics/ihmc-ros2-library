#include "nativeparticipantimpl.h"
#include "nativepublisherimpl.h"

#include <iostream>
#include <chrono>
#include <thread>
using namespace us::ihmc::rtps::impl::fastRTPS;


class ExampleParticipantListener : public NativeParticipantListener
{
    void onParticipantDiscovery(int64_t infoPtr, int64_t guidHigh, int64_t guidLow, DISCOVERY_STATUS status)
    {
        std::cout << "Discovered participant " << getName(infoPtr) << std::endl;
    }

};


class ExamplePublisherListener : public NativePublisherListener
{
    void onWriterMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow)
    {
        std::cout << "Found subscriber " << std::endl;
    }

};


int main()
{
    RTPSParticipantAttributes rtps;
    rtps.setName("Participant");
    rtps.builtin.domainId = 1;

    ExampleParticipantListener participantListener;

    NativeParticipantImpl participant(rtps, &participantListener);

    participant.registerType("chat::ChatMessage", 528, false);

    PublisherAttributes attr;

    attr.topic.topicName = "ChatBox1";
    attr.topic.topicDataType = "chat::ChatMessage";


    attr.qos.m_reliability.kind = RELIABLE_RELIABILITY_QOS;
    attr.qos.m_partition.push_back("us/ihmc");
    attr.qos.m_durability.kind = TRANSIENT_LOCAL_DURABILITY_QOS;
    attr.topic.historyQos.kind = KEEP_LAST_HISTORY_QOS;
    attr.topic.historyQos.depth = 50;

    ExamplePublisherListener publisherListener;

    NativePublisherImpl publisher(-1, -1, 528, PREALLOCATED_MEMORY_MODE, &attr.topic, &attr.qos,
                                  &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList,
                                  &attr.outLocatorList, &attr.throughputController, &participant, &publisherListener);
    publisher.createPublisher();


    unsigned char data[] = {0, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 74, 97, 118, 97, 0, 0, 0, 0, 14, 0, 0, 0, 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 32, 48, 0};

    for(int i = 0; i < 100; i++)
    {
        publisher.write(data,38,CDR_LE, nullptr, 0);
        std::this_thread::sleep_for(std::chrono::milliseconds(10));
    }

}
