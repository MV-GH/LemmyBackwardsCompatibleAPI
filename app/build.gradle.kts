import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.vanniktech.maven.publish.SonatypeHost
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "2.0.21"
    id("org.jmailen.kotlinter") version "4.4.0"
    id("com.google.devtools.ksp") version ("2.0.21-1.0.25")
    id("com.vanniktech.maven.publish") version "0.29.0"
    id("com.github.ben-manes.versions") version "0.51.0"
    id("com.android.library")
    id("kotlin-parcelize")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

android {
    namespace = "it.vercruysse.lemmyapi"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}

kotlin {
    jvmToolchain(17)

    jvm {
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    androidTarget {
        compilerOptions {
            freeCompilerArgs.addAll("-P", "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=it.vercruysse.lemmyapi.CommonParcelize")
        }
    }

    linuxX64()
    linuxArm64()
    mingwX64()
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    watchosX64()
    watchosArm64()

    js {
        nodejs()
        browser {
            testTask {
                enabled = false
            }
        }
    }

    sourceSets {
        val ktorVersion = "3.0.1"


        commonMain.dependencies {
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            api("io.github.z4kn4fein:semver:2.0.0")
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
            implementation("io.ktor:ktor-client-logging:$ktorVersion")
        }


        jvmMain.dependencies {
            api("io.ktor:ktor-client-okhttp:$ktorVersion")
        }

        jvmTest.dependencies {
            implementation(kotlin("reflect"))
            implementation("io.mockk:mockk:1.13.13")
            implementation("org.wiremock:wiremock:3.9.2")
            implementation("com.marcinziolo:kotlin-wiremock:2.1.1")
            implementation("ch.qos.logback:logback-classic:1.5.6")
            implementation("io.ktor:ktor-client-mock:$ktorVersion")
        }

        jsMain.dependencies {
            api("io.ktor:ktor-client-js:$ktorVersion")
        }

        linuxMain.dependencies {
            api("io.ktor:ktor-client-cio:$ktorVersion")
        }

        // CIO is not available on Windows yet
        mingwMain.dependencies {
            api("io.ktor:ktor-client-winhttp:$ktorVersion")
        }

        appleMain.dependencies {
            api("io.ktor:ktor-client-cio:$ktorVersion")
        }

        androidMain.dependencies {
            api("io.ktor:ktor-client-okhttp:$ktorVersion")
        }
    }

    val publicationsFromMainHost = listOf(jvm(), js(), androidTarget()).map { it.name } + "kotlinMultiplatform"

    publishing {
        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { getHostOsName() == OS.LINUX } }
            }
        }
    }

    targets.configureEach {
        compilations.configureEach {
            compileTaskProvider.configure {
                compilerOptions {
                    // Disable beta warning actual/expect usage
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }
            }
        }
    }
}


tasks.withType<LintTask> {
    val l = fileTree(".")
    l.setIncludes(listOf("**/datatypes/**"))
    this.source = this.source.minus(l).asFileTree
}

tasks.withType<FormatTask> {
    val l = fileTree(".")
    l.setIncludes(listOf("**/datatypes/**"))
    this.source = this.source.minus(l).asFileTree
}

enum class OS {
    LINUX, WINDOWS, MAC
}

fun getHostOsName(): OS =
    System.getProperty("os.name").let { osName ->
        when {
            osName == "Linux" -> OS.LINUX
            osName.startsWith("Windows") -> OS.WINDOWS
            osName.startsWith("Mac") -> OS.MAC
            else -> throw GradleException("Unknown OS: $osName")
        }
    }

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01, true)
    signAllPublications()
}


fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
    gradleReleaseChannel = "current"
}
