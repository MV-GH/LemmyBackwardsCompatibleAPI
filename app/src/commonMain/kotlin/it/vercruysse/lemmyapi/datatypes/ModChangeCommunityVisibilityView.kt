package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ModChangeCommunityVisibilityView(
    val mod_change_community_visibility: ModChangeCommunityVisibility,
    val moderator: Person? = null,
    val community: Community,
): DatatypeRoot
