package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModLockCommentView(
    val mod_lock_comment: ModLockComment,
    val moderator: Person? = null,
    val other_person: Person,
    val comment: Comment,
    val post: Post,
    val community: Community,
) : DatatypeRoot
