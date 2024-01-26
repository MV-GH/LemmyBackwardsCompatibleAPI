package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPrivateMessages(
    val unread_only: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val creator_id: PersonId? = null,
)
