package it.vercruysse.lemmyapi.v0.x19.x0

import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.*

internal interface MapperGenerator {

    fun toUni(d: CommentReplyView): it.vercruysse.lemmyapi.datatypes.CommentReplyView

    fun toUni(d: CommentReportView): it.vercruysse.lemmyapi.datatypes.CommentReportView

    fun toUni(d: CommentView): it.vercruysse.lemmyapi.datatypes.CommentView

    fun toUni(d: Community): it.vercruysse.lemmyapi.datatypes.Community

    fun toUni(d: CommunityAggregates): it.vercruysse.lemmyapi.datatypes.CommunityAggregates

    fun toUni(d: CommunityView): it.vercruysse.lemmyapi.datatypes.CommunityView

    fun toUni(d: SiteMetadata): it.vercruysse.lemmyapi.datatypes.LinkMetadata =
        it.vercruysse.lemmyapi.datatypes.LinkMetadata(
            title = d.title,
            description = d.description,
            image = d.image,
            embed_video_url = d.embed_video_url,
        )

    fun toUni(d: GetSiteResponse): it.vercruysse.lemmyapi.datatypes.GetSiteResponse

    fun toUni(d: LocalSite): it.vercruysse.lemmyapi.datatypes.LocalSite

    fun toUni(d: PersonMentionView): it.vercruysse.lemmyapi.datatypes.PersonMentionView

    fun toUni(d: PostAggregates): it.vercruysse.lemmyapi.datatypes.PostAggregates

    fun toUni(d: PostReportView): it.vercruysse.lemmyapi.datatypes.PostReportView

    fun toUni(d: PostView): it.vercruysse.lemmyapi.datatypes.PostView

    // GENERATED
    fun toUni(d: AddAdminResponse): it.vercruysse.lemmyapi.datatypes.AddAdminResponse
    fun toUni(d: AddModToCommunityResponse): it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse
    fun toUni(d: AdminPurgeComment): it.vercruysse.lemmyapi.datatypes.AdminPurgeComment
    fun toUni(d: AdminPurgeCommentView): it.vercruysse.lemmyapi.datatypes.AdminPurgeCommentView
    fun toUni(d: AdminPurgeCommunity): it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunity
    fun toUni(d: AdminPurgeCommunityView): it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunityView
    fun toUni(d: AdminPurgePerson): it.vercruysse.lemmyapi.datatypes.AdminPurgePerson
    fun toUni(d: AdminPurgePersonView): it.vercruysse.lemmyapi.datatypes.AdminPurgePersonView
    fun toUni(d: AdminPurgePost): it.vercruysse.lemmyapi.datatypes.AdminPurgePost
    fun toUni(d: AdminPurgePostView): it.vercruysse.lemmyapi.datatypes.AdminPurgePostView
    fun toUni(d: BanFromCommunityResponse): it.vercruysse.lemmyapi.datatypes.BanFromCommunityResponse
    fun toUni(d: BannedPersonsResponse): it.vercruysse.lemmyapi.datatypes.BannedPersonsResponse
    fun toUni(d: BanPersonResponse): it.vercruysse.lemmyapi.datatypes.BanPersonResponse
    fun toUni(d: BlockCommunityResponse): it.vercruysse.lemmyapi.datatypes.BlockCommunityResponse
    fun toUni(d: BlockInstanceResponse): it.vercruysse.lemmyapi.datatypes.BlockInstanceResponse
    fun toUni(d: BlockPersonResponse): it.vercruysse.lemmyapi.datatypes.BlockPersonResponse
    fun toUni(d: CaptchaResponse): it.vercruysse.lemmyapi.datatypes.CaptchaResponse
    fun toUni(d: Comment): it.vercruysse.lemmyapi.datatypes.Comment
    fun toUni(d: CommentAggregates): it.vercruysse.lemmyapi.datatypes.CommentAggregates
    fun toUni(d: CommentReply): it.vercruysse.lemmyapi.datatypes.CommentReply
    fun toUni(d: CommentReplyResponse): it.vercruysse.lemmyapi.datatypes.CommentReplyResponse

    fun toUni(d: CommentReport): it.vercruysse.lemmyapi.datatypes.CommentReport
    fun toUni(d: CommentReportResponse): it.vercruysse.lemmyapi.datatypes.CommentReportResponse

