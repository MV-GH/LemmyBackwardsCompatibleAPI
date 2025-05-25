package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class SearchCombinedView {
    @Serializable
    @SerialName("Post")
    internal data class Post(
        val post: PostView
    ) : SearchCombinedView()

    @Serializable
    @SerialName("Comment")
    internal data class Comment(
        val comment: CommentView
    ) : SearchCombinedView()

    @Serializable
    @SerialName("Community")
    internal data class Community(
        val community: CommunityView
    ) : SearchCombinedView()

    @Serializable
    @SerialName("Person")
    internal data class Person(
        val person: PersonView
    ) : SearchCombinedView()
}
