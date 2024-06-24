package it.vercruysse.lemmyapi.v0.x18.x5

import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.*

internal interface DatatypesMapperOld {
    fun toV0x19(d: LocalUser): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalUser

    fun toV0x19(d: MyUserInfo): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MyUserInfo

    fun toV0x19(d: LocalSiteRateLimit): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalSiteRateLimit

    // GENERATED

    fun toV0x19(d: AddAdminResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddAdminResponse

    fun toV0x19(d: AddModToCommunityResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddModToCommunityResponse

    fun toV0x19(d: AdminPurgeComment): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeComment

    fun toV0x19(d: AdminPurgeCommentView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommentView

    fun toV0x19(d: AdminPurgeCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommunity

    fun toV0x19(d: AdminPurgeCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommunityView

    fun toV0x19(d: AdminPurgePerson): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePerson

    fun toV0x19(d: AdminPurgePersonView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePersonView

    fun toV0x19(d: AdminPurgePost): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePost

    fun toV0x19(d: AdminPurgePostView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePostView

    fun toV0x19(d: BanFromCommunityResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanFromCommunityResponse

    fun toV0x19(d: BannedPersonsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BannedPersonsResponse

    fun toV0x19(d: BanPersonResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanPersonResponse

    fun toV0x19(d: BlockCommunityResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockCommunityResponse

    fun toV0x19(d: BlockPersonResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockPersonResponse

    fun toV0x19(d: CaptchaResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CaptchaResponse

    fun toV0x19(d: Comment): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Comment

    fun toV0x19(d: CommentAggregates): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentAggregates

    fun toV0x19(d: CommentReply): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReply

    fun toV0x19(d: CommentReplyResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReplyResponse

    fun toV0x19(d: CommentReplyView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReplyView

    fun toV0x19(d: CommentReport): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReport

    fun toV0x19(d: CommentReportResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReportResponse

    fun toV0x19(d: CommentReportView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReportView

    fun toV0x19(d: CommentResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentResponse

    fun toV0x19(d: CommentView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentView

    fun toV0x19(d: Community): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Community

    fun toV0x19(d: CommunityAggregates): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityAggregates

    fun toV0x19(d: CommunityBlockView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityBlockView

    fun toV0x19(d: CommunityFollowerView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityFollowerView

    fun toV0x19(d: CommunityModeratorView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityModeratorView

    fun toV0x19(d: CommunityResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityResponse

    fun toV0x19(d: CommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityView

    fun toV0x19(d: CustomEmoji): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmoji

    fun toV0x19(d: CustomEmojiKeyword): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiKeyword

    fun toV0x19(d: CustomEmojiResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiResponse

    fun toV0x19(d: CustomEmojiView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiView

    fun toV0x19(d: FederatedInstances): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FederatedInstances

    fun toV0x19(d: GetCaptchaResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCaptchaResponse

    fun toV0x19(d: GetCommentsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommentsResponse

    fun toV0x19(d: GetCommunityResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommunityResponse

    fun toV0x19(d: GetFederatedInstancesResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetFederatedInstancesResponse

    fun toV0x19(d: GetModlogResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetModlogResponse

    fun toV0x19(d: GetPersonDetailsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonDetailsResponse

    fun toV0x19(d: GetPersonMentionsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonMentionsResponse

    fun toV0x19(d: GetPostResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPostResponse

    fun toV0x19(d: GetPostsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPostsResponse

    fun toV0x19(d: GetRepliesResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetRepliesResponse

    fun toV0x19(d: GetReportCountResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReportCountResponse

    fun toV0x19(d: GetSiteMetadataResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteMetadataResponse

    fun toV0x19(d: GetSiteResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteResponse

    fun toV0x19(d: GetUnreadCountResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetUnreadCountResponse

    fun toV0x19(d: GetUnreadRegistrationApplicationCountResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetUnreadRegistrationApplicationCountResponse

    fun toV0x19(d: Instance): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Instance

    fun toV0x19F(d: Instance): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.InstanceWithFederationState

    fun toV0x19(d: Language): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Language

    fun toV0x19(d: ListCommentReportsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommentReportsResponse

    fun toV0x19(d: ListCommunitiesResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommunitiesResponse

    fun toV0x19(d: ListPostReportsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPostReportsResponse

    fun toV0x19(d: ListPrivateMessageReportsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPrivateMessageReportsResponse

    fun toV0x19(d: ListRegistrationApplicationsResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListRegistrationApplicationsResponse

    fun toV0x19(d: LocalSite): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalSite

    fun toV0x19(d: LocalUserView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalUserView

    fun toV0x19(d: LoginResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LoginResponse

    fun toV0x19(d: ModAdd): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAdd

    fun toV0x19(d: ModAddCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddCommunity

    fun toV0x19(d: ModAddCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddCommunityView

    fun toV0x19(d: ModAddView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddView

    fun toV0x19(d: ModBan): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBan

    fun toV0x19(d: ModBanFromCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanFromCommunity

    fun toV0x19(d: ModBanFromCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanFromCommunityView

    fun toV0x19(d: ModBanView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanView

    fun toV0x19(d: ModFeaturePost): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModFeaturePost

    fun toV0x19(d: ModFeaturePostView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModFeaturePostView

    fun toV0x19(d: ModHideCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModHideCommunity

    fun toV0x19(d: ModHideCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModHideCommunityView

    fun toV0x19(d: ModLockPost): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModLockPost

    fun toV0x19(d: ModLockPostView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModLockPostView

    fun toV0x19(d: ModlogListParams): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModlogListParams

    fun toV0x19(d: ModRemoveComment): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveComment

    fun toV0x19(d: ModRemoveCommentView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommentView

    fun toV0x19(d: ModRemoveCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommunity

    fun toV0x19(d: ModRemoveCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommunityView

    fun toV0x19(d: ModRemovePost): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemovePost

    fun toV0x19(d: ModRemovePostView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemovePostView

    fun toV0x19(d: ModTransferCommunity): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModTransferCommunity

    fun toV0x19(d: ModTransferCommunityView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModTransferCommunityView

    fun toV0x19(d: Person): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Person

    fun toV0x19(d: PersonAggregates): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonAggregates

    fun toV0x19(d: PersonBlockView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonBlockView

    fun toV0x19(d: PersonMention): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonMention

    fun toV0x19(d: PersonMentionResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonMentionResponse

    fun toV0x19(d: PersonMentionView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonMentionView

    fun toV0x19(d: PersonView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonView

    fun toV0x19(d: Post): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Post

    fun toV0x19(d: PostAggregates): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostAggregates

    fun toV0x19(d: PostReport): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReport

    fun toV0x19(d: PostReportResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReportResponse

    fun toV0x19(d: PostReportView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReportView

    fun toV0x19(d: PostResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostResponse

    fun toV0x19(d: PostView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostView

    fun toV0x19(d: PrivateMessage): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessage

    fun toV0x19(d: PrivateMessageReport): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReport

    fun toV0x19(d: PrivateMessageReportResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReportResponse

    fun toV0x19(d: PrivateMessageReportView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReportView

    fun toV0x19(d: PrivateMessageResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageResponse

    fun toV0x19(d: PrivateMessagesResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessagesResponse

    fun toV0x19(d: PrivateMessageView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageView

    fun toV0x19(d: RegistrationApplication): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplication

    fun toV0x19(d: RegistrationApplicationResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplicationResponse

    fun toV0x19(d: RegistrationApplicationView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplicationView

    fun toV0x19(d: ResolveObjectResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveObjectResponse

    fun toV0x19(d: SearchResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SearchResponse

    fun toV0x19(d: Site): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Site

    fun toV0x19(d: SiteAggregates): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteAggregates

    fun toV0x19(d: SiteMetadata): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LinkMetadata

    fun toV0x19(d: SiteResponse): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteResponse

    fun toV0x19(d: SiteView): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteView

    fun toV0x19(d: Tagline): it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Tagline

    // body mappings

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddAdmin): AddAdmin

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddModToCommunity): AddModToCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanFromCommunity): BanFromCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanPerson): BanPerson

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockCommunity): BlockCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockPerson): BlockPerson

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ChangePassword): ChangePassword

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateComment): CreateComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommentLike): CreateCommentLike

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommentReport): CreateCommentReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommunity): CreateCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCustomEmoji): CreateCustomEmoji

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePost): CreatePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePostLike): CreatePostLike

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePostReport): CreatePostReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePrivateMessage): CreatePrivateMessage

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateSite): CreateSite

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteAccount): DeleteAccount

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteComment): DeleteComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteCommunity): DeleteCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteCustomEmoji): DeleteCustomEmoji

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeletePost): DeletePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeletePrivateMessage): DeletePrivateMessage

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DistinguishComment): DistinguishComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditComment): EditComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditCommunity): EditCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditCustomEmoji): EditCustomEmoji

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditPost): EditPost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditPrivateMessage): EditPrivateMessage

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditSite): EditSite

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FeaturePost): FeaturePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FollowCommunity): FollowCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetComment): GetComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetComments): GetComments

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommunity): GetCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetModlog): GetModlog

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonDetails): GetPersonDetails

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonMentions): GetPersonMentions

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPost): GetPost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPosts): GetPosts

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPrivateMessages): GetPrivateMessages

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReplies): GetReplies

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReportCount): GetReportCount

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteMetadata): GetSiteMetadata

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.HideCommunity): HideCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommentReports): ListCommentReports

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommunities): ListCommunities

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPostReports): ListPostReports

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPrivateMessageReports): ListPrivateMessageReports

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListRegistrationApplications): ListRegistrationApplications

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LockPost): LockPost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Login): Login

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkCommentReplyAsRead): MarkCommentReplyAsRead

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkPersonMentionAsRead): MarkPersonMentionAsRead

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkPrivateMessageAsRead): MarkPrivateMessageAsRead

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PasswordChangeAfterReset): PasswordChangeAfterReset

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PasswordReset): PasswordReset

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgeComment): PurgeComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgeCommunity): PurgeCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgePerson): PurgePerson

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgePost): PurgePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Register): Register

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemoveComment): RemoveComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemoveCommunity): RemoveCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemovePost): RemovePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveCommentReport): ResolveCommentReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveObject): ResolveObject

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolvePostReport): ResolvePostReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SaveComment): SaveComment

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SavePost): SavePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SaveUserSettings): SaveUserSettings

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Search): Search

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.TransferCommunity): TransferCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0.x19.x4.datatypes.VerifyEmail): VerifyEmail
}
