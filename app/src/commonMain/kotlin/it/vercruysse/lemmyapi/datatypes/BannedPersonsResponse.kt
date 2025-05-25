package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: 1.0.0 lemmy types are outdated Banned renamed to Hidden
@CommonParcelize
@Serializable
data class BannedPersonsResponse(
    val banned: List<PersonView>,
) : DatatypeRoot
