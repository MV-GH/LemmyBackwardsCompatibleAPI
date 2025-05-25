package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: cursor changes

@CommonParcelize
@Serializable
data class ListRegistrationApplications(
    val unread_only: Boolean? = null,
    val page: Long? = null,
    val limit: Long? = null,
) : DatatypeRoot
