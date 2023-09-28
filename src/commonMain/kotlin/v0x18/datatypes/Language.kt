package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val id: LanguageId,
    val code: String,
    val name: String,
)
