package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GetFederatedInstancesKind(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("all")
    All,

    @SerialName("linked")
    Linked,

    @SerialName("allowed")
    Allowed,

    @SerialName("blocked")
    Blocked,
}
