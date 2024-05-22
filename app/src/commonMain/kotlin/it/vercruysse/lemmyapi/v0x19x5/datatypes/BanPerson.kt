package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_data: Boolean? = null,
    val reason: String? = null,
    val expires: Long? = null,
)
