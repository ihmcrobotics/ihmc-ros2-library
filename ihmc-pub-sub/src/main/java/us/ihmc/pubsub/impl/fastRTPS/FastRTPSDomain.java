/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC) Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package us.ihmc.pubsub.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;

import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSJNI;
import us.ihmc.tools.nativelibraries.NativeLibraryLoader;

public class FastRTPSDomain implements Domain
{
   public static final String FAST_DDS_DISCOVERY_CONFIGURABLE_PREFIX = "44.53.%02X.5f.45.50.52.4f.53.49.4d.41";
   public static final String FAST_DDS_XML_NAMESPACE = "http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles";
   public static final String FAST_DDS_METATRAFFIC_UNICAST_LOCATOR_LIST = "metatrafficUnicastLocatorList";
   public static final String FAST_DDS_PARTICIPANT = "participant";
   public static final String FAST_DDS_PUBLISHER = "publisher";
   public static final String FAST_DDS_SUBSCRIBER = "subscriber";
   public static final String FAST_DDS_NANOSEC = "nanosec";
   public static final String FAST_DDS_SEC = "sec";

   private final ArrayList<FastRTPSParticipant> participants = new ArrayList<>();

   private static boolean useSystemFastRTPS = false;
   private static FastRTPSDomain instance = null;

   public static synchronized FastRTPSDomain getInstance(boolean useSystemFastRTPS)
   {
      if (instance == null)
      {
         FastRTPSDomain.useSystemFastRTPS = useSystemFastRTPS;
         instance = new FastRTPSDomain(useSystemFastRTPS);
      }

      if(FastRTPSDomain.useSystemFastRTPS != useSystemFastRTPS)
      {
         if(useSystemFastRTPS)
         {
            throw new RuntimeException("Loading FastRTPS using the system FastRTPS library, but the builtin FastRTPS library is already loaded.");
         }
         else
         {
            throw new RuntimeException("Loading FastRTPS using the builtin FastRTPS library, but the system FastRTPS library is already loaded.");
         }
      }

      return instance;
   }

   private FastRTPSDomain(boolean useSystemFastRTPS)
   {
      try
      {
         if(useSystemFastRTPS)
         {
            System.loadLibrary("FastRTPSWrapper");
         }
         else
         {
            NativeLibraryLoader.loadLibrary("us.ihmc.rtps.impl.fastRTPS", "FastRTPSWrapper");

            // Force initialization of the FastRTPS class by setting the log level. This allows early bailout if there are linking errors.
            FastRTPSJNI.LogLevel_setLogLevel(0);
         }
      }
      catch (UnsatisfiedLinkError e)
      {
         if (SystemUtils.IS_OS_WINDOWS)
         {
            throw new UnsatisfiedLinkError("Cannot load library, make sure to install Microsoft Visual C++ 2019 Redistributable (x64) (https://aka.ms/vs/16/release/vc_redist.x64.exe). "
                  + e.getMessage());
         }
         else
         {
            throw e;
         }
      }
      Runtime.getRuntime().addShutdownHook(new Thread(() ->
      {
         LogTools.info("FastRTPS domain is going down.");
         stopAll();
         // It appears that without a small sleep, the printout does not show up.
         ThreadTools.sleep(10);
      }, "IHMCPubSub-FastRTPSDomain-StopAll"));
   }


   @Override
   public synchronized Participant createParticipant(ParticipantAttributes att, ParticipantListener participantListener) throws IOException
   {
      FastRTPSParticipant participant = new FastRTPSParticipant(att, participantListener);
      participants.add(participant);
      return participant;
   }


   @Override
   public synchronized Publisher createPublisherImpl(Participant participant, PublisherAttributes att, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      Publisher publisher = null;

      for (FastRTPSParticipant fastRTPSParticipant : participants)
      {
         if (fastRTPSParticipant == participant)
         {
            publisher = fastRTPSParticipant.createPublisher(att, listener);
            break;
         }
      }

      if (publisher == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return publisher;
   }

   @Override
   public synchronized Subscriber createSubscriberImpl(Participant participant, SubscriberAttributes attrs, SubscriberListener listener)
         throws IOException, IllegalArgumentException
   {

      Subscriber subscriber = null;

      for (FastRTPSParticipant fastRTPSParticipant : participants)
      {
         if (fastRTPSParticipant == participant)
         {
            subscriber = fastRTPSParticipant.createSubscriber(attrs, listener);
            break;
         }
      }

      if (subscriber == null)
      {
         throw new IllegalArgumentException("Participant is not part of this domain.");
      }

      ThreadTools.sleep(1);

      return subscriber;
   }

   @Override
   public synchronized boolean removeParticipant(Participant participant)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).delete();
            participants.remove(i);
            return true;
         }
      }

      return false;
   }

   @Override
   public synchronized boolean removePublisher(Publisher publisher)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(publisher.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removePublisher(publisher);
         }
      }
      return false;
   }

   @Override
   public synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i).getGuid().getGuidPrefix().equals(subscriber.getGuid().getGuidPrefix()))
         {
            return participants.get(i).removeSubscriber(subscriber);
         }
      }
      return false;
   }

   @Override
   public synchronized TopicDataType<?> getRegisteredType(Participant participant, String typeName)
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            return participants.get(i).getRegisteredType(typeName);
         }
      }
      return null;
   }

   @Override
   public synchronized void registerType(Participant participant, TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).registerType(topicDataType);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void unregisterType(Participant participant, String typeName) throws IOException
   {
      for (int i = 0; i < participants.size(); i++)
      {
         if (participants.get(i) == participant)
         {
            participants.get(i).unregisterType(typeName);
            return;
         }
      }
      throw new IllegalArgumentException("Participant is not part of this domain.");
   }

   @Override
   public synchronized void stopAll()
   {
      for (int i = participants.size() - 1; i >= 0; i--)
      {
         removeParticipant(participants.get(i));
      }
   }

   @Override
   public SubscriberAttributes createSubscriberAttributes(GenericSubscriberAttributes genericSubscriberAttributes) {
      return FastRTPSSubscriber.CommonToFastRTPSAttrs(genericSubscriberAttributes);
   }

   @Override
   public PublisherAttributes createPublisherAttributes(GenericPublisherAttributes genericPublisherAttributes) {
      return FastRTPSPublisher.CommonToFastRTPSAttrs(genericPublisherAttributes);
   }

   @Override
   public ParticipantAttributes createParticipantAttributes(GenericParticipantAttributes genericParticipantAttributes) {
      return FastRTPSParticipant.CommonToFastRTPSAttrs(genericParticipantAttributes);
   }

   @Override
   public void setLogLevel(LogLevel level)
   {
      us.ihmc.rtps.impl.fastRTPS.LogLevel.setLogLevel(level.getLevel());
   }
}
