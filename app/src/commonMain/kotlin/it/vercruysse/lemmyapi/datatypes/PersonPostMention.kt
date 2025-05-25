package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PersonPostMention(
    val id: PersonPostMentionId,
    val recipient_id: PersonId,
    val post_id: PostId,
    val read: Boolean,
    val published: String,
): DatatypeRoot
