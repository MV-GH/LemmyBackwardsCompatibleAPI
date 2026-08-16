package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RegistrationMode(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) :
    VersionTracker {
    @SerialName("closed")
    Closed,

    @SerialName("require_application")
    RequireApplication,

    @SerialName("require_invitation")
    RequireInvitation(V1_0_0),

    @SerialName("open")
    Open,
}
