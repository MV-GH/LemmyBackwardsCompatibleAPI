package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val local_only: Boolean? = null, // Pre 0.19.4
    val visibility: CommunityVisibility? /* "Public" | "LocalOnly" */ = null, // Added in 0.19.4
)
