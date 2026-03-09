package it.vercruysse.lemmyapi.v0.x19.x11

import it.vercruysse.lemmyapi.datatypes.CommentActions
import it.vercruysse.lemmyapi.datatypes.CommunityActions
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.Notification
import it.vercruysse.lemmyapi.datatypes.NotificationView
import it.vercruysse.lemmyapi.datatypes.PersonActions
import it.vercruysse.lemmyapi.datatypes.PostActions
import it.vercruysse.lemmyapi.v0.enums.CommentSortType as V0CommentSortType
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.NotificationType
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteShow
import it.vercruysse.lemmyapi.v0.enums.CommunityVisibility as V0CommunityVisibility
import it.vercruysse.lemmyapi.v0.enums.ListingType as V0ListingType
import it.vercruysse.lemmyapi.v0.enums.ModlogActionType as V0ModlogActionType
import it.vercruysse.lemmyapi.v0.enums.PostFeatureType as V0PostFeatureType
import it.vercruysse.lemmyapi.v0.enums.PostListingMode as V0PostListingMode
import it.vercruysse.lemmyapi.v0.enums.RegistrationMode as V0RegistrationMode
import it.vercruysse.lemmyapi.v0.enums.SearchType as V0SearchType
import it.vercruysse.lemmyapi.v0.enums.SortType as V0SortType
import it.vercruysse.lemmyapi.utils.toAt
import it.vercruysse.lemmyapi.datatypes.AddAdmin as LemmyapiDatatypesAddAdmin
import it.vercruysse.lemmyapi.datatypes.AddAdminResponse as LemmyapiDatatypesAddAdminResponse
import it.vercruysse.lemmyapi.datatypes.AddModToCommunity as LemmyapiDatatypesAddModToCommunity
import it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse as LemmyapiDatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication as LemmyapiDatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.BanFromCommunity as LemmyapiDatatypesBanFromCommunity
import it.vercruysse.lemmyapi.datatypes.BanPerson as LemmyapiDatatypesBanPerson
import it.vercruysse.lemmyapi.datatypes.BlockCommunity as LemmyapiDatatypesBlockCommunity
import it.vercruysse.lemmyapi.datatypes.BlockPerson as LemmyapiDatatypesBlockPerson
import it.vercruysse.lemmyapi.datatypes.CaptchaResponse as LemmyapiDatatypesCaptchaResponse
import it.vercruysse.lemmyapi.datatypes.ChangePassword as LemmyapiDatatypesChangePassword
import it.vercruysse.lemmyapi.datatypes.Comment as LemmyapiDatatypesComment
import it.vercruysse.lemmyapi.datatypes.CommentReport as LemmyapiDatatypesCommentReport
import it.vercruysse.lemmyapi.datatypes.CommentReportResponse as LemmyapiDatatypesCommentReportResponse
import it.vercruysse.lemmyapi.datatypes.CommentReportView as LemmyapiDatatypesCommentReportView
import it.vercruysse.lemmyapi.datatypes.CommentResponse as LemmyapiDatatypesCommentResponse
import it.vercruysse.lemmyapi.datatypes.CommentView as LemmyapiDatatypesCommentView
import it.vercruysse.lemmyapi.datatypes.Community as LemmyapiDatatypesCommunity
import it.vercruysse.lemmyapi.datatypes.CommunityFollowerView as LemmyapiDatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.datatypes.CommunityModeratorView as LemmyapiDatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.datatypes.CommunityResponse as LemmyapiDatatypesCommunityResponse
import it.vercruysse.lemmyapi.datatypes.CommunityView as LemmyapiDatatypesCommunityView
import it.vercruysse.lemmyapi.datatypes.CreateComment as LemmyapiDatatypesCreateComment
import it.vercruysse.lemmyapi.datatypes.CreateCommentLike as LemmyapiDatatypesCreateCommentLike
import it.vercruysse.lemmyapi.datatypes.CreateCommentReport as LemmyapiDatatypesCreateCommentReport
import it.vercruysse.lemmyapi.datatypes.CreateCommunity as LemmyapiDatatypesCreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji as LemmyapiDatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.datatypes.CreatePost as LemmyapiDatatypesCreatePost
import it.vercruysse.lemmyapi.datatypes.CreatePostLike as LemmyapiDatatypesCreatePostLike
import it.vercruysse.lemmyapi.datatypes.CreatePostReport as LemmyapiDatatypesCreatePostReport
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage as LemmyapiDatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport as LemmyapiDatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.CreateSite as LemmyapiDatatypesCreateSite
import it.vercruysse.lemmyapi.datatypes.CustomEmoji as LemmyapiDatatypesCustomEmoji
import it.vercruysse.lemmyapi.datatypes.CustomEmojiKeyword as LemmyapiDatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse as LemmyapiDatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.datatypes.CustomEmojiView as LemmyapiDatatypesCustomEmojiView
import it.vercruysse.lemmyapi.datatypes.DeleteAccount as LemmyapiDatatypesDeleteAccount
import it.vercruysse.lemmyapi.datatypes.DeleteComment as LemmyapiDatatypesDeleteComment
import it.vercruysse.lemmyapi.datatypes.DeleteCommunity as LemmyapiDatatypesDeleteCommunity
import it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji as LemmyapiDatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.datatypes.DeletePost as LemmyapiDatatypesDeletePost
import it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage as LemmyapiDatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.datatypes.DistinguishComment as LemmyapiDatatypesDistinguishComment
import it.vercruysse.lemmyapi.datatypes.EditComment as LemmyapiDatatypesEditComment
import it.vercruysse.lemmyapi.datatypes.EditCommunity as LemmyapiDatatypesEditCommunity
import it.vercruysse.lemmyapi.datatypes.EditCustomEmoji as LemmyapiDatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.datatypes.EditPost as LemmyapiDatatypesEditPost
import it.vercruysse.lemmyapi.datatypes.EditPrivateMessage as LemmyapiDatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.datatypes.EditSite as LemmyapiDatatypesEditSite
import it.vercruysse.lemmyapi.datatypes.FeaturePost as LemmyapiDatatypesFeaturePost
import it.vercruysse.lemmyapi.datatypes.FollowCommunity as LemmyapiDatatypesFollowCommunity
import it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse as LemmyapiDatatypesGenerateTotpSecretResponse
import it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse as LemmyapiDatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.datatypes.GetComment as LemmyapiDatatypesGetComment
import it.vercruysse.lemmyapi.datatypes.GetComments as LemmyapiDatatypesGetComments
import it.vercruysse.lemmyapi.datatypes.GetCommunity as LemmyapiDatatypesGetCommunity
import it.vercruysse.lemmyapi.datatypes.GetCommunityResponse as LemmyapiDatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.datatypes.GetModlog as LemmyapiDatatypesGetModlog
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails as LemmyapiDatatypesGetPersonDetails
import it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse as LemmyapiDatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.datatypes.GetPost as LemmyapiDatatypesGetPost
import it.vercruysse.lemmyapi.datatypes.GetPostResponse as LemmyapiDatatypesGetPostResponse
import it.vercruysse.lemmyapi.datatypes.GetPosts as LemmyapiDatatypesGetPosts
import it.vercruysse.lemmyapi.datatypes.GetRegistrationApplication as LemmyapiDatatypesGetRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadata as LemmyapiDatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse as LemmyapiDatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.datatypes.GetSiteResponse as LemmyapiDatatypesGetSiteResponse
import it.vercruysse.lemmyapi.datatypes.HideCommunity as LemmyapiDatatypesHideCommunity
import it.vercruysse.lemmyapi.datatypes.HidePost as LemmyapiDatatypesHidePost
import it.vercruysse.lemmyapi.datatypes.ImageDetails as LemmyapiDatatypesImageDetails
import it.vercruysse.lemmyapi.datatypes.Instance as LemmyapiDatatypesInstance
import it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState as LemmyapiDatatypesInstanceWithFederationState
import it.vercruysse.lemmyapi.datatypes.Language as LemmyapiDatatypesLanguage
import it.vercruysse.lemmyapi.datatypes.LinkMetadata as LemmyapiDatatypesLinkMetadata
import it.vercruysse.lemmyapi.datatypes.ListCommentLikes as LemmyapiDatatypesListCommentLikes
import it.vercruysse.lemmyapi.datatypes.ListCommunities as LemmyapiDatatypesListCommunities
import it.vercruysse.lemmyapi.datatypes.ListMedia as LemmyapiDatatypesListMedia
import it.vercruysse.lemmyapi.datatypes.ListNotifications as LemmyapiDatatypesListNotifications
import it.vercruysse.lemmyapi.datatypes.ListPostLikes as LemmyapiDatatypesListPostLikes
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications as LemmyapiDatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.LocalImage as LemmyapiDatatypesLocalImage
import it.vercruysse.lemmyapi.datatypes.LocalImageView as LemmyapiDatatypesLocalImageView
import it.vercruysse.lemmyapi.datatypes.LocalSite as LemmyapiDatatypesLocalSite
import it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit as LemmyapiDatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.datatypes.LocalSiteUrlBlocklist as LemmyapiDatatypesLocalSiteUrlBlocklist
import it.vercruysse.lemmyapi.datatypes.LocalUser as LemmyapiDatatypesLocalUser
import it.vercruysse.lemmyapi.datatypes.LocalUserView as LemmyapiDatatypesLocalUserView
import it.vercruysse.lemmyapi.datatypes.LockPost as LemmyapiDatatypesLockPost
import it.vercruysse.lemmyapi.datatypes.Login as LemmyapiDatatypesLogin
import it.vercruysse.lemmyapi.datatypes.LoginResponse as LemmyapiDatatypesLoginResponse
import it.vercruysse.lemmyapi.datatypes.LoginToken as LemmyapiDatatypesLoginToken
import it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead as LemmyapiDatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.datatypes.MyUserInfo as LemmyapiDatatypesMyUserInfo
import it.vercruysse.lemmyapi.datatypes.PasswordChangeAfterReset as LemmyapiDatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.datatypes.PasswordReset as LemmyapiDatatypesPasswordReset
import it.vercruysse.lemmyapi.datatypes.Person as LemmyapiDatatypesPerson
import it.vercruysse.lemmyapi.datatypes.PersonView as LemmyapiDatatypesPersonView
import it.vercruysse.lemmyapi.datatypes.Post as LemmyapiDatatypesPost
import it.vercruysse.lemmyapi.datatypes.PostReport as LemmyapiDatatypesPostReport
import it.vercruysse.lemmyapi.datatypes.PostReportResponse as LemmyapiDatatypesPostReportResponse
import it.vercruysse.lemmyapi.datatypes.PostReportView as LemmyapiDatatypesPostReportView
import it.vercruysse.lemmyapi.datatypes.PostResponse as LemmyapiDatatypesPostResponse
import it.vercruysse.lemmyapi.datatypes.PostView as LemmyapiDatatypesPostView
import it.vercruysse.lemmyapi.datatypes.PrivateMessage as LemmyapiDatatypesPrivateMessage
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReport as LemmyapiDatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse as LemmyapiDatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView as LemmyapiDatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse as LemmyapiDatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.datatypes.PrivateMessageView as LemmyapiDatatypesPrivateMessageView
import it.vercruysse.lemmyapi.datatypes.PurgeComment as LemmyapiDatatypesPurgeComment
import it.vercruysse.lemmyapi.datatypes.PurgeCommunity as LemmyapiDatatypesPurgeCommunity
import it.vercruysse.lemmyapi.datatypes.PurgePerson as LemmyapiDatatypesPurgePerson
import it.vercruysse.lemmyapi.datatypes.PurgePost as LemmyapiDatatypesPurgePost
import it.vercruysse.lemmyapi.datatypes.FederationQueueState as LemmyapiDatatypesReadableFederationState
import it.vercruysse.lemmyapi.datatypes.Register as LemmyapiDatatypesRegister
import it.vercruysse.lemmyapi.datatypes.RegistrationApplication as LemmyapiDatatypesRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse as LemmyapiDatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView as LemmyapiDatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.datatypes.RemoveComment as LemmyapiDatatypesRemoveComment
import it.vercruysse.lemmyapi.datatypes.RemoveCommunity as LemmyapiDatatypesRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.RemovePost as LemmyapiDatatypesRemovePost
import it.vercruysse.lemmyapi.datatypes.ResolveCommentReport as LemmyapiDatatypesResolveCommentReport
import it.vercruysse.lemmyapi.datatypes.ResolveObject as LemmyapiDatatypesResolveObject
import it.vercruysse.lemmyapi.datatypes.ResolvePostReport as LemmyapiDatatypesResolvePostReport
import it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport as LemmyapiDatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.SaveComment as LemmyapiDatatypesSaveComment
import it.vercruysse.lemmyapi.datatypes.SavePost as LemmyapiDatatypesSavePost
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings as LemmyapiDatatypesSaveUserSettings
import it.vercruysse.lemmyapi.datatypes.Search as LemmyapiDatatypesSearch
import it.vercruysse.lemmyapi.datatypes.SearchResponse as LemmyapiDatatypesSearchResponse
import it.vercruysse.lemmyapi.datatypes.Site as LemmyapiDatatypesSite
import it.vercruysse.lemmyapi.datatypes.SiteResponse as LemmyapiDatatypesSiteResponse
import it.vercruysse.lemmyapi.datatypes.SiteView as LemmyapiDatatypesSiteView
import it.vercruysse.lemmyapi.datatypes.Tagline as LemmyapiDatatypesTagline
import it.vercruysse.lemmyapi.datatypes.TransferCommunity as LemmyapiDatatypesTransferCommunity
import it.vercruysse.lemmyapi.datatypes.EditTotp as LemmyapiDatatypesUpdateTotp
import it.vercruysse.lemmyapi.datatypes.EditTotpResponse as LemmyapiDatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams as LemmyapiDatatypesBlockInstance
import it.vercruysse.lemmyapi.datatypes.VerifyEmail as LemmyapiDatatypesVerifyEmail
import it.vercruysse.lemmyapi.datatypes.VoteView as LemmyapiDatatypesVoteView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.AddAdmin as X11DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.AddAdminResponse as X11DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.AddModToCommunity as X11DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.AddModToCommunityResponse as X11DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ApproveRegistrationApplication as X11DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BanFromCommunity as X11DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BanFromCommunityResponse as X11DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BanPerson as X11DatatypesBanPerson
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BanPersonResponse as X11DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BlockCommunity as X11DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BlockCommunityResponse as X11DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BlockInstance as X11DatatypesBlockInstance
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BlockPerson as X11DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.BlockPersonResponse as X11DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CaptchaResponse as X11DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ChangePassword as X11DatatypesChangePassword
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Comment as X11DatatypesComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentAggregates as X11DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentReplyView as X11DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentReport as X11DatatypesCommentReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentReportResponse as X11DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentReportView as X11DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentResponse as X11DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommentView as X11DatatypesCommentView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Community as X11DatatypesCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityAggregates as X11DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityFollowerView as X11DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityModeratorView as X11DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityResponse as X11DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CommunityView as X11DatatypesCommunityView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateComment as X11DatatypesCreateComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateCommentLike as X11DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateCommentReport as X11DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateCommunity as X11DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateCustomEmoji as X11DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreatePost as X11DatatypesCreatePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreatePostLike as X11DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreatePostReport as X11DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreatePrivateMessage as X11DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreatePrivateMessageReport as X11DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CreateSite as X11DatatypesCreateSite
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CustomEmoji as X11DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CustomEmojiKeyword as X11DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CustomEmojiResponse as X11DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.CustomEmojiView as X11DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeleteAccount as X11DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeleteComment as X11DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeleteCommunity as X11DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeleteCustomEmoji as X11DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeletePost as X11DatatypesDeletePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DeletePrivateMessage as X11DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.DistinguishComment as X11DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditComment as X11DatatypesEditComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditCommunity as X11DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditCustomEmoji as X11DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditPost as X11DatatypesEditPost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditPrivateMessage as X11DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.EditSite as X11DatatypesEditSite
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.FeaturePost as X11DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.FollowCommunity as X11DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GenerateTotpSecretResponse as X11DatatypesGenerateTotpSecretResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCaptchaResponse as X11DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetComment as X11DatatypesGetComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetComments as X11DatatypesGetComments
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCommunity as X11DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetCommunityResponse as X11DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetModlog as X11DatatypesGetModlog
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPersonDetails as X11DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPersonDetailsResponse as X11DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPersonMentions as X11DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPost as X11DatatypesGetPost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPostResponse as X11DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPosts as X11DatatypesGetPosts
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetPrivateMessages as X11DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetRegistrationApplication as X11DatatypesGetRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetReplies as X11DatatypesGetReplies
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteMetadata as X11DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteMetadataResponse as X11DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.GetSiteResponse as X11DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.HideCommunity as X11DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.HidePost as X11DatatypesHidePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ImageDetails as X11DatatypesImageDetails
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Instance as X11DatatypesInstance
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.InstanceWithFederationState as X11DatatypesInstanceWithFederationState
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Language as X11DatatypesLanguage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LinkMetadata as X11DatatypesLinkMetadata
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListCommentLikes as X11DatatypesListCommentLikes
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListCommentReports as X11DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListCommunities as X11DatatypesListCommunities
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListMedia as X11DatatypesListMedia
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListPostLikes as X11DatatypesListPostLikes
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListPostReports as X11DatatypesListPostReports
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListPrivateMessageReports as X11DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ListRegistrationApplications as X11DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalImage as X11DatatypesLocalImage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalImageView as X11DatatypesLocalImageView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalSite as X11DatatypesLocalSite
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalSiteRateLimit as X11DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalSiteUrlBlocklist as X11DatatypesLocalSiteUrlBlocklist
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalUser as X11DatatypesLocalUser
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalUserView as X11DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LocalUserVoteDisplayMode as X11DatatypesLocalUserVoteDisplayMode
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LockPost as X11DatatypesLockPost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Login as X11DatatypesLogin
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LoginResponse as X11DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.LoginToken as X11DatatypesLoginToken
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.MarkCommentReplyAsRead as X11DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.MarkPersonMentionAsRead as X11DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.MarkPostAsRead as X11DatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.MarkPrivateMessageAsRead as X11DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.MyUserInfo as X11DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PasswordChangeAfterReset as X11DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PasswordReset as X11DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Person as X11DatatypesPerson
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PersonAggregates as X11DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PersonMentionView as X11DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PersonView as X11DatatypesPersonView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Post as X11DatatypesPost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostAggregates as X11DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostReport as X11DatatypesPostReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostReportResponse as X11DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostReportView as X11DatatypesPostReportView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostResponse as X11DatatypesPostResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PostView as X11DatatypesPostView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessage as X11DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessageReport as X11DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessageReportResponse as X11DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessageReportView as X11DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessageResponse as X11DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PrivateMessageView as X11DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PurgeComment as X11DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PurgeCommunity as X11DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PurgePerson as X11DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.PurgePost as X11DatatypesPurgePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ReadableFederationState as X11DatatypesReadableFederationState
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Register as X11DatatypesRegister
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RegistrationApplication as X11DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RegistrationApplicationResponse as X11DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RegistrationApplicationView as X11DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RemoveComment as X11DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RemoveCommunity as X11DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.RemovePost as X11DatatypesRemovePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolveCommentReport as X11DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolveObject as X11DatatypesResolveObject
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolveObjectResponse as X11DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolvePostReport as X11DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.ResolvePrivateMessageReport as X11DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SaveComment as X11DatatypesSaveComment
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SavePost as X11DatatypesSavePost
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SaveUserSettings as X11DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Search as X11DatatypesSearch
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SearchResponse as X11DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Site as X11DatatypesSite
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SiteAggregates as X11DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SiteResponse as X11DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.SiteView as X11DatatypesSiteView
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.Tagline as X11DatatypesTagline
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.TransferCommunity as X11DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.UpdateTotp as X11DatatypesUpdateTotp
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.UpdateTotpResponse as X11DatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.VerifyEmail as X11DatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.VoteView as X11DatatypesVoteView

