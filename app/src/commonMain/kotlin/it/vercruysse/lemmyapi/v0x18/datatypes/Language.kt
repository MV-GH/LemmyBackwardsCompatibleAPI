package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Language(
    val id: LanguageId,
    val code: String,
    val name: String,
)
