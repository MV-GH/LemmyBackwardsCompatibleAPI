package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreatePostLike(
    val post_id: PostId,
    val vote: VoteAction,
) : DatatypeRoot