// Based on tags/0.19.11-donation-dialog.1
internal class Transformer : MapperGenerator {
    override fun toUni(d: X11DatatypesAddAdminResponse): LemmyapiDatatypesAddAdminResponse =
        LemmyapiDatatypesAddAdminResponse(
            admins = d.admins.map { this.toUni(d = it) },
        )

    override fun toUni(d: X11DatatypesAddModToCommunityResponse): LemmyapiDatatypesAddModToCommunityResponse = LemmyapiDatatypesAddModToCommunityResponse(
        moderators = d.moderators.map { this.toUni(d = it) },
    )

    override fun toUni(d: X11DatatypesBanFromCommunityResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X11DatatypesBanPersonResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X11DatatypesBlockCommunityResponse): it.vercruysse.lemmyapi.datatypes.CommunityResponse =
        it.vercruysse.lemmyapi.datatypes.CommunityResponse(community_view = this.toUni(d = d.community_view), discussion_languages = emptyList())

    override fun toUni(d: X11DatatypesBlockPersonResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X11DatatypesCaptchaResponse): LemmyapiDatatypesCaptchaResponse =
        LemmyapiDatatypesCaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid,
        )

    override fun toUni(d: X11DatatypesComment, counts: X11DatatypesCommentAggregates): LemmyapiDatatypesComment = LemmyapiDatatypesComment(
        id = d.id,
        creator_id = d.creator_id,
        post_id = d.post_id,
        content = d.content,
        removed = d.removed,
        published_at = d.published,
        updated_at = d.updated,
        deleted = d.deleted,
        ap_id = d.ap_id,
        local = d.local,
        path = d.path,
        distinguished = d.distinguished,
        language_id = d.language_id,
        score = counts.score,
        upvotes = counts.upvotes,
        downvotes = counts.downvotes,
        child_count = counts.child_count,
        report_count = -1,
        unresolved_report_count = -1,
        federation_pending = false,
        locked = false,
    )

    override fun toUni(d: X11DatatypesCommentReport): LemmyapiDatatypesCommentReport =
        LemmyapiDatatypesCommentReport(
            id = d.id,
            creator_id = d.creator_id,
            comment_id = d.comment_id,
            original_comment_text = d.original_comment_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X11DatatypesCommentReportResponse): LemmyapiDatatypesCommentReportResponse =
        LemmyapiDatatypesCommentReportResponse(
            comment_report_view = this.toUni(d = d.comment_report_view),
        )

    override fun toUni(d: X11DatatypesCommentReportView): LemmyapiDatatypesCommentReportView =
        LemmyapiDatatypesCommentReportView(
            comment_report = this.toUni(d = d.comment_report),
            comment = this.toUni(d = d.comment, d.counts),
            post = this.toUni(d = d.post, counts = X11DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            comment_creator = this.toUni(d = d.comment_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            creator_banned = d.creator.banned,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X11DatatypesCommentResponse): LemmyapiDatatypesCommentResponse =
        LemmyapiDatatypesCommentResponse(
            comment_view = this.toUni(d = d.comment_view),
        )

    override fun toUni(d: X11DatatypesCommentView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X11DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X11DatatypesCommunity, counts: X11DatatypesCommunityAggregates): LemmyapiDatatypesCommunity =
        LemmyapiDatatypesCommunity(
            id = d.id,
            name = d.name,
            title = d.title,
            summary = d.description,
            removed = d.removed,
            published_at = d.published,
            updated_at = d.updated,
            deleted = d.deleted,
            nsfw = d.nsfw,
            ap_id = d.actor_id,
            local = d.local,
            icon = d.icon,
            banner = d.banner,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            instance_id = d.instance_id,
            visibility = if (d.hidden) CommunityVisibility.Unlisted else d.visibility.toUni(),
            subscribers = counts.subscribers,
            posts = counts.posts,
            comments = counts.comments,
            users_active_day = counts.users_active_day,
            users_active_week = counts.users_active_week,
            users_active_month = counts.users_active_month,
            users_active_half_year = counts.users_active_half_year,
            subscribers_local = -1,
            report_count = -1,
            unresolved_report_count = -1,
            local_removed = false,
            last_refreshed_at = "",
        )

    override fun toUni(d: X11DatatypesCommunityFollowerView): LemmyapiDatatypesCommunityFollowerView =
        LemmyapiDatatypesCommunityFollowerView(
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            follower = this.toUni(d = d.follower),
        )

    override fun toUni(d: X11DatatypesCommunityModeratorView): LemmyapiDatatypesCommunityModeratorView = LemmyapiDatatypesCommunityModeratorView(
        community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        moderator = this.toUni(d = d.moderator),
    )

    override fun toUni(d: X11DatatypesCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X11DatatypesCommunityView): LemmyapiDatatypesCommunityView =
        LemmyapiDatatypesCommunityView(
            community = this.toUni(d = d.community, d.counts),
            can_mod = false,
            tags = emptyList(),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed), if (d.blocked) "" else null, null, if (d.banned_from_community) "" else null, if (d.banned_from_community) "" else null),
        )

    override fun toUni(d: X11DatatypesCustomEmoji): LemmyapiDatatypesCustomEmoji =
        LemmyapiDatatypesCustomEmoji(
            id = d.id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X11DatatypesCustomEmojiKeyword): LemmyapiDatatypesCustomEmojiKeyword =
        LemmyapiDatatypesCustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword,
        )

    override fun toUni(d: X11DatatypesCustomEmojiResponse): LemmyapiDatatypesCustomEmojiResponse =
        LemmyapiDatatypesCustomEmojiResponse(
            custom_emoji = this.toUni(d = d.custom_emoji),
        )

    override fun toUni(d: X11DatatypesCustomEmojiView): LemmyapiDatatypesCustomEmojiView =
        LemmyapiDatatypesCustomEmojiView(
            custom_emoji = this.toUni(d = d.custom_emoji),
            keywords = d.keywords.map { this.toUni(d = it) },
        )

    override fun toUni(d: X11DatatypesGenerateTotpSecretResponse): LemmyapiDatatypesGenerateTotpSecretResponse = LemmyapiDatatypesGenerateTotpSecretResponse(
        totp_secret_url = d.totp_secret_url,
    )

    override fun toUni(d: X11DatatypesGetCaptchaResponse): LemmyapiDatatypesGetCaptchaResponse =
        LemmyapiDatatypesGetCaptchaResponse(
            ok = d.ok?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X11DatatypesGetCommunityResponse): LemmyapiDatatypesGetCommunityResponse =
        LemmyapiDatatypesGetCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            site = d.site?.let { this.toUni(d = it) },
            moderators = d.moderators.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X11DatatypesGetPersonDetailsResponse): LemmyapiDatatypesGetPersonDetailsResponse = LemmyapiDatatypesGetPersonDetailsResponse(
        person_view = this.toUni(d = d.person_view),
        site = d.site?.let { this.toUni(d = it) },
        moderates = d.moderates.map { this.toUni(d = it) },
        multi_communities_created = emptyList()
    )

    override fun toUni(d: X11DatatypesGetPostResponse): LemmyapiDatatypesGetPostResponse =
        LemmyapiDatatypesGetPostResponse(
            post_view = this.toUni(d = d.post_view),
            community_view = this.toUni(d = d.community_view),
            moderators = d.moderators.map { this.toUni(d = it) },
            cross_posts = d.cross_posts.map { this.toUni(d = it) },
        )

    fun toUni(d: X11DatatypesCommentReplyView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.comment_reply.id,
                recipient_id = d.comment_reply.recipient_id,
                comment_id = d.comment_reply.comment_id,
                read = d.comment_reply.read,
                published_at = d.comment_reply.published,
                kind = NotificationType.Reply,
                post_id = d.post.id,
            ),
            data = this.toUniCV(d),
        )

    fun toUniCV(d: X11DatatypesCommentReplyView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X11DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUni(d: X11DatatypesPersonMentionView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.person_mention.id,
                recipient_id = d.person_mention.recipient_id,
                comment_id = d.person_mention.comment_id,
                read = d.person_mention.read,
                published_at = d.person_mention.published,
                kind = NotificationType.Mention,
                post_id = d.post.id,
            ),
            data = this.toUniPV(d),
        )

    fun toUniPV(d: X11DatatypesPersonMentionView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X11DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUniPMV(d: X11DatatypesPrivateMessageView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.private_message.id,
                recipient_id = d.private_message.recipient_id,
                read = d.private_message.read,
                published_at = d.private_message.published,
                kind = NotificationType.PrivateMessage,
            ),
            data = this.toUni(d),
        )

    override fun toUni(d: X11DatatypesGetSiteMetadataResponse): LemmyapiDatatypesGetSiteMetadataResponse = LemmyapiDatatypesGetSiteMetadataResponse(
        metadata = this.toUni(d = d.metadata),
    )

    override fun toUni(d: X11DatatypesGetSiteResponse): LemmyapiDatatypesGetSiteResponse =
        LemmyapiDatatypesGetSiteResponse(
            site_view = this.toUni(d = d.site_view),
            admins = d.admins.map { this.toUni(d = it) },
            version = d.version,
            all_languages = d.all_languages.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
            blocked_urls = d.blocked_urls.map { this.toUni(d = it) },
            tagline = if (d.taglines.isEmpty()) null else this.toUni(d = d.taglines.random()),
            oauth_providers = emptyList(),
            admin_oauth_providers = emptyList(),
            image_upload_disabled = false,
            active_plugins = emptyList(),
        )

    override fun toUni(d: X11DatatypesImageDetails): LemmyapiDatatypesImageDetails =
        LemmyapiDatatypesImageDetails(
            link = d.link,
            width = d.width,
            height = d.height,
            content_type = d.content_type,
        )

    override fun toUni(d: X11DatatypesInstance): LemmyapiDatatypesInstance =
        LemmyapiDatatypesInstance(
            id = d.id,
            domain = d.domain,
            published_at = d.published,
            updated_at = d.updated,
            software = d.software,
            version = d.version,
        )

    override fun toUni(d: X11DatatypesInstanceWithFederationState): LemmyapiDatatypesInstanceWithFederationState = LemmyapiDatatypesInstanceWithFederationState(
        id = d.id,
        domain = d.domain,
        published_at = d.published,
        updated_at = d.updated,
        software = d.software,
        version = d.version,
        federation_state = d.federation_state?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X11DatatypesLanguage): LemmyapiDatatypesLanguage =
        LemmyapiDatatypesLanguage(
            id = d.id,
            code = d.code,
            name = d.name,
        )

    override fun toUni(d: X11DatatypesLinkMetadata): LemmyapiDatatypesLinkMetadata =
        LemmyapiDatatypesLinkMetadata(
            title = d.title,
            description = d.description,
            image = d.image,
            embed_video_url = d.embed_video_url,
            content_type = d.content_type,
        )

    override fun toUni(d: X11DatatypesLocalImage): LemmyapiDatatypesLocalImage =
        LemmyapiDatatypesLocalImage(
            person_id = d.local_user_id,
            pictrs_alias = d.pictrs_alias,
            pictrs_delete_token = d.pictrs_delete_token,
            published_at = d.published,
        )

    override fun toUni(d: X11DatatypesLocalImageView): LemmyapiDatatypesLocalImageView =
        LemmyapiDatatypesLocalImageView(
            local_image = this.toUni(d = d.local_image),
            person = this.toUni(d = d.person),
        )

    override fun toUni(d: X11DatatypesLocalSite, counts: X11DatatypesSiteAggregates): LemmyapiDatatypesLocalSite =
        LemmyapiDatatypesLocalSite(
            id = d.id,
            site_id = d.site_id,
            site_setup = d.site_setup,
            community_creation_admin_only = d.community_creation_admin_only,
            require_email_verification = d.require_email_verification,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = d.default_post_listing_type.toUni(),
            legal_information = d.legal_information,
            application_email_admins = d.application_email_admins,
            slur_filter_regex = d.slur_filter_regex,
            federation_enabled = d.federation_enabled,
            captcha_enabled = d.captcha_enabled,
            captcha_difficulty = d.captcha_difficulty,
            published_at = d.published,
            updated_at = d.updated,
            registration_mode = d.registration_mode.toUni(),
            reports_email_admins = d.reports_email_admins,
            federation_signed_fetch = d.federation_signed_fetch,
            default_post_listing_mode = d.default_post_listing_mode.toUni(),
            default_post_sort_type = d.default_sort_type.toUni(),
            disallow_nsfw_content = !d.enable_nsfw,
            oauth_registration = false,
            disable_email_notifications = false,
            suggested_multi_community_id = null,
            default_comment_sort_type = SortType.Active,
            default_post_time_range_seconds = null,
            post_upvotes = FederationMode.All,
            post_downvotes = if (d.enable_downvotes) FederationMode.All else FederationMode.Disable,
            comment_upvotes = FederationMode.All,
            comment_downvotes = if (d.enable_downvotes) FederationMode.All else FederationMode.Disable,
            users = counts.users,
            posts = counts.posts,
            comments = counts.comments,
            communities = counts.communities,
            users_active_day = counts.users_active_day,
            users_active_week = counts.users_active_week,
            users_active_month = counts.users_active_month,
            users_active_half_year = counts.users_active_half_year,
            default_items_per_page = 20,
        )

    override fun toUni(d: X11DatatypesLocalSiteRateLimit): LemmyapiDatatypesLocalSiteRateLimit =
        LemmyapiDatatypesLocalSiteRateLimit(
            local_site_id = d.local_site_id,
            message_max_requests = d.message,
            message_interval_seconds = d.message_per_second,
            post_max_requests = d.post,
            post_interval_seconds = d.post_per_second,
            register_max_requests = d.register,
            register_interval_seconds = d.register_per_second,
            image_max_requests = d.image,
            image_interval_seconds = d.image_per_second,
            comment_max_requests = d.comment,
            comment_interval_seconds = d.comment_per_second,
            search_max_requests = d.search,
            search_interval_seconds = d.search_per_second,
            published_at = d.published,
            updated_at = d.updated,
            import_user_settings_max_requests = d.import_user_settings,
            import_user_settings_interval_seconds = d.import_user_settings_per_second,
        )

    override fun toUni(d: X11DatatypesLocalSiteUrlBlocklist): LemmyapiDatatypesLocalSiteUrlBlocklist =
        LemmyapiDatatypesLocalSiteUrlBlocklist(
            id = d.id,
            url = d.url,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X11DatatypesLocalUser, e: X11DatatypesLocalUserVoteDisplayMode): LemmyapiDatatypesLocalUser =
        LemmyapiDatatypesLocalUser(
            id = d.id,
            person_id = d.person_id,
            email = d.email,
            show_nsfw = d.show_nsfw,
            theme = d.theme,
            default_post_sort_type = d.default_sort_type.toUni(),
            default_listing_type = d.default_listing_type.toUni(),
            interface_language = d.interface_language,
            show_avatars = d.show_avatars,
            send_notifications_to_email = d.send_notifications_to_email,
            show_bot_accounts = d.show_bot_accounts,
            show_read_posts = d.show_read_posts,
            email_verified = d.email_verified,
            accepted_application = d.accepted_application,
            open_links_in_new_tab = d.open_links_in_new_tab,
            blur_nsfw = d.blur_nsfw,
            infinite_scroll_enabled = d.infinite_scroll_enabled,
            admin = d.admin,
            post_listing_mode = d.post_listing_mode.toUni(),
            enable_animated_images = d.enable_animated_images,
            collapse_bot_comments = d.collapse_bot_comments,
            last_donation_notification_at = d.last_donation_notification,
            show_score = e.score,
            show_upvotes = e.upvotes,
            show_person_votes = e.score,
            show_upvote_percentage = e.upvote_percentage,
            show_downvotes = if (e.downvotes) VoteShow.Show else VoteShow.Hide,
            auto_mark_fetched_posts_as_read = false,
            default_comment_sort_type = SortType.Active,
            enable_private_messages = true,
            hide_media = false,
            default_post_time_range_seconds = null,
            default_items_per_page = 20,
            totp_2fa_enabled = d.totp_2fa_enabled,
        )

    override fun toUni(d: X11DatatypesLocalUserView): LemmyapiDatatypesLocalUserView =
        LemmyapiDatatypesLocalUserView(
            local_user = this.toUni(d = d.local_user, e = d.local_user_vote_display_mode),
            person = this.toUni(d = d.person, d.counts),
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,

        )

    override fun toUni(d: X11DatatypesLoginResponse): LemmyapiDatatypesLoginResponse =
        LemmyapiDatatypesLoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent,
        )

    override fun toUni(d: X11DatatypesLoginToken): LemmyapiDatatypesLoginToken =
        LemmyapiDatatypesLoginToken(
            user_id = d.user_id,
            published_at = d.published,
            ip = d.ip,
            user_agent = d.user_agent,
        )

    override fun toUni(d: X11DatatypesMyUserInfo): LemmyapiDatatypesMyUserInfo =
        LemmyapiDatatypesMyUserInfo(
            local_user_view = this.toUni(d = d.local_user_view),
            follows = d.follows.map { this.toUni(d = it) },
            moderates = d.moderates.map { this.toUni(d = it) },
            community_blocks = d.community_blocks.map { this.toUni(d = it.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)) },
            instance_communities_blocks = d.instance_blocks.map { this.toUni(d = it.instance) },
            instance_persons_blocks = emptyList(),
            person_blocks = d.person_blocks.map { this.toUni(d = it.target) },
            discussion_languages = d.discussion_languages,
            multi_community_follows = emptyList(),
        )

    fun toUni(d: X11DatatypesPerson) = this.toUni(d, X11DatatypesPersonAggregates(-1, -1, -1))

    override fun toUni(d: X11DatatypesPerson, counts: X11DatatypesPersonAggregates): LemmyapiDatatypesPerson = LemmyapiDatatypesPerson(
        id = d.id,
        name = d.name,
        display_name = d.display_name,
        avatar = d.avatar,
        published_at = d.published,
        updated_at = d.updated,
        ap_id = d.actor_id,
        bio = d.bio,
        local = d.local,
        banner = d.banner,
        deleted = d.deleted,
        matrix_user_id = d.matrix_user_id,
        bot_account = d.bot_account,
        instance_id = d.instance_id,
        post_count = counts.post_count,
        comment_count = counts.comment_count,
        last_refreshed_at = "",
    )

    override fun toUni(d: X11DatatypesPersonView): LemmyapiDatatypesPersonView =
        LemmyapiDatatypesPersonView(
            person = this.toUni(d = d.person, d.counts),
            is_admin = d.is_admin,
            person_actions = null,
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,
        )

    override fun toUni(d: X11DatatypesPost, counts: X11DatatypesPostAggregates): LemmyapiDatatypesPost = LemmyapiDatatypesPost(
        id = d.id,
        name = d.name,
        url = d.url,
        body = d.body,
        creator_id = d.creator_id,
        community_id = d.community_id,
        removed = d.removed,
        locked = d.locked,
        published_at = d.published,
        updated_at = d.updated,
        deleted = d.deleted,
        nsfw = d.nsfw,
        embed_title = d.embed_title,
        embed_description = d.embed_description,
        thumbnail_url = d.thumbnail_url,
        ap_id = d.ap_id,
        local = d.local,
        embed_video_url = d.embed_video_url,
        language_id = d.language_id,
        featured_community = d.featured_community,
        featured_local = d.featured_local,
        url_content_type = d.url_content_type,
        alt_text = d.alt_text,
        comments = counts.comments,
        score = counts.score,
        upvotes = counts.upvotes,
        downvotes = counts.downvotes,
        newest_comment_time_at = counts.newest_comment_time,
        report_count = -1,
        unresolved_report_count = -1,
        federation_pending = false,
    )

    override fun toUni(d: X11DatatypesPostReport): LemmyapiDatatypesPostReport =
        LemmyapiDatatypesPostReport(
            id = d.id,
            creator_id = d.creator_id,
            post_id = d.post_id,
            original_post_name = d.original_post_name,
            original_post_url = d.original_post_url,
            original_post_body = d.original_post_body,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published_at = d.published,
            updated_at = d.updated,
            violates_instance_rules = false,
        )

    override fun toUni(d: X11DatatypesPostReportResponse): LemmyapiDatatypesPostReportResponse =
        LemmyapiDatatypesPostReportResponse(
            post_report_view = this.toUni(d = d.post_report_view),
        )

    override fun toUni(d: X11DatatypesPostReportView): LemmyapiDatatypesPostReportView =
        LemmyapiDatatypesPostReportView(
            post_report = this.toUni(d = d.post_report),
            post = this.toUni(d = d.post, d.counts),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            post_creator = this.toUni(d = d.post_creator),
            resolver = d.resolver?.let { this.toUni(d = it) },
            post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, d.my_vote, toAt(d.hidden)),
            person_actions = PersonActions(toAt(d.creator_blocked)),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_banned = d.creator.banned,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
        )

    override fun toUni(d: X11DatatypesPostResponse): LemmyapiDatatypesPostResponse =
        LemmyapiDatatypesPostResponse(
            post_view = this.toUni(d = d.post_view),
        )

    override fun toUni(d: X11DatatypesPostView): LemmyapiDatatypesPostView =
        LemmyapiDatatypesPostView(
            post = this.toUni(d = d.post, d.counts),
            creator = this.toUni(d = d.creator),
            community = this.toUni(d = d.community, counts = X11DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            image_details = d.image_details?.let { this.toUni(d = it) },
            post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, d.my_vote, toAt(d.hidden)),
            person_actions = PersonActions(toAt(d.creator_blocked)),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
            tags = emptyList(),
            can_mod = false,
            creator_banned_from_community = d.creator_banned_from_community,
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
        )

    override fun toUni(d: X11DatatypesPrivateMessage): LemmyapiDatatypesPrivateMessage =
        LemmyapiDatatypesPrivateMessage(
            id = d.id,
            creator_id = d.creator_id,
            recipient_id = d.recipient_id,
            content = d.content,
            deleted = d.deleted,
            read = d.read,
            published_at = d.published,
            updated_at = d.updated,
            ap_id = d.ap_id,
            local = d.local,
            removed = false,
        )

    override fun toUni(d: X11DatatypesPrivateMessageReport): LemmyapiDatatypesPrivateMessageReport =
        LemmyapiDatatypesPrivateMessageReport(
            id = d.id,
            creator_id = d.creator_id,
            private_message_id = d.private_message_id,
            original_pm_text = d.original_pm_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X11DatatypesPrivateMessageReportResponse): LemmyapiDatatypesPrivateMessageReportResponse = LemmyapiDatatypesPrivateMessageReportResponse(
        private_message_report_view = this.toUni(d = d.private_message_report_view),
    )

    override fun toUni(d: X11DatatypesPrivateMessageReportView): LemmyapiDatatypesPrivateMessageReportView = LemmyapiDatatypesPrivateMessageReportView(
        private_message_report = this.toUni(d = d.private_message_report),
        private_message = this.toUni(d = d.private_message),
        private_message_creator = this.toUni(d = d.private_message_creator),
        creator = this.toUni(d = d.creator),
        resolver = d.resolver?.let { this.toUni(d = it) },
        creator_is_admin = false,
        creator_banned = d.creator.banned,
        creator_ban_expires_at = d.creator.ban_expires,
    )

    override fun toUni(d: X11DatatypesPrivateMessageResponse): LemmyapiDatatypesPrivateMessageResponse = LemmyapiDatatypesPrivateMessageResponse(
        private_message_view = this.toUni(d = d.private_message_view),
    )

    override fun toUni(d: X11DatatypesPrivateMessageView): LemmyapiDatatypesPrivateMessageView =
        LemmyapiDatatypesPrivateMessageView(
            private_message = this.toUni(d = d.private_message),
            creator = this.toUni(d = d.creator),
            recipient = this.toUni(d = d.recipient),
        )

    override fun toUni(d: X11DatatypesReadableFederationState): LemmyapiDatatypesReadableFederationState = LemmyapiDatatypesReadableFederationState(
        instance_id = d.instance_id,
        last_successful_id = d.last_successful_id,
        last_successful_published_time_at = d.last_successful_published_time,
        fail_count = d.fail_count,
        last_retry_at = d.last_retry,
    )

    override fun toUni(d: X11DatatypesRegistrationApplication): LemmyapiDatatypesRegistrationApplication = LemmyapiDatatypesRegistrationApplication(
        id = d.id,
        local_user_id = d.local_user_id,
        answer = d.answer,
        admin_id = d.admin_id,
        deny_reason = d.deny_reason,
        published_at = d.published,
    )

    override fun toUni(d: X11DatatypesRegistrationApplicationResponse): LemmyapiDatatypesRegistrationApplicationResponse =
        LemmyapiDatatypesRegistrationApplicationResponse(
            registration_application = this.toUni(d = d.registration_application),
        )

    override fun toUni(d: X11DatatypesRegistrationApplicationView): LemmyapiDatatypesRegistrationApplicationView = LemmyapiDatatypesRegistrationApplicationView(
        registration_application = this.toUni(d = d.registration_application),
        creator_local_user = this.toUni(d = d.creator_local_user, e = X11DatatypesLocalUserVoteDisplayMode(-1, true, true, true, true)),
        creator = this.toUni(d = d.creator),
        admin = d.admin?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X11DatatypesResolveObjectResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            resolve = when {
                d.post != null -> toUni(d.post)
                d.comment != null -> toUni(d.comment)
                d.community != null -> toUni(d.community)
                d.person != null -> toUni(d.person)
                else -> null
            },
            search = emptyList(),
        )

    override fun toUni(d: X11DatatypesSearchResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            search = buildList {
                addAll(d.comments.map(this@Transformer::toUni))
                addAll(d.posts.map(this@Transformer::toUni))
                addAll(d.communities.map(this@Transformer::toUni))
                addAll(d.users.map(this@Transformer::toUni))
            },
        )

    override fun toUni(d: X11DatatypesSite): LemmyapiDatatypesSite = LemmyapiDatatypesSite(
        id = d.id,
        name = d.name,
        sidebar = d.sidebar,
        published_at = d.published,
        updated_at = d.updated,
        icon = d.icon,
        banner = d.banner,
        summary = d.description,
        ap_id = d.actor_id,
        last_refreshed_at = d.last_refreshed_at,
        inbox_url = d.inbox_url,
        instance_id = d.instance_id,
        content_warning = d.content_warning,
    )

    override fun toUni(d: X11DatatypesSiteResponse): LemmyapiDatatypesSiteResponse =
        LemmyapiDatatypesSiteResponse(
            site_view = this.toUni(d = d.site_view),
        )

    override fun toUni(d: X11DatatypesSiteView): LemmyapiDatatypesSiteView =
        LemmyapiDatatypesSiteView(
            site = this.toUni(d = d.site),
            local_site = this.toUni(d = d.local_site, counts = d.counts),
            local_site_rate_limit = this.toUni(d = d.local_site_rate_limit),
            instance = null,
        )

    override fun toUni(d: X11DatatypesTagline): LemmyapiDatatypesTagline = LemmyapiDatatypesTagline(
        id = d.id,
        content = d.content,
        published_at = d.published,
        updated_at = d.updated,
    )

    override fun toUni(d: X11DatatypesUpdateTotpResponse): LemmyapiDatatypesUpdateTotpResponse =
        LemmyapiDatatypesUpdateTotpResponse(
            enabled = d.enabled,
        )

    override fun toUni(d: X11DatatypesVoteView): LemmyapiDatatypesVoteView =
        LemmyapiDatatypesVoteView(
            creator = this.toUni(d = d.creator),
            creator_banned = d.creator.banned,
            creator_banned_from_community = d.creator_banned_from_community,
            score = d.score,
        )

    override fun fromUni(d: LemmyapiDatatypesAddAdmin): X11DatatypesAddAdmin = X11DatatypesAddAdmin(
        person_id = d.person_id,
        added = d.added,
    )

    override fun fromUni(d: LemmyapiDatatypesAddModToCommunity): X11DatatypesAddModToCommunity =
        X11DatatypesAddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
        )

    override fun fromUni(d: LemmyapiDatatypesApproveRegistrationApplication): X11DatatypesApproveRegistrationApplication = X11DatatypesApproveRegistrationApplication(
        id = d.id,
        approve = d.approve,
        deny_reason = d.deny_reason,
    )

    override fun fromUni(d: LemmyapiDatatypesBanFromCommunity): X11DatatypesBanFromCommunity =
        X11DatatypesBanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_or_restore_data,
            reason = d.reason,
            expires = d.expires_at,
        )

    override fun fromUni(d: LemmyapiDatatypesBanPerson): X11DatatypesBanPerson =
        X11DatatypesBanPerson(
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_or_restore_data,
            reason = d.reason,
            expires = d.expires_at,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockCommunity): X11DatatypesBlockCommunity =
        X11DatatypesBlockCommunity(
            community_id = d.community_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockInstance): X11DatatypesBlockInstance =
        X11DatatypesBlockInstance(
            instance_id = d.instance_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockPerson): X11DatatypesBlockPerson =
        X11DatatypesBlockPerson(
            person_id = d.person_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesChangePassword): X11DatatypesChangePassword =
        X11DatatypesChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateComment): X11DatatypesCreateComment =
        X11DatatypesCreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentLike): X11DatatypesCreateCommentLike =
        X11DatatypesCreateCommentLike(
            comment_id = d.comment_id,
            score = d.score.toLong(),
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentReport): X11DatatypesCreateCommentReport =
        X11DatatypesCreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommunity): X11DatatypesCreateCommunity =
        X11DatatypesCreateCommunity(
            name = d.name,
            title = d.title,
            description = d.summary,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            visibility = V0CommunityVisibility.fromUniNullable(d.visibility),
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCustomEmoji): X11DatatypesCreateCustomEmoji =
        X11DatatypesCreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePost): X11DatatypesCreatePost =
        X11DatatypesCreatePost(
            name = d.name,
            community_id = d.community_id,
            url = d.url,
            body = d.body,
            alt_text = d.alt_text,
            honeypot = d.honeypot,
            nsfw = d.nsfw,
            language_id = d.language_id,
            custom_thumbnail = d.custom_thumbnail,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostLike): X11DatatypesCreatePostLike =
        X11DatatypesCreatePostLike(
            post_id = d.post_id,
            score = d.score.toLong(),
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostReport): X11DatatypesCreatePostReport =
        X11DatatypesCreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessage): X11DatatypesCreatePrivateMessage =
        X11DatatypesCreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessageReport): X11DatatypesCreatePrivateMessageReport = X11DatatypesCreatePrivateMessageReport(
        private_message_id = d.private_message_id,
        reason = d.reason,
    )

    override fun fromUni(d: LemmyapiDatatypesCreateSite): X11DatatypesCreateSite =
        X11DatatypesCreateSite(
            name = d.name,
            sidebar = d.sidebar,
            description = d.summary,
            icon = d.icon,
            banner = d.banner,
            enable_downvotes = when (d.post_downvotes) {
                FederationMode.Local, FederationMode.All -> true
                FederationMode.Disable -> false
                null -> null
            },
            enable_nsfw = if (d.disallow_nsfw_content == null) null else !d.disallow_nsfw_content,
            community_creation_admin_only = d.community_creation_admin_only,
            require_email_verification = d.require_email_verification,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = V0ListingType.fromUniNullable(d.default_post_listing_type),
            default_sort_type = V0SortType.fromUniNullable(d.default_post_sort_type),
            legal_information = d.legal_information,
            application_email_admins = d.application_email_admins,
            discussion_languages = d.discussion_languages,
            slur_filter_regex = d.slur_filter_regex,
            rate_limit_message = d.rate_limit_message_max_requests,
            rate_limit_message_per_second = d.rate_limit_message_interval_seconds,
            rate_limit_post = d.rate_limit_post_max_requests,
            rate_limit_post_per_second = d.rate_limit_post_interval_seconds,
            rate_limit_register = d.rate_limit_register_max_requests,
            rate_limit_register_per_second = d.rate_limit_register_interval_seconds,
            rate_limit_image = d.rate_limit_image_max_requests,
            rate_limit_image_per_second = d.rate_limit_image_interval_seconds,
            rate_limit_comment = d.rate_limit_comment_max_requests,
            rate_limit_comment_per_second = d.rate_limit_comment_interval_seconds,
            rate_limit_search = d.rate_limit_search_max_requests,
            rate_limit_search_per_second = d.rate_limit_search_interval_seconds,
            federation_enabled = d.federation_enabled,
            captcha_enabled = d.captcha_enabled,
            captcha_difficulty = d.captcha_difficulty,
            allowed_instances = d.allowed_instances,
            blocked_instances = d.blocked_instances,
            taglines = d.taglines,
            registration_mode = V0RegistrationMode.fromUniNullable(d.registration_mode),
            content_warning = d.content_warning,
            default_post_listing_mode = V0PostListingMode.fromUniNullable(d.default_post_listing_mode),
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteAccount): X11DatatypesDeleteAccount =
        X11DatatypesDeleteAccount(
            password = d.password,
            delete_content = d.delete_content,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteComment): X11DatatypesDeleteComment =
        X11DatatypesDeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCommunity): X11DatatypesDeleteCommunity =
        X11DatatypesDeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCustomEmoji): X11DatatypesDeleteCustomEmoji =
        X11DatatypesDeleteCustomEmoji(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePost): X11DatatypesDeletePost =
        X11DatatypesDeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePrivateMessage): X11DatatypesDeletePrivateMessage =
        X11DatatypesDeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDistinguishComment): X11DatatypesDistinguishComment =
        X11DatatypesDistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
        )

    override fun fromUni(d: LemmyapiDatatypesEditComment): X11DatatypesEditComment =
        X11DatatypesEditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCommunity): X11DatatypesEditCommunity =
        X11DatatypesEditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.summary,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            visibility = V0CommunityVisibility.fromUniNullable(d.visibility),
        )

    override fun fromUni(d: LemmyapiDatatypesEditCustomEmoji): X11DatatypesEditCustomEmoji =
        X11DatatypesEditCustomEmoji(
            id = d.id,
            category = d.category ?: "",
            image_url = d.image_url ?: "",
            alt_text = d.alt_text ?: "",
            keywords = d.keywords ?: emptyList(),
        )

    override fun fromUni(d: LemmyapiDatatypesEditPost): X11DatatypesEditPost = X11DatatypesEditPost(
        post_id = d.post_id,
        name = d.name,
        url = d.url,
        body = d.body,
        alt_text = d.alt_text,
        nsfw = d.nsfw,
        language_id = d.language_id,
        custom_thumbnail = d.custom_thumbnail,
    )

    override fun fromUni(d: LemmyapiDatatypesEditPrivateMessage): X11DatatypesEditPrivateMessage =
        X11DatatypesEditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
        )

    override fun fromUni(d: LemmyapiDatatypesEditSite): X11DatatypesEditSite = X11DatatypesEditSite(
        name = d.name,
        sidebar = d.sidebar,
        description = d.summary,
        icon = d.icon,
        banner = d.banner,
        enable_downvotes = d.enable_downvotes,
        enable_nsfw = d.enable_nsfw,
        community_creation_admin_only = d.community_creation_admin_only,
        require_email_verification = d.require_email_verification,
        application_question = d.application_question,
        private_instance = d.private_instance,
        default_theme = d.default_theme,
        default_post_listing_type = V0ListingType.fromUniNullable(d.default_post_listing_type),
        default_sort_type = V0SortType.fromUniNullable(d.default_post_sort_type),
        legal_information = d.legal_information,
        application_email_admins = d.application_email_admins,
        hide_modlog_mod_names = d.hide_modlog_mod_names,
        discussion_languages = d.discussion_languages,
        slur_filter_regex = d.slur_filter_regex,
        rate_limit_message = d.rate_limit_message_max_requests,
        rate_limit_message_per_second = d.rate_limit_message_interval_seconds,
        rate_limit_post = d.rate_limit_post_max_requests,
        rate_limit_post_per_second = d.rate_limit_post_interval_seconds,
        rate_limit_register = d.rate_limit_register_max_requests,
        rate_limit_register_per_second = d.rate_limit_register_interval_seconds,
        rate_limit_image = d.rate_limit_image_max_requests,
        rate_limit_image_per_second = d.rate_limit_image_interval_seconds,
        rate_limit_comment = d.rate_limit_comment_max_requests,
        rate_limit_comment_per_second = d.rate_limit_comment_interval_seconds,
        rate_limit_search = d.rate_limit_search_max_requests,
        rate_limit_search_per_second = d.rate_limit_search_interval_seconds,
        federation_enabled = d.federation_enabled,
        federation_debug = d.federation_debug,
        captcha_enabled = d.captcha_enabled,
        captcha_difficulty = d.captcha_difficulty,
        allowed_instances = d.allowed_instances,
        blocked_instances = d.blocked_instances,
        blocked_urls = d.blocked_urls,
        taglines = d.taglines,
        registration_mode = V0RegistrationMode.fromUniNullable(d.registration_mode),
        reports_email_admins = d.reports_email_admins,
        content_warning = d.content_warning,
        default_post_listing_mode = V0PostListingMode.fromUniNullable(d.default_post_listing_mode),
    )

    override fun fromUni(d: LemmyapiDatatypesFeaturePost): X11DatatypesFeaturePost =
        X11DatatypesFeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = V0PostFeatureType.fromUni(d.feature_type),
        )

    override fun fromUni(d: LemmyapiDatatypesFollowCommunity): X11DatatypesFollowCommunity =
        X11DatatypesFollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComment): X11DatatypesGetComment =
        X11DatatypesGetComment(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComments): X11DatatypesGetComments =
        X11DatatypesGetComments(
            type_ = V0ListingType.fromUniNullable(d.type_),
            sort = V0CommentSortType.fromUniNullable(d.sort),
            max_depth = d.max_depth,
            page = d.page,
            limit = d.limit,
            community_id = d.community_id,
            community_name = d.community_name,
            post_id = d.post_id,
            parent_id = d.parent_id,
            saved_only = d.saved_only,
            liked_only = d.liked_only,
            disliked_only = d.disliked_only,
        )

    override fun fromUni(d: LemmyapiDatatypesGetCommunity): X11DatatypesGetCommunity =
        X11DatatypesGetCommunity(
            id = d.id,
            name = d.name,
        )

    override fun fromUni(d: LemmyapiDatatypesGetModlog): X11DatatypesGetModlog =
        X11DatatypesGetModlog(
            mod_person_id = d.mod_person_id,
            community_id = d.community_id,
            page = d.page,
            limit = d.limit,
            type_ = V0ModlogActionType.fromUniNullable(d.type_),
            other_person_id = d.other_person_id,
            post_id = d.post_id,
            comment_id = d.comment_id,
        )

    override fun fromUni(d: LemmyapiDatatypesGetPersonDetails): X11DatatypesGetPersonDetails =
        X11DatatypesGetPersonDetails(
            person_id = d.person_id,
            username = d.username,
        )

    override fun fromUni(d: LemmyapiDatatypesGetPost): X11DatatypesGetPost = X11DatatypesGetPost(
        id = d.id,
        comment_id = d.comment_id,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPosts): X11DatatypesGetPosts = X11DatatypesGetPosts(
        type_ = V0ListingType.fromUniNullable(d.type_),
        sort = V0SortType.fromUniNullable(d.sort),
        page = d.page,
        limit = d.limit,
        community_id = d.community_id,
        community_name = d.community_name,
        show_hidden = d.show_hidden,
        show_read = d.show_read,
        show_nsfw = d.show_nsfw,
        page_cursor = d.page_cursor,
    )

    fun fromUniR(d: LemmyapiDatatypesListNotifications): X11DatatypesGetReplies =
        X11DatatypesGetReplies(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniM(d: LemmyapiDatatypesListNotifications): X11DatatypesGetPersonMentions =
        X11DatatypesGetPersonMentions(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniP(d: LemmyapiDatatypesListNotifications): X11DatatypesGetPrivateMessages =
        X11DatatypesGetPrivateMessages(
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    override fun fromUni(d: LemmyapiDatatypesGetRegistrationApplication): X11DatatypesGetRegistrationApplication = X11DatatypesGetRegistrationApplication(
        person_id = d.person_id,
    )



    override fun fromUni(d: LemmyapiDatatypesGetSiteMetadata): X11DatatypesGetSiteMetadata =
        X11DatatypesGetSiteMetadata(
            url = d.url,
        )

    override fun fromUni(d: LemmyapiDatatypesHideCommunity): X11DatatypesHideCommunity =
        X11DatatypesHideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesHidePost): X11DatatypesHidePost = X11DatatypesHidePost(
        post_ids = d.post_ids,
        hide = d.hide,
    )

    // Unified ListReports helpers (for combined ListReports support)
    override fun fromUniC(d: it.vercruysse.lemmyapi.datatypes.ListReports): X11DatatypesListCommentReports =
        X11DatatypesListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
        )

    override fun fromUniP(d: it.vercruysse.lemmyapi.datatypes.ListReports): X11DatatypesListPostReports =
        X11DatatypesListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            post_id = d.post_id,
        )

    override fun fromUniPm(d: it.vercruysse.lemmyapi.datatypes.ListReports): X11DatatypesListPrivateMessageReports =
        X11DatatypesListPrivateMessageReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
        )

    override fun fromUni(d: LemmyapiDatatypesListCommentLikes): X11DatatypesListCommentLikes =
        X11DatatypesListCommentLikes(
            comment_id = d.comment_id,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListCommunities): X11DatatypesListCommunities =
        X11DatatypesListCommunities(
            type_ = V0ListingType.fromUniNullable(d.type_),
            sort = V0SortType.fromUniNullable(d.sort),
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListMedia): X11DatatypesListMedia =
        X11DatatypesListMedia(
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListPostLikes): X11DatatypesListPostLikes =
        X11DatatypesListPostLikes(
            post_id = d.post_id,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListRegistrationApplications): X11DatatypesListRegistrationApplications = X11DatatypesListRegistrationApplications(
        unread_only = d.unread_only,
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesLockPost): X11DatatypesLockPost = X11DatatypesLockPost(
        post_id = d.post_id,
        locked = d.locked,
    )

    override fun fromUni(d: LemmyapiDatatypesLogin): X11DatatypesLogin = X11DatatypesLogin(
        username_or_email = d.username_or_email,
        password = d.password,
        totp_2fa_token = d.totp_2fa_token,
    )

    fun fromUniR(d: MarkNotificationAsRead): X11DatatypesMarkCommentReplyAsRead = X11DatatypesMarkCommentReplyAsRead(
        comment_reply_id = d.notification_id,
        read = d.read,
    )

    fun fromUniM(d: MarkNotificationAsRead): X11DatatypesMarkPersonMentionAsRead = X11DatatypesMarkPersonMentionAsRead(
        person_mention_id = d.notification_id,
        read = d.read,
    )

    fun fromUniP(d: MarkNotificationAsRead): X11DatatypesMarkPrivateMessageAsRead = X11DatatypesMarkPrivateMessageAsRead(
        private_message_id = d.notification_id,
        read = d.read,
    )

    override fun fromUni(d: LemmyapiDatatypesMarkPostAsRead): X11DatatypesMarkPostAsRead =
        X11DatatypesMarkPostAsRead(
            post_ids = d.post_ids,
            read = d.read,
        )

    override fun fromUni(d: LemmyapiDatatypesPasswordChangeAfterReset): X11DatatypesPasswordChangeAfterReset = X11DatatypesPasswordChangeAfterReset(
        token = d.token,
        password = d.password,
        password_verify = d.password_verify,
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordReset): X11DatatypesPasswordReset =
        X11DatatypesPasswordReset(
            email = d.email,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeComment): X11DatatypesPurgeComment =
        X11DatatypesPurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeCommunity): X11DatatypesPurgeCommunity =
        X11DatatypesPurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePerson): X11DatatypesPurgePerson =
        X11DatatypesPurgePerson(
            person_id = d.person_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePost): X11DatatypesPurgePost =
        X11DatatypesPurgePost(
            post_id = d.post_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRegister): X11DatatypesRegister = X11DatatypesRegister(
        username = d.username,
        password = d.password,
        password_verify = d.password_verify,
        show_nsfw = d.show_nsfw,
        email = d.email,
        captcha_uuid = d.captcha_uuid,
        captcha_answer = d.captcha_answer,
        honeypot = d.honeypot,
        answer = d.answer,
    )

    override fun fromUni(d: LemmyapiDatatypesRemoveComment): X11DatatypesRemoveComment =
        X11DatatypesRemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemoveCommunity): X11DatatypesRemoveCommunity =
        X11DatatypesRemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemovePost): X11DatatypesRemovePost =
        X11DatatypesRemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveCommentReport): X11DatatypesResolveCommentReport =
        X11DatatypesResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveObject): X11DatatypesResolveObject =
        X11DatatypesResolveObject(
            q = d.q,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePostReport): X11DatatypesResolvePostReport =
        X11DatatypesResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePrivateMessageReport): X11DatatypesResolvePrivateMessageReport = X11DatatypesResolvePrivateMessageReport(
        report_id = d.report_id,
        resolved = d.resolved,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveComment): X11DatatypesSaveComment =
        X11DatatypesSaveComment(
            comment_id = d.comment_id,
            save = d.save,
        )

    override fun fromUni(d: LemmyapiDatatypesSavePost): X11DatatypesSavePost = X11DatatypesSavePost(
        post_id = d.post_id,
        save = d.save,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveUserSettings): X11DatatypesSaveUserSettings =
        X11DatatypesSaveUserSettings(
            show_nsfw = d.show_nsfw,
            blur_nsfw = d.blur_nsfw,
            theme = d.theme,
            default_sort_type = V0SortType.fromUniNullable(d.default_post_sort_type),
            default_listing_type = V0ListingType.fromUniNullable(d.default_listing_type),
            interface_language = d.interface_language,
            avatar = d.avatar,
            banner = d.banner,
            display_name = d.display_name,
            email = d.email,
            bio = d.bio,
            matrix_user_id = d.matrix_user_id,
            show_avatars = d.show_avatars,
            send_notifications_to_email = d.send_notifications_to_email,
            bot_account = d.bot_account,
            show_bot_accounts = d.show_bot_accounts,
            show_read_posts = d.show_read_posts,
            discussion_languages = d.discussion_languages,
            open_links_in_new_tab = d.open_links_in_new_tab,
            infinite_scroll_enabled = d.infinite_scroll_enabled,
            post_listing_mode = V0PostListingMode.fromUniNullable(d.post_listing_mode),
            enable_animated_images = d.enable_animated_images,
            collapse_bot_comments = d.collapse_bot_comments,
            show_scores = d.show_score,
            show_upvotes = d.show_upvotes,
            show_downvotes = when (d.show_downvotes) {
                VoteShow.ShowForOthers, VoteShow.Show -> true
                VoteShow.Hide -> false
                null -> null
            },
            show_upvote_percentage = d.show_upvote_percentage,
        )

    override fun fromUni(d: LemmyapiDatatypesSearch): X11DatatypesSearch = X11DatatypesSearch(
        q = d.q,
        community_id = d.community_id,
        community_name = d.community_name,
        creator_id = d.creator_id,
        type_ = V0SearchType.fromUniNullable(d.type_),
        sort = V0SortType.fromUniNullable(d.sort),
        listing_type = V0ListingType.fromUniNullable(d.listing_type),
        page = d.page,
        limit = d.limit,
        post_title_only = d.title_only,
    )

    override fun fromUni(d: LemmyapiDatatypesTransferCommunity): X11DatatypesTransferCommunity =
        X11DatatypesTransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
        )

    override fun fromUni(d: LemmyapiDatatypesUpdateTotp): X11DatatypesUpdateTotp =
        X11DatatypesUpdateTotp(
            totp_token = d.totp_token,
            enabled = d.enabled,
        )

    override fun fromUni(d: LemmyapiDatatypesVerifyEmail): X11DatatypesVerifyEmail =
        X11DatatypesVerifyEmail(
            token = d.token,
        )
}
