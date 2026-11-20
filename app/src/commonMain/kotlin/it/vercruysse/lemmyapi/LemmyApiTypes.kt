package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.github.z4kn4fein.semver.withoutSuffixes
import it.vercruysse.lemmyapi.utils.constructBaseUrl
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

data class LemmyInstance(val url: String) {
    init {
        require(url.isNotBlank()) { "Lemmy instance must not be blank" }
    }

    internal val baseUrl: String = constructBaseUrl(url)

    override fun toString(): String = url
}

data class LemmyVersion(val value: String) {

    @PublishedApi
    internal val semanticVersion: Version = try {
        value.toVersion(strict = false)
    } catch (exception: Exception) {
        throw IllegalArgumentException("Invalid Lemmy version: $value", exception)
    }

    internal val semVersionNoSuffix = semanticVersion.withoutSuffixes()

    override fun toString(): String = value
}

sealed interface LemmyAuth {
    data object Anonymous : LemmyAuth

    data class Bearer(val token: String) : LemmyAuth {
        init {
            require(token.isNotBlank()) { "Bearer token must not be blank" }
        }
    }

    companion object {
        fun fromToken(token: String?): LemmyAuth = if (token == null) Anonymous else Bearer(token)
    }
}

/** Determines how LemmyApi handles versions newer than the latest known compatible implementation in their release line. */
enum class VersionPolicy {
    /** Rejects versions newer than the latest known compatible implementation in their release line. */
    Strict,

    /** Maps newer versions to the latest known wrapper; this avoids immediate rejection but can be unsafe when an upstream schema changes. */
    LatestKnownCompatible,
}

data class LemmyApiOptions(
    val requestTimeout: Duration = 20.seconds,
    val maxRetries: Int = 3,
    val userAgent: String = "LemmyKotlinApi",
    val versionPolicy: VersionPolicy = VersionPolicy.LatestKnownCompatible,
    /**
     * Called with the token of an API request the server rejected as not logged in: a 401, or the Lemmy error
     * `not_logged_in` or `incorrect_login`. Password checks (login, change password, delete account) are left out,
     * as there `incorrect_login` means a wrong password.
     *
     * It gets the token the request was sent with, so a token replaced since can be told apart. It runs on the
     * requesting coroutine before the result is returned; keep it quick. Exceptions it throws are ignored.
     */
    val onAuthRejected: AuthRejectedListener? = null,
) {
    init {
        require(requestTimeout.isPositive() && requestTimeout.isFinite()) { "Request timeout must be positive and finite" }
        require(maxRetries >= 0) { "Maximum retries must not be negative" }
        require(userAgent.isNotBlank()) { "User agent must not be blank" }
    }
}

internal val LemmyAuth.token: String?
    get() = (this as? LemmyAuth.Bearer)?.token

/** See [LemmyApiOptions.onAuthRejected]. */
typealias AuthRejectedListener = (LemmyAuth.Bearer) -> Unit
