buildscript {
   dependencies {
      classpath("us.ihmc:ros2-msg-to-pubsub-generator:1.2.4")
   }
}

plugins {
   id("us.ihmc.ihmc-build")
   id("org.ajoberstar.grgit") version "4.1.1"
}

val rclInterfacesPath = "src/main/vendor/rcl_interfaces"
val rclInterfacesUrl = "https://github.com/ros2/rcl_interfaces.git"
val commonInterfacesPath = "src/main/vendor/common_interfaces"
val commonInterfacesUrl = "https://github.com/ros2/common_interfaces.git"
val ros2Release = "humble"
val geometry2Path = "src/main/vendor/geometry2"
val tf2Path = "src/main/vendor/geometry2/tf2_msgs"
val geometry2Url = "https://github.com/ros2/geometry2.git"
val geomtry2Release = "0.39.1"
val uuidPath = "src/main/vendor/unique_identifier_msgs"
val uuidUrl = "https://github.com/ros2/unique_identifier_msgs.git"
val uuidRelease = "2.7.0"

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   resourceDirectory("main", "custom-idl")
   resourceDirectory("main", "generated-idl")
   javaDirectory("main", "generated-java")
   resourceDirectory("main", "vendor")
   configurePublications()
}

mainDependencies {
   api("us.ihmc:euclid-geometry:0.22.5")
   api("us.ihmc:ihmc-pub-sub:source")
}

generatorDependencies {
   api("us.ihmc:ros2-msg-to-pubsub-generator:source")
}

val show by tasks.creating {
   doLast {
      project.gradle.includedBuilds.forEach { println(it) }
      buildscript.configurations.runtimeClasspath.get().forEach { println("Buildscript: " + it) }
      configurations.runtimeClasspath.get().forEach { println("Runtime classpath: " + it) }
   }
}

val generateMessages by tasks.creating(us.ihmc.ros2.rosidl.ROS2MessageGenerator::class) {
   doFirst {
      setupVendoredRepo(commonInterfacesPath, commonInterfacesUrl, ros2Release)
      setupVendoredRepo(rclInterfacesPath, rclInterfacesUrl, ros2Release)
      setupVendoredRepo(geometry2Path, geometry2Url, geomtry2Release)
      setupVendoredRepo(uuidPath, uuidUrl, uuidRelease)

      delete(file("src/main/vendor/rcl_interfaces/test_msgs"))

      // Patch for Image
      val imageMsg = file("$commonInterfacesPath/sensor_msgs/msg/Image.msg")
      val imageMsgContent = imageMsg.readText()
      val imageMsgContentUpdated = imageMsgContent.replace("uint8[] data", "uint8[<=10000000] data") // 10MB of data
      imageMsg.writeText(imageMsgContentUpdated)

      // Patch for CompressedImage
      val compressedImageMsg = file("$commonInterfacesPath/sensor_msgs/msg/CompressedImage.msg")
      val compressedImageMsgContent = compressedImageMsg.readText()
      val compressedImageMsgContentUpdated = compressedImageMsgContent.replace("uint8[] data", "uint8[<=3000000] data") // 3MB of data
      compressedImageMsg.writeText(compressedImageMsgContentUpdated)

      // Patch for PointCloud2
      val pointCloud2Msg = file("$commonInterfacesPath/sensor_msgs/msg/PointCloud2.msg")
      val pointCloud2MsgContent = pointCloud2Msg.readText()
      val pointCloud2MsgContentUpdated = pointCloud2MsgContent
            .replace("uint8[] data", "uint8[<=25000000] data") // 25MB of data
            .replace("PointField[] fields", "PointField[<=16] fields")
      pointCloud2Msg.writeText(pointCloud2MsgContentUpdated)
   }

   rosPackages = files(rclInterfacesPath, commonInterfacesPath, tf2Path, uuidPath)
   idlOutputDirectory = file("src/main/generated-idl")
   ros1OutputDirectory = file("src/main/generated-ros1")
   javaOutputDirectory = file("src/main/generated-java")
   customIDLDirectory = files("src/main/custom-idl")
}

for (allproject in project.allprojects)
   allproject.tasks.named<ProcessResources>("processResources") {
      duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

for (allproject in project.allprojects)
   allproject.tasks.named<Jar>("sourcesJar") {
      duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

fun setupVendoredRepo(clonePath: String, vcsUrl: String, tagName: String)
{
   delete(clonePath)

   if (!file(clonePath).exists())
   {
      org.ajoberstar.grgit.Grgit.clone {
         dir = file(clonePath)
         uri = vcsUrl
         refToCheckout = tagName
      }
   }
}
