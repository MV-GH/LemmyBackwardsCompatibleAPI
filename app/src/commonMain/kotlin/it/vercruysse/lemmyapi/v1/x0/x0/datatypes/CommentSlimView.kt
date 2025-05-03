package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommentSlimView(
    val comment: Comment,
    val creator: Person,
    val comment_actions: CommentActions? = null,
    val person_actions: PersonActions? = null,
    val creator_community_actions: CommunityActions? = null,
    val instance_actions: InstanceActions? = null,
    val creator_home_instance_actions: InstanceActions? = null,
    val creator_local_instance_actions: InstanceActions? = null,
    val creator_is_admin: Boolean,
    val can_mod: Boolean,
    val creator_banned: Boolean,
)
