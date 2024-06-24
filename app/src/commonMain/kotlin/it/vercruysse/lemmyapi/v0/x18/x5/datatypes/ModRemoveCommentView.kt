package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemoveCommentView(
    val mod_remove_comment: ModRemoveComment,
    val moderator: Person? = null,
    val comment: Comment,
    val commenter: Person,
    val post: Post,
    val community: Community,
)
