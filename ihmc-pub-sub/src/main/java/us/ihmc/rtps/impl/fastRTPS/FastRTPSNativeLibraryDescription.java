package us.ihmc.rtps.impl.fastRTPS;

import us.ihmc.tools.nativelibraries.NativeLibraryDescription;
import us.ihmc.tools.nativelibraries.NativeLibraryWithDependencies;

class FastRTPSNativeLibraryDescription implements NativeLibraryDescription
{
   private final boolean useSystemFastRTPS;

   FastRTPSNativeLibraryDescription(boolean useSystemFastRTPS)
   {
      this.useSystemFastRTPS = useSystemFastRTPS;
   }

   @Override
   public String getPackage()
   {
      return "us.ihmc.rtps.impl.fastRTPS";
   }

   public NativeLibraryWithDependencies[] getLibrariesWithDependencies(Platform platform)
   {
      NativeLibraryWithDependencies[] libraries = new NativeLibraryWithDependencies[1];

      switch (platform)
      {
         case LINUX64:
            String library = "libFastRTPSWrapper.so";
            if (useSystemFastRTPS)
            {
               libraries[0] = NativeLibraryWithDependencies.fromFilename(library);
            }
            else
            {
               libraries[0] = NativeLibraryWithDependencies.fromFilename(library, "libfastrtps.so.1", "libfastcdr.so.1");
            }

            break;
         case WIN64:
            throw new RuntimeException("TODO: setup library loading for windows");
         default:
            throw new RuntimeException("PubsubImplemenation.FAST_RTPS: Unsupported platform: " + platform);
      }

      return libraries;

   }

}
