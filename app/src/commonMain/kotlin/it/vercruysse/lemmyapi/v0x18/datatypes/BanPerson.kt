package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_data: Boolean? = null,
    val reason: String? = null,
    val expires: Int? = null,
    val auth: String,
)
