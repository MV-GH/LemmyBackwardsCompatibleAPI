package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBan(
    val id: Int,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
)
