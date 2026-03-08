@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.example

import io.mcarle.konvert.api.Konvert
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.api.Mapping
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.*

//@Konverter(
//    options = [
//        Konfig(key = "konvert.konverter.generate-class", value = "true"),
//        Konfig(key = "konvert.enable-converters", value = "FloatToIntConverter"),
//        Konfig(key = "konvert.add-generated-konverter-annotation", value = "false"),
//    ],
//
//    )
internal interface MapperGenerator0x18x5 {
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
            Mapping(target = "collapse_bot_comments", constant = "false"),
        ],
    )
    fun toUni(d: LocalUser): it.vercruysse.lemmyapi.datatypes.LocalUser

    @Konvert(mappings = [Mapping(target = "instance_blocks", constant = "listOf()")])
    fun toUni(d: MyUserInfo): it.vercruysse.lemmyapi.datatypes.MyUserInfo

    @Konvert(
        mappings = [
            Mapping(target = "import_user_settings", constant = "-1"),
            Mapping(target = "import_user_settings_per_second", constant = "-1"),
        ],
    )
    fun toUni(d: LocalSiteRateLimit): it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit


    @Konvert(
        mappings = [
            Mapping(target = "banned_from_community", constant = "false"),
            Mapping(target = "creator_is_moderator", constant = "false"),
            Mapping(target = "creator_is_admin", constant = "false"),
            Mapping(target = "creator_blocked", constant = "false"),
            Mapping(target = "subscribed", constant = "SubscribedType.NotSubscribed"),
            Mapping(target = "saved", constant = "false"),
        ]
    )
    fun toUni(d: CommentReportView): it.vercruysse.lemmyapi.datatypes.CommentReportView

    @Konvert(
        mappings = [
            Mapping(target = "banned_from_community", constant = "false"),
            Mapping(target = "creator_is_moderator", constant = "false"),
            Mapping(target = "creator_is_admin", constant = "false"),
        ]
    )
    fun toUni(d: CommentView): it.vercruysse.lemmyapi.datatypes.CommentView

    @Konvert(
        mappings = [
            Mapping(target = "visibility", constant = "CommunityVisibility.Public"),
        ]
    )
    fun toUni(d: Community): it.vercruysse.lemmyapi.datatypes.Community

    @Konvert(
        mappings = [
            Mapping(target = "banned_from_community", constant = "false"),
        ]
    )
    fun toUni(d: CommunityView): it.vercruysse.lemmyapi.datatypes.CommunityView

    fun toUniF(d: Instance): it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState =
        it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState(
            id = d.id,
            domain = d.domain,
            published_at = d.published,
            updated_at = d.updated,
            software = d.software,
            version = d.version,
        )

    fun toUni(d: SiteMetadata): it.vercruysse.lemmyapi.datatypes.LinkMetadata =
        it.vercruysse.lemmyapi.datatypes.LinkMetadata(
            title = d.title,
            description = d.description,
            image = d.image,
            embed_video_url = d.embed_video_url,
        )

    @Konvert(
        mappings = [
            Mapping(target = "blocked_urls", constant = "listOf()"),
        ]
    )
    fun toUni(d: GetSiteResponse): it.vercruysse.lemmyapi.datatypes.GetSiteResponse

    @Konvert(
        mappings = [
            Mapping(target = "federation_signed_fetch", constant = "false"),
            Mapping(target = "default_post_listing_mode", constant = "PostListingMode.Card"),
            Mapping(target = "default_sort_type", constant = "SortType.Active"),
        ]
    )
    fun toUni(d: LocalSite): it.vercruysse.lemmyapi.datatypes.LocalSite

    fun toUni(@Konverter.Source d: PersonView, is_admin: Boolean = false): it.vercruysse.lemmyapi.datatypes.PersonView

    @Konvert(
        mappings = [
            Mapping(target = "creator_is_moderator", constant = "false"),
            Mapping(target = "creator_is_admin", constant = "false"),
            Mapping(target = "creator_blocked", constant = "false"),
            Mapping(target = "subscribed", constant = "SubscribedType.NotSubscribed"),
            Mapping(target = "saved", constant = "false"),
            Mapping(target = "read", constant = "false"),
            Mapping(target = "hidden", constant = "false"),
            Mapping(target = "unread_comments", constant = "0"),
        ]
    )
    fun toUni(d: PostReportView): it.vercruysse.lemmyapi.datatypes.PostReportView

    @Konvert(
        mappings = [
            Mapping(target = "banned_from_community", constant = "false"),
            Mapping(target = "creator_is_moderator", constant = "false"),
            Mapping(target = "creator_is_admin", constant = "false"),
            Mapping(target = "hidden", constant = "false"),
        ]
    )
    fun toUni(d: PostView): it.vercruysse.lemmyapi.datatypes.PostView
    // GENERATED

    fun toUni(d: AddAdminResponse): it.vercruysse.lemmyapi.datatypes.AddAdminResponse
    fun toUni(d: AddModToCommunityResponse): it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse
    fun toUni(d: CaptchaResponse): it.vercruysse.lemmyapi.datatypes.CaptchaResponse
    fun toUni(d: Comment): it.vercruysse.lemmyapi.datatypes.Comment

    fun toUni(d: CommentReport): it.vercruysse.lemmyapi.datatypes.CommentReport
    fun toUni(d: CommentReportResponse): it.vercruysse.lemmyapi.datatypes.CommentReportResponse

    fun toUni(d: CommentResponse): it.vercruysse.lemmyapi.datatypes.CommentResponse


    fun toUni(d: CommunityFollowerView): it.vercruysse.lemmyapi.datatypes.CommunityFollowerView
    fun toUni(d: CommunityModeratorView): it.vercruysse.lemmyapi.datatypes.CommunityModeratorView
    fun toUni(d: CommunityResponse): it.vercruysse.lemmyapi.datatypes.CommunityResponse

    fun toUni(d: CustomEmoji): it.vercruysse.lemmyapi.datatypes.CustomEmoji
    fun toUni(d: CustomEmojiKeyword): it.vercruysse.lemmyapi.datatypes.CustomEmojiKeyword
    fun toUni(d: CustomEmojiResponse): it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse
    fun toUni(d: CustomEmojiView): it.vercruysse.lemmyapi.datatypes.CustomEmojiView
    fun toUni(d: GetCaptchaResponse): it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse
    fun toUni(d: GetCommunityResponse): it.vercruysse.lemmyapi.datatypes.GetCommunityResponse
    fun toUni(d: GetPersonDetailsResponse): it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse
    fun toUni(d: GetPostResponse): it.vercruysse.lemmyapi.datatypes.GetPostResponse
    fun toUni(d: GetSiteMetadataResponse): it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse

    fun toUni(d: Instance): it.vercruysse.lemmyapi.datatypes.Instance
    fun toUni(d: Language): it.vercruysse.lemmyapi.datatypes.Language

    fun toUni(d: LocalUserView): it.vercruysse.lemmyapi.datatypes.LocalUserView
    fun toUni(d: LoginResponse): it.vercruysse.lemmyapi.datatypes.LoginResponse
    fun toUni(d: Person): it.vercruysse.lemmyapi.datatypes.Person


    fun toUni(d: Post): it.vercruysse.lemmyapi.datatypes.Post
    fun toUni(d: PostReport): it.vercruysse.lemmyapi.datatypes.PostReport
    fun toUni(d: PostReportResponse): it.vercruysse.lemmyapi.datatypes.PostReportResponse

    fun toUni(d: PostResponse): it.vercruysse.lemmyapi.datatypes.PostResponse

    fun toUni(d: PrivateMessage): it.vercruysse.lemmyapi.datatypes.PrivateMessage
    fun toUni(d: PrivateMessageReport): it.vercruysse.lemmyapi.datatypes.PrivateMessageReport
    fun toUni(d: PrivateMessageReportResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse
    fun toUni(d: PrivateMessageReportView): it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView
    fun toUni(d: PrivateMessageResponse): it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse
    fun toUni(d: PrivateMessageView): it.vercruysse.lemmyapi.datatypes.PrivateMessageView
    fun toUni(d: RegistrationApplication): it.vercruysse.lemmyapi.datatypes.RegistrationApplication
    fun toUni(d: RegistrationApplicationResponse): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse
    fun toUni(d: RegistrationApplicationView): it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView
    fun toUni(d: SearchResponse): it.vercruysse.lemmyapi.datatypes.SearchResponse
    fun toUni(d: Site): it.vercruysse.lemmyapi.datatypes.Site
    fun toUni(d: SiteResponse): it.vercruysse.lemmyapi.datatypes.SiteResponse
    fun toUni(d: SiteView): it.vercruysse.lemmyapi.datatypes.SiteView
    fun toUni(d: Tagline): it.vercruysse.lemmyapi.datatypes.Tagline

    // body mappings
    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddAdmin): AddAdmin

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.AddModToCommunity): AddModToCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication): ApproveRegistrationApplication

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanFromCommunity): BanFromCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BanPerson): BanPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockCommunity): BlockCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.BlockPerson): BlockPerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ChangePassword): ChangePassword

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateComment): CreateComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentLike): CreateCommentLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommentReport): CreateCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCommunity): CreateCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji): CreateCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePost): CreatePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostLike): CreatePostLike

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePostReport): CreatePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage): CreatePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport): CreatePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.CreateSite): CreateSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteAccount): DeleteAccount

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteComment): DeleteComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCommunity): DeleteCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji): DeleteCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePost): DeletePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage): DeletePrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.DistinguishComment): DistinguishComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditComment): EditComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCommunity): EditCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditCustomEmoji): EditCustomEmoji

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPost): EditPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditPrivateMessage): EditPrivateMessage

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.EditSite): EditSite

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FeaturePost): FeaturePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.FollowCommunity): FollowCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComment): GetComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetComments): GetComments

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetCommunity): GetCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetModlog): GetModlog

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPersonDetails): GetPersonDetails

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPost): GetPost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetPosts): GetPosts

    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.GetSiteMetadata): GetSiteMetadata

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.HideCommunity): HideCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListCommunities): ListCommunities

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications): ListRegistrationApplications

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.LockPost): LockPost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Login): Login

    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PasswordChangeAfterReset): PasswordChangeAfterReset
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PasswordReset): PasswordReset

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeComment): PurgeComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgeCommunity): PurgeCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePerson): PurgePerson

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.PurgePost): PurgePost
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Register): Register

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveComment): RemoveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemoveCommunity): RemoveCommunity

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.RemovePost): RemovePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveCommentReport): ResolveCommentReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolveObject): ResolveObject

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePostReport): ResolvePostReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport): ResolvePrivateMessageReport

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveComment): SaveComment

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SavePost): SavePost

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.SaveUserSettings): SaveUserSettings

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.Search): Search

    @Konvert(mappings = [Mapping(target = "auth", constant = "auth")])
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.TransferCommunity): TransferCommunity
    fun fromUni(d: it.vercruysse.lemmyapi.datatypes.VerifyEmail): VerifyEmail

}
