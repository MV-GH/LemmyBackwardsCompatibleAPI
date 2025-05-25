package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommunity(
    val name: String,
    val title: String,
    val sidebar: String? = null,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */ = null,
)
