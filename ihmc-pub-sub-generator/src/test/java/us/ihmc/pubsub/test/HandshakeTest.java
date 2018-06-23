package us.ihmc.pubsub.test;

import org.junit.Test;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.generated.test.*;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.attributes.*;
import us.ihmc.pubsub.common.LogLevel;
import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.common.SampleInfo;
import us.ihmc.pubsub.common.Time;
import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;
import us.ihmc.pubsub.subscriber.Subscriber;
import us.ihmc.pubsub.subscriber.SubscriberListener;

import java.io.IOException;
import java.util.Random;

public class HandshakeTest
{
   @Test(timeout = 30000)
   public void testPublishSubscribeFooHandshake() throws IOException
   {
      Random random = new Random(29103902183L);


      Domain domain = DomainFactory.getDomain(DomainFactory.PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(1);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      FooHandshakePubSubType dataType = new FooHandshakePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      publisherAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(50);
      publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);

      FooHandshakePubSubType dataType2 = new FooHandshakePubSubType();

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType2, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      subscriberAttributes.getQos().setDurabilityKind(DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());

      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());

      FooHandshake msg;

      int i = 0;
      for (; i < 10; i++)
      {
         try
         {
            msg = constructRandomHandshake(random, i);
            publisher.write(msg);

            System.out.println("Publishing: " + msg.toString());
            Thread.sleep(1000);
            ++i;
         }
         catch (InterruptedException e)
         {
         }
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final FooHandshake data = new FooHandshake();
      private final SampleInfo info = new SampleInfo();

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(data, info))
         {
            System.out.println("Received: " + data.toString());
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

   public FooHandshake constructRandomHandshake(Random random, int id)
   {
      FooHandshake fooHandshake = new FooHandshake();

      fooHandshake.setUniqueId(id);
      fooHandshake.setDt(random.nextDouble());
      fooHandshake.setDestination(random.nextInt());
      fooHandshake.setSource(random.nextInt());

      FooSummary summary = fooHandshake.getSummary();
      summary.setCreateSummary(random.nextBoolean());
      summary.setSummaryTriggerVariable("ksnfajisfiuhou");

      IDLSequence.Object<FooGraphicObjectMessage> artifacts1 = fooHandshake.getArtifacts();
      for (int i = 0; i < 2000; i++)
      {
         FooGraphicObjectMessage fooGraphicObjectMessage = artifacts1.add();
         fooGraphicObjectMessage.setListName("asndoasd" + i);
         fooGraphicObjectMessage.setName("aiojdsoia" + i);
         fooGraphicObjectMessage.setRegistrationID(random.nextInt());

         for (int j = 0; j < 70; j++)
         {
            fooGraphicObjectMessage.getConstants().add(random.nextDouble());
         }

         for (int j = 0; j < 700; j++)
         {
            fooGraphicObjectMessage.getYoVariableIndex().add(random.nextInt());
         }

         FooAppearanceDefinitionMessage appearance = fooGraphicObjectMessage.getAppearance();
         appearance.setB(255.0);
         appearance.setG(255.0);
         appearance.setR(255.0);
      }

      IDLSequence.Object<FooEnumType> enumTypes = fooHandshake.getEnumTypes();
      for (int i = 0; i < 700; i++)
      {
         enumTypes.add().setName("ioshda" + i);
      }

      IDLSequence.Object<FooGraphicObjectMessage> graphicObjects = fooHandshake.getGraphicObjects();
      for (int i = 0; i < 2000; i++)
      {
         FooGraphicObjectMessage fooGraphicObjectMessage = graphicObjects.add();

         fooGraphicObjectMessage.setName("asodjao" + i);
         fooGraphicObjectMessage.setRegistrationID(random.nextInt());

         for (int j = 0; j < 70; j++)
         {
            fooGraphicObjectMessage.getConstants().add(random.nextDouble());
         }

         for (int j = 0; j < 700; j++)
         {
            fooGraphicObjectMessage.getYoVariableIndex().add(random.nextInt());
         }

         FooAppearanceDefinitionMessage appearance = fooGraphicObjectMessage.getAppearance();
         appearance.setB(255.0);
         appearance.setG(255.0);
         appearance.setR(255.0);
      }

      IDLSequence.Object<FooJointDefinition> joints = fooHandshake.getJoints();
      for (int i = 0; i < 70; i++)
      {
         FooJointDefinition fooJointDefinition = joints.add();
         fooJointDefinition.setName("iksaof" + i);
         fooJointDefinition.setType(FooJointType.FooOneDoFJoint);
      }

      IDLSequence.Object<FooYoRegistryDefinition> registries = fooHandshake.getRegistries();
      for (int i = 0; i < 1000; i++)
      {
         FooYoRegistryDefinition fooYoRegistryDefinition = registries.add();
         fooYoRegistryDefinition.setName("iasodoiasd" + i);
         fooYoRegistryDefinition.setParent(random.nextInt());
      }

      IDLSequence.Object<FooYoVariableDefinition> variables = fooHandshake.getVariables();
      for (int i = 0; i < 30000; i++)
      {
         FooYoVariableDefinition fooYoVariableDefinition = variables.add();
         fooYoVariableDefinition.setAllowNullValues(random.nextBoolean());
         fooYoVariableDefinition.setDescription("Diosfopjka" + i);
         fooYoVariableDefinition.setEnumType(random.nextInt());
         fooYoVariableDefinition.setIsParameter(random.nextBoolean());
         fooYoVariableDefinition.setLoadStatus(FooLoadStatus.FooLoaded);
         fooYoVariableDefinition.setMax(random.nextDouble());
         fooYoVariableDefinition.setMin(random.nextDouble());
         fooYoVariableDefinition.setRegistry(random.nextInt());
         fooYoVariableDefinition.setType(FooYoType.FooDoubleYoVariable);
      }

      return fooHandshake;
   }
}
