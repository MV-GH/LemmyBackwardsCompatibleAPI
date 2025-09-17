package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO is now admin/list/users
// AdminListUsersResponse
@CommonParcelize
@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
) : DatatypeRoot
