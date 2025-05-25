package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: local_site_id removal

@CommonParcelize
@Serializable
data class Tagline(
    val id: TaglineId,
    val local_site_id: LocalSiteId,
    val content: String,
    val published: String,
    val updated: String? = null,
) : DatatypeRoot
