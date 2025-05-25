package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Tagline(
    val id: TaglineId,
    val content: String,
    val published: String,
    val updated: String? = null,
) : DatatypeRoot
