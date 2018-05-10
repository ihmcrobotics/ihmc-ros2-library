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

    participant.registerType("chat::ChatMessage", 64000, false);

    PublisherAttributes attr;

    attr.topic.topicName = "ChatBox1";
    attr.topic.topicDataType = "chat::ChatMessage";


    attr.qos.m_reliability.kind = BEST_EFFORT_RELIABILITY_QOS;
    attr.qos.m_partition.push_back("us/ihmc");


    ExamplePublisherListener publisherListener;

    NativePublisherImpl publisher(-1, -1, 528, PREALLOCATED_MEMORY_MODE, &attr.topic, &attr.qos,
                                  &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList,
                                  &attr.outLocatorList, &attr.throughputController, &participant, &publisherListener);
    publisher.createPublisher();


    std::vector<unsigned char> data(64000, 'a');

    while(true)
    {
        publisher.write(data.data(),64000,CDR_LE, nullptr, 0);
        std::this_thread::sleep_for(std::chrono::nanoseconds(10000));

    }

}
