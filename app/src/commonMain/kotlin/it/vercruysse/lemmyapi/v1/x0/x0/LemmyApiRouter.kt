package it.vercruysse.lemmyapi.v1.x0.x0

import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.AuthBaseClient
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.*

internal abstract class LemmyApiRouter(client: HttpClient, auth: String?) : AuthBaseClient(client, auth) {

    /** @GET("site") */
    abstract suspend fun getSite(): Result<GetSiteResponse>

    /** @POST("site") */
    abstract suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /** @PUT("site") */
    abstract suspend fun editSite(form: EditSite): Result<SiteResponse>

    /** @GET("modlog") */
    abstract suspend fun getModlog(form: GetModlog): Result<PagedResponse<ModlogView>>

    /** @GET("search") */
    abstract suspend fun search(form: Search): Result<SearchResponse>

    /** @GET("resolve_object") */
    abstract suspend fun resolveObject(form: ResolveObject): Result<SearchResponse>

    /** @GET("community") */
    abstract suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /** @POST("community") */
    abstract suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /** @PUT("community") */
    abstract suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /** @DELETE("community") */
    abstract suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /** @PUT("community/hide") */
    abstract suspend fun hideCommunity(form: HideCommunity): Result<Unit>

    /** @GET("community/list") */
    abstract suspend fun listCommunities(form: ListCommunities): Result<PagedResponse<CommunityView>>

    /** @POST("community/follow") */
    abstract suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /** @POST("community/remove") */
    abstract suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /** @POST("community/transfer") */
    abstract suspend fun transferCommunity(form: TransferCommunity): Result<GetCommunityResponse>

    /** @POST("community/ban_user") */
    abstract suspend fun banFromCommunity(form: BanFromCommunity): Result<PersonResponse>

    /** @POST("community/mod") */
    abstract suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /** @GET("community/random") */
    abstract suspend fun getRandomCommunity(form: GetRandomCommunity): Result<CommunityResponse>

    /** @POST("community/report") */
    abstract suspend fun createCommunityReport(form: CreateCommunityReport): Result<CommunityReportResponse>

    /** @PUT("community/report/resolve") */
    abstract suspend fun resolveCommunityReport(form: ResolveCommunityReport): Result<CommunityReportResponse>

    /** @POST("community/tag") */
    abstract suspend fun createCommunityTag(form: CreateCommunityTag): Result<CommunityTag>

    /** @PUT("community/tag") */
    abstract suspend fun editCommunityTag(form: EditCommunityTag): Result<CommunityTag>

    /** @DELETE("community/tag") */
    abstract suspend fun deleteCommunityTag(form: DeleteCommunityTag): Result<CommunityTag>

    /** @PUT("community/notifications") */
    abstract suspend fun editCommunityNotifications(form: EditCommunityNotifications): Result<Unit>

    /** @POST("community/pending_follows/approve") */
    abstract suspend fun approveCommunityPendingFollow(form: ApproveCommunityPendingFollower): Result<Unit>

    /** @GET("community/pending_follows/list") */
    abstract suspend fun listCommunityPendingFollows(form: ListCommunityPendingFollows): Result<PagedResponse<PendingFollowerView>>

    /** @GET("federated_instances") */
    abstract suspend fun getFederatedInstances(form: GetFederatedInstances): Result<PagedResponse<FederatedInstanceView>>

    /** @GET("post") */
    abstract suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /** @POST("post") */
    abstract suspend fun createPost(form: CreatePost): Result<PostResponse>

    /** @PUT("post") */
    abstract suspend fun editPost(form: EditPost): Result<PostResponse>

    /** @DELETE("post") */
    abstract suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /** @GET("post/list") */
    abstract suspend fun getPosts(form: GetPosts): Result<PagedResponse<PostView>>

    /** @POST("post/remove") */
    abstract suspend fun removePost(form: RemovePost): Result<PostResponse>

    /** @POST("post/mark_as_read") */
    abstract suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse>

    /** @POST("post/mark_as_read/many") */
    abstract suspend fun markManyPostsAsRead(form: MarkManyPostsAsRead): Result<Unit>

    /** @POST("post/lock") */
    abstract suspend fun lockPost(form: LockPost): Result<PostResponse>

