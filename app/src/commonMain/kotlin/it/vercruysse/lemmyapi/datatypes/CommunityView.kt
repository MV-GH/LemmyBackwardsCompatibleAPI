package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable
import it.vercruysse.lemmyapi.CommonParcelize

// TODO: changed

@CommonParcelize
@Serializable
data class CommunityView(
    val community: Community,

//    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
//    val blocked: Boolean,
//    val counts: CommunityAggregates,
//    val banned_from_community: Boolean,

    val community_actions: CommunityActions? = null,
    val can_mod: Boolean,
    val post_tags: TagsView,
) : DatatypeRoot
