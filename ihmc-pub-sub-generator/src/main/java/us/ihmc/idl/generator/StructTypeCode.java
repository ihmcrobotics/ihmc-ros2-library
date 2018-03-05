/**
 * Copyright 2017 Florida Institute for Human and Machine Cognition (IHMC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Copyright 2016 Proyectos y Sistemas de Mantenimiento SL (eProsima).
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package us.ihmc.idl.generator;

import com.eprosima.idl.parser.tree.Annotation;
import com.eprosima.idl.parser.typecode.Member;
import org.antlr.stringtemplate.StringTemplate;

/**
 * Internal class for the code generator
 *
 * @author Jesper Smith
 */
class StructTypeCode extends com.eprosima.idl.parser.typecode.StructTypeCode
{
   private boolean istopic_ = true;

   public StructTypeCode(String scope, String name, String comments)
   {
      super(scope, name, comments);
   }

   public boolean isHasKey()
   {
      boolean returnedValue = false;

      for (int count = 0; count < getMembers().size() && !returnedValue; ++count)
      {
         Member member = getMembers().get(count);
         Annotation key = member.getAnnotations().get("Key");

         if (key != null)
         {
            String value = key.getValue("value");

            if (value != null && value.equals("true"))
               returnedValue = true;
         }
      }

      return returnedValue;
   }

   public String getAbstractimpl()
   {
      return null;
   }

   public boolean isAbstract()
   {
      return false;
   }

   public boolean isIsTopic()
   {
      return istopic_;
   }

   public void setIsTopic(boolean value)
   {
      istopic_ = value;
   }

   public String getPubsubTypename()
   {
      StringTemplate st = getJavaTypenameFromStringTemplate();
      st.setAttribute("name", getJavaScopedname() + "PubSubType");
      return st.toString();
   }
}