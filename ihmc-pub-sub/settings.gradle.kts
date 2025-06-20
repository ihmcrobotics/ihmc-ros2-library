pluginManagement {
   plugins {
      id("us.ihmc.ihmc-build") version "1.2.1"
   }
}

buildscript {
   repositories {
      maven { url = uri("https://plugins.gradle.org/m2/") }
      mavenLocal()
   }
   dependencies {
      classpath("us.ihmc:ihmc-build:1.2.1")
   }
}

ProcessBuilder("git", "submodule", "update", "--init", "--recursive").directory(settings.settingsDir).start().waitFor()

val ihmcSettingsConfigurator = us.ihmc.build.IHMCSettingsConfigurator(settings, logger, extra)
ihmcSettingsConfigurator.checkRequiredPropertiesAreSet()
ihmcSettingsConfigurator.configureExtraSourceSets()
ihmcSettingsConfigurator.findAndIncludeCompositeBuilds()
