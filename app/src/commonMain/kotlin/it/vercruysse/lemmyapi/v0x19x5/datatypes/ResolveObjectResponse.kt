package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveObjectResponse(
    val comment: CommentView? = null,
    val post: PostView? = null,
    val community: CommunityView? = null,
    val person: PersonView? = null,
)
