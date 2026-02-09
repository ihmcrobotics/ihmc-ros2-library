# Making a release

This project is a group of project and contains a Gradle plugin. It requires various levels of attention and care
depending on what changes are included in the upgrade.

#### Update ihmc-pub-sub dependencies

1. Check for the latest version here: https://repo.maven.apache.org/maven2/us/ihmc/ihmc-pub-sub/
1. Run "Find and replace" for ihmc-pub-sub, ihmc-pub-sub-generator and update the versions
1. Refresh Gradle


#### Publish local versions of the generators (if generators changed in pub sub)

Bump version number in `ihmc-ros2-library/group.gradle.properties`

1.  `cd ros2-msg-to-idl-generator/`
1. `gradle publishToMavenLocal`
1.  `cd ros2-msg-to-pubsub-generator/`
1. `gradle publishToMavenLocal`

Set the plugin management to use Maven local in 
`ros2-common-interfaces/settings.gradle.kts`:

```
pluginManagement {
   repositories {
      mavenLocal()
      gradlePluginPortal()
   }
```

Then, update the version of `ros2-msg-to-pubsub-generator` plugin in `ros2-common-interfaces/build.gradle.kts` to the local version you just published.

#### Generate messages

###### Call `generateMessages`

```
> cd ros2-common-interfaces
> gradle generateMessages
```

#### Ensure tests are passing

```
> cd /path/to/ihmc-ros2-library
> gradle compositeTask -PtaskName=test --info
```

#### Publish artifacts

Bump version number in `ihmc-ros2-library/group.gradle.properties` (if you didn't already)

Update the README.md to document any changed procedures, new features, etc.

Publish artifacts to sonatype: `gradle compositePublish -PpublishUrl=robotlabfiles` from `ihmc-ros2-library/`

Check when they become available at [https://robotlabfiles.ihmc.us/repository/us/ihmc/](https://robotlabfiles.ihmc.us/repository/us/ihmc/).

#### Update generator version (if you didn't already)

1. It will take several minutes before the newly published jars are available for Gradle to download such that it will take a moment 
before Gradle is able to assemble `ros2-common-interfaces`.
1. Update the version of `ros2-msg-to-pubsub-generator` plugin in `ros2-common-interfaces/build.gradle`.

#### Bookmark

1. Commit and push with message `:bookmark: X.X.X` and tag `X.X.X`

#### Make a release on GitHub

Follow the formatting of other releases and document the changes introduced in the new version.
