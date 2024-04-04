plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.3"
   id("us.ihmc.ihmc-cd") version "1.26"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-pub-sub:0.19.0")
   api("us.ihmc:ihmc-realtime:1.6.0")
   api("us.ihmc:ihmc-commons:0.32.0")

   api("us.ihmc:ros2-common-interfaces:source")
}

testDependencies {
   api("us.ihmc:ihmc-commons-test:0.32.0")
   api("us.ihmc:ros2-common-interfaces:source")
   api("us.ihmc:ros2-msg-to-pubsub-generator-test:source")
   api("com.google.guava:guava:18.0")
}
