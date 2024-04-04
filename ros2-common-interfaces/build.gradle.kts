buildscript {
   dependencies {
      classpath("us.ihmc:ros2-msg-to-pubsub-generator:0.24.0")
   }
}

plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.3"
   id("us.ihmc.ihmc-cd") version "1.26"
   id("org.ajoberstar.grgit") version "4.1.1"
}

val rclInterfacesPath = "src/main/vendor/rcl_interfaces"
val rclInterfacesUrl = "https://github.com/ros2/rcl_interfaces.git"
val commonInterfacesPath = "src/main/vendor/common_interfaces"
val commonInterfacesUrl = "https://github.com/ros2/common_interfaces.git"
val ros2Release = "0.8.0"
val geometry2Path = "src/main/vendor/geometry2"
val tf2Path = "src/main/vendor/geometry2/tf2_msgs"
val geometry2Url = "https://github.com/ros2/geometry2.git"
val geomtry2Release = "0.12.0"
val uuidPath = "src/main/vendor/unique_identifier_msgs"
val uuidUrl = "https://github.com/ros2/unique_identifier_msgs.git"
val uuidRelease = "2.1.0"

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
   api("us.ihmc:euclid-geometry:0.21.0")
   api("us.ihmc:ihmc-pub-sub:0.19.0")
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
   }

   rosPackages = files(rclInterfacesPath, commonInterfacesPath, tf2Path, uuidPath)
   idlOutputDirectory = file("src/main/generated-idl")
   ros1OutputDirectory = file("src/main/generated-ros1")
   javaOutputDirectory = file("src/main/generated-java")
   customIDLDirectory = files("src/main/custom-idl")
}

tasks.named<Copy>("processResources") {
    duplicatesStrategy = DuplicatesStrategy.WARN
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
