package it.vercruysse.lemmyapi.v0.x19.x0

import it.vercruysse.lemmyapi.datatypes.CommentActions
import it.vercruysse.lemmyapi.datatypes.CommunityActions
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.Notification
import it.vercruysse.lemmyapi.datatypes.NotificationView
import it.vercruysse.lemmyapi.datatypes.PersonActions
import it.vercruysse.lemmyapi.datatypes.PostActions
import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.ImageMode
import it.vercruysse.lemmyapi.enums.NotificationType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteAction
import it.vercruysse.lemmyapi.enums.VoteShow
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
import it.vercruysse.lemmyapi.datatypes.ChangePasswordAfterReset as LemmyapiDatatypesPasswordChangeAfterReset
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
import it.vercruysse.lemmyapi.datatypes.EditTotp as LemmyapiDatatypesUpdateTotp
import it.vercruysse.lemmyapi.datatypes.EditTotpResponse as LemmyapiDatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.datatypes.FeaturePost as LemmyapiDatatypesFeaturePost
import it.vercruysse.lemmyapi.datatypes.FederationQueueState as LemmyapiDatatypesReadableFederationState
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
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadata as LemmyapiDatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse as LemmyapiDatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.datatypes.GetSiteResponse as LemmyapiDatatypesGetSiteResponse
import it.vercruysse.lemmyapi.datatypes.HideCommunity as LemmyapiDatatypesHideCommunity
import it.vercruysse.lemmyapi.datatypes.Instance as LemmyapiDatatypesInstance
import it.vercruysse.lemmyapi.datatypes.Language as LemmyapiDatatypesLanguage
import it.vercruysse.lemmyapi.datatypes.ListCommunities as LemmyapiDatatypesListCommunities
import it.vercruysse.lemmyapi.datatypes.ListNotifications as LemmyapiDatatypesListNotifications
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications as LemmyapiDatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.LocalSite as LemmyapiDatatypesLocalSite
import it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit as LemmyapiDatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.datatypes.LocalUser as LemmyapiDatatypesLocalUser
import it.vercruysse.lemmyapi.datatypes.LocalUserView as LemmyapiDatatypesLocalUserView
import it.vercruysse.lemmyapi.datatypes.LockPost as LemmyapiDatatypesLockPost
import it.vercruysse.lemmyapi.datatypes.Login as LemmyapiDatatypesLogin
import it.vercruysse.lemmyapi.datatypes.LoginResponse as LemmyapiDatatypesLoginResponse
import it.vercruysse.lemmyapi.datatypes.LoginToken as LemmyapiDatatypesLoginToken
import it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead as LemmyapiDatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.datatypes.MyUserInfo as LemmyapiDatatypesMyUserInfo
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
import it.vercruysse.lemmyapi.datatypes.Register as LemmyapiDatatypesRegister
import it.vercruysse.lemmyapi.datatypes.RegistrationApplication as LemmyapiDatatypesRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse as LemmyapiDatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView as LemmyapiDatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.datatypes.RemoveComment as LemmyapiDatatypesRemoveComment
import it.vercruysse.lemmyapi.datatypes.RemoveCommunity as LemmyapiDatatypesRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.RemovePost as LemmyapiDatatypesRemovePost
import it.vercruysse.lemmyapi.datatypes.ResetPassword as LemmyapiDatatypesPasswordReset
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
import it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams as LemmyapiDatatypesBlockInstance
import it.vercruysse.lemmyapi.datatypes.VerifyEmail as LemmyapiDatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0.enums.CommentSortType as V0CommentSortType
import it.vercruysse.lemmyapi.v0.enums.ListingType as V0ListingType
import it.vercruysse.lemmyapi.v0.enums.ModlogActionType as V0ModlogActionType
import it.vercruysse.lemmyapi.v0.enums.PostFeatureType as V0PostFeatureType
import it.vercruysse.lemmyapi.v0.enums.PostListingMode as V0PostListingMode
import it.vercruysse.lemmyapi.v0.enums.RegistrationMode as V0RegistrationMode
import it.vercruysse.lemmyapi.v0.enums.SearchType as V0SearchType
import it.vercruysse.lemmyapi.v0.enums.SortType as V0SortType
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.AddAdmin as X0DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.AddAdminResponse as X0DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.AddModToCommunity as X0DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.AddModToCommunityResponse as X0DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ApproveRegistrationApplication as X0DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BanFromCommunity as X0DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BanFromCommunityResponse as X0DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BanPerson as X0DatatypesBanPerson
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BanPersonResponse as X0DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BlockCommunity as X0DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BlockCommunityResponse as X0DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BlockInstance as X0DatatypesBlockInstance
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BlockPerson as X0DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.BlockPersonResponse as X0DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CaptchaResponse as X0DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ChangePassword as X0DatatypesChangePassword
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Comment as X0DatatypesComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentAggregates as X0DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentReplyView as X0DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentReport as X0DatatypesCommentReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentReportResponse as X0DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentReportView as X0DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentResponse as X0DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommentView as X0DatatypesCommentView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Community as X0DatatypesCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityAggregates as X0DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityFollowerView as X0DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityModeratorView as X0DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityResponse as X0DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CommunityView as X0DatatypesCommunityView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateComment as X0DatatypesCreateComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateCommentLike as X0DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateCommentReport as X0DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateCommunity as X0DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateCustomEmoji as X0DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreatePost as X0DatatypesCreatePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreatePostLike as X0DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreatePostReport as X0DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreatePrivateMessage as X0DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreatePrivateMessageReport as X0DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CreateSite as X0DatatypesCreateSite
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CustomEmoji as X0DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CustomEmojiKeyword as X0DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CustomEmojiResponse as X0DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.CustomEmojiView as X0DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeleteAccount as X0DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeleteComment as X0DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeleteCommunity as X0DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeleteCustomEmoji as X0DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeletePost as X0DatatypesDeletePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DeletePrivateMessage as X0DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.DistinguishComment as X0DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditComment as X0DatatypesEditComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditCommunity as X0DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditCustomEmoji as X0DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditPost as X0DatatypesEditPost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditPrivateMessage as X0DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.EditSite as X0DatatypesEditSite
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.FeaturePost as X0DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.FollowCommunity as X0DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GenerateTotpSecretResponse as X0DatatypesGenerateTotpSecretResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetCaptchaResponse as X0DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetComment as X0DatatypesGetComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetComments as X0DatatypesGetComments
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetCommunity as X0DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetCommunityResponse as X0DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetModlog as X0DatatypesGetModlog
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPersonDetails as X0DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPersonDetailsResponse as X0DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPersonMentions as X0DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPost as X0DatatypesGetPost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPostResponse as X0DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPosts as X0DatatypesGetPosts
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetPrivateMessages as X0DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetReplies as X0DatatypesGetReplies
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteMetadata as X0DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteMetadataResponse as X0DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.GetSiteResponse as X0DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.HideCommunity as X0DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Instance as X0DatatypesInstance
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Language as X0DatatypesLanguage
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListCommentReports as X0DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListCommunities as X0DatatypesListCommunities
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListPostReports as X0DatatypesListPostReports
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListPrivateMessageReports as X0DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ListRegistrationApplications as X0DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LocalSite as X0DatatypesLocalSite
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LocalSiteRateLimit as X0DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LocalUser as X0DatatypesLocalUser
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LocalUserView as X0DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LockPost as X0DatatypesLockPost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Login as X0DatatypesLogin
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LoginResponse as X0DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.LoginToken as X0DatatypesLoginToken
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.MarkCommentReplyAsRead as X0DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.MarkPersonMentionAsRead as X0DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.MarkPostAsRead as X0DatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.MarkPrivateMessageAsRead as X0DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.MyUserInfo as X0DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PasswordChangeAfterReset as X0DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PasswordReset as X0DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Person as X0DatatypesPerson
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PersonAggregates as X0DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PersonMentionView as X0DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PersonView as X0DatatypesPersonView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Post as X0DatatypesPost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostAggregates as X0DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostReport as X0DatatypesPostReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostReportResponse as X0DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostReportView as X0DatatypesPostReportView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostResponse as X0DatatypesPostResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PostView as X0DatatypesPostView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessage as X0DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessageReport as X0DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessageReportResponse as X0DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessageReportView as X0DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessageResponse as X0DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PrivateMessageView as X0DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PurgeComment as X0DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PurgeCommunity as X0DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PurgePerson as X0DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.PurgePost as X0DatatypesPurgePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ReadableFederationState as X0DatatypesReadableFederationState
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Register as X0DatatypesRegister
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RegistrationApplication as X0DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RegistrationApplicationResponse as X0DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RegistrationApplicationView as X0DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RemoveComment as X0DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RemoveCommunity as X0DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.RemovePost as X0DatatypesRemovePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolveCommentReport as X0DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolveObject as X0DatatypesResolveObject
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolveObjectResponse as X0DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolvePostReport as X0DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.ResolvePrivateMessageReport as X0DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SaveComment as X0DatatypesSaveComment
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SavePost as X0DatatypesSavePost
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SaveUserSettings as X0DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Search as X0DatatypesSearch
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SearchResponse as X0DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Site as X0DatatypesSite
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SiteAggregates as X0DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SiteResponse as X0DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.SiteView as X0DatatypesSiteView
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.Tagline as X0DatatypesTagline
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.TransferCommunity as X0DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.UpdateTotp as X0DatatypesUpdateTotp
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.UpdateTotpResponse as X0DatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.v0.x19.x0.datatypes.VerifyEmail as X0DatatypesVerifyEmail

