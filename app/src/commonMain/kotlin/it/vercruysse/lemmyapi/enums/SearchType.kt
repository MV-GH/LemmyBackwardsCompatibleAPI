package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SearchType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("all")
    All,

    @SerialName("comments")
    Comments,

    @SerialName("posts")
    Posts,

    @SerialName("communities")
    Communities,

    @SerialName("users")
    Users,

    @SerialName("url")
    Url,

    @SerialName("multi_communities")
    MultiCommunities(V1_0_0),
}
