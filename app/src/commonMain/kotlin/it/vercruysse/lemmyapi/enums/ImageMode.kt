package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ImageMode(override val minimumVersion: Version = V1_0_0, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("none")
    None,

    @SerialName("store_link_previews")
    StoreLinkPreviews,

    @SerialName("proxy_all_images")
    ProxyAllImages,
}
