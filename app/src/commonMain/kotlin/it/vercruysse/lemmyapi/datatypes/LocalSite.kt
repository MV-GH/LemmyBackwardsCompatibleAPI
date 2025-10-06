package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.RegistrationMode
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.dto.FederationMode

@CommonParcelize
@Serializable
data class LocalSite(
    override val id: LocalSiteId,
    val site_id: SiteId,
    val site_setup: Boolean,
    val community_creation_admin_only: Boolean,
    val require_email_verification: Boolean,
    val application_question: String? = null,
    val private_instance: Boolean,
    val default_theme: String,
    val default_post_listing_type: ListingType /* "All" | "Local" | "Subscribed" | "ModeratorView" */,
    val legal_information: String? = null,
    val application_email_admins: Boolean,
    val slur_filter_regex: String? = null,
    val federation_enabled: Boolean,
    val captcha_enabled: Boolean,
    val captcha_difficulty: String,
    val published_at: String,
    val updated_at: String? = null,
    val registration_mode: RegistrationMode /* "Closed" | "RequireApplication" | "Open" */,
    val reports_email_admins: Boolean,
    val federation_signed_fetch: Boolean,
    val default_post_listing_mode: PostListingMode /* "List" | "Card" | "SmallCard" */,
    val default_sort_type: SortType /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */,
    val default_comment_sort_type: SortType /* "Hot" | "Top" | "New" | "Old" | "Controversial" */,
    val oauth_registration: Boolean,
    val post_upvotes: FederationMode /* "All" | "Local" | "Disable" */,
    val post_downvotes: FederationMode /* "All" | "Local" | "Disable" */,
    val comment_upvotes: FederationMode /* "All" | "Local" | "Disable" */,
    val comment_downvotes: FederationMode /* "All" | "Local" | "Disable" */,
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
    val suggested_communities: MultiCommunityId? = null,
    val default_items_per_page: Long,
    ) : DatatypeRoot, Identity
