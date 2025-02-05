plugins {
   id("us.ihmc.ihmc-build")
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-pub-sub:source")
   api("us.ihmc:ihmc-realtime:1.7.0")
   api("us.ihmc:ihmc-commons:0.35.1")

   api("us.ihmc:ros2-common-interfaces:source")
}

testDependencies {
   api("us.ihmc:ihmc-commons-test:0.35.1")
   api("us.ihmc:ros2-common-interfaces:source")
   api("us.ihmc:ros2-msg-to-pubsub-generator-test:source")
   api("com.google.guava:guava:18.0")
}
