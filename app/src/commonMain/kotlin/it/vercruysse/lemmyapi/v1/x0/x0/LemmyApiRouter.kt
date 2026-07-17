package it.vercruysse.lemmyapi.v1.x0.x0

import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.*

internal interface LemmyApiRouter {

    /** @GET("site") */
    suspend fun getSite(): Result<GetSiteResponse>

    /** @POST("site") */
    suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /** @PUT("site") */
    suspend fun editSite(form: EditSite): Result<SiteResponse>

    /** @GET("modlog") */
    suspend fun getModlog(form: GetModlog): Result<PagedResponse<ModlogView>>

    /** @GET("search") */
    suspend fun search(form: Search): Result<SearchResponse>

    /** @GET("resolve_object") */
    suspend fun resolveObject(form: ResolveObject): Result<SearchResponse>

    /** @GET("community") */
    suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /** @POST("community") */
    suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /** @PUT("community") */
    suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /** @DELETE("community") */
    suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /** @PUT("community/hide") */
    suspend fun hideCommunity(form: HideCommunity): Result<Unit>

    /** @GET("community/list") */
    suspend fun listCommunities(form: ListCommunities): Result<PagedResponse<CommunityView>>

    /** @POST("community/follow") */
    suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /** @POST("community/remove") */
    suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /** @POST("community/transfer") */
    suspend fun transferCommunity(form: TransferCommunity): Result<GetCommunityResponse>

    /** @POST("community/ban_user") */
    suspend fun banFromCommunity(form: BanFromCommunity): Result<PersonResponse>

    /** @POST("community/mod") */
    suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /** @GET("community/random") */
    suspend fun getRandomCommunity(form: GetRandomCommunity): Result<CommunityResponse>

    /** @POST("community/report") */
    suspend fun createCommunityReport(form: CreateCommunityReport): Result<CommunityReportResponse>

    /** @PUT("community/report/resolve") */
    suspend fun resolveCommunityReport(form: ResolveCommunityReport): Result<CommunityReportResponse>

    /** @POST("community/tag") */
    suspend fun createCommunityTag(form: CreateCommunityTag): Result<CommunityTag>

    /** @PUT("community/tag") */
    suspend fun editCommunityTag(form: EditCommunityTag): Result<CommunityTag>

    /** @DELETE("community/tag") */
    suspend fun deleteCommunityTag(form: DeleteCommunityTag): Result<CommunityTag>

    /** @PUT("community/notifications") */
    suspend fun editCommunityNotifications(form: EditCommunityNotifications): Result<Unit>

    /** @POST("community/pending_follows/approve") */
    suspend fun approveCommunityPendingFollow(form: ApproveCommunityPendingFollower): Result<Unit>

    /** @GET("community/pending_follows/list") */
    suspend fun listCommunityPendingFollows(form: ListCommunityPendingFollows): Result<PagedResponse<PendingFollowerView>>

    /** @GET("federated_instances") */
    suspend fun getFederatedInstances(form: GetFederatedInstances): Result<PagedResponse<FederatedInstanceView>>

    /** @GET("post") */
    suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /** @POST("post") */
    suspend fun createPost(form: CreatePost): Result<PostResponse>

    /** @PUT("post") */
    suspend fun editPost(form: EditPost): Result<PostResponse>

    /** @DELETE("post") */
    suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /** @GET("post/list") */
    suspend fun getPosts(form: GetPosts): Result<PagedResponse<PostView>>

    /** @POST("post/remove") */
    suspend fun removePost(form: RemovePost): Result<PostResponse>

    /** @POST("post/mark_as_read") */
    suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse>

    /** @POST("post/mark_as_read/many") */
    suspend fun markManyPostsAsRead(form: MarkManyPostsAsRead): Result<Unit>

    /** @POST("post/lock") */
    suspend fun lockPost(form: LockPost): Result<PostResponse>

    /** @POST("post/feature") */
    suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /** @POST("post/like") */
    suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /** @PUT("post/save") */
    suspend fun savePost(form: SavePost): Result<PostResponse>

