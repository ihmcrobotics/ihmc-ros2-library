# Upgrading Fast-DDS
This is more of an advanced process and requires special care to ensure things work properly across all platforms.

## Checking out a new version of Fast-DDS, foonathan_memory_vendor
First, figure out what version of Fast-DDS to upgrade to. Generally, this can just be the latest stable release.
Then, find the latest release of foonathan_memory_vendor (https://github.com/eProsima/foonathan_memory_vendor).

Checkout the git submodules located in ihmc-pub-sub-repo/ihmc-pub-sub/thirdparty to the versions you selected. I.e.

```
cd ihmc-pub-sub/thirdparty/Fast-RTPS
git checkout <version>

cd ihmc-pub-sub/thirdparty/foonathan_memory_vendor
git checkout <version>
```

Commit these git submodule changes.

## Analyzing compilation procedure and dependencies
For each platform, you must ensure the compilation process has not changed.

Platforms:
- Linux x86_64
- Linux arm64
- Windows x86_64
- macOS x86_64
- macOS arm64

This can be done locally, in a virtual machine, in a GitHub runner (if you are patient), or elsewhere you can think of.
Follow the compilation steps in the build-natives.yml GitHub workflow for each platform and ensure they still work. Make changes
to the GitHub workflow if required.

The end result is that build-natives.yml should succeed for each platform when run on GitHub's own runners.

## Creating the xsd patch file
Java classes are generated from an xsd (XML) file located in the Fast-DDS upstream repository.
You can find that file here: https://github.com/eProsima/Fast-DDS/blob/7124ff87c4813bed26858fd89d3b915a5857dbc7/resources/xsd/fastRTPS_profiles.xsd

Our generation method doesn't work for all of the schema present in the xsd file. As such, we have to modify the file and create a patch. This patch
resides in ihmc-pub-sub-repo/ihmc-pub-sub/patches/fastRTPS_profiles.patch

In short summary, you must extract simpleTypes from complexTypes and ensure all types are named. Upstream, they declare
nested unnamed complexTypes, which doesn't work well with the generator.

The process is as follows:
- Modify ihmc-pub-sub-repo/ihmc-pub-sub/thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd until it generates all Java correctly and things compile Java-side
- Once you have success, create a copy of the modified xsd file somewhere
- git reset the submodule
- Create a diff between the modified file and the original file
- Place the diff (patch file) in ihmc-pub-sub/patches/fastRTPS_profiles.patch

## Cleanup
Lastly, bump the Fast-DDS version in the parent README.md file