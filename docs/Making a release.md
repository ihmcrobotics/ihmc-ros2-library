# Making a release

#### Step 1: Run cppbuild.sh

Run cppbuild.sh from the repository root directory. This will apply a required patch file to upstream Fast-DDS xsd profiles and attempt to compile the native library.
This is mainly just for applying that patch file, if there are missing libraries on your system and it doesn't compile, that's fine. The native compilation happens on github runners anyway.

#### Step 2: Make sure compileJava works after running cppbuild.sh

gradle compositeTask -PtaskName=compileJava

#### Step 1: Generate messages (Only if test messages changed. Only affects tests.)

Run `us.ihmc.pubsub.examples.GenerateTestMessages` 
with `ihmc-pub-sub-generator/src/test` set as the working directory.

> Note: If using IntelliJ, this might require "Build, no error check"

Make sure the generated files have LF (Unix) line separators.

#### Step 2: Ensure tests are passing in CI

Go to the GitHub actions and make sure the gradle test workflow is passing on the develop branch

#### Step 3: Update version

In `ihmc-pub-sub-group/group.gradle.properties`, up the version number.

#### Step 4: Publish artifacts

Publish artifacts to Maven Central.

`gradle compositePublish -PpublishUrl=ihmcRelease`

Check when they become available at [https://repo.maven.apache.org/maven2/us/ihmc/](https://repo.maven.apache.org/maven2/us/ihmc/).

#### Step 5: Draft and publish release on GitHub

1. Go to [https://github.com/ihmcrobotics/ihmc-pub-sub/releases](https://github.com/ihmcrobotics/ihmc-pub-sub/releases)
1. Click "Draft a new release"
1. Enter version X.X.X as the tag name
1. Title the release "X.X.X Release Notes"
1. Document all features, API changes, regressions, bug fixes, etc.
1. Tick the "This is a pre-release" box
1. Click "Publish release"
