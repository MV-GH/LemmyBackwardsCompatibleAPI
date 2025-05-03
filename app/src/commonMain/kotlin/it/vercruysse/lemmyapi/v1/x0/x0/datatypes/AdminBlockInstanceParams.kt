package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminBlockInstanceParams(
    val instance: String,
    val block: Boolean,
    val reason: String? = null,
    val expires: String? = null,
)
