plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.6"
   id("us.ihmc.ihmc-cd") version "1.23"
   id("com.github.hierynomus.license") version "0.14.0"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

	// Temporary for testing the new native library loader version
	repository("https://artifacts.halodi.com/repository/maven-open-source-group")
	

   configureDependencyResolution()
   resourceDirectory("main", "templates")
   javaDirectory("test", "generated-java")
   resourceDirectory("test", "idl")
   configurePublications()
}

app.entrypoint("IDLGenerator", "us.ihmc.idl.generator.IDLGenerator")

mainDependencies {
   api(dependencies.gradleApi())
   api("us.ihmc:eprosima-idl-parser:source")
   api("org.anarres:jcpp:1.4.12")
   api("us.ihmc:euclid:0.19.0")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub-test:source")
   api("us.ihmc:ihmc-commons-testing:0.30.6")
}

//
//task generateIDLElementTest(type: us.ihmc.idl.generator.IDLGeneratorTask) {
//   idlFiles = fileTree(dir: "src/test/idl")
//   includeDirs = files(".", "idl")
//   targetDirectory = file("src/test/generated-java")
//   packagePrefix = "us.ihmc.idl.generated"
//}
