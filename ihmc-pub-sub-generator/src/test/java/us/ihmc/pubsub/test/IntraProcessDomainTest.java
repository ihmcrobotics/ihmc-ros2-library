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
package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Test;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.*;
import us.ihmc.pubsub.common.Guid.GuidPrefix;
import us.ihmc.pubsub.common.MatchingInfo.MatchingStatus;
import us.ihmc.pubsub.impl.intraprocess.IntraProcessDomain;
import us.ihmc.pubsub.participant.*;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.pubsub.types.ByteBufferPubSubType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class IntraProcessDomainTest
{
   private void checkMatchingInfo(MatchingStatus expectedStatus, Guid expectedGuid, MatchingInfo info)
   {
      assertNotNull(info);
      assertEquals(expectedStatus, info.getStatus());
      assertEquals(expectedGuid, info.getGuid());
   }

   private void checkMatchingInfo(MatchingStatus expectedStatus, GuidPrefix expectedGuidPrefix, MatchingInfo info)
   {
      assertNotNull(info);
      assertEquals(expectedStatus, info.getStatus());
      assertEquals(expectedGuidPrefix, info.getGuid().getGuidPrefix());
   }

   @Test// timeout = 30000
   public void testMessagePassing() throws IOException, InterruptedException
   {
      TopicDataType<?> typeOfTheDay = new ChatMessagePubSubType();
      String topic = "chat";
      String partition = "us.ihmc";

      IntraProcessDomain domain = IntraProcessDomain.getInstance();
      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes participantAttributes = domain.createParticipantAttributes(1, "participant");
      Participant participant = domain.createParticipant(participantAttributes);

      try
      {

         ArrayBlockingQueue<ChatMessage> messageQueue = new ArrayBlockingQueue<>(10);

         SubscriberListener listener = new SubscriberListener()
         {

            @Override
            public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
            {

            }

            @Override
            public void onNewDataMessage(Subscriber subscriber)
            {
               ChatMessage data = new ChatMessage();
               if (subscriber.takeNextData(data, null))
               {
                  messageQueue.add(data);
               }
            }
         };

         PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Publisher publisher1 = domain.createPublisher(participant, publisherAttributes);

         SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Subscriber subscriber1 = domain.createSubscriber(participant, subscriberAttributes);

         SubscriberAttributes subscriberAttributes2 = domain.createSubscriberAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Subscriber subscriber2 = domain.createSubscriber(participant, subscriberAttributes2, listener);

         SubscriberAttributes subscriberAttributes3 = domain.createSubscriberAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE);
         Subscriber subscriber3 = domain.createSubscriber(participant, subscriberAttributes3);

         ChatMessage msg = new ChatMessage();
         msg.setMsg("Test");
         msg.setSender("JUnit");

         publisher1.write(msg);

         subscriber1.waitForUnreadMessage(100);

         ChatMessage rec = new ChatMessage();
         SampleInfo info = new SampleInfo();

         int k = 0;
         for (; k < 5 && !subscriber1.readNextData(rec, info); k++)
         {
            ThreadTools.sleep(100);
         }
         assertTrue(k < 5, "could not read data");
         assertEquals(msg, rec);

         subscriber1.waitForUnreadMessage(100);

         assertTrue(subscriber1.takeNextData(rec, info));
         assertEquals(msg, rec);

         assertEquals(publisher1.getGuid(), info.getSampleIdentity().getGuid());
         assertEquals(0l, info.getSampleIdentity().getSequenceNumber().get());
         assertEquals(ChangeKind.ALIVE, info.getSampleKind());

         assertEquals(msg, messageQueue.poll(5000, TimeUnit.MILLISECONDS));

         assertFalse(subscriber1.takeNextData(rec, info));
         assertFalse(subscriber2.takeNextData(rec, info));
         assertFalse(subscriber3.takeNextData(msg, info));

         for(int i = 0; i < 10; i++)
         {
            String msgText = "Test " + i;
            msg.setMsg(msgText);
            publisher1.write(msg);
            subscriber1.waitForUnreadMessage(100);

            assertTrue(subscriber1.takeNextData(rec, info));
            assertEquals(msg, rec);
            assertEquals(msgText, rec.getMsgAsString());

            assertEquals(publisher1.getGuid(), info.getSampleIdentity().getGuid());
            assertEquals(i + 1l, info.getSampleIdentity().getSequenceNumber().get());
            assertEquals(ChangeKind.ALIVE, info.getSampleKind());

            ChatMessage rec2 = messageQueue.poll(5000, TimeUnit.MILLISECONDS);
            assertEquals(msg, rec2);
            assertEquals(msgText, rec2.getMsgAsString());
         }
         
         boolean failed = false;
         Object failure = new Object();
         try
         {
            publisher1.write(failure);
         }
         catch(IOException e)
         {
            failed = true;
         }

         assertTrue(failed);
      } finally
      {
         domain.stopAll();
      }
   }

   @Test// timeout = 30000
   public void testConnectionLogic() throws IOException, InterruptedException
   {
      // Setup participant with subscriber and publisher listeners
      ArrayBlockingQueue<ParticipantDiscoveryInfo> participantListenerFuture = new ArrayBlockingQueue<>(1);
      
      ParticipantListener participantListener = (participant, info) -> {
         participantListenerFuture.add(info);
      };
      IntraProcessDomain domain = IntraProcessDomain.getInstance();
      domain.setLogLevel(LogLevel.INFO);
      
      ParticipantAttributes participantAttributes = domain.createParticipantAttributes(1, "participant");
      Participant participant = domain.createParticipant(participantAttributes, participantListener);
      
      try
      {
         TopicDataType<?> typeOfTheDay = new ChatMessagePubSubType();
         String topic = "chat";
         String partition = "us.ihmc";




         ArrayBlockingQueue<Guid> publisherEndpointDiscover = new ArrayBlockingQueue<>(1);
         ArrayBlockingQueue<Guid> subscriberEndpointDiscover = new ArrayBlockingQueue<>(1);

         PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener = (boolean isAlive, Guid guid, ArrayList<Locator> unicastLocatorList,
                                                                                  ArrayList<Locator> multicastLocatorList, Guid participantGuid,
                                                                                  String typeName, String topicName, int userDefinedId, long typeMaxSerialized,
                                                                                  TopicKind topicKind, WriterQosHolder writerQosHolder) -> {
            publisherEndpointDiscover.add(guid);
         };
         SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener = (boolean isAlive, Guid guid, boolean expectsInlineQos,
                                                                                    ArrayList<Locator> unicastLocatorList,
                                                                                    ArrayList<Locator> multicastLocatorList, Guid participantGuid,
                                                                                    String typeName, String topicName, int userDefinedId,
                                                                                    TopicKind javaTopicKind, ReaderQosHolder readerQosHolder) -> {
            subscriberEndpointDiscover.add(guid);
         };

         participant.registerEndpointDiscoveryListeners(publisherEndpointDiscoveryListener, subscriberEndpointDiscoveryListener);

         ArrayBlockingQueue<MatchingInfo> publisherMatched = new ArrayBlockingQueue<>(2);
         PublisherListener publisherListener = (Publisher publisher, MatchingInfo info) -> {
            publisherMatched.add(info);
         };
         PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, typeOfTheDay, topic, ReliabilityKind.RELIABLE, partition);
         Publisher publisher1 = domain.createPublisher(participant, publisherAttributes, publisherListener);

         ArrayBlockingQueue<MatchingInfo> subscriberMatched = new ArrayBlockingQueue<>(2);
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

         assertEquals(1, (long) participant.get_no_publisher(topic));
         assertEquals(2, (long) participant.get_no_subscribers(topic));

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

         assertEquals(2, (long) participant2.get_no_publisher(topic));
         assertEquals(2, (long) participant2.get_no_subscribers(topic));

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

         assertEquals(5, (long) participant2.get_no_publisher(topic));
         assertEquals(1, (long) participant2.get_no_publisher(topic + "Invalid"));

         SubscriberAttributes subAtt3 = domain.createSubscriberAttributes(participant2, typeOfTheDay, topic, ReliabilityKind.BEST_EFFORT);
         guid = domain.createSubscriber(participant2, subAtt3).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));

         SubscriberAttributes subAtt4 = domain.createSubscriberAttributes(participant2, typeOfTheDay, topic + "Invalid", ReliabilityKind.BEST_EFFORT,
                                                                          partition);
         guid = domain.createSubscriber(participant2, subAtt4).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));

         SubscriberAttributes subAtt5 = domain.createSubscriberAttributes(participant2, newDataType, topic, ReliabilityKind.BEST_EFFORT, partition);
         guid = domain.createSubscriber(participant2, subAtt5).getGuid();
         assertEquals(guid, subscriberEndpointDiscover.poll(1, TimeUnit.SECONDS));

         assertEquals(4, (long) participant2.get_no_subscribers(topic));
         assertEquals(1, (long) participant2.get_no_subscribers(topic + "Invalid"));

         assertEquals(null, publisherMatched.poll(1, TimeUnit.SECONDS));

         assertTrue(publisher1.isAvailable());
         assertTrue(subscriber2.isAvailable());

         // Check if removing participants works
         domain.removeParticipant(participant2);

         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, participant2.getGuid().getGuidPrefix(), publisherMatched.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, participant2.getGuid().getGuidPrefix(), publisherMatched.poll(1, TimeUnit.SECONDS));
         assertEquals(null, publisherMatched.poll(1, TimeUnit.SECONDS));

         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, participant2.getGuid().getGuidPrefix(), subscriberMatched.poll(1, TimeUnit.SECONDS));
         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, participant2.getGuid().getGuidPrefix(), subscriberMatched.poll(1, TimeUnit.SECONDS));
         assertEquals(null, subscriberMatched.poll(1, TimeUnit.SECONDS));

         assertEquals(0, (long) participant2.get_no_publisher(topic));
         assertEquals(0, (long) participant2.get_no_publisher(topic + "Invalid"));
         assertEquals(0, (long) participant2.get_no_subscribers(topic));
         assertEquals(0, (long) participant2.get_no_subscribers(topic + "Invalid"));

         // Check removing of subscriber
         domain.removeSubscriber(subscriber2);
         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, subscriber2.getGuid(), publisherMatched.poll(1, TimeUnit.SECONDS));
         assertEquals(null, subscriberMatched.poll(1, TimeUnit.SECONDS));

         domain.removePublisher(publisher1);
         checkMatchingInfo(MatchingStatus.REMOVED_MATCHING, publisher1.getGuid(), subscriberMatched.poll(1, TimeUnit.SECONDS));
         assertEquals(null, publisherMatched.poll(1, TimeUnit.SECONDS));

         assertEquals(0, (long) participant.get_no_publisher(topic));
         assertEquals(1, (long) participant.get_no_subscribers(topic));

         assertFalse(publisher1.isAvailable());
         assertFalse(subscriber2.isAvailable());
         assertTrue(subscriber1.isAvailable());

         assertTrue(participant.isAvailable());
         assertFalse(participant2.isAvailable());
      }
      finally
      {
         domain.stopAll();
      }
   }

}
