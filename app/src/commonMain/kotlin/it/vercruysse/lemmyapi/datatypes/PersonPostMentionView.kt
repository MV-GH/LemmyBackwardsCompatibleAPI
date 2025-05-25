package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot

@CommonParcelize
@Serializable
data class PersonPostMentionView(
    val person_post_mention: PersonPostMention,
    val recipient: Person,
    val post: Post,
    val creator: Person,
    val community: Community,
    val image_details: ImageDetails? = null,
    val community_actions: CommunityActions? = null,
    val person_actions: PersonActions? = null,
    val post_actions: PostActions? = null,
    val instance_actions: InstanceActions? = null,
    val creator_home_instance_actions: InstanceActions? = null,
    val creator_local_instance_actions: InstanceActions? = null,
    val creator_community_actions: CommunityActions? = null,
    val post_tags: TagsView,
    val creator_is_admin: Boolean,
    val can_mod: Boolean,
    val creator_banned: Boolean,
): DatatypeRoot
