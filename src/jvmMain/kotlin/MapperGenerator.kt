@file:Suppress("unused")

import io.mcarle.konvert.api.Konfig
import io.mcarle.konvert.api.Konvert
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.api.Mapping
import v0x18.datatypes.*

//@Konverter(
//    options = [
//        Konfig(key = "konvert.enable-converters", value = "FloatToIntConverter"),
//        Konfig(key = "konvert.add-generated-konverter-annotation", value = "false"),
//    ]
//)
interface DatatypesMapper {
    @Konvert(
        mappings = [
            Mapping(target = "blur_nsfw", constant = "false"),
            Mapping(target = "admin", constant = "false"),
            Mapping(target = "infinite_scroll_enabled", constant = "true"),
            Mapping(target = "post_listing_mode", constant = "PostListingMode.Card"),
            Mapping(target = "auto_expand", constant = "false"),
            Mapping(target = "totp_2fa_enabled", expression = "this.mapLocalUserTotp(it)"),
            Mapping(target = "enable_keyboard_navigation", constant = "false"),
            Mapping(target = "enable_animated_images", constant = "true"),
        ],
    )
    fun toV0x19(d: LocalUser): v0x19.datatypes.LocalUser

    @Konvert(mappings = [Mapping(target = "instance_blocks", constant = "listOf()")])
    fun toV0x19(d: MyUserInfo): v0x19.datatypes.MyUserInfo

    @Konvert(
        mappings = [
            Mapping(target = "import_user_settings", constant = "-1"),
            Mapping(target = "import_user_settings_per_second", constant = "-1")
        ]
    )
    fun toV0x19(d: LocalSiteRateLimit): v0x19.datatypes.LocalSiteRateLimit

    // GENERATED

