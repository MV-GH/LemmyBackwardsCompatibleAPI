package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AddAdminResponse(
    val admins: List<PersonView>,
)
