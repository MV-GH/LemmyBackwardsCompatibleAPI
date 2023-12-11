package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetCommunityResponse(
    val community_view: CommunityView,
    val site: Site? = null,
    val moderators: List<CommunityModeratorView>,
    val discussion_languages: List<LanguageId>,
)
