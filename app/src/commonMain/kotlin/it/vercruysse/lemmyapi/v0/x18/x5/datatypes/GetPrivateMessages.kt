package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPrivateMessages(
    val unread_only: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val auth: String,
)
