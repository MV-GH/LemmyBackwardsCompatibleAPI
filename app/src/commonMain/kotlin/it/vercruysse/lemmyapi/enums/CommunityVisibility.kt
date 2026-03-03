package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V0_19_4
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.Serializable

@Serializable
enum class CommunityVisibility(override val minimumVersion: Version = V0_19_4, override val maximumVersion: Version? = null) :
    VersionTracker {
    Public,
    LocalOnly(V0_19_4, V1_0_0),
    Unlisted(V1_0_0),
    LocalOnlyPublic(V1_0_0),
    LocalOnlyPrivate(V1_0_0),
    Private(V1_0_0),
}
