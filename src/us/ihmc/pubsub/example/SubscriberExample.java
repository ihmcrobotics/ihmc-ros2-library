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
package us.ihmc.pubsub.example;

import java.io.IOException;
import java.net.InetAddress;

import us.ihmc.idl.generated.Chat.ChatMessage;
import us.ihmc.idl.generated.Chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.HistoryQosPolicy.HistoryQosPolicyKind;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

public class SubscriberExample
{

   private class ParticipantListenerImpl implements ParticipantListener
   {

      @Override
      public void onParticipantDiscovery(Participant participant, ParticipantDiscoveryInfo info)
      {
         System.out.println("New participant discovered");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
         System.out.println("Name: " + info.getName());
      }

   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final ChatMessage data = new ChatMessage();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         try
         {
            if (subscriber.takeNextData(data, info))
            {
               System.out.println(data.getSender().toString() + ": " + data.getMsg().toString());
               Thread.sleep(10);
            }
         }
         catch (IOException | InterruptedException e)
         {
            e.printStackTrace();
         }
      }

      @Override
      public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
      {
         System.out.println("New publisher matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
   }

   public SubscriberExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("SubscriberExample");      
      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType, "ChatBox", ReliabilityKind.RELIABLE, "us/ihmc");      
      subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      
      
      
      domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());

      while (true)
      {
         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
         }
      }

   }

   public static void main(String[] args) throws IOException
   {
      new SubscriberExample();
   }
}
