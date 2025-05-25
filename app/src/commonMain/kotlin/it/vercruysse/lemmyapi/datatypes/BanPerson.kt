package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class BanPerson(
    val person_id: PersonId,
    val ban: Boolean,
    val remove_or_restore_data: Boolean? = null,
    val reason: String? = null,
    val expires: Long? = null,
) : DatatypeRoot
