package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.NotificationDataType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListNotifications(
    val type_: NotificationDataType /* "All" | "Reply" | "Mention" | "PrivateMessage" | "Subscribed" */,
    val unread_only: Boolean? = null,
    val creator_id: PersonId? = null,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
