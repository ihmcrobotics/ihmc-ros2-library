package us.ihmc.ros2;

import com.google.common.base.CaseFormat;
import org.junit.jupiter.api.Test;
import std_msgs.msg.dds.*;
import us.ihmc.commons.MutationTestFacilitator;

import java.lang.String;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ROS2TopicTest
{
   static class ExampleTypeMessage
   {

   }

   @Test
   public void testEqualsAndHash()
   {
      ROS2Topic<?> topicName1 = new ROS2Topic<>().withPrefix("ihmc");
      ROS2Topic<?> topicName2 = new ROS2Topic<>().withPrefix("ihmc");

      assertEquals(topicName1, topicName2);

      HashMap<ROS2Topic<?>, Object> map = new HashMap<>();
      map.put(topicName1, null);
      map.put(topicName2, null);

      assertEquals(1, map.size());

      ROS2Topic<Int32> topicName3 = new ROS2Topic<>().withPrefix("ihmc").withTypeName(Int32.class);
      ROS2Topic<Int32> topicName4 = new ROS2Topic<>().withPrefix("ihmc").withTypeName(Int32.class);

      assertEquals(topicName1, topicName2);

      HashMap<ROS2Topic<?>, Object> map2 = new HashMap<>();
      map2.put(topicName3, null);
      map2.put(topicName4, null);

      assertEquals(1, map2.size());
   }

   @Test
   public void testROS2TopicName()
   {
      ROS2Topic<?> topicName = new ROS2Topic<>().withPrefix("ihmc")
                                                .withRobot("atlas")
                                                .withModule("rea")
                                                .withTypeName(ExampleTypeMessage.class)
                                                .withTypeName()
                                                .withSuffix("one");
      assertEquals("/ihmc/atlas/rea/example_type/one", topicName.toString());

      ROS2Topic<?> ihmcPrefixed = new ROS2Topic<>().withPrefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed.toString());
      ihmcPrefixed.withModule("hello");
      ihmcPrefixed.withRobot("robot_one");
      ihmcPrefixed.withTypeName(Int8.class);
      ihmcPrefixed.withSuffix("meow");
      ihmcPrefixed.withInput();
      ihmcPrefixed.withOutput();
      ihmcPrefixed.withIOQualifier("client");
      ihmcPrefixed.withIOQualifier("server");
      ihmcPrefixed.withQoS(ROS2QosProfile.RELIABLE());
      assertEquals("/ihmc", ihmcPrefixed.toString());

      assertEquals("/ihmc/cat/bengal_tiger", ihmcPrefixed.withModule("cat/bengal_tiger").getName());

      ROS2Topic<?> ihmcPrefixed2 = new ROS2Topic<>().withPrefix("ihmc");
      assertEquals("/ihmc", ihmcPrefixed2.toString());
      ROS2Topic<?> hello = ihmcPrefixed2.withModule("hello");
      ROS2Topic<?> robotOne = hello.withRobot("robot_one");
      ROS2Topic<Int8> int8 = robotOne.withTypeName(Int8.class);
      ROS2Topic<Int8> meow = int8.withSuffix("meow");
      ROS2Topic<?> input = meow.withInput();
      ROS2Topic<?> output = input.withOutput();

      assertEquals("/ihmc/hello", hello.toString());
      assertEquals("/ihmc/robot_one/hello", robotOne.toString());
      assertEquals("/ihmc/robot_one/hello/int8", int8.toString());
      assertEquals("/ihmc/robot_one/hello/int8/meow", meow.toString());
      assertEquals("/ihmc/robot_one/hello/input/int8/meow", input.toString());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow", output.toString());

      ROS2Topic<?> meowReliable = output.withQoS(ROS2QosProfile.RELIABLE());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow", meowReliable.toString());
      assertEquals(ROS2QosProfile.RELIABLE(), meowReliable.getQoS());
      assertNotEquals(output, meowReliable);

      ROS2Topic<?> meowBestEffort = meowReliable.withSuffix("meow_best_effort");
      assertEquals(ROS2QosProfile.RELIABLE(), meowBestEffort.getQoS());
      meowBestEffort = meowBestEffort.withQoS(ROS2QosProfile.BEST_EFFORT());
      assertEquals(ROS2QosProfile.BEST_EFFORT(), meowBestEffort.getQoS());
      assertEquals("/ihmc/robot_one/hello/output/int8/meow_best_effort", meowBestEffort.toString());

      assertEquals("/ihmc", output.withSuffix("").withIOQualifier(null).withModule(null).withRobot(null).clearTypeName().toString());
      assertEquals("", output.withPrefix(null).withIOQualifier(null).withSuffix("").withModule(null).withRobot(null).clearTypeName().toString());
   }

   @Test
   public void testRedundantModificationReturnsThis()
   {
      ROS2Topic<?> empty = new ROS2Topic<>();
      assertSame(empty, empty.withPrefix(""));
      assertSame(empty, empty.withRobot(""));
      assertSame(empty, empty.withModule(""));
      assertSame(empty, empty.withIOQualifier(""));
      assertSame(empty, empty.clearTypeName());
      assertSame(empty, empty.withSuffix(""));
      assertNotSame(empty, empty.withType(Bool.class));

      ROS2Topic<?> root = empty.withPrefix("ihmc");
      assertNull(root.getType());
      assertNotSame(root, root.withPrefix(""));
      assertSame(root, root.withPrefix("ihmc"));
      assertSame(root, root.withRobot(""));
      assertSame(root, root.withModule(""));
      assertSame(root, root.withIOQualifier(""));
      assertSame(root, root.clearTypeName());
      assertSame(root, root.withSuffix(""));
      assertNotSame(root, root.withType(Float32.class));

      ROS2Topic<Float64> float64Topic = root.withType(Float64.class);
      assertNotSame(float64Topic, float64Topic.withPrefix(""));
      assertSame(float64Topic, float64Topic.withRobot(""));
      assertSame(float64Topic, float64Topic.withModule(""));
      assertSame(float64Topic, float64Topic.withIOQualifier(""));
      assertSame(float64Topic, float64Topic.clearTypeName());
      assertSame(float64Topic, float64Topic.withSuffix(""));
      assertSame(float64Topic, float64Topic.withType(Float64.class));
   }

   @Test
   public void testExceptionsThrown()
   {
      ROS2Topic<?> root = new ROS2Topic<>().withPrefix("ihmc");
      assertThrows(RuntimeException.class, () -> root.withTypeName());
      assertThrows(RuntimeException.class, () -> root.withType(null));
      ROS2Topic<Bool> boolTopic = root.withType(Bool.class);
      assertThrows(RuntimeException.class, () -> root.withTopic(boolTopic));
      assertThrows(RuntimeException.class, () -> boolTopic.withTypeName(Int8.class));
      assertThrows(RuntimeException.class, () -> boolTopic.withType(Int8.class));
      assertDoesNotThrow(() -> boolTopic.withType(Bool.class));
      assertDoesNotThrow(() -> boolTopic.withTypeName(Bool.class));
      assertDoesNotThrow(() -> boolTopic.withTopic(boolTopic));

      ROS2Topic<Int8> int8Topic = root.withType(Int8.class);
      ROS2Topic<?> fooModule = new ROS2Topic<>().withModule("foo");
      ROS2Topic<Bool> fooBoolTopic = boolTopic.withTopic(fooModule);
      assertEquals("/ihmc/foo", fooBoolTopic.getName());
      assertThrows(RuntimeException.class, () -> boolTopic.withTopic(int8Topic));
      assertEquals(Int8.class, int8Topic.getType());

      assertFalse(boolTopic.equals(null));
      assertTrue(boolTopic.equals(boolTopic));
   }

   @Test
   public void testTypeNaming()
   {
      ROS2Topic<?> emptyTopic = new ROS2Topic<>();
      assertEquals("", emptyTopic.getName());

      ROS2Topic<?> withEmptyTypeNamed = new ROS2Topic<>().withType(Int8.class);
      assertEquals("", withEmptyTypeNamed.getName());

      ROS2Topic<?> typeNamed = new ROS2Topic<>().withTypeName(Int8.class).withTypeName();
      assertEquals("/int8", typeNamed.getName());

      ROS2Topic<?> usedTypeInName = new ROS2Topic<>().withType(Int8.class).withSuffix("int8_for_ui");
      assertEquals("/int8_for_ui", usedTypeInName.getName());

      ROS2Topic<?> withInput = typeNamed.withInput();
      assertEquals("/input/int8", withInput.getName());

      ROS2Topic<Object> atlas = new ROS2Topic<>().withRobot("atlas").withPrefix("/ihmc");
      assertEquals("/ihmc/atlas/input/int8", withInput.withTopic(atlas).getName());
   }

   @Test
   void testToROSTopicFormat()
   {
      compareAgainstGuava("", "");
      compareAgainstGuava("a", "a");
      compareAgainstGuava("a", "A");
      compareAgainstGuava("arm_trajectory", "ArmTrajectory");
      compareAgainstGuava("behavior_control_mode", "BehaviorControlMode");
      compareAgainstGuava("there_is_a_pine_tree", "ThereIsAPineTree");
      compareAgainstGuava("you_are_dah_best", "youAreDahBest");
      compareAgainstGuava("v2_forge", "V2Forge");
      compareAgainstGuava("v578_forge", "V578Forge");
      compareAgainstGuava("forge_v578", "ForgeV578");
      compareAgainstGuava("forge578", "Forge578");
      compareAgainstGuava("578_forge", "578Forge");

      String troublingString = "REAIsAnAcronymAndIsNotHandledByGuava";
      String guavaExpectedAnswer = "r_e_a_is_an_acronym_and_is_not_handled_by_guava";
      String rosTopicExpectedName = "rea_is_an_acronym_and_is_not_handled_by_guava";

      assertEquals(guavaExpectedAnswer, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, troublingString));
      assertEquals(rosTopicExpectedName, ROS2TopicNameTools.toROSTopicFormat(troublingString));

      troublingString = "TheAcronymIsAtTheEndREA";
      guavaExpectedAnswer = "the_acronym_is_at_the_end_r_e_a";
      rosTopicExpectedName = "the_acronym_is_at_the_end_rea";
      assertEquals(guavaExpectedAnswer, CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, troublingString));
      assertEquals(rosTopicExpectedName, ROS2TopicNameTools.toROSTopicFormat(troublingString));
   }

   private static void compareAgainstGuava(String expectedOutput, String stringToEvaluate)
   {
      String guavaOutput = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, stringToEvaluate);
      String ros2ToolsOutput = ROS2TopicNameTools.toROSTopicFormat(stringToEvaluate);
      assertEquals(guavaOutput, ros2ToolsOutput);
      assertEquals(expectedOutput, ros2ToolsOutput);
   }

   public static void main(String[] args)
   {
      MutationTestFacilitator.facilitateMutationTestForClass(ROS2Topic.class, ROS2TopicTest.class);
   }
}
