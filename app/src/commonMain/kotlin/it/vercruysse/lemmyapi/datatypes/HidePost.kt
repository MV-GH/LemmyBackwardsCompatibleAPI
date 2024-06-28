package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class HidePost(
    val post_ids: List<PostId>,
    val hide: Boolean,
) : DatatypeRoot
