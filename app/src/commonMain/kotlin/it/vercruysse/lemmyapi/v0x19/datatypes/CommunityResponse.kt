package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommunityResponse(
    val community_view: CommunityView,
    val discussion_languages: List<LanguageId>,
)
