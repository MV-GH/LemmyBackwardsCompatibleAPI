plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("com.google.devtools.ksp").version("2.0.0-1.0.22")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.charleskorn.kaml:kaml:0.55.0")
    val ktorVersion = "2.3.10"
    val konvertVersion = "3.2.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation("com.squareup.okio:okio:3.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.3.0")
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
