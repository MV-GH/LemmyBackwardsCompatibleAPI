package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: changed

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
    val instance_actions: InstanceActions? = null,
    val creator_home_instance_actions: InstanceActions? = null,
    val creator_local_instance_actions: InstanceActions? = null,
    val creator_community_actions: CommunityActions? = null,
    val creator_is_admin: Boolean,
    /** Added in Lemmy 1.0.0 */
    val post_tags: TagsView,
    val can_mod: Boolean,
    val creator_banned: Boolean,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = comment.id
}
