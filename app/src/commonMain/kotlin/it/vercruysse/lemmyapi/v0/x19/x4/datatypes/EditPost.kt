package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditPost(
    val post_id: PostId,
    val name: String? = null,
    val url: String? = null,
    val body: String? = null,
    val alt_text: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val custom_thumbnail: String? = null,
)