    fun toUni(d: CommentResponse): it.vercruysse.lemmyapi.datatypes.CommentResponse

    fun toUni(d: CommunityBlockView): it.vercruysse.lemmyapi.datatypes.CommunityBlockView
    fun toUni(d: CommunityFollowerView): it.vercruysse.lemmyapi.datatypes.CommunityFollowerView
    fun toUni(d: CommunityModeratorView): it.vercruysse.lemmyapi.datatypes.CommunityModeratorView
    fun toUni(d: CommunityResponse): it.vercruysse.lemmyapi.datatypes.CommunityResponse

    fun toUni(d: CustomEmoji): it.vercruysse.lemmyapi.datatypes.CustomEmoji
    fun toUni(d: CustomEmojiKeyword): it.vercruysse.lemmyapi.datatypes.CustomEmojiKeyword
    fun toUni(d: CustomEmojiResponse): it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse
    fun toUni(d: CustomEmojiView): it.vercruysse.lemmyapi.datatypes.CustomEmojiView
    fun toUni(d: FederatedInstances): it.vercruysse.lemmyapi.datatypes.FederatedInstances
    fun toUni(d: GenerateTotpSecretResponse): it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse
    fun toUni(d: GetCaptchaResponse): it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse
    fun toUni(d: GetCommentsResponse): it.vercruysse.lemmyapi.datatypes.GetCommentsResponse
    fun toUni(d: GetCommunityResponse): it.vercruysse.lemmyapi.datatypes.GetCommunityResponse
    fun toUni(d: GetFederatedInstancesResponse): it.vercruysse.lemmyapi.datatypes.GetFederatedInstancesResponse
    fun toUni(d: GetModlogResponse): it.vercruysse.lemmyapi.datatypes.GetModlogResponse
    fun toUni(d: GetPersonDetailsResponse): it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse
    fun toUni(d: GetPersonMentionsResponse): it.vercruysse.lemmyapi.datatypes.GetPersonMentionsResponse
    fun toUni(d: GetPostResponse): it.vercruysse.lemmyapi.datatypes.GetPostResponse
    fun toUni(d: GetPostsResponse): it.vercruysse.lemmyapi.datatypes.GetPostsResponse
    fun toUni(d: GetRepliesResponse): it.vercruysse.lemmyapi.datatypes.GetRepliesResponse
    fun toUni(d: GetReportCountResponse): it.vercruysse.lemmyapi.datatypes.GetReportCountResponse
    fun toUni(d: GetSiteMetadataResponse): it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse

    fun toUni(d: GetUnreadCountResponse): it.vercruysse.lemmyapi.datatypes.GetUnreadCountResponse
    fun toUni(
        d: GetUnreadRegistrationApplicationCountResponse,
    ): it.vercruysse.lemmyapi.datatypes.GetUnreadRegistrationApplicationCountResponse
    fun toUni(d: Instance): it.vercruysse.lemmyapi.datatypes.Instance
    fun toUni(d: InstanceBlockView): it.vercruysse.lemmyapi.datatypes.InstanceBlockView
    fun toUni(d: InstanceWithFederationState): it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState
    fun toUni(d: Language): it.vercruysse.lemmyapi.datatypes.Language
    fun toUni(d: ListCommentReportsResponse): it.vercruysse.lemmyapi.datatypes.ListCommentReportsResponse
    fun toUni(d: ListCommunitiesResponse): it.vercruysse.lemmyapi.datatypes.ListCommunitiesResponse
    fun toUni(d: ListPostReportsResponse): it.vercruysse.lemmyapi.datatypes.ListPostReportsResponse
    fun toUni(d: ListPrivateMessageReportsResponse): it.vercruysse.lemmyapi.datatypes.ListPrivateMessageReportsResponse
    fun toUni(d: ListRegistrationApplicationsResponse): it.vercruysse.lemmyapi.datatypes.ListRegistrationApplicationsResponse

