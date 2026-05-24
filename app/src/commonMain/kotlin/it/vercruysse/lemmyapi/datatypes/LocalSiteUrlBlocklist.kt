package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LocalSiteUrlBlocklist(
    val id: Long,
    val url: String,
    val published_at: String,
    val updated_at: String? = null,
) : DatatypeRoot
