package us.ihmc.pubsub.stats;

public class PubSubStatsTools
{
   public static String getHumanReadableDataSize(long numberOfBytes)
   {
      if (numberOfBytes < 1000)
         return "%d B".formatted(numberOfBytes);
      else if (numberOfBytes < 1000000)
         return "%.2f kB".formatted(numberOfBytes / 1000.0);
      else
         return "%.2f MB".formatted(numberOfBytes / 1000000.0);
   }
}
