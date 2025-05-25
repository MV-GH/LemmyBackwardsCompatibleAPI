package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: deal with dynamic
@CommonParcelize
@Serializable
data class ListInboxResponse(
    val inbox: List<InboxCombinedView>,
    val next_page: it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
): DatatypeRoot
