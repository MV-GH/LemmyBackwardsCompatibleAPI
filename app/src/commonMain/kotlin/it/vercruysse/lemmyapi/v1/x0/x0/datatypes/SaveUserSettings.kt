package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteShow
import kotlinx.serialization.Serializable

@Serializable
internal data class SaveUserSettings(
    val show_nsfw: Boolean? = null,
    val blur_nsfw: Boolean? = null,
    val theme: String? = null,
    val default_listing_type: ListingType? /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */ = null,
    val post_listing_mode: PostListingMode? /* "list" | "card" | "small_card" */ = null,
    val default_post_sort_type: SortType? /* "active" | "hot" | "new" | "old" | "top" | "most_comments" | "new_comments" | "controversial" | "scaled" */ = null,
    val default_post_time_range_seconds: Long? = null,
    val default_items_per_page: Long? = null,
    val default_comment_sort_type: CommentSortType? /* "hot" | "top" | "new" | "old" | "controversial" */ = null,
    val interface_language: String? = null,
    val display_name: String? = null,
    val email: SensitiveString? = null,
    val bio: String? = null,
    val matrix_user_id: String? = null,
    val show_avatars: Boolean? = null,
    val show_media: Boolean? = null,
    val send_notifications_to_email: Boolean? = null,
    val bot_account: Boolean? = null,
    val show_bot_accounts: Boolean? = null,
    val show_read_posts: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val blocking_keywords: List<String>? = null,
    val open_links_in_new_tab: Boolean? = null,
    val infinite_scroll_enabled: Boolean? = null,
    val animated_images_enabled: Boolean? = null,
    val private_messages_enabled: Boolean? = null,
    val collapse_bot_comments: Boolean? = null,
    val show_score: Boolean? = null,
    val show_upvotes: Boolean? = null,
    val show_downvotes: VoteShow? /* "show" | "show_for_others" | "hide" */ = null,
    val show_upvote_percentage: Boolean? = null,
    val auto_mark_fetched_posts_as_read: Boolean? = null,
    val hide_posts_with_media: Boolean? = null,
    val show_person_votes: Boolean? = null,
)
