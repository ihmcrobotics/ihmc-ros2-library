package us.ihmc.pubsub.tools;

import us.ihmc.pubsub.common.SampleInfo;

public interface MessageCallback<T>
{
   void callback(T data, SampleInfo info);
}