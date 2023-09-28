package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeCommunity(
    val id: Int,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val when_: String,
)
