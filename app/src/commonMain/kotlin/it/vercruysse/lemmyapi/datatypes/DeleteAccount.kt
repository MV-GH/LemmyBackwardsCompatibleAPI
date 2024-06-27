package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteAccount(
    val password: String,
    val delete_content: Boolean,
)
