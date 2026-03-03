package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PostNotificationsMode
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditPostNotifications(
    val post_id: PostId,
    val mode: PostNotificationsMode /* "AllComments" | "RepliesAndMentions" | "Mute" */,
) : DatatypeRoot
