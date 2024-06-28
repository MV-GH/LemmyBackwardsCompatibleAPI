package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class SavePost(
    val post_id: PostId,
    val save: Boolean,
) : DatatypeRoot
