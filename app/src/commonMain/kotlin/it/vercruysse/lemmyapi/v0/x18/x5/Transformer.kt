package it.vercruysse.lemmyapi.v0.x18.x5

import it.vercruysse.lemmyapi.datatypes.CommentActions
import it.vercruysse.lemmyapi.datatypes.CommunityActions
import it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.Notification
import it.vercruysse.lemmyapi.datatypes.NotificationView
import it.vercruysse.lemmyapi.datatypes.PersonActions
import it.vercruysse.lemmyapi.datatypes.PostActions
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.FederationMode
import it.vercruysse.lemmyapi.enums.NotificationType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteShow
import it.vercruysse.lemmyapi.utils.toAt
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUser
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
import it.vercruysse.lemmyapi.datatypes.ListReports as LemmyapiDatatypesListReports
import it.vercruysse.lemmyapi.datatypes.LocalSite as LemmyapiDatatypesLocalSite
import it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit as LemmyapiDatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.datatypes.LocalUser as LemmyapiDatatypesLocalUser
import it.vercruysse.lemmyapi.datatypes.LocalUserView as LemmyapiDatatypesLocalUserView
import it.vercruysse.lemmyapi.datatypes.LockPost as LemmyapiDatatypesLockPost
import it.vercruysse.lemmyapi.datatypes.Login as LemmyapiDatatypesLogin
import it.vercruysse.lemmyapi.datatypes.LoginResponse as LemmyapiDatatypesLoginResponse
import it.vercruysse.lemmyapi.datatypes.MyUserInfo as LemmyapiDatatypesMyUserInfo
import it.vercruysse.lemmyapi.datatypes.ChangePasswordAfterReset as LemmyapiDatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.datatypes.ResetPassword as LemmyapiDatatypesPasswordReset
import it.vercruysse.lemmyapi.datatypes.Person as LemmyapiDatatypesPerson
import it.vercruysse.lemmyapi.datatypes.PersonResponse as LemmyapiDatatypesPersonResponse
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
import it.vercruysse.lemmyapi.datatypes.VerifyEmail as LemmyapiDatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0.enums.CommentSortType as V0CommentSortType
import it.vercruysse.lemmyapi.v0.enums.ListingType as V0ListingType
import it.vercruysse.lemmyapi.v0.enums.ModlogActionType as V0ModlogActionType
import it.vercruysse.lemmyapi.v0.enums.PostFeatureType as V0PostFeatureType
import it.vercruysse.lemmyapi.v0.enums.RegistrationMode as V0RegistrationMode
import it.vercruysse.lemmyapi.v0.enums.SearchType as V0SearchType
import it.vercruysse.lemmyapi.v0.enums.SortType as V0SortType
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddAdmin as X5DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddAdminResponse as X5DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddModToCommunity as X5DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddModToCommunityResponse as X5DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ApproveRegistrationApplication as X5DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanFromCommunity as X5DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanFromCommunityResponse as X5DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanPerson as X5DatatypesBanPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockCommunity as X5DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockPerson as X5DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CaptchaResponse as X5DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ChangePassword as X5DatatypesChangePassword
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Comment as X5DatatypesComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentAggregates as X5DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReplyView as X5DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReport as X5DatatypesCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReportResponse as X5DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReportView as X5DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentResponse as X5DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentView as X5DatatypesCommentView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Community as X5DatatypesCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityAggregates as X5DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityFollowerView as X5DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityModeratorView as X5DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityResponse as X5DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityView as X5DatatypesCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateComment as X5DatatypesCreateComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommentLike as X5DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommentReport as X5DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommunity as X5DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCustomEmoji as X5DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePost as X5DatatypesCreatePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePostLike as X5DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePostReport as X5DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePrivateMessage as X5DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePrivateMessageReport as X5DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateSite as X5DatatypesCreateSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmoji as X5DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiKeyword as X5DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiResponse as X5DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiView as X5DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeleteAccount as X5DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeleteComment as X5DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeleteCommunity as X5DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeleteCustomEmoji as X5DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeletePost as X5DatatypesDeletePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DeletePrivateMessage as X5DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.DistinguishComment as X5DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditComment as X5DatatypesEditComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditCommunity as X5DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditCustomEmoji as X5DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditPost as X5DatatypesEditPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditPrivateMessage as X5DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.EditSite as X5DatatypesEditSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.FeaturePost as X5DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.FollowCommunity as X5DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCaptchaResponse as X5DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetComment as X5DatatypesGetComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetComments as X5DatatypesGetComments
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommunity as X5DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommunityResponse as X5DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetModlog as X5DatatypesGetModlog
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetails as X5DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetailsResponse as X5DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonMentions as X5DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPost as X5DatatypesGetPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPostResponse as X5DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPosts as X5DatatypesGetPosts
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPrivateMessages as X5DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetReplies as X5DatatypesGetReplies
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteMetadata as X5DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteMetadataResponse as X5DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse as X5DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.HideCommunity as X5DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Instance as X5DatatypesInstance
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Language as X5DatatypesLanguage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommentReports as X5DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommunities as X5DatatypesListCommunities
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPostReports as X5DatatypesListPostReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPrivateMessageReports as X5DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListRegistrationApplications as X5DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalSite as X5DatatypesLocalSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalSiteRateLimit as X5DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUser as X5DatatypesLocalUser
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUserView as X5DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LockPost as X5DatatypesLockPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Login as X5DatatypesLogin
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LoginResponse as X5DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkCommentReplyAsRead as X5DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkPersonMentionAsRead as X5DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkPrivateMessageAsRead as X5DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MyUserInfo as X5DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PasswordChangeAfterReset as X5DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PasswordReset as X5DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Person as X5DatatypesPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonAggregates as X5DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonMentionView as X5DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonView as X5DatatypesPersonView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Post as X5DatatypesPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostAggregates as X5DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReport as X5DatatypesPostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReportResponse as X5DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReportView as X5DatatypesPostReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostResponse as X5DatatypesPostResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostView as X5DatatypesPostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessage as X5DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReport as X5DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReportResponse as X5DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReportView as X5DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageResponse as X5DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageView as X5DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgeComment as X5DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgeCommunity as X5DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgePerson as X5DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgePost as X5DatatypesPurgePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Register as X5DatatypesRegister
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplication as X5DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplicationResponse as X5DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplicationView as X5DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemoveComment as X5DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemoveCommunity as X5DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemovePost as X5DatatypesRemovePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveCommentReport as X5DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveObject as X5DatatypesResolveObject
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveObjectResponse as X5DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolvePostReport as X5DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolvePrivateMessageReport as X5DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SaveComment as X5DatatypesSaveComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SavePost as X5DatatypesSavePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SaveUserSettings as X5DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Search as X5DatatypesSearch
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SearchResponse as X5DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Site as X5DatatypesSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteAggregates as X5DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteResponse as X5DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteView as X5DatatypesSiteView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Tagline as X5DatatypesTagline
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.TransferCommunity as X5DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.VerifyEmail as X5DatatypesVerifyEmail

