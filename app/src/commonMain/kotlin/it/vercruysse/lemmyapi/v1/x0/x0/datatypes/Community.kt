package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Community(
    val id: CommunityId,
    val name: String,
    val title: String,
    val sidebar: String? = null,
    val removed: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val nsfw: Boolean,
    val ap_id: DbUrl,
    val local: Boolean,
    val icon: DbUrl? = null,
    val banner: DbUrl? = null,
    val posting_restricted_to_mods: Boolean,
    val instance_id: InstanceId,
    val visibility: String /* "Public" | "Unlisted" | "LocalOnlyPublic" | "LocalOnlyPrivate" | "Private" */,
    val description: String? = null,
    val subscribers: Long,
    val posts: Long,
    val comments: Long,
    val users_active_day: Long,
    val users_active_week: Long,
    val users_active_month: Long,
    val users_active_half_year: Long,
    val subscribers_local: Long,
    val report_count: Long,
    val unresolved_report_count: Long,
    val local_removed: Boolean,
)