    /** @POST("post/feature") */
    abstract suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /** @POST("post/like") */
    abstract suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /** @PUT("post/save") */
    abstract suspend fun savePost(form: SavePost): Result<PostResponse>

    /** @POST("post/report") */
    abstract suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /** @PUT("post/report/resolve") */
    abstract suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /** @GET("post/site_metadata") */
    abstract suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /** @POST("post/hide") */
    abstract suspend fun hidePost(form: HidePost): Result<PostResponse>

    /** @GET("post/like/list") */
    abstract suspend fun listPostLikes(form: ListPostLikes): Result<PagedResponse<VoteView>>

    /** @PUT("post/mod_edit") */
    abstract suspend fun modEditPost(form: ModEditPost): Result<PostResponse>

    /** @PUT("post/notifications") */
    abstract suspend fun editPostNotifications(form: EditPostNotifications): Result<Unit>

    /** @POST("post/warn") */
    abstract suspend fun warnPost(form: CreatePostWarning): Result<PostResponse>

    /** @GET("comment") */
    abstract suspend fun getComment(form: GetComment): Result<CommentResponse>

    /** @POST("comment") */
    abstract suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /** @PUT("comment") */
    abstract suspend fun editComment(form: EditComment): Result<CommentResponse>

    /** @DELETE("comment") */
    abstract suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /** @GET("comment/list") */
    abstract suspend fun getComments(form: GetComments): Result<PagedResponse<CommentView>>

    /** @GET("comment/list/slim") */
    abstract suspend fun getCommentsSlim(form: GetComments): Result<PagedResponse<CommentSlimView>>

    /** @POST("comment/remove") */
    abstract suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /** @POST("comment/lock") */
    abstract suspend fun lockComment(form: LockComment): Result<CommentResponse>

    /** @POST("comment/distinguish") */
    abstract suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /** @POST("comment/like") */
    abstract suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /** @PUT("comment/save") */
    abstract suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /** @POST("comment/report") */
    abstract suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /** @PUT("comment/report/resolve") */
    abstract suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /** @GET("comment/like/list") */
    abstract suspend fun listCommentLikes(form: ListCommentLikes): Result<PagedResponse<VoteView>>

    /** @POST("comment/warn") */
    abstract suspend fun warnComment(form: CreateCommentWarning): Result<CommentResponse>

    /** @POST("private_message") */
    abstract suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /** @PUT("private_message") */
    abstract suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /** @DELETE("private_message") */
    abstract suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /** @POST("private_message/report") */
    abstract suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /** @PUT("private_message/report/resolve") */
    abstract suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /** @GET("person") */
    abstract suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /** @GET("person/content") */
    abstract suspend fun listPersonContent(form: ListPersonContent): Result<PagedResponse<PostCommentCombinedView>>

    /** @POST("person/note") */
    abstract suspend fun notePerson(form: NotePerson): Result<Unit>

    /** @GET("account") */
    abstract suspend fun getMyUser(): Result<MyUserInfo>

    /** @DELETE("account") */
    abstract suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /** @POST("account/auth/login") */
    abstract suspend fun login(form: Login): Result<LoginResponse>

    /** @POST("account/auth/logout") */
    abstract suspend fun logout(): Result<Unit>

    /** @POST("account/auth/register") */
    abstract suspend fun register(form: Register): Result<LoginResponse>

    /** @GET("account/auth/get_captcha") */
    abstract suspend fun getCaptcha(): Result<GetCaptchaResponse>

    /** @POST("account/auth/password_reset") */
    abstract suspend fun resetPassword(form: ResetPassword): Result<Unit>

    /** @POST("account/auth/password_change") */
    abstract suspend fun changePasswordAfterReset(form: ChangePasswordAfterReset): Result<Unit>

    /** @PUT("account/auth/change_password") */
    abstract suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /** @POST("account/auth/verify_email") */
    abstract suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /** @POST("account/auth/resend_verification_email") */
    abstract suspend fun resendVerificationEmail(form: ResendVerificationEmail): Result<Unit>

    /** @POST("account/auth/totp/generate") */
    abstract suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse>

