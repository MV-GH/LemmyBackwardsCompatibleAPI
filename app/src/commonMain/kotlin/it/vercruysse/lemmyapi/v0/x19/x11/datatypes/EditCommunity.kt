package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
internal data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "LocalOnly" */ = null,
)
