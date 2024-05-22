package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published: String,
    val updated: String? = null,
)
