plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.4.21"
    id("com.google.devtools.ksp").version("2.3.12")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.charleskorn.kaml:kaml:0.104.0")
    val ktorVersion = "3.6.0"
    val konvertVersion = "4.5.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.12.0")

    implementation("com.squareup.okio:okio:3.18.2")
    implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.9.1")
    implementation("io.mcarle:konvert-api:$konvertVersion")
    implementation(project(":app"))

    ksp("io.mcarle:konvert:$konvertVersion")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
