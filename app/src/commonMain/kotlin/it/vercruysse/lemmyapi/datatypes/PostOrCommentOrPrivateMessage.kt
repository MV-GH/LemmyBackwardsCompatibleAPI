package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@CommonParcelize
@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
sealed class PostOrCommentOrPrivateMessage : DatatypeRoot {
    @CommonParcelize
    @Serializable
    @SerialName("Post")
    data class Post(
        val post: it.vercruysse.lemmyapi.datatypes.Post
    ) : PostOrCommentOrPrivateMessage()

    @CommonParcelize
    @Serializable
    @SerialName("Comment")
    data class Comment(
        val comment: it.vercruysse.lemmyapi.datatypes.Comment
    ) : PostOrCommentOrPrivateMessage()

    @CommonParcelize
    @Serializable
    @SerialName("PrivateMessage")
    data class PrivateMessage(
        val private_message: it.vercruysse.lemmyapi.datatypes.PrivateMessage
    ) : PostOrCommentOrPrivateMessage()
}
