plugins {
   idea
   id("us.ihmc.ihmc-build")
   id("us.ihmc.ihmc-ci") version "8.3"
   id("us.ihmc.ihmc-cd") version "1.26"
   id("com.github.hierynomus.license") version "0.14.0"
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
   api("us.ihmc:ihmc-native-library-loader:2.0.3")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.21.0")
   api("us.ihmc:ihmc-commons:0.34.0")
   api("us.ihmc:log-tools:0.6.3")
   api("com.sun.xml.bind:jaxb-impl:4.0.5")
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.34.0")
}

configurations.create("xjc")
dependencies { "xjc"("com.sun.xml.bind:jaxb-xjc:4.0.5") }

// Cookie cutter function for defining multiple XJC tasks
fun addXjcTask(taskName: String, schema: String, pkg: String, dest: String) : Task {
   // If you haven't already, create the generated output dir before running XJC or it will fail
   file(dest).mkdirs()

   // The main XJC task, calls XJCFacade which is the entry point of the XJC JAR
   return tasks.create(taskName, JavaExec::class) {
      classpath = configurations["xjc"]
      mainClass.set("com.sun.tools.xjc.XJCFacade")

      // See https://docs.oracle.com/javase/9/tools/xjc.htm#JSWOR741 for full list of args
      args(schema, "-p", pkg, "-d", dest, "-no-header", "-quiet")
   }
}

var generateFastRTPSProfiles = addXjcTask(
   "generateFastRTPSProfiles",
   "thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd",
   "com.eprosima.xmlschemas.fastrtps_profiles",
   "build/generated/sources/xjc/java/main"
)

tasks.create<Exec>("applyPatches") {
   isIgnoreExitValue = true
   commandLine("patch", "-N", "thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd", "patches/fastRTPS_profiles.patch")
}

tasks.create<Exec>("updateSubmodules") {
   commandLine("git", "submodule", "update", "--init", "--recursive")
}

tasks.named("updateSubmodules") {
   dependsOn("applyPatches")
}

tasks.getByPath("compileJava").dependsOn("updateSubmodules")

tasks {
   compileJava.configure { dependsOn.add(generateFastRTPSProfiles) }
   named("sourceJar").configure { dependsOn.add(generateFastRTPSProfiles) }
}
