package it.vercruysse.lemmyapi

import io.ktor.client.HttpClient
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException
import it.vercruysse.lemmyapi.exception.TokenRedactedException
import it.vercruysse.lemmyapi.utils.addQueryParams
import it.vercruysse.lemmyapi.utils.deleteResult
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.postUploadResult
import it.vercruysse.lemmyapi.utils.putResult
import it.vercruysse.lemmyapi.utils.setJsonBody
import kotlinx.coroutines.CancellationException
import kotlinx.io.IOException

internal class LemmyRequestClient(
    val client: HttpClient,
    val apiBaseUrl: String,
    val authProvider: AuthProvider?,
    private val sendAuthHeader: Boolean = true,
    private val onAuthRejected: AuthRejectedListener? = null,
    private val redactToken: Boolean = false,
) {
    suspend inline fun <reified R, reified T> deleteResult(path: String, body: T): Result<R> {
        val token = currentToken()
        return client.deleteResult<R>(resolve(path)) {
            authenticate(token)
            setJsonBody(body)
        }.checked(HttpMethod.Delete, path, token)
    }

    suspend inline fun <reified R> deleteResult(path: String): Result<R> {
        val token = currentToken()
        return client.deleteResult<R>(resolve(path)) { authenticate(token) }.checked(HttpMethod.Delete, path, token)
    }

    suspend inline fun <reified R, reified T> getResult(path: String, form: T): Result<R> {
        val token = currentToken()
        return client.getResult<R>(resolve(path)) {
            authenticate(token)
            addQueryParams(form)
        }.checked(HttpMethod.Get, path, token)
    }

    suspend inline fun <reified R> getResult(path: String): Result<R> {
        val token = currentToken()
        return client.getResult<R>(resolve(path)) { authenticate(token) }.checked(HttpMethod.Get, path, token)
    }

    suspend inline fun <reified R, reified T> postResult(path: String, body: T): Result<R> {
        val token = currentToken()
        return client.postResult<R>(resolve(path)) {
            authenticate(token)
            setJsonBody(body)
        }.checked(HttpMethod.Post, path, token)
    }

    suspend inline fun <reified R> postResult(path: String): Result<R> {
        val token = currentToken()
        return client.postResult<R>(resolve(path)) { authenticate(token) }.checked(HttpMethod.Post, path, token)
    }

    suspend inline fun <reified R> postUploadResult(
        path: String,
        image: ByteArray,
        noinline builder: HttpRequestBuilder.() -> Unit = {},
    ): Result<R> {
        val token = currentToken()
        return client.postUploadResult<R>(resolve(path), image) {
            authenticate(token)
            builder()
        }.checked(HttpMethod.Post, path, token)
    }

    suspend inline fun <reified R, reified T> putResult(path: String, body: T): Result<R> {
        val token = currentToken()
        return client.putResult<R>(resolve(path)) {
            authenticate(token)
            setJsonBody(body)
        }.checked(HttpMethod.Put, path, token)
    }

    private fun currentToken(): String? = authProvider?.invoke()

    private fun resolve(path: String): String = "$apiBaseUrl/$path"

    private fun HttpRequestBuilder.authenticate(token: String?) {
        headers.remove(HttpHeaders.Authorization)
        if (sendAuthHeader && token != null) headers[HttpHeaders.Authorization] = "Bearer $token"
    }

    private fun <R> Result<R>.checked(method: HttpMethod, path: String, token: String?): Result<R> {
        val failure = exceptionOrNull() ?: return this
        if (token.isNullOrEmpty()) return this
        if (failure.rejectsAuth() && !isCredentialCheck(method, path)) notifyAuthRejected(token)
        return if (redactToken) Result.failure(failure.redacting(token)) else this
    }

    private fun notifyAuthRejected(token: String) {
        val listener = onAuthRejected ?: return
        try {
            listener(LemmyAuth.Bearer(token))
        } catch (exception: CancellationException) {
            throw exception
        } catch (_: Exception) {
            // A failing listener must not turn the request's Result into a thrown exception
        }
    }

    private companion object {
        /** Lemmy error ids that mean the request's token is not (or no longer) valid. */
        val REJECTED_AUTH_ERRORS = setOf("not_logged_in", "incorrect_login")

        /** Requests that check a password, where `incorrect_login` means a wrong password rather than a bad token. */
        val CREDENTIAL_CHECKS = setOf(
            HttpMethod.Post to "user/login",
            HttpMethod.Post to "account/auth/login",
            HttpMethod.Put to "user/change_password",
            HttpMethod.Put to "account/auth/change_password",
            HttpMethod.Post to "user/delete_account",
            HttpMethod.Delete to "account",
        )

        fun isCredentialCheck(method: HttpMethod, path: String): Boolean = (method to path) in CREDENTIAL_CHECKS

        fun Throwable.rejectsAuth(): Boolean = when (this) {
            is LemmyBadRequestException -> statusCode == 401 || id in REJECTED_AUTH_ERRORS
            is ResponseException -> response.status.value == 401
            else -> false
        }
    }
}

private const val REDACTED = "<redacted>"
private const val MAX_CAUSE_DEPTH = 16

/**
 * Replaces this failure by a [TokenRedactedException] when its message, or a cause's, contains [token].
 * Lemmy 0.18 sends the token in the query of GET requests, and Ktor puts the address in its exception messages.
 */
internal fun Throwable.redacting(token: String): Throwable {
    // Bounded, as a cause chain can loop back on itself
    val leaks = generateSequence(this) { it.cause }.take(MAX_CAUSE_DEPTH).any { it.message?.contains(token) == true }
    if (!leaks) return this
    val original = listOfNotNull(this::class.simpleName, message).joinToString(": ")
    return TokenRedactedException(
        message = original.replace(token, REDACTED),
        statusCode = (this as? ResponseException)?.response?.status?.value,
        isNetworkFailure = this is IOException,
    )
}
