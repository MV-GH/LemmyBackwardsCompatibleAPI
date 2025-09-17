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
sealed class SearchCombinedView : DatatypeRoot {
    @CommonParcelize
    @Serializable
    @SerialName("Post")
    data class Post(val post: PostView) : SearchCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("Comment")
    data class Comment(val comment: CommentView) : SearchCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("Community")
    data class Community(val community: CommunityView) : SearchCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("Person")
    data class Person(val person: PersonView) : SearchCombinedView()

    @CommonParcelize
    @Serializable
    @SerialName("MultiCommunity")
    data class MultiCommunity(val multiCommunity: MultiCommunityView) : SearchCombinedView()
}
