package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published: String,
    val updated: String? = null,
) : DatatypeRoot
