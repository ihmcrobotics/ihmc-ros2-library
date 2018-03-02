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
package us.ihmc.idl.generator;

import java.util.ArrayList;

/**
 * Internal class for the code generator
 *
 * @author Jesper Smith
 */
public class IDLContext extends Context
{
   private String m_package = "";
   private String m_onlypackage = "";
   private String m_packageDir = "";

   private String m_file;

   IDLContext(String onlyFileName, String idlFilename, ArrayList<String> arg2)
   {
      super(onlyFileName, idlFilename, arg2);
      this.m_file = idlFilename;

      createAnnotationDeclaration("startInclude", null);
      createAnnotationDeclaration("endInclude", null);
   }

   public String getIDLFileName()
   {
      return m_file;
   }

   public boolean isIsPackageEmpty()
   {
      return m_package.isEmpty();
   }

   public String getPackage()
   {
      return m_package;
   }

   public void setPackage(String pack)
   {
      if (pack != null && !pack.isEmpty())
      {
         m_package = pack;
         m_onlypackage = pack;
         m_packageDir = m_package.replace('.', '/');
      }
   }

   public String getOnlyPackage()
   {
      return m_onlypackage;
   }

   public String getPackageDir()
   {
      return m_packageDir;
   }

   public String getPackageUnder()
   {
      return m_package.replace('.', '_');
   }

   @Override
   public StructTypeCode createStructTypeCode(String name, String comments)
   {
      return new StructTypeCode(getScope(), name, comments);
   }

   public boolean isPrintexception()
   {
      return false;
   }

   public boolean isPrintoperation()
   {
      return false;
   }

   public String getProduct()
   {
      return "IHMC IDL Generator";
   }

   public String getNamespace()
   {
      return "fastcdr";
   }

   public boolean isCdr()
   {
      return true;
   }

   public boolean isFastcdr()
   {
      return false;
   }
}
