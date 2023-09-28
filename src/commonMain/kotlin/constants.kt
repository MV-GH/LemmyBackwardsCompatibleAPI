import kotlinx.serialization.json.Json

const val MINIMUM_API_VERSION = "0.17.0"
val JSON = Json { encodeDefaults = true }

val ktorJson =  Json { ignoreUnknownKeys = true }