package it.vercruysse.lemmyapi.v0x19

import io.github.z4kn4fein.semver.Version
import io.ktor.client.*
import it.vercruysse.lemmyapi.utils.addAuth
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.putResult
import it.vercruysse.lemmyapi.v0x19.datatypes.*

class LemmyApiService(
    private val defaultKtor: HttpClient,
    actualVersion: Version,
    baseUrl: String,
    auth: String? = null,
) : LemmyApi(defaultKtor, actualVersion, baseUrl, auth) {
    var ktor: HttpClient = defaultKtor.addAuth(auth)

    override var auth: String?
        get() = super.auth
        set(value) {
            super.auth = value
            ktor = defaultKtor.addAuth(value)
        }

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    override suspend fun getSite(): Result<GetSiteResponse> = ktor.getResult("site")

    /**
     * Create your site.
     *
     * @POST("site")
     */
    override suspend fun createSite(form: CreateSite): Result<SiteResponse> = ktor.postResult("site", form)

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    override suspend fun editSite(form: EditSite): Result<SiteResponse> = ktor.putResult("site", form)

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    override suspend fun getModlog(form: GetModlog): Result<GetModlogResponse> = ktor.getResult("modlog", form)

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    override suspend fun search(form: Search): Result<SearchResponse> =
        ktor.getResult("search", form)

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    override suspend fun resolveObject(form: ResolveObject): Result<ResolveObjectResponse> =
        ktor.getResult("resolve_object", form)

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    override suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse> = ktor.getResult("community", form)

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    override suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse> = ktor.postResult("community", form)

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    override suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse> = ktor.putResult("community", form)

    /**
     * Hide a community from public view.
     *
     * @PUT("community/hide")
     */
    override suspend fun hideCommunity(form: HideCommunity): Result<Unit> = ktor.putResult("community/hide", form)

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    override suspend fun listCommunities(form: ListCommunities): Result<ListCommunitiesResponse> = ktor.getResult("community/list", form)

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    override suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse> = ktor.postResult("community/follow", form)

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    override suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse> = ktor.postResult("community/block", form)

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    override suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse> = ktor.postResult("community/delete", form)

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    override suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse> = ktor.postResult("community/remove", form)

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    override suspend fun transferCommunity(form: TransferCommunity): Result<CommunityResponse> = ktor.postResult("community/transfer", form)

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    override suspend fun banFromCommunity(form: BanFromCommunity): Result<BanFromCommunityResponse> =
        ktor.postResult("community/ban_user", form)

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    override suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse> =
        ktor.postResult("community/mod", form)

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    override suspend fun getFederatedInstances(): Result<GetFederatedInstancesResponse> = ktor.getResult("federated_instances")

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    override suspend fun getPost(form: GetPost): Result<GetPostResponse> = ktor.getResult("post", form)

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    override suspend fun editPost(form: EditPost): Result<PostResponse> = ktor.putResult("post", form)

    /**
     * Create a post.
     *
     * @POST("post")
     */
    override suspend fun createPost(form: CreatePost): Result<PostResponse> = ktor.postResult("post", form)

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    override suspend fun getPosts(form: GetPosts): Result<GetPostsResponse> =
        ktor.getResult(
            "post/list",
            form.copy(page = if (form.page_cursor != null) null else form.page),
        )

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    override suspend fun deletePost(form: DeletePost): Result<PostResponse> = ktor.postResult("post/delete", form)

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    override suspend fun removePost(form: RemovePost): Result<PostResponse> = ktor.postResult("post/remove", form)

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markPostAsRead(form: MarkPostAsRead): Result<Unit> = ktor.postResult("post/mark_as_read", form)

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    override suspend fun lockPost(form: LockPost): Result<PostResponse> = ktor.postResult("post/lock", form)

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    override suspend fun featurePost(form: FeaturePost): Result<PostResponse> = ktor.postResult("post/feature", form)

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    override suspend fun createPostLike(form: CreatePostLike): Result<PostResponse> = ktor.postResult("post/like", form)

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    override suspend fun savePost(form: SavePost): Result<PostResponse> = ktor.putResult("post/save", form)

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    override suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse> = ktor.postResult("post/report", form)

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    override suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse> =
        ktor.putResult("post/report/resolve", form)

    /**
     * List post reports.
     *
     * @GET("post/report/list")
     */
    override suspend fun listPostReports(form: ListPostReports): Result<ListPostReportsResponse> = ktor.getResult("post/report/list", form)

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    override suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse> =
        ktor.getResult("post/site_metadata", form)

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    override suspend fun getComment(form: GetComment): Result<CommentResponse> = ktor.getResult("comment", form)

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    override suspend fun createComment(form: CreateComment): Result<CommentResponse> = ktor.postResult("comment", form)

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    override suspend fun editComment(form: EditComment): Result<CommentResponse> = ktor.putResult("comment", form)

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    override suspend fun getComments(form: GetComments): Result<GetCommentsResponse> = ktor.getResult("comment/list", form)

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    override suspend fun deleteComment(form: DeleteComment): Result<CommentResponse> = ktor.postResult("comment/delete", form)

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    override suspend fun removeComment(form: RemoveComment): Result<CommentResponse> = ktor.postResult("comment/remove", form)

    /**
     * Mark a comment as read.
     *
     * @POST("comment/mark_as_read")
     */
    override suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse> =
        ktor.postResult("comment/mark_as_read", form)

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    override suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse> =
        ktor.postResult("comment/distinguish", form)

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    override suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse> = ktor.postResult("comment/like", form)

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    override suspend fun saveComment(form: SaveComment): Result<CommentResponse> = ktor.putResult("comment/save", form)

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    override suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse> =
        ktor.postResult("comment/report", form)

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    override suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse> =
        ktor.putResult("comment/report/resolve", form)

    /**
     * List comment reports.
     *
     * @GET("comment/report/list")
     */
    override suspend fun listCommentReports(form: ListCommentReports): Result<ListCommentReportsResponse> =
        ktor.getResult("comment/report/list", form)

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    override suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse> =
        ktor.putResult("private_message", form)

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse> =
        ktor.postResult("private_message", form)

    /**
     * Get / fetch private messages.
     *
     * @GET("private_message/list")
     */
    override suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse> =
        ktor.getResult("private_message/list", form)

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    override suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse> =
        ktor.postResult("private_message/delete", form)

    /**
     * Mark a private message as read.
     *
     * @POST("private_message/mark_as_read")
     */
    override suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse> =
        ktor.postResult("private_message/mark_as_read", form)

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    override suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse> =
        ktor.postResult("private_message/report", form)

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    override suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse> =
        ktor.putResult("private_message/report/resolve", form)

    /**
     * List private message reports.
     *
     * @GET("private_message/report/list")
     */
    override suspend fun listPrivateMessageReports(form: ListPrivateMessageReports): Result<ListPrivateMessageReportsResponse> =
        ktor.getResult("private_message/report/list", form)

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    override suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse> = ktor.getResult("user", form)

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    override suspend fun register(form: Register): Result<LoginResponse> = ktor.postResult("user/register", form)

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    override suspend fun getCaptcha(): Result<GetCaptchaResponse> = ktor.getResult("user/get_captcha")

    /**
     * Get mentions for your user.
     *
     * @GET("user/mention")
     */
    override suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse> =
        ktor.getResult("user/mention", form)

    /**
     * Mark a person mention as read.
     *
     * @POST("user/mention/mark_as_read")
     */
    override suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse> =
        ktor.postResult("user/mention/mark_as_read", form)

    /**
     * Get comment replies.
     *
     * @GET("user/replies")
     */
    override suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse> = ktor.getResult("user/replies", form)

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    override suspend fun banPerson(form: BanPerson): Result<BanPersonResponse> = ktor.postResult("user/ban", form)

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    override suspend fun getBannedPersons(): Result<BannedPersonsResponse> = ktor.getResult("user/banned")

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    override suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse> = ktor.postResult("user/block", form)

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    override suspend fun login(form: Login): Result<LoginResponse> = ktor.postResult("user/login", form)

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    override suspend fun deleteAccount(form: DeleteAccount): Result<Unit> = ktor.postResult("user/delete_account", form)

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    override suspend fun passwordReset(form: PasswordReset): Result<Unit> = ktor.postResult("user/password_reset", form)

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    override suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Result<Unit> =
        ktor.postResult("user/password_change", form)

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    override suspend fun markAllAsRead(): Result<GetRepliesResponse> = ktor.postResult("user/mark_all_as_read")

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    override suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit> = ktor.putResult("user/save_user_settings", form)

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    override suspend fun changePassword(form: ChangePassword): Result<Unit> = ktor.putResult("user/change_password", form)

    /**
     * Get counts for your reports
     *
     * @GET("user/report_count")
     */
    override suspend fun getReportCount(form: GetReportCount): Result<GetReportCountResponse> = ktor.getResult("user/report_count", form)

    /**
     * Get your unread counts
     *
     * @GET("user/unread_count")
     */
    override suspend fun getUnreadCount(): Result<GetUnreadCountResponse> = ktor.getResult("user/unread_count")

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    override suspend fun verifyEmail(form: VerifyEmail): Result<Unit> = ktor.postResult("user/verify_email", form)

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    override suspend fun leaveAdmin(): Result<GetSiteResponse> = ktor.postResult("user/leave_admin")

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    override suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse> = ktor.postResult("admin/add", form)

    /**
     * Get the unread registration applications count.
     *
     * @GET("admin/registration_application/count")
     */
    override suspend fun getUnreadRegistrationApplicationCount(): Result<GetUnreadRegistrationApplicationCountResponse> =
        ktor.getResult("admin/registration_application/count")

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    override suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<ListRegistrationApplicationsResponse> =
        ktor.getResult("admin/registration_application/list", form)

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    override suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse> =
        ktor.putResult("admin/registration_application/approve", form)

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    override suspend fun purgePerson(form: PurgePerson): Result<Unit> = ktor.postResult("admin/purge/person", form)

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    override suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit> = ktor.postResult("admin/purge/community", form)

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    override suspend fun purgePost(form: PurgePost): Result<Unit> = ktor.postResult("admin/purge/post", form)

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    override suspend fun purgeComment(form: PurgeComment): Result<Unit> = ktor.postResult("admin/purge/comment", form)

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    override suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse> = ktor.putResult("custom_emoji", form)

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    override suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse> = ktor.postResult("custom_emoji", form)

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    override suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit> = ktor.postResult("custom_emoji/delete", form)

    /**
     * Block an instance.
     *
     * @POST("site/block")
     */
    override suspend fun blockInstance(form: BlockInstance): Result<BlockInstanceResponse> = ktor.postResult("site/block", form)

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/user/totp/update` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    override suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse> = ktor.postResult("user/totp/generate")

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/user/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    override suspend fun updateTotp(form: UpdateTotp): Result<UpdateTotpResponse> = ktor.postResult("user/totp/update", form)

    /**
     * Export a backup of your user settings, including your saved content,
     * followed communities, and blocks.
     *
     * @GET("user/export_settings")
     */
    override suspend fun getUserExportSettings(): Result<GetUserExportSettingsResponse> = ktor.getResult("user/export_settings")

    /**
     * Import a backup of your user settings.
     *
     * @POST("user/import_settings")
     */
    override suspend fun getUserImportSettings(form: GetUserImportSettings): Result<Unit> = ktor.postResult("user/import_settings", form)

    /**
     * List login tokens for your user
     *
     * @GET("user/list_logins")
     */
    override suspend fun listLogins(): Result<LoginToken> = ktor.getResult("user/list_logins")

    /**
     * Returns an error message if your auth token is invalid
     *
     * @GET("user/validate_auth")
     */
    override suspend fun validateAuth(): Result<Unit> = ktor.getResult("user/validate_auth")

    /**
     * Logout your user
     *
     * @POST("user/logout")
     */
    override suspend fun logout(): Result<Unit> = ktor.postResult("user/logout")

    /**
     * List a post's likes. Admin-only.
     *
     * @GET("post/like/list")
     */
    override suspend fun listPostLikes(form: ListPostLikes): Result<ListPostLikesResponse> =
        ktor.getResult("post/like/list", form)

    /**
     * List a comment's likes. Admin-only.
     *
     * @GET("comment/like/list")
     */
    override suspend fun listCommentLikes(form: ListCommentLikes): Result<ListCommentLikesResponse> =
        ktor.getResult("comment/like/list", form)

    /**
     * List all the media for your user
     *
     * @GET("account/list_media")
     */
    override suspend fun listMedia(form: ListMedia): Result<ListMediaResponse> =
        ktor.getResult("account/list_media", form)

    /**
     * List all the media known to your instance.
     *
     * @GET("admin/list_all_media")
     */
    override suspend fun listAllMedia(form: ListMedia): Result<ListMediaResponse> =
        ktor.getResult("admin/list_all_media", form)

    /**
     * Hide a post from list views.
     *
     * @POST("post/hide")
     */
    override suspend fun hidePost(form: HidePost): Result<Unit> =
        ktor.postResult("post/hide", form)
}
