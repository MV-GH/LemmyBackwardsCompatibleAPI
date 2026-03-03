package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.Serializable

@Serializable
enum class NotificationType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) : VersionTracker {
    Mention,
    Reply,
    PrivateMessage,
    Subscribed(V1_0_0),
    ModAction(V1_0_0),
}
