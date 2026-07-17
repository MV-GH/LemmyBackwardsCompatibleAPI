package it.vercruysse.lemmyapi

import it.vercruysse.lemmyapi.datatypes.*
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings

interface UniRoutes {

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    suspend fun getSite(): Result<GetSiteResponse>

    /**
     * Create your site.
     *
     * @POST("site")
     */
    suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    suspend fun editSite(form: EditSite): Result<SiteResponse>

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    suspend fun getModlog(form: GetModlog): Result<PagedResponse<ModlogView>>

    /**
     * Search lemmy. If `search_term` is a url it also attempts to fetch it, just like `resolve_object`.
     *
     * @GET("search")
     */
    suspend fun search(form: Search): Result<SearchResponse>

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    suspend fun resolveObject(form: ResolveObject): Result<SearchResponse>

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /**
     * Hide a community from public / "All" view. Admins only.
     *
     * @PUT("community/hide")
     */
    suspend fun hideCommunity(form: HideCommunity): Result<Unit>

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    suspend fun listCommunities(form: ListCommunities): Result<PagedResponse<CommunityView>>

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    suspend fun blockCommunity(form: BlockCommunity): Result<CommunityResponse>

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    suspend fun transferCommunity(form: TransferCommunity): Result<GetCommunityResponse>

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    suspend fun banFromCommunity(form: BanFromCommunity): Result<PersonResponse>

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    suspend fun getFederatedInstances(form: GetFederatedInstances): Result<PagedResponse<FederatedInstanceView>>

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    suspend fun editPost(form: EditPost): Result<PostResponse>

    /**
     * Create a post.
     *
     * @POST("post")
     */
    suspend fun createPost(form: CreatePost): Result<PostResponse>

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    suspend fun getPosts(form: GetPosts): Result<PagedResponse<PostView>>

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    suspend fun removePost(form: RemovePost): Result<PostResponse>

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse>

    /**
     * Mark multiple posts as read.
     *
     * @POST("post/mark_as_read")
     */
    suspend fun markManyPostsAsRead(form: MarkManyPostsAsRead): Result<Unit>

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    suspend fun lockPost(form: LockPost): Result<PostResponse>

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    suspend fun savePost(form: SavePost): Result<PostResponse>

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /**
     * List user reports.
     */
    suspend fun listReports(form: ListReports): Result<PagedResponse<ReportCombinedView>>

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    suspend fun getComment(form: GetComment): Result<CommentResponse>

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    suspend fun editComment(form: EditComment): Result<CommentResponse>

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    suspend fun getComments(form: GetComments): Result<PagedResponse<CommentView>>

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /**
     * List persons.
     *
     * @GET("person/list")
     */
    suspend fun listPersons(form: ListPersons): Result<PagedResponse<PersonView>>

    /**
     * List the content for a person.
     *
     * @GET("person/content")
     */
    suspend fun listPersonContent(form: ListPersonContent): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    suspend fun register(form: Register): Result<LoginResponse>

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    suspend fun getCaptcha(): Result<GetCaptchaResponse>

    /**
     * Mark a notification as read.
     */
    suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit>

    /**
     * Get your inbox (replies, comment mentions, post mentions, and messages).
     */
    suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<NotificationView>>

    /**
     * Ban a person from your site.
     *
     * @POST("admin/ban")
     */
    suspend fun banPerson(form: BanPerson): Result<PersonResponse>

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    suspend fun blockPerson(form: BlockPerson): Result<PersonResponse>

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    suspend fun login(form: Login): Result<LoginResponse>

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    suspend fun resetPassword(form: ResetPassword): Result<Unit>

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    suspend fun changePasswordAfterReset(form: ChangePasswordAfterReset): Result<Unit>

    /**
     * Mark all notifications as read.
     *
     * @POST("user/mark_all_as_read")
     */
    suspend fun markAllNotificationsAsRead(): Result<Unit>

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit>

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /**
     * Returns the amount of unread items of various types. For normal users this means
     * the number of unread notifications, mods and admins get additional unread counts for
     * reports, registration applications and pending follows to private communities.
     *
     * @GET("account/unread_counts")
     */
    suspend fun getUnreadCounts(): Result<UnreadCountsResponse>

    /**
     * Verify your email.
     *
     * @POST("user/verify_email")
     */
    suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    suspend fun leaveAdmin(): Result<GetSiteResponse>

