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
sealed class PersonLikedCombinedView : DatatypeRoot {

    @CommonParcelize
    @Serializable
    @SerialName("Post")
    data class Post(
        val post: PostView
    ) : PersonLikedCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("Comment")
    data class Comment(
        val comment: CommentView
    ) : PersonLikedCombinedView()
}
