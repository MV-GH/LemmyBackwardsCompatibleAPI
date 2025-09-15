package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PersonActions(
    val blocked_at: String? = null,
    val noted_at: String? = null,
    val note: String? = null,
    val voted_at: String? = null,
    val upvotes: Long? = null,
    val downvotes: Long? = null,
): DatatypeRoot