internal class Transformer(var auth: String) : MapperGenerator {

    private fun mapLocalUserTotp(l: LocalUser): Boolean = l.totp_2fa_url != null

    private fun addTimezoneOffset(d: String): String = d + "Z"

    private fun addTimezoneOffsetNullable(d: String?): String? = d?.let { d + "Z" }

    override fun toUni(d: X5DatatypesLocalUser): LemmyapiDatatypesLocalUser =
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
            blur_nsfw = false,
            infinite_scroll_enabled = true,
            admin = false,
            post_listing_mode = PostListingMode.Card,
            totp_2fa_enabled = d.let { this.mapLocalUserTotp(it) },
            enable_animated_images = true,
            collapse_bot_comments = false,
            last_donation_notification_at = "",
            show_score = d.show_scores,
            show_upvotes = d.show_scores,
            show_downvotes = VoteShow.Show,
            show_person_votes = d.show_scores,
            show_upvote_percentage = d.show_scores,
            hide_media = false,
            enable_private_messages = true,
            default_comment_sort_type = SortType.Active,
            auto_mark_fetched_posts_as_read = false,
            default_post_time_range_seconds = 0,
            default_items_per_page = 20,
        )

    override fun toUni(d: X5DatatypesMyUserInfo): LemmyapiDatatypesMyUserInfo =
        LemmyapiDatatypesMyUserInfo(
            local_user_view = this.toUni(d = d.local_user_view),
            follows = d.follows.map { this.toUni(d = it) },
            moderates = d.moderates.map { this.toUni(d = it) },
            community_blocks = d.community_blocks.map { this.toUni(d = it.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)) },
            instance_communities_blocks = emptyList(),
            instance_persons_blocks = emptyList(),
            person_blocks = d.person_blocks.map { this.toUni(d = it.target) },
            discussion_languages = d.discussion_languages,
            multi_community_follows = emptyList(),
        )

    override fun toUni(d: X5DatatypesLocalSiteRateLimit): LemmyapiDatatypesLocalSiteRateLimit =
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
            published_at = addTimezoneOffset(d.published),
            updated_at = addTimezoneOffsetNullable(d.updated),
            import_user_settings_max_requests = -1,
            import_user_settings_interval_seconds = -1,
        )

    override fun toUni(d: X5DatatypesCommentReportView): LemmyapiDatatypesCommentReportView =
        LemmyapiDatatypesCommentReportView(
            comment_report = this.toUni(d = d.comment_report),
            comment = this.toUni(d = d.comment, d.counts),
            post = this.toUni(d = d.post, counts = X5DatatypesPostAggregates(-1, -1, -1, -1, -1, -1, "", "", "", false, false, -1, -1)),
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            comment_creator = this.toUni(d = d.comment_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            creator_banned = d.creator.banned,
            resolver = d.resolver?.let { this.toUni(d = it) },
            comment_actions = CommentActions(d.my_vote, null, null),
        )

    override fun toUni(d: X5DatatypesCommentView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X5DatatypesPostAggregates(-1, -1, -1, -1, -1, -1, "", "", "", false, false, -1, -1)),
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = addTimezoneOffsetNullable(d.creator.ban_expires),
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X5DatatypesCommunity, counts: X5DatatypesCommunityAggregates): LemmyapiDatatypesCommunity =
        LemmyapiDatatypesCommunity(
            id = d.id,
            name = d.name,
            title = d.title,
            summary = d.description,
            removed = d.removed,
            published_at = addTimezoneOffset(d.published),
            updated_at = addTimezoneOffsetNullable(d.updated),
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

    override fun toUni(d: X5DatatypesCommunityView): LemmyapiDatatypesCommunityView =
        LemmyapiDatatypesCommunityView(
            community = this.toUni(d = d.community, d.counts),
            can_mod = false,
            tags = emptyList(),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed), if (d.blocked) "" else null),
        )

    override fun toUni(d: X5DatatypesGetSiteResponse): LemmyapiDatatypesGetSiteResponse =
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
            image_upload_disabled = false,
            active_plugins = emptyList(),
        )

    override fun toUni(d: X5DatatypesLocalSite, counts: X5DatatypesSiteAggregates): LemmyapiDatatypesLocalSite =
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
            published_at = addTimezoneOffset(d.published),
            updated_at = addTimezoneOffsetNullable(d.updated),
            registration_mode = d.registration_mode.toUni(),
            reports_email_admins = d.reports_email_admins,
            federation_signed_fetch = false,
            default_post_listing_mode = PostListingMode.Card,
            default_post_sort_type = SortType.Active,
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

    override fun toUni(d: X5DatatypesPersonView, is_admin: Boolean): LemmyapiDatatypesPersonView =
        LemmyapiDatatypesPersonView(
            person = this.toUni(d = d.person, d.counts),
            is_admin = is_admin,
            person_actions = null,
            banned = d.person.banned,
            ban_expires_at = addTimezoneOffsetNullable(d.person.ban_expires),
        )

    override fun toUni(d: X5DatatypesPostReportView): LemmyapiDatatypesPostReportView =
        LemmyapiDatatypesPostReportView(
            post_report = this.toUni(d = d.post_report),
            post = this.toUni(d = d.post, d.counts),
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            post_creator = this.toUni(d = d.post_creator),
            post_actions = PostActions(null, null, null, null, null, d.my_vote, null),
            person_actions = null,
            community_actions = null,
            resolver = d.resolver?.let { this.toUni(d = it) },
            creator_is_moderator = false,
            creator_is_admin = false,
            creator_banned = d.creator.banned,
            creator_banned_from_community = d.creator_banned_from_community,
        )

    override fun toUni(d: X5DatatypesPostView): LemmyapiDatatypesPostView = LemmyapiDatatypesPostView(
        post = this.toUni(d = d.post, d.counts),
        creator = this.toUni(d = d.creator),
        community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, d.my_vote, null),
        person_actions = PersonActions(toAt(d.creator_blocked)),
        community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        tags = emptyList(),
        can_mod = false,
        creator_banned = d.creator.banned,
        creator_ban_expires_at = addTimezoneOffsetNullable(d.creator.ban_expires),
        creator_is_admin = false,
        creator_is_moderator = false,
        creator_banned_from_community = d.creator_banned_from_community,
    )

    override fun toUni(d: X5DatatypesAddAdminResponse): LemmyapiDatatypesAddAdminResponse =
        LemmyapiDatatypesAddAdminResponse(
            admins = d.admins.map { this.toUni(d = it) },
        )

    override fun toUni(d: X5DatatypesAddModToCommunityResponse): LemmyapiDatatypesAddModToCommunityResponse = LemmyapiDatatypesAddModToCommunityResponse(
        moderators = d.moderators.map { this.toUni(d = it) },
    )

    override fun toUni(d: X5DatatypesBanFromCommunityResponse): LemmyapiDatatypesPersonResponse = LemmyapiDatatypesPersonResponse(
        person_view = this.toUni(d = d.person_view),
    )

    override fun toUni(d: X5DatatypesCaptchaResponse): LemmyapiDatatypesCaptchaResponse =
        LemmyapiDatatypesCaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid,
        )

    override fun toUni(d: X5DatatypesComment, counts: X5DatatypesCommentAggregates): LemmyapiDatatypesComment = LemmyapiDatatypesComment(
        id = d.id,
        creator_id = d.creator_id,
        post_id = d.post_id,
        content = d.content,
        removed = d.removed,
        published_at = addTimezoneOffset(d.published),
        updated_at = addTimezoneOffsetNullable(d.updated),
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

    override fun toUni(d: X5DatatypesCommentReport): LemmyapiDatatypesCommentReport =
        LemmyapiDatatypesCommentReport(
            id = d.id,
            creator_id = d.creator_id,
            comment_id = d.comment_id,
            original_comment_text = d.original_comment_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published_at = addTimezoneOffset(d.published),
            updated_at = d.updated,
        )

    override fun toUni(d: X5DatatypesCommentReportResponse): LemmyapiDatatypesCommentReportResponse =
        LemmyapiDatatypesCommentReportResponse(
            comment_report_view = this.toUni(d = d.comment_report_view),
        )

    override fun toUni(d: X5DatatypesCommentResponse): LemmyapiDatatypesCommentResponse =
        LemmyapiDatatypesCommentResponse(
            comment_view = this.toUni(d = d.comment_view),
        )

    override fun toUni(d: X5DatatypesCommunityFollowerView): LemmyapiDatatypesCommunityFollowerView =
        LemmyapiDatatypesCommunityFollowerView(
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            follower = this.toUni(d = d.follower),
        )

    override fun toUni(d: X5DatatypesCommunityModeratorView): LemmyapiDatatypesCommunityModeratorView = LemmyapiDatatypesCommunityModeratorView(
        community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        moderator = this.toUni(d = d.moderator),
    )

    override fun toUni(d: X5DatatypesCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X5DatatypesCustomEmoji): LemmyapiDatatypesCustomEmoji =
        LemmyapiDatatypesCustomEmoji(
            id = d.id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published_at = addTimezoneOffset(d.published),
            updated_at = d.updated,
        )

    override fun toUni(d: X5DatatypesCustomEmojiKeyword): LemmyapiDatatypesCustomEmojiKeyword =
        LemmyapiDatatypesCustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword,
        )

    override fun toUni(d: X5DatatypesCustomEmojiResponse): LemmyapiDatatypesCustomEmojiResponse =
        LemmyapiDatatypesCustomEmojiResponse(
            custom_emoji = this.toUni(d = d.custom_emoji),
        )

    override fun toUni(d: X5DatatypesCustomEmojiView): LemmyapiDatatypesCustomEmojiView =
        LemmyapiDatatypesCustomEmojiView(
            custom_emoji = this.toUni(d = d.custom_emoji),
            keywords = d.keywords.map { this.toUni(d = it) },
        )

    override fun toUni(d: X5DatatypesGetCaptchaResponse): LemmyapiDatatypesGetCaptchaResponse =
        LemmyapiDatatypesGetCaptchaResponse(
            ok = d.ok?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X5DatatypesGetCommunityResponse): LemmyapiDatatypesGetCommunityResponse =
        LemmyapiDatatypesGetCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            site = d.site?.let { this.toUni(d = it) },
            moderators = d.moderators.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X5DatatypesGetPersonDetailsResponse): LemmyapiDatatypesGetPersonDetailsResponse = LemmyapiDatatypesGetPersonDetailsResponse(
        person_view = this.toUni(d = d.person_view),
        moderates = d.moderates.map { this.toUni(d = it) },
        multi_communities_created = emptyList(),
    )

    override fun toUni(d: X5DatatypesGetPostResponse): LemmyapiDatatypesGetPostResponse =
        LemmyapiDatatypesGetPostResponse(
            post_view = this.toUni(d = d.post_view),
            community_view = this.toUni(d = d.community_view),
            moderators = d.moderators.map { this.toUni(d = it) },
            cross_posts = d.cross_posts.map { this.toUni(d = it) },
        )

    fun toUni(d: X5DatatypesCommentReplyView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.comment_reply.id,
                recipient_id = d.comment_reply.recipient_id,
                comment_id = d.comment_reply.comment_id,
                read = d.comment_reply.read,
                published_at = addTimezoneOffset(d.comment_reply.published),
                kind = NotificationType.Reply,
                post_id = d.post.id,
            ),
            data = this.toUniCV(d),
        )

    fun toUniCV(d: X5DatatypesCommentReplyView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X5DatatypesPostAggregates(-1, -1, -1, -1, -1, -1, "", "", "", false, false, -1, -1)),
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = addTimezoneOffsetNullable(d.creator.ban_expires),
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUni(d: X5DatatypesPersonMentionView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.person_mention.id,
                recipient_id = d.person_mention.recipient_id,
                comment_id = d.person_mention.comment_id,
                read = d.person_mention.read,
                published_at = addTimezoneOffset(d.person_mention.published),
                kind = NotificationType.Mention,
                post_id = d.post.id,
            ),
            data = this.toUniPV(d),
        )

    fun toUniPV(d: X5DatatypesPersonMentionView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X5DatatypesPostAggregates(-1, -1, -1, -1, -1, -1, "", "", "", false, false, -1, -1)),
            community = this.toUni(d = d.community, counts = X5DatatypesCommunityAggregates(-1, -1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = addTimezoneOffsetNullable(d.creator.ban_expires),
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUniPMV(d: X5DatatypesPrivateMessageView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.private_message.id,
                recipient_id = d.private_message.recipient_id,
                read = d.private_message.read,
                published_at = addTimezoneOffset(d.private_message.published),
                kind = NotificationType.PrivateMessage,
            ),
            data = this.toUni(d),
        )

    override fun toUni(d: X5DatatypesGetSiteMetadataResponse): LemmyapiDatatypesGetSiteMetadataResponse = LemmyapiDatatypesGetSiteMetadataResponse(
        metadata = this.toUni(d = d.metadata),
    )

    override fun toUni(d: X5DatatypesInstance): LemmyapiDatatypesInstance = LemmyapiDatatypesInstance(
        id = d.id,
        domain = d.domain,
        published_at = addTimezoneOffset(d.published),
        updated_at = addTimezoneOffsetNullable(d.updated),
        software = d.software,
        version = d.version,
    )

    override fun toUni(d: X5DatatypesLanguage): LemmyapiDatatypesLanguage = LemmyapiDatatypesLanguage(
        id = d.id,
        code = d.code,
        name = d.name,
    )

    override fun toUni(d: X5DatatypesLocalUserView): LemmyapiDatatypesLocalUserView =
        LemmyapiDatatypesLocalUserView(
            local_user = this.toUni(d = d.local_user),
            person = this.toUni(d = d.person, d.counts),
            banned = d.person.banned,
            ban_expires_at = addTimezoneOffsetNullable(d.person.ban_expires),
        )

    override fun toUni(d: X5DatatypesLoginResponse): LemmyapiDatatypesLoginResponse =
        LemmyapiDatatypesLoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent,
        )

    fun toUni(d: X5DatatypesPerson) = this.toUni(d, X5DatatypesPersonAggregates(-1, -1, -1, -1, -1, -1))

    override fun toUni(d: X5DatatypesPerson, counts: X5DatatypesPersonAggregates): LemmyapiDatatypesPerson = LemmyapiDatatypesPerson(
        id = d.id,
        name = d.name,
        display_name = d.display_name,
        avatar = d.avatar,
        published_at = addTimezoneOffset(d.published),
        updated_at = addTimezoneOffsetNullable(d.updated),
        last_refreshed_at = "",
        ap_id = d.actor_id,
        bio = d.bio,
        local = d.local,
        banner = d.banner,
        deleted = d.deleted,
        matrix_user_id = d.matrix_user_id,
        bot_account = d.bot_account,
//        ban_expires = addTimezoneOffsetNullable(d.ban_expires),
        instance_id = d.instance_id,
        post_count = counts.post_count,
        comment_count = counts.comment_count,
    )

    override fun toUni(d: X5DatatypesPost, counts: X5DatatypesPostAggregates): LemmyapiDatatypesPost = LemmyapiDatatypesPost(
        id = d.id,
        name = d.name,
        url = d.url,
        body = d.body,
        creator_id = d.creator_id,
        community_id = d.community_id,
        removed = d.removed,
        locked = d.locked,
        published_at = addTimezoneOffset(d.published),
        updated_at = addTimezoneOffsetNullable(d.updated),
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
        newest_comment_time_at = addTimezoneOffset(counts.newest_comment_time),
        report_count = -1,
        unresolved_report_count = -1,
        federation_pending = false,
    )

    override fun toUni(d: X5DatatypesPostReport): LemmyapiDatatypesPostReport =
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
            published_at = addTimezoneOffset(d.published),
            updated_at = d.updated,
            violates_instance_rules = false,
        )

    override fun toUni(d: X5DatatypesPostReportResponse): LemmyapiDatatypesPostReportResponse =
        LemmyapiDatatypesPostReportResponse(
            post_report_view = this.toUni(d = d.post_report_view),
        )

    override fun toUni(d: X5DatatypesPostResponse): LemmyapiDatatypesPostResponse =
        LemmyapiDatatypesPostResponse(
            post_view = this.toUni(d = d.post_view),
        )

    override fun toUni(d: X5DatatypesPrivateMessage): LemmyapiDatatypesPrivateMessage =
        LemmyapiDatatypesPrivateMessage(
            id = d.id,
            creator_id = d.creator_id,
            recipient_id = d.recipient_id,
            content = d.content,
            deleted = d.deleted,
            read = d.read,
            published_at = addTimezoneOffset(d.published),
            updated_at = addTimezoneOffsetNullable(d.updated),
            ap_id = d.ap_id,
            local = d.local,
            removed = false,
        )

    override fun toUni(d: X5DatatypesPrivateMessageReport): LemmyapiDatatypesPrivateMessageReport =
        LemmyapiDatatypesPrivateMessageReport(
            id = d.id,
            creator_id = d.creator_id,
            private_message_id = d.private_message_id,
            original_pm_text = d.original_pm_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published_at = addTimezoneOffset(d.published),
            updated_at = d.updated,
        )

    override fun toUni(d: X5DatatypesPrivateMessageReportResponse): LemmyapiDatatypesPrivateMessageReportResponse = LemmyapiDatatypesPrivateMessageReportResponse(
        private_message_report_view = this.toUni(d = d.private_message_report_view),
    )

    override fun toUni(d: X5DatatypesPrivateMessageReportView): LemmyapiDatatypesPrivateMessageReportView = LemmyapiDatatypesPrivateMessageReportView(
        private_message_report = this.toUni(d = d.private_message_report),
        private_message = this.toUni(d = d.private_message),
        private_message_creator = this.toUni(d = d.private_message_creator),
        creator = this.toUni(d = d.creator),
        resolver = d.resolver?.let { this.toUni(d = it) },
        creator_is_admin = d.creator.admin,
        creator_banned = d.creator.banned,
    )

    override fun toUni(d: X5DatatypesPrivateMessageResponse): LemmyapiDatatypesPrivateMessageResponse = LemmyapiDatatypesPrivateMessageResponse(
        private_message_view = this.toUni(d = d.private_message_view),
    )

    override fun toUni(d: X5DatatypesPrivateMessageView): LemmyapiDatatypesPrivateMessageView =
        LemmyapiDatatypesPrivateMessageView(
            private_message = this.toUni(d = d.private_message),
            creator = this.toUni(d = d.creator),
            recipient = this.toUni(d = d.recipient),
        )

    override fun toUni(d: X5DatatypesRegistrationApplication): LemmyapiDatatypesRegistrationApplication = LemmyapiDatatypesRegistrationApplication(
        id = d.id,
        local_user_id = d.local_user_id,
        answer = d.answer,
        admin_id = d.admin_id,
        deny_reason = d.deny_reason,
        published_at = d.published,
    )

    override fun toUni(d: X5DatatypesRegistrationApplicationResponse): LemmyapiDatatypesRegistrationApplicationResponse =
        LemmyapiDatatypesRegistrationApplicationResponse(
            registration_application = this.toUni(d = d.registration_application),
        )

    override fun toUni(d: X5DatatypesRegistrationApplicationView): LemmyapiDatatypesRegistrationApplicationView = LemmyapiDatatypesRegistrationApplicationView(
        registration_application = this.toUni(d = d.registration_application),
        creator_local_user = this.toUni(d = d.creator_local_user),
        creator = this.toUni(d = d.creator),
        admin = d.admin?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X5DatatypesResolveObjectResponse): LemmyapiDatatypesSearchResponse =
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

    override fun toUni(d: X5DatatypesSearchResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            search = buildList {
                addAll(d.comments.map(this@Transformer::toUni))
                addAll(d.posts.map(this@Transformer::toUni))
                addAll(d.communities.map(this@Transformer::toUni))
                addAll(d.users.map(this@Transformer::toUni))
            },
        )

    override fun toUni(d: X5DatatypesSite): LemmyapiDatatypesSite = LemmyapiDatatypesSite(
        id = d.id,
        name = d.name,
        sidebar = d.sidebar,
        published_at = addTimezoneOffset(d.published),
        updated_at = addTimezoneOffsetNullable(d.updated),
        icon = d.icon,
        banner = d.banner,
        summary = d.description,
        ap_id = d.actor_id,
        last_refreshed_at = addTimezoneOffset(d.last_refreshed_at),
        inbox_url = d.inbox_url,
        instance_id = d.instance_id,
    )

    override fun toUni(d: X5DatatypesSiteResponse): LemmyapiDatatypesSiteResponse =
        LemmyapiDatatypesSiteResponse(
            site_view = this.toUni(d = d.site_view),
        )

    override fun toUni(d: X5DatatypesSiteView): LemmyapiDatatypesSiteView = LemmyapiDatatypesSiteView(
        site = this.toUni(d = d.site),
        local_site = this.toUni(d = d.local_site, counts = d.counts),
        local_site_rate_limit = this.toUni(d = d.local_site_rate_limit),
        instance = null,
    )

    override fun toUni(d: X5DatatypesTagline): LemmyapiDatatypesTagline = LemmyapiDatatypesTagline(
        id = d.id,
        content = d.content,
        published_at = addTimezoneOffset(d.published),
        updated_at = d.updated,
    )

    override fun toUniF(d: X5DatatypesInstance): InstanceWithFederationState = super.toUniF(d)

    override fun fromUni(d: LemmyapiDatatypesAddAdmin): X5DatatypesAddAdmin = X5DatatypesAddAdmin(
        person_id = d.person_id,
        added = d.added,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesAddModToCommunity): X5DatatypesAddModToCommunity =
        X5DatatypesAddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesApproveRegistrationApplication): X5DatatypesApproveRegistrationApplication = X5DatatypesApproveRegistrationApplication(
        id = d.id,
        approve = d.approve,
        deny_reason = d.deny_reason,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesBanFromCommunity): X5DatatypesBanFromCommunity =
        X5DatatypesBanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_or_restore_data,
            reason = d.reason,
            expires = d.expires_at,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesBanPerson): X5DatatypesBanPerson = X5DatatypesBanPerson(
        person_id = d.person_id,
        ban = d.ban,
        remove_data = d.remove_or_restore_data,
        reason = d.reason,
        expires = d.expires_at,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesBlockCommunity): X5DatatypesBlockCommunity =
        X5DatatypesBlockCommunity(
            community_id = d.community_id,
            block = d.block,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockPerson): X5DatatypesBlockPerson =
        X5DatatypesBlockPerson(
            person_id = d.person_id,
            block = d.block,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesChangePassword): X5DatatypesChangePassword =
        X5DatatypesChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateComment): X5DatatypesCreateComment =
        X5DatatypesCreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentLike): X5DatatypesCreateCommentLike =
        X5DatatypesCreateCommentLike(
            comment_id = d.comment_id,
            score = d.score,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentReport): X5DatatypesCreateCommentReport =
        X5DatatypesCreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommunity): X5DatatypesCreateCommunity =
        X5DatatypesCreateCommunity(
            name = d.name,
            title = d.title,
            description = d.summary,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCustomEmoji): X5DatatypesCreateCustomEmoji =
        X5DatatypesCreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePost): X5DatatypesCreatePost =
        X5DatatypesCreatePost(
            name = d.name,
            community_id = d.community_id,
            url = d.url,
            body = d.body,
            honeypot = d.honeypot,
            nsfw = d.nsfw,
            language_id = d.language_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostLike): X5DatatypesCreatePostLike =
        X5DatatypesCreatePostLike(
            post_id = d.post_id,
            score = d.score,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostReport): X5DatatypesCreatePostReport =
        X5DatatypesCreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessage): X5DatatypesCreatePrivateMessage =
        X5DatatypesCreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessageReport): X5DatatypesCreatePrivateMessageReport = X5DatatypesCreatePrivateMessageReport(
        private_message_id = d.private_message_id,
        reason = d.reason,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesCreateSite): X5DatatypesCreateSite =
        X5DatatypesCreateSite(
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
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteAccount): X5DatatypesDeleteAccount =
        X5DatatypesDeleteAccount(
            password = d.password,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteComment): X5DatatypesDeleteComment =
        X5DatatypesDeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCommunity): X5DatatypesDeleteCommunity =
        X5DatatypesDeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCustomEmoji): X5DatatypesDeleteCustomEmoji =
        X5DatatypesDeleteCustomEmoji(
            id = d.id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePost): X5DatatypesDeletePost =
        X5DatatypesDeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePrivateMessage): X5DatatypesDeletePrivateMessage =
        X5DatatypesDeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesDistinguishComment): X5DatatypesDistinguishComment =
        X5DatatypesDistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesEditComment): X5DatatypesEditComment =
        X5DatatypesEditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCommunity): X5DatatypesEditCommunity =
        X5DatatypesEditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.summary,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCustomEmoji): X5DatatypesEditCustomEmoji =
        X5DatatypesEditCustomEmoji(
            id = d.id,
            category = d.category!!,
            image_url = d.image_url!!,
            alt_text = d.alt_text!!,
            keywords = d.keywords ?: emptyList(),
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesEditPost): X5DatatypesEditPost = X5DatatypesEditPost(
        post_id = d.post_id,
        name = d.name,
        url = d.url,
        body = d.body,
        nsfw = d.nsfw,
        language_id = d.language_id,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesEditPrivateMessage): X5DatatypesEditPrivateMessage =
        X5DatatypesEditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesEditSite): X5DatatypesEditSite = X5DatatypesEditSite(
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
        taglines = d.taglines,
        registration_mode = V0RegistrationMode.fromUniNullable(d.registration_mode),
        reports_email_admins = d.reports_email_admins,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesFeaturePost): X5DatatypesFeaturePost =
        X5DatatypesFeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = V0PostFeatureType.fromUni(d.feature_type),
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesFollowCommunity): X5DatatypesFollowCommunity =
        X5DatatypesFollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComment): X5DatatypesGetComment =
        X5DatatypesGetComment(
            id = d.id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComments): X5DatatypesGetComments =
        X5DatatypesGetComments(
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
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetCommunity): X5DatatypesGetCommunity =
        X5DatatypesGetCommunity(
            id = d.id,
            name = d.name,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetModlog): X5DatatypesGetModlog = X5DatatypesGetModlog(
        mod_person_id = d.mod_person_id,
        community_id = d.community_id,
        page = d.page,
        limit = d.limit,
        type_ = V0ModlogActionType.fromUniNullable(d.type_),
        other_person_id = d.other_person_id,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPersonDetails): X5DatatypesGetPersonDetails =
        X5DatatypesGetPersonDetails(
            person_id = d.person_id,
            username = d.username,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetPost): X5DatatypesGetPost = X5DatatypesGetPost(
        id = d.id,
        comment_id = d.comment_id,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPosts): X5DatatypesGetPosts = X5DatatypesGetPosts(
        type_ = V0ListingType.fromUniNullable(d.type_),
        sort = V0SortType.fromUniNullable(d.sort),
        page = d.page,
        limit = d.limit,
        community_id = d.community_id,
        community_name = d.community_name,
        auth = auth,
    )

    fun fromUniR(d: LemmyapiDatatypesListNotifications): X5DatatypesGetReplies =
        X5DatatypesGetReplies(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth,
        )

    fun fromUniM(d: LemmyapiDatatypesListNotifications): X5DatatypesGetPersonMentions =
        X5DatatypesGetPersonMentions(
            sort = V0CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth,
        )

    fun fromUniP(d: LemmyapiDatatypesListNotifications): X5DatatypesGetPrivateMessages =
        X5DatatypesGetPrivateMessages(
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesGetSiteMetadata): X5DatatypesGetSiteMetadata =
        X5DatatypesGetSiteMetadata(
            url = d.url,
        )

    override fun fromUni(d: LemmyapiDatatypesHideCommunity): X5DatatypesHideCommunity =
        X5DatatypesHideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUniC(d: LemmyapiDatatypesListReports): X5DatatypesListCommentReports =
        X5DatatypesListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesListCommunities): X5DatatypesListCommunities =
        X5DatatypesListCommunities(
            type_ = V0ListingType.fromUniNullable(d.type_),
            sort = V0SortType.fromUniNullable(d.sort),
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
            auth = auth,
        )

    override fun fromUniP(d: LemmyapiDatatypesListReports): X5DatatypesListPostReports =
        X5DatatypesListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth,
        )

    override fun fromUniPm(d: LemmyapiDatatypesListReports): X5DatatypesListPrivateMessageReports = X5DatatypesListPrivateMessageReports(
        page = d.page,
        limit = d.limit,
        unresolved_only = d.unresolved_only,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesListRegistrationApplications): X5DatatypesListRegistrationApplications = X5DatatypesListRegistrationApplications(
        unread_only = d.unread_only,
        page = d.page,
        limit = d.limit,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesLockPost): X5DatatypesLockPost = X5DatatypesLockPost(
        post_id = d.post_id,
        locked = d.locked,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesLogin): X5DatatypesLogin = X5DatatypesLogin(
        username_or_email = d.username_or_email,
        password = d.password,
        totp_2fa_token = d.totp_2fa_token,
    )

    fun fromUniR(d: MarkNotificationAsRead): X5DatatypesMarkCommentReplyAsRead = X5DatatypesMarkCommentReplyAsRead(
        comment_reply_id = d.notification_id,
        read = d.read,
        auth = auth,
    )

    fun fromUniM(d: MarkNotificationAsRead): X5DatatypesMarkPersonMentionAsRead = X5DatatypesMarkPersonMentionAsRead(
        person_mention_id = d.notification_id,
        read = d.read,
        auth = auth,
    )

    fun fromUniP(d: MarkNotificationAsRead): X5DatatypesMarkPrivateMessageAsRead = X5DatatypesMarkPrivateMessageAsRead(
        private_message_id = d.notification_id,
        read = d.read,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordChangeAfterReset): X5DatatypesPasswordChangeAfterReset = X5DatatypesPasswordChangeAfterReset(
        token = d.token,
        password = d.password,
        password_verify = d.password_verify,
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordReset): X5DatatypesPasswordReset =
        X5DatatypesPasswordReset(
            email = d.email,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeComment): X5DatatypesPurgeComment =
        X5DatatypesPurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeCommunity): X5DatatypesPurgeCommunity =
        X5DatatypesPurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePerson): X5DatatypesPurgePerson =
        X5DatatypesPurgePerson(
            person_id = d.person_id,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePost): X5DatatypesPurgePost = X5DatatypesPurgePost(
        post_id = d.post_id,
        reason = d.reason,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesRegister): X5DatatypesRegister = X5DatatypesRegister(
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

    override fun fromUni(d: LemmyapiDatatypesRemoveComment): X5DatatypesRemoveComment =
        X5DatatypesRemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesRemoveCommunity): X5DatatypesRemoveCommunity =
        X5DatatypesRemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesRemovePost): X5DatatypesRemovePost =
        X5DatatypesRemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveCommentReport): X5DatatypesResolveCommentReport =
        X5DatatypesResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveObject): X5DatatypesResolveObject =
        X5DatatypesResolveObject(
            q = d.q,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePostReport): X5DatatypesResolvePostReport =
        X5DatatypesResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePrivateMessageReport): X5DatatypesResolvePrivateMessageReport = X5DatatypesResolvePrivateMessageReport(
        report_id = d.report_id,
        resolved = d.resolved,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveComment): X5DatatypesSaveComment =
        X5DatatypesSaveComment(
            comment_id = d.comment_id,
            save = d.save,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesSavePost): X5DatatypesSavePost = X5DatatypesSavePost(
        post_id = d.post_id,
        save = d.save,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveUserSettings): X5DatatypesSaveUserSettings =
        X5DatatypesSaveUserSettings(
            show_nsfw = d.show_nsfw,
            show_scores = d.show_score,
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
            auth = auth,
            open_links_in_new_tab = d.open_links_in_new_tab,
        )

    override fun fromUni(d: LemmyapiDatatypesSearch): X5DatatypesSearch = X5DatatypesSearch(
        q = d.q,
        community_id = d.community_id,
        community_name = d.community_name,
        creator_id = d.creator_id,
        type_ = V0SearchType.fromUniNullable(d.type_),
        sort = V0SortType.fromUniNullable(d.sort),
        listing_type = V0ListingType.fromUniNullable(d.listing_type),
        page = d.page,
        limit = d.limit,
        auth = auth,
    )

    override fun fromUni(d: LemmyapiDatatypesTransferCommunity): X5DatatypesTransferCommunity =
        X5DatatypesTransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            auth = auth,
        )

    override fun fromUni(d: LemmyapiDatatypesVerifyEmail): X5DatatypesVerifyEmail =
        X5DatatypesVerifyEmail(
            token = d.token,
        )
}
