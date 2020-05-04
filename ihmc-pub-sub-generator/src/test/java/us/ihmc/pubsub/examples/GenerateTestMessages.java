package us.ihmc.pubsub.examples;

import us.ihmc.commons.nio.FileTools;
import us.ihmc.idl.generator.IDLGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class GenerateTestMessages
{
   /**
    * Must be run from ihmc-pub-sub-group/ihmc-pub-sub-generator/src/test folder.
    */
   public static void main(String[] args) throws IOException
   {
      FileTools.deleteQuietly(Paths.get("generated-java"));

      /**
       * Generate Java types for all (*.idl) file in `src/test/idl` and put them in `src/test/generated-java`.
       */
      for (Path idl : Files.list(Paths.get("idl")).toArray(Path[]::new))
      {
         IDLGenerator.execute(idl.toFile(),
                              "us.ihmc.idl.generated",
                              Paths.get("generated-java").toFile(),
                              Arrays.asList(Paths.get("idl").toFile()));
      }
   }
}
