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
) {
    init {
        require(requestTimeout.isPositive() && requestTimeout.isFinite()) { "Request timeout must be positive and finite" }
        require(maxRetries >= 0) { "Maximum retries must not be negative" }
        require(userAgent.isNotBlank()) { "User agent must not be blank" }
    }
}

internal val LemmyAuth.token: String?
    get() = (this as? LemmyAuth.Bearer)?.token
