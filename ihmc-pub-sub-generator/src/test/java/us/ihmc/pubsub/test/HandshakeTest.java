package us.ihmc.pubsub.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import us.ihmc.commons.PrintTools;
import us.ihmc.commons.allocations.AllocationProfiler;
import us.ihmc.commons.allocations.AllocationRecord;
import us.ihmc.commons.thread.ThreadTools;
import us.ihmc.idl.CDR;
import us.ihmc.idl.IDLSequence;
import us.ihmc.idl.generated.test.*;
import us.ihmc.log.LogTools;
import us.ihmc.pubsub.Domain;
import us.ihmc.pubsub.DomainFactory;
import us.ihmc.pubsub.DomainFactory.PubSubImplementation;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HandshakeTest
{
   public static final int NUMBER_OF_MESSAGES_TO_SEND = 7;

   public int sendIndex = 0;

   @Tag("allocation")
   @Test// timeout = 30000
   public void testPublishSubscribeFooHandshake() throws IOException
   {
      PubSubImplementation pubSubImplementation = PubSubImplementation.FAST_RTPS;

      AllocationProfiler allocationProfiler = new AllocationProfiler();
      allocationProfiler.excludeAllocationsInsideMethod("java.lang.ThreadGroup.add");

      Random random = new Random(29103902183L);

      Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);

      domain.setLogLevel(LogLevel.INFO);

      ParticipantAttributes attributes = domain.createParticipantAttributes();
      attributes.setDomainId(215);
      attributes.setLeaseDuration(Time.Infinite);
      attributes.setName("StatusTest");

      Participant participant = domain.createParticipant(attributes, new ParticipantListenerImpl());

      FooHandshakePubSubType dataType = new FooHandshakePubSubType();
      domain.registerType(participant, dataType);

      PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      publisherAttributes.getQos().setDurabilityKind(pubSubImplementation == PubSubImplementation.INTRAPROCESS ?
                                                           DurabilityKind.VOLATILE_DURABILITY_QOS
                                                           : DurabilityKind.TRANSIENT_LOCAL_DURABILITY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_LAST_HISTORY_QOS);
      publisherAttributes.getTopic().getHistoryQos().setDepth(50);
      publisherAttributes.getQos().setPublishMode(PublishModeKind.ASYNCHRONOUS_PUBLISH_MODE);

      FooHandshakePubSubType dataType2 = new FooHandshakePubSubType();

      SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType2, "Status", ReliabilityKind.RELIABLE, "us/ihmc");
      subscriberAttributes.getQos().setDurabilityKind(pubSubImplementation == PubSubImplementation.INTRAPROCESS ?
                                                            DurabilityKind.VOLATILE_DURABILITY_QOS
                                                            : DurabilityKind.VOLATILE_DURABILITY_QOS);
      subscriberAttributes.getTopic().getHistoryQos().setKind(HistoryQosPolicy.HistoryQosPolicyKind.KEEP_ALL_HISTORY_QOS);

      SubscriberListenerImpl subscriberListener = new SubscriberListenerImpl();
      Subscriber subscriber = domain.createSubscriber(participant, subscriberAttributes, subscriberListener);

      Publisher publisher = domain.createPublisher(participant, publisherAttributes, new PublisherListenerImpl());

      List<FooHandshake> preallocatedHandshakes = new ArrayList<>();
      for (int n = 0; n < NUMBER_OF_MESSAGES_TO_SEND; n++)
      {
         System.out.println("Constructing random handshake " + n + "...");
         preallocatedHandshakes.add(constructRandomHandshake(random, n));
      }

      writeNHandshakes(publisher, preallocatedHandshakes, 1); // warmup

      allocationProfiler.startRecordingAllocations(); // start recording

      writeNHandshakes(publisher, preallocatedHandshakes, NUMBER_OF_MESSAGES_TO_SEND - 1); // write the rest

      allocationProfiler.stopRecordingAllocations();  // stop recording

      ThreadTools.sleep(100);

      for (int i = 0; i < subscriberListener.i; i++)
      {
         PrintTools.info(this, "Message received: " + subscriberListener.receivedMessages[i].getDt());
      }

      List<AllocationRecord> allocations = allocationProfiler.pollAllocations();

      String message = "";
      for (AllocationRecord allocation : allocations)
      {
         message += allocation.toString() + "\n";
      }
      System.out.println(message);

      LogTools.info("Recieved: " + subscriberListener.i + "/" + NUMBER_OF_MESSAGES_TO_SEND + " messages");
      assertTrue(allocations.size() == 0, "allocated " + allocations.size() + ": \n" + message);
      assertTrue(subscriberListener.i >= 1, "did not receive all");
   }

   private void writeNHandshakes(Publisher publisher, List<FooHandshake> preallocatedHandshakes, int handshakesToWrite) throws IOException
   {
      for (int i = 0; i < handshakesToWrite; i++)
      {
         try
         {
            publisher.write(preallocatedHandshakes.get(sendIndex));
            sendIndex++;

            Thread.sleep(100);
         }
         catch (InterruptedException e)
         {
         }
      }
   }

   private class SubscriberListenerImpl implements SubscriberListener
   {
      private final SampleInfo info = new SampleInfo();
      public final FooHandshake[] receivedMessages = new FooHandshake[NUMBER_OF_MESSAGES_TO_SEND + 1];
      {
         for (int i = 0; i < receivedMessages.length; i++)
         {
            receivedMessages[i] = new FooHandshake();
         }
      }
      public int i = 0;

      @Override
      public void onNewDataMessage(Subscriber subscriber)
      {
         if (subscriber.takeNextData(receivedMessages[i++], info))
         {
            // do nothing
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
            fooGraphicObjectMessage.getYoVariableIndex().add(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
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
            fooGraphicObjectMessage.getYoVariableIndex().add(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
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
         fooYoRegistryDefinition.setParent(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
      }

      IDLSequence.Object<FooYoVariableDefinition> variables = fooHandshake.getVariables();
      for (int i = 0; i < 30000; i++)
      {
         FooYoVariableDefinition fooYoVariableDefinition = variables.add();
         fooYoVariableDefinition.setAllowNullValues(random.nextBoolean());
         fooYoVariableDefinition.setDescription("Diosfopjka" + i);
         fooYoVariableDefinition.setEnumType(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
         fooYoVariableDefinition.setIsParameter(random.nextBoolean());
         fooYoVariableDefinition.setLoadStatus(FooLoadStatus.FooLoaded);
         fooYoVariableDefinition.setMax(random.nextDouble());
         fooYoVariableDefinition.setMin(random.nextDouble());
         fooYoVariableDefinition.setRegistry(random.nextInt(CDR.UNSIGNED_SHORT_MAX));
         fooYoVariableDefinition.setType(FooYoType.FooDoubleYoVariable);
      }

      return fooHandshake;
   }
}
