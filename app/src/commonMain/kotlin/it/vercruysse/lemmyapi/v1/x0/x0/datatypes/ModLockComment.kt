package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModLockComment(
    val id: ModLockCommentId,
    val mod_person_id: PersonId,
    val comment_id: CommentId,
    val locked: Boolean,
    val reason: String,
    val published_at: String,
)
