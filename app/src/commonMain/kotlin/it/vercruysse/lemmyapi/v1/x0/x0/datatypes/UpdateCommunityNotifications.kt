package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@Serializable
internal data class UpdateCommunityNotifications(
    val community_id: CommunityId,
    val mode: CommunityNotificationsMode /* "AllPostsAndComments" | "AllPosts" | "RepliesAndMentions" | "Mute" */,
)
