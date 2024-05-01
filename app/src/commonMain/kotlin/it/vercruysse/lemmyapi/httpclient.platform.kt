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

val baseClient: HttpClient = HttpClient {
    install(UserAgent) {
        agent = "LemmyKotlinApi"
    }

    install(HttpTimeout) {
        requestTimeoutMillis = TIMEOUT_MS
        socketTimeoutMillis = TIMEOUT_MS
        connectTimeoutMillis = TIMEOUT_MS / 2
    }
}


/**
 * This client contains all the core configuration for LemmyAPI
 */
val coreHttpClient = baseClient.config {
    expectSuccess = true

    install(ContentNegotiation) {
        json(ktorJson)
    }

    install(HttpRequestRetry) {
        maxRetries = 5
        retryIf { _, response ->
            response.status.value >= 500
        }
        exponentialDelay()
    }

    HttpResponseValidator {
        // If a 4XX is returned we try to parse it as a "Lemmy Error"
        // If it is a "Lemmy Error" we throw it as a LemmyBadRequestException
        handleResponseExceptionWithRequest { exception, _ ->
            val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
            val exceptionResponse = clientException.response
            val exceptionResponseText = exceptionResponse.bodyAsText()
            val contentType = exceptionResponse.contentType()

            if (exceptionResponseText.isNotEmpty() && contentType?.match(ContentType.Application.Json) == true) {
                try {
                    val errorResponse = lenientJson.decodeFromString<ErrorResponse>(exceptionResponseText)
                    throw LemmyBadRequestException(
                        exceptionResponse.call.response.status.value,
                        errorResponse.msg,
                        exceptionResponse,
                    )
                // Don't throw if it's not an ErrorResponse
                } catch (_: SerializationException) {
                }
            }
        }
    }
}


val lenientClient = baseClient.config {
    expectSuccess = true

    install(ContentNegotiation) {
        json(lenientJson)
    }
}
