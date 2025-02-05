plugins {
   id("us.ihmc.ihmc-build")
}

ihmc {
   loadProductProperties("../group.gradle.properties")

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
   api("org.anarres:jcpp:1.4.14")
   api("us.ihmc:euclid:0.22.3")
   api("commons-codec:commons-codec:1.15")
}

testDependencies {
   api("us.ihmc:ihmc-pub-sub-test:source")
   api("us.ihmc:ihmc-commons-testing:0.35.1")
}

//
//task generateIDLElementTest(type: us.ihmc.idl.generator.IDLGeneratorTask) {
//   idlFiles = fileTree(dir: "src/test/idl")
//   includeDirs = files(".", "idl")
//   targetDirectory = file("src/test/generated-java")
//   packagePrefix = "us.ihmc.idl.generated"
//}
