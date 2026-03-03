package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
internal data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    val sidebar: String? = null,
    val summary: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "public" | "unlisted" | "local_only_public" | "local_only_private" | "private" */ = null,
)
