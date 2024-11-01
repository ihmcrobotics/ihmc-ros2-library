/**
 * Copyright 2024 Florida Institute for Human and Machine Cognition (IHMC)
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

import com.eprosima.xmlschemas.fastrtps_profiles.DurabilityQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.HistoryQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.PublishModeQosKindPolicyType;
import com.eprosima.xmlschemas.fastrtps_profiles.ReliabilityQosKindPolicyType;
import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.attributes.ParticipantProfile;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

import java.io.IOException;
import java.util.Collections;

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

      ParticipantProfile attributes2 = ParticipantProfile.create()
                                                         .domainId(1)
                                                         .name("PublisherExample2")
                                                         .discoveryLeaseDuration(Time.Infinite);
      //.discoveryServer("127.0.0.1", 4);
      
      System.out.println(attributes2.marshall("test"));


      Participant participant = domain.createParticipant(attributes2, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes attrs = PublisherAttributes.create()
        .topicName("chatter")
        .topicDataType(dataType)
        .publishModeKind(PublishModeQosKindPolicyType.ASYNCHRONOUS)
        .reliabilityKind(ReliabilityQosKindPolicyType.RELIABLE)
        .durabilityKind(DurabilityQosKindPolicyType.TRANSIENT_LOCAL)
        .historyQosPolicyKind(HistoryQosKindPolicyType.KEEP_LAST)
        .historyDepth(50)
        .partitions(Collections.singletonList("us/ihmc"))
        .lifespan(new Time(14, 0))
        .heartBeatPeriod(new Time(0, (long)(0.1 * 1e9)));

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
