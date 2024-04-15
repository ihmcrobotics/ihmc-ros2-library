package us.ihmc.pubsub.stats;

import us.ihmc.pubsub.attributes.CommonAttributes;

public class CommonStats
{
   /**
    * We have observed issues when messages are larger than this.
    */
   public static final int HIGH_PAYLOAD_LIMIT = 250000;

   private long numberOfEvents = 0;
   private long largestMessageSize = 0;
   private long currentMessageSize = 0;
   private long cumulativePayloadBytes = 0;
   private final PubSubRateCalculator eventFrequencyCalculator = new PubSubRateCalculator();
   private final PubSubRateCalculator bandwidthCalculator = new PubSubRateCalculator();
   private double publishFrequency = 0.0;
   private double bandwidth = 0.0;

   public void recordEvent()
   {
      ++numberOfEvents;
   }
   
   public void registerPayload(CommonAttributes attributes, int payloadSize)
   {
      currentMessageSize = payloadSize;

      if (payloadSize > largestMessageSize)
      {
         if (payloadSize > CommonStats.HIGH_PAYLOAD_LIMIT)
            PubSubStatsTools.printLargePayloadWarning(attributes, payloadSize);

         largestMessageSize = payloadSize;
      }

      cumulativePayloadBytes += payloadSize;
   }

   /** This should be called at a periodic rate. */
   public void update()
   {
      publishFrequency = eventFrequencyCalculator.finiteDifference(numberOfEvents);
      bandwidth = bandwidthCalculator.finiteDifference(cumulativePayloadBytes);
   }

   public long getNumberOfEvents()
   {
      return numberOfEvents;
   }

   public long getLargestMessageSize()
   {
      return largestMessageSize;
   }

   public long getCurrentMessageSize()
   {
      return currentMessageSize;
   }

   public double getEventFrequency()
   {
      return publishFrequency;
   }

   public double getBandwidth()
   {
      return bandwidth;
   }
}
