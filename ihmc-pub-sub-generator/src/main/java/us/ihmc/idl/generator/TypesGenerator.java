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

import com.eprosima.idl.generator.manager.TemplateManager;
import com.eprosima.idl.parser.tree.Module;
import com.eprosima.idl.parser.tree.*;
import com.eprosima.idl.parser.typecode.*;
import com.eprosima.log.ColorMessage;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Internal class for the code generator
 *
 * @author Jesper Smith
 */
class TypesGenerator
{
   private static final String PUB_SUB_TYPE_NAME = "PubSubType";

   private final HashMap<TypeCode, AbstractStructTypeCode> updatedTypes = new HashMap<>();
   private final ArrayList<Member> members = new ArrayList<>();
   private TemplateManager tmanager_ = null;
   private boolean replace_ = false;

   TypesGenerator(TemplateManager tmanager, boolean replace)
   {
      tmanager_ = tmanager;
      replace_ = replace;
   }

   /*
    * @brief This function generates data types in Java. It uses a context that
    * was processed by the IDL parser.
    */
   boolean generate(IDLContext context, String packagDir, String packag, Map<String, String> extensions)
   {
      ArrayList<Definition> definitions = context.getDefinitions();

      processAbstractDefinitions(definitions);

      StringTemplateGroup javaTypeTemplate = tmanager_.createStringTemplateGroup("JavaType");
      boolean returnedValue = processDefinitions(javaTypeTemplate, context, definitions, packagDir, packag, "", extensions);
      if (returnedValue)
      {
         StringTemplateGroup javaPubSubTypeTemplate = tmanager_.createStringTemplateGroup("JavaPubSubType");
         returnedValue = processDefinitions(javaPubSubTypeTemplate, context, definitions, packagDir, packag, PUB_SUB_TYPE_NAME, extensions);
      }

      return returnedValue;
   }

   private void processAbstractDefinitions(ArrayList<Definition> definitions)
   {
      if (definitions != null)
      {
         for (int i = 0; i < definitions.size(); i++)
         {
            Definition definition = definitions.get(i);

            if (definition.isIsModule())
            {
               Module module = (Module) definition;
               processAbstractDefinitions(module.getDefinitions());
            }
            else if (definition.isIsTypeDeclaration())
            {
               TypeDeclaration typedecl = (TypeDeclaration) definition;
               if (typedecl.getTypeCode().getKind() == TypeCode.KIND_STRUCT)
               {
                  boolean abstractAnnotation = typedecl.getAnnotations().containsKey("Abstract");
                  if (abstractAnnotation)
                  {
                     AbstractTypeDeclaration newDeclaration = new AbstractTypeDeclaration(typedecl);
                     definitions.set(i, newDeclaration);
                     updatedTypes.put(typedecl.getTypeCode(), (AbstractStructTypeCode) newDeclaration.getTypeCode());
                  }
                  members.addAll(((StructTypeCode) typedecl.getTypeCode()).getMembers());
               }
            }
         }

         for (Member member : members)
         {
            if (updatedTypes.containsKey(member.getTypecode()))
            {
               member.setTypecode(updatedTypes.get(member.getTypecode()));
            }
            else if (member.getTypecode().getKind() == TypeCode.KIND_SEQUENCE || member.getTypecode().getKind() == TypeCode.KIND_ARRAY)
            {
               ContainerTypeCode containerTypeCode = (ContainerTypeCode) member.getTypecode();
               if (containerTypeCode.getContentTypeCode().getKind() == TypeCode.KIND_STRUCT)
               {
                  for (AbstractStructTypeCode entry : updatedTypes.values())
                  {
                     if (entry.getIdlTypename().equals(containerTypeCode.getContentTypeCode().getIdlTypename()))
                     {
                        containerTypeCode.setContentTypeCode(entry);
                        break;
                     }
                  }
               }
            }
         }
      }
   }

   private boolean isInScope(IDLContext context, String filename)
   {
      Path input = Paths.get(context.getIDLFileName());
      Path current = Paths.get(filename);
      try
      {
         return Files.isSameFile(input, current);
      }
      catch (IOException e)
      {
         e.printStackTrace();
         return false; // Probably not the same file;
      }
   }

