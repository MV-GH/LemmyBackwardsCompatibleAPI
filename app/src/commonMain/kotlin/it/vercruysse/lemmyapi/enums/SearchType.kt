package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import kotlinx.serialization.Serializable

@Serializable
enum class SearchType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    All,
    Comments,
    Posts,
    Communities,
    Users,
    Url,
}
