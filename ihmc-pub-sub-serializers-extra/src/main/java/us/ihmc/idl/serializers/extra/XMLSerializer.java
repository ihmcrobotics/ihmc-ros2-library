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

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import us.ihmc.pubsub.TopicDataType;

/**
 * XML Serializer. Serializes IDL files to XML representation using Jackson
 * 
 * The XML serializer does not support data types with arrays and sequences due to limitations in the way XML files are read.
 * 
 * @author Jesper Smith
 *
 * @param <T> IDL element type
 */
public class XMLSerializer<T> extends AbstractSerializer<T>
{
   @JacksonXmlRootElement(localName = "TopicDataType")
   private static class Wrapper
   {
      @JacksonXmlProperty(localName = "name", isAttribute = true)
      private String name;

      @JacksonXmlProperty(localName = "TopicData", isAttribute = false)
      private ObjectNode payload;
   }

   private static ObjectMapper createXMLObjectMapper()
   {
      JacksonXmlModule module = new JacksonXmlModule();
      module.setDefaultUseWrapper(false);
      XmlMapper objectMapper = new XmlMapper(module);
      objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
      return objectMapper;
   }

   public XMLSerializer(TopicDataType<T> topicDataType)
   {
      super(topicDataType, createXMLObjectMapper());
   }

   @Override
   protected Object serialize(T data) throws IOException
   {
      Wrapper wrapper = new Wrapper();

      wrapper.name = topicDataType.getName();
      wrapper.payload = mapper.createObjectNode();
      topicDataType.serialize(data, new JacksonInterchangeSerializer(wrapper.payload, false));
      return wrapper;
   }

   @Override
   protected T deserialize(JsonNode root) throws IOException
   {
      String name = root.get("name").asText();
      JsonNode element = root.get("TopicData");

      if (topicDataType.getName().equals(name) && element != null && element.isObject())
      {
         JacksonInterchangeSerializer serializer = new JacksonInterchangeSerializer((ObjectNode) element, false);
         T data = topicDataType.createData();
         topicDataType.deserialize(serializer, data);
         return data;

      }
      else
      {
         return null;
      }

   }

}
