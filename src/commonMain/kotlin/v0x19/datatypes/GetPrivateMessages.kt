package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPrivateMessages(
    val unread_only: Boolean? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val creator_id: PersonId? = null,
)
