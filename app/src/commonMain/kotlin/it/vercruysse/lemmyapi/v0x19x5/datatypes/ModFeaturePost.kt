package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModFeaturePost(
    val id: Long,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val featured: Boolean,
    val when_: String,
    val is_featured_community: Boolean,
)
