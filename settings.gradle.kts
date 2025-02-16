pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    kotlin("jvm") version "2.1.10" apply false
    id("com.android.library") version "8.7.3" apply false
}

rootProject.name = "LemmyBackwardsCompatibleAPI"
include("app", "GeneratorScripts")
