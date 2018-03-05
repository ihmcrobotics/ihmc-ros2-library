/*
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
package us.ihmc.idl.generator;

import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.tree.TypeDeclaration;
import com.eprosima.idl.parser.typecode.Member;
import org.antlr.stringtemplate.StringTemplate;

public class AbstractStructTypeCode extends StructTypeCode
{
   private final String abstractTypeName;
   private final String abstractImplementation;

   public AbstractStructTypeCode(TypeDeclaration declaration)
   {
      super(((StructTypeCode) declaration.getTypeCode()).getScope(), ((StructTypeCode) declaration.getTypeCode()).getName(), null);
      Annotation abstractAnnotation = declaration.getAnnotations().get("Abstract");
      if (abstractAnnotation == null)
      {
         throw new RuntimeException("No Abstract annotation");
      }
      String rawType = abstractAnnotation.getValue("type");
      this.abstractTypeName = rawType.substring(1, rawType.length() - 1);
      if (abstractAnnotation.getValue("impl") != null)
      {
         String rawImpl = abstractAnnotation.getValue("impl");
         this.abstractImplementation = rawImpl.substring(1, rawImpl.length() - 1);
      }
      else
      {
         this.abstractImplementation = "null";
      }

      for (Member member : ((StructTypeCode) declaration.getTypeCode()).getMembers())
      {
         addMember(member);
      }
   }

   @Override
   public String getJavaScopedname()
   {
      return abstractTypeName;
   }

   public String getAbstractimpl()
   {
      return abstractImplementation;
   }

   protected StringTemplate getJavaTypenameFromStringTemplate()
   {
      StringTemplate st = javatypesgr.getInstanceOf("type_" + Integer.toHexString(getKind()));
      st.setAttribute("package", "");
      return st;
   }

   @Override
   public String getPubsubTypename()
   {
      StringTemplate st = getJavaTypenameFromStringTemplate();
      st.setAttribute("package", javapackage);
      st.setAttribute("name", super.getJavaScopedname() + "PubSubType");
      return st.toString();
   }

   @Override
   public boolean isAbstract()
   {
      return true;
   }
}
