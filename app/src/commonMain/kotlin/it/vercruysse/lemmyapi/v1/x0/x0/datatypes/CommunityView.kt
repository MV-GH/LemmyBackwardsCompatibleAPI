package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("community")
internal data class CommunityView(
    val community: Community,
    val community_actions: CommunityActions? = null,
    val can_mod: Boolean,
    val tags: CommunityTagsView,
) : ResolveObjectView
