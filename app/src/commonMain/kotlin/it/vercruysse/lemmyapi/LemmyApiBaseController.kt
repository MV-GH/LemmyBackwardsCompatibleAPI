package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.datatypes.*
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings

abstract class LemmyApiBaseController(actualVersion: Version, baseUrl: String, override var auth: String?) :
    LemmyApiBase(
        actualVersion,
        baseUrl,
        auth,
    ),
    OldRoutes {

    suspend fun uploadAndApplyImage(
        image: ByteArray,
        applyImage: suspend (String) -> Result<Unit>,
    ): Result<UploadImageResponse> = runCatching {
        val uploadResponse = uploadImage(image).getOrThrow()
        try {
            applyImage(uploadResponse.image_url).getOrThrow()
            uploadResponse
        } catch (e: Throwable) {
            deleteMedia(DeleteImageParams(uploadResponse.delete_filename)).getOrNull()
            throw e
        }
    }

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    abstract suspend fun getSite(): Result<GetSiteResponse>

    /**
     * Create your site.
     *
     * @POST("site")
     */
    abstract suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    abstract suspend fun editSite(form: EditSite): Result<SiteResponse>

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    abstract suspend fun getModlog(form: GetModlog): Result<PagedResponse<ModlogView>>

    /**
     * Search lemmy. If `search_term` is a url it also attempts to fetch it, just like `resolve_object`.
     *
     * @GET("search")
     */
    abstract suspend fun search(form: Search): Result<SearchResponse>

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    abstract suspend fun resolveObject(form: ResolveObject): Result<SearchResponse>

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    abstract suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    abstract suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    abstract suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /**
     * Hide a community from public / "All" view. Admins only.
     *
     * @PUT("community/hide")
     */
    abstract suspend fun hideCommunity(form: HideCommunity): Result<Unit>

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    abstract suspend fun listCommunities(form: ListCommunities): Result<PagedResponse<CommunityView>>

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    abstract suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    abstract suspend fun blockCommunity(form: BlockCommunity): Result<CommunityResponse>

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    abstract suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    abstract suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    abstract suspend fun transferCommunity(form: TransferCommunity): Result<GetCommunityResponse>

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    abstract suspend fun banFromCommunity(form: BanFromCommunity): Result<PersonResponse>

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    abstract suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    abstract suspend fun getFederatedInstances(form: GetFederatedInstances): Result<PagedResponse<FederatedInstanceView>>

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    abstract suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    abstract suspend fun editPost(form: EditPost): Result<PostResponse>

    /**
     * Create a post.
     *
     * @POST("post")
     */
    abstract suspend fun createPost(form: CreatePost): Result<PostResponse>

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    abstract suspend fun getPosts(form: GetPosts): Result<PagedResponse<PostView>>

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    abstract suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    abstract suspend fun removePost(form: RemovePost): Result<PostResponse>

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    abstract suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse>

    /**
     * Mark multiple posts as read.
     *
     * @POST("post/mark_as_read")
     */
    abstract suspend fun markManyPostsAsRead(form: MarkManyPostsAsRead): Result<Unit>

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    abstract suspend fun lockPost(form: LockPost): Result<PostResponse>

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    abstract suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    abstract suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    abstract suspend fun savePost(form: SavePost): Result<PostResponse>

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    abstract suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    abstract suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /**
     * List user reports.
     */
    abstract suspend fun listReports(form: ListReports): Result<PagedResponse<ReportCombinedView>>

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    abstract suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    abstract suspend fun getComment(form: GetComment): Result<CommentResponse>

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    abstract suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    abstract suspend fun editComment(form: EditComment): Result<CommentResponse>

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    abstract suspend fun getComments(form: GetComments): Result<PagedResponse<CommentView>>

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    abstract suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    abstract suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    abstract suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    abstract suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    abstract suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    abstract suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    abstract suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    abstract suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    abstract suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    abstract suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    abstract suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    abstract suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    abstract suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /**
     * List persons.
     *
     * @GET("person/list")
     */
    abstract suspend fun listPersons(form: ListPersons): Result<PagedResponse<PersonView>>

    /**
     * List the content for a person.
     *
     * @GET("person/content")
     */
    abstract suspend fun listPersonContent(form: ListPersonContent): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    abstract suspend fun register(form: Register): Result<LoginResponse>

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    abstract suspend fun getCaptcha(): Result<GetCaptchaResponse>

    /**
     * Mark a notification as read.
     */
    abstract suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit>

    /**
     * Get your inbox (replies, comment mentions, post mentions, and messages).
     */
    abstract suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<NotificationView>>

    /**
     * Ban a person from your site.
     *
     * @POST("admin/ban")
     */
    abstract suspend fun banPerson(form: BanPerson): Result<PersonResponse>

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    abstract suspend fun blockPerson(form: BlockPerson): Result<PersonResponse>

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    abstract suspend fun login(form: Login): Result<LoginResponse>

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    abstract suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    abstract suspend fun resetPassword(form: ResetPassword): Result<Unit>

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    abstract suspend fun changePasswordAfterReset(form: ChangePasswordAfterReset): Result<Unit>

    /**
     * Mark all notifications as read.
     *
     * @POST("user/mark_all_as_read")
     */
    abstract suspend fun markAllNotificationsAsRead(): Result<Unit>

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    abstract suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit>

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    abstract suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /**
     * Returns the amount of unread items of various types. For normal users this means
     * the number of unread notifications, mods and admins get additional unread counts for
     * reports, registration applications and pending follows to private communities.
     *
     * @GET("account/unread_counts")
     */
    abstract suspend fun getUnreadCounts(): Result<UnreadCountsResponse>

    /**
     * Verify your email.
     *
     * @POST("user/verify_email")
     */
    abstract suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    abstract suspend fun leaveAdmin(): Result<GetSiteResponse>

    /**
     * Mark the donation dialog as shown, so it isn't displayed anymore.
     *
     * @POST("user/donation_dialog_shown")
     */
    abstract suspend fun markDonationDialogShown(): Result<Unit>

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    abstract suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /**
     * Create a new registration invitation.
     *
     * @POST("account/invite")
     */
    abstract suspend fun createRegistrationInvitation(form: CreateInvitation): Result<CreateInvitationResponse>

    /**
     * Revoke a previously created registration invitation.
     *
     * @DELETE("account/invite")
     */
    abstract suspend fun revokeRegistrationInvitation(form: RevokeInvitation): Result<Unit>

    /**
     * List previously created registration invitations.
     *
     * @GET("account/invite")
     */
    abstract suspend fun listRegistrationInvitations(form: ListInvitations): Result<PagedResponse<LocalUserInvite>>

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    abstract suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<PagedResponse<RegistrationApplicationView>>

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    abstract suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse>

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    abstract suspend fun purgePerson(form: PurgePerson): Result<Unit>

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    abstract suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit>

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    abstract suspend fun purgePost(form: PurgePost): Result<Unit>

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    abstract suspend fun purgeComment(form: PurgeComment): Result<Unit>

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    abstract suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    abstract suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    abstract suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit>

    /**
     * List custom emojis
     *
     * @GET("custom_emoji/list")
     */
    abstract suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse>

    /**
     * Block an instance's communities as a user.
     *
     * @POST("site/block")
     */
    abstract suspend fun userBlockInstanceCommunities(form: UserBlockInstanceCommunitiesParams): Result<Unit>

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/account/auth/totp/edit` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    abstract suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse>

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/account/auth/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    abstract suspend fun editTotp(form: EditTotp): Result<EditTotpResponse>

    /**
     * Export a backup of your user settings, including your saved content,
     * followed communities, and blocks.
     *
     * @GET("user/export_settings")
     */
    abstract suspend fun exportUserSettings(): Result<ExportUserSettingsResponse>

    /**
     * Import a backup of your user settings.
     *
     * @POST("user/import_settings")
     */
    abstract suspend fun importUserSettings(form: ImportUserSettings): Result<Unit>

    /**
     * List login tokens for your user
     *
     * @GET("user/list_logins")
     */
    abstract suspend fun listLogins(): Result<ListLoginsResponse>

    /**
     * Returns an error message if your auth token is invalid
     *
     * @GET("user/validate_auth")
     */
    abstract suspend fun validateAuth(): Result<Unit>

    /**
     * Get data of current user.
     *
     * @GET("/account")
     */
    abstract suspend fun getMyUser(): Result<MyUserInfo>

    /**
     * Invalidate the currently used auth token.
     *
     * @POST("user/logout")
     */
    abstract suspend fun logout(): Result<Unit>

    /**
     * List a post's likes. Admin-only.
     *
     * @GET("post/like/list")
     */
    abstract suspend fun listPostLikes(form: ListPostLikes): Result<PagedResponse<VoteView>>

    /**
     * List a comment's likes. Admin-only.
     *
     * @GET("comment/like/list")
     */
    abstract suspend fun listCommentLikes(form: ListCommentLikes): Result<PagedResponse<VoteView>>

    /**
     * List all the media for your user
     *
     * @GET("account/list_media")
     */
    abstract suspend fun listMedia(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /**
     * List all the media known to your instance.
     *
     * @GET("admin/list_all_media")
     */
    abstract suspend fun listMediaAdmin(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /**
     * Hide a post from list views.
     *
     * @POST("post/hide")
     */
    abstract suspend fun hidePost(form: HidePost): Result<PostResponse>

    /**
     * Hide multiple posts from list views.
     *
     * @POST("post/hide")
     */
    abstract suspend fun hidePosts(form: HidePosts): Result<Unit>

    /**
     * Get the application a user submitted when they first registered their account
     *
     * @GET("admin/registration_application")
     */
    abstract suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse>

    /**
     * Get a list of users.
     *
     * @GET("admin/users")
     */
    abstract suspend fun adminListUsers(form: AdminListUsers): Result<PagedResponse<LocalUserView>>

    /**
     * Upload a generic image.
     *
     * @POST("image")
     */
    abstract suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse>

    /**
     * Delete media for your account.
     *
     * @DELETE("account/media")
     */
    abstract suspend fun deleteMedia(form: DeleteImageParams): Result<Unit>

    /**
     * Upload new user avatar.
     *
     * @POST("account/avatar")
     */
    abstract suspend fun uploadUserAvatar(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a user banner image.
     *
     * @POST("account/banner")
     */
    abstract suspend fun uploadUserBanner(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a site banner image.
     *
     * @POST("site/banner")
     */
    abstract suspend fun uploadSiteBanner(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload new site icon.
     *
     * @POST("site/icon")
     */
    abstract suspend fun uploadSiteIcon(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a community banner image.
     *
     * @POST("community/banner")
     */
    abstract suspend fun uploadCommunityBanner(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /**
     * Upload a community icon image.
     *
     * @POST("community/icon")
     */
    abstract suspend fun uploadCommunityIcon(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /**
     * Delete the user avatar.
     *
     * @DELETE("account/avatar")
     */
    abstract suspend fun deleteUserAvatar(): Result<Unit>

    /**
     * Delete a user banner image.
     *
     * @DELETE("account/banner")
     */
    abstract suspend fun deleteUserBanner(): Result<Unit>

    /**
     * Delete a community banner image.
     *
     * @DELETE("community/banner")
     */
    abstract suspend fun deleteCommunityBanner(form: CommunityIdQuery): Result<Unit>

    /**
     * Delete a community icon image.
     *
     * @DELETE("community/icon")
     */
    abstract suspend fun deleteCommunityIcon(form: CommunityIdQuery): Result<Unit>

    /**
     * Delete a site banner image.
     *
     * @DELETE("site/banner")
     */
    abstract suspend fun deleteSiteBanner(): Result<Unit>

    /**
     * Delete the site icon.
     *
     * @DELETE("site/icon")
     */
    abstract suspend fun deleteSiteIcon(): Result<Unit>

    /**
     * Get a random community.
     *
     * @GET("community/random")
     */
    abstract suspend fun getRandomCommunity(form: GetRandomCommunity): Result<CommunityResponse>

    /**
     * Report a community.
     *
     * @POST("community/report")
     */
    abstract suspend fun createCommunityReport(form: CreateCommunityReport): Result<CommunityReportResponse>

    /**
     * Resolve a community report.
     *
     * @PUT("community/report/resolve")
     */
    abstract suspend fun resolveCommunityReport(form: ResolveCommunityReport): Result<CommunityReportResponse>

    /**
     * Create a community tag.
     *
     * @POST("community/tag")
     */
    abstract suspend fun createCommunityTag(form: CreateCommunityTag): Result<CommunityTag>

    /**
     * Edit a community tag.
     *
     * @PUT("community/tag")
     */
    abstract suspend fun editCommunityTag(form: EditCommunityTag): Result<CommunityTag>

    /**
     * Delete a community tag.
     *
     * @DELETE("community/tag")
     */
    abstract suspend fun deleteCommunityTag(form: DeleteCommunityTag): Result<CommunityTag>

    /**
     * Edit community notifications.
     *
     * @PUT("community/notifications")
     */
    abstract suspend fun editCommunityNotifications(form: EditCommunityNotifications): Result<Unit>

    /**
     * Approve a community pending follower.
     *
     * @POST("community/pending_follows/approve")
     */
    abstract suspend fun approveCommunityPendingFollow(form: ApproveCommunityPendingFollower): Result<Unit>

    /**
     * List community pending follows.
     *
     * @GET("community/pending_follows/list")
     */
    abstract suspend fun listCommunityPendingFollows(form: ListCommunityPendingFollows): Result<PagedResponse<PendingFollowerView>>

    /**
     * Mods can change nsfw flag and tags for a post.
     *
     * @PUT("post/mod_edit")
     */
    abstract suspend fun modEditPost(form: ModEditPost): Result<PostResponse>

    /**
     * Change notification settings for a post.
     *
     * @PUT("post/notifications")
     */
    abstract suspend fun editPostNotifications(form: EditPostNotifications): Result<Unit>

    /**
     * Creates a warning against a post and notifies the user.
     *
     * @POST("post/warn")
     */
    abstract suspend fun warnPost(form: CreatePostWarning): Result<PostResponse>

    /**
     * Get slim comment list.
     *
     * @GET("comment/list/slim")
     */
    abstract suspend fun getCommentsSlim(form: GetComments): Result<PagedResponse<CommentSlimView>>

    /**
     * Lock a comment.
     *
     * @POST("comment/lock")
     */
    abstract suspend fun lockComment(form: LockComment): Result<CommentResponse>

    /**
     * Warn a comment.
     *
     * @POST("comment/warn")
     */
    abstract suspend fun warnComment(form: CreateCommentWarning): Result<CommentResponse>

    /**
     * Make a note for a person.
     *
     * @POST("person/note")
     */
    abstract suspend fun notePerson(form: NotePerson): Result<Unit>

    /**
     * List your saved content.
     *
     * @GET("account/saved")
     */
    abstract suspend fun listPersonSaved(form: ListPersonSaved): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * List your read content.
     *
     * @GET("account/read")
     */
    abstract suspend fun listPersonRead(form: ListPersonRead): Result<PagedResponse<PostView>>

    /**
     * List hidden posts for a person.
     *
     * @GET("account/hidden")
     */
    abstract suspend fun listPersonHidden(form: ListPersonHidden): Result<PagedResponse<PostView>>

    /**
     * List your liked content.
     *
     * @GET("account/liked")
     */
    abstract suspend fun listPersonLiked(form: ListPersonLiked): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * Resend a verification email.
     *
     * @POST("account/auth/resend_verification_email")
     */
    abstract suspend fun resendVerificationEmail(form: ResendVerificationEmail): Result<Unit>

    /**
     * Authenticate with OAuth.
     *
     * @POST("oauth/authenticate")
     */
    abstract suspend fun authenticateWithOAuth(form: AuthenticateWithOauth): Result<LoginResponse>

    /**
     * Block an instance's persons as a user.
     *
     * @POST("account/block/instance/persons")
     */
    abstract suspend fun userBlockInstancePersons(form: UserBlockInstancePersonsParams): Result<Unit>

    /**
     * Globally allow an instance as admin.
     *
     * @POST("admin/instance/allow")
     */
    abstract suspend fun adminAllowInstance(form: AdminAllowInstanceParams): Result<Unit>

    /**
     * Globally block an instance as admin.
     *
     * @POST("admin/instance/block")
     */
    abstract suspend fun adminBlockInstance(form: AdminBlockInstanceParams): Result<Unit>

    /**
     * Create a new tagline.
     *
     * @POST("admin/tagline")
     */
    abstract suspend fun createTagline(form: CreateTagline): Result<TaglineResponse>

    /**
     * Edit an existing tagline.
     *
     * @PUT("admin/tagline")
     */
    abstract suspend fun editTagline(form: EditTagline): Result<TaglineResponse>

    /**
     * Delete a tagline.
     *
     * @DELETE("admin/tagline")
     */
    abstract suspend fun deleteTagline(form: DeleteTagline): Result<Unit>

    /**
     * List taglines.
     *
     * @GET("admin/tagline/list")
     */
    abstract suspend fun listTaglines(form: ListTaglines): Result<PagedResponse<Tagline>>

    /**
     * Create a new OAuth provider method.
     *
     * @POST("oauth_provider")
     */
    abstract suspend fun createOAuthProvider(form: CreateOAuthProvider): Result<AdminOAuthProvider>

    /**
     * Edit an existing OAuth provider method.
     *
     * @PUT("oauth_provider")
     */
    abstract suspend fun editOAuthProvider(form: EditOAuthProvider): Result<AdminOAuthProvider>

    /**
     * Delete an OAuth provider method.
     *
     * @DELETE("oauth_provider")
     */
    abstract suspend fun deleteOAuthProvider(form: DeleteOAuthProvider): Result<Unit>

    /**
     * Get a multi-community.
     *
     * @GET("multi_community")
     */
    abstract suspend fun getMultiCommunity(form: GetMultiCommunity): Result<GetMultiCommunityResponse>

    /**
     * Create a multi-community.
     *
     * @POST("multi_community")
     */
    abstract suspend fun createMultiCommunity(form: CreateMultiCommunity): Result<MultiCommunityResponse>

    /**
     * Edit a multi-community.
     *
     * @PUT("multi_community")
     */
    abstract suspend fun editMultiCommunity(form: EditMultiCommunity): Result<MultiCommunityResponse>

    /**
     * Add a community to a multi-community.
     *
     * @POST("multi_community/entry")
     */
    abstract suspend fun createMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<CommunityResponse>

    /**
     * Remove a community from a multi-community.
     *
     * @DELETE("multi_community/entry")
     */
    abstract suspend fun deleteMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<Unit>

    /**
     * Follow a multi-community.
     *
     * @POST("multi_community/follow")
     */
    abstract suspend fun followMultiCommunity(form: FollowMultiCommunity): Result<MultiCommunityResponse>

    /**
     * List multi-communities.
     *
     * @GET("multi_community/list")
     */
    abstract suspend fun listMultiCommunities(form: ListMultiCommunities): Result<PagedResponse<MultiCommunityView>>

    /**
     * Delete admin media.
     *
     * @DELETE("image")
     */
    abstract suspend fun deleteMediaAdmin(form: DeleteImageParams): Result<Unit>

    /**
     * Check image service health.
     *
     * @GET("image/health")
     */
    abstract suspend fun imageHealth(): Result<Unit>
}
