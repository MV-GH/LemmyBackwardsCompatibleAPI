package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
) : DatatypeRoot
