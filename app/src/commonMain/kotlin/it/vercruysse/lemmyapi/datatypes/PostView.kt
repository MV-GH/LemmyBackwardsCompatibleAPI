package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.SerialName

@CommonParcelize
@Serializable
@SerialName("post")
data class PostView(
    val post: Post,
    val creator: Person,
    val community: Community,
    /** Added in 0.19.6 */
    val image_details: ImageDetails? = null,
    val community_actions: CommunityActions? = null,
    val person_actions: PersonActions? = null,
    val post_actions: PostActions? = null,
    val tags: CommunityTagsView,
    /** Added in 1.0.0 */
    val can_mod: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
    val creator_is_admin: Boolean,
    val creator_is_moderator: Boolean,
    val creator_banned_from_community: Boolean,
    val creator_community_ban_expires_at: String? = null,
    ) : DatatypeRoot, Identity, NotificationData, SearchCombinedView, PostCommentCombinedView {
    override val id: Long
        get() = post.id
}
