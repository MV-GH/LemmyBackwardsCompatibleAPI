package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MultiCommunitySortType(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("new") New,
    @SerialName("old") Old,
    @SerialName("name_asc") NameAsc,
    @SerialName("name_desc") NameDesc,
    @SerialName("communities") Communities,
    @SerialName("subscribers") Subscribers,
    @SerialName("subscribers_local") SubscribersLocal,
}
