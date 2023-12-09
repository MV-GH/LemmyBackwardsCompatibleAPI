package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ImageUpload(
    val id: ImageUploadId,
    val local_user_id: LocalUserId,
    val pictrs_alias: String,
    val pictrs_delete_token: String,
    val published: String,
)
