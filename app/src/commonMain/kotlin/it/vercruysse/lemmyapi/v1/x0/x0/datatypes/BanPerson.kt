package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_or_restore_data: Boolean? = null,
    val reason: String? = null,
    val expires: Long? = null,
)
