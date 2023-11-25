package it.vercruysse.lemmyapi.v0x19.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class PostView(
    val post: Post,
    val creator: Person,
    val community: Community,
    val creator_banned_from_community: Boolean,
    val creator_is_moderator: Boolean,
    val creator_is_admin: Boolean,
    val counts: PostAggregates,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean,
    val read: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int? = null,
    val unread_comments: Int,
)
