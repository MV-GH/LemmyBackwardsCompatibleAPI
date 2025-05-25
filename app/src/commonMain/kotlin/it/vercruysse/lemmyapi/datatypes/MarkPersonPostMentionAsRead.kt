package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot

@CommonParcelize
@Serializable
data class MarkPersonPostMentionAsRead(
    val person_post_mention_id: PersonPostMentionId,
    val read: Boolean,
): DatatypeRoot
