package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemoveCommentView(
    val mod_remove_comment: ModRemoveComment,
    val moderator: Person? = null,
    val other_person: Person,
    val comment: Comment,
    val post: Post,
    val community: Community,
)
