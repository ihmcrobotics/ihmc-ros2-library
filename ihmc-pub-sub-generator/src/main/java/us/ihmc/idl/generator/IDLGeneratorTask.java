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

import org.gradle.api.DefaultTask;
import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IDLGeneratorTask extends DefaultTask
{
   /**
    * [Required] Collection of IDL files to compile
    */
   public FileCollection idlFiles;

   /**
    * [Optional] Include directories used to resolve includes in IDL files
    */
   public FileCollection includeDirs;

   /**
    * [Optional] Prefix to the package path
    */
   public String packagePrefix = "";

   /**
    * [Required] output directory
    */
   public File targetDirectory;

   @TaskAction
   public void compile() throws IOException
   {
      if (idlFiles == null)
      {
         throw new IOException("No IDL files to compile.");
      }

      ArrayList<File> idlList = new ArrayList<>();
      for (File idl : idlFiles)
      {
         if (!idl.exists())
         {
            throw new IOException("Cannot find " + idl);
         }
         idlList.add(idl);
      }

      ArrayList<File> includeList = new ArrayList<>();
      if (includeDirs != null)
      {
         for (File include : includeDirs)
         {
            includeList.add(include);
         }
      }

      String packagePrefix = this.packagePrefix;
      if (packagePrefix == null)
      {
         packagePrefix = "";
      }

      if (targetDirectory == null)
      {
         throw new IOException("Target directory not set.");
      }

      if (!targetDirectory.exists())
      {
         throw new IOException("Target directory " + targetDirectory + " does not exist.");
      }
      if (!targetDirectory.isDirectory())
      {
         throw new IOException("Target directory " + targetDirectory + " is not a directory.");
      }

      for (File idl : idlList)
      {
         IDLGenerator.execute(idl, packagePrefix, targetDirectory, includeList);
      }
   }
}
