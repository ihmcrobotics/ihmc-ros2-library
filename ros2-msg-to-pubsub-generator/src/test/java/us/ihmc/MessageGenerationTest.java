package us.ihmc;

import org.junit.Test;
import us.ihmc.commons.nio.FileTools;
import us.ihmc.continuousIntegration.ContinuousIntegrationTools;
import us.ihmc.ros2.rosidl.RosInterfaceGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MessageGenerationTest
{
   @Test(timeout = 30000)
   public void testMessageGeneration() throws IOException
   {
      Path startingPath;
      if (ContinuousIntegrationTools.isRunningOnContinuousIntegrationServer())
         startingPath = Paths.get("ros2-msg-to-pubsub-generator/src/test");
      else
         startingPath = Paths.get("");

      FileTools.deleteQuietly(startingPath.resolve("generated-java"));
      FileTools.deleteQuietly(startingPath.resolve("generated-idl"));

      RosInterfaceGenerator generator = new RosInterfaceGenerator();
      generator.addPackageRoot(startingPath.resolve("ros_msgs"));
      generator.addCustomIDLFiles(startingPath.resolve("custom-idl"));
      generator.generate(startingPath.resolve("generated-idl"), startingPath.resolve("generated-java"));
   }
}