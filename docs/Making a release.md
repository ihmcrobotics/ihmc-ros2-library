# Making a release

#### Step 1: Generate messages (Only if test messages changed. Only affects tests.)

In `ihmc-pub-sub-generator/src/test/java`, run `us.ihmc.pubsub.examples.GenerateTestMessages` (with 
"Build, no error check" if using IntelliJ).

Make sure the generated files have LF (Unix) line separators.

#### Step 2: Ensure tests are passing

Use Bamboo or run tests manually.

##### Running tests locally

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

#### Step 3: Update version numbers

Run a "Find and replace" on all files (not just *.gradle) in the repo to replace the old version with new version.
Make sure to search over all files, not just *.gradle.

Update the README.md to document any changed procedures, new features, etc.

#### Step 4: Publish artifacts

Publish artifacts to Bintray.

`gradle compositePublish -PpublishUrl=ihmcRelease`

Go to [https://bintray.com/ihmcrobotics/maven-release](https://bintray.com/ihmcrobotics/maven-release) and "Publish All".

#### Step 5: Draft and publish release on GitHub

1. Go to [https://github.com/ihmcrobotics/ihmc-pub-sub/releases](https://github.com/ihmcrobotics/ihmc-pub-sub/releases)
1. Click "Draft a new release"
1. Enter version X.X.X as the tag name
1. Title the release "X.X.X Release Notes"
1. Document all features, API changes, regressions, bug fixes, etc.
1. Tick the "This is a pre-release" box
1. Click "Publish release"