package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.PostNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class PostActions(
    val read_at: String? = null,
    val read_comments_at: String? = null,
    val read_comments_amount: Long? = null,
    val saved_at: String? = null,
    val liked_at: String? = null,
    val like_score: Int? = null,
    val hidden_at: String? = null,
    val notifications: PostNotificationsMode? /* "AllComments" | "RepliesAndMentions" | "Mute" */ = null,
)
