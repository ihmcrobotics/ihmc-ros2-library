#include "nativeparticipantimpl.h"
#include "nativesubscriberimpl.h"

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


class ExampleSubscriberListener : public NativeSubscriberListener
{
    virtual void onSubscriptionMatched(MatchingStatus status, int64_t guidHigh, int64_t guidLow)
    {
        std::cout << "Found publisher" << std::endl;
    }
    virtual void onNewDataMessage()
    {
        std::cout << "Got callback" << std::endl;
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

    SubscriberAttributes attr;
    attr.topic.topicName = "ChatBox1";
    attr.topic.topicDataType = "chat::ChatMessage";


    attr.qos.m_reliability.kind = BEST_EFFORT_RELIABILITY_QOS;
    attr.qos.m_partition.push_back("us/ihmc");

    ExampleSubscriberListener subscriberListener;

    NativeSubscriberImpl subscriber(-1, -1, 528, PREALLOCATED_MEMORY_MODE,
                                    &attr.topic, &attr.qos, &attr.times, &attr.unicastLocatorList, &attr.multicastLocatorList, &attr.outLocatorList,
                                    false, &participant, &subscriberListener);
    subscriber.createSubscriber();
    std::vector<unsigned char> data(64000);
    SampleInfoMarshaller marshaller;
    while(true)
    {
        subscriber.waitForUnreadMessage();
        if(subscriber.takeNextData(64000, data.data(), &marshaller, NO_KEY, SHARED_OWNERSHIP_QOS))
        {
            std::cout << "Got message of length " << marshaller.dataLength << std::endl;
        }
    }


}
