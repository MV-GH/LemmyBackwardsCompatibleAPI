@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.example

import io.mcarle.konvert.api.Konvert
import io.mcarle.konvert.api.Mapping
import it.vercruysse.lemmyapi.v0x18.datatypes.*

// @Konverter(
//    options = [
//        Konfig(key = "konvert.enable-converters", value = "FloatToIntConverter"),
//        Konfig(key = "konvert.add-generated-konverter-annotation", value = "false"),
//    ]
// )
internal interface MapperGenerator {
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
    fun toV0x19(d: LocalUser): it.vercruysse.lemmyapi.v0x19.datatypes.LocalUser

    @Konvert(mappings = [Mapping(target = "instance_blocks", constant = "listOf()")])
    fun toV0x19(d: MyUserInfo): it.vercruysse.lemmyapi.v0x19.datatypes.MyUserInfo

    @Konvert(
        mappings = [
            Mapping(target = "import_user_settings", constant = "-1"),
            Mapping(target = "import_user_settings_per_second", constant = "-1"),
        ],
    )
    fun toV0x19(d: LocalSiteRateLimit): it.vercruysse.lemmyapi.v0x19.datatypes.LocalSiteRateLimit

    // GENERATED

    fun toV0x19(d: AddAdminResponse): it.vercruysse.lemmyapi.v0x19.datatypes.AddAdminResponse

    fun toV0x19(d: AddModToCommunityResponse): it.vercruysse.lemmyapi.v0x19.datatypes.AddModToCommunityResponse

    fun toV0x19(d: AdminPurgeComment): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeComment

    fun toV0x19(d: AdminPurgeCommentView): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommentView

