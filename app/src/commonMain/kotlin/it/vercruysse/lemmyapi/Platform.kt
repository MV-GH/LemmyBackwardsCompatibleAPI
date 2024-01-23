package it.vercruysse.lemmyapi

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import it.vercruysse.lemmyapi.dto.ErrorResponse
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import kotlinx.serialization.SerializationException

val baseClient: HttpClient =
    HttpClient {
        install(UserAgent) {
            agent = "LemmyKotlinApi"
        }

        install(HttpTimeout) {
            requestTimeoutMillis = TIMEOUT_MS
            socketTimeoutMillis = TIMEOUT_MS
            connectTimeoutMillis = TIMEOUT_MS
        }
    }

fun getKtor(baseUrl: String): HttpClient =
    coreKtor.config {
        install(Logging) {
            level = LogLevel.ALL
        }

        defaultRequest {
            url(baseUrl)
        }
    }

val coreKtor =
    baseClient.config {
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
                    } catch (_: SerializationException) {
                    }
                }
            }
        }
    }

val lenientKtor =
    baseClient.config {
        expectSuccess = true

        install(ContentNegotiation) {
            json(lenientJson)
        }
    }
