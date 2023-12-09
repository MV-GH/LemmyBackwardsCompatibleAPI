package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityResponse(
    val community_view: CommunityView,
    val discussion_languages: List<LanguageId>,
)
