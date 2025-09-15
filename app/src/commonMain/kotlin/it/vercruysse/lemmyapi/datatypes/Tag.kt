package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Tag(
    val id: TagId,
    val ap_id: String,
    /** Added in 1.0.0 */
    val name: String,
    /** Added in 1.0.0  */
    val description: String? = null,
    val display_name: String,
    val community_id: CommunityId,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
): DatatypeRoot
