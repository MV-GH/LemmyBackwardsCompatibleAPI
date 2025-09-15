package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UpdateCommunityNotifications(
    val community_id: CommunityId,
    val mode: CommunityNotificationsMode /* "AllPostsAndComments" | "AllPosts" | "RepliesAndMentions" | "Mute" */,
) : DatatypeRoot
