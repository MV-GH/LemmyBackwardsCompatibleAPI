package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.CommonParcelize
import kotlinx.serialization.SerialName

@CommonParcelize
@Serializable
@SerialName("community")
data class CommunityView(
    val community: Community,
    val community_actions: CommunityActions? = null,
    val can_mod: Boolean,
    val tags: CommunityTagsView,
) : DatatypeRoot, SearchCombinedView
