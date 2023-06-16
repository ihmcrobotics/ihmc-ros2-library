plugins {
   idea
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.1"
   id("us.ihmc.ihmc-cd") version "1.24"
   id("com.github.hierynomus.license") version "0.14.0"
   id("org.unbroken-dome.xjc") version "2.0.0"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "../../swig/FastRTPS/generated")
   javaDirectory("main", "../../build/generated/sources/xjc/java/main")
   configurePublications()
}

// For swig builds
//buildDir = 'build-java'

mainDependencies {
   api("us.ihmc:ihmc-native-library-loader:2.0.2")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.20.0")
   api("us.ihmc:ihmc-commons:0.32.0")
   api("us.ihmc:log-tools:0.6.3")
   api("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
   api("org.glassfish.jaxb:jaxb-runtime:2.3.2")
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.32.0")
}

sourceSets {
   main {
      xjcSchema {
         srcDir("thirdparty/Fast-RTPS/resources/xsd")
         include("fastRTPS_profiles.xsd")
         exclude("governance.xsd", "permissions.xsd")
      }
   }
}

tasks.create<Exec>("updateSubmodules") {
   commandLine("git", "submodule", "update", "--init", "--recursive")
}

tasks.getByPath("compileJava").dependsOn("updateSubmodules")

tasks {
   compileJava.configure { dependsOn.add(xjcGenerate) }
   named("sourceJar").configure { dependsOn.add(xjcGenerate) }
}
