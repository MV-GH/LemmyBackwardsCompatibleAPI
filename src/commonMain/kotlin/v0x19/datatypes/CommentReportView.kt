package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CommentReportView(
    val comment_report: CommentReport,
    val comment: Comment,
    val post: Post,
    val community: Community,
    val creator: Person,
    val comment_creator: Person,
    val counts: CommentAggregates,
    val creator_banned_from_community: Boolean,
    val my_vote: Int? = null,
    val resolver: Person? = null,
)
