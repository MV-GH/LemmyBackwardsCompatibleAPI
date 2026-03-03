package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Person(
    override val id: PersonId,
    val name: String,
    val display_name: String? = null,
    val avatar: String? = null,
    val published_at: String,
    val updated_at: String? = null,
    val ap_id: String,
    val bio: String? = null,
    val local: Boolean,
    val banner: String? = null,
    val deleted: Boolean,
    val matrix_user_id: String? = null,
    val bot_account: Boolean,
    val instance_id: InstanceId,
    val post_count: Long,
    val comment_count: Long,
    /** Added in 1.0.0 */
    val last_refreshed_at: String,
) : DatatypeRoot, Identity
