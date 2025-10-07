package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminRemoveCommunityView(
    val admin_remove_community: AdminRemoveCommunity,
    val moderator: Person? = null,
    val community: Community,
) : DatatypeRoot
