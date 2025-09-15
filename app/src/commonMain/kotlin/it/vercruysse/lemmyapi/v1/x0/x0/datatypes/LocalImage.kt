package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalImage(
    val pictrs_alias: String,
    val published_at: String,
    val person_id: PersonId? = null,
    val thumbnail_for_post_id: PostId? = null,
)
