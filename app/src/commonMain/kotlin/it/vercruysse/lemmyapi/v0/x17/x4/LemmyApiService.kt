package it.vercruysse.lemmyapi.v0.x17.x4

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.ktor.client.*
import it.vercruysse.lemmyapi.LemmyApi.getKtorClient
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.putResult
import it.vercruysse.lemmyapi.v0.x17.x4.datatypes.GetSiteResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.*

/**
 * Barebones implementation for v0.17, not continued due to required effort to support
 * while having a very low usage rate.
 *
 * But I am accepting PRs for this. To fully support v0.17,
 * you need to make new enums that are all lowercase, make transformations that map those enums to the existing ones
 *
 * And whatever other problems show up.
 *
 */
internal class LemmyApiService(val client: HttpClient, actualVersion: Version, baseUrl: String, override var auth: String? = null) :
    LemmyApi(client, actualVersion, baseUrl, auth) {
    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    override suspend fun getSite(form: GetSite): Result<GetSiteResponse> = client.getResult("site", form)

    /**
     * Create your site.
     *
     * @POST("site")
     */
    override suspend fun createSite(form: CreateSite): Result<SiteResponse> = client.postResult("site", form)

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    override suspend fun editSite(form: EditSite): Result<SiteResponse> = client.putResult("site", form)

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    override suspend fun getModlog(form: GetModlog): Result<GetModlogResponse> = client.getResult("modlog", form)

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    override suspend fun search(form: Search): Result<SearchResponse> = client.getResult("search", form)

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    override suspend fun resolveObject(form: ResolveObject): Result<ResolveObjectResponse> = client.getResult("resolve_object", form)

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    override suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse> = client.getResult("community", form)

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    override suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse> = client.postResult("community", form)

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    override suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse> = client.putResult("community", form)

    /**
     * Hide a community from public view.
     *
     * @PUT("community/hide")
     */
    override suspend fun hideCommunity(form: HideCommunity): Result<CommunityResponse> = client.putResult("community/hide", form)

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    override suspend fun listCommunities(form: ListCommunities): Result<ListCommunitiesResponse> = client.getResult("community/list", form)

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    override suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse> = client.postResult("community/follow", form)

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    override suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse> = client.postResult("community/block", form)

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    override suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse> = client.postResult("community/delete", form)

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    override suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse> = client.postResult("community/remove", form)

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    override suspend fun transferCommunity(
        form: TransferCommunity,
    ): Result<CommunityResponse> = client.postResult("community/transfer", form)

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    override suspend fun banFromCommunity(form: BanFromCommunity): Result<BanFromCommunityResponse> =
        client.postResult("community/ban_user", form)

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    override suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse> =
        client.postResult("community/mod", form)

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    override suspend fun getFederatedInstances(form: GetFederatedInstances): Result<GetFederatedInstancesResponse> =
        client.getResult("federated_instances", form)

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    override suspend fun getPost(form: GetPost): Result<GetPostResponse> = client.getResult("post", form)

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    override suspend fun editPost(form: EditPost): Result<PostResponse> = client.putResult("post", form)

    /**
     * Create a post.
     *
     * @POST("post")
     */
    override suspend fun createPost(form: CreatePost): Result<PostResponse> = client.postResult("post", form)

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    override suspend fun getPosts(form: GetPosts): Result<GetPostsResponse> = client.getResult("post/list", form)

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    override suspend fun deletePost(form: DeletePost): Result<PostResponse> = client.postResult("post/delete", form)

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    override suspend fun removePost(form: RemovePost): Result<PostResponse> = client.postResult("post/remove", form)

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse> = client.postResult("post/mark_as_read", form)

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    override suspend fun lockPost(form: LockPost): Result<PostResponse> = client.postResult("post/lock", form)

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    override suspend fun featurePost(form: FeaturePost): Result<PostResponse> = client.postResult("post/feature", form)

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    override suspend fun createPostLike(form: CreatePostLike): Result<PostResponse> = client.postResult("post/like", form)

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    override suspend fun savePost(form: SavePost): Result<PostResponse> = client.putResult("post/save", form)

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    override suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse> = client.postResult("post/report", form)

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    override suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse> =
        client.putResult("post/report/resolve", form)

    /**
     * List post reports.
     *
     * @GET("post/report/list")
     */
    override suspend fun listPostReports(
        form: ListPostReports,
    ): Result<ListPostReportsResponse> = client.getResult("post/report/list", form)

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    override suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse> =
        client.getResult("post/site_metadata", form)

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    override suspend fun getComment(form: GetComment): Result<CommentResponse> = client.getResult("comment", form)

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    override suspend fun createComment(form: CreateComment): Result<CommentResponse> = client.postResult("comment", form)

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    override suspend fun editComment(form: EditComment): Result<CommentResponse> = client.putResult("comment", form)

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    override suspend fun getComments(form: GetComments): Result<GetCommentsResponse> = client.getResult("comment/list", form)

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    override suspend fun deleteComment(form: DeleteComment): Result<CommentResponse> = client.postResult("comment/delete", form)

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    override suspend fun removeComment(form: RemoveComment): Result<CommentResponse> = client.postResult("comment/remove", form)

    /**
     * Mark a comment as read.
     *
     * @POST("comment/mark_as_read")
     */
    override suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse> =
        client.postResult("comment/mark_as_read", form)

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    override suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse> =
        client.postResult("comment/distinguish", form)

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    override suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse> = client.postResult("comment/like", form)

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    override suspend fun saveComment(form: SaveComment): Result<CommentResponse> = client.putResult("comment/save", form)

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    override suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse> =
        client.postResult("comment/report", form)

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    override suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse> =
        client.putResult("comment/report/resolve", form)

    /**
     * List comment reports.
     *
     * @GET("comment/report/list")
     */
    override suspend fun listCommentReports(form: ListCommentReports): Result<ListCommentReportsResponse> =
        client.getResult("comment/report/list", form)

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    override suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse> =
        client.putResult("private_message", form)

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse> =
        client.postResult("private_message", form)

    /**
     * Get / fetch private messages.
     *
     * @GET("private_message/list")
     */
    override suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse> =
        client.getResult("private_message/list", form)

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    override suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse> =
        client.postResult("private_message/delete", form)

    /**
     * Mark a private message as read.
     *
     * @POST("private_message/mark_as_read")
     */
    override suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse> =
        client.postResult("private_message/mark_as_read", form)

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    override suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse> =
        client.postResult("private_message/report", form)

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    override suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse> =
        client.putResult("private_message/report/resolve", form)

    /**
     * List private message reports.
     *
     * @GET("private_message/report/list")
     */
    override suspend fun listPrivateMessageReports(form: ListPrivateMessageReports): Result<ListPrivateMessageReportsResponse> =
        client.getResult("private_message/report/list", form)

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    override suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse> = client.getResult("user", form)

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    override suspend fun register(form: Register): Result<LoginResponse> = client.postResult("user/register", form)

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    override suspend fun getCaptcha(form: GetCaptcha): Result<GetCaptchaResponse> = client.getResult("user/get_captcha", form)

    /**
     * Get mentions for your user.
     *
     * @GET("user/mention")
     */
    override suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse> =
        client.getResult("user/mention", form)

    /**
     * Mark a person mention as read.
     *
     * @POST("user/mention/mark_as_read")
     */
    override suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse> =
        client.postResult("user/mention/mark_as_read", form)

    /**
     * Get comment replies.
     *
     * @GET("user/replies")
     */
    override suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse> = client.getResult("user/replies", form)

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    override suspend fun banPerson(form: BanPerson): Result<BanPersonResponse> = client.postResult("user/ban", form)

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    override suspend fun getBannedPersons(form: GetBannedPersons): Result<BannedPersonsResponse> = client.getResult("user/banned", form)

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    override suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse> = client.postResult("user/block", form)

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    override suspend fun login(form: Login): Result<LoginResponse> = client.postResult("user/login", form)

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    override suspend fun deleteAccount(form: DeleteAccount): Result<Unit> = client.postResult("user/delete_account", form)

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    override suspend fun passwordReset(form: PasswordReset): Result<Unit> = client.postResult("user/password_reset", form)

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    override suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Result<Unit> =
        client.postResult("user/password_change", form)

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    override suspend fun markAllAsRead(form: MarkAllAsRead): Result<GetRepliesResponse> = client.postResult("user/mark_all_as_read", form)

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    override suspend fun saveUserSettings(form: SaveUserSettings): Result<LoginResponse> = client.putResult("user/save_user_settings", form)

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    override suspend fun changePassword(form: ChangePassword): Result<LoginResponse> = client.putResult("user/change_password", form)

    /**
     * Get counts for your reports
     *
     * @GET("user/report_count")
     */
    override suspend fun getReportCount(form: GetReportCount): Result<GetReportCountResponse> = client.getResult("user/report_count", form)

    /**
     * Get your unread counts
     *
     * @GET("user/unread_count")
     */
    override suspend fun getUnreadCount(form: GetUnreadCount): Result<GetUnreadCountResponse> = client.getResult("user/unread_count", form)

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    override suspend fun verifyEmail(form: VerifyEmail): Result<Unit> = client.postResult("user/verify_email", form)

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    override suspend fun leaveAdmin(form: LeaveAdmin): Result<GetSiteResponse> = client.postResult("user/leave_admin", form)

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    override suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse> = client.postResult("admin/add", form)

    /**
     * Get the unread registration applications count.
     *
     * @GET("admin/registration_application/count")
     */
    override suspend fun getUnreadRegistrationApplicationCount(
        form: GetUnreadRegistrationApplicationCount,
    ): Result<GetUnreadRegistrationApplicationCountResponse> = client.getResult("admin/registration_application/count", form)

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    override suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<ListRegistrationApplicationsResponse> =
        client.getResult("admin/registration_application/list", form)

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    override suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse> =
        client.putResult("admin/registration_application/approve", form)

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    override suspend fun purgePerson(form: PurgePerson): Result<Unit> = client.postResult("admin/purge/person", form)

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    override suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit> = client.postResult("admin/purge/community", form)

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    override suspend fun purgePost(form: PurgePost): Result<Unit> = client.postResult("admin/purge/post", form)

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    override suspend fun purgeComment(form: PurgeComment): Result<Unit> = client.postResult("admin/purge/comment", form)

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    override suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse> = client.putResult("custom_emoji", form)

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    override suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse> = client.postResult("custom_emoji", form)

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    override suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit> = client.postResult("custom_emoji/delete", form)
}

suspend fun main() {
    val api = LemmyApiService(getKtorClient("https://animoe.xyz/api/v3/"), "0.17.4".toVersion(), "") // v0.17.4
    println(api.version)
    println(api.getSite(GetSite()).getOrThrow())
    // Throws because apparently enums are full lowercase in v0.17.4 D:
    // Caused by: kotlinx.serialization.SerializationException: it.vercruysse.lemmyapi.dto.RegistrationMode does not contain element with name 'requireapplication' at path $.site_view.local_site.registration_mode
}
