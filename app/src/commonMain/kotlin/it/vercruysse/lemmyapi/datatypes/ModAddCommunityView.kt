package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person? = null,
    val community: Community,
    val other_person: Person,
) : DatatypeRoot
