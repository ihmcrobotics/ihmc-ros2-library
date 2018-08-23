package us.ihmc.pubsub.tools;

import us.ihmc.pubsub.participant.Participant;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;
import us.ihmc.pubsub.participant.ParticipantListener;

public class ParticipantListenerImpl implements ParticipantListener
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