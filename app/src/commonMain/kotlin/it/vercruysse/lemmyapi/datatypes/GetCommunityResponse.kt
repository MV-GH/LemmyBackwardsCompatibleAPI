package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetCommunityResponse(
    val community_view: CommunityView,
    val site: Site? = null,
    val moderators: List<CommunityModeratorView>,
    val discussion_languages: List<LanguageId>,
) : DatatypeRoot
