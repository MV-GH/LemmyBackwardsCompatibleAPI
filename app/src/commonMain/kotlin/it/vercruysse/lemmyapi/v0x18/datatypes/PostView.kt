package it.vercruysse.lemmyapi.v0x18.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
internal data class PostView(
    val post: Post,
    val creator: Person,
    val community: Community,
    val creator_banned_from_community: Boolean,
    val counts: PostAggregates,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean,
    val read: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int = 0,
    val unread_comments: Long,
)
