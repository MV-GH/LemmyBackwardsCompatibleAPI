package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CommentView(
    val comment: Comment,
    val creator: Person,
    val post: Post,
    val community: Community,
    val community_actions: CommunityActions? = null,
    val comment_actions: CommentActions? = null,
    val person_actions: PersonActions? = null,
    val post_tags: TagsView,
    val can_mod: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
    val creator_is_admin: Boolean,
    val creator_is_moderator: Boolean,
    val creator_banned_from_community: Boolean,
    val creator_community_ban_expires_at: String? = null,

    ) : DatatypeRoot, Identity {
    override val id: Long
        get() = comment.id
}