    /** @POST("account/auth/totp/edit") */
    abstract suspend fun editTotp(form: EditTotp): Result<EditTotpResponse>

    /** @PUT("account/settings/save") */
    abstract suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit>

    /** @GET("account/settings/export") */
    abstract suspend fun exportUserSettings(): Result<ExportUserSettingsResponse>

    /** @POST("account/settings/import") */
    abstract suspend fun importUserSettings(form: ImportUserSettings): Result<Unit>

    /** @POST("account/block/community") */
    abstract suspend fun blockCommunity(form: BlockCommunity): Result<CommunityResponse>

    /** @POST("account/block/person") */
    abstract suspend fun blockPerson(form: BlockPerson): Result<PersonResponse>

    /** @POST("account/block/instance/communities") */
    abstract suspend fun userBlockInstanceCommunities(form: UserBlockInstanceCommunitiesParams): Result<Unit>

    /** @POST("account/block/instance/persons") */
    abstract suspend fun userBlockInstancePersons(form: UserBlockInstancePersonsParams): Result<Unit>

    /** @POST("account/donation_dialog_shown") */
    abstract suspend fun markDonationDialogShown(): Result<Unit>

    /** @GET("account/login/list") */
    abstract suspend fun listLogins(): Result<ListLoginsResponse>

    /** @GET("account/validate_auth") */
    abstract suspend fun validateAuth(): Result<Unit>

    /** @GET("account/unread_counts") */
    abstract suspend fun getUnreadCounts(): Result<UnreadCountsResponse>

    /** @POST("account/notification/mark_as_read") */
    abstract suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit>

    /** @POST("account/notification/mark_as_read/all") */
    abstract suspend fun markAllNotificationsAsRead(): Result<Unit>

    /** @GET("account/notification/list") */
    abstract suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<NotificationView>>

    /** @GET("account/saved") */
    abstract suspend fun listPersonSaved(form: ListPersonSaved): Result<PagedResponse<PostCommentCombinedView>>

    /** @GET("account/read") */
    abstract suspend fun listPersonRead(form: ListPersonRead): Result<PagedResponse<PostView>>

    /** @GET("account/hidden") */
    abstract suspend fun listPersonHidden(form: ListPersonHidden): Result<PagedResponse<PostView>>

    /** @GET("account/liked") */
    abstract suspend fun listPersonLiked(form: ListPersonLiked): Result<PagedResponse<PostCommentCombinedView>>

