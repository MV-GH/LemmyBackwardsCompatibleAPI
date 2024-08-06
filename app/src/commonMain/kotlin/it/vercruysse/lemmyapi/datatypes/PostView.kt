package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.Identity

@CommonParcelize
@Serializable
data class PostView(
    val post: Post,
    val creator: Person,
    val community: Community,
    val creator_banned_from_community: Boolean,
    val banned_from_community: Boolean,
    val creator_is_moderator: Boolean,
    val creator_is_admin: Boolean,
    val counts: PostAggregates,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val saved: Boolean,
    val read: Boolean,
    val hidden: Boolean,
    val creator_blocked: Boolean,
    val my_vote: Int = 0,
    val unread_comments: Long,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = post.id
}
