package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import kotlinx.serialization.Serializable

/**
 * Tracks the version of the supported entries from this enum
 * Use this in conjunction with [getSupportedEntries]
 *
 * @property minimumVersion The version this entry was added
 * @property maximumVersion The version this entry was removed, if null, it is still supported
 */
@Serializable
sealed interface VersionTracker {
    val minimumVersion: Version
    val maximumVersion: Version?
}
