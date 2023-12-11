import com.vanniktech.maven.publish.SonatypeHost
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.9.21"
    id("org.jmailen.kotlinter") version "4.0.0"
    id("com.google.devtools.ksp") version ("1.9.21-1.0.15")
    id("com.vanniktech.maven.publish") version "0.25.3"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

kotlin {

    when (getHostOsName()) {
        OS.LINUX -> {
            linuxX64()
            linuxArm64()
        }

        OS.WINDOWS -> {
            mingwX64()
        }

        OS.MAC -> {
            macosX64()
            macosArm64()
            iosX64()
            iosArm64()
            watchosX64()
            watchosArm32()
            watchosArm64()
        }
    }

    jvm {
        jvmToolchain(17)
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        nodejs()
        browser {
            testTask {
                enabled = false
            }
        }
    }

    sourceSets {
        val ktorVersion = "2.3.7"


        commonMain.dependencies {
            implementation("io.ktor:ktor-client-core:$ktorVersion")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

            implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
            implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            implementation("io.ktor:ktor-client-logging:$ktorVersion")
            api("io.github.z4kn4fein:semver:1.4.2")
        }

        commonTest.dependencies {
            implementation(kotlin("test"))

        }


        jvmMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
        }


        jsMain.dependencies {
            implementation("io.ktor:ktor-client-js:$ktorVersion")
        }

        when (getHostOsName()) {
            OS.LINUX -> {
                linuxMain.dependencies {
                    implementation("io.ktor:ktor-client-cio:$ktorVersion")
                }
            }

            OS.WINDOWS -> {
                mingwMain.dependencies {
                    implementation("io.ktor:ktor-client-winhttp:$ktorVersion")
                }
            }

            OS.MAC -> {
                macosMain.dependencies {
                    implementation("io.ktor:ktor-client-cio:$ktorVersion")
                }
            }
        }
    }

//    val publicationsFromMainHost =
//        listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"
//
//    publishing {
//        publications {
//            matching { it.name in publicationsFromMainHost }.all {
//                val targetPublication = this@all
//                tasks.withType<AbstractPublishToMaven>()
//                    .matching { it.publication == targetPublication }
//                    .configureEach { onlyIf { getHostOsName() == OS.LINUX } }
//            }
//        }
//    }
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
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
}
