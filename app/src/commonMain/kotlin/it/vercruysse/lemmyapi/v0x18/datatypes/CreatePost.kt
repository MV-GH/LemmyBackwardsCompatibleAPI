package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePost(
    val name: String,
    val community_id: CommunityId,
    val url: String? = null,
    val body: String? = null,
    val honeypot: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val auth: String,
)
