plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.3"
   id("us.ihmc.ihmc-cd") version "1.26"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   resourceDirectory("main", "python")
   resourceDirectory("test", "generated-idl")
   resourceDirectory("test", "ros_msgs")
   configurePublications()
}

mainDependencies {
   api("org.glassfish:javax.json:1.0.4")
   api("org.python:jython-standalone:2.7.1")
   api("com.sun.xml.bind:jaxb-ri:4.0.5")
}