    /** @POST("post/report") */
    suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /** @PUT("post/report/resolve") */
    suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /** @GET("post/site_metadata") */
    suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /** @POST("post/hide") */
    suspend fun hidePost(form: HidePost): Result<PostResponse>

    /** @GET("post/like/list") */
    suspend fun listPostLikes(form: ListPostLikes): Result<PagedResponse<VoteView>>

    /** @PUT("post/mod_edit") */
    suspend fun modEditPost(form: ModEditPost): Result<PostResponse>

    /** @PUT("post/notifications") */
    suspend fun editPostNotifications(form: EditPostNotifications): Result<Unit>

    /** @POST("post/warn") */
    suspend fun warnPost(form: CreatePostWarning): Result<PostResponse>

    /** @GET("comment") */
    suspend fun getComment(form: GetComment): Result<CommentResponse>

    /** @POST("comment") */
    suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /** @PUT("comment") */
    suspend fun editComment(form: EditComment): Result<CommentResponse>

    /** @DELETE("comment") */
    suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /** @GET("comment/list") */
    suspend fun getComments(form: GetComments): Result<PagedResponse<CommentView>>

    /** @GET("comment/list/slim") */
    suspend fun getCommentsSlim(form: GetComments): Result<PagedResponse<CommentSlimView>>

    /** @POST("comment/remove") */
    suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /** @POST("comment/lock") */
    suspend fun lockComment(form: LockComment): Result<CommentResponse>

    /** @POST("comment/distinguish") */
    suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /** @POST("comment/like") */
    suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /** @PUT("comment/save") */
    suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /** @POST("comment/report") */
    suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /** @PUT("comment/report/resolve") */
    suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /** @GET("comment/like/list") */
    suspend fun listCommentLikes(form: ListCommentLikes): Result<PagedResponse<VoteView>>

    /** @POST("comment/warn") */
    suspend fun warnComment(form: CreateCommentWarning): Result<CommentResponse>

    /** @POST("private_message") */
    suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /** @PUT("private_message") */
    suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /** @DELETE("private_message") */
    suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /** @POST("private_message/report") */
    suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /** @PUT("private_message/report/resolve") */
    suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /** @GET("person") */
    suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /** @GET("person/list") */
    suspend fun listPersons(form: ListPersons): Result<PagedResponse<PersonView>>

    /** @GET("person/content") */
    suspend fun listPersonContent(form: ListPersonContent): Result<PagedResponse<PostCommentCombinedView>>

    /** @POST("person/note") */
    suspend fun notePerson(form: NotePerson): Result<Unit>

    /** @GET("account") */
    suspend fun getMyUser(): Result<MyUserInfo>

    /** @DELETE("account") */
    suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /** @POST("account/auth/login") */
    suspend fun login(form: Login): Result<LoginResponse>

    /** @POST("account/auth/logout") */
    suspend fun logout(): Result<Unit>

    /** @POST("account/auth/register") */
    suspend fun register(form: Register): Result<LoginResponse>

    /** @GET("account/auth/get_captcha") */
    suspend fun getCaptcha(): Result<GetCaptchaResponse>

    /** @POST("account/auth/password_reset") */
    suspend fun resetPassword(form: ResetPassword): Result<Unit>

    /** @POST("account/auth/password_change") */
    suspend fun changePasswordAfterReset(form: ChangePasswordAfterReset): Result<Unit>

    /** @PUT("account/auth/change_password") */
    suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /** @POST("account/auth/verify_email") */
    suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /** @POST("account/auth/resend_verification_email") */
    suspend fun resendVerificationEmail(form: ResendVerificationEmail): Result<Unit>

    /** @POST("account/auth/totp/generate") */
    suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse>

    /** @POST("account/auth/totp/edit") */
    suspend fun editTotp(form: EditTotp): Result<EditTotpResponse>

    /** @PUT("account/settings/save") */
    suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit>

    /** @GET("account/settings/export") */
    suspend fun exportUserSettings(): Result<ExportUserSettingsResponse>

