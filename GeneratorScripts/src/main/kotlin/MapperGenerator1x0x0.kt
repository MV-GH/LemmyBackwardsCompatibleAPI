@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.*

import io.mcarle.konvert.api.Konvert
import io.mcarle.konvert.api.Mapping

//@Konverter(
//    options = [
//        Konfig(key = "konvert.konverter.generate-class", value = "true"),
//        Konfig(key = "konvert.enable-converters", value = "FloatToIntConverter"),
//        Konfig(key = "konvert.add-generated-konverter-annotation", value = "false"),
//    ],
//)
internal interface MapperGenerator1x0x0 {

    fun toUni(d: AddAdminResponse): it.vercruysse.lemmyapi.datatypes.AddAdminResponse
    fun toUni(d: AddModToCommunityResponse): it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse
    fun toUni(d: AdminAllowInstanceParams): it.vercruysse.lemmyapi.datatypes.AdminAllowInstanceParams
    fun toUni(d: AdminBlockInstanceParams): it.vercruysse.lemmyapi.datatypes.AdminBlockInstanceParams
    fun toUni(d: AdminListUsers): it.vercruysse.lemmyapi.datatypes.AdminListUsers
    fun toUni(d: AdminOAuthProvider): it.vercruysse.lemmyapi.datatypes.AdminOAuthProvider
    fun toUni(d: AuthenticateWithOauth): it.vercruysse.lemmyapi.datatypes.AuthenticateWithOauth
    fun toUni(d: CaptchaResponse): it.vercruysse.lemmyapi.datatypes.CaptchaResponse
    fun toUni(d: Comment): it.vercruysse.lemmyapi.datatypes.Comment
    fun toUni(d: CommentActions): it.vercruysse.lemmyapi.datatypes.CommentActions
    fun toUni(d: CommentReport): it.vercruysse.lemmyapi.datatypes.CommentReport
    fun toUni(d: CommentReportResponse): it.vercruysse.lemmyapi.datatypes.CommentReportResponse
    fun toUni(d: CommentReportView): it.vercruysse.lemmyapi.datatypes.CommentReportView
    fun toUni(d: CommentResponse): it.vercruysse.lemmyapi.datatypes.CommentResponse
    fun toUni(d: CommentSlimView): it.vercruysse.lemmyapi.datatypes.CommentSlimView

    @Konvert(mappings = [Mapping(target = "tags", expression = "d.tags.map { this.toUni(d = it) }")])
    fun toUni(d: CommentView): it.vercruysse.lemmyapi.datatypes.CommentView
    fun toUni(d: Community): it.vercruysse.lemmyapi.datatypes.Community
    fun toUni(d: CommunityActions): it.vercruysse.lemmyapi.datatypes.CommunityActions
    fun toUni(d: CommunityFollowerView): it.vercruysse.lemmyapi.datatypes.CommunityFollowerView
    fun toUni(d: CommunityIdQuery): it.vercruysse.lemmyapi.datatypes.CommunityIdQuery
    fun toUni(d: CommunityModeratorView): it.vercruysse.lemmyapi.datatypes.CommunityModeratorView
    fun toUni(d: CommunityReport): it.vercruysse.lemmyapi.datatypes.CommunityReport
    fun toUni(d: CommunityReportResponse): it.vercruysse.lemmyapi.datatypes.CommunityReportResponse
    fun toUni(d: CommunityReportView): it.vercruysse.lemmyapi.datatypes.CommunityReportView
    fun toUni(d: CommunityResponse): it.vercruysse.lemmyapi.datatypes.CommunityResponse
    fun toUni(d: CommunityTag): it.vercruysse.lemmyapi.datatypes.CommunityTag

    @Konvert(mappings = [Mapping(target = "tags", expression = "d.tags.map { this.toUni(d = it) }")])
    fun toUni(d: CommunityView): it.vercruysse.lemmyapi.datatypes.CommunityView
    fun toUni(d: CustomEmoji): it.vercruysse.lemmyapi.datatypes.CustomEmoji
    fun toUni(d: CustomEmojiKeyword): it.vercruysse.lemmyapi.datatypes.CustomEmojiKeyword
    fun toUni(d: CustomEmojiResponse): it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse
    fun toUni(d: CustomEmojiView): it.vercruysse.lemmyapi.datatypes.CustomEmojiView
    fun toUni(d: EditTotpResponse): it.vercruysse.lemmyapi.datatypes.EditTotpResponse

