package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.FederationMode
import it.vercruysse.lemmyapi.dto.RegistrationMode
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class EditSite(
    val name: String? = null,
    val sidebar: String? = null,
    val description: String? = null,
    val community_creation_admin_only: Boolean? = null,
    val require_email_verification: Boolean? = null,
    val application_question: String? = null,
    val private_instance: Boolean? = null,
    val default_theme: String? = null,
    val default_post_listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" | "Suggested" */ = null,
    val default_post_listing_mode: PostListingMode? /* "List" | "Card" | "SmallCard" */ = null,
    val default_post_sort_type: SortType? /* "Active" | "Hot" | "New" | "Old" | "Top" | "MostComments" | "NewComments" | "Controversial" | "Scaled" */ = null,
    val default_post_time_range_seconds: Long? = null,
    val default_items_per_page: Long? = null,
    val default_comment_sort_type: SortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val legal_information: String? = null,
    val application_email_admins: Boolean? = null,
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
    val rate_limit_import_user_settings_max_requests: Long? = null,
    val rate_limit_import_user_settings_interval_seconds: Long? = null,
    val federation_enabled: Boolean? = null,
    val captcha_enabled: Boolean? = null,
    val captcha_difficulty: String? = null,
    val blocked_urls: List<String>? = null,
    val registration_mode: RegistrationMode? /* "Closed" | "RequireApplication" | "Open" */ = null,
    val reports_email_admins: Boolean? = null,
    val content_warning: String? = null,
    val oauth_registration: Boolean? = null,
    val post_upvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    val post_downvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    val comment_upvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    val comment_downvotes: FederationMode? /* "All" | "Local" | "Disable" */ = null,
    val disallow_nsfw_content: Boolean? = null,
    val disable_email_notifications: Boolean? = null,
    val suggested_communities: MultiCommunityId? = null,
)
