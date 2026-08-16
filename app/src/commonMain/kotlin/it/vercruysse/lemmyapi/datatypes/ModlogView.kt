package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
@SerialName("mod_action")
data class ModlogView(
    val modlog: Modlog,
    val moderator: Person? = null,
    val target_person: Person? = null,
    val target_instance: Instance? = null,
    val target_community: Community? = null,
    val target_post: Post? = null,
    val target_comment: Comment? = null,
) : DatatypeRoot, NotificationData
