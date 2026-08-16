package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V0_19_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PostListingMode(override val minimumVersion: Version = V0_19_0, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("list")
    List,

    @SerialName("card")
    Card,

    @SerialName("small_card")
    SmallCard,
}
