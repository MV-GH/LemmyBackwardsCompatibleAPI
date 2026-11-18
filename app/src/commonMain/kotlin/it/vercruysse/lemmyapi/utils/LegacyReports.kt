package it.vercruysse.lemmyapi.utils

import it.vercruysse.lemmyapi.datatypes.CommentReportView
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.PostReportView
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView
import it.vercruysse.lemmyapi.datatypes.ReportCombinedView

/**
 * Applies the [ListReports] filters that pre 1.0 Lemmy can't apply itself:
 * not every version filters post reports by post, comment reports can't be filtered by post,
 * and private message reports belong to no post or community.
 */
internal fun ReportCombinedView.matchesLegacyFilters(form: ListReports): Boolean = when (this) {
    is PostReportView -> form.post_id == null || post.id == form.post_id
    is CommentReportView -> form.post_id == null || comment.post_id == form.post_id
    is PrivateMessageReportView -> form.post_id == null && form.community_id == null
    else -> true
}