// Based on tags/0.19.0
internal class Transformer : MapperGenerator {
    override fun toUni(d: X0DatatypesCommentReportView): LemmyapiDatatypesCommentReportView =
        LemmyapiDatatypesCommentReportView(
            comment_report = this.toUni(d = d.comment_report),
            comment = this.toUni(d = d.comment, d.counts),
            post = this.toUni(d = d.post, counts = X0DatatypesPostAggregates(-1, -1, -1, -1, -1, "")),
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            comment_creator = this.toUni(d = d.comment_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            creator_banned = d.creator.banned,
            resolver = d.resolver?.let { this.toUni(d = it) },
            comment_actions = CommentActions(VoteAction.from(d.my_vote), null, null),
        )

    override fun toUni(d: X0DatatypesCommentView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X0DatatypesPostAggregates(-1, -1, -1, -1, -1, "")),
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = d.creator_is_admin,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(VoteAction.from(d.my_vote), null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X0DatatypesCommunity, counts: X0DatatypesCommunityAggregates): LemmyapiDatatypesCommunity =
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
            visibility = if (d.hidden) CommunityVisibility.Unlisted else CommunityVisibility.Public,
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

    override fun toUni(d: X0DatatypesCommunityView): LemmyapiDatatypesCommunityView =
        LemmyapiDatatypesCommunityView(
            community = this.toUni(d = d.community, d.counts),
            can_mod = false,
            tags = emptyList(),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed), if (d.blocked) "" else null),
        )

    override fun toUni(d: X0DatatypesGetSiteResponse): LemmyapiDatatypesGetSiteResponse =
        LemmyapiDatatypesGetSiteResponse(
            site_view = this.toUni(d = d.site_view),
            admins = d.admins.map { this.toUni(d = it) },
            version = d.version,
            all_languages = d.all_languages.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
            blocked_urls = emptyList(),
            tagline = if (d.taglines.isEmpty()) null else this.toUni(d = d.taglines.random()),
            oauth_providers = emptyList(),
            admin_oauth_providers = emptyList(),
            active_plugins = emptyList(),
            captcha_enabled = false,
        )

    override fun toUni(d: X0DatatypesLocalSite, counts: X0DatatypesSiteAggregates): LemmyapiDatatypesLocalSite =
        LemmyapiDatatypesLocalSite(
            id = d.id,
            site_id = d.site_id,
            site_setup = d.site_setup,
            community_creation_admin_only = d.community_creation_admin_only,
            email_verification_required = d.require_email_verification,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = d.default_post_listing_type.toUni(),
            legal_information = d.legal_information,
            application_email_admins = d.application_email_admins,
            slur_filter_regex = d.slur_filter_regex,
            federation_enabled = d.federation_enabled,
            published_at = d.published,
            updated_at = d.updated,
            registration_mode = d.registration_mode.toUni(),
            reports_email_admins = d.reports_email_admins,
            federation_signed_fetch = d.federation_signed_fetch,
            default_post_listing_mode = PostListingMode.Card,
            default_post_sort_type = SortType.Active,
            nsfw_content_disallowed = !d.enable_nsfw,
            oauth_registration = false,
            email_notifications_disabled = false,
            suggested_multi_community_id = null,
            default_comment_sort_type = CommentSortType.Hot,
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
            image_mode = ImageMode.StoreLinkPreviews,
            image_upload_timeout_seconds = 0,
            image_max_thumbnail_size = 0,
            image_max_avatar_size = 0,
            image_max_banner_size = 0,
            image_max_upload_size = 0,
            image_allow_video_uploads = false,
            image_upload_disabled = false,
            max_invites_per_user_allowed = 0,
        )

    override fun toUni(d: X0DatatypesPostReportView): LemmyapiDatatypesPostReportView =
        LemmyapiDatatypesPostReportView(
            post_report = this.toUni(d = d.post_report),
            post = this.toUni(d = d.post, d.counts),
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            post_creator = this.toUni(d = d.post_creator),
            resolver = d.resolver?.let { this.toUni(d = it) },
            post_actions = PostActions(vote = VoteAction.from(d.my_vote)),
            person_actions = null,
            community_actions = null,
            creator_banned_from_community = d.creator_banned_from_community,
            creator_banned = d.creator.banned,
            creator_is_moderator = false,
            creator_is_admin = false,

        )

    override fun toUni(d: X0DatatypesPostView): LemmyapiDatatypesPostView = LemmyapiDatatypesPostView(
        post = this.toUni(d = d.post, d.counts),
        creator = this.toUni(d = d.creator),
        community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
        post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, VoteAction.from(d.my_vote), null),
        person_actions = PersonActions(toAt(d.creator_blocked)),
        community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        tags = emptyList(),
        can_mod = false,
        creator_banned_from_community = d.creator_banned_from_community,
        creator_banned = d.creator.banned,
        creator_ban_expires_at = d.creator.ban_expires,
        creator_is_admin = d.creator_is_admin,
        creator_is_moderator = d.creator_is_moderator,
    )

    override fun toUni(d: X0DatatypesAddAdminResponse): LemmyapiDatatypesAddAdminResponse =
        LemmyapiDatatypesAddAdminResponse(
            admins = d.admins.map { this.toUni(d = it) },
        )

    override fun toUni(d: X0DatatypesAddModToCommunityResponse): LemmyapiDatatypesAddModToCommunityResponse = LemmyapiDatatypesAddModToCommunityResponse(
        moderators = d.moderators.map { this.toUni(d = it) },
    )

    override fun toUni(d: X0DatatypesBanFromCommunityResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X0DatatypesBanPersonResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X0DatatypesBlockCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(community_view = this.toUni(d = d.community_view), discussion_languages = emptyList())

    override fun toUni(d: X0DatatypesBlockPersonResponse): it.vercruysse.lemmyapi.datatypes.PersonResponse =
        it.vercruysse.lemmyapi.datatypes.PersonResponse(person_view = this.toUni(d = d.person_view))

    override fun toUni(d: X0DatatypesCaptchaResponse): LemmyapiDatatypesCaptchaResponse =
        LemmyapiDatatypesCaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid,
        )

    override fun toUni(d: X0DatatypesComment, counts: X0DatatypesCommentAggregates): LemmyapiDatatypesComment = LemmyapiDatatypesComment(
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

    override fun toUni(d: X0DatatypesCommentReport): LemmyapiDatatypesCommentReport =
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

    override fun toUni(d: X0DatatypesCommentReportResponse): LemmyapiDatatypesCommentReportResponse =
        LemmyapiDatatypesCommentReportResponse(
            comment_report_view = this.toUni(d = d.comment_report_view),
        )

    override fun toUni(d: X0DatatypesCommentResponse): LemmyapiDatatypesCommentResponse =
        LemmyapiDatatypesCommentResponse(
            comment_view = this.toUni(d = d.comment_view),
        )

    override fun toUni(d: X0DatatypesCommunityFollowerView): LemmyapiDatatypesCommunityFollowerView =
        LemmyapiDatatypesCommunityFollowerView(
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            follower = this.toUni(d = d.follower),
        )

    override fun toUni(d: X0DatatypesCommunityModeratorView): LemmyapiDatatypesCommunityModeratorView = LemmyapiDatatypesCommunityModeratorView(
        community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
        moderator = this.toUni(d = d.moderator),
    )

    override fun toUni(d: X0DatatypesCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X0DatatypesCustomEmoji): LemmyapiDatatypesCustomEmoji =
        LemmyapiDatatypesCustomEmoji(
            id = d.id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X0DatatypesCustomEmojiKeyword): LemmyapiDatatypesCustomEmojiKeyword =
        LemmyapiDatatypesCustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword,
        )

    override fun toUni(d: X0DatatypesCustomEmojiResponse): LemmyapiDatatypesCustomEmojiResponse =
        LemmyapiDatatypesCustomEmojiResponse(
            custom_emoji = this.toUni(d = d.custom_emoji),
        )

    override fun toUni(d: X0DatatypesCustomEmojiView): LemmyapiDatatypesCustomEmojiView =
        LemmyapiDatatypesCustomEmojiView(
            custom_emoji = this.toUni(d = d.custom_emoji),
            keywords = d.keywords.map { this.toUni(d = it) },
        )

    override fun toUni(d: X0DatatypesGenerateTotpSecretResponse): LemmyapiDatatypesGenerateTotpSecretResponse = LemmyapiDatatypesGenerateTotpSecretResponse(
        totp_secret_url = d.totp_secret_url,
    )

    override fun toUni(d: X0DatatypesGetCaptchaResponse): LemmyapiDatatypesGetCaptchaResponse =
        LemmyapiDatatypesGetCaptchaResponse(
            ok = d.ok?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X0DatatypesGetCommunityResponse): LemmyapiDatatypesGetCommunityResponse =
        LemmyapiDatatypesGetCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            site = d.site?.let { this.toUni(d = it) },
            moderators = d.moderators.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X0DatatypesGetPersonDetailsResponse): LemmyapiDatatypesGetPersonDetailsResponse = LemmyapiDatatypesGetPersonDetailsResponse(
        person_view = this.toUni(d = d.person_view),
        moderates = d.moderates.map { this.toUni(d = it) },
        multi_communities_created = emptyList(),
    )

    override fun toUni(d: X0DatatypesGetPostResponse): LemmyapiDatatypesGetPostResponse =
        LemmyapiDatatypesGetPostResponse(
            post_view = this.toUni(d = d.post_view),
            community_view = this.toUni(d = d.community_view),
            moderators = d.moderators.map { this.toUni(d = it) },
            cross_posts = d.cross_posts.map { this.toUni(d = it) },
        )

    fun toUni(d: X0DatatypesCommentReplyView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.comment_reply.id,
                recipient_id = d.comment_reply.recipient_id,
                comment_id = d.comment_reply.comment_id,
                read = d.comment_reply.read,
                published_at = d.comment_reply.published,
                kind = NotificationType.Reply,
                post_id = d.post.id,
                creator_id = d.creator.id,
            ),
            data = this.toUniCV(d),
        )

    fun toUniCV(d: X0DatatypesCommentReplyView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X0DatatypesPostAggregates(-1, -1, -1, -1, -1, "")),
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(VoteAction.from(d.my_vote), null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUni(d: X0DatatypesPersonMentionView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.person_mention.id,
                recipient_id = d.person_mention.recipient_id,
                comment_id = d.person_mention.comment_id,
                read = d.person_mention.read,
                published_at = d.person_mention.published,
                kind = NotificationType.Mention,
                post_id = d.post.id,
                creator_id = d.creator.id,
            ),
            data = this.toUniPV(d),
        )

    fun toUniPV(d: X0DatatypesPersonMentionView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X0DatatypesPostAggregates(-1, -1, -1, -1, -1, "")),
            community = this.toUni(d = d.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(VoteAction.from(d.my_vote), null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUniPMV(d: X0DatatypesPrivateMessageView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.private_message.id,
                recipient_id = d.private_message.recipient_id,
                read = d.private_message.read,
                published_at = d.private_message.published,
                kind = NotificationType.PrivateMessage,
                creator_id = d.creator.id,
            ),
            data = this.toUni(d),
        )

    override fun toUni(d: X0DatatypesGetSiteMetadataResponse): LemmyapiDatatypesGetSiteMetadataResponse = LemmyapiDatatypesGetSiteMetadataResponse(
        metadata = this.toUni(d = d.metadata),
    )

    override fun toUni(d: X0DatatypesInstance): LemmyapiDatatypesInstance = LemmyapiDatatypesInstance(
        id = d.id,
        domain = d.domain,
        published_at = d.published,
        updated_at = d.updated,
        software = d.software,
        version = d.version,
    )

    override fun toUni(d: X0DatatypesLanguage): LemmyapiDatatypesLanguage = LemmyapiDatatypesLanguage(
        id = d.id,
        code = d.code,
        name = d.name,
    )

    override fun toUni(d: X0DatatypesLocalSiteRateLimit): LemmyapiDatatypesLocalSiteRateLimit =
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

    override fun toUni(d: X0DatatypesLocalUser): LemmyapiDatatypesLocalUser =
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
            animated_images_enabled = d.enable_animated_images,
            collapse_bot_comments = d.collapse_bot_comments,
            last_donation_notification_at = "",
            show_score = d.show_scores,
            show_upvotes = d.show_scores,
            show_person_votes = d.show_scores,
            show_upvote_percentage = d.show_scores,
            show_downvotes = VoteShow.Show,
            hide_posts_with_media = false,
            show_media = true,
            default_comment_sort_type = CommentSortType.Hot,
            private_messages_enabled = true,
            auto_mark_fetched_posts_as_read = false,
            default_post_time_range_seconds = null,
            default_items_per_page = 20,
            totp_2fa_enabled = d.totp_2fa_enabled,
        )

    override fun toUni(d: X0DatatypesLocalUserView): LemmyapiDatatypesLocalUserView =
        LemmyapiDatatypesLocalUserView(
            local_user = this.toUni(d = d.local_user),
            person = this.toUni(d = d.person, d.counts),
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,
        )

    override fun toUni(d: X0DatatypesLoginResponse): LemmyapiDatatypesLoginResponse =
        LemmyapiDatatypesLoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent,
        )

    override fun toUni(d: X0DatatypesLoginToken): LemmyapiDatatypesLoginToken =
        LemmyapiDatatypesLoginToken(
            user_id = d.user_id,
            published_at = d.published,
            ip = d.ip,
            user_agent = d.user_agent,
        )

    override fun toUni(d: X0DatatypesMyUserInfo): LemmyapiDatatypesMyUserInfo =
        LemmyapiDatatypesMyUserInfo(
            local_user_view = this.toUni(d = d.local_user_view),
            follows = d.follows.map { this.toUni(d = it) },
            moderates = d.moderates.map { this.toUni(d = it) },
            community_blocks = d.community_blocks.map { this.toUni(d = it.community, counts = X0DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1)) },
            instance_communities_blocks = d.instance_blocks.map { this.toUni(d = it.instance) },
            instance_persons_blocks = emptyList(),
            person_blocks = d.person_blocks.map { this.toUni(d = it.target) },
            discussion_languages = d.discussion_languages,
            multi_community_follows = emptyList(),
        )

    fun toUni(d: X0DatatypesPerson) = this.toUni(d, X0DatatypesPersonAggregates(-1, -1, -1))

    override fun toUni(d: X0DatatypesPerson, counts: X0DatatypesPersonAggregates): LemmyapiDatatypesPerson = LemmyapiDatatypesPerson(
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
//        ban_expires = d.ban_expires,
        instance_id = d.instance_id,
        comment_count = counts.comment_count,
        post_count = counts.post_count,
        last_refreshed_at = "",
    )

    override fun toUni(d: X0DatatypesPersonView): LemmyapiDatatypesPersonView =
        LemmyapiDatatypesPersonView(
            person = this.toUni(d = d.person, d.counts),
            is_admin = d.is_admin,
            person_actions = null,
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,
        )

    override fun toUni(d: X0DatatypesPost, counts: X0DatatypesPostAggregates): LemmyapiDatatypesPost = LemmyapiDatatypesPost(
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
        comments = counts.comments,
        score = counts.score,
        upvotes = counts.upvotes,
        downvotes = counts.downvotes,
        newest_comment_time_at = "",
        report_count = -1,
        unresolved_report_count = -1,
        federation_pending = false,
    )

    override fun toUni(d: X0DatatypesPostReport): LemmyapiDatatypesPostReport =
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

    override fun toUni(d: X0DatatypesPostReportResponse): LemmyapiDatatypesPostReportResponse =
        LemmyapiDatatypesPostReportResponse(
            post_report_view = this.toUni(d = d.post_report_view),
        )

    override fun toUni(d: X0DatatypesPostResponse): LemmyapiDatatypesPostResponse =
        LemmyapiDatatypesPostResponse(
            post_view = this.toUni(d = d.post_view),
        )

    override fun toUni(d: X0DatatypesPrivateMessage): LemmyapiDatatypesPrivateMessage =
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
            deleted_by_recipient = false,
        )

    override fun toUni(d: X0DatatypesPrivateMessageReport): LemmyapiDatatypesPrivateMessageReport =
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

    override fun toUni(d: X0DatatypesPrivateMessageReportResponse): LemmyapiDatatypesPrivateMessageReportResponse = LemmyapiDatatypesPrivateMessageReportResponse(
        private_message_report_view = this.toUni(d = d.private_message_report_view),
    )

    override fun toUni(d: X0DatatypesPrivateMessageReportView): LemmyapiDatatypesPrivateMessageReportView = LemmyapiDatatypesPrivateMessageReportView(
        private_message_report = this.toUni(d = d.private_message_report),
        private_message = this.toUni(d = d.private_message),
        private_message_creator = this.toUni(d = d.private_message_creator),
        creator = this.toUni(d = d.creator),
        resolver = d.resolver?.let { this.toUni(d = it) },
        creator_is_admin = false,
        creator_banned = d.creator.banned,
        creator_ban_expires_at = d.creator.ban_expires,
    )

    override fun toUni(d: X0DatatypesPrivateMessageResponse): LemmyapiDatatypesPrivateMessageResponse = LemmyapiDatatypesPrivateMessageResponse(
        private_message_view = this.toUni(d = d.private_message_view),
    )

    override fun toUni(d: X0DatatypesPrivateMessageView): LemmyapiDatatypesPrivateMessageView =
        LemmyapiDatatypesPrivateMessageView(
            private_message = this.toUni(d = d.private_message),
            creator = this.toUni(d = d.creator),
            recipient = this.toUni(d = d.recipient),
        )

    override fun toUni(d: X0DatatypesReadableFederationState): LemmyapiDatatypesReadableFederationState = LemmyapiDatatypesReadableFederationState(
        instance_id = d.instance_id,
        last_successful_id = d.last_successful_id,
        last_successful_published_time_at = d.last_successful_published_time,
        fail_count = d.fail_count,
        last_retry_at = d.last_retry,
    )

    override fun toUni(d: X0DatatypesRegistrationApplication): LemmyapiDatatypesRegistrationApplication = LemmyapiDatatypesRegistrationApplication(
        id = d.id,
        local_user_id = d.local_user_id,
        answer = d.answer,
        admin_id = d.admin_id,
        deny_reason = d.deny_reason,
        published_at = d.published,
    )

    override fun toUni(d: X0DatatypesRegistrationApplicationResponse): LemmyapiDatatypesRegistrationApplicationResponse =
        LemmyapiDatatypesRegistrationApplicationResponse(
            registration_application = this.toUni(d = d.registration_application),
        )

    override fun toUni(d: X0DatatypesRegistrationApplicationView): LemmyapiDatatypesRegistrationApplicationView = LemmyapiDatatypesRegistrationApplicationView(
        registration_application = this.toUni(d = d.registration_application),
        creator_local_user = this.toUni(d = d.creator_local_user),
        creator = this.toUni(d = d.creator),
        admin = d.admin?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X0DatatypesResolveObjectResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            resolve = when {
                d.post != null -> toUni(d.post)
                d.comment != null -> toUni(d.comment)
                d.community != null -> toUni(d.community)
                d.person != null -> toUni(d.person)
                else -> null
            },
            comments = emptyList(),
            posts = emptyList(),
            communities = emptyList(),
            persons = emptyList(),
            multi_communities = emptyList(),
        )

    override fun toUni(d: X0DatatypesSearchResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            comments = d.comments.map(this@Transformer::toUni),
            posts = d.posts.map(this@Transformer::toUni),
            communities = d.communities.map(this@Transformer::toUni),
            persons = d.users.map(this@Transformer::toUni),
            multi_communities = emptyList(),
        )

    override fun toUni(d: X0DatatypesSite): LemmyapiDatatypesSite = LemmyapiDatatypesSite(
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
    )

    override fun toUni(d: X0DatatypesSiteResponse): LemmyapiDatatypesSiteResponse =
        LemmyapiDatatypesSiteResponse(
            site_view = this.toUni(d = d.site_view),
        )

    override fun toUni(d: X0DatatypesSiteView): LemmyapiDatatypesSiteView = LemmyapiDatatypesSiteView(
        site = this.toUni(d = d.site),
        local_site = this.toUni(d = d.local_site, counts = d.counts),
        local_site_rate_limit = this.toUni(d = d.local_site_rate_limit),
        instance = null,
    )

    override fun toUni(d: X0DatatypesTagline): LemmyapiDatatypesTagline = LemmyapiDatatypesTagline(
        id = d.id,
        content = d.content,
        published_at = d.published,
        updated_at = d.updated,
    )

    override fun toUni(d: X0DatatypesUpdateTotpResponse): LemmyapiDatatypesUpdateTotpResponse =
        LemmyapiDatatypesUpdateTotpResponse(
            enabled = d.enabled,
        )

    override fun fromUni(d: LemmyapiDatatypesAddAdmin): X0DatatypesAddAdmin = X0DatatypesAddAdmin(
        person_id = d.person_id,
        added = d.added,
    )

    override fun fromUni(d: LemmyapiDatatypesAddModToCommunity): X0DatatypesAddModToCommunity =
        X0DatatypesAddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
        )

    override fun fromUni(d: LemmyapiDatatypesApproveRegistrationApplication): X0DatatypesApproveRegistrationApplication = X0DatatypesApproveRegistrationApplication(
        id = d.id,
        approve = d.approve,
        deny_reason = d.deny_reason,
    )

    override fun fromUni(d: LemmyapiDatatypesBanFromCommunity): X0DatatypesBanFromCommunity =
        X0DatatypesBanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_or_restore_data,
            reason = d.reason,
            expires = d.expires_at,
        )

    override fun fromUni(d: LemmyapiDatatypesBanPerson): X0DatatypesBanPerson = X0DatatypesBanPerson(
        person_id = d.person_id,
        ban = d.ban,
        remove_data = d.remove_or_restore_data,
        reason = d.reason,
        expires = d.expires_at,
    )

    override fun fromUni(d: LemmyapiDatatypesBlockCommunity): X0DatatypesBlockCommunity =
        X0DatatypesBlockCommunity(
            community_id = d.community_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockInstance): X0DatatypesBlockInstance =
        X0DatatypesBlockInstance(
            instance_id = d.instance_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockPerson): X0DatatypesBlockPerson =
        X0DatatypesBlockPerson(
            person_id = d.person_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesChangePassword): X0DatatypesChangePassword =
        X0DatatypesChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateComment): X0DatatypesCreateComment =
        X0DatatypesCreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentLike): X0DatatypesCreateCommentLike =
        X0DatatypesCreateCommentLike(
            comment_id = d.comment_id,
            score = d.vote.value.toLong(),
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentReport): X0DatatypesCreateCommentReport =
        X0DatatypesCreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommunity): X0DatatypesCreateCommunity =
        X0DatatypesCreateCommunity(
            name = d.name,
            title = d.title,
            description = d.summary,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCustomEmoji): X0DatatypesCreateCustomEmoji =
        X0DatatypesCreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePost): X0DatatypesCreatePost =
        X0DatatypesCreatePost(
            name = d.name,
            community_id = d.community_id,
            url = d.url,
            body = d.body,
            honeypot = d.honeypot,
            nsfw = d.nsfw,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostLike): X0DatatypesCreatePostLike =
        X0DatatypesCreatePostLike(
            post_id = d.post_id,
            score = d.vote.value.toLong(),
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostReport): X0DatatypesCreatePostReport =
        X0DatatypesCreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessage): X0DatatypesCreatePrivateMessage =
        X0DatatypesCreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessageReport): X0DatatypesCreatePrivateMessageReport = X0DatatypesCreatePrivateMessageReport(
        private_message_id = d.private_message_id,
        reason = d.reason,
    )

    override fun fromUni(d: LemmyapiDatatypesCreateSite): X0DatatypesCreateSite =
        X0DatatypesCreateSite(
            name = d.name,
            sidebar = d.sidebar,
            description = d.summary,
            enable_downvotes = when (d.post_downvotes) {
                FederationMode.Local, FederationMode.All -> true
                FederationMode.Disable -> false
                null -> null
            },
            enable_nsfw = if (d.nsfw_content_disallowed == null) null else !d.nsfw_content_disallowed,
            community_creation_admin_only = d.community_creation_admin_only,
            require_email_verification = d.email_verification_required,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = V0ListingType.fromUniNullable(d.default_post_listing_type),
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
            captcha_enabled = null,
            captcha_difficulty = null,
            allowed_instances = d.allowed_instances,
            blocked_instances = d.blocked_instances,
            taglines = d.taglines,
            registration_mode = V0RegistrationMode.fromUniNullable(d.registration_mode),
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteAccount): X0DatatypesDeleteAccount =
        X0DatatypesDeleteAccount(
            password = d.password,
            delete_content = d.delete_content,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteComment): X0DatatypesDeleteComment =
        X0DatatypesDeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCommunity): X0DatatypesDeleteCommunity =
        X0DatatypesDeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCustomEmoji): X0DatatypesDeleteCustomEmoji =
        X0DatatypesDeleteCustomEmoji(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePost): X0DatatypesDeletePost =
        X0DatatypesDeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePrivateMessage): X0DatatypesDeletePrivateMessage =
        X0DatatypesDeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDistinguishComment): X0DatatypesDistinguishComment =
        X0DatatypesDistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
        )

    override fun fromUni(d: LemmyapiDatatypesEditComment): X0DatatypesEditComment =
        X0DatatypesEditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCommunity): X0DatatypesEditCommunity =
        X0DatatypesEditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.summary,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCustomEmoji): X0DatatypesEditCustomEmoji =
        X0DatatypesEditCustomEmoji(
            id = d.id,
            category = d.category ?: "",
            image_url = d.image_url ?: "",
            alt_text = d.alt_text ?: "",
            keywords = d.keywords ?: emptyList(),
        )

    override fun fromUni(d: LemmyapiDatatypesEditPost): X0DatatypesEditPost = X0DatatypesEditPost(
        post_id = d.post_id,
        name = d.name,
        url = d.url,
        body = d.body,
        nsfw = d.nsfw,
        language_id = d.language_id,
    )

    override fun fromUni(d: LemmyapiDatatypesEditPrivateMessage): X0DatatypesEditPrivateMessage =
        X0DatatypesEditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
        )

    override fun fromUni(d: LemmyapiDatatypesEditSite): X0DatatypesEditSite = X0DatatypesEditSite(
        name = d.name,
        sidebar = d.sidebar,
        description = d.summary,
        enable_downvotes = when (d.post_downvotes) {
            FederationMode.Local, FederationMode.All -> true
            FederationMode.Disable -> false
            null -> null
        },
        enable_nsfw = d.enable_nsfw,
        community_creation_admin_only = d.community_creation_admin_only,
        require_email_verification = d.email_verification_required,
        application_question = d.application_question,
        private_instance = d.private_instance,
        default_theme = d.default_theme,
        default_post_listing_type = V0ListingType.fromUniNullable(d.default_post_listing_type),
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
        captcha_enabled = null,
        captcha_difficulty = null,
        allowed_instances = d.allowed_instances,
        blocked_instances = d.blocked_instances,
        taglines = d.taglines,
        registration_mode = V0RegistrationMode.fromUniNullable(d.registration_mode),
        reports_email_admins = d.reports_email_admins,
    )

    override fun fromUni(d: LemmyapiDatatypesFeaturePost): X0DatatypesFeaturePost =
        X0DatatypesFeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = V0PostFeatureType.fromUni(d.feature_type),
        )

    override fun fromUni(d: LemmyapiDatatypesFollowCommunity): X0DatatypesFollowCommunity =
        X0DatatypesFollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComment): X0DatatypesGetComment =
        X0DatatypesGetComment(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComments): X0DatatypesGetComments =
        X0DatatypesGetComments(
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

    override fun fromUni(d: LemmyapiDatatypesGetCommunity): X0DatatypesGetCommunity =
        X0DatatypesGetCommunity(
            id = d.id,
            name = d.name,
        )

    override fun fromUni(d: LemmyapiDatatypesGetModlog): X0DatatypesGetModlog = X0DatatypesGetModlog(
        mod_person_id = d.mod_person_id,
        community_id = d.community_id,
        page = d.page,
        limit = d.limit,
        type_ = V0ModlogActionType.fromUniNullable(d.type_),
        other_person_id = d.other_person_id,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPersonDetails): X0DatatypesGetPersonDetails =
        X0DatatypesGetPersonDetails(
            person_id = d.person_id,
            username = d.username,
        )

    override fun fromUni(d: LemmyapiDatatypesGetPost): X0DatatypesGetPost = X0DatatypesGetPost(
        id = d.id,
        comment_id = d.comment_id,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPosts): X0DatatypesGetPosts = X0DatatypesGetPosts(
        type_ = V0ListingType.fromUniNullable(d.type_),
        sort = V0SortType.fromUniNullable(d.sort),
        page = d.page,
        limit = d.limit,
        community_id = d.community_id,
        community_name = d.community_name,
        page_cursor = d.page_cursor,
    )

    fun fromUniR(d: LemmyapiDatatypesListNotifications): X0DatatypesGetReplies =
        X0DatatypesGetReplies(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniM(d: LemmyapiDatatypesListNotifications): X0DatatypesGetPersonMentions =
        X0DatatypesGetPersonMentions(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniP(d: LemmyapiDatatypesListNotifications): X0DatatypesGetPrivateMessages =
        X0DatatypesGetPrivateMessages(
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    override fun fromUni(d: LemmyapiDatatypesGetSiteMetadata): X0DatatypesGetSiteMetadata =
        X0DatatypesGetSiteMetadata(
            url = d.url,
        )

    override fun fromUni(d: LemmyapiDatatypesHideCommunity): X0DatatypesHideCommunity =
        X0DatatypesHideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
        )

    override fun fromUniC(d: it.vercruysse.lemmyapi.datatypes.ListReports): X0DatatypesListCommentReports =
        X0DatatypesListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
        )

    override fun fromUniP(d: it.vercruysse.lemmyapi.datatypes.ListReports): X0DatatypesListPostReports =
        X0DatatypesListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
        )

    override fun fromUniPm(d: it.vercruysse.lemmyapi.datatypes.ListReports): X0DatatypesListPrivateMessageReports =
        X0DatatypesListPrivateMessageReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
        )

    override fun fromUni(d: LemmyapiDatatypesListCommunities): X0DatatypesListCommunities =
        X0DatatypesListCommunities(
            type_ = V0ListingType.fromUniNullable(d.type_),
            sort = V0SortType.fromUniNullable(d.sort),
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListRegistrationApplications): X0DatatypesListRegistrationApplications = X0DatatypesListRegistrationApplications(
        unread_only = d.unread_only,
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesLockPost): X0DatatypesLockPost = X0DatatypesLockPost(
        post_id = d.post_id,
        locked = d.locked,
    )

    override fun fromUni(d: LemmyapiDatatypesLogin): X0DatatypesLogin = X0DatatypesLogin(
        username_or_email = d.username_or_email,
        password = d.password,
        totp_2fa_token = d.totp_2fa_token,
    )

    fun fromUniR(d: MarkNotificationAsRead): X0DatatypesMarkCommentReplyAsRead = X0DatatypesMarkCommentReplyAsRead(
        comment_reply_id = d.notification_id,
        read = d.read,
    )

    fun fromUniM(d: MarkNotificationAsRead): X0DatatypesMarkPersonMentionAsRead = X0DatatypesMarkPersonMentionAsRead(
        person_mention_id = d.notification_id,
        read = d.read,
    )

    fun fromUniP(d: MarkNotificationAsRead): X0DatatypesMarkPrivateMessageAsRead = X0DatatypesMarkPrivateMessageAsRead(
        private_message_id = d.notification_id,
        read = d.read,
    )

    override fun fromUni(d: LemmyapiDatatypesMarkPostAsRead): X0DatatypesMarkPostAsRead =
        X0DatatypesMarkPostAsRead(
            post_ids = d.post_ids,
            read = d.read,
        )

    override fun fromUni(d: LemmyapiDatatypesPasswordChangeAfterReset): X0DatatypesPasswordChangeAfterReset = X0DatatypesPasswordChangeAfterReset(
        token = d.token,
        password = d.password,
        password_verify = d.password_verify,
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordReset): X0DatatypesPasswordReset =
        X0DatatypesPasswordReset(
            email = d.email,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeComment): X0DatatypesPurgeComment =
        X0DatatypesPurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeCommunity): X0DatatypesPurgeCommunity =
        X0DatatypesPurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePerson): X0DatatypesPurgePerson =
        X0DatatypesPurgePerson(
            person_id = d.person_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePost): X0DatatypesPurgePost = X0DatatypesPurgePost(
        post_id = d.post_id,
        reason = d.reason,
    )

    override fun fromUni(d: LemmyapiDatatypesRegister): X0DatatypesRegister = X0DatatypesRegister(
        username = d.username,
        password = d.password,
        password_verify = d.password_verify,
        show_nsfw = d.show_nsfw ?: false,
        email = d.email,
        captcha_uuid = d.captcha_uuid,
        captcha_answer = d.captcha_answer,
        honeypot = d.honeypot,
        answer = d.answer,
    )

    override fun fromUni(d: LemmyapiDatatypesRemoveComment): X0DatatypesRemoveComment =
        X0DatatypesRemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemoveCommunity): X0DatatypesRemoveCommunity =
        X0DatatypesRemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemovePost): X0DatatypesRemovePost =
        X0DatatypesRemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveCommentReport): X0DatatypesResolveCommentReport =
        X0DatatypesResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveObject): X0DatatypesResolveObject =
        X0DatatypesResolveObject(
            q = d.q,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePostReport): X0DatatypesResolvePostReport =
        X0DatatypesResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePrivateMessageReport): X0DatatypesResolvePrivateMessageReport = X0DatatypesResolvePrivateMessageReport(
        report_id = d.report_id,
        resolved = d.resolved,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveComment): X0DatatypesSaveComment =
        X0DatatypesSaveComment(
            comment_id = d.comment_id,
            save = d.save,
        )

    override fun fromUni(d: LemmyapiDatatypesSavePost): X0DatatypesSavePost = X0DatatypesSavePost(
        post_id = d.post_id,
        save = d.save,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveUserSettings): X0DatatypesSaveUserSettings =
        X0DatatypesSaveUserSettings(
            show_nsfw = d.show_nsfw,
            blur_nsfw = d.blur_nsfw,
            show_scores = d.show_score,
            theme = d.theme,
            default_sort_type = V0SortType.fromUniNullable(d.default_post_sort_type),
            default_listing_type = V0ListingType.fromUniNullable(d.default_listing_type),
            interface_language = d.interface_language,
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
            enable_animated_images = d.animated_images_enabled,
            collapse_bot_comments = d.collapse_bot_comments,
        )

    override fun fromUni(d: LemmyapiDatatypesSearch): X0DatatypesSearch = X0DatatypesSearch(
        q = d.search_term,
        community_id = d.community_id,
        community_name = d.community_name,
        creator_id = d.creator_id,
        type_ = V0SearchType.fromUniNullable(d.type_),
        listing_type = V0ListingType.fromUniNullable(d.listing_type),
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesTransferCommunity): X0DatatypesTransferCommunity =
        X0DatatypesTransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
        )

    override fun fromUni(d: LemmyapiDatatypesUpdateTotp): X0DatatypesUpdateTotp =
        X0DatatypesUpdateTotp(
            totp_token = d.totp_token,
            enabled = d.enabled,
        )

    override fun fromUni(d: LemmyapiDatatypesVerifyEmail): X0DatatypesVerifyEmail =
        X0DatatypesVerifyEmail(
            token = d.token,
        )
}