    /**
     * Mark the donation dialog as shown, so it isn't displayed anymore.
     *
     * @POST("user/donation_dialog_shown")
     */
    suspend fun markDonationDialogShown(): Result<Unit>

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /**
     * Create a new registration invitation.
     *
     * @POST("account/invite")
     */
    suspend fun createRegistrationInvitation(form: CreateInvitation): Result<CreateInvitationResponse>

    /**
     * Revoke a previously created registration invitation.
     *
     * @DELETE("account/invite")
     */
    suspend fun revokeRegistrationInvitation(form: RevokeInvitation): Result<Unit>

    /**
     * List previously created registration invitations.
     *
     * @GET("account/invite")
     */
    suspend fun listRegistrationInvitations(form: ListInvitations): Result<PagedResponse<LocalUserInvite>>

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<PagedResponse<RegistrationApplicationView>>

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse>

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    suspend fun purgePerson(form: PurgePerson): Result<Unit>

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit>

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    suspend fun purgePost(form: PurgePost): Result<Unit>

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    suspend fun purgeComment(form: PurgeComment): Result<Unit>

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit>

    /**
     * List custom emojis
     *
     * @GET("custom_emoji/list")
     */
    suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse>

    /**
     * Block an instance's communities as a user.
     *
     * @POST("site/block")
     */
    suspend fun userBlockInstanceCommunities(form: UserBlockInstanceCommunitiesParams): Result<Unit>

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/account/auth/totp/edit` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse>

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/account/auth/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    suspend fun editTotp(form: EditTotp): Result<EditTotpResponse>

    /**
     * Export a backup of your user settings, including your saved content,
     * followed communities, and blocks.
     *
     * @GET("user/export_settings")
     */
    suspend fun exportUserSettings(): Result<ExportUserSettingsResponse>

    /**
     * Import a backup of your user settings.
     *
     * @POST("user/import_settings")
     */
    suspend fun importUserSettings(form: ImportUserSettings): Result<Unit>

    /**
     * List login tokens for your user
     *
     * @GET("user/list_logins")
     */
    suspend fun listLogins(): Result<ListLoginsResponse>

    /**
     * Returns an error message if your auth token is invalid
     *
     * @GET("user/validate_auth")
     */
    suspend fun validateAuth(): Result<Unit>

    /**
     * Get data of current user.
     *
     * @GET("/account")
     */
    suspend fun getMyUser(): Result<MyUserInfo>

    /**
     * Invalidate the currently used auth token.
     *
     * @POST("user/logout")
     */
    suspend fun logout(): Result<Unit>

    /**
     * List a post's likes. Admin-only.
     *
     * @GET("post/like/list")
     */
    suspend fun listPostLikes(form: ListPostLikes): Result<PagedResponse<VoteView>>

    /**
     * List a comment's likes. Admin-only.
     *
     * @GET("comment/like/list")
     */
    suspend fun listCommentLikes(form: ListCommentLikes): Result<PagedResponse<VoteView>>

    /**
     * List all the media for your user
     *
     * @GET("account/list_media")
     */
    suspend fun listMedia(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /**
     * List all the media known to your instance.
     *
     * @GET("admin/list_all_media")
     */
    suspend fun listMediaAdmin(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /**
     * Hide a post from list views.
     *
     * @POST("post/hide")
     */
    suspend fun hidePost(form: HidePost): Result<PostResponse>

    /**
     * Hide multiple posts from list views.
     *
     * @POST("post/hide")
     */
    suspend fun hidePosts(form: HidePosts): Result<Unit>

    /**
     * Get the application a user submitted when they first registered their account
     *
     * @GET("admin/registration_application")
     */
    suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse>

    /**
     * Get a list of users.
     *
     * @GET("admin/users")
     */
    suspend fun adminListUsers(form: AdminListUsers): Result<PagedResponse<LocalUserView>>

    /**
     * Upload a generic image.
     *
     * @POST("image")
     */
    suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse>

    /**
     * Delete media for your account.
     *
     * @DELETE("account/media")
     */
    suspend fun deleteMedia(form: DeleteImageParams): Result<Unit>

    /**
     * Upload new user avatar.
     *
     * @POST("account/avatar")
     */
    suspend fun uploadUserAvatar(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a user banner image.
     *
     * @POST("account/banner")
     */
    suspend fun uploadUserBanner(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a site banner image.
     *
     * @POST("site/banner")
     */
    suspend fun uploadSiteBanner(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload new site icon.
     *
     * @POST("site/icon")
     */
    suspend fun uploadSiteIcon(image: ByteArray): Result<UploadImageResponse>

    /**
     * Upload a community banner image.
     *
     * @POST("community/banner")
     */
    suspend fun uploadCommunityBanner(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /**
     * Upload a community icon image.
     *
     * @POST("community/icon")
     */
    suspend fun uploadCommunityIcon(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /**
     * Delete the user avatar.
     *
     * @DELETE("account/avatar")
     */
    suspend fun deleteUserAvatar(): Result<Unit>

    /**
     * Delete a user banner image.
     *
     * @DELETE("account/banner")
     */
    suspend fun deleteUserBanner(): Result<Unit>

    /**
     * Delete a community banner image.
     *
     * @DELETE("community/banner")
     */
    suspend fun deleteCommunityBanner(form: CommunityIdQuery): Result<Unit>

    /**
     * Delete a community icon image.
     *
     * @DELETE("community/icon")
     */
    suspend fun deleteCommunityIcon(form: CommunityIdQuery): Result<Unit>

    /**
     * Delete a site banner image.
     *
     * @DELETE("site/banner")
     */
    suspend fun deleteSiteBanner(): Result<Unit>

    /**
     * Delete the site icon.
     *
     * @DELETE("site/icon")
     */
    suspend fun deleteSiteIcon(): Result<Unit>

    /**
     * Get a random community.
     *
     * @GET("community/random")
     */
    suspend fun getRandomCommunity(form: GetRandomCommunity): Result<CommunityResponse>

    /**
     * Report a community.
     *
     * @POST("community/report")
     */
    suspend fun createCommunityReport(form: CreateCommunityReport): Result<CommunityReportResponse>

    /**
     * Resolve a community report.
     *
     * @PUT("community/report/resolve")
     */
    suspend fun resolveCommunityReport(form: ResolveCommunityReport): Result<CommunityReportResponse>

    /**
     * Create a community tag.
     *
     * @POST("community/tag")
     */
    suspend fun createCommunityTag(form: CreateCommunityTag): Result<CommunityTag>

    /**
     * Edit a community tag.
     *
     * @PUT("community/tag")
     */
    suspend fun editCommunityTag(form: EditCommunityTag): Result<CommunityTag>

    /**
     * Delete a community tag.
     *
     * @DELETE("community/tag")
     */
    suspend fun deleteCommunityTag(form: DeleteCommunityTag): Result<CommunityTag>

    /**
     * Edit community notifications.
     *
     * @PUT("community/notifications")
     */
    suspend fun editCommunityNotifications(form: EditCommunityNotifications): Result<Unit>

    /**
     * Approve a community pending follower.
     *
     * @POST("community/pending_follows/approve")
     */
    suspend fun approveCommunityPendingFollow(form: ApproveCommunityPendingFollower): Result<Unit>

    /**
     * List community pending follows.
     *
     * @GET("community/pending_follows/list")
     */
    suspend fun listCommunityPendingFollows(form: ListCommunityPendingFollows): Result<PagedResponse<PendingFollowerView>>

    /**
     * Mods can change nsfw flag and tags for a post.
     *
     * @PUT("post/mod_edit")
     */
    suspend fun modEditPost(form: ModEditPost): Result<PostResponse>

    /**
     * Change notification settings for a post.
     *
     * @PUT("post/notifications")
     */
    suspend fun editPostNotifications(form: EditPostNotifications): Result<Unit>

    /**
     * Creates a warning against a post and notifies the user.
     *
     * @POST("post/warn")
     */
    suspend fun warnPost(form: CreatePostWarning): Result<PostResponse>

    /**
     * Get slim comment list.
     *
     * @GET("comment/list/slim")
     */
    suspend fun getCommentsSlim(form: GetComments): Result<PagedResponse<CommentSlimView>>

    /**
     * Lock a comment.
     *
     * @POST("comment/lock")
     */
    suspend fun lockComment(form: LockComment): Result<CommentResponse>

    /**
     * Warn a comment.
     *
     * @POST("comment/warn")
     */
    suspend fun warnComment(form: CreateCommentWarning): Result<CommentResponse>

    /**
     * Make a note for a person.
     *
     * @POST("person/note")
     */
    suspend fun notePerson(form: NotePerson): Result<Unit>

    /**
     * List your saved content.
     *
     * @GET("account/saved")
     */
    suspend fun listPersonSaved(form: ListPersonSaved): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * List your read content.
     *
     * @GET("account/read")
     */
    suspend fun listPersonRead(form: ListPersonRead): Result<PagedResponse<PostView>>

    /**
     * List hidden posts for a person.
     *
     * @GET("account/hidden")
     */
    suspend fun listPersonHidden(form: ListPersonHidden): Result<PagedResponse<PostView>>

    /**
     * List your liked content.
     *
     * @GET("account/liked")
     */
    suspend fun listPersonLiked(form: ListPersonLiked): Result<PagedResponse<PostCommentCombinedView>>

    /**
     * Resend a verification email.
     *
     * @POST("account/auth/resend_verification_email")
     */
    suspend fun resendVerificationEmail(form: ResendVerificationEmail): Result<Unit>

    /**
     * Authenticate with OAuth.
     *
     * @POST("oauth/authenticate")
     */
    suspend fun authenticateWithOAuth(form: AuthenticateWithOauth): Result<LoginResponse>

    /**
     * Block an instance's persons as a user.
     *
     * @POST("account/block/instance/persons")
     */
    suspend fun userBlockInstancePersons(form: UserBlockInstancePersonsParams): Result<Unit>

    /**
     * Globally allow an instance as admin.
     *
     * @POST("admin/instance/allow")
     */
    suspend fun adminAllowInstance(form: AdminAllowInstanceParams): Result<Unit>

    /**
     * Globally block an instance as admin.
     *
     * @POST("admin/instance/block")
     */
    suspend fun adminBlockInstance(form: AdminBlockInstanceParams): Result<Unit>

    /**
     * Create a new tagline.
     *
     * @POST("admin/tagline")
     */
    suspend fun createTagline(form: CreateTagline): Result<TaglineResponse>

    /**
     * Edit an existing tagline.
     *
     * @PUT("admin/tagline")
     */
    suspend fun editTagline(form: EditTagline): Result<TaglineResponse>

    /**
     * Delete a tagline.
     *
     * @DELETE("admin/tagline")
     */
    suspend fun deleteTagline(form: DeleteTagline): Result<Unit>

    /**
     * List taglines.
     *
     * @GET("admin/tagline/list")
     */
    suspend fun listTaglines(form: ListTaglines): Result<PagedResponse<Tagline>>

    /**
     * Create a new OAuth provider method.
     *
     * @POST("oauth_provider")
     */
    suspend fun createOAuthProvider(form: CreateOAuthProvider): Result<AdminOAuthProvider>

    /**
     * Edit an existing OAuth provider method.
     *
     * @PUT("oauth_provider")
     */
    suspend fun editOAuthProvider(form: EditOAuthProvider): Result<AdminOAuthProvider>

    /**
     * Delete an OAuth provider method.
     *
     * @DELETE("oauth_provider")
     */
    suspend fun deleteOAuthProvider(form: DeleteOAuthProvider): Result<Unit>

    /**
     * Get a multi-community.
     *
     * @GET("multi_community")
     */
    suspend fun getMultiCommunity(form: GetMultiCommunity): Result<GetMultiCommunityResponse>

    /**
     * Create a multi-community.
     *
     * @POST("multi_community")
     */
    suspend fun createMultiCommunity(form: CreateMultiCommunity): Result<MultiCommunityResponse>

    /**
     * Edit a multi-community.
     *
     * @PUT("multi_community")
     */
    suspend fun editMultiCommunity(form: EditMultiCommunity): Result<MultiCommunityResponse>

    /**
     * Add a community to a multi-community.
     *
     * @POST("multi_community/entry")
     */
    suspend fun createMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<CommunityResponse>

    /**
     * Remove a community from a multi-community.
     *
     * @DELETE("multi_community/entry")
     */
    suspend fun deleteMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<Unit>

    /**
     * Follow a multi-community.
     *
     * @POST("multi_community/follow")
     */
    suspend fun followMultiCommunity(form: FollowMultiCommunity): Result<MultiCommunityResponse>

    /**
     * List multi-communities.
     *
     * @GET("multi_community/list")
     */
    suspend fun listMultiCommunities(form: ListMultiCommunities): Result<PagedResponse<MultiCommunityView>>

    /**
     * Delete admin media.
     *
     * @DELETE("image")
     */
    suspend fun deleteMediaAdmin(form: DeleteImageParams): Result<Unit>

    /**
     * Check image service health.
     *
     * @GET("image/health")
     */
    suspend fun imageHealth(): Result<Unit>
}
