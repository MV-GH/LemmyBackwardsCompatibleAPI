pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
    kotlin("jvm") version "1.9.21" apply false
}

rootProject.name = "LemmyBackwardsCompatibleAPI"
include("app", "GeneratorScripts")
