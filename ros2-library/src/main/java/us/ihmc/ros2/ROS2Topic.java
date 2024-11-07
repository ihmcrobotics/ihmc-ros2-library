package us.ihmc.ros2;

import java.util.Objects;

import static us.ihmc.ros2.ROS2TopicNameTools.messageTypeToTopicNamePart;
import static us.ihmc.ros2.ROS2TopicNameTools.processTopicNamePart;

/**
 * <p>
 * A ROS 2 topic, represented as a String builder with a type. It is designed to be an immutable class with
 * equals, hashCode, and toString support.
 * </p>
 * <p>The immutable methods start with "with".</p>
 * <p>It considers a ROS 2 topic name to be 6 string parts put together:</p>
 * <ul>
 *    <li>prefix</li>
 *    <li>robot name</li>
 *    <li>module name</li>
 *    <li>io qualifier</li>
 *    <li>type name</li>
 *    <li>suffix</li>
 * </ul>
 * <p>
 * The toString() method and the getName() methods evaluate to the topic name i.e. /ihmc/controller/output/status
 * </p>
 * <p>
 * It also is parameterized by type. This type is used to enforce topic type safety and
 * increase the usefulness of helper methods.
 * <p>
 * Before the message type is known, for example the IHMC_ROOT topic in ROS2Tools,
 * the user would use the ? as ROS2Topic<?> to say the type has not yet been decided.
 * </p>
 * <p>
 * The standard usage of this class would be:
 * <pre>
 *    // evaluates to "/ihmc/atlas/rea/example_type/one"
 *    ROS2Topic topicName = new ROS2Topic().withPrefix("ihmc").withRobot("atlas").withModule("rea")
 *                                            .withType(ExampleTypeMessage.class).withTypeName().withSuffix("one");
 *
 *    // use of immutable property
 *    // evaluates to "/ihmc"
 *    ROS2Topic ihmcPrefixed = new ROS2Topic().withPrefix("ihmc");
 *    // evaluates to "/ihmc/hello"
 *    ROS2Topic hello = ihmcPrefixed.withModule("hello");
 * </pre>
 *
 * @param <T>
 */
public class ROS2Topic<T>
{
   public static final String INPUT = "input";
   public static final String OUTPUT = "output";

   private final String prefix;
   private final String robotName;
   private final String moduleName;
   private final String ioQualifier;
   private final String typeName;
   private final String suffix;
   private final Class<T> messageType;
   /** Allows a QoS to be carried along with the topic to keep boilerplate to a minimum. */
   private final ROS2QosProfile qos;

   public ROS2Topic() // TODO make private and provide static root name method?
   {
      prefix = "";
      robotName = "";
      moduleName = "";
      ioQualifier = "";
      typeName = "";
      suffix = "";
      messageType = null;
      qos = ROS2QosProfile.DEFAULT();
   }

   private ROS2Topic(String prefix,
                     String robotName,
                     String moduleName,
                     String ioQualifier,
                     String typeName,
                     String suffix,
                     Class<T> messageType,
                     ROS2QosProfile qos)
   {
      this.prefix = prefix;
      this.robotName = robotName;
      this.moduleName = moduleName;
      this.ioQualifier = ioQualifier;
      this.typeName = typeName;
      this.suffix = suffix;
      this.messageType = messageType;
      this.qos = qos;
   }

