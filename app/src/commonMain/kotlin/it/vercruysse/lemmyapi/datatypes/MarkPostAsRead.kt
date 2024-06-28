package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
) : DatatypeRoot
