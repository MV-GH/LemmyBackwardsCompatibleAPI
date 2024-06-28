package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class DeleteAccount(
    val password: String,
    val delete_content: Boolean,
) : DatatypeRoot
