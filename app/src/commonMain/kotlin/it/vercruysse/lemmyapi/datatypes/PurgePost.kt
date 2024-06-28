package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PurgePost(
    val post_id: PostId,
    val reason: String? = null,
) : DatatypeRoot
