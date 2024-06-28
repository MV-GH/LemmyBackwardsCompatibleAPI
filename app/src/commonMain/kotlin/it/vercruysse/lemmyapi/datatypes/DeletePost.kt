package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class DeletePost(
    val post_id: PostId,
    val deleted: Boolean,
) : DatatypeRoot
