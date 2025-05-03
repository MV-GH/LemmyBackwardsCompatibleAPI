package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostView(
    val post: Post,
    val creator: Person,
    val community: Community,
    val image_details: ImageDetails? = null,
    val community_actions: CommunityActions? = null,
    val person_actions: PersonActions? = null,
    val post_actions: PostActions? = null,
    val instance_actions: InstanceActions? = null,
    val creator_home_instance_actions: InstanceActions? = null,
    val creator_local_instance_actions: InstanceActions? = null,
    val creator_community_actions: CommunityActions? = null,
    val creator_is_admin: Boolean,
    val tags: TagsView,
    val can_mod: Boolean,
    val creator_banned: Boolean,
)
