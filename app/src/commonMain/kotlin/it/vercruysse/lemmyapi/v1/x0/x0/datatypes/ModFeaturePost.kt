package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModFeaturePost(
    val id: Long,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val featured: Boolean,
    val published: String,
    val is_featured_community: Boolean,
)
