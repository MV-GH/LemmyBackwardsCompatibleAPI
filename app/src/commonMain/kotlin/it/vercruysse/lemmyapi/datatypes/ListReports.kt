package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ReportSortType
import it.vercruysse.lemmyapi.enums.ReportType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListReports(
    val unresolved_only: Boolean? = null,
    val type_: ReportType /* "All" | "Posts" | "Comments" | "PrivateMessages" | "Communities" */,
    val post_id: PostId? = null,
    /** Removed in 1.0.0 */
    val community_id: CommunityId? = null,
    val page: Long? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
    /** Added in 1.0.0 */
    val sort: ReportSortType? = null,
    /** Added in 1.0.0 */
    val show_community_rule_violations: Boolean? = null,
    /** Added in 1.0.0 */
    val my_reports_only: Boolean? = null,
) : DatatypeRoot
