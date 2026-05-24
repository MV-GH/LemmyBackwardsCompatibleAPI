package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.ImageMode
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.RegistrationMode
import it.vercruysse.lemmyapi.enums.SortType
import kotlinx.serialization.Serializable

@Serializable
internal data class CreateSite(
    val name: String,
    val sidebar: String? = null,
    val summary: String? = null,
    val community_creation_admin_only: Boolean? = null,
    val email_verification_required: Boolean? = null,
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
    val registration_mode: RegistrationMode? /* "closed" | "require_application" | "open" */ = null,
    val oauth_registration: Boolean? = null,
    val content_warning: String? = null,
    val reports_email_admins: Boolean? = null,
    val federation_signed_fetch: Boolean? = null,
    val post_upvotes: FederationMode? /* "all" | "local" | "disable" */ = null,
    val post_downvotes: FederationMode? /* "all" | "local" | "disable" */ = null,
    val comment_upvotes: FederationMode? /* "all" | "local" | "disable" */ = null,
    val comment_downvotes: FederationMode? /* "all" | "local" | "disable" */ = null,
    val nsfw_content_disallowed: Boolean? = null,
    val email_notifications_disabled: Boolean? = null,
    val suggested_multi_community_id: MultiCommunityId? = null,
    val image_mode: ImageMode? /* "none" | "store_link_previews" | "proxy_all_images" */ = null,
    val image_proxy_bypass_domains: String? = null,
    val image_upload_timeout_seconds: Long? = null,
    val image_max_thumbnail_size: Long? = null,
    val image_max_avatar_size: Long? = null,
    val image_max_banner_size: Long? = null,
    val image_max_upload_size: Long? = null,
    val image_allow_video_uploads: Boolean? = null,
    val image_upload_disabled: Boolean? = null,
)
