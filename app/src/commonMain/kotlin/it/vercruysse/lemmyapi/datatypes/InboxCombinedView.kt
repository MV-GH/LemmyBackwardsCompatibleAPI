package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable


@CommonParcelize
@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed class InboxCombinedView: DatatypeRoot {
    @CommonParcelize
    @Serializable
    @SerialName("CommentReply")
    data class CommentReply(
        val comment_reply: CommentReplyView
    ) : InboxCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("CommentMention")
    data class CommentMention(
        val comment_mention: PersonCommentMentionView
    ) : InboxCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("PostMention")
    data class PostMention(
        val post_mention: PersonPostMentionView
    ) : InboxCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("PrivateMessage")
    data class PrivateMessage(
        val private_message: PrivateMessageView
    ) : InboxCombinedView()
}
