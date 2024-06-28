package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModBan(
    override val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
) : DatatypeRoot, Identity
