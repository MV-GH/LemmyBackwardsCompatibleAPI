package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: removed

@CommonParcelize
@Serializable
data class ModHideCommunityView(
    val mod_hide_community: ModHideCommunity,
    val admin: Person? = null,
    val community: Community,
) : DatatypeRoot
