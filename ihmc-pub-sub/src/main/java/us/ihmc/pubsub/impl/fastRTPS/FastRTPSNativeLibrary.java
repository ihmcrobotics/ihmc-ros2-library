package us.ihmc.pubsub.impl.fastRTPS;

import us.ihmc.tools.nativelibraries.NativeLibraryDescription;
import us.ihmc.tools.nativelibraries.NativeLibraryWithDependencies;

class FastRTPSNativeLibrary implements NativeLibraryDescription
{
   /**
    * Get the package name for the library
    * 
    * The CMake build puts the files in a subpackage for each OS/Architecture combination. If there is an unknown combination, 
    * just return the default and we will fail out on  getLibraryWithDependencies.
    */
   @Override
   public String getPackage(OperatingSystem os, Architecture arch)
   {
      String archPackage = "";
      switch (arch)
      {
         case x64:
            switch (os)
            {
               case WIN64:
                  archPackage = "Windows.AMD64";
                  break;

               case LINUX64:
                  archPackage = "Linux.x86_64";
                  break;

               case MACOSX64:
                  archPackage = "Darwin.x86_64";
                  break;

               default:
                  archPackage = "unknown";
                  break;
            }
            break;
         case arm64:
            switch (os)
            {
               case WIN64:
                  archPackage = "Windows.ARM64";
                  break;

               case LINUX64:
                  archPackage = "Linux.aarch64";
                  break;

               case MACOSX64:
                  archPackage = "Darwin.arm64";
                  break;

               default:
                  archPackage = "unknown";
                  break;
            }
            break;
      }

      return "ihmc-pub-sub.native." + archPackage;
   }

   @Override
   public NativeLibraryWithDependencies getLibraryWithDependencies(OperatingSystem os, Architecture arch)
   {

      switch (os)
      {
         case WIN64:
            return NativeLibraryWithDependencies.fromFilename("FastRTPSWrapper.dll", "fastcdr-2.2.dll", "fastrtps-2.14.dll");
         case LINUX64:
            return NativeLibraryWithDependencies.fromFilename("libFastRTPSWrapper.so", "libfastrtps.so.2.14", "libfastcdr.so.2");
         case MACOSX64:
            return NativeLibraryWithDependencies.fromFilename("libFastRTPSWrapper.jnilib", "libfastcdr.2.dylib", "libfastrtps.2.14.dylib");
         default:
            break;
      }

      System.err.println("Unsupported OS: " + os);
      return null;
   }
}
