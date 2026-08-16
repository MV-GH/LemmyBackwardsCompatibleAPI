package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PaginationCursor
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListTaglines(
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
