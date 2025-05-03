package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class SaveUserSettings(
    val show_nsfw: Boolean? = null,
    val blur_nsfw: Boolean? = null,
    val theme: String? = null,
    val default_listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val post_listing_mode: PostListingMode? /* "List" | "Card" | "SmallCard" */ = null,
    val default_post_sort_type: SortType? /* "Active" | "Hot" | "New" | "Old" | "Top" | "MostComments" | "NewComments" | "Controversial" | "Scaled" */ = null,
    val default_post_time_range_seconds: Long? = null,
    val default_comment_sort_type: SortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val interface_language: String? = null,
    val display_name: String? = null,
    val email: SensitiveString? = null,
    val bio: String? = null,
    val matrix_user_id: String? = null,
    val show_avatars: Boolean? = null,
    val send_notifications_to_email: Boolean? = null,
    val bot_account: Boolean? = null,
    val show_bot_accounts: Boolean? = null,
    val show_read_posts: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val blocking_keywords: List<String>? = null,
    val open_links_in_new_tab: Boolean? = null,
    val infinite_scroll_enabled: Boolean? = null,
    val enable_keyboard_navigation: Boolean? = null,
    val enable_animated_images: Boolean? = null,
    val enable_private_messages: Boolean? = null,
    val collapse_bot_comments: Boolean? = null,
    val show_scores: Boolean? = null,
    val show_upvotes: Boolean? = null,
    val show_downvotes: Boolean? = null,
    val show_upvote_percentage: Boolean? = null,
    val auto_mark_fetched_posts_as_read: Boolean? = null,
    val hide_media: Boolean? = null,
)
