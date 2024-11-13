plugins {
   id("us.ihmc.ihmc-build")
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
   api("org.glassfish:javax.json:1.1.4")
   api("org.python:jython-standalone:2.7.1")
   api("com.sun.xml.bind:jaxb-impl:4.0.5")
}
