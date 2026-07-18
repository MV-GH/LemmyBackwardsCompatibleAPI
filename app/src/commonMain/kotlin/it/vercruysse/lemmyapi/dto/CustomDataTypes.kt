@file:Suppress("unused")

package it.vercruysse.lemmyapi.dto

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.github.z4kn4fein.semver.withoutSuffixes
import it.vercruysse.lemmyapi.enums.VersionTracker
import it.vercruysse.lemmyapi.utils.isBetweenVersions

/**
 * Returns the supported entries for the given version.
 * It is possible that this list is empty, such case means this type is not used at all in a newer version
 * Or doesn't exist in the older version.
 *
 * @param instanceVersion The version of the instance
 * @return A list of supported entries
 */
inline fun <reified T> getSupportedEntries(
    instanceVersion: String,
): List<T> where T : Enum<T>, T : VersionTracker = getSupportedEntries(instanceVersion.toVersion(strict = false))

/**
 * Returns the supported entries for the given version.
 * It is possible that this list is empty, such case means this type is not used at all in a newer version
 * Or doesn't exist in the older version.
 *
 * @param instanceVersion The version of the instance
 * @return A list of supported entries
 */
inline fun <reified T> getSupportedEntries(instanceVersion: Version): List<T> where T : Enum<T>, T : VersionTracker {
    val ignorePreReleaseVersion = instanceVersion.withoutSuffixes()
    return enumValues<T>().filter {
        val max = it.maximumVersion
        if (max == null) {
            ignorePreReleaseVersion >= it.minimumVersion
        } else {
            isBetweenVersions(ignorePreReleaseVersion, it.minimumVersion, max)
        }
    }
}

typealias ImportUserSettings = String
typealias ExportUserSettingsResponse = String
