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
package us.ihmc.pubsub;

import us.ihmc.pubsub.impl.intraprocess.IntraProcessDomain;
import us.ihmc.rtps.impl.fastRTPS.FastRTPSDomain;

public class DomainFactory
{
   public enum PubSubImplementation
   {
      FAST_RTPS, INTRAPROCESS;
   }
   
   public static synchronized Domain getDefaultDomain()
   {
      return getDomain(PubSubImplementation.FAST_RTPS);
   }
   
   public static synchronized Domain getDomain(PubSubImplementation impl)
   {
      switch(impl)
      {
      case FAST_RTPS:
         return FastRTPSDomain.getInstance();
      case INTRAPROCESS:
         return IntraProcessDomain.getInstance();
      default:
         throw new RuntimeException("Invalid implementation specified");
      }
   }
}
