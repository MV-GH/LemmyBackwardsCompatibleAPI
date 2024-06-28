package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
) : DatatypeRoot
