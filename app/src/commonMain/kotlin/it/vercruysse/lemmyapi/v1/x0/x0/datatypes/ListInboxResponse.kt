package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListInboxResponse(
    val inbox: List<dynamic /* `T$20` & CommentReplyView | `T$21` & PersonCommentMentionView | `T$22` & PersonPostMentionView | `T$23` & PrivateMessageView */>,
    val next_page: PaginationCursor? = null,
    val prev_page: PaginationCursor? = null,
)
