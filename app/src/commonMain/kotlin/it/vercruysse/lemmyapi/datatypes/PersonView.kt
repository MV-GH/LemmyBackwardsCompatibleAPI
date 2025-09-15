package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class PersonView(
    val person: Person,
    val is_admin: Boolean,
    val person_actions: PersonActions? = null,
    val creator_banned: Boolean,
    ) : DatatypeRoot
