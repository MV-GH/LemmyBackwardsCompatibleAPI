package it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class PostOrCommentOrPrivateMessage {
    @Serializable
    @SerialName("Post")
    internal data class Post(
        val post: it.vercruysse.lemmyapi.v1.x0.x0.datatypes.Post,
    ) : PostOrCommentOrPrivateMessage()

    @Serializable
    @SerialName("Comment")
    internal data class Comment(
        val comment: it.vercruysse.lemmyapi.v1.x0.x0.datatypes.Comment,
    ) : PostOrCommentOrPrivateMessage()

    @Serializable
    @SerialName("PrivateMessage")
    internal data class PrivateMessage(
        val private_message: it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PrivateMessage,
    ) : PostOrCommentOrPrivateMessage()
}
