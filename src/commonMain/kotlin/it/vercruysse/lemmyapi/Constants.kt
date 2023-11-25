package it.vercruysse.lemmyapi

import kotlinx.serialization.json.Json

const val MINIMUM_API_VERSION = "0.17.0"
const val TIMEOUT_MS = 20000L


// TODO think about this
val ktorJson = Json {
    ignoreUnknownKeys = true
}

val lenientJson =
    Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
