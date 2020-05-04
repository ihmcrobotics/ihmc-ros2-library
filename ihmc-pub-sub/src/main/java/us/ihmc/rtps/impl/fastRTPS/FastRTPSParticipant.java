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
package us.ihmc.rtps.impl.fastRTPS;

import java.io.IOException;
import java.util.ArrayList;

import us.ihmc.pubsub.TopicDataType;
import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.ParticipantAttributes;
import us.ihmc.pubsub.attributes.PublisherAttributes;
import us.ihmc.pubsub.attributes.ReaderQosHolder;
import us.ihmc.pubsub.attributes.SubscriberAttributes;
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

class FastRTPSParticipant implements Participant
{
   private final NativeParticipantImpl impl;

   private final ArrayList<TopicDataType<?>> types = new ArrayList<>();
   private final ArrayList<FastRTPSPublisher> publishers = new ArrayList<>();
   private final ArrayList<FastRTPSSubscriber> subscribers = new ArrayList<>();

   private final FastRTPSParticipantAttributes attributes;
   private final ParticipantListener participantListener;

   private final Guid guid = new Guid();

   private final NativeParticipantListenerImpl nativeListener = new NativeParticipantListenerImpl();

   private NativeParticipantPublisherEDPListenerImpl nativeParticipantPublisherEDPListenerImpl = null;
   private NativeParticipantSubscriberEDPListenerImpl nativeParticipantSubscriberEDPListenerImpl = null;

   private class NativeParticipantListenerImpl extends NativeParticipantListener
   {
      private final FastRTPSParticipantDiscoveryInfo discoveryInfo = new FastRTPSParticipantDiscoveryInfo();

      @Override
      public void onParticipantDiscovery(long infoPtr, long guidHigh, long guidLow, DISCOVERY_STATUS status)
      {
         try
         {
            if (participantListener != null)
            {
               discoveryInfo.updateInfo(status, this, infoPtr, guidHigh, guidLow);
               participantListener.onParticipantDiscovery(FastRTPSParticipant.this, discoveryInfo);
            }
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }
   }

   private class NativeParticipantPublisherEDPListenerImpl extends NativeParticipantPublisherEDPListener
   {
      private final PublisherEndpointDiscoveryListener listener;

      public NativeParticipantPublisherEDPListenerImpl(PublisherEndpointDiscoveryListener listener)
      {
         this.listener = listener;
      }

      @Override
      public void publisherTopicChange(boolean isAlive, long guidHigh, long guidLow, LocatorList_t unicastLocatorList, LocatorList_t multicastLocatorList,
                                       long participantGuidHigh, long participantGuidLow, String typeName, String topicName, int userDefinedId,
                                       long typeMaxSerialized, TopicKind_t topicKind, WriterQos writerQoS)
      {
         try
         {
            Guid guid = new Guid();
            guid.fromPrimitives(guidHigh, guidLow);

            Guid participantGuid = new Guid();
            participantGuid.fromPrimitives(participantGuidHigh, participantGuidLow);

            ArrayList<Locator> unicastLocatorListOut = new ArrayList<>();
            ArrayList<Locator> multicastLocatorListOut = new ArrayList<>();

            for (int i = 0; i < unicastLocatorList.size(); i++)
            {
               Locator out = new Locator();
               FastRTPSCommonFunctions.convertToJavaLocator(FastRTPS.getLocator(unicastLocatorList, i), out);
               unicastLocatorListOut.add(out);
            }

            for (int i = 0; i < multicastLocatorList.size(); i++)
            {
               Locator out = new Locator();
               FastRTPSCommonFunctions.convertToJavaLocator(FastRTPS.getLocator(multicastLocatorList, i), out);
               multicastLocatorListOut.add(out);
            }

            FastRTPSWriterQosHolder writerQosOut = new FastRTPSWriterQosHolder(writerQoS);

            listener.publisherTopicChange(isAlive, guid, unicastLocatorListOut, multicastLocatorListOut, participantGuid, typeName, topicName, userDefinedId,
                                          typeMaxSerialized, FastRTPSCommonFunctions.toJavaTopicKind(topicKind), writerQosOut);
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }

      }
   }

   private class NativeParticipantSubscriberEDPListenerImpl extends NativeParticipantSubscriberEDPListener
   {
      private final SubscriberEndpointDiscoveryListener listener;

      public NativeParticipantSubscriberEDPListenerImpl(SubscriberEndpointDiscoveryListener listener)
      {
         this.listener = listener;
      }

      @Override
      public void subscriberTopicChange(boolean isAlive, long guidHigh, long guidLow, boolean expectsInlineQos, LocatorList_t unicastLocatorList,
                                        LocatorList_t multicastLocatorList, long participantGuidHigh, long participantGuidLow, String typeName,
                                        String topicName, int userDefinedId, TopicKind_t topicKind, ReaderQos readerQoS)
      {
         try
         {
            Guid guid = new Guid();
            guid.fromPrimitives(guidHigh, guidLow);

            Guid participantGuid = new Guid();
            participantGuid.fromPrimitives(participantGuidHigh, participantGuidLow);

            ArrayList<Locator> unicastLocatorListOut = new ArrayList<>();
            ArrayList<Locator> multicastLocatorListOut = new ArrayList<>();

            for (int i = 0; i < unicastLocatorList.size(); i++)
            {
               Locator out = new Locator();
               FastRTPSCommonFunctions.convertToJavaLocator(FastRTPS.getLocator(unicastLocatorList, i), out);
               unicastLocatorListOut.add(out);
            }

            for (int i = 0; i < multicastLocatorList.size(); i++)
            {
               Locator out = new Locator();
               FastRTPSCommonFunctions.convertToJavaLocator(FastRTPS.getLocator(multicastLocatorList, i), out);
               multicastLocatorListOut.add(out);
            }

            ReaderQosHolder readerQosOut = new FastRTPSReaderQosHolder(readerQoS);

            listener.subscriberTopicChange(isAlive, guid, expectsInlineQos, unicastLocatorListOut, multicastLocatorListOut, participantGuid, typeName,
                                           topicName, userDefinedId, FastRTPSCommonFunctions.toJavaTopicKind(topicKind), readerQosOut);
         }
         catch (Throwable e)
         {
            e.printStackTrace();
         }
      }
   }

