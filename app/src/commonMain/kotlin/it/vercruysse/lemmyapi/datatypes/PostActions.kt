package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PostNotificationsMode
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PostActions(
    val read_at: String? = null,
    val read_comments_at: String? = null,
    val read_comments_amount: Long? = null,
    val saved_at: String? = null,
    val voted_at: String? = null,
    val vote: VoteAction = VoteAction.NoVote,
    val hidden_at: String? = null,
    val notifications: PostNotificationsMode? /* "AllComments" | "RepliesAndMentions" | "Mute" */ = null,
) : DatatypeRoot
