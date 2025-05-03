package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommentReport(
    val comment_id: CommentId,
    val reason: String,
    val violates_instance_rules: Boolean? = null,
)
