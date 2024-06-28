package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@Serializable
data class Language(
    override val id: LanguageId,
    val code: String,
    val name: String,
) : DatatypeRoot, Identity