    fun toUni(d: ExportDataResponse): it.vercruysse.lemmyapi.datatypes.ExportDataResponse
    fun toUni(d: FederatedInstanceView): it.vercruysse.lemmyapi.datatypes.FederatedInstanceView
    fun toUni(d: FederationAllowList): it.vercruysse.lemmyapi.datatypes.FederationAllowList
    fun toUni(d: FederationBlockList): it.vercruysse.lemmyapi.datatypes.FederationBlockList
    fun toUni(d: FederationQueueState): it.vercruysse.lemmyapi.datatypes.FederationQueueState
    fun toUni(d: GenerateTotpSecretResponse): it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse
    fun toUni(d: GetCaptchaResponse): it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse
    fun toUni(d: GetCommunityResponse): it.vercruysse.lemmyapi.datatypes.GetCommunityResponse
    fun toUni(d: GetMultiCommunityResponse): it.vercruysse.lemmyapi.datatypes.GetMultiCommunityResponse
    fun toUni(d: GetPersonDetailsResponse): it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse
    fun toUni(d: GetPostResponse): it.vercruysse.lemmyapi.datatypes.GetPostResponse
    fun toUni(d: GetSiteMetadataResponse): it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse
    fun toUni(d: GetSiteResponse): it.vercruysse.lemmyapi.datatypes.GetSiteResponse
    fun toUni(d: ImageDetails): it.vercruysse.lemmyapi.datatypes.ImageDetails
    fun toUni(d: ImageGetParams): it.vercruysse.lemmyapi.datatypes.ImageGetParams
    fun toUni(d: ImageProxyParams): it.vercruysse.lemmyapi.datatypes.ImageProxyParams
    fun toUni(d: Instance): it.vercruysse.lemmyapi.datatypes.Instance
    fun toUni(d: InstanceActions): it.vercruysse.lemmyapi.datatypes.InstanceActions
    fun toUni(d: Language): it.vercruysse.lemmyapi.datatypes.Language
    fun toUni(d: LinkMetadata): it.vercruysse.lemmyapi.datatypes.LinkMetadata
    fun toUni(d: ListCustomEmojisResponse): it.vercruysse.lemmyapi.datatypes.ListCustomEmojisResponse
    fun toUni(d: ListLoginsResponse): it.vercruysse.lemmyapi.datatypes.ListLoginsResponse
    fun toUni(d: LocalImage): it.vercruysse.lemmyapi.datatypes.LocalImage
    fun toUni(d: LocalImageView): it.vercruysse.lemmyapi.datatypes.LocalImageView
    fun toUni(d: LocalSite): it.vercruysse.lemmyapi.datatypes.LocalSite
    fun toUni(d: LocalSiteRateLimit): it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit
    fun toUni(d: LocalSiteUrlBlocklist): it.vercruysse.lemmyapi.datatypes.LocalSiteUrlBlocklist
    fun toUni(d: LocalUser): it.vercruysse.lemmyapi.datatypes.LocalUser
    fun toUni(d: LocalUserView): it.vercruysse.lemmyapi.datatypes.LocalUserView
    fun toUni(d: LoginResponse): it.vercruysse.lemmyapi.datatypes.LoginResponse
    fun toUni(d: LoginToken): it.vercruysse.lemmyapi.datatypes.LoginToken
    fun toUni(d: ModEditPost): it.vercruysse.lemmyapi.datatypes.ModEditPost
    fun toUni(d: Modlog): it.vercruysse.lemmyapi.datatypes.Modlog
    fun toUni(d: ModlogView): it.vercruysse.lemmyapi.datatypes.ModlogView
    fun toUni(d: MultiCommunity): it.vercruysse.lemmyapi.datatypes.MultiCommunity
    fun toUni(d: MultiCommunityEntry): it.vercruysse.lemmyapi.datatypes.MultiCommunityEntry
    fun toUni(d: MultiCommunityFollow): it.vercruysse.lemmyapi.datatypes.MultiCommunityFollow
    fun toUni(d: MultiCommunityResponse): it.vercruysse.lemmyapi.datatypes.MultiCommunityResponse
    fun toUni(d: MultiCommunityView): it.vercruysse.lemmyapi.datatypes.MultiCommunityView
    fun toUni(d: MyUserInfo): it.vercruysse.lemmyapi.datatypes.MyUserInfo
    fun toUni(d: NotePerson): it.vercruysse.lemmyapi.datatypes.NotePerson
    fun toUni(d: Notification): it.vercruysse.lemmyapi.datatypes.Notification

    fun toUni(d: NotificationData): it.vercruysse.lemmyapi.datatypes.NotificationData = when (d) {
        is CommentView -> toUni(d)
        is ModlogView -> toUni(d)
        is PrivateMessageView -> toUni(d)
    }

