/**
 * Copyright 2024 Florida Institute for Human and Machine Cognition (IHMC)
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.LoaderOptions;
import us.ihmc.pubsub.TopicDataType;

/**
 * JSON Serializer. Serializes IDL files to YAML representation using Jackson
 * 
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class YAMLSerializer<T> extends AbstractSerializer<T>
{
   private static final LoaderOptions LOADER_OPTIONS;
   static {
      LOADER_OPTIONS = new LoaderOptions();
      LOADER_OPTIONS.setCodePointLimit((int) 2e24);
   }

   public YAMLSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, new ObjectMapper(YAMLFactory.builder().loaderOptions(LOADER_OPTIONS).build()));
   }
}