   private ROS2Topic<T> copyIfNotEqual(String prefix,
                                       String robotName,
                                       String moduleName,
                                       String ioQualifier,
                                       String typeName,
                                       String suffix,
                                       Class<T> messageType,
                                       ROS2QosProfile qos)
   {
      if (equals(prefix, robotName, moduleName, ioQualifier, typeName, suffix, messageType, qos))
      {
         return this;
      }
      else
      {
         return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, typeName, suffix, messageType, qos);
      }
   }

   public ROS2Topic<T> withPrefix(String prefix)
   {
      return copyIfNotEqual(processTopicNamePart(prefix), robotName, moduleName, ioQualifier, typeName, suffix, messageType, qos);
   }

   public ROS2Topic<T> withRobot(String robotName)
   {
      return copyIfNotEqual(prefix, processTopicNamePart(robotName), moduleName, ioQualifier, typeName, suffix, messageType, qos);
   }

   // TODO: Allow multiple parts as String... that gets turned into part1/part2/part3
   public ROS2Topic<T> withModule(String moduleName)
   {
      return copyIfNotEqual(prefix, robotName, processTopicNamePart(moduleName), ioQualifier, typeName, suffix, messageType, qos);
   }

   public ROS2Topic<T> withInput()
   {
      return withIOQualifier(INPUT);
   }

   public ROS2Topic<T> withOutput()
   {
      return withIOQualifier(OUTPUT);
   }

   public ROS2Topic<T> withIOQualifier(String ioQualifier)
   {
      return copyIfNotEqual(prefix, robotName, moduleName, processTopicNamePart(ioQualifier), typeName, suffix, messageType, qos);
   }

   public ROS2Topic<T> withTypeName()
   {
      if (messageType == null)
      {
         throw new RuntimeException("This topic does not have a type yet. Cannot add type name");
      }
      return copyIfNotEqual(prefix, robotName, moduleName, ioQualifier, processTopicNamePart(messageTypeToTopicNamePart(messageType)), suffix, messageType, qos);
   }

   public ROS2Topic<T> clearTypeName()
   {
      return copyIfNotEqual(prefix, robotName, moduleName, ioQualifier, "", suffix, messageType, qos);
   }

   public ROS2Topic<T> withSuffix(String suffix)
   {
      return copyIfNotEqual(prefix, robotName, moduleName, ioQualifier, typeName, processTopicNamePart(suffix), messageType, qos);
   }

   public ROS2Topic<T> withQoS(ROS2QosProfile qos)
   {
      return copyIfNotEqual(prefix, robotName, moduleName, ioQualifier, typeName, processTopicNamePart(suffix), messageType, qos);
   }

   public <K> ROS2Topic<K> withType(Class<K> messageType)
   {
      if (messageType == null)
      {
         throw new RuntimeException("Cannot change the type of a topic to null");
      }
      else if (this.messageType == null)
      {
         return new ROS2Topic<>(prefix, robotName, moduleName, ioQualifier, typeName, suffix, messageType, qos);
      }
      else if (Objects.equals(messageType, this.messageType))
      {
         return (ROS2Topic<K>) this;
      }
      else
      {
         throw new RuntimeException("Cannot change the type of a topic after it's already been set");
      }
   }

   public <K> ROS2Topic<K> withTypeName(Class<K> messageType)
   {
      return withType(messageType).withTypeName();
   }

   /**
    * If this topic doesn't have a value for a field, take the value from the passed topic.
    * We always take the passed in topic's QoS setting.
    * @param topic to fill in the blanks with
    */
   public ROS2Topic<T> withTopic(ROS2Topic<?> topic)
   {
      String newPrefix = takeSecondIfFirstEmpty(prefix, topic.prefix);
      String newRobotName = takeSecondIfFirstEmpty(robotName, topic.robotName);
      String newModuleName = takeSecondIfFirstEmpty(moduleName, topic.moduleName);
      String newIOQualifier = takeSecondIfFirstEmpty(ioQualifier, topic.ioQualifier);
      String newTypeName = takeSecondIfFirstEmpty(typeName, topic.typeName);
      String newSuffix = takeSecondIfFirstEmpty(suffix, topic.suffix);
      ROS2QosProfile newQoS = topic.getQoS();
      if (topic.messageType != null && !topic.messageType.equals(messageType))
      {
         throw new RuntimeException("Cannot change the type of a topic with the withTopic method");
      }
      return new ROS2Topic<>(newPrefix, newRobotName, newModuleName, newIOQualifier, newTypeName, newSuffix, messageType, newQoS);
   }

   private String takeSecondIfFirstEmpty(String first, String second)
   {
      if (first.isEmpty())
      {
         return second;
      }
      else
      {
         return first;
      }
   }

   public Class<T> getType()
   {
      return messageType;
   }

   public ROS2QosProfile getQoS()
   {
      return qos;
   }

   public String getName()
   {
      return toString();
   }

   @Override
   public String toString()
   {
      String topicName = "";
      topicName += prefix;
      topicName += robotName;
      topicName += moduleName;
      topicName += ioQualifier;
      topicName += typeName;
      topicName += suffix;
      return topicName;
   }

   @Override
   public boolean equals(Object other)
   {
      if (this == other)
         return true;
      if (other == null || getClass() != other.getClass())
         return false;
      ROS2Topic<?> otherTopic = (ROS2Topic<?>) other;
      return equals(otherTopic.prefix,
                    otherTopic.robotName,
                    otherTopic.moduleName,
                    otherTopic.ioQualifier,
                    otherTopic.typeName,
                    otherTopic.suffix,
                    otherTopic.messageType,
                    otherTopic.qos);
   }

   private boolean equals(String prefix,
                          String robotName,
                          String moduleName,
                          String ioQualifier,
                          String typeName,
                          String suffix,
                          Class<?> messageType,
                          ROS2QosProfile qos)
   {
      return Objects.equals(this.prefix, prefix) &&
             Objects.equals(this.robotName, robotName) &&
             Objects.equals(this.moduleName, moduleName) &&
             Objects.equals(this.ioQualifier, ioQualifier) &&
             Objects.equals(this.typeName, typeName) &&
             Objects.equals(this.suffix, suffix) &&
             Objects.equals(this.messageType, messageType) &&
             Objects.equals(this.qos, qos);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(prefix, robotName, moduleName, ioQualifier, typeName, suffix, messageType, qos);
   }
}