    @Konvert(mappings = [Mapping(target = "data", expression = "toUni(d.data)")])
    fun toUni(d: NotificationView): it.vercruysse.lemmyapi.datatypes.NotificationView
    fun toUni(d: OAuthAccount): it.vercruysse.lemmyapi.datatypes.OAuthAccount
    fun toUni(d: PendingFollow): it.vercruysse.lemmyapi.datatypes.PendingFollow
    fun toUni(d: PendingFollowerView): it.vercruysse.lemmyapi.datatypes.PendingFollowerView
    fun toUni(d: Person): it.vercruysse.lemmyapi.datatypes.Person
    fun toUni(d: PersonActions): it.vercruysse.lemmyapi.datatypes.PersonActions
    fun toUni(d: PersonResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse
    fun toUni(d: PersonView): it.vercruysse.lemmyapi.datatypes.PersonView
    fun toUni(d: PluginMetadata): it.vercruysse.lemmyapi.datatypes.PluginMetadata
    fun toUni(d: Post): it.vercruysse.lemmyapi.datatypes.Post
    fun toUni(d: PostActions): it.vercruysse.lemmyapi.datatypes.PostActions

    fun toUni(d: PostCommentCombinedView): it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView = when (d) {
        is CommentView -> toUni(d)
        is PostView -> toUni(d)
    }

    fun toUni(d: PostOrCommentOrPrivateMessage): it.vercruysse.lemmyapi.datatypes.PostOrCommentOrPrivateMessage = when (d) {
        is Comment -> toUni(d)
        is Post -> toUni(d)
        is PrivateMessage -> toUni(d)
    }
    fun toUni(d: PostReport): it.vercruysse.lemmyapi.datatypes.PostReport
    fun toUni(d: PostReportResponse): it.vercruysse.lemmyapi.datatypes.PostReportResponse
    fun toUni(d: PostReportView): it.vercruysse.lemmyapi.datatypes.PostReportView
    fun toUni(d: PostResponse): it.vercruysse.lemmyapi.datatypes.PostResponse

    @Konvert(mappings = [Mapping(target = "tags", expression = "d.tags.map { this.toUni(d = it) }")])
    fun toUni(d: PostView): it.vercruysse.lemmyapi.datatypes.PostView
    fun toUni(d: PrivateMessage): it.vercruysse.lemmyapi.datatypes.PrivateMessage
    fun toUni(d: PrivateMessageReport): it.vercruysse.lemmyapi.datatypes.PrivateMessageReport
    fun toUni(d: PrivateMessageReportResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse
    fun toUni(d: PrivateMessageReportView): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView
    fun toUni(d: PrivateMessageResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse
    fun toUni(d: PrivateMessageView): it.vercruysse.lemmyapi.datatypes.PrivateMessageView
    fun toUni(d: PublicOAuthProvider): it.vercruysse.lemmyapi.datatypes.PublicOAuthProvider
    fun toUni(d: RegistrationApplication): it.vercruysse.lemmyapi.datatypes.RegistrationApplication
    fun toUni(d: RegistrationApplicationResponse): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse
    fun toUni(d: RegistrationApplicationView): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView

    // ReportCombinedView is a sealed interface — Konvert cannot generate this automatically.
    fun toUni(d: ReportCombinedView): it.vercruysse.lemmyapi.datatypes.ReportCombinedView = when (d) {
        is CommentReportView -> toUni(d)
        is PostReportView -> toUni(d)
        is CommunityReportView -> toUni(d)
        is PrivateMessageReportView -> toUni(d)
    }

    //    fun toUni(d: ReportCombinedView): already implemented above as when-dispatch
    fun toUni(d: ResendVerificationEmail): it.vercruysse.lemmyapi.datatypes.ResendVerificationEmail
    fun toUni(d: ResolveObjectView): it.vercruysse.lemmyapi.datatypes.ResolveObjectView = when (d) {
        is CommentView -> toUni(d)
        is CommunityView -> toUni(d)
        is PersonView -> toUni(d)
        is PostView -> toUni(d)
        is MultiCommunityView -> toUni(d)
    }
    fun toUni(d: SearchResponse): it.vercruysse.lemmyapi.datatypes.SearchResponse
    fun toUni(d: Site): it.vercruysse.lemmyapi.datatypes.Site
    fun toUni(d: SiteResponse): it.vercruysse.lemmyapi.datatypes.SiteResponse
    fun toUni(d: SiteView): it.vercruysse.lemmyapi.datatypes.SiteView
    fun toUni(d: Tagline): it.vercruysse.lemmyapi.datatypes.Tagline
    fun toUni(d: TaglineResponse): it.vercruysse.lemmyapi.datatypes.TaglineResponse
    fun toUni(d: UnreadCountsResponse): it.vercruysse.lemmyapi.datatypes.UnreadCountsResponse
    fun toUni(d: UploadImageResponse): it.vercruysse.lemmyapi.datatypes.UploadImageResponse
    fun toUni(d: UserBlockInstanceCommunitiesParams): it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams
    fun toUni(d: UserBlockInstancePersonsParams): it.vercruysse.lemmyapi.datatypes.UserBlockInstancePersonsParams
    fun toUni(d: UserSettingsBackup): it.vercruysse.lemmyapi.datatypes.UserSettingsBackup
    @Konvert(mappings = [Mapping(target = "score", expression = "if (d.is_upvote) 1 else -1")])
    fun toUni(d: VoteView): it.vercruysse.lemmyapi.datatypes.VoteView

    // body mappings
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddAdmin): AddAdmin
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddModToCommunity): AddModToCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ApproveCommunityPendingFollower): ApproveCommunityPendingFollower
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanFromCommunity): BanFromCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanPerson): BanPerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockCommunity): BlockCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockPerson): BlockPerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ChangePassword): ChangePassword
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateComment): CreateComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentLike): CreateCommentLike
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentReport): CreateCommentReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentWarning): CreateCommentWarning
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommunity): CreateCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommunityReport): CreateCommunityReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommunityTag): CreateCommunityTag
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji): CreateCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateMultiCommunity): CreateMultiCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateOAuthProvider): CreateOAuthProvider
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateOrDeleteMultiCommunityEntry): CreateOrDeleteMultiCommunityEntry
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePost): CreatePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostLike): CreatePostLike
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostReport): CreatePostReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostWarning): CreatePostWarning
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage): CreatePrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateSite): CreateSite
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateTagline): CreateTagline
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteAccount): DeleteAccount
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteComment): DeleteComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCommunity): DeleteCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCommunityTag): DeleteCommunityTag
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji): DeleteCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteImageParams): DeleteImageParams
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteOAuthProvider): DeleteOAuthProvider
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePost): DeletePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage): DeletePrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteTagline): DeleteTagline
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DistinguishComment): DistinguishComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditComment): EditComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCommunity): EditCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCommunityNotifications): EditCommunityNotifications
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCommunityTag): EditCommunityTag
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCustomEmoji): EditCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditMultiCommunity): EditMultiCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditOAuthProvider): EditOAuthProvider
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPost): EditPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPostNotifications): EditPostNotifications
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPrivateMessage): EditPrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditSite): EditSite
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditTagline): EditTagline
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditTotp): EditTotp
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FeaturePost): FeaturePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FollowCommunity): FollowCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FollowMultiCommunity): FollowMultiCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComment): GetComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComments): GetComments
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetCommunity): GetCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetFederatedInstances): GetFederatedInstances
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetModlog): GetModlog
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetMultiCommunity): GetMultiCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPersonDetails): GetPersonDetails
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPost): GetPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPosts): GetPosts
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetRandomCommunity): GetRandomCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetRegistrationApplication): GetRegistrationApplication
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetSiteMetadata): GetSiteMetadata
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.HideCommunity): HideCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.HidePost): HidePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommentLikes): ListCommentLikes
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommunities): ListCommunities
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommunityPendingFollows): ListCommunityPendingFollows
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCustomEmojis): ListCustomEmojis
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListMedia): ListMedia
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListMultiCommunities): ListMultiCommunities
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListNotifications): ListNotifications
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPersonContent): ListPersonContent
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPersonHidden): ListPersonHidden
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPersonLiked): ListPersonLiked
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPersonRead): ListPersonRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPersonSaved): ListPersonSaved
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPostLikes): ListPostLikes
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications): ListRegistrationApplications
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListReports): ListReports
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListTaglines): ListTaglines
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.LockComment): LockComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.LockPost): LockPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Login): Login
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead): MarkManyPostsAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead): MarkNotificationAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkPostAsRead): MarkPostAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ChangePasswordAfterReset): ChangePasswordAfterReset
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResetPassword): ResetPassword
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeComment): PurgeComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeCommunity): PurgeCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePerson): PurgePerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePost): PurgePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Register): Register
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveComment): RemoveComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveCommunity): RemoveCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemovePost): RemovePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveCommentReport): ResolveCommentReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveCommunityReport): ResolveCommunityReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveObject): ResolveObject
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePostReport): ResolvePostReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveComment): SaveComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SavePost): SavePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveUserSettings): SaveUserSettings
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Search): Search
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.TransferCommunity): TransferCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.VerifyEmail): VerifyEmail
}
