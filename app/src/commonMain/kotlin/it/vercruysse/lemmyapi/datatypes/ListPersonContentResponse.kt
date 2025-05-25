package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: dynamic stuff

@CommonParcelize
@Serializable
data class ListPersonContentResponse(
    val content: List<dynamic /* `T$199` & PostView | `T$200` & CommentView */>,
    val next_page: it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
): DatatypeRoot
