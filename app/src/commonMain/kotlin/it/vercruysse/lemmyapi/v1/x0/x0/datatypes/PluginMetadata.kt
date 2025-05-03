package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PluginMetadata(
    val name: String,
    val url: String,
    val description: String,
)
