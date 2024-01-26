package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class Tagline(
    val id: Long,
    val local_site_id: LocalSiteId,
    val content: String,
    val published: String,
    val updated: String? = null,
)