    fun toUni(d: LocalSiteRateLimit): it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit
    fun toUni(d: LocalUser): it.vercruysse.lemmyapi.datatypes.LocalUser
    fun toUni(d: LocalUserView): it.vercruysse.lemmyapi.datatypes.LocalUserView
    fun toUni(d: LoginResponse): it.vercruysse.lemmyapi.datatypes.LoginResponse
    fun toUni(d: LoginToken): it.vercruysse.lemmyapi.datatypes.LoginToken
    fun toUni(d: ModAdd): it.vercruysse.lemmyapi.datatypes.ModAdd
    fun toUni(d: ModAddCommunity): it.vercruysse.lemmyapi.datatypes.ModAddCommunity
    fun toUni(d: ModAddCommunityView): it.vercruysse.lemmyapi.datatypes.ModAddCommunityView
    fun toUni(d: ModAddView): it.vercruysse.lemmyapi.datatypes.ModAddView
    fun toUni(d: ModBan): it.vercruysse.lemmyapi.datatypes.ModBan
    fun toUni(d: ModBanFromCommunity): it.vercruysse.lemmyapi.datatypes.ModBanFromCommunity
    fun toUni(d: ModBanFromCommunityView): it.vercruysse.lemmyapi.datatypes.ModBanFromCommunityView
    fun toUni(d: ModBanView): it.vercruysse.lemmyapi.datatypes.ModBanView
    fun toUni(d: ModFeaturePost): it.vercruysse.lemmyapi.datatypes.ModFeaturePost
    fun toUni(d: ModFeaturePostView): it.vercruysse.lemmyapi.datatypes.ModFeaturePostView
    fun toUni(d: ModHideCommunity): it.vercruysse.lemmyapi.datatypes.ModHideCommunity
    fun toUni(d: ModHideCommunityView): it.vercruysse.lemmyapi.datatypes.ModHideCommunityView
    fun toUni(d: ModLockPost): it.vercruysse.lemmyapi.datatypes.ModLockPost
    fun toUni(d: ModLockPostView): it.vercruysse.lemmyapi.datatypes.ModLockPostView
    fun toUni(d: ModlogListParams): it.vercruysse.lemmyapi.datatypes.ModlogListParams
    fun toUni(d: ModRemoveComment): it.vercruysse.lemmyapi.datatypes.ModRemoveComment
    fun toUni(d: ModRemoveCommentView): it.vercruysse.lemmyapi.datatypes.ModRemoveCommentView
    fun toUni(d: ModRemoveCommunity): it.vercruysse.lemmyapi.datatypes.ModRemoveCommunity
    fun toUni(d: ModRemoveCommunityView): it.vercruysse.lemmyapi.datatypes.ModRemoveCommunityView
    fun toUni(d: ModRemovePost): it.vercruysse.lemmyapi.datatypes.ModRemovePost
    fun toUni(d: ModRemovePostView): it.vercruysse.lemmyapi.datatypes.ModRemovePostView
    fun toUni(d: ModTransferCommunity): it.vercruysse.lemmyapi.datatypes.ModTransferCommunity
    fun toUni(d: ModTransferCommunityView): it.vercruysse.lemmyapi.datatypes.ModTransferCommunityView
    fun toUni(d: MyUserInfo): it.vercruysse.lemmyapi.datatypes.MyUserInfo
    fun toUni(d: Person): it.vercruysse.lemmyapi.datatypes.Person
    fun toUni(d: PersonAggregates): it.vercruysse.lemmyapi.datatypes.PersonAggregates
    fun toUni(d: PersonBlockView): it.vercruysse.lemmyapi.datatypes.PersonBlockView
    fun toUni(d: PersonMention): it.vercruysse.lemmyapi.datatypes.PersonMention
    fun toUni(d: PersonMentionResponse): it.vercruysse.lemmyapi.datatypes.PersonMentionResponse

    fun toUni(d: PersonView): it.vercruysse.lemmyapi.datatypes.PersonView
    fun toUni(d: Post): it.vercruysse.lemmyapi.datatypes.Post

    fun toUni(d: PostReport): it.vercruysse.lemmyapi.datatypes.PostReport
    fun toUni(d: PostReportResponse): it.vercruysse.lemmyapi.datatypes.PostReportResponse

    fun toUni(d: PostResponse): it.vercruysse.lemmyapi.datatypes.PostResponse

