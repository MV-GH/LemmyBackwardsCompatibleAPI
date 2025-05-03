package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published: String,
    val updated: String? = null,
)
