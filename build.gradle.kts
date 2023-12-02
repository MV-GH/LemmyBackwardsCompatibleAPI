import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    kotlin("multiplatform") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("org.jmailen.kotlinter") version "4.0.0"
    id("com.google.devtools.ksp") version ("1.9.21-1.0.15")
    id("com.vanniktech.maven.publish") version "0.25.3"
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64()
    mingwX64()
    macosX64()
    macosArm64()

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
        browser()
    }

    sourceSets {
        val ktorVersion = "2.3.6"


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


        nativeMain.dependencies {
            // Can't seem to get CIO to work, so using curl this probably won't work on all architectures
            implementation("io.ktor:ktor-client-curl:$ktorVersion")
        }
    }
}



tasks.check {
    dependsOn("installKotlinterPrePushHook")
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
