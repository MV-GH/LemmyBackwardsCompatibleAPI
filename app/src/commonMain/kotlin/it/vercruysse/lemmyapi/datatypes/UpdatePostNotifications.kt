package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UpdatePostNotifications(
    val post_id: PostId,
    val mode: String /* "AllComments" | "RepliesAndMentions" | "Mute" */,
) : DatatypeRoot
