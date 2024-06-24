package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostLikes(
    val post_id: PostId,
    val page: Long? = null,
    val limit: Long? = null,
)
