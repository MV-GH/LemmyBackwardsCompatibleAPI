package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: mapping changes

@CommonParcelize
@Serializable
data class GetModlogResponse(
    val modlog: List<ModlogCombinedView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
) : DatatypeRoot
