package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetCommentsResponse(
    val comments: List<CommentView>,
)
