package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("mod_action")
internal data class ModlogView(
    val modlog: Modlog,
    val moderator: Person? = null,
    val target_person: Person? = null,
    val target_instance: Instance? = null,
    val target_community: Community? = null,
    val target_post: Post? = null,
    val target_comment: Comment? = null,
) : NotificationData
