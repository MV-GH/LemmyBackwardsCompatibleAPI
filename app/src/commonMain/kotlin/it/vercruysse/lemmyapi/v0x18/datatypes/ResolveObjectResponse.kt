package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ResolveObjectResponse(
    val comment: CommentView? = null,
    val post: PostView? = null,
    val community: CommunityView? = null,
    val person: PersonView? = null,
)
