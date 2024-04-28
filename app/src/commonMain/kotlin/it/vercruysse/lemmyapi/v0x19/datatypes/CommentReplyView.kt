package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class CommentReplyView(
    val comment_reply: CommentReply,
    val comment: Comment,
    val creator: Person,
    val post: Post,
    val community: Community,
    val recipient: Person,
    val counts: CommentAggregates,
    val creator_banned_from_community: Boolean,
    val banned_from_community: Boolean = false, // Added in 0.19.4
    val creator_is_moderator: Boolean,
    val creator_is_admin: Boolean,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int = 0,
)
