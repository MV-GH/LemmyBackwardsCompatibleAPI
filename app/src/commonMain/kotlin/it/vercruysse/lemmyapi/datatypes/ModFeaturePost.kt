package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModFeaturePost(
    val id: Long,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val featured: Boolean,
    val published: String,
    val is_featured_community: Boolean,
) : DatatypeRoot
