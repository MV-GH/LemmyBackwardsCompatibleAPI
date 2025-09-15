package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CommunityView(
    val community: Community,
    val community_actions: CommunityActions? = null,
    val can_mod: Boolean,
    val post_tags: TagsView,
) : DatatypeRoot
