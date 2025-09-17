package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PaginationCursor

@CommonParcelize
@Serializable
data class ListMedia(
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Added in 1.0.0 */
    val page_back: Boolean? = null,
    val limit: Long? = null,
) : DatatypeRoot