    /** @GET("account/media/list") */
    abstract suspend fun listMedia(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /** @POST("admin/add") */
    abstract suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /** @POST("admin/ban") */
    abstract suspend fun banPerson(form: BanPerson): Result<PersonResponse>

    /** @POST("admin/leave") */
    abstract suspend fun leaveAdmin(): Result<GetSiteResponse>

    /** @GET("admin/registration_application") */
    abstract suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse>

    /** @PUT("admin/registration_application/approve") */
    abstract suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse>

    /** @GET("admin/registration_application/list") */
    abstract suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<PagedResponse<RegistrationApplicationView>>

    /** @POST("admin/purge/person") */
    abstract suspend fun purgePerson(form: PurgePerson): Result<Unit>

    /** @POST("admin/purge/community") */
    abstract suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit>

    /** @POST("admin/purge/post") */
    abstract suspend fun purgePost(form: PurgePost): Result<Unit>

    /** @POST("admin/purge/comment") */
    abstract suspend fun purgeComment(form: PurgeComment): Result<Unit>

    /** @POST("admin/instance/block") */
    abstract suspend fun adminBlockInstance(form: AdminBlockInstanceParams): Result<Unit>

    /** @POST("admin/instance/allow") */
    abstract suspend fun adminAllowInstance(form: AdminAllowInstanceParams): Result<Unit>

    /** @POST("admin/tagline") */
    abstract suspend fun createTagline(form: CreateTagline): Result<TaglineResponse>

    /** @PUT("admin/tagline") */
    abstract suspend fun editTagline(form: EditTagline): Result<TaglineResponse>

    /** @DELETE("admin/tagline") */
    abstract suspend fun deleteTagline(form: DeleteTagline): Result<Unit>

    /** @GET("admin/tagline/list") */
    abstract suspend fun listTaglines(form: ListTaglines): Result<PagedResponse<Tagline>>

    /** @GET("admin/users") */
    abstract suspend fun adminListUsers(form: AdminListUsers): Result<PagedResponse<LocalUserView>>

    /** @POST("custom_emoji") */
    abstract suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /** @PUT("custom_emoji") */
    abstract suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /** @POST("custom_emoji/delete") */
    abstract suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit>

    /** @GET("custom_emoji/list") */
    abstract suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse>

    /** @POST("oauth/authenticate") */
    abstract suspend fun authenticateWithOAuth(form: AuthenticateWithOauth): Result<LoginResponse>

    /** @POST("oauth_provider") */
    abstract suspend fun createOAuthProvider(form: CreateOAuthProvider): Result<AdminOAuthProvider>

    /** @PUT("oauth_provider") */
    abstract suspend fun editOAuthProvider(form: EditOAuthProvider): Result<AdminOAuthProvider>

    /** @DELETE("oauth_provider") */
    abstract suspend fun deleteOAuthProvider(form: DeleteOAuthProvider): Result<Unit>

    /** @GET("report/list") */
    abstract suspend fun listReports(form: ListReports): Result<PagedResponse<ReportCombinedView>>

    /** @GET("multi_community") */
    abstract suspend fun getMultiCommunity(form: GetMultiCommunity): Result<GetMultiCommunityResponse>

    /** @POST("multi_community") */
    abstract suspend fun createMultiCommunity(form: CreateMultiCommunity): Result<MultiCommunityResponse>

    /** @PUT("multi_community") */
    abstract suspend fun editMultiCommunity(form: EditMultiCommunity): Result<MultiCommunityResponse>

    /** @POST("multi_community/entry") */
    abstract suspend fun createMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<CommunityResponse>

    /** @DELETE("multi_community/entry") */
    abstract suspend fun deleteMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<Unit>

    /** @POST("multi_community/follow") */
    abstract suspend fun followMultiCommunity(form: FollowMultiCommunity): Result<MultiCommunityResponse>

    /** @GET("multi_community/list") */
    abstract suspend fun listMultiCommunities(form: ListMultiCommunities): Result<PagedResponse<MultiCommunityView>>

    /** @DELETE("image") */
    abstract suspend fun deleteMediaAdmin(form: DeleteImageParams): Result<Unit>

    /** @GET("image/health") */
    abstract suspend fun imageHealth(): Result<Unit>

    /** @GET("image/list") */
    abstract suspend fun listMediaAdmin(form: ListMedia): Result<PagedResponse<LocalImageView>>

    /** @POST("image") */
    abstract suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse>

    /** @DELETE("account/media") */
    abstract suspend fun deleteMedia(form: DeleteImageParams): Result<Unit>

    /** @POST("community/banner") */
    abstract suspend fun uploadCommunityBanner(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /** @POST("community/icon") */
    abstract suspend fun uploadCommunityIcon(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse>

    /** @POST("site/banner") */
    abstract suspend fun uploadSiteBanner(image: ByteArray): Result<UploadImageResponse>

    /** @POST("site/icon") */
    abstract suspend fun uploadSiteIcon(image: ByteArray): Result<UploadImageResponse>

    /** @POST("account/avatar") */
    abstract suspend fun uploadUserAvatar(image: ByteArray): Result<UploadImageResponse>

    /** @POST("account/banner") */
    abstract suspend fun uploadUserBanner(image: ByteArray): Result<UploadImageResponse>

    /** @DELETE("account/avatar") */
    abstract suspend fun deleteUserAvatar(): Result<Unit>

    /** @DELETE("account/banner") */
    abstract suspend fun deleteUserBanner(): Result<Unit>

    /** @DELETE("community/banner") */
    abstract suspend fun deleteCommunityBanner(form: CommunityIdQuery): Result<Unit>

    /** @DELETE("community/icon") */
    abstract suspend fun deleteCommunityIcon(form: CommunityIdQuery): Result<Unit>

    /** @DELETE("site/banner") */
    abstract suspend fun deleteSiteBanner(): Result<Unit>

    /** @DELETE("site/icon") */
    abstract suspend fun deleteSiteIcon(): Result<Unit>
}