   private boolean processDefinitions(StringTemplateGroup stg_, IDLContext context, ArrayList<Definition> definitions, String packagDir, String packag,
                                      String moduleNamePostfix, Map<String, String> extensions)
   {
      if (definitions != null)
      {

         for (Definition definition : definitions)
         {
            if (definition.isIsModule())
            {
               Module module = (Module) definition;
               if (isInScope(context, module.getScopeFile()))
               {
                  // Create directory for module.
                  String outputDir = packagDir + module.getName();
                  File dir = new File(outputDir);

                  if (!dir.exists())
                  {
                     if (!dir.mkdir())
                     {
                        System.out.println(ColorMessage.error() + "Cannot create directory for module " + module.getName());
                        return false;
                     }
                  }

                  String packageName = packag.isEmpty() ? "" : (packag + ".");
                  if (!processDefinitions(stg_, context, module.getDefinitions(), outputDir + File.separator, packageName + module.getName(), moduleNamePostfix,
                                          extensions))
                     return false;
               }
            }
            else if (definition.isIsInterface())
            {
               Interface ifc = (Interface) definition;
               if (isInScope(context, ifc.getScopeFile()))
               {
                  // Create StringTemplate of the interface
                  StringTemplate ifcst = stg_.getInstanceOf("interface");
                  ifcst.setAttribute("ctx", context);
                  ifcst.setAttribute("parent", ifc.getParent());
                  ifcst.setAttribute("interface", ifc);

                  StringTemplate extensionst = null;
                  String extensionname = null;
                  if (extensions != null && (extensionname = extensions.get("interface")) != null)
                  {
                     extensionst = stg_.getInstanceOf(extensionname);
                     extensionst.setAttribute("ctx", context);
                     extensionst.setAttribute("parent", ifc.getParent());
                     extensionst.setAttribute("interface", ifc);
                     ifcst.setAttribute("extension", extensionst.toString());
                  }

                  if (processExports(stg_, context, ifc.getExports(), ifcst, extensions))
                  {
                     // Save file.
                     StringTemplate st = stg_.getInstanceOf("main");
                     st.setAttribute("ctx", context);
                     st.setAttribute("definitions", ifcst.toString());
                     st.setAttribute("package", (!packag.isEmpty() ? packag : null));

                     if (extensions != null && (extensionname = extensions.get("main")) != null)
                     {
                        extensionst = stg_.getInstanceOf(extensionname);
                        extensionst.setAttribute("ctx", context);
                        st.setAttribute("extension", extensionst.toString());
                     }

                     String fileName = packagDir + ifc.getName() + moduleNamePostfix + ".java";
                     System.out.println("[IDL -> PubSub] Generating " + fileName);
                     if (!writeFile(fileName, st))
                     {
                        System.out.println(ColorMessage.error() + "Cannot write file " + packagDir + ifc.getName() + ".java");
                        return false;
                     }
                  }
                  else
                     return false;
               }
            }
            else if (definition.isIsTypeDeclaration())
            {
               TypeDeclaration typedecl = (TypeDeclaration) definition;
               if (isInScope(context, typedecl.getScopeFile()))
               {

                  boolean abstractAnnotation = typedecl.getAnnotations().containsKey("Abstract");
                  boolean notEnumPubSubType = !moduleNamePostfix.equals(PUB_SUB_TYPE_NAME) || typedecl.getTypeCode().getKind() != TypeCode.KIND_ENUM;
                  boolean notAbstractDefinition = moduleNamePostfix.equals(PUB_SUB_TYPE_NAME) || !abstractAnnotation;

                  if (notEnumPubSubType && notAbstractDefinition)
                  {
                     // get StringTemplate of the structure
                     StringTemplate typest = processTypeDeclaration(stg_, context, typedecl, extensions);

                     if (typest != null)
                     {
                        // Save file.
                        StringTemplate st = stg_.getInstanceOf("main");
                        st.setAttribute("ctx", context);
                        st.setAttribute("definitions", typest.toString());
                        st.setAttribute("package", (!packag.isEmpty() ? packag : null));

                        StringTemplate extensionst = null;
                        String extensionname = null;
                        if (extensions != null && (extensionname = extensions.get("main")) != null)
                        {
                           extensionst = stg_.getInstanceOf(extensionname);
                           extensionst.setAttribute("ctx", context);
                           st.setAttribute("extension", extensionst.toString());
                        }

                        String fileName = packagDir + typedecl.getName() + moduleNamePostfix + ".java";
                        System.out.println("[IDL -> PubSub] Generating " + fileName);
                        if (!writeFile(fileName, st))
                        {
                           System.out.println(ColorMessage.error() + "Cannot write file " + packagDir + typedecl.getName() + ".java");
                           return false;
                        }
                     }
                  }
               }
            }
         }
      }

      return true;
   }

