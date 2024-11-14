package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Tagline(
    val id: Long,
    val local_site_id: LocalSiteId,
    val content: String,
    val published: String,
    val updated: String? = null,
)
