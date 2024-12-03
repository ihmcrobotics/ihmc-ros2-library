package us.ihmc.ros2;

import org.junit.jupiter.api.Test;
import us.ihmc.ros2.ROS2NodeBuilder.SpecialTransportMode;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2NodeBuilderTest
{
   @Test
   public void createAndDestroyTest()
   {
      int domainId = 1;
      SpecialTransportMode specialTransportMode = SpecialTransportMode.INTRAPROCESS_ONLY;
      String namespace = "/test/test";
      boolean useSharedMemory = true;
      String nodeName = "test_node";

      ROS2Node node = new ROS2NodeBuilder().domainId(domainId)
                                           .specialTransportMode(specialTransportMode)
                                           .namespace(namespace)
                                           .useSharedMemory(useSharedMemory)
                                           .build(nodeName);

      assertEquals(domainId, node.getProfile().getDomainId());
      assertEquals(specialTransportMode, node.getSpecialTransportMode());
      assertEquals(namespace, node.getNamespace());
      assertEquals(nodeName, node.getName());

      node.destroy();
   }
}
