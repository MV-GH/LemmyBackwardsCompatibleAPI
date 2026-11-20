package it.vercruysse.lemmyapi.exception

/**
 * Replaces a request failure whose message contained the auth token.
 *
 * Lemmy 0.18 sends the token in the query of GET requests, and Ktor's exceptions (non-Lemmy error statuses, timeouts)
 * name the full address. The original exception is dropped, not kept as the cause, so the token can't reach a log
 * through it. [message] is the original type and message with the token replaced.
 *
 * @property statusCode the HTTP status when the server answered, or null when it didn't.
 * @property isNetworkFailure whether the original failure was an I/O failure (timeout, unreachable host, ...).
 */
class TokenRedactedException(
    message: String,
    val statusCode: Int?,
    val isNetworkFailure: Boolean,
) : Exception(message)
