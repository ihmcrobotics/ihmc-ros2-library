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

import us.ihmc.pubsub.common.DiscoveryStatus;
import us.ihmc.pubsub.participant.ParticipantDiscoveryInfo;

public class FastRTPSParticipantDiscoveryInfo extends ParticipantDiscoveryInfo
{
   private NativeParticipantListener participant;
   private long infoPtr;

   FastRTPSParticipantDiscoveryInfo()
   {
   }
   
   public void updateInfo(DISCOVERY_STATUS status, NativeParticipantListener nativeParticipantListener, long infoPtr, long guidHigh, long guidLow)
   {
      guid.fromPrimitives(guidHigh, guidLow);

      this.status = DiscoveryStatus.values[status.swigValue()];

      this.participant = nativeParticipantListener;
      this.infoPtr = infoPtr;
   }

   @Override
   public String getName()
   {
      return participant.getName(infoPtr);
   }

}
