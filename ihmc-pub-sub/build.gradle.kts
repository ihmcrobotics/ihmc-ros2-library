plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.6"
   id("us.ihmc.ihmc-cd") version "1.23"
   id("com.github.hierynomus.license") version "0.14.0"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "../../swig/FastRTPS/generated")
   configurePublications()
}

// For swig builds
//buildDir = 'build-java'

mainDependencies {
   api("us.ihmc:ihmc-native-library-loader:1.3.1")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.17.2")
   api("us.ihmc:ihmc-commons:0.30.6")
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.30.6")
}