    fun toV0x19(d: AddAdminResponse): v0x19.datatypes.AddAdminResponse
    fun toV0x19(d: AddModToCommunityResponse): v0x19.datatypes.AddModToCommunityResponse
    fun toV0x19(d: AdminPurgeComment): v0x19.datatypes.AdminPurgeComment
    fun toV0x19(d: AdminPurgeCommentView): v0x19.datatypes.AdminPurgeCommentView
    fun toV0x19(d: AdminPurgeCommunity): v0x19.datatypes.AdminPurgeCommunity
    fun toV0x19(d: AdminPurgeCommunityView): v0x19.datatypes.AdminPurgeCommunityView
    fun toV0x19(d: AdminPurgePerson): v0x19.datatypes.AdminPurgePerson
    fun toV0x19(d: AdminPurgePersonView): v0x19.datatypes.AdminPurgePersonView
    fun toV0x19(d: AdminPurgePost): v0x19.datatypes.AdminPurgePost
    fun toV0x19(d: AdminPurgePostView): v0x19.datatypes.AdminPurgePostView
    fun toV0x19(d: BanFromCommunityResponse): v0x19.datatypes.BanFromCommunityResponse
    fun toV0x19(d: BannedPersonsResponse): v0x19.datatypes.BannedPersonsResponse
    fun toV0x19(d: BanPersonResponse): v0x19.datatypes.BanPersonResponse
    fun toV0x19(d: BlockCommunityResponse): v0x19.datatypes.BlockCommunityResponse
    fun toV0x19(d: BlockPersonResponse): v0x19.datatypes.BlockPersonResponse
    fun toV0x19(d: CaptchaResponse): v0x19.datatypes.CaptchaResponse
    fun toV0x19(d: Comment): v0x19.datatypes.Comment
    fun toV0x19(d: CommentAggregates): v0x19.datatypes.CommentAggregates
    fun toV0x19(d: CommentReply): v0x19.datatypes.CommentReply
    fun toV0x19(d: CommentReplyResponse): v0x19.datatypes.CommentReplyResponse
    fun toV0x19(d: CommentReplyView): v0x19.datatypes.CommentReplyView
    fun toV0x19(d: CommentReport): v0x19.datatypes.CommentReport
    fun toV0x19(d: CommentReportResponse): v0x19.datatypes.CommentReportResponse
    fun toV0x19(d: CommentReportView): v0x19.datatypes.CommentReportView
    fun toV0x19(d: CommentResponse): v0x19.datatypes.CommentResponse
    fun toV0x19(d: CommentView): v0x19.datatypes.CommentView
    fun toV0x19(d: Community): v0x19.datatypes.Community
    fun toV0x19(d: CommunityAggregates): v0x19.datatypes.CommunityAggregates
    fun toV0x19(d: CommunityBlockView): v0x19.datatypes.CommunityBlockView
    fun toV0x19(d: CommunityFollowerView): v0x19.datatypes.CommunityFollowerView
    fun toV0x19(d: CommunityModeratorView): v0x19.datatypes.CommunityModeratorView
    fun toV0x19(d: CommunityResponse): v0x19.datatypes.CommunityResponse
    fun toV0x19(d: CommunityView): v0x19.datatypes.CommunityView
    fun toV0x19(d: CustomEmoji): v0x19.datatypes.CustomEmoji
    fun toV0x19(d: CustomEmojiKeyword): v0x19.datatypes.CustomEmojiKeyword
    fun toV0x19(d: CustomEmojiResponse): v0x19.datatypes.CustomEmojiResponse
    fun toV0x19(d: CustomEmojiView): v0x19.datatypes.CustomEmojiView
    fun toV0x19(d: FederatedInstances): v0x19.datatypes.FederatedInstances
    fun toV0x19(d: GetCaptchaResponse): v0x19.datatypes.GetCaptchaResponse
    fun toV0x19(d: GetCommentsResponse): v0x19.datatypes.GetCommentsResponse
    fun toV0x19(d: GetCommunityResponse): v0x19.datatypes.GetCommunityResponse
    fun toV0x19(d: GetFederatedInstancesResponse): v0x19.datatypes.GetFederatedInstancesResponse
    fun toV0x19(d: GetModlogResponse): v0x19.datatypes.GetModlogResponse
    fun toV0x19(d: GetPersonDetailsResponse): v0x19.datatypes.GetPersonDetailsResponse
    fun toV0x19(d: GetPersonMentionsResponse): v0x19.datatypes.GetPersonMentionsResponse
    fun toV0x19(d: GetPostResponse): v0x19.datatypes.GetPostResponse
    fun toV0x19(d: GetPostsResponse): v0x19.datatypes.GetPostsResponse
    fun toV0x19(d: GetRepliesResponse): v0x19.datatypes.GetRepliesResponse
    fun toV0x19(d: GetReportCountResponse): v0x19.datatypes.GetReportCountResponse
    fun toV0x19(d: GetSiteMetadataResponse): v0x19.datatypes.GetSiteMetadataResponse
    fun toV0x19(d: GetSiteResponse): v0x19.datatypes.GetSiteResponse
    fun toV0x19(d: GetUnreadCountResponse): v0x19.datatypes.GetUnreadCountResponse
    fun toV0x19(d: GetUnreadRegistrationApplicationCountResponse): v0x19.datatypes.GetUnreadRegistrationApplicationCountResponse
    fun toV0x19(d: Instance): v0x19.datatypes.Instance
    fun toV0x19(d: Language): v0x19.datatypes.Language
    fun toV0x19(d: ListCommentReportsResponse): v0x19.datatypes.ListCommentReportsResponse
    fun toV0x19(d: ListCommunitiesResponse): v0x19.datatypes.ListCommunitiesResponse
    fun toV0x19(d: ListPostReportsResponse): v0x19.datatypes.ListPostReportsResponse
    fun toV0x19(d: ListPrivateMessageReportsResponse): v0x19.datatypes.ListPrivateMessageReportsResponse
    fun toV0x19(d: ListRegistrationApplicationsResponse): v0x19.datatypes.ListRegistrationApplicationsResponse
    fun toV0x19(d: LocalSite): v0x19.datatypes.LocalSite
    fun toV0x19(d: LocalUserView): v0x19.datatypes.LocalUserView
    fun toV0x19(d: LoginResponse): v0x19.datatypes.LoginResponse
    fun toV0x19(d: ModAdd): v0x19.datatypes.ModAdd
    fun toV0x19(d: ModAddCommunity): v0x19.datatypes.ModAddCommunity
    fun toV0x19(d: ModAddCommunityView): v0x19.datatypes.ModAddCommunityView
    fun toV0x19(d: ModAddView): v0x19.datatypes.ModAddView
    fun toV0x19(d: ModBan): v0x19.datatypes.ModBan
    fun toV0x19(d: ModBanFromCommunity): v0x19.datatypes.ModBanFromCommunity
    fun toV0x19(d: ModBanFromCommunityView): v0x19.datatypes.ModBanFromCommunityView
    fun toV0x19(d: ModBanView): v0x19.datatypes.ModBanView
    fun toV0x19(d: ModFeaturePost): v0x19.datatypes.ModFeaturePost
    fun toV0x19(d: ModFeaturePostView): v0x19.datatypes.ModFeaturePostView
    fun toV0x19(d: ModHideCommunity): v0x19.datatypes.ModHideCommunity
    fun toV0x19(d: ModHideCommunityView): v0x19.datatypes.ModHideCommunityView
    fun toV0x19(d: ModLockPost): v0x19.datatypes.ModLockPost
    fun toV0x19(d: ModLockPostView): v0x19.datatypes.ModLockPostView
    fun toV0x19(d: ModlogListParams): v0x19.datatypes.ModlogListParams
    fun toV0x19(d: ModRemoveComment): v0x19.datatypes.ModRemoveComment
    fun toV0x19(d: ModRemoveCommentView): v0x19.datatypes.ModRemoveCommentView
    fun toV0x19(d: ModRemoveCommunity): v0x19.datatypes.ModRemoveCommunity
    fun toV0x19(d: ModRemoveCommunityView): v0x19.datatypes.ModRemoveCommunityView
    fun toV0x19(d: ModRemovePost): v0x19.datatypes.ModRemovePost
    fun toV0x19(d: ModRemovePostView): v0x19.datatypes.ModRemovePostView
    fun toV0x19(d: ModTransferCommunity): v0x19.datatypes.ModTransferCommunity
    fun toV0x19(d: ModTransferCommunityView): v0x19.datatypes.ModTransferCommunityView
    fun toV0x19(d: Person): v0x19.datatypes.Person
    fun toV0x19(d: PersonAggregates): v0x19.datatypes.PersonAggregates
    fun toV0x19(d: PersonBlockView): v0x19.datatypes.PersonBlockView
    fun toV0x19(d: PersonMention): v0x19.datatypes.PersonMention
    fun toV0x19(d: PersonMentionResponse): v0x19.datatypes.PersonMentionResponse
    fun toV0x19(d: PersonMentionView): v0x19.datatypes.PersonMentionView
    fun toV0x19(d: PersonView): v0x19.datatypes.PersonView
    fun toV0x19(d: Post): v0x19.datatypes.Post
    fun toV0x19(d: PostAggregates): v0x19.datatypes.PostAggregates
    fun toV0x19(d: PostReport): v0x19.datatypes.PostReport
    fun toV0x19(d: PostReportResponse): v0x19.datatypes.PostReportResponse
    fun toV0x19(d: PostReportView): v0x19.datatypes.PostReportView
    fun toV0x19(d: PostResponse): v0x19.datatypes.PostResponse
    fun toV0x19(d: PostView): v0x19.datatypes.PostView
    fun toV0x19(d: PrivateMessage): v0x19.datatypes.PrivateMessage
    fun toV0x19(d: PrivateMessageReport): v0x19.datatypes.PrivateMessageReport
    fun toV0x19(d: PrivateMessageReportResponse): v0x19.datatypes.PrivateMessageReportResponse
    fun toV0x19(d: PrivateMessageReportView): v0x19.datatypes.PrivateMessageReportView
    fun toV0x19(d: PrivateMessageResponse): v0x19.datatypes.PrivateMessageResponse
    fun toV0x19(d: PrivateMessagesResponse): v0x19.datatypes.PrivateMessagesResponse
    fun toV0x19(d: PrivateMessageView): v0x19.datatypes.PrivateMessageView
    fun toV0x19(d: RegistrationApplication): v0x19.datatypes.RegistrationApplication
    fun toV0x19(d: RegistrationApplicationResponse): v0x19.datatypes.RegistrationApplicationResponse
    fun toV0x19(d: RegistrationApplicationView): v0x19.datatypes.RegistrationApplicationView
    fun toV0x19(d: ResolveObjectResponse): v0x19.datatypes.ResolveObjectResponse
    fun toV0x19(d: SearchResponse): v0x19.datatypes.SearchResponse
    fun toV0x19(d: Site): v0x19.datatypes.Site
    fun toV0x19(d: SiteAggregates): v0x19.datatypes.SiteAggregates
    fun toV0x19(d: SiteMetadata): v0x19.datatypes.SiteMetadata
    fun toV0x19(d: SiteResponse): v0x19.datatypes.SiteResponse
    fun toV0x19(d: SiteView): v0x19.datatypes.SiteView
    fun toV0x19(d: Tagline): v0x19.datatypes.Tagline

