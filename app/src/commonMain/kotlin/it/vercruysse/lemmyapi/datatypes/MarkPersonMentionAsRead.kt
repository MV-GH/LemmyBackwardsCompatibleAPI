package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: removed, possibly renamed to MarkPersonCommentMentionAsRead

@CommonParcelize
@Serializable
data class MarkPersonMentionAsRead(
    val person_mention_id: PersonMentionId,
    val read: Boolean,
) : DatatypeRoot
