package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Language(
    val id: LanguageId,
    val code: String,
    val name: String,
)
