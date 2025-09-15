package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Tagline(
    val id: TaglineId,
    val content: String,
    val published_at: String,
    val updated_at: String? = null,
) : DatatypeRoot
