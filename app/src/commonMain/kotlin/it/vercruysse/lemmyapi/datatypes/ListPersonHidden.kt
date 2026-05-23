package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: for new endpoint

@CommonParcelize
@Serializable
data class ListPersonHidden(
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
