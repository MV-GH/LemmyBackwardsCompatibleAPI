package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.NotificationDataType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListNotifications(
    val type_: NotificationDataType? /* "All" | "Reply" | "Mention" | "PrivateMessage" | "Subscribed" */ = null,
    val unread_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
)
