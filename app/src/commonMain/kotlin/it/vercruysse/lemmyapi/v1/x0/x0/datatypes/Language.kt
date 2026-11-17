package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Language(
    val id: LanguageId,
    val code: String,
    val name: String,
    val usage_in_local_posts_percent: Long,
    val usage_in_local_comments_percent: Long,
)
