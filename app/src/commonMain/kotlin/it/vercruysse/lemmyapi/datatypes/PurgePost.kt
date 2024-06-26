package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgePost(
    val post_id: PostId,
    val reason: String? = null,
)