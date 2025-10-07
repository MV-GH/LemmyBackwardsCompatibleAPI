package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModLockCommentView(
    val mod_lock_comment: ModLockComment,
    val moderator: Person? = null,
    val other_person: Person,
    val comment: Comment,
    val post: Post,
    val community: Community,
)
