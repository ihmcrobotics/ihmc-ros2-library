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

import us.ihmc.idl.generated.chat.ChatMessage;
import us.ihmc.idl.generated.chat.ChatMessagePubSubType;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

import java.io.IOException;

public class XMLPublisherExample
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

   public XMLPublisherExample() throws IOException
   {
      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
      
      domain.setLogLevel(LogLevel.INFO);

      String participantXml = "<dds xmlns=\"http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles\">\n" + "    <profiles>\n" + "        <participant profile_name=\"INMEM_PARTICIPANT\">\n" + "            <domainId>1</domainId>\n" + "            <rtps>\n" + "                <builtin>\n" + "                    <discovery_config>\n" + "                        <discoveryProtocol>CLIENT</discoveryProtocol>\n" + "                        <leaseDuration>\n" + "                            <nanosec>2147483647</nanosec>\n" + "                            <sec>2147483647</sec>\n" + "                        </leaseDuration>\n" + "                        <discoveryServersList>\n" + "                            <RemoteServer prefix=\"44.53.00.5f.45.50.52.4f.53.49.4d.41\">\n" + "                                <metatrafficUnicastLocatorList>\n" + "                                    <locator>\n" + "                                        <udpv4>\n" + "                                            <port>11811</port>\n" + "                                            <address>127.0.0.1</address>\n" + "                                        </udpv4>\n" + "                                    </locator>\n" + "                                </metatrafficUnicastLocatorList>\n" + "                            </RemoteServer>\n" + "                        </discoveryServersList>\n" + "                    </discovery_config>\n" + "                </builtin>\n" + "                <name>PublisherExample2</name>\n" + "            </rtps>\n" + "        </participant>\n" + "    </profiles>\n" + "</dds>\n";
      Participant participant = domain.createParticipant(participantXml, new ParticipantListenerImpl());

      ChatMessagePubSubType dataType = new ChatMessagePubSubType();
      domain.registerType(participant, dataType);


      String publisherXml = "<profiles>\n" + "    <publisher profile_name=\"INMEM_PUBLISHER\">\n" + "        <topic>\n" + "            <name>chatter</name>\n" + "            <dataType>chat::ChatMessage</dataType>\n" + "            <historyQos>\n" + "                <kind>KEEP_LAST</kind>\n" + "                <depth>50</depth>\n" + "            </historyQos>\n" + "        </topic>\n" + "    \n" + "        <qos> <!-- dataWriterQosPoliciesType -->\n" + "            <durability>\n" + "                <kind>TRANSIENT_LOCAL</kind>\n" + "            </durability>\n" + "            <reliability>\n" + "                <kind>RELIABLE</kind>\n" + "            </reliability>\n" + "            <lifespan>\n" + "                <duration>\n" + "                    <sec>5</sec>\n" + "                    <nanosec>0</nanosec>\n" + "                </duration>\n" + "            </lifespan>\n" + "            <partition>\n" + "                <names>\n" + "                    <name>us/ihmc</name>\n" + "                </names>\n" + "            </partition>\n" + "            <publishMode>\n" + "                <kind>ASYNCHRONOUS</kind>\n" + "            </publishMode>\n" + "        </qos>\n" + "        <userDefinedID>45</userDefinedID>\n" + "        <entityID>76</entityID>\n" + "    </publisher>\n" + "</profiles>";
      Publisher publisher = domain.createPublisher(participant, "INMEM_PUBLISHER", publisherXml, dataType, new PublisherListenerImpl());

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
      new XMLPublisherExample();
   }
}
