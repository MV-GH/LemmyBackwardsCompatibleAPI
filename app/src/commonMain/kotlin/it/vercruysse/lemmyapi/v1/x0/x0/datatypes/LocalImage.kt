package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalImage(
    val local_user_id: LocalUserId? = null,
    val pictrs_alias: String,
    val published: String,
)
