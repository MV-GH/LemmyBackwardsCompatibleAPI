package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val modded_person: Person,
) : DatatypeRoot