    /** @POST("account/settings/import") */
    suspend fun importUserSettings(form: ImportUserSettings): Result<Unit>

    /** @POST("account/block/community") */
    suspend fun blockCommunity(form: BlockCommunity): Result<CommunityResponse>

    /** @POST("account/block/person") */
    suspend fun blockPerson(form: BlockPerson): Result<PersonResponse>

    /** @POST("account/block/instance/communities") */
    suspend fun userBlockInstanceCommunities(form: UserBlockInstanceCommunitiesParams): Result<Unit>

    /** @POST("account/block/instance/persons") */
    suspend fun userBlockInstancePersons(form: UserBlockInstancePersonsParams): Result<Unit>

    /** @POST("account/donation_dialog_shown") */
    suspend fun markDonationDialogShown(): Result<Unit>

    /** @GET("account/login/list") */
    suspend fun listLogins(): Result<ListLoginsResponse>

    /** @GET("account/validate_auth") */
    suspend fun validateAuth(): Result<Unit>

    /** @GET("account/unread_counts") */
    suspend fun getUnreadCounts(): Result<UnreadCountsResponse>

    /** @POST("account/notification/mark_as_read") */
    suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit>

    /** @POST("account/notification/mark_as_read/all") */
    suspend fun markAllNotificationsAsRead(): Result<Unit>

    /** @GET("account/notification/list") */
    suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<NotificationView>>

    /** @GET("account/saved") */
    suspend fun listPersonSaved(form: ListPersonSaved): Result<PagedResponse<PostCommentCombinedView>>

    /** @GET("account/read") */
    suspend fun listPersonRead(form: ListPersonRead): Result<PagedResponse<PostView>>

    /** @GET("account/hidden") */
    suspend fun listPersonHidden(form: ListPersonHidden): Result<PagedResponse<PostView>>

    /** @GET("account/liked") */
    suspend fun listPersonLiked(form: ListPersonLiked): Result<PagedResponse<PostCommentCombinedView>>

    /** @POST("account/invite") */
    suspend fun createRegistrationInvitation(form: CreateInvitation): Result<CreateInvitationResponse>

    /** @DELETE("account/invite") */
    suspend fun revokeRegistrationInvitation(form: RevokeInvitation): Result<Unit>

    /** @GET("account/invite") */
    suspend fun listRegistrationInvitations(form: ListInvitations): Result<PagedResponse<LocalUserInvite>>

