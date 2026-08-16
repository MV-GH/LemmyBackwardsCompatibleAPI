package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommunityResponse(
    val community_view: CommunityView,
    val discussion_languages: List<LanguageId>,
) : DatatypeRoot
