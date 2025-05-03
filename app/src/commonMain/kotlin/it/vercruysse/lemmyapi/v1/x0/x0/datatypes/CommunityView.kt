package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityView(
    val community: Community,
    val community_actions: CommunityActions? = null,
    val instance_actions: InstanceActions? = null,
    val can_mod: Boolean,
    val post_tags: TagsView,
)
