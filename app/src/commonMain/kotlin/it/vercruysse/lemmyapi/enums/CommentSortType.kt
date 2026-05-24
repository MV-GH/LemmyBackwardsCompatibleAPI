package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_19_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CommentSortType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("hot")
    Hot,

    @SerialName("top")
    Top,

    @SerialName("new")
    New,

    @SerialName("old")
    Old,

    @SerialName("controversial")
    Controversial(V0_19_0),
}
