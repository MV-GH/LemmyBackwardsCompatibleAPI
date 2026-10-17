package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetCommunityResponse(
    val community_view: CommunityView,
    val site: Site? = null,
    val moderators: List<CommunityModeratorView>,
    val discussion_languages: List<LanguageId>,
)
