plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "2.3.21"
    id("com.google.devtools.ksp").version("2.3.8")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    val ktorVersion = "3.5.0"
    val konvertVersion = "4.5.0"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

    implementation("com.squareup.okio:okio:3.17.0")
    implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.9.0")
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