    /** @GET("account/media/list") */
    suspend fun listMedia(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /** @POST("admin/add") */
    suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /** @POST("admin/ban") */
    suspend fun banPerson(form: BanPerson): Result<PersonResponse>

    /** @POST("admin/leave") */
    suspend fun leaveAdmin(): Result<GetSiteResponse>

    /** @GET("admin/registration_application") */
    suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse>

    /** @PUT("admin/registration_application/approve") */
    suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse>

    /** @GET("admin/registration_application/list") */
    suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<PagedResponse<RegistrationApplicationView>>

    /** @POST("admin/purge/person") */
    suspend fun purgePerson(form: PurgePerson): Result<Unit>

    /** @POST("admin/purge/community") */
    suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit>

    /** @POST("admin/purge/post") */
    suspend fun purgePost(form: PurgePost): Result<Unit>

    /** @POST("admin/purge/comment") */
    suspend fun purgeComment(form: PurgeComment): Result<Unit>

    /** @POST("admin/instance/block") */
    suspend fun adminBlockInstance(form: AdminBlockInstanceParams): Result<Unit>

    /** @POST("admin/instance/allow") */
    suspend fun adminAllowInstance(form: AdminAllowInstanceParams): Result<Unit>

    /** @POST("admin/tagline") */
    suspend fun createTagline(form: CreateTagline): Result<TaglineResponse>

    /** @PUT("admin/tagline") */
    suspend fun editTagline(form: EditTagline): Result<TaglineResponse>

    /** @DELETE("admin/tagline") */
    suspend fun deleteTagline(form: DeleteTagline): Result<Unit>

    /** @GET("admin/tagline/list") */
    suspend fun listTaglines(form: ListTaglines): Result<PagedResponse<Tagline>>

    /** @GET("admin/users") */
    suspend fun adminListUsers(form: AdminListUsers): Result<PagedResponse<LocalUserView>>

    /** @POST("custom_emoji") */
    suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /** @PUT("custom_emoji") */
    suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /** @POST("custom_emoji/delete") */
    suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit>

    /** @GET("custom_emoji/list") */
    suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse>

    /** @POST("oauth/authenticate") */
    suspend fun authenticateWithOAuth(form: AuthenticateWithOauth): Result<LoginResponse>

    /** @POST("oauth_provider") */
    suspend fun createOAuthProvider(form: CreateOAuthProvider): Result<AdminOAuthProvider>

    /** @PUT("oauth_provider") */
    suspend fun editOAuthProvider(form: EditOAuthProvider): Result<AdminOAuthProvider>

    /** @DELETE("oauth_provider") */
    suspend fun deleteOAuthProvider(form: DeleteOAuthProvider): Result<Unit>

    /** @GET("report/list") */
    suspend fun listReports(form: ListReports): Result<PagedResponse<ReportCombinedView>>

    /** @GET("multi_community") */
    suspend fun getMultiCommunity(form: GetMultiCommunity): Result<GetMultiCommunityResponse>

    /** @POST("multi_community") */
    suspend fun createMultiCommunity(form: CreateMultiCommunity): Result<MultiCommunityResponse>

    /** @PUT("multi_community") */
    suspend fun editMultiCommunity(form: EditMultiCommunity): Result<MultiCommunityResponse>

    /** @POST("multi_community/entry") */
    suspend fun createMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<CommunityResponse>

    /** @DELETE("multi_community/entry") */
    suspend fun deleteMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<Unit>

    /** @POST("multi_community/follow") */
    suspend fun followMultiCommunity(form: FollowMultiCommunity): Result<MultiCommunityResponse>

    /** @GET("multi_community/list") */
    suspend fun listMultiCommunities(form: ListMultiCommunities): Result<PagedResponse<MultiCommunityView>>

    /** @DELETE("image") */
    suspend fun deleteMediaAdmin(form: DeleteImageParams): Result<Unit>

    /** @GET("image/health") */
    suspend fun imageHealth(): Result<Unit>

    /** @GET("image/list") */
    suspend fun listMediaAdmin(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /** @POST("image") */
    suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse>

    /** @DELETE("account/media") */
    suspend fun deleteMedia(form: DeleteImageParams): Result<Unit>

    /** @POST("community/banner") */
    suspend fun uploadCommunityBanner(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /** @POST("community/icon") */
    suspend fun uploadCommunityIcon(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /** @POST("site/banner") */
    suspend fun uploadSiteBanner(image: ByteArray): Result<UploadImageResponse>

    /** @POST("site/icon") */
    suspend fun uploadSiteIcon(image: ByteArray): Result<UploadImageResponse>

    /** @POST("account/avatar") */
    suspend fun uploadUserAvatar(image: ByteArray): Result<UploadImageResponse>

    /** @POST("account/banner") */
    suspend fun uploadUserBanner(image: ByteArray): Result<UploadImageResponse>

    /** @DELETE("account/avatar") */
    suspend fun deleteUserAvatar(): Result<Unit>

    /** @DELETE("account/banner") */
    suspend fun deleteUserBanner(): Result<Unit>

    /** @DELETE("community/banner") */
    suspend fun deleteCommunityBanner(form: CommunityIdQuery): Result<Unit>

    /** @DELETE("community/icon") */
    suspend fun deleteCommunityIcon(form: CommunityIdQuery): Result<Unit>

    /** @DELETE("site/banner") */
    suspend fun deleteSiteBanner(): Result<Unit>

    /** @DELETE("site/icon") */
    suspend fun deleteSiteIcon(): Result<Unit>
}
