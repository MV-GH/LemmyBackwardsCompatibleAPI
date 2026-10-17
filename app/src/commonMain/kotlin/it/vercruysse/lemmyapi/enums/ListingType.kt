package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_19_0
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ListingType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("all")
    All,

    @SerialName("local")
    Local,

    @SerialName("subscribed")
    Subscribed,

    @SerialName("moderator_view")
    ModeratorView(V0_19_0),

    @SerialName("suggested")
    Suggested(V1_0_0),
}
