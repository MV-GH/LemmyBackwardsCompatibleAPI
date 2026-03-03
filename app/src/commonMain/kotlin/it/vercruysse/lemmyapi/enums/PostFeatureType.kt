package it.vercruysse.lemmyapi.enums

import kotlinx.serialization.Serializable

@Serializable
enum class PostFeatureType {
    Local,
    Community,
}
