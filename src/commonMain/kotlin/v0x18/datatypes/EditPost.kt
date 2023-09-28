package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditPost(
    val post_id: PostId,
    val name: String? = null,
    val url: String? = null,
    val body: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val auth: String,
)
