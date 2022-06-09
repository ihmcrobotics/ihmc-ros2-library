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
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.UUID;

import com.eprosima.xmlschemas.fastrtps_profiles.*;
import com.eprosima.xmlschemas.fastrtps_profiles.RemoteServerAttributes;
import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.pubsub.common.Guid;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.participant.PublisherEndpointDiscoveryListener;
import us.ihmc.pubsub.participant.SubscriberEndpointDiscoveryListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;
import us.ihmc.rtps.impl.fastRTPS.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

class FastRTPSParticipant implements Participant
{
   private final NativeParticipantImpl impl;

   private final ArrayList<TopicDataType<?>> types = new ArrayList<>();
   private final ArrayList<FastRTPSPublisher> publishers = new ArrayList<>();
   private final ArrayList<FastRTPSSubscriber> subscribers = new ArrayList<>();

   private final ParticipantAttributes attributes;
   private final ParticipantListener participantListener;

   private final Guid guid = new Guid();

   private final NativeParticipantListenerImpl nativeListener = new NativeParticipantListenerImpl();

   private PublisherEndpointDiscoveryListener publisherDiscoveryListener = null;
   private SubscriberEndpointDiscoveryListener subscriberDiscoveryListener = null;

   private class NativeParticipantListenerImpl extends NativeParticipantListener
   {
      private final FastRTPSParticipantDiscoveryInfo discoveryInfo = new FastRTPSParticipantDiscoveryInfo();

      @Override
      public void onParticipantDiscovery(long infoPtr, long guidHigh, long guidLow, int discoveryStatus)
      {
         try
         {
            if (participantListener != null)
            {
               System.out.println("infoPtr = " + infoPtr + ", guidHigh = " + guidHigh + ", guidLow = " + guidLow + ", status = " + discoveryStatus);
               discoveryInfo.updateInfo(discoveryStatus, this, infoPtr, guidHigh, guidLow);
               participantListener.onParticipantDiscovery(FastRTPSParticipant.this, discoveryInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }
   }


   FastRTPSParticipant(ParticipantAttributes attrs, ParticipantListener participantListener) throws IOException, IllegalArgumentException
   {
      String profileName = UUID.randomUUID().toString();
      String profileXML = attrs.marshall(profileName);

      //Set listener first, can be called before the constructor returns
      this.participantListener = participantListener;
      impl = new NativeParticipantImpl(profileName, profileXML, profileXML.length(), nativeListener);
      this.attributes = attrs;
      getGuid(guid);
   }

   synchronized void delete()
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         publishers.get(i).delete();
      }
      for (int i = 0; i < subscribers.size(); i++)
      {
         subscribers.get(i).delete();
      }
      impl.delete();
      nativeListener.delete();
   }

   private void getGuid(Guid guid)
   {
      guid.fromPrimitives(impl.getGuidHigh(), impl.getGuidLow());
   }

   @Override
   public Guid getGuid()
   {
      return guid;
   }

   @Override
   public ParticipantAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public synchronized int get_no_publisher(String target_topic)
   {
      int count = 0;
      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i).getAttributes().getTopicName().equals(target_topic))
         {
            count++;
         }
      }

      return count;
   }

   @Override
   public synchronized int get_no_subscribers(String target_topic)
   {
      int count = 0;
      for (int i = 0; i < subscribers.size(); i++)
      {
         if (subscribers.get(i).getAttributes().getTopicName().equals(target_topic))
         {
            count++;
         }
      }

      return count;
   }

   synchronized void registerType(TopicDataType<?> topicDataType) throws IllegalArgumentException
   {
      if (topicDataType.getTypeSize() <= 0)
      {
         throw new IllegalArgumentException("Registered type must have maximum byte size > 0");
      }

      if (topicDataType.getName().isEmpty())
      {
         throw new IllegalArgumentException("Registered type must have a name");
      }

      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(topicDataType.getName()))
         {
            throw new IllegalArgumentException("Type with the same name already exists: " + topicDataType.getName());
         }
      }

      impl.registerType(topicDataType.getName(), topicDataType.getTypeSize(), topicDataType.isGetKeyDefined());

      types.add(topicDataType);
   }

   synchronized TopicDataType<?> getRegisteredType(String name)
   {
      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(name))
         {
            return types.get(i);
         }
      }
      return null;
   }

   synchronized FastRTPSPublisher createPublisher(PublisherAttributes attrs, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      TopicDataType<?> topicDataType = getRegisteredType(attrs.getTopicDataType().getName());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + attrs.getTopicDataType() + " is not registered");
      }

      if (attrs.getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (this.attributes.isUseStaticDiscovery())
      {
         if (attrs.getUserDefinedId() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }


      FastRTPSPublisher publisher = new FastRTPSPublisher(topicDataType, attrs, listener, impl);
      publishers.add(publisher);
      return publisher;
   }

   synchronized Subscriber createSubscriber(SubscriberAttributes attrs, SubscriberListener listener) throws IOException
   {
      TopicDataType<?> topicDataType = getRegisteredType(attrs.getTopicDataType().getName());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + attrs.getTopicDataType() + " is not registered");
      }

      if (attrs.getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (this.attributes.isUseStaticDiscovery())
      {
         if (attrs.getUserDefinedId() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }

      FastRTPSSubscriber subscriber = new FastRTPSSubscriber(topicDataType, attrs, listener, impl);
      subscribers.add(subscriber);
      return subscriber;
   }

   synchronized boolean removePublisher(Publisher publisher)
   {
      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i) == publisher)
         {
            publishers.get(i).delete();
            publishers.remove(i);
            return true;
         }
      }
      return false;
   }

   synchronized boolean removeSubscriber(Subscriber subscriber)
   {
      for (int i = 0; i < subscribers.size(); i++)
      {
         if (subscribers.get(i) == subscriber)
         {
            subscribers.get(i).delete();
            subscribers.remove(i);
            return true;
         }
      }
      return false;
   }

   synchronized void unregisterType(String typeName) throws IOException
   {
      TopicDataType<?> type = null;
      for (int i = 0; i < types.size(); i++)
      {
         if (types.get(i).getName().equals(typeName))
         {
            type = types.get(i);
            continue;
         }
      }
      if (type == null)
      {
         throw new IllegalArgumentException(typeName + " is not registered with participant");
      }

      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i).getTopicDataType().equals(type))
         {
            throw new IOException("TopicDataType in use by publisher " + publishers.get(i).getAttributes().getTopicName());
         }
      }

      for (int i = 0; i < subscribers.size(); i++)
      {
         if (subscribers.get(i).getTopicDataType().equals(type))
         {
            throw new IOException("TopicDataType in use by subscriber " + subscribers.get(i).getAttributes().getTopicName());
         }
      }

      publishers.remove(type);
   }

   @Override
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener,
                                                  SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener)
         throws IOException
   {
      this.publisherDiscoveryListener = publisherEndpointDiscoveryListener;
      this.subscriberDiscoveryListener = subscriberEndpointDiscoveryListener;
   }

   @Override
   public synchronized boolean isAvailable()
   {
      return impl != null;
   }
}
