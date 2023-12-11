package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPrivateMessages(
    val unread_only: Boolean? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val auth: String,
)
