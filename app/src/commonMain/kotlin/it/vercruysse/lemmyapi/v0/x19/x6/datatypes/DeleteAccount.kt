package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteAccount(
    val password: String,
    val delete_content: Boolean,
)
