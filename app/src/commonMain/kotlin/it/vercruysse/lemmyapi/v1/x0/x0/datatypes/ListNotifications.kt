package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.NotificationDataType
import kotlinx.serialization.Serializable

@Serializable
internal data class ListNotifications(
    val type_: NotificationDataType? /* "all" | "mention" | "reply" | "subscribed" | "private_message" | "mod_action" */ = null,
    val unread_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
)
