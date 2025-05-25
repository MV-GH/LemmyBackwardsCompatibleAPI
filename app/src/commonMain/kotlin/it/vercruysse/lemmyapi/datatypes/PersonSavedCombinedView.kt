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
sealed class PersonSavedCombinedView: DatatypeRoot {
    @CommonParcelize
    @Serializable
    @SerialName("Post")
    data class Post(
        val post: PostView
    ) : PersonSavedCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("Comment")
    data class Comment(
        val comment: CommentView
    ) : PersonSavedCombinedView()
}
