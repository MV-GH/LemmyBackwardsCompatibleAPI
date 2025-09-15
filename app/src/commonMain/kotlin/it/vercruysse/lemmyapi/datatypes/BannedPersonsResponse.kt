package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: 1.0.0 lemmy types are outdated Banned renamed to Hidden
// is now ListPersonHiddenResponse
// TODO not sure if banned person was actually renamed to hidden person

// IT doesnt seem that BannedPersonsResponse to ListPersonHiddenResponse
@CommonParcelize
@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
) : DatatypeRoot
