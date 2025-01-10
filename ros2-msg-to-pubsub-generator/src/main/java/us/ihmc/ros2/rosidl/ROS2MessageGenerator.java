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
package us.ihmc.ros2.rosidl;

import org.gradle.api.DefaultTask;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * To be used in Gradle scripts to generate ROS 2 messages.
 */
public class ROS2MessageGenerator extends DefaultTask
{
   /**
    * [Required] List of directories containing ros packages
    */
   public FileCollection rosPackages;

   /**
    * [Required] Generated Java output directory
    */
   public File javaOutputDirectory;

   /**
    * [Required] Generated IDL output directory
    */
   public File idlOutputDirectory;

   /**
    * [Required] Generated ROS 1 output directory
    */
   public File ros1OutputDirectory;

   /**
    * [Optional] List of directories containing custom .idl files that override the generated ones
    */
   public FileCollection customIDLDirectory;

   public List<Configuration> configurations = new ArrayList<>();
   public List<String> artifactIds = new ArrayList<>();
   public List<File> locations = new ArrayList<>();
   
   public List<String> ignoredPackages = new ArrayList<String>();

   public void artifactDependency(Configuration configuration, String artifactId, File location)
   {
      configurations.add(configuration);
      artifactIds.add(artifactId);
      locations.add(location);
   }

//   private WorkResult copyClosure()
//   {
//
//      return WorkResults.didWork(true);
//   }

   @TaskAction
   public void generateMessages() throws IOException
   {
      if (rosPackages == null)
      {
         throw new IOException("Please set rosPackages = files(\"path/to/package\")");
      }

      if (javaOutputDirectory == null)
      {
         throw new IOException("Please set javaOutputDirectory = files(\"path/to/java/output\")");
      }

      if(ros1OutputDirectory == null)
      {
         throw new IOException("Please set ros1OutputDirectory = files(\"path/to/ros1/output\")");
      }

      if (javaOutputDirectory.exists() && !javaOutputDirectory.isDirectory())
      {
         throw new IOException("Output directory exists but is not a directory");
      }

      if (idlOutputDirectory == null)
      {
         idlOutputDirectory = new File(getTemporaryDir(), "idl");
      }

//      locations.forEach(location -> getProject().delete(location));
//
//      for (int i = 0; i < configurations.size(); i++)
//      {
//         boolean foundDependency = false;
//         getProject().copy(new MethodClosure(this, "copyClosure"));
////         getProject().zipTree()
//      }


      getProject().delete(javaOutputDirectory);
      getProject().delete(idlOutputDirectory);

      ROS2InterfaceGenerator generator = new ROS2InterfaceGenerator();

      String[] ignoredPackagesArray = ignoredPackages.toArray(new String[ignoredPackages.size()]);
      for (File rosPackage : rosPackages)
      {
         generator.addPackageRootToIDLGenerator(rosPackage.toPath(), ignoredPackagesArray);
      }

      if (customIDLDirectory != null)
      {
         for (File custom : customIDLDirectory)
         {
            generator.addCustomIDLFiles(custom.toPath());
         }
      }

      generator.generate(idlOutputDirectory.toPath(), ros1OutputDirectory.toPath(), javaOutputDirectory.toPath());

      ROS2InterfaceGenerator.convertDirectoryToUnixEOL(idlOutputDirectory.toPath());
      ROS2InterfaceGenerator.convertDirectoryToUnixEOL(javaOutputDirectory.toPath());
   }
}
