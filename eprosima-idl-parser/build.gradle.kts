plugins {
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "7.5"
   id("us.ihmc.ihmc-cd") version "1.21"
   id("me.champeau.gradle.antlr4") version "0.1"
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "generated-java")
   resourceDirectory("main", "antlr4")
   configurePublications()
}

mainDependencies {
   api("org.antlr:antlr4:4.2.2")
   api("org.antlr:stringtemplate:3.2")
   api("us.ihmc:ihmc-commons:0.30.4")
}

tasks.named("antlr4", me.champeau.gradle.Antlr4Task::class) {
   source = project.file("src/main/antlr4/omg")
   output = project.file("src/main/generated-java/com/eprosima/idl/parser/grammar")
   listener = false
   visitor = false
   extraArgs = listOf("-package", "com.eprosima.idl.parser.grammar")
}
