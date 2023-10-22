import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

fun getKtor(baseUrl: String): HttpClient = coreKtor.config {
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
               println(message)
            }
        }
        level = LogLevel.HEADERS
    }

    defaultRequest {
        url(baseUrl)
    }
}

val coreKtor by lazy {
    baseClient.config {
        expectSuccess = true

        install(ContentNegotiation) {
            json(ktorJson)
        }

        install(HttpTimeout) {
            requestTimeoutMillis = TIMEOUT_MS
        }
    }
}

expect val baseClient: HttpClient
