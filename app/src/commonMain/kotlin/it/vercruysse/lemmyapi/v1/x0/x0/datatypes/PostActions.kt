package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.PostNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class PostActions(
    val read_at: String? = null,
    val read_comments_at: String? = null,
    val saved_at: String? = null,
    val voted_at: String? = null,
    val hidden_at: String? = null,
    val read_comments_amount: Long? = null,
    val vote_is_upvote: Boolean? = null,
    val notifications: PostNotificationsMode? /* "all_comments" | "replies_and_mentions" | "mute" */ = null,
)
