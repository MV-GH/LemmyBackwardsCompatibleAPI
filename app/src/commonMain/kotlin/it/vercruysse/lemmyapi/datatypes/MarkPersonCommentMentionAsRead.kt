package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MarkPersonCommentMentionAsRead(
    val person_comment_mention_id: PersonCommentMentionId,
    val read: Boolean,
): DatatypeRoot
