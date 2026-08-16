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
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
    kotlin("jvm") version "2.3.21" apply false
    id("com.android.kotlin.multiplatform.library") version "9.2.1" apply false
}

rootProject.name = "LemmyBackwardsCompatibleAPI"
include("app", "GeneratorScripts")
