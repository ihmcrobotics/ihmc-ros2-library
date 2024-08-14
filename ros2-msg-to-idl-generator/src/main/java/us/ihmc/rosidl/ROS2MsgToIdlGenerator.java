package us.ihmc.rosidl;

import org.python.core.Py;
import org.python.core.PyList;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ROS2MsgToIdlGenerator
{
   public static final boolean COMPILE_ROS_SERVICES = false;

   // Template to use
   private static final String MSG_TO_IDL_EM_TEMPLATE_NAME = "msg.idl.em";

   private final PythonInterpreter pythonInterpreter = new PythonInterpreter();
   private final Path templateDirectory;
   private final Path argumentsJsonFile;

   private final HashMap<String, RosPackageDescription> packageNameToDescriptionMap = new HashMap<>();

   public ROS2MsgToIdlGenerator()
   {
      argumentsJsonFile = createTempFile("rosInterfaceArguments", "arguments.json");
      templateDirectory = createTempDirectory("rosInterfaceCompilerTemplates");
      copyResourceToTempDirectory(templateDirectory, MSG_TO_IDL_EM_TEMPLATE_NAME);

      pythonInterpreter.exec("from rosidl_generator_dds_idl import generate_dds_idl");
   }

   /**
    * Add a directory with ros packages to the list of interfaces to be compiled.
    *
    * The expected directory structure is
    * - rootPath
    * - packageName
    * - package.xml
    *
    * A package xml with at least <name /> and optionally <build_depends />
    *
    * @param rootPath The root directory of packages to add
    * @param rclInterfacesToIgnore Optional array of packages to ignore
    * @throws IOException If the rootPath cannot be read
    */
   public void addPackageRoot(Path rootPath, String... rclInterfacesToIgnore) throws IOException
   {
      List<String> ignoredInterfaces;
      if (rclInterfacesToIgnore != null)
      {
         ignoredInterfaces = Arrays.asList(rclInterfacesToIgnore);
      }
      else
      {
         ignoredInterfaces = Collections.emptyList();
      }

      // Find all subdirectories with a package.xml in them and call this.addPackage()
      Path start = rootPath;
      int maxDepth = 2;
      BiPredicate<Path, BasicFileAttributes> matcher = (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().equals("package.xml");
      Predicate<Path> packageIsNotIgnored = path -> !ignoredInterfaces.contains(path.getParent().getFileName().toString());
      Files.find(start, maxDepth, matcher)
           .filter(packageIsNotIgnored)
           .forEach(packageXmlFilePath -> addPackage(packageXmlFilePath, packageNameToDescriptionMap));
   }

   /**
    * Add a ROS2 package to the list of packages to compile
    *
    * This function reads the package.xml to get the package name and list of dependencies.
    *
    * The .msg and .srv files to compile are found with a search in the directory.
    *
    * @param packageXmlFilePath the package.xml description
    */
   static void addPackage(Path packageXmlFilePath, HashMap<String, RosPackageDescription> packages)
   {
      try
      {
         // Read the XML file
         JAXBContext jaxbContext = JAXBContext.newInstance(RosPackage.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
         RosPackage rosPackage = (RosPackage) unmarshaller.unmarshal(packageXmlFilePath.toFile());

         // Create a package description
         RosPackageDescription packageDescription = new RosPackageDescription(rosPackage.getName(), packageXmlFilePath.getParent());
         if (rosPackage.getBuild_depend() != null)
         {
            packageDescription.getDependencies().addAll(rosPackage.getBuild_depend());
         }

         // Search for .msg and .srv files and add them to pkgDesc.msg and pkgDesc.srv respectivly
         try
         {
            Files.find(packageDescription.getPackageDirectory(), 2, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().endsWith(".msg"))
                 .forEach(path -> packageDescription.getMsgFilePaths().add(path));
            if (COMPILE_ROS_SERVICES)
            {
               Files.find(packageDescription.getPackageDirectory(), 2, (path, attrs) -> attrs.isRegularFile() && path.getFileName().toString().endsWith(".srv"))
                    .forEach(path -> packageDescription.getSrvFilePaths().add(path));
            }
         }
         catch (IOException e)
         {
            throw new RuntimeException(
                  "Cannot search folder " + packageDescription.getPackageDirectory() + " for package " + packageDescription.getPackageName(), e);
         }

         packages.put(packageDescription.getPackageName(), packageDescription);
      }
      catch (JAXBException e)
      {
         throw new RuntimeException("Cannot parse package.xml: " + packageXmlFilePath, e);
      }
   }

   /**
    * Convert all ROS2 packages to .idl files
    *
    * @param outputDirectory Directory to put the generated files in
    */
   public void convertToIDL(Path outputDirectory)
   {
      packageNameToDescriptionMap.forEach((name, pkg) -> convertPackageToIDL(pkg, outputDirectory));
   }

   private void convertPackageToIDL(RosPackageDescription packageDescription, Path outputDirectory)
   {
      HashSet<String> dependencies = new HashSet<>();
      addDependenciesRecursive(packageDescription, dependencies);

      List<Path> dependencyFiles = new ArrayList<>();
      for (String dependency : dependencies)
      {
         RosPackageDescription desc = packageNameToDescriptionMap.get(dependency);
         dependencyFiles.addAll(desc.getMsgFilePaths());
      }

      Path packageOutputDirectory = outputDirectory.resolve(packageDescription.getPackageName());

      // generate the json format the ros2 idl compiler requires
      setupAndWriteJythonJSONFile(packageDescription, dependencyFiles, packageOutputDirectory, templateDirectory, argumentsJsonFile);

      System.out.println("[ROS2 MSG -> IDL] Generating .idl files for " + packageDescription.getPackageName() + " in " + packageOutputDirectory);

      pythonInterpreter.set("argFile", new PyString(argumentsJsonFile.toAbsolutePath().toString()));

      PyList subFolderList = new PyList();
      subFolderList.add(new PyString("."));

      pythonInterpreter.set("subFolders", subFolderList);
      pythonInterpreter.set("extension", Py.None);
      pythonInterpreter.exec("generate_dds_idl(argFile, subFolders, extension)");
   }

   static void setupAndWriteJythonJSONFile(RosPackageDescription packageDescription,
                                           List<Path> dependencyFiles,
                                           Path packageOutputDirectory,
                                           Path templateDirectory,
                                           Path argumentsJsonFile)
   {
      JsonObjectBuilder json = Json.createObjectBuilder();

      // package_name is the name of the package
      json.add("package_name", packageDescription.getPackageName());
      // output_dir is the directory to write the files in. The ros2 idl compiler does not append the package name to this directory.
      json.add("output_dir", packageOutputDirectory.toAbsolutePath().toString());
      // directory where msg.idl.em can be found
      json.add("template_dir", templateDirectory.toAbsolutePath().toString());

      JsonArrayBuilder rosInterfaceFiles = Json.createArrayBuilder();
      for (Path msg : packageDescription.getMsgFilePaths())
      {
         rosInterfaceFiles.add(msg.toString());
      }
      for (Path srv : packageDescription.getSrvFilePaths())
      {
         rosInterfaceFiles.add(srv.toString());
      }

      // The ros interface files to compile
      json.add("ros_interface_files", rosInterfaceFiles);

      JsonArrayBuilder rosInterfaceDependencies = Json.createArrayBuilder();
      for (Path dep : dependencyFiles)
      {
         rosInterfaceDependencies.add(dep.toString());
      }

      // The ros interface files necessary to compile this interface
      json.add("ros_interface_dependencies", rosInterfaceDependencies);

      // Don't know what this flag does
      json.add("target_dependencies", Json.createArrayBuilder());
      // Don't know what this flag does
      json.add("additional_files", Json.createArrayBuilder());

      OutputStream os;
      try
      {
         os = Files.newOutputStream(argumentsJsonFile);
      }
      catch (IOException e)
      {
         throw new RuntimeException(e);
      }
      JsonWriter writer = Json.createWriter(os);
      writer.writeObject(json.build());
      writer.close();
   }

   /**
    * Recursive function to add all .msg files that are necessary to compile this package
    *
    * @param rosPackageDescription package description
    * @param dependencies Output set of dependencies
    */
   private void addDependenciesRecursive(RosPackageDescription rosPackageDescription, HashSet<String> dependencies)
   {
      for (String dependency : rosPackageDescription.getDependencies())
      {
         dependencies.add(dependency);
         if (packageNameToDescriptionMap.containsKey(dependency))
         {
            addDependenciesRecursive(packageNameToDescriptionMap.get(dependency), dependencies);
         }
         else
         {
            throw new RuntimeException("Cannot find dependency " + dependency + " for " + rosPackageDescription.getPackageName());
         }
      }
   }

   static Path createTempFile(String prefix, String suffix)
   {
      Path tempFile;
      try
      {
         tempFile = Files.createTempFile(prefix, suffix);
         tempFile.toFile().deleteOnExit();
      }
      catch (IOException e)
      {
         tempFile = null;
         e.printStackTrace();
      }
      return tempFile;
   }

   static Path createTempDirectory(String prefix)
   {
      Path tempDirectory;
      try
      {
         tempDirectory = Files.createTempDirectory(prefix);
         tempDirectory.toFile().deleteOnExit();
      }
      catch (IOException e)
      {
         tempDirectory = null;
         e.printStackTrace();
      }
      return tempDirectory;
   }

   static void copyResourceToTempDirectory(Path directory, String fileName)
   {
      try
      {
         InputStream template = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
         Path templateFile = directory.resolve(fileName);
         Files.copy(template, templateFile);

         templateFile.toFile().deleteOnExit();
         template.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
