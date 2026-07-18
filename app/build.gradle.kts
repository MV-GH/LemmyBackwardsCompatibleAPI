import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "2.3.21"
    id("org.jmailen.kotlinter") version "5.6.0"
    id("com.vanniktech.maven.publish") version "0.37.0"
    id("com.github.ben-manes.versions") version "0.54.0"
    id("com.android.kotlin.multiplatform.library")
    id("kotlin-parcelize")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
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

    android {
        namespace = "it.vercruysse.lemmyapi"
        compileSdk = 36
        minSdk = 21
        compilerOptions {
            freeCompilerArgs.addAll(
                "-P",
                "plugin:org.jetbrains.kotlin.parcelize:additionalAnnotation=it.vercruysse.lemmyapi.CommonParcelize"
            )
        }
    }

    linuxX64()
    linuxArm64()
    mingwX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
    iosArm64()
    watchosSimulatorArm64()
    watchosArm64()
    watchosDeviceArm64()

    js {
        nodejs()
        browser {
            testTask {
                enabled = false
            }
        }
    }




    sourceSets {
        val ktorVersion = "3.5.1"


        commonMain.dependencies {
            api("io.ktor:ktor-client-core:$ktorVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            api("io.github.z4kn4fein:semver:3.1.0")
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")
            implementation("io.ktor:ktor-client-logging:$ktorVersion")
        }


        jvmMain.dependencies {
            api("io.ktor:ktor-client-okhttp:$ktorVersion")
        }

        jvmTest.dependencies {
            implementation(kotlin("reflect"))
            implementation("io.mockk:mockk:1.14.11")
            implementation("org.wiremock:wiremock:3.13.2")
            implementation("com.marcinziolo:kotlin-wiremock:2.1.1")
            implementation("ch.qos.logback:logback-classic:1.5.38")
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
    exclude("**/datatypes/**")
}

tasks.withType<FormatTask> {
    exclude("**/datatypes/**")
}

mavenPublishing {
    publishToMavenCentral(true)
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
