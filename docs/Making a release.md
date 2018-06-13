# Making a release

#### Step 1: Build native libs

Skip this step if the C++ side did not change, including the version of Fast-RTPS.

```
# clone Fast-RTPS and dependencies to specified version
> git submodule update --init --recursive
```

##### Linux

```
> !unfinshed command plz help! sudo apt install build-essential swig open-jdk-8-jdk

> mkdir build
> cd build
> cmake ..
> make 
> make install
```

##### Mac

Mac users should use [Homebrew](https://brew.sh/) to install required packages.

```
> !unfinshed command plz help! brew install build-essential swig open-jdk-8-jdk

> mkdir build
> cd build
> cmake ..
> make 
> make install
```

##### Windows

Install Visual Studio 2017 Community [https://www.visualstudio.com/downloads/](https://www.visualstudio.com/downloads/).
- Make sure to select "Desktop Development with C++" and select "MFC and ATL support (x86 and x64)" under Optional.

Windows users should use [Chocolatey](https://chocolatey.org/) to install required packages.

Hit windows key, type `cmd`, hit enter. Right-click `Command Prompt' and select "Run as administrator".

```
> choco install -y git swig cmake which

# get the location of swig.exe for later
> which swig
```

Hit windows key, type `x64 Native Tools Command Prompt for VS 2017`, hit enter. In `ihmc-pub-sub-group/ihmc-pub-sub`, run:

```
> mkdir build
> cd build
> cmake -G "Visual Studio 14 2015 Win64" -DSWIG_EXECUTABLE="\path\to\swig.exe" ..
> cmake --build . --config Release --target install
```

#### Step 2: Generate messages

Run `us.ihmc.pubsub.examples.GenerateTestMessages`, located in `ihmc-pub-sub-generator/src/test/java`.

Make sure the generated files have LF (Unix) line separators.

Note 1: You must run `GenerateTestMessages.main()` from the `ihmc-pub-sub-generator/src/test` directory.

Note 2: In IntelliJ, you may need to build with Eclipse compiler with "Build, no error check".

#### Step 3: Run tests

```
> cd /path/to/ihmc-pub-sub-group
> gradle compositeTask -PtaskName=test
```
Visit these urls to view test results:

```
file:///path/to/ihmc-pub-sub-group/ihmc-pub-sub/src/test/build/reports/tests/test/index.html
file:///path/to/ihmc-pub-sub-group/ihmc-pub-sub-generator/src/test/build/reports/tests/test/index.html
```

Note: Currently `IntraprocessLargeCopyTest3` is flaky. Run it in the IDE a few times to see if it passes.

#### Step 4: Touch up

- Git flow release via CLI or SmartGit. Use `release/X.X.X` as the branch name.
- Find and Replace old version with new version. Make sure to search over all files, not just *.gradle.
- Update README.md to reflect any changed procedures, new features, etc.

#### Step 5: Release

- Git flow finish release.

`gradle publishAll -PpublishUrl=ihmcRelease`