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
package us.ihmc.pubsub.impl.fastRTPS;

import java.util.ArrayList;
import java.util.List;

import us.ihmc.pubsub.attributes.DurabilityKind;
import us.ihmc.pubsub.attributes.Locator;
import us.ihmc.pubsub.attributes.Locator.Kind;
import us.ihmc.pubsub.attributes.OwnerShipPolicyKind;
import us.ihmc.pubsub.attributes.PublishModeKind;
import us.ihmc.pubsub.attributes.ReliabilityKind;
import us.ihmc.pubsub.attributes.TopicAttributes.TopicKind;
import us.ihmc.rtps.impl.fastRTPS.*;

class FastRTPSCommonFunctions
{
   public static final int LOCATOR_KIND_RESERVED = 0;
   public static final int LOCATOR_KIND_UDPv4 = 1;
   public static final int LOCATOR_KIND_UDPv6 = 2;

}
