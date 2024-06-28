package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class RemovePost(
    val post_id: PostId,
    val removed: Boolean,
    val reason: String? = null,
) : DatatypeRoot
