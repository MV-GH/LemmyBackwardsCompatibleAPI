plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.0.20"
    id("com.google.devtools.ksp").version("2.0.21-1.0.25")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    val ktorVersion = "3.0.0"
    val konvertVersion = "3.2.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    implementation("com.squareup.okio:okio:3.9.1")
    implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.5.4")
    implementation("io.mcarle:konvert:$konvertVersion")
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
