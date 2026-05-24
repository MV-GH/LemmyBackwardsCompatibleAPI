package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.RegistrationMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.ImageMode

@CommonParcelize
@Serializable
data class EditSite(
    val name: String? = null,
    val sidebar: String? = null,
    val summary: String? = null,
    /** Removed in 1.0.0 */
    val enable_nsfw: Boolean? = null,
    val community_creation_admin_only: Boolean? = null,
    val email_verification_required: Boolean? = null,
    val application_question: String? = null,
    val private_instance: Boolean? = null,
    val default_theme: String? = null,
    val default_post_listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val default_post_listing_mode: PostListingMode? /* "List" | "Card" | "SmallCard" */ = null,
    val default_post_sort_type: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    val default_post_time_range_seconds: Long? = null,
    val default_items_per_page: Long? = null,
    val default_comment_sort_type: SortType? /* "hot" | "top" | "new" | "old" | "controversial" */ = null,
    val legal_information: String? = null,
    val application_email_admins: Boolean? = null,
    /** Added in 1.0.0 */
    val federation_signed_fetch: Boolean? = null,
    val hide_modlog_mod_names: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val slur_filter_regex: String? = null,
    val rate_limit_message_max_requests: Long? = null,
    val rate_limit_message_interval_seconds: Long? = null,
    val rate_limit_post_max_requests: Long? = null,
    val rate_limit_post_interval_seconds: Long? = null,
    val rate_limit_register_max_requests: Long? = null,
    val rate_limit_register_interval_seconds: Long? = null,
    val rate_limit_image_max_requests: Long? = null,
    val rate_limit_image_interval_seconds: Long? = null,
    val rate_limit_comment_max_requests: Long? = null,
    val rate_limit_comment_interval_seconds: Long? = null,
    val rate_limit_search_max_requests: Long? = null,
    val rate_limit_search_interval_seconds: Long? = null,
    /** Added in 1.0.0 */
    val rate_limit_import_user_settings_max_requests: Long? = null,
    /** Added in 1.0.0 */
    val rate_limit_import_user_settings_interval_seconds: Long? = null,
    val federation_enabled: Boolean? = null,
    /** Removed in 1.0.0 */
    val federation_debug: Boolean? = null,
    /** Removed in 1.0.0 */
    val captcha_enabled: Boolean? = null,
    /** Removed in 1.0.0 */
    val captcha_difficulty: String? = null,
    /** Removed in 1.0.0 */
    val allowed_instances: List<String>? = null,
    /** Removed in 1.0.0 */
    val blocked_instances: List<String>? = null,
    val blocked_urls: List<String>? = null,
    /** Removed in 1.0.0 */
    val taglines: List<String>? = null,
    val registration_mode: RegistrationMode? /* "Closed" | "RequireApplication" | "Open" */ = null,
    val reports_email_admins: Boolean? = null,
    val content_warning: String? = null,
    /** Added in 1.0.0 */
    val oauth_registration: Boolean? = null,
    /** Added in 1.0.0 */
    val post_upvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    /** Added in 1.0.0 */
    val post_downvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    /** Added in 1.0.0 */
    val comment_upvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    /** Added in 1.0.0 */
    val comment_downvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    /** Added in 1.0.0 */
    val suggested_multi_community_id: MultiCommunityId? = null,
    /** Added in 1.0.0 */
    val nsfw_content_disallowed: Boolean? = null,
    /** Added in 1.0.0 */
    val email_notifications_disabled: Boolean? = null,
    /** Added in 1.0.0 */
    val image_mode: ImageMode? /* "none" | "store_link_previews" | "proxy_all_images" */ = null,
    /** Added in 1.0.0 */
    val image_proxy_bypass_domains: String? = null,
    /** Added in 1.0.0 */
    val image_upload_timeout_seconds: Long? = null,
    /** Added in 1.0.0 */
    val image_max_thumbnail_size: Long? = null,
    /** Added in 1.0.0 */
    val image_max_avatar_size: Long? = null,
    /** Added in 1.0.0 */
    val image_max_banner_size: Long? = null,
    /** Added in 1.0.0 */
    val image_max_upload_size: Long? = null,
    /** Added in 1.0.0 */
    val image_allow_video_uploads: Boolean? = null,
    /** Added in 1.0.0 */
    val image_upload_disabled: Boolean? = null,
) : DatatypeRoot
