package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalImage(
    val local_user_id: LocalUserId? = null,
    val pictrs_alias: String,
    val pictrs_delete_token: String,
    val published: String,
)
