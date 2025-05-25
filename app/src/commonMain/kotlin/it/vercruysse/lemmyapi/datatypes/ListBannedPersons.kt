package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

// TODO: prob changed in latest types

@CommonParcelize
@Serializable
data class ListBannedPersons(
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
) : DatatypeRoot
