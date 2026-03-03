package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ListRegistrationApplications(
    val unread_only: Boolean? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
