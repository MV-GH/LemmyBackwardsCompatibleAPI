package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostLikes(
    val post_id: PostId,
    val page: Long? = null,
    val limit: Long? = null,
)
