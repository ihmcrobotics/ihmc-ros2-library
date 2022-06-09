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
package us.ihmc.pubsub.examples;

import java.io.IOException;
import java.util.Collections;

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindType;

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

public class PublisherExample
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
   
   private class PublisherListenerImpl implements PublisherListener
   {

      @Override
      public void onPublicationMatched(Publisher publisher, MatchingInfo info)
      {
         System.out.println("New subscriber matched");
         System.out.println("Status: " + info.getStatus());
         System.out.println("Guid: " + info.getGuid().toString());
      }
      
   }

   public PublisherExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
      
      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes2 = ParticipantAttributes.create()
      .domainId(1)
      .name("PublisherExample2")
      .discoveryLeaseDuration(Time.Infinite);


      Participant participant = domain.createParticipant(attributes2, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes attrs = PublisherAttributes.builder()
                                                     .topicName("chatter")
                                                     .topicDataType(dataType)
                                                     .publishModeKind(PublishModeQosKindType.ASYNCHRONOUS)
                                                     .reliabilityKind(ReliabilityQosKindType.RELIABLE)
                                                     .durabilityKind(DurabilityQosKindType.TRANSIENT_LOCAL)
                                                     .historyQosPolicyKind(HistoryQosKindType.KEEP_LAST)
                                                     .historyDepth(50)
                                                     .partitions(Collections.singletonList("us/ihmc"))
                                                     .lifespan(new Time(14, 0))
                                                     .heartBeatPeriodNsec((long) (0.1 * 1e9)) //100ms
                                                     .build();

      System.out.println("creating publisher");
      Publisher publisher = domain.createPublisher(participant, attrs, new PublisherListenerImpl());
      
      
      ChatMessage msg = new ChatMessage();
      msg.setSender("Java");
      
      int i = 0;
      while(true)
      {
         try
         {
            msg.setMsg("Hello World " + (i++));
            publisher.write(msg);
            
            System.out.println("Publishing: " + msg.getMsgAsString());
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
         }
      }
   }
   
   public static void main(String[] args) throws IOException
   {
      new PublisherExample();
   }
}