    fun toUni(d: PrivateMessage): it.vercruysse.lemmyapi.datatypes.PrivateMessage
    fun toUni(d: PrivateMessageReport): it.vercruysse.lemmyapi.datatypes.PrivateMessageReport
    fun toUni(d: PrivateMessageReportResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse
    fun toUni(d: PrivateMessageReportView): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView
    fun toUni(d: PrivateMessageResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse
    fun toUni(d: PrivateMessagesResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessagesResponse
    fun toUni(d: PrivateMessageView): it.vercruysse.lemmyapi.datatypes.PrivateMessageView
    fun toUni(d: ReadableFederationState): it.vercruysse.lemmyapi.datatypes.ReadableFederationState
    fun toUni(d: RegistrationApplication): it.vercruysse.lemmyapi.datatypes.RegistrationApplication
    fun toUni(d: RegistrationApplicationResponse): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse
    fun toUni(d: RegistrationApplicationView): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView
    fun toUni(d: ResolveObjectResponse): it.vercruysse.lemmyapi.datatypes.ResolveObjectResponse
    fun toUni(d: SearchResponse): it.vercruysse.lemmyapi.datatypes.SearchResponse
    fun toUni(d: Site): it.vercruysse.lemmyapi.datatypes.Site
    fun toUni(d: SiteAggregates): it.vercruysse.lemmyapi.datatypes.SiteAggregates
    fun toUni(d: SiteResponse): it.vercruysse.lemmyapi.datatypes.SiteResponse
    fun toUni(d: SiteView): it.vercruysse.lemmyapi.datatypes.SiteView
    fun toUni(d: Tagline): it.vercruysse.lemmyapi.datatypes.Tagline
    fun toUni(d: UpdateTotpResponse): it.vercruysse.lemmyapi.datatypes.UpdateTotpResponse

    // body mappings
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddAdmin): AddAdmin
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddModToCommunity): AddModToCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanFromCommunity): BanFromCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanPerson): BanPerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockCommunity): BlockCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockInstance): BlockInstance
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockPerson): BlockPerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ChangePassword): ChangePassword
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateComment): CreateComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentLike): CreateCommentLike
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentReport): CreateCommentReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommunity): CreateCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji): CreateCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePost): CreatePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostLike): CreatePostLike
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostReport): CreatePostReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage): CreatePrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateSite): CreateSite
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteAccount): DeleteAccount
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteComment): DeleteComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCommunity): DeleteCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji): DeleteCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePost): DeletePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage): DeletePrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DistinguishComment): DistinguishComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditComment): EditComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCommunity): EditCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCustomEmoji): EditCustomEmoji
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPost): EditPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPrivateMessage): EditPrivateMessage
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditSite): EditSite
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FeaturePost): FeaturePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FollowCommunity): FollowCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComment): GetComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComments): GetComments
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetCommunity): GetCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetModlog): GetModlog
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPersonDetails): GetPersonDetails
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPersonMentions): GetPersonMentions
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPost): GetPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPosts): GetPosts
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPrivateMessages): GetPrivateMessages
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetReplies): GetReplies
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetReportCount): GetReportCount
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetSiteMetadata): GetSiteMetadata
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.HideCommunity): HideCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommentReports): ListCommentReports
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommunities): ListCommunities
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPostReports): ListPostReports
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListPrivateMessageReports): ListPrivateMessageReports
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications): ListRegistrationApplications
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.LockPost): LockPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Login): Login
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkCommentReplyAsRead): MarkCommentReplyAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkPersonMentionAsRead): MarkPersonMentionAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkPostAsRead): MarkPostAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.MarkPrivateMessageAsRead): MarkPrivateMessageAsRead
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PasswordChangeAfterReset): PasswordChangeAfterReset
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PasswordReset): PasswordReset
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeComment): PurgeComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeCommunity): PurgeCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePerson): PurgePerson
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePost): PurgePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Register): Register
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveComment): RemoveComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveCommunity): RemoveCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemovePost): RemovePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveCommentReport): ResolveCommentReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveObject): ResolveObject
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePostReport): ResolvePostReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveComment): SaveComment
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SavePost): SavePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveUserSettings): SaveUserSettings
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Search): Search
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.TransferCommunity): TransferCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.UpdateTotp): UpdateTotp
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.VerifyEmail): VerifyEmail
}
