package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminAddView(
    val admin_add: AdminAdd,
    val moderator: Person? = null,
    val other_person: Person,
)
