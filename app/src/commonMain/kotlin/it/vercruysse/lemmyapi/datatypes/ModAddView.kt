package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val other_person: Person,
) : DatatypeRoot
