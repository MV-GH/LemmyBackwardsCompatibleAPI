package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class InboxCombinedView {
    @Serializable
    @SerialName("CommentReply")
    internal data class CommentReply(
        val comment_reply: CommentReplyView
    ) : InboxCombinedView()

    @Serializable
    @SerialName("CommentMention")
    internal data class CommentMention(
        val comment_mention: PersonCommentMentionView
    ) : InboxCombinedView()

    @Serializable
    @SerialName("PostMention")
    internal data class PostMention(
        val post_mention: PersonPostMentionView
    ) : InboxCombinedView()

    @Serializable
    @SerialName("PrivateMessage")
    internal data class PrivateMessage(
        val private_message: PrivateMessageView
    ) : InboxCombinedView()
}
