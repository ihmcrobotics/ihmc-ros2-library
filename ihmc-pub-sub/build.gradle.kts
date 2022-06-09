plugins {
   idea
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.6"
   id("us.ihmc.ihmc-cd") version "1.23"
   id("com.github.hierynomus.license") version "0.14.0"
   id("org.unbroken-dome.xjc") version "2.0.0"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

	
	// Temporary for testing the new native library loader version
	repository("https://artifacts.halodi.com/repository/maven-open-source-group")
	

   configureDependencyResolution()
   javaDirectory("main", "../../swig/FastRTPS/generated")
   configurePublications()
}

// For swig builds
//buildDir = 'build-java'

mainDependencies {
   api("us.ihmc:ihmc-native-library-loader:2.0.0-halodi2")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.17.2")
   api("us.ihmc:ihmc-commons:0.30.6")
   api("us.ihmc:log-tools:0.6.1")
   api("javax.xml.bind:jaxb-api:2.3.0")
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.30.6")
}

val generatedXSDSourcesPath = file("build/generated/sources/xjc/java/main")

sourceSets {
   main {
      xjcSchema {
         srcDir("thirdparty/Fast-RTPS/resources/xsd")
         include("fastRTPS_profiles.xsd")
         exclude("governance.xsd", "permissions.xsd")
      }
      java {
         srcDir(generatedXSDSourcesPath)
      }
   }
}

tasks {
   compileJava.configure { dependsOn.add(xjcGenerate) }
}

idea {
   module {
      generatedSourceDirs.add(generatedXSDSourcesPath)
   }
}