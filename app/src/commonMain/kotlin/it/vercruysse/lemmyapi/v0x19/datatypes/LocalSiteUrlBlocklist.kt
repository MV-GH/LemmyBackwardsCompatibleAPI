package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

// Added in 0.19.4
@Serializable
data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published: String,
    val updated: String? = null,
)
