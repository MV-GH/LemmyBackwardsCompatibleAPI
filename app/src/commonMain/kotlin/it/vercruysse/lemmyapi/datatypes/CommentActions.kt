package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CommentActions(
    val vote: VoteAction = VoteAction.NoVote,
    val voted_at: String? = null,
    val saved_at: String? = null,
) : DatatypeRoot
