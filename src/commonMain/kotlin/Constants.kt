import kotlinx.serialization.json.Json

const val MINIMUM_API_VERSION = "0.17.0"
const val TIMEOUT_MS = 15000L

val JSON =
    Json {
        encodeDefaults = true
//    ignoreUnknownKeys = true
    }

// TODO think about this
val ktorJson = Json
