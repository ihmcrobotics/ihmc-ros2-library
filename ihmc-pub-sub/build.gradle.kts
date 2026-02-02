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
   configurePublications()
}

mainDependencies {
   api("us.ihmc:ihmc-native-library-loader:2.0.6")
   api("net.sf.trove4j:trove4j:3.0.3")
   api("us.ihmc:euclid:0.22.5")
   api("us.ihmc:ihmc-commons:0.35.1")
   api("us.ihmc:log-tools:0.6.4")

   // JavaCPP used for backing native memory pointers
   val javacppVersion = "1.5.11"
   api("org.bytedeco:javacpp:$javacppVersion")
   api("org.bytedeco:javacpp:$javacppVersion:linux-arm64")
   api("org.bytedeco:javacpp:$javacppVersion:linux-x86_64")
   api("org.bytedeco:javacpp:$javacppVersion:windows-x86_64")
   // TODO: macOS

   api(ihmc.sourceSetProject("xjc"))
}

testDependencies {
   api("us.ihmc:ihmc-commons-testing:0.35.1")
}

xjcDependencies {
   api("com.sun.xml.bind:jaxb-impl:4.0.5") // Match this version with YoVariables
}

fun runScript(scriptPath: String, envVars: Map<String, String> = emptyMap(), vararg args: String) {
   val isWindows = System.getProperty("os.name").lowercase().contains("win")
   val bashCommand = if (isWindows) "C:\\Program Files\\Git\\git-bash.exe" else "bash"

   val command = listOf(bashCommand, scriptPath) + args.toList()
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
//runScript(projectDir.absolutePath + "/../cppbuild.bash", envVars)
