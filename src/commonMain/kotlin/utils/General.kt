package utils

import JSON
import arrow.core.compareTo
import kotlinx.serialization.json.*




// TODO: IMMUTABLE



/**
 * Compare two version strings.
 *
 * This attempts to do a natural comparison assuming it's a typical semver (e.g. x.y.z),
 * but it ignores anything it doesn't understand. Since we're highly confident that these verisons
 * will be properly formed, this is safe enough without overcomplicating it.
 *
 * @author Jameson Little
 */
fun compareVersions(a: String, b: String): Int { // TODO remove this from Jerboa
    val versionA: List<Int> = a.split('.').mapNotNull { it.toIntOrNull() }
    val versionB: List<Int> = b.split('.').mapNotNull { it.toIntOrNull() }

    val comparison = versionA.compareTo(versionB)
    if (comparison == 0) {
        return a.compareTo(b)
    }
    return comparison
}
/**
 * Check if a version is between two other versions.
 *
 * @param current The version to check.
 * @param min The minimum version (inclusive).
 * @param max The maximum version (inclusive).
 * @return True if the current version is between the min and max versions.
 */

fun isBetweenVersions(current: String, min: String, max: String): Boolean {
    return compareVersions(current, min) >= 0 && compareVersions(current, max) <= 0
}



inline fun <reified T> toMap(obj: T): Map<String, Any?> {
    return jsonObjectToMap(JSON.encodeToJsonElement(obj).jsonObject)
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

