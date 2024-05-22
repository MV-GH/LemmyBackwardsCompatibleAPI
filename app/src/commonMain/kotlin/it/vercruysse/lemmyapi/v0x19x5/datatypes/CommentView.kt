package it.vercruysse.lemmyapi.v0x19x5.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class CommentView(
    val comment: Comment,
    val creator: Person,
    val post: Post,
    val community: Community,
    val counts: CommentAggregates,
    val creator_banned_from_community: Boolean,
    val banned_from_community: Boolean,
    val creator_is_moderator: Boolean,
    val creator_is_admin: Boolean,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int = 0,
)
