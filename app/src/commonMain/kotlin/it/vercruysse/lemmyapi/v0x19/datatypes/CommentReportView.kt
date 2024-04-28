package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
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
    val creator_is_moderator: Boolean = false, // Added in 0.19.4
    val creator_is_admin: Boolean = false, // Added in 0.19.4
    val creator_blocked: Boolean = false, // Added in 0.19.4
    val subscribed: SubscribedType? = null /* "Subscribed" | "NotSubscribed" | "Pending" */, // Added in 0.19.4
    val saved: Boolean? = null, // Added in 0.19.4
    val my_vote: Int = 0,
    val resolver: Person? = null,
)