    fun toV0x19(d: AdminPurgeCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunity

    fun toV0x19(d: AdminPurgeCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunityView

    fun toV0x19(d: AdminPurgePerson): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePerson

    fun toV0x19(d: AdminPurgePersonView): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePersonView

    fun toV0x19(d: AdminPurgePost): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePost

    fun toV0x19(d: AdminPurgePostView): it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePostView

    fun toV0x19(d: BanFromCommunityResponse): it.vercruysse.lemmyapi.v0x19.datatypes.BanFromCommunityResponse

    fun toV0x19(d: BannedPersonsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.BannedPersonsResponse

    fun toV0x19(d: BanPersonResponse): it.vercruysse.lemmyapi.v0x19.datatypes.BanPersonResponse

    fun toV0x19(d: BlockCommunityResponse): it.vercruysse.lemmyapi.v0x19.datatypes.BlockCommunityResponse

    fun toV0x19(d: BlockPersonResponse): it.vercruysse.lemmyapi.v0x19.datatypes.BlockPersonResponse

    fun toV0x19(d: CaptchaResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CaptchaResponse

    fun toV0x19(d: Comment): it.vercruysse.lemmyapi.v0x19.datatypes.Comment

    fun toV0x19(d: CommentAggregates): it.vercruysse.lemmyapi.v0x19.datatypes.CommentAggregates

    fun toV0x19(d: CommentReply): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReply

    fun toV0x19(d: CommentReplyResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyResponse

    fun toV0x19(d: CommentReplyView): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyView

    fun toV0x19(d: CommentReport): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReport

    fun toV0x19(d: CommentReportResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportResponse

    fun toV0x19(d: CommentReportView): it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportView

    fun toV0x19(d: CommentResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CommentResponse

    fun toV0x19(d: CommentView): it.vercruysse.lemmyapi.v0x19.datatypes.CommentView

    fun toV0x19(d: Community): it.vercruysse.lemmyapi.v0x19.datatypes.Community

    fun toV0x19(d: CommunityAggregates): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityAggregates

    fun toV0x19(d: CommunityBlockView): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityBlockView

    fun toV0x19(d: CommunityFollowerView): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityFollowerView

    fun toV0x19(d: CommunityModeratorView): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityModeratorView

    fun toV0x19(d: CommunityResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityResponse

    fun toV0x19(d: CommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.CommunityView

    fun toV0x19(d: CustomEmoji): it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmoji

    fun toV0x19(d: CustomEmojiKeyword): it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiKeyword

    fun toV0x19(d: CustomEmojiResponse): it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiResponse

    fun toV0x19(d: CustomEmojiView): it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiView

    fun toV0x19(d: FederatedInstances): it.vercruysse.lemmyapi.v0x19.datatypes.FederatedInstances

    fun toV0x19(d: GetCaptchaResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetCaptchaResponse

    fun toV0x19(d: GetCommentsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetCommentsResponse

    fun toV0x19(d: GetCommunityResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetCommunityResponse

    fun toV0x19(d: GetFederatedInstancesResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetFederatedInstancesResponse

    fun toV0x19(d: GetModlogResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetModlogResponse

    fun toV0x19(d: GetPersonDetailsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonDetailsResponse

    fun toV0x19(d: GetPersonMentionsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonMentionsResponse

    fun toV0x19(d: GetPostResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetPostResponse

    fun toV0x19(d: GetPostsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetPostsResponse

    fun toV0x19(d: GetRepliesResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetRepliesResponse

    fun toV0x19(d: GetReportCountResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetReportCountResponse

    fun toV0x19(d: GetSiteMetadataResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteMetadataResponse

    fun toV0x19(d: GetSiteResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteResponse

    fun toV0x19(d: GetUnreadCountResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadCountResponse

    fun toV0x19(d: GetUnreadRegistrationApplicationCountResponse): it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadRegistrationApplicationCountResponse

    fun toV0x19(d: Instance): it.vercruysse.lemmyapi.v0x19.datatypes.Instance

    fun toV0x19(d: Language): it.vercruysse.lemmyapi.v0x19.datatypes.Language

    fun toV0x19(d: ListCommentReportsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ListCommentReportsResponse

    fun toV0x19(d: ListCommunitiesResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ListCommunitiesResponse

    fun toV0x19(d: ListPostReportsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ListPostReportsResponse

    fun toV0x19(d: ListPrivateMessageReportsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ListPrivateMessageReportsResponse

    fun toV0x19(d: ListRegistrationApplicationsResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ListRegistrationApplicationsResponse

    fun toV0x19(d: LocalSite): it.vercruysse.lemmyapi.v0x19.datatypes.LocalSite

    fun toV0x19(d: LocalUserView): it.vercruysse.lemmyapi.v0x19.datatypes.LocalUserView

    fun toV0x19(d: LoginResponse): it.vercruysse.lemmyapi.v0x19.datatypes.LoginResponse

    fun toV0x19(d: ModAdd): it.vercruysse.lemmyapi.v0x19.datatypes.ModAdd

    fun toV0x19(d: ModAddCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunity

    fun toV0x19(d: ModAddCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunityView

    fun toV0x19(d: ModAddView): it.vercruysse.lemmyapi.v0x19.datatypes.ModAddView

    fun toV0x19(d: ModBan): it.vercruysse.lemmyapi.v0x19.datatypes.ModBan

    fun toV0x19(d: ModBanFromCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunity

    fun toV0x19(d: ModBanFromCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunityView

    fun toV0x19(d: ModBanView): it.vercruysse.lemmyapi.v0x19.datatypes.ModBanView

    fun toV0x19(d: ModFeaturePost): it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePost

    fun toV0x19(d: ModFeaturePostView): it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePostView

    fun toV0x19(d: ModHideCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunity

    fun toV0x19(d: ModHideCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunityView

    fun toV0x19(d: ModLockPost): it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPost

    fun toV0x19(d: ModLockPostView): it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPostView

    fun toV0x19(d: ModlogListParams): it.vercruysse.lemmyapi.v0x19.datatypes.ModlogListParams

    fun toV0x19(d: ModRemoveComment): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveComment

    fun toV0x19(d: ModRemoveCommentView): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommentView

    fun toV0x19(d: ModRemoveCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunity

    fun toV0x19(d: ModRemoveCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunityView

    fun toV0x19(d: ModRemovePost): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePost

    fun toV0x19(d: ModRemovePostView): it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePostView

    fun toV0x19(d: ModTransferCommunity): it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunity

    fun toV0x19(d: ModTransferCommunityView): it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunityView

    fun toV0x19(d: Person): it.vercruysse.lemmyapi.v0x19.datatypes.Person

    fun toV0x19(d: PersonAggregates): it.vercruysse.lemmyapi.v0x19.datatypes.PersonAggregates

    fun toV0x19(d: PersonBlockView): it.vercruysse.lemmyapi.v0x19.datatypes.PersonBlockView

    fun toV0x19(d: PersonMention): it.vercruysse.lemmyapi.v0x19.datatypes.PersonMention

    fun toV0x19(d: PersonMentionResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionResponse

    fun toV0x19(d: PersonMentionView): it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionView

    fun toV0x19(d: PersonView): it.vercruysse.lemmyapi.v0x19.datatypes.PersonView

    fun toV0x19(d: Post): it.vercruysse.lemmyapi.v0x19.datatypes.Post

    fun toV0x19(d: PostAggregates): it.vercruysse.lemmyapi.v0x19.datatypes.PostAggregates

    fun toV0x19(d: PostReport): it.vercruysse.lemmyapi.v0x19.datatypes.PostReport

    fun toV0x19(d: PostReportResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PostReportResponse

    fun toV0x19(d: PostReportView): it.vercruysse.lemmyapi.v0x19.datatypes.PostReportView

    fun toV0x19(d: PostResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PostResponse

    fun toV0x19(d: PostView): it.vercruysse.lemmyapi.v0x19.datatypes.PostView

    fun toV0x19(d: PrivateMessage): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessage

    fun toV0x19(d: PrivateMessageReport): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReport

    fun toV0x19(d: PrivateMessageReportResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportResponse

    fun toV0x19(d: PrivateMessageReportView): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportView

    fun toV0x19(d: PrivateMessageResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageResponse

    fun toV0x19(d: PrivateMessagesResponse): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessagesResponse

    fun toV0x19(d: PrivateMessageView): it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageView

    fun toV0x19(d: RegistrationApplication): it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplication

    fun toV0x19(d: RegistrationApplicationResponse): it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationResponse

    fun toV0x19(d: RegistrationApplicationView): it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationView

    fun toV0x19(d: ResolveObjectResponse): it.vercruysse.lemmyapi.v0x19.datatypes.ResolveObjectResponse

    fun toV0x19(d: SearchResponse): it.vercruysse.lemmyapi.v0x19.datatypes.SearchResponse

    fun toV0x19(d: Site): it.vercruysse.lemmyapi.v0x19.datatypes.Site

    fun toV0x19(d: SiteAggregates): it.vercruysse.lemmyapi.v0x19.datatypes.SiteAggregates

    fun toV0x19(d: SiteMetadata): it.vercruysse.lemmyapi.v0x19.datatypes.SiteMetadata

    fun toV0x19(d: SiteResponse): it.vercruysse.lemmyapi.v0x19.datatypes.SiteResponse

    fun toV0x19(d: SiteView): it.vercruysse.lemmyapi.v0x19.datatypes.SiteView

    fun toV0x19(d: Tagline): it.vercruysse.lemmyapi.v0x19.datatypes.Tagline

    // body mappings
    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.AddAdmin): AddAdmin

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.AddModToCommunity): AddModToCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.BanFromCommunity): BanFromCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.BanPerson): BanPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.BlockCommunity): BlockCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.BlockPerson): BlockPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ChangePassword): ChangePassword

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateComment): CreateComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommentLike): CreateCommentLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommentReport): CreateCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommunity): CreateCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateCustomEmoji): CreateCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreatePost): CreatePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreatePostLike): CreatePostLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreatePostReport): CreatePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreatePrivateMessage): CreatePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.CreateSite): CreateSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeleteAccount): DeleteAccount

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeleteComment): DeleteComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeleteCommunity): DeleteCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeleteCustomEmoji): DeleteCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeletePost): DeletePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DeletePrivateMessage): DeletePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.DistinguishComment): DistinguishComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditComment): EditComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditCommunity): EditCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditCustomEmoji): EditCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditPost): EditPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditPrivateMessage): EditPrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.EditSite): EditSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.FeaturePost): FeaturePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.FollowCommunity): FollowCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetComment): GetComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetComments): GetComments

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetCommunity): GetCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetModlog): GetModlog

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonDetails): GetPersonDetails

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonMentions): GetPersonMentions

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetPost): GetPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetPosts): GetPosts

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetPrivateMessages): GetPrivateMessages

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetReplies): GetReplies

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetReportCount): GetReportCount

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteMetadata): GetSiteMetadata

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.HideCommunity): HideCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ListCommentReports): ListCommentReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ListCommunities): ListCommunities

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ListPostReports): ListPostReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ListPrivateMessageReports): ListPrivateMessageReports

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ListRegistrationApplications): ListRegistrationApplications

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.LockPost): LockPost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.Login): Login

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.MarkCommentReplyAsRead): MarkCommentReplyAsRead

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.MarkPersonMentionAsRead): MarkPersonMentionAsRead

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.MarkPrivateMessageAsRead): MarkPrivateMessageAsRead

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PasswordChangeAfterReset): PasswordChangeAfterReset

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PasswordReset): PasswordReset

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PurgeComment): PurgeComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PurgeCommunity): PurgeCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PurgePerson): PurgePerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.PurgePost): PurgePost

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.Register): Register

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.RemoveComment): RemoveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.RemoveCommunity): RemoveCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.RemovePost): RemovePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ResolveCommentReport): ResolveCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ResolveObject): ResolveObject

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ResolvePostReport): ResolvePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.SaveComment): SaveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.SavePost): SavePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.SaveUserSettings): SaveUserSettings

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.Search): Search

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.TransferCommunity): TransferCommunity

    fun toV0x18(d: it.vercruysse.lemmyapi.v0x19.datatypes.VerifyEmail): VerifyEmail
}
