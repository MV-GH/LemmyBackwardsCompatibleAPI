package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

// Added in 0.19.4
@Serializable
data class LocalImage(
    val local_user_id: LocalUserId? = null,
    val pictrs_alias: String,
    val pictrs_delete_token: String,
    val published: String,
)
