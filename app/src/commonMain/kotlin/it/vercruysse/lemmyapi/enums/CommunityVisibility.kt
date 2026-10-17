package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V0_19_4
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CommunityVisibility(override val minimumVersion: Version = V0_19_4, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("public")
    Public,

    @SerialName("local_only")
    LocalOnly(V0_19_4, V1_0_0),

    @SerialName("unlisted")
    Unlisted(V1_0_0),

    @SerialName("local_only_public")
    LocalOnlyPublic(V1_0_0),

    @SerialName("local_only_private")
    LocalOnlyPrivate(V1_0_0),

    @SerialName("private")
    Private(V1_0_0),
}
