package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V0_19_4
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VoteShow(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("show")
    Show,

    @SerialName("show_for_others")
    ShowForOthers(V1_0_0),

    @SerialName("hide")
    Hide(V0_19_4),
}
