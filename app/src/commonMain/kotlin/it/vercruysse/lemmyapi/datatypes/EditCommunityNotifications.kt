package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.CommunityNotificationsMode
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditCommunityNotifications(
    val community_id: CommunityId,
    val mode: CommunityNotificationsMode /* "AllPostsAndComments" | "AllPosts" | "RepliesAndMentions" | "Mute" */,
) : DatatypeRoot
