package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO changes again

@CommonParcelize
@Serializable
data class HidePost(
    val post_ids: List<PostId>,
    val hide: Boolean,
) : DatatypeRoot
