package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentReplyView(
    val comment_reply: CommentReply,
    val recipient: Person,
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
    val post_tags: TagsView,
    val can_mod: Boolean,
    val creator_banned: Boolean,
)
