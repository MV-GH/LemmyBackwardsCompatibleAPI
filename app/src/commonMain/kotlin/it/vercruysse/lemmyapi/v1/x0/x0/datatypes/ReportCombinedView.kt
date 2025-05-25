package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.Serializable

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type_")
internal sealed class ReportCombinedView {
    @Serializable
    @SerialName("Post")
    internal data class Post(
        val post: PostReportView
    ) : ReportCombinedView()

    @Serializable
    @SerialName("Comment")
    internal data class Comment(
        val comment: CommentReportView
    ) : ReportCombinedView()

    @Serializable
    @SerialName("PrivateMessage")
    internal data class PrivateMessage(
        val private_message: PrivateMessageReportView
    ) : ReportCombinedView()

    @Serializable
    @SerialName("Community")
    internal data class Community(
        val community: CommunityReportView
    ) : ReportCombinedView()
}
