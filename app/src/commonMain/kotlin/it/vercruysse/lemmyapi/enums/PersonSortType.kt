package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PersonSortType(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("new")
    New,

    @SerialName("old")
    Old,

    @SerialName("post_score")
    PostScore,

    @SerialName("comment_score")
    CommentScore,
}
