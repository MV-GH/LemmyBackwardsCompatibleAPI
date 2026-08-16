package it.vercruysse.lemmyapi.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PostFeatureType {
    @SerialName("local")
    Local,

    @SerialName("community")
    Community,
}
