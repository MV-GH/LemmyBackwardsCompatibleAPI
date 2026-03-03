package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import it.vercruysse.lemmyapi.dto.VersionTracker
import kotlinx.serialization.Serializable

@Serializable
enum class MultiCommunityListingType(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    All,
    Local,
    Subscribed,
}
