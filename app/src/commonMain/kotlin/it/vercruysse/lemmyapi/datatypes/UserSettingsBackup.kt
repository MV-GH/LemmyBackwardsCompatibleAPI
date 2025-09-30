package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UserSettingsBackup(
    val display_name: String? = null,
    val bio: String? = null,
    val avatar: String? = null,
    val banner: String? = null,
    val matrix_id: String? = null,
    val bot_account: Boolean? = null,
    val settings: LocalUser? = null,
    val followed_communities: List<String>,
    val saved_posts: List<String>,
    val saved_comments: List<String>,
    val blocked_communities: List<String>,
    val blocked_users: List<String>,
    val blocked_instances_communities: List<String>,
    val blocked_instances_persons: List<String>,
) : DatatypeRoot
