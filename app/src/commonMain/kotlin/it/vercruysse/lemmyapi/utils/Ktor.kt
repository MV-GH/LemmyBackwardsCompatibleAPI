package it.vercruysse.lemmyapi.utils

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*

suspend inline fun <reified R> HttpClient.getResult(
    urlString: String,
    builder: HttpRequestBuilder.() -> Unit = {},
): Result<R> = runCatching { get(urlString, builder).body() }

suspend inline fun <reified R> HttpClient.putResult(
    urlString: String,
    builder: HttpRequestBuilder.() -> Unit = {},
): Result<R> = runCatching { put(urlString, builder).body() }

suspend inline fun <reified R> HttpClient.postResult(
    urlString: String,
    builder: HttpRequestBuilder.() -> Unit = {},
): Result<R> = runCatching { post(urlString, builder).body() }

suspend inline fun <reified R, reified T> HttpClient.getResult(
    urlString: String,
    form: T,
): Result<R> = this.getResult(urlString) { addQueryParams(form) }

suspend inline fun <reified R, reified T> HttpClient.postResult(
    urlString: String,
    body: T,
): Result<R> = this.postResult(urlString) { setJsonBody(body) }

suspend inline fun <reified R, reified T> HttpClient.putResult(
    urlString: String,
    body: T,
): Result<R> = this.putResult(urlString) { setJsonBody(body) }

inline fun <reified T> HttpRequestBuilder.addQueryParams(form: T) {
    toMap(form).forEach { (key, value) ->
        when (value) {
            null -> Unit
            is List<*> -> value.forEach { parameter(key, it.toString()) }
            else -> parameter(key, value.toString())
        }
    }
}

inline fun <reified T> HttpRequestBuilder.setJsonBody(body: T) {
    contentType(ContentType.Application.Json)
    setBody(body)
}

fun HttpClient.addAuth(auth: String?) =
    this.config {
        if (auth != null) {
            defaultRequest {
                headers.appendIfNameAbsent(HttpHeaders.Authorization, "Bearer $auth")
            }
        }
    }
