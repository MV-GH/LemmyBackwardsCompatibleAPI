package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePost(
    val name: String,
    val community_id: CommunityId,
    val url: String? = null,
    val body: String? = null,
    val alt_text: String? = null,
    val honeypot: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val custom_thumbnail: String? = null,
)