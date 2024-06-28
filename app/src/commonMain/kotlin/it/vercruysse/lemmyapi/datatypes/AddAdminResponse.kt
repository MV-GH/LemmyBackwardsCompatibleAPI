package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class AddAdminResponse(
    val admins: List<PersonView>,
) : DatatypeRoot
