package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.PostId

@CommonParcelize
@Serializable
data class LocalImage(
    val person_id: PersonId? = null,
    val pictrs_alias: String,
    /** Removed in Lemmy 1.0.0  */
    val pictrs_delete_token: String,
    val published_at: String,
    /** Added in Lemmy 1.0.0 */
    val thumbnail_for_post_id: PostId? = null,
) : DatatypeRoot
