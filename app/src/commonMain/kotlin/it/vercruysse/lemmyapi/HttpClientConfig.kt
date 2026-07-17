package it.vercruysse.lemmyapi

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import it.vercruysse.lemmyapi.dto.ErrorResponse
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import kotlinx.serialization.SerializationException

internal fun HttpClient.withLemmyApiConfig(): HttpClient = config {
    installRequiredPlugins()
    expectSuccess = true

    install(ContentNegotiation) {
        json(IGNORE_UNKNOWN_KEYS_JSON)
    }

    HttpResponseValidator {
        // If a 4XX is returned, we try to parse it as a "Lemmy Error"
        // If it is a "Lemmy Error" we throw it as a LemmyBadRequestException
        handleResponseExceptionWithRequest { exception, _ ->
            val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
            val exceptionResponse = clientException.response
            val exceptionResponseText = exceptionResponse.bodyAsText()
            val contentType = exceptionResponse.contentType()

            if (exceptionResponseText.isNotEmpty() && contentType?.match(ContentType.Application.Json) == true) {
                try {
                    val errorResponse = IGNORE_UNKNOWN_KEYS_JSON.decodeFromString<ErrorResponse>(exceptionResponseText)
                    throw LemmyBadRequestException(
                        exceptionResponse.call.response.status.value,
                        errorResponse.id,
                        errorResponse.message,
                    )
                    // Don't throw if it's not an ErrorResponse
                } catch (_: SerializationException) {
                }
            }
        }
    }
}

internal fun HttpClientConfig<*>.installRequiredPlugins() {
    install(UserAgent) {
        agent = "LemmyKotlinApi"
    }

    install(HttpTimeout) {
        requestTimeoutMillis = DEFAULT_TIMEOUT_MS
        socketTimeoutMillis = DEFAULT_TIMEOUT_MS
        connectTimeoutMillis = DEFAULT_TIMEOUT_MS / 2
    }

    install(HttpRequestRetry) {
        maxRetries = 5
        retryIf { req, response ->
            response.status.value >= 500 && req.method == HttpMethod.Get
        }
        exponentialDelay()
    }
}

internal typealias AuthProvider = () -> String?

internal fun HttpClient.withBearerAuth(authProvider: AuthProvider): HttpClient = config {
    defaultRequest {
        headers.remove(HttpHeaders.Authorization)
        authProvider()?.let { token ->
            headers[HttpHeaders.Authorization] = "Bearer $token"
        }
    }
}
