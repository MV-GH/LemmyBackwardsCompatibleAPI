package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
internal data class AdminListUsersResponse(
    val users: List<LocalUserView>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
) : DatatypeRoot