   boolean processExports(StringTemplateGroup stg_, IDLContext context, ArrayList<Export> exports, StringTemplate ifcst, Map<String, String> extensions)
   {
      for (Export export : exports)
      {
         if (export.isIsTypeDeclaration())
         {
            TypeDeclaration typedecl = (TypeDeclaration) export;

            // get StringTemplate of the structure
            StringTemplate typest = processTypeDeclaration(stg_, context, typedecl, extensions);

            if (typest != null)
            {
               // Add type stringtemplate to interface stringtemplate.
               ifcst.setAttribute("exports", typest.toString());
            }
         }
      }

      return true;
   }

   StringTemplate processTypeDeclaration(StringTemplateGroup stg_, IDLContext context, TypeDeclaration typedecl, Map<String, String> extensions)
   {
      StringTemplate typest = null, extensionst = null;
      String extensionname = null;

      if (typedecl.getTypeCode().getKind() == TypeCode.KIND_STRUCT)
      {
         typest = stg_.getInstanceOf("struct_type");
         typest.setAttribute("struct", typedecl.getTypeCode());
         if (typedecl.getAnnotations().containsKey("TypeCode"))
         {
            typest.setAttribute("typecode", getTypeCodeAnnotation(typedecl));
         }
         else
         {
            typest.setAttribute("typecode", ((StructTypeCode) typedecl.getTypeCode()).getScopedname());
         }
         // Get extension
         if (extensions != null && (extensionname = extensions.get("struct_type")) != null)
         {
            extensionst = stg_.getInstanceOf(extensionname);
            extensionst.setAttribute("struct", typedecl.getTypeCode());
         }
      }
      else if (typedecl.getTypeCode().getKind() == TypeCode.KIND_UNION)
      {
         typest = stg_.getInstanceOf("union_type");
         typest.setAttribute("union", typedecl.getTypeCode());

         if (typedecl.getAnnotations().containsKey("TypeCode"))
         {
            typest.setAttribute("typecode", getTypeCodeAnnotation(typedecl));
         }
         else
         {
            typest.setAttribute("typecode", ((UnionTypeCode) typedecl.getTypeCode()).getScopedname());
         }

         // Get extension
         if (extensions != null && (extensionname = extensions.get("union_type")) != null)
         {
            extensionst = stg_.getInstanceOf(extensionname);
            extensionst.setAttribute("union", typedecl.getTypeCode());
         }
      }
      else if (typedecl.getTypeCode().getKind() == TypeCode.KIND_ENUM)
      {
         typest = stg_.getInstanceOf("enum_type");
         typest.setAttribute("enum", typedecl.getTypeCode());

         if (typedecl.getAnnotations().containsKey("TypeCode"))
         {
            typest.setAttribute("typecode", getTypeCodeAnnotation(typedecl));
         }
         else
         {
            typest.setAttribute("typecode", ((EnumTypeCode) typedecl.getTypeCode()).getScopedname());
         }

         // Get extension
         if (extensions != null && (extensionname = extensions.get("enum_type")) != null)
         {
            extensionst = stg_.getInstanceOf(extensionname);
            extensionst.setAttribute("enum", typedecl.getTypeCode());
         }
      }

      if (typest != null)
      {
         // Generate extension
         if (extensionst != null)
         {
            extensionst.setAttribute("ctx", context);
            extensionst.setAttribute("parent", typedecl.getParent());
            typest.setAttribute("extension", extensionst.toString());
         }

         // Main stringtemplate
         typest.setAttribute("ctx", context);
         typest.setAttribute("parent", typedecl.getParent());
      }

      return typest;
   }

   private String getTypeCodeAnnotation(TypeDeclaration typedecl)
   {
      String raw = typedecl.getAnnotations().get("TypeCode").getValue("type");
      return raw.substring(1, raw.length() - 1);
   }

   private boolean writeFile(String file, StringTemplate template)
   {
      boolean returnedValue = false;

      try
      {
         File handle = new File(file);

         if (!handle.exists() || replace_)
         {
            FileWriter fw = new FileWriter(file);
            String data = template.toString();

            data = data.replaceAll("\r\n", "\n");
            fw.write(data, 0, data.length());
            fw.close();
         }
         else
         {
            System.out.println("INFO: " + file + " exists. Skipping.");
         }

         returnedValue = true;
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

      return returnedValue;
   }
}
