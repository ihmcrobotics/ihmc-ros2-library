plugins {
   id("us.ihmc.ihmc-build")
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "java-generated")
   resourceDirectory("test", "generated-idl")
   resourceDirectory("test", "custom-idl")
   resourceDirectory("test", "generated-ros1")
   javaDirectory("test", "generated-java")
   resourceDirectory("test", "ros_msgs")
   configurePublications()
}

mainDependencies {
   api(dependencies.gradleApi())
   api("us.ihmc:ihmc-pub-sub-generator:source")
   api("us.ihmc:ros2-msg-to-idl-generator:source")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub:source")
   api("us.ihmc:ihmc-commons:0.35.1")
}

for (allproject in project.allprojects)
   allproject.tasks.named<Jar>("sourcesJar") {
      duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