    // body mappings
    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.AddAdmin): AddAdmin

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.AddModToCommunity): AddModToCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.BanFromCommunity): BanFromCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.BanPerson): BanPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.BlockCommunity): BlockCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.BlockPerson): BlockPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ChangePassword): ChangePassword

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateComment): CreateComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateCommentLike): CreateCommentLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateCommentReport): CreateCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateCommunity): CreateCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateCustomEmoji): CreateCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreatePost): CreatePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreatePostLike): CreatePostLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreatePostReport): CreatePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreatePrivateMessage): CreatePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.CreateSite): CreateSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeleteAccount): DeleteAccount

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeleteComment): DeleteComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeleteCommunity): DeleteCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeleteCustomEmoji): DeleteCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeletePost): DeletePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DeletePrivateMessage): DeletePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.DistinguishComment): DistinguishComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditComment): EditComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditCommunity): EditCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditCustomEmoji): EditCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditPost): EditPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditPrivateMessage): EditPrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.EditSite): EditSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.FeaturePost): FeaturePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.FollowCommunity): FollowCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetComment): GetComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetComments): GetComments

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetCommunity): GetCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetModlog): GetModlog

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetPersonDetails): GetPersonDetails

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetPersonMentions): GetPersonMentions

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetPost): GetPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetPosts): GetPosts

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetPrivateMessages): GetPrivateMessages

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetReplies): GetReplies

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.GetReportCount): GetReportCount
    fun toV0x18(d: v0x19.datatypes.GetSiteMetadata): GetSiteMetadata

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.HideCommunity): HideCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ListCommentReports): ListCommentReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ListCommunities): ListCommunities

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ListPostReports): ListPostReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ListPrivateMessageReports): ListPrivateMessageReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ListRegistrationApplications): ListRegistrationApplications

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.LockPost): LockPost
    fun toV0x18(d: v0x19.datatypes.Login): Login

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.MarkCommentReplyAsRead): MarkCommentReplyAsRead

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.MarkPersonMentionAsRead): MarkPersonMentionAsRead

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.MarkPrivateMessageAsRead): MarkPrivateMessageAsRead
    fun toV0x18(d: v0x19.datatypes.PasswordChangeAfterReset): PasswordChangeAfterReset
    fun toV0x18(d: v0x19.datatypes.PasswordReset): PasswordReset

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.PurgeComment): PurgeComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.PurgeCommunity): PurgeCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.PurgePerson): PurgePerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.PurgePost): PurgePost
    fun toV0x18(d: v0x19.datatypes.Register): Register

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.RemoveComment): RemoveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.RemoveCommunity): RemoveCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.RemovePost): RemovePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ResolveCommentReport): ResolveCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ResolveObject): ResolveObject

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ResolvePostReport): ResolvePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.SaveComment): SaveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.SavePost): SavePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.SaveUserSettings): SaveUserSettings

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.Search): Search

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: v0x19.datatypes.TransferCommunity): TransferCommunity
    fun toV0x18(d: v0x19.datatypes.VerifyEmail): VerifyEmail
}
