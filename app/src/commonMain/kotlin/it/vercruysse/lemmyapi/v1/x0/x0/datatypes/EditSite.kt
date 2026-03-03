package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.RegistrationMode
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class EditSite(
    val name: String? = null,
    val sidebar: String? = null,
    val summary: String? = null,
    val community_creation_admin_only: Boolean? = null,
    val require_email_verification: Boolean? = null,
    val application_question: String? = null,
    val private_instance: Boolean? = null,
    val default_theme: String? = null,
    val default_post_listing_type: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val default_post_listing_mode: PostListingMode? /* "list" | "card" | "small_card" */ = null,
    val default_post_sort_type: SortType? /* "active" | "hot" | "new" | "old" | "top" | "most_comments" | "new_comments" | "controversial" | "scaled" */ = null,
    val default_post_time_range_seconds: Long? = null,
    val default_items_per_page: Long? = null,
    val default_comment_sort_type: SortType? /* "hot" | "top" | "new" | "old" | "controversial" */ = null,
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
    val registration_mode: RegistrationMode? /* "closed" | "require_application" | "open" */ = null,
    val reports_email_admins: Boolean? = null,
    val content_warning: String? = null,
    val oauth_registration: Boolean? = null,
    val post_upvotes: RegistrationMode? /* "all" | "local" | "disable" */ = null,
    val post_downvotes: RegistrationMode? /* "all" | "local" | "disable" */ = null,
    val comment_upvotes: RegistrationMode? /* "all" | "local" | "disable" */ = null,
    val comment_downvotes: RegistrationMode? /* "all" | "local" | "disable" */ = null,
    val disallow_nsfw_content: Boolean? = null,
    val disable_email_notifications: Boolean? = null,
    val suggested_multi_community_id: MultiCommunityId? = null,
)
