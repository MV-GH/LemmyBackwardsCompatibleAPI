package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val other_person: Person,
)
