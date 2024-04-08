package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.toVersion
import kotlinx.serialization.json.Json

val MINIMUM_API_VERSION = "0.17.0".toVersion()
val V0_18_0 = "0.18.0".toVersion()
val V0_19_0 = "0.19.0".toVersion()
const val TIMEOUT_MS = 20000L

val ktorJson = Json {
    ignoreUnknownKeys = true
}

val lenientJson = Json {
    ignoreUnknownKeys = true
    isLenient = true
}
