package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteAccount(
    val password: String,
    val delete_content: Boolean,
)
