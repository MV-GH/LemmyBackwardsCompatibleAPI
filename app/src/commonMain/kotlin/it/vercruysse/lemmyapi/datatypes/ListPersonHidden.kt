package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: renamed prob changed in latest types

@CommonParcelize
@Serializable
data class ListPersonHidden(
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
