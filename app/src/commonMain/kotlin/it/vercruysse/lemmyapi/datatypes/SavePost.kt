package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SavePost(
    val post_id: PostId,
    val save: Boolean,
)
