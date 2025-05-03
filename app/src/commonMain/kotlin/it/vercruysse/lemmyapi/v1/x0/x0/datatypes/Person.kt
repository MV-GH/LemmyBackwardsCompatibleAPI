package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Person(
    val id: PersonId,
    val name: String,
    val display_name: String? = null,
    val avatar: DbUrl? = null,
    val published: String,
    val updated: String? = null,
    val ap_id: DbUrl,
    val bio: String? = null,
    val local: Boolean,
    val banner: DbUrl? = null,
    val deleted: Boolean,
    val matrix_user_id: String? = null,
    val bot_account: Boolean,
    val instance_id: InstanceId,
    val post_count: Long,
    val comment_count: Long,
)
