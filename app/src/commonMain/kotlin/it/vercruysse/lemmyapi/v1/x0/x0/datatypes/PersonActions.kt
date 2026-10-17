package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonActions(
    val blocked_at: String? = null,
    val noted_at: String? = null,
    val note: String? = null,
    val voted_at: String? = null,
    val upvotes: Long? = null,
    val downvotes: Long? = null,
)
