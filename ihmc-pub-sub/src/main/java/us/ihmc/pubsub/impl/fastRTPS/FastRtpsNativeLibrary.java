package us.ihmc.pubsub.impl.fastRTPS;

import us.ihmc.tools.nativelibraries.NativeLibraryDescription;
import us.ihmc.tools.nativelibraries.NativeLibraryWithDependencies;

class FastRtpsNativeLibrary implements NativeLibraryDescription
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
      switch(arch)
      {
         case x64:
            switch(os)
            {
               case WIN64:
                  archPackage = "Windows-AMD64";
                  break;
                  
               case LINUX64:
                  archPackage = "Linux-x86_64";
                  break;
                  
               default:
                  archPackage = "unknown";
                  break;
            }
           break;
         case arm64:
            switch(os)
            {
               case WIN64:
                  archPackage = "Windows-ARM64";
                  break;
                  
               case LINUX64:
                  archPackage = "Linux-aarch64";
                  break;
                  
               default:
                  archPackage = "unknown";
                  break;
            }
            break;
      }
      
      
      return "us.ihmc.rtps.impl.fastRTPS." + archPackage;
   }

   @Override
   public NativeLibraryWithDependencies getLibraryWithDependencies(OperatingSystem os, Architecture arch)
   {

      switch (arch)
      {
         case x64:
            switch (os)
            {
               case WIN64:
                  return NativeLibraryWithDependencies.fromFilename("FastRTPSWrapper.dll",
                                                                                                         "fastcdr-1.0.dll",
                                                                                                         "fastrtps-2.6.dll");
               case LINUX64:
                  return NativeLibraryWithDependencies.fromFilename("libFastRTPSWrapper.so", "libfastrtps.so.2.6", "libfastcdr.so.1");
               default:
                  break;
            }
         case arm64:
            switch (os)
            {
               default:
                  break;
            }

            break;
      }

      System.err.println("Unsupported OS/Architecture combination: " + os + " " + arch);
      return null;

   }

}