package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.RegistrationMode
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class LocalSite(
    val id: LocalSiteId,
    val site_id: SiteId,
    val site_setup: Boolean,
    val community_creation_admin_only: Boolean,
    val require_email_verification: Boolean,
    val application_question: String? = null,
    val private_instance: Boolean,
    val default_theme: String,
    val default_post_listing_type: ListingType /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */,
    val legal_information: String? = null,
    val application_email_admins: Boolean,
    val slur_filter_regex: String? = null,
    val federation_enabled: Boolean,
    val captcha_enabled: Boolean,
    val captcha_difficulty: String,
    val published_at: String,
    val updated_at: String? = null,
    val registration_mode: RegistrationMode /* "closed" | "require_application" | "open" */,
    val reports_email_admins: Boolean,
    val federation_signed_fetch: Boolean,
    val default_post_listing_mode: PostListingMode /* "list" | "card" | "small_card" */,
    val default_post_sort_type: SortType /* "active" | "hot" | "new" | "old" | "top" | "most_comments" | "new_comments" | "controversial" | "scaled" */,
    val default_comment_sort_type: SortType /* "hot" | "top" | "new" | "old" | "controversial" */,
    val oauth_registration: Boolean,
    val post_upvotes: FederationMode /* "all" | "local" | "disable" */,
    val post_downvotes: FederationMode /* "all" | "local" | "disable" */,
    val comment_upvotes: FederationMode /* "all" | "local" | "disable" */,
    val comment_downvotes: FederationMode /* "all" | "local" | "disable" */,
    val default_post_time_range_seconds: Long? = null,
    val disallow_nsfw_content: Boolean,
    val users: Long,
    val posts: Long,
    val comments: Long,
    val communities: Long,
    val users_active_day: Long,
    val users_active_week: Long,
    val users_active_month: Long,
    val users_active_half_year: Long,
    val disable_email_notifications: Boolean,
    val suggested_multi_community_id: MultiCommunityId? = null,
    val default_items_per_page: Long,
)
