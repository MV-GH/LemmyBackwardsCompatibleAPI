package it.vercruysse.lemmyapi.v1.x0.x0.combinedtypes

import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.CommentView
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PostView
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class PersonLikedCombinedView {
    @Serializable
    @SerialName("Post")
    internal data class Post(
        val post: PostView,
    ) : PersonLikedCombinedView()

    @Serializable
    @SerialName("Comment")
    internal data class Comment(
        val comment: CommentView,
    ) : PersonLikedCombinedView()
}
