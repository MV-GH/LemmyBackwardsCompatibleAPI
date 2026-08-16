package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
@SerialName("community")
data class CommunityView(
    val community: Community,
    val community_actions: CommunityActions? = null,
    val can_mod: Boolean,
    val tags: CommunityTagsView,
) : DatatypeRoot, ResolveObjectView
