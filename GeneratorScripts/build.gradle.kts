plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.9.21"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    val ktorVersion = "2.3.6"
    val konvertVersion = "2.3.0"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    implementation("com.squareup.okio:okio:3.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.3.0")
    implementation("io.mcarle:konvert:$konvertVersion")
    implementation("io.mcarle:konvert-api:$konvertVersion")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
