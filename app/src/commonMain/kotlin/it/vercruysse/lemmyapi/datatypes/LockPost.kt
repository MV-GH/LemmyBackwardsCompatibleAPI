package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LockPost(
    val post_id: PostId,
    val locked: Boolean,
    val reason: String,
) : DatatypeRoot
