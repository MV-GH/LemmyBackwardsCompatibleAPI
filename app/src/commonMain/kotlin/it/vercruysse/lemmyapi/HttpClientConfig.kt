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

internal fun HttpClient.withLemmyApiConfig(options: LemmyApiOptions): HttpClient = config {
    installRequiredPlugins(options)
    expectSuccess = true

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

internal fun HttpClientConfig<*>.installRequiredPlugins(options: LemmyApiOptions = LemmyApiOptions()) {
    install(UserAgent) {
        agent = options.userAgent
    }

    install(HttpTimeout) {
        requestTimeoutMillis = options.requestTimeout.inWholeMilliseconds
        socketTimeoutMillis = options.requestTimeout.inWholeMilliseconds
        connectTimeoutMillis = options.requestTimeout.inWholeMilliseconds / 2
    }

    install(HttpRequestRetry) {
        maxRetries = options.maxRetries
        retryIf { req, response ->
            response.status.value >= 500 && req.method == HttpMethod.Get
        }
        exponentialDelay()
    }

    install(ContentNegotiation) {
        json(IGNORE_UNKNOWN_KEYS_JSON)
    }
}

internal typealias AuthProvider = () -> String?
