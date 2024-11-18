import java.io.BufferedReader
import java.io.InputStreamReader

plugins {
   idea
   id("us.ihmc.ihmc-build")
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   javaDirectory("main", "../../swig/FastRTPS/generated")
   javaDirectory("xjc", "../xjc/java")
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-native-library-loader:2.0.3")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.22.2")
   api("us.ihmc:ihmc-commons:0.34.0")
   api("us.ihmc:log-tools:0.6.4")

   api(ihmc.sourceSetProject("xjc"))
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.34.0")
}

xjcDependencies {
   api("com.sun.xml.bind:jaxb-impl:4.0.5") // Match this version with YoVariables
}

fun runScript(scriptPath: String, envVars: Map<String, String> = emptyMap(), vararg args: String) {
   val command = listOf("bash", scriptPath) + args.toList()
   val processBuilder = ProcessBuilder(command)

   val environment = processBuilder.environment()
   environment.putAll(envVars)

   try {
      val process = processBuilder.start()

      val reader = BufferedReader(InputStreamReader(process.inputStream))
      val errorReader = BufferedReader(InputStreamReader(process.errorStream))

      Thread {
         var line: String?
         while (errorReader.readLine().also { line = it } != null) {
            System.err.println(line)
         }
      }.start()

      var line: String?
      while (reader.readLine().also { line = it } != null) {
         println(line)
      }

      val exitCode = process.waitFor()
      println("Script exited with code: $exitCode")

   } catch (e: Exception) {
      e.printStackTrace()
   }
}

val envVars = mapOf(
   "ONLY_CLONE_AND_PATCH" to "1"
)
runScript(projectDir.absolutePath + "/../cppbuild.bash", envVars)
