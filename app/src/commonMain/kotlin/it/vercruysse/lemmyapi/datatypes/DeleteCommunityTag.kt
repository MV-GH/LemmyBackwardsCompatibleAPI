package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.TagId
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class DeleteCommunityTag(
    val tag_id: TagId,
): DatatypeRoot
