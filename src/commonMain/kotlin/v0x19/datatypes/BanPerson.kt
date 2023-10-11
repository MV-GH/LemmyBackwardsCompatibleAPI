package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_data: Boolean? = null,
    val reason: String? = null,
    val expires: Int? = null,
)
