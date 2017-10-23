/*
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
package us.ihmc.pubsub.impl.intraprocess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.attributes.WriterQosHolder;
import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.pubsub.types.ByteBufferPubSubType;

public class IntraProcessDomainTest
{
   private void checkMatchingInfo(MatchingStatus expectedStatus, Guid expectedGuid, MatchingInfo info)
   {
      assertNotNull(info);
      assertEquals(expectedStatus, info.getStatus());
      assertEquals(expectedGuid, info.getGuid());
   }
   

   @Test
   public void testConnectionLogic() throws IOException
   {
      try
      {
         TopicDataType<?> typeOfTheDay = new ChatMessagePubSubType();
         String topic = "chat";
         String partition = "us.ihmc";

         IntraProcessDomain domain = IntraProcessDomain.getInstance();
         domain.setLogLevel(LogLevel.INFO);


         // Setup participant with subscriber and publisher listeners
         ArrayBlockingQueue<ParticipantDiscoveryInfo> participantListenerFuture = new ArrayBlockingQueue<>(1);

         ParticipantListener participantListener = (participant, info) -> {
            participantListenerFuture.add(info);
         };

         ParticipantAttributes participantAttributes = domain.createParticipantAttributes(1, "participant");
         Participant participant = domain.createParticipant(participantAttributes, participantListener);

         ArrayBlockingQueue<Guid> publisherEndpointDiscover = new ArrayBlockingQueue<>(1);
         ArrayBlockingQueue<Guid> subscriberEndpointDiscover = new ArrayBlockingQueue<>(1);

         PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener = (boolean isAlive, Guid guid, ArrayList<Locator> unicastLocatorList,
                                                                                  ArrayList<Locator> multicastLocatorList, Guid participantGuid,
                                                                                  String typeName, String topicName, int userDefinedId, long typeMaxSerialized,
                                                                                  TopicKind topicKind, WriterQosHolder writerQosHolder) -> {
            System.out.println(topicName + " publisher came online");
            publisherEndpointDiscover.add(guid);
         };
         SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener = (boolean isAlive, Guid guid, boolean expectsInlineQos,
                                                                                    ArrayList<Locator> unicastLocatorList,
                                                                                    ArrayList<Locator> multicastLocatorList, Guid participantGuid,
                                                                                    String typeName, String topicName, int userDefinedId,
                                                                                    TopicKind javaTopicKind, ReaderQosHolder readerQosHolder) -> {
            System.out.println(topicName + " subscriber came online");
            subscriberEndpointDiscover.add(guid);
         };

         participant.registerEndpointDiscoveryListeners(publisherEndpointDiscoveryListener, subscriberEndpointDiscoveryListener);

         ArrayBlockingQueue<MatchingInfo> publisherMatched = new ArrayBlockingQueue<>(1);
         PublisherListener publisherListener = (Publisher publisher, MatchingInfo info) -> {
            publisherMatched.add(info);
         };
         PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Publisher publisher1 = domain.createPublisher(participant, publisherAttributes, publisherListener);

         ArrayBlockingQueue<MatchingInfo> subscriberMatched = new ArrayBlockingQueue<>(1);
         SubscriberListener subscriberListener = new SubscriberListener()
         {

            @Override
            public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
            {
               subscriberMatched.add(info);
            }

            @Override
            public void onNewDataMessage(Subscriber subscriber)
            {
            }
         };

         SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Subscriber subscriber1 = domain.createSubscriber(participant, subscriberAttributes, subscriberListener);


         // Check if all listeners have been called in the correct order
         assertEquals(publisher1.getGuid(), publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));
         assertEquals(subscriber1.getGuid(), subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));

         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, subscriber1.getGuid(), publisherMatched.poll(1, TimeUnit.SECONDS));

         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, publisher1.getGuid(), subscriberMatched.poll(1, TimeUnit.SECONDS));
         // Create new subscriber, check if all listeners get triggered
         Subscriber subscriber2 = domain.createSubscriber(participant, subscriberAttributes);

         assertEquals(subscriber2.getGuid(), subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));

         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, subscriber2.getGuid(), publisherMatched.poll(1, TimeUnit.SECONDS));
         
         // Create a new participant, see if original participant listeners get triggered
         Participant participant2 = domain.createParticipant(domain.createParticipantAttributes(1, "participant2"));
         
         ParticipantDiscoveryInfo participant2info = participantListenerFuture.poll(1, TimeUnit.SECONDS);
         assertNotEquals(null, participant2info);
         assertEquals(DiscoveryStatus.DISCOVERED_RTPSPARTICIPANT, participant2info.getStatus());
         assertEquals(participant2.getGuid(), participant2info.getGuid());
         assertEquals("participant2", participant2info.getName());
         
         
         // Create publishers and subscribers on the second participant and make sure they get registered
         Guid guid; 
         PublisherAttributes pubAtt2 = domain.createPublisherAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         guid = domain.createPublisher(participant2, pubAtt2).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, guid, subscriberMatched.poll(1, TimeUnit.SECONDS));
         guid = domain.createPublisher(participant2, pubAtt2).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, guid, subscriberMatched.poll(1, TimeUnit.SECONDS));
         
         SubscriberAttributes subAtt2 = domain.createSubscriberAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.BEST_EFFORT, partition);
         guid = domain.createSubscriber(participant2, subAtt2).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, guid, publisherMatched.poll(1, TimeUnit.SECONDS));
         guid = domain.createSubscriber(participant2, subAtt2).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.MATCHED_MATCHING, guid, publisherMatched.poll(1, TimeUnit.SECONDS));
         
         
         // Create a bunch of non-matching subscribers and publishers and make sure they only trigger the subscriber/publisher listeners
         PublisherAttributes pubAtt3 = domain.createPublisherAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.BEST_EFFORT, partition);
         guid = domain.createPublisher(participant2, pubAtt3).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));
         
         PublisherAttributes pubAtt4 = domain.createPublisherAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.RELIABLE);
         guid = domain.createPublisher(participant2, pubAtt4).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));

         PublisherAttributes pubAtt5 = domain.createPublisherAttributes(participant2, typeOfTheDay, topic + "Invalid", ReliabilityKind.RELIABLE, partition);
         guid = domain.createPublisher(participant2, pubAtt5).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));

         TopicDataType<?> newDataType = new ByteBufferPubSubType("Test", 10);
         PublisherAttributes pubAtt6 = domain.createPublisherAttributes(participant2, newDataType, topic, ReliabilityKind.RELIABLE, partition);
         guid = domain.createPublisher(participant2, pubAtt6).getGuid();
         assertEquals(guid, publisherEndpointDiscover.poll(1, TimeUnit.SECONDS));
         // Make sure no subscribers matched
         assertEquals(null, subscriberMatched.poll(1, TimeUnit.SECONDS));
         
         
         SubscriberAttributes subAtt3 = domain.createSubscriberAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.BEST_EFFORT);
         guid = domain.createSubscriber(participant2, subAtt3).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));
         
         SubscriberAttributes subAtt4 = domain.createSubscriberAttributes(participant2, typeOfTheDay, topic + "Invalid", ReliabilityKind.BEST_EFFORT, partition);
         guid = domain.createSubscriber(participant2, subAtt4).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));
         
         SubscriberAttributes subAtt5 = domain.createSubscriberAttributes(participant2, newDataType, topic, ReliabilityKind.BEST_EFFORT, partition);
         guid = domain.createSubscriber(participant2, subAtt5).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));
         
         
         
         assertEquals(null, publisherMatched.poll(1, TimeUnit.SECONDS));
         
      }
      catch (InterruptedException e)
      {
         throw new RuntimeException(e);
      }
   }

}
