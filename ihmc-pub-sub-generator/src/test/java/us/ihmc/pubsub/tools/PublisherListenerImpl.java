package us.ihmc.pubsub.tools;

import us.ihmc.pubsub.common.MatchingInfo;
import us.ihmc.pubsub.publisher.Publisher;
import us.ihmc.pubsub.publisher.PublisherListener;

public class PublisherListenerImpl implements PublisherListener
{
   @Override
   public void onPublicationMatched(Publisher publisher, MatchingInfo info)
   {
      System.out.println("New subscriber matched");
      System.out.println("Status: " + info.getStatus());
      System.out.println("Guid: " + info.getGuid().toString());
   }
}