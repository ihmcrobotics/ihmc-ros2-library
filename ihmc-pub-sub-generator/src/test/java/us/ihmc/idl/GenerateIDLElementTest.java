package us.ihmc.idl;

import us.ihmc.idl.generator.IDLGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GenerateIDLElementTest
{
   /**
    * Must be run from $MODULE_DIR$!!!
    */
   public static void main(String[] args) throws IOException
   {
      ArrayList<File> idlList = new ArrayList<>();

      Path idlPath = Paths.get("idl");

      System.out.println(idlPath.toAbsolutePath());

      for (Path idl : Files.list(idlPath).toArray(Path[]::new))
      {
         idlList.add(idl.toFile());
      }

      ArrayList<File> includeList = new ArrayList<>();
      includeList.add(Paths.get(".").toFile());
      includeList.add(Paths.get("idl").toFile());

      String packagePrefix = "us.ihmc.idl.generated";

      File targetDirectory = new File("generated-java");

      for (File idl : idlList)
      {
         IDLGenerator.execute(idl, packagePrefix, targetDirectory, includeList);
      }
   }
}
