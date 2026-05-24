package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateMultiCommunity(
    val name: String,
    val title: String? = null,
    val summary: String? = null,
    val sidebar: String? = null,
)
