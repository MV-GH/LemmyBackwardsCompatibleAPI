package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class Language(
    val id: LanguageId,
    val code: String,
    val name: String,
) : DatatypeRoot
