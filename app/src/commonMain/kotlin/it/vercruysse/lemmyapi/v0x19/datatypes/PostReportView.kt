package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class PostReportView(
    val post_report: PostReport,
    val post: Post,
    val community: Community,
    val creator: Person,
    val post_creator: Person,
    val creator_banned_from_community: Boolean,
    val creator_is_moderator: Boolean = false, // Added 0.19.4
    val creator_is_admin: Boolean = false, // Added 0.19.4
    val subscribed: SubscribedType? = null /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean = false, // Added 0.19.4
    val read: Boolean = false, // Added 0.19.4
    val hidden: Boolean = false, // Added 0.19.4
    val creator_blocked: Boolean = false, // Added 0.19.4
    val my_vote: Int = 0,
    val unread_comments: Long? = null, // Added 0.19.4, made Nullable
    val counts: PostAggregates,
    val resolver: Person? = null,
)
