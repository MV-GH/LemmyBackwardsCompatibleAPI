package it.vercruysse.lemmyapi.utils

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApiBase
import it.vercruysse.lemmyapi.exception.NotSupportedException
import kotlinx.serialization.json.*

/**
 * Check if a version is between two other versions.
 *
 * @param current The version to check.
 * @param min The minimum version (inclusive).
 * @param max The maximum version (exclusive).
 * @return True if the current version is between the min and max versions.
 */

fun isBetweenVersions(
    current: String,
    min: String,
    max: String,
): Boolean {
    return isBetweenVersions(
        current.toVersion(false),
        min.toVersion(false),
        max.toVersion(false),
    )
}

/**
 * Check if a version is between two other versions.
 *
 * @param current The version to check.
 * @param min The minimum version (inclusive).
 * @param max The maximum version (exclusive).
 * @return True if the current version is between the min and max versions.
 */

fun isBetweenVersions(
    current: Version,
    min: Version,
    max: Version,
): Boolean {
    return min <= current && current < max
}

fun dropPatchVersion(version: String): String {
    return version.split(".").take(2).joinToString(".")
}

inline fun <reified T> toMap(obj: T): Map<String, Any?> {
    return jsonObjectToMap(Json.encodeToJsonElement(obj).jsonObject)
}

fun jsonObjectToMap(element: JsonObject): Map<String, Any?> {
    return element.entries.associate {
        it.key to extractValue(it.value)
    }
}

private fun extractValue(element: JsonElement): Any? {
    return when (element) {
        is JsonNull -> null
        is JsonPrimitive -> element.content
        is JsonArray -> element.map { extractValue(it) }
        is JsonObject -> jsonObjectToMap(element)
    }
}

internal fun LemmyApiBase.notSupported(): Nothing =
    throw NotSupportedException(
        "This endpoint is not supported on this version of Lemmy: $version",
    )

/**
 * Constructs a base url from any instance string.
 *
 * Uses some heuristics to determine some defaults
 */
internal fun constructBaseUrl(instance: String): String {
    val instanceUrl = instance.trim()

    val url =
        if (instanceUrl.contains("://")) {
            Url(instanceUrl)
        } else {
            // Really basic heuristic to determine if it's http or https,
            // if wrong consumer should specify protocol
            val protocol =
                if (instanceUrl.equals("localhost", true)) {
                    URLProtocol.HTTP
                } else {
                    URLProtocol.HTTPS
                }
            Url("${protocol.name}://$instanceUrl")
        }

    return url.protocolWithAuthority
}