   FastRTPSParticipant(ParticipantAttributes att, ParticipantListener participantListener) throws IOException, IllegalArgumentException
   {
      //Set listener first, can be called before the constructor returns
      this.participantListener = participantListener;
      if (att instanceof FastRTPSParticipantAttributes)
      {
         this.attributes = (FastRTPSParticipantAttributes) att;
         impl = new NativeParticipantImpl(attributes.rtps(), nativeListener);
      }
      else
      {
         throw new IllegalArgumentException("ParticipantAttributes<?> is not of base class FastRTPSParticipantAttributes");
      }
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
      if(nativeParticipantPublisherEDPListenerImpl != null)
      {
         nativeParticipantPublisherEDPListenerImpl.delete();
      }
      
      if(nativeParticipantSubscriberEDPListenerImpl != null)
      {
         nativeParticipantSubscriberEDPListenerImpl.delete();
      }
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
   public FastRTPSParticipantAttributes getAttributes()
   {
      return attributes;
   }

   @Override
   public synchronized int get_no_publisher(String target_topic)
   {

      int count = 0;
      for (int i = 0; i < publishers.size(); i++)
      {
         if (publishers.get(i).getAttributes().getTopic().getTopicName().equals(target_topic))
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
         if (subscribers.get(i).getAttributes().getTopic().getTopicName().equals(target_topic))
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

   synchronized FastRTPSPublisher createPublisher(PublisherAttributes publisherAttributes, PublisherListener listener)
         throws IOException, IllegalArgumentException
   {
      TopicDataType<?> topicDataType = getRegisteredType(publisherAttributes.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + publisherAttributes.getTopic().getTopicDataType() + " is not registered");
      }

      if (publisherAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (attributes.rtps().getBuiltin().getUse_STATIC_EndpointDiscoveryProtocol())
      {
         if (publisherAttributes.getUserDefinedID() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }

      if (publisherAttributes instanceof FastRTPSPublisherAttributes)
      {
         FastRTPSPublisher publisher = new FastRTPSPublisher(topicDataType, (FastRTPSPublisherAttributes) publisherAttributes, listener, impl);
         publishers.add(publisher);
         return publisher;
      }
      else
      {
         throw new IllegalArgumentException("publisherAttributes are not an instance of FastRTPSPublisherAttributes");
      }
   }

   synchronized Subscriber createSubscriber(SubscriberAttributes subscriberAttributes, SubscriberListener listener) throws IOException
   {
      TopicDataType<?> topicDataType = getRegisteredType(subscriberAttributes.getTopic().getTopicDataType());
      if (topicDataType == null)
      {
         throw new IllegalArgumentException("Type: " + subscriberAttributes.getTopic().getTopicDataType() + " is not registered");
      }

      if (subscriberAttributes.getTopic().getTopicKind() == TopicKind.WITH_KEY && !topicDataType.isGetKeyDefined())
      {
         throw new IllegalArgumentException("Keyed topic needs getKey function");
      }

      if (attributes.rtps().getBuiltin().getUse_STATIC_EndpointDiscoveryProtocol())
      {
         if (subscriberAttributes.getUserDefinedID() <= 0)
         {
            throw new IllegalArgumentException("Static EDP requires user defined EDP");
         }
      }

      if (subscriberAttributes instanceof FastRTPSSubscriberAttributes)
      {
         FastRTPSSubscriber subscriber = new FastRTPSSubscriber(topicDataType, (FastRTPSSubscriberAttributes) subscriberAttributes, listener, impl);
         subscribers.add(subscriber);
         return subscriber;
      }
      else
      {
         throw new IllegalArgumentException("subscriberAttributes are not an instance of FastRTPSSubscriberAttributes");
      }
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
            throw new IOException("TopicDataType in use by publisher " + publishers.get(i).getAttributes().getTopic().getTopicName());
         }
      }

      for (int i = 0; i < subscribers.size(); i++)
      {
         if (subscribers.get(i).getTopicDataType().equals(type))
         {
            throw new IOException("TopicDataType in use by subscriber " + subscribers.get(i).getAttributes().getTopic().getTopicName());

         }
      }

      publishers.remove(type);
   }

   @Override
   public void registerEndpointDiscoveryListeners(PublisherEndpointDiscoveryListener publisherEndpointDiscoveryListener,
                                                  SubscriberEndpointDiscoveryListener subscriberEndpointDiscoveryListener)
         throws IOException
   {
      nativeParticipantPublisherEDPListenerImpl = publisherEndpointDiscoveryListener == null ? null
            : new NativeParticipantPublisherEDPListenerImpl(publisherEndpointDiscoveryListener);
      nativeParticipantSubscriberEDPListenerImpl = subscriberEndpointDiscoveryListener == null ? null
            : new NativeParticipantSubscriberEDPListenerImpl(subscriberEndpointDiscoveryListener);

      impl.registerEDPReaderListeners(nativeParticipantPublisherEDPListenerImpl, nativeParticipantSubscriberEDPListenerImpl);
   }

   @Override
   public synchronized boolean isAvailable()
   {
      return impl != null;
   }

}
