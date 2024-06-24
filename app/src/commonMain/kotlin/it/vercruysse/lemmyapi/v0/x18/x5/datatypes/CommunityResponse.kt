package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityResponse(
    val community_view: CommunityView,
    val discussion_languages: List<LanguageId>,
)
