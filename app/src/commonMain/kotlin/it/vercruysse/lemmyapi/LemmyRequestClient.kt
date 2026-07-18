package it.vercruysse.lemmyapi

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpHeaders
import it.vercruysse.lemmyapi.utils.addQueryParams
import it.vercruysse.lemmyapi.utils.deleteResult
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.postUploadResult
import it.vercruysse.lemmyapi.utils.putResult
import it.vercruysse.lemmyapi.utils.setJsonBody

internal class LemmyRequestClient(
    val client: HttpClient,
    val apiBaseUrl: String,
    val authProvider: AuthProvider?,
) {
    suspend inline fun <reified R, reified T> deleteResult(path: String, body: T): Result<R> =
        client.deleteResult(resolve(path)) {
            authenticate()
            setJsonBody(body)
        }

    suspend inline fun <reified R> deleteResult(path: String): Result<R> =
        client.deleteResult(resolve(path)) { authenticate() }

    suspend inline fun <reified R, reified T> getResult(path: String, form: T): Result<R> =
        client.getResult(resolve(path)) {
            authenticate()
            addQueryParams(form)
        }

    suspend inline fun <reified R> getResult(path: String): Result<R> =
        client.getResult(resolve(path)) { authenticate() }

    suspend inline fun <reified R, reified T> postResult(path: String, body: T): Result<R> =
        client.postResult(resolve(path)) {
            authenticate()
            setJsonBody(body)
        }

    suspend inline fun <reified R> postResult(path: String): Result<R> =
        client.postResult(resolve(path)) { authenticate() }

    suspend inline fun <reified R> postUploadResult(
        path: String,
        image: ByteArray,
        noinline builder: HttpRequestBuilder.() -> Unit = {},
    ): Result<R> = client.postUploadResult(resolve(path), image) {
        authenticate()
        builder()
    }

    suspend inline fun <reified R, reified T> putResult(path: String, body: T): Result<R> =
        client.putResult(resolve(path)) {
            authenticate()
            setJsonBody(body)
        }

    private fun resolve(path: String): String = "$apiBaseUrl/$path"

    private fun HttpRequestBuilder.authenticate() {
        headers.remove(HttpHeaders.Authorization)
        authProvider?.invoke()?.let { token -> headers[HttpHeaders.Authorization] = "Bearer $token" }
    }
}
