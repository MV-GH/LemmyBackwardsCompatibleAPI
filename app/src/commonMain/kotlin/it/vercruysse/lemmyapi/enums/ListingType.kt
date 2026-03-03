package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_19_0
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.Serializable

@Serializable
enum class ListingType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    All,
    Local,
    Subscribed,
    ModeratorView(V0_19_0),
    Suggested(V1_0_0),
}
