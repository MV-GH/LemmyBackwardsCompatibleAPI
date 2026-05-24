package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.NotificationType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MarkNotificationAsRead(
    val notification_id: NotificationId,
    val read: Boolean,
    /** Doesn't exist but needed for compatability with before 1.0.0 */
    val _kind: NotificationType? = null,
) : DatatypeRoot
