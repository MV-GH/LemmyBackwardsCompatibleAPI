package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PersonContentType
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.CommunityId
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonContent(
    val type_: PersonContentType? /* "all" | "comments" | "posts" */ = null,
    val person_id: PersonId? = null,
    val username: String? = null,
    val community_id: CommunityId? = null,
    /** Added in 1.0.0 */
    val community_name: String? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
) : DatatypeRoot
