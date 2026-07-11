package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreateCommentLike(
    val comment_id: CommentId,
    val vote: VoteAction,
) : DatatypeRoot
