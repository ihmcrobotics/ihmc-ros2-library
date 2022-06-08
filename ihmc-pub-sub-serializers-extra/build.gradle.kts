plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.6"
   id("us.ihmc.ihmc-cd") version "1.23"
}

ihmc {
   loadProductProperties("../group.gradle.properties")
   
   	// Temporary for testing the new native library loader version
	repository("https://artifacts.halodi.com/repository/maven-open-source-group")
   

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
    api("us.ihmc:ihmc-pub-sub:source")
    api("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:2.13.0")
    api("org.codehaus.woodstox:woodstox-core-asl:4.1.4")
    api("de.undercouch:bson4jackson:2.13.0")
}

testDependencies {
    api("us.ihmc:ihmc-pub-sub-generator-test:source")
}
