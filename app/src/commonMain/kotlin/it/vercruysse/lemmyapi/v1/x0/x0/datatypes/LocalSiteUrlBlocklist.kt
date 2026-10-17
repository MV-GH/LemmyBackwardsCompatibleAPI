package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published_at: String,
    val updated_at: String? = null,
)
