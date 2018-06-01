/**
 * Copyright 2018 Florida Institute for Human and Machine Cognition (IHMC)
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
package us.ihmc.idl.serializers.extra;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import us.ihmc.pubsub.TopicDataType;

/**
 * Java properties Serializer. Serializes IDL files to Java Properties representation using Jackson
 * 
 * By default, the type is not added to the serialized output.
 * 
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class PropertiesSerializer<T> extends AbstractSerializer<T>
{
   public PropertiesSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, new JavaPropsMapper());
      setAddTypeAsRootNode(false);
   }
}
