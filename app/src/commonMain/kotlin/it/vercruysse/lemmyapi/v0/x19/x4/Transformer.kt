package it.vercruysse.lemmyapi.v0.x19.x4

import it.vercruysse.lemmyapi.datatypes.CommentActions
import it.vercruysse.lemmyapi.datatypes.CommunityActions
import it.vercruysse.lemmyapi.datatypes.ListNotificationsResponse
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.Notification
import it.vercruysse.lemmyapi.datatypes.NotificationData
import it.vercruysse.lemmyapi.datatypes.NotificationView
import it.vercruysse.lemmyapi.datatypes.PersonActions
import it.vercruysse.lemmyapi.datatypes.PostActions
import it.vercruysse.lemmyapi.dto.CommentSortType
import it.vercruysse.lemmyapi.dto.CommunityFollowerState
import it.vercruysse.lemmyapi.dto.FederationMode
import it.vercruysse.lemmyapi.dto.NotificationType
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.VoteShow
import it.vercruysse.lemmyapi.utils.toAt
import it.vercruysse.lemmyapi.datatypes.AddAdmin as LemmyapiDatatypesAddAdmin
import it.vercruysse.lemmyapi.datatypes.AddAdminResponse as LemmyapiDatatypesAddAdminResponse
import it.vercruysse.lemmyapi.datatypes.AddModToCommunity as LemmyapiDatatypesAddModToCommunity
import it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse as LemmyapiDatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.datatypes.AdminAdd as LemmyapiDatatypesModAdd
import it.vercruysse.lemmyapi.datatypes.AdminAddView as LemmyapiDatatypesModAddView
import it.vercruysse.lemmyapi.datatypes.AdminBan as LemmyapiDatatypesModBan
import it.vercruysse.lemmyapi.datatypes.AdminBanView as LemmyapiDatatypesModBanView
import it.vercruysse.lemmyapi.datatypes.AdminPurgeComment as LemmyapiDatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommentView as LemmyapiDatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunity as LemmyapiDatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunityView as LemmyapiDatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.datatypes.AdminPurgePerson as LemmyapiDatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.datatypes.AdminPurgePersonView as LemmyapiDatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.datatypes.AdminPurgePost as LemmyapiDatatypesAdminPurgePost
import it.vercruysse.lemmyapi.datatypes.AdminPurgePostView as LemmyapiDatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.datatypes.AdminRemoveCommunity as LemmyapiDatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.AdminRemoveCommunityView as LemmyapiDatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication as LemmyapiDatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.BanFromCommunity as LemmyapiDatatypesBanFromCommunity
import it.vercruysse.lemmyapi.datatypes.BanFromCommunityResponse as LemmyapiDatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.datatypes.BanPerson as LemmyapiDatatypesBanPerson
import it.vercruysse.lemmyapi.datatypes.BanPersonResponse as LemmyapiDatatypesBanPersonResponse
import it.vercruysse.lemmyapi.datatypes.BannedPersonsResponse as LemmyapiDatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.datatypes.BlockCommunity as LemmyapiDatatypesBlockCommunity
import it.vercruysse.lemmyapi.datatypes.BlockCommunityResponse as LemmyapiDatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.datatypes.BlockPerson as LemmyapiDatatypesBlockPerson
import it.vercruysse.lemmyapi.datatypes.BlockPersonResponse as LemmyapiDatatypesBlockPersonResponse
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
import it.vercruysse.lemmyapi.datatypes.FederatedInstances as LemmyapiDatatypesFederatedInstances
import it.vercruysse.lemmyapi.datatypes.FollowCommunity as LemmyapiDatatypesFollowCommunity
import it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse as LemmyapiDatatypesGenerateTotpSecretResponse
import it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse as LemmyapiDatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.datatypes.GetComment as LemmyapiDatatypesGetComment
import it.vercruysse.lemmyapi.datatypes.GetComments as LemmyapiDatatypesGetComments
import it.vercruysse.lemmyapi.datatypes.GetCommentsResponse as LemmyapiDatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.datatypes.GetCommunity as LemmyapiDatatypesGetCommunity
import it.vercruysse.lemmyapi.datatypes.GetCommunityResponse as LemmyapiDatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.datatypes.GetFederatedInstancesResponse as LemmyapiDatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.datatypes.GetModlog as LemmyapiDatatypesGetModlog
import it.vercruysse.lemmyapi.datatypes.GetModlogResponse as LemmyapiDatatypesGetModlogResponse
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails as LemmyapiDatatypesGetPersonDetails
import it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse as LemmyapiDatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.datatypes.GetPost as LemmyapiDatatypesGetPost
import it.vercruysse.lemmyapi.datatypes.GetPostResponse as LemmyapiDatatypesGetPostResponse
import it.vercruysse.lemmyapi.datatypes.GetPosts as LemmyapiDatatypesGetPosts
import it.vercruysse.lemmyapi.datatypes.GetPostsResponse as LemmyapiDatatypesGetPostsResponse
import it.vercruysse.lemmyapi.datatypes.GetReportCount as LemmyapiDatatypesGetReportCount
import it.vercruysse.lemmyapi.datatypes.GetReportCountResponse as LemmyapiDatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadata as LemmyapiDatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse as LemmyapiDatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.datatypes.GetSiteResponse as LemmyapiDatatypesGetSiteResponse
import it.vercruysse.lemmyapi.datatypes.GetUnreadCountResponse as LemmyapiDatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.datatypes.GetUnreadRegistrationApplicationCountResponse as LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.datatypes.HideCommunity as LemmyapiDatatypesHideCommunity
import it.vercruysse.lemmyapi.datatypes.HidePost as LemmyapiDatatypesHidePost
import it.vercruysse.lemmyapi.datatypes.Instance as LemmyapiDatatypesInstance
import it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState as LemmyapiDatatypesInstanceWithFederationState
import it.vercruysse.lemmyapi.datatypes.Language as LemmyapiDatatypesLanguage
import it.vercruysse.lemmyapi.datatypes.LinkMetadata as LemmyapiDatatypesLinkMetadata
import it.vercruysse.lemmyapi.datatypes.ListCommentLikes as LemmyapiDatatypesListCommentLikes
import it.vercruysse.lemmyapi.datatypes.ListCommentLikesResponse as LemmyapiDatatypesListCommentLikesResponse
import it.vercruysse.lemmyapi.datatypes.ListCommunities as LemmyapiDatatypesListCommunities
import it.vercruysse.lemmyapi.datatypes.ListCommunitiesResponse as LemmyapiDatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.datatypes.ListMedia as LemmyapiDatatypesListMedia
import it.vercruysse.lemmyapi.datatypes.ListMediaResponse as LemmyapiDatatypesListMediaResponse
import it.vercruysse.lemmyapi.datatypes.ListNotifications as LemmyapiDatatypesListNotifications
import it.vercruysse.lemmyapi.datatypes.ListNotificationsResponse as LemmyapiDatatypesListNotificationsResponse
import it.vercruysse.lemmyapi.datatypes.ListPostLikes as LemmyapiDatatypesListPostLikes
import it.vercruysse.lemmyapi.datatypes.ListPostLikesResponse as LemmyapiDatatypesListPostLikesResponse
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications as LemmyapiDatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplicationsResponse as LemmyapiDatatypesListRegistrationApplicationsResponse
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
import it.vercruysse.lemmyapi.datatypes.MarkPostAsRead as LemmyapiDatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.datatypes.ModAddToCommunity as LemmyapiDatatypesModAddCommunity
import it.vercruysse.lemmyapi.datatypes.ModAddToCommunityView as LemmyapiDatatypesModAddCommunityView
import it.vercruysse.lemmyapi.datatypes.ModBanFromCommunity as LemmyapiDatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.datatypes.ModBanFromCommunityView as LemmyapiDatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.datatypes.ModChangeCommunityVisibility as LemmyapiDatatypesModChangeCommunityVisibility
import it.vercruysse.lemmyapi.datatypes.ModChangeCommunityVisibilityView as LemmyapiDatatypesModChangeCommunityVisibilityView
import it.vercruysse.lemmyapi.datatypes.ModFeaturePost as LemmyapiDatatypesModFeaturePost
import it.vercruysse.lemmyapi.datatypes.ModFeaturePostView as LemmyapiDatatypesModFeaturePostView
import it.vercruysse.lemmyapi.datatypes.ModLockPost as LemmyapiDatatypesModLockPost
import it.vercruysse.lemmyapi.datatypes.ModLockPostView as LemmyapiDatatypesModLockPostView
import it.vercruysse.lemmyapi.datatypes.ModRemoveComment as LemmyapiDatatypesModRemoveComment
import it.vercruysse.lemmyapi.datatypes.ModRemoveCommentView as LemmyapiDatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.datatypes.ModRemovePost as LemmyapiDatatypesModRemovePost
import it.vercruysse.lemmyapi.datatypes.ModRemovePostView as LemmyapiDatatypesModRemovePostView
import it.vercruysse.lemmyapi.datatypes.ModTransferCommunity as LemmyapiDatatypesModTransferCommunity
import it.vercruysse.lemmyapi.datatypes.ModTransferCommunityView as LemmyapiDatatypesModTransferCommunityView
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
import it.vercruysse.lemmyapi.datatypes.ReadableFederationState as LemmyapiDatatypesReadableFederationState
import it.vercruysse.lemmyapi.datatypes.Register as LemmyapiDatatypesRegister
import it.vercruysse.lemmyapi.datatypes.RegistrationApplication as LemmyapiDatatypesRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse as LemmyapiDatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView as LemmyapiDatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.datatypes.RemoveComment as LemmyapiDatatypesRemoveComment
import it.vercruysse.lemmyapi.datatypes.RemoveCommunity as LemmyapiDatatypesRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.RemovePost as LemmyapiDatatypesRemovePost
import it.vercruysse.lemmyapi.datatypes.ResolveCommentReport as LemmyapiDatatypesResolveCommentReport
import it.vercruysse.lemmyapi.datatypes.ResolveObject as LemmyapiDatatypesResolveObject
import it.vercruysse.lemmyapi.datatypes.ResolveObjectResponse as LemmyapiDatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.datatypes.ResolvePostReport as LemmyapiDatatypesResolvePostReport
import it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport as LemmyapiDatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.SaveComment as LemmyapiDatatypesSaveComment
import it.vercruysse.lemmyapi.datatypes.SavePost as LemmyapiDatatypesSavePost
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings as LemmyapiDatatypesSaveUserSettings
import it.vercruysse.lemmyapi.datatypes.Search as LemmyapiDatatypesSearch
import it.vercruysse.lemmyapi.datatypes.SearchCombinedView as LemmyapiDatatypesSearchCombinedView
import it.vercruysse.lemmyapi.datatypes.SearchResponse as LemmyapiDatatypesSearchResponse
import it.vercruysse.lemmyapi.datatypes.Site as LemmyapiDatatypesSite
import it.vercruysse.lemmyapi.datatypes.SiteResponse as LemmyapiDatatypesSiteResponse
import it.vercruysse.lemmyapi.datatypes.SiteView as LemmyapiDatatypesSiteView
import it.vercruysse.lemmyapi.datatypes.Tagline as LemmyapiDatatypesTagline
import it.vercruysse.lemmyapi.datatypes.TransferCommunity as LemmyapiDatatypesTransferCommunity
import it.vercruysse.lemmyapi.datatypes.UpdateTotp as LemmyapiDatatypesUpdateTotp
import it.vercruysse.lemmyapi.datatypes.UpdateTotpResponse as LemmyapiDatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams as LemmyapiDatatypesBlockInstance
import it.vercruysse.lemmyapi.datatypes.VerifyEmail as LemmyapiDatatypesVerifyEmail
import it.vercruysse.lemmyapi.datatypes.VoteView as LemmyapiDatatypesVoteView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddAdmin as X4DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddAdminResponse as X4DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddModToCommunity as X4DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AddModToCommunityResponse as X4DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeComment as X4DatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommentView as X4DatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommunity as X4DatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgeCommunityView as X4DatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePerson as X4DatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePersonView as X4DatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePost as X4DatatypesAdminPurgePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.AdminPurgePostView as X4DatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ApproveRegistrationApplication as X4DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanFromCommunity as X4DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanFromCommunityResponse as X4DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanPerson as X4DatatypesBanPerson
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BanPersonResponse as X4DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BannedPersonsResponse as X4DatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockCommunity as X4DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockCommunityResponse as X4DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockInstance as X4DatatypesBlockInstance
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockPerson as X4DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.BlockPersonResponse as X4DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CaptchaResponse as X4DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ChangePassword as X4DatatypesChangePassword
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Comment as X4DatatypesComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentAggregates as X4DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReplyView as X4DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReport as X4DatatypesCommentReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReportResponse as X4DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentReportView as X4DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentResponse as X4DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommentView as X4DatatypesCommentView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Community as X4DatatypesCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityAggregates as X4DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityFollowerView as X4DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityModeratorView as X4DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityResponse as X4DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CommunityView as X4DatatypesCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateComment as X4DatatypesCreateComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommentLike as X4DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommentReport as X4DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCommunity as X4DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateCustomEmoji as X4DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePost as X4DatatypesCreatePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePostLike as X4DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePostReport as X4DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePrivateMessage as X4DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreatePrivateMessageReport as X4DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CreateSite as X4DatatypesCreateSite
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmoji as X4DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiKeyword as X4DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiResponse as X4DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.CustomEmojiView as X4DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteAccount as X4DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteComment as X4DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteCommunity as X4DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeleteCustomEmoji as X4DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeletePost as X4DatatypesDeletePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DeletePrivateMessage as X4DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.DistinguishComment as X4DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditComment as X4DatatypesEditComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditCommunity as X4DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditCustomEmoji as X4DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditPost as X4DatatypesEditPost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditPrivateMessage as X4DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.EditSite as X4DatatypesEditSite
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FeaturePost as X4DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FederatedInstances as X4DatatypesFederatedInstances
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.FollowCommunity as X4DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GenerateTotpSecretResponse as X4DatatypesGenerateTotpSecretResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCaptchaResponse as X4DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetComment as X4DatatypesGetComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetComments as X4DatatypesGetComments
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommentsResponse as X4DatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommunity as X4DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetCommunityResponse as X4DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetFederatedInstancesResponse as X4DatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetModlog as X4DatatypesGetModlog
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetModlogResponse as X4DatatypesGetModlogResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonDetails as X4DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonDetailsResponse as X4DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonMentions as X4DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPersonMentionsResponse as X4DatatypesGetPersonMentionsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPost as X4DatatypesGetPost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPostResponse as X4DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPosts as X4DatatypesGetPosts
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPostsResponse as X4DatatypesGetPostsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetPrivateMessages as X4DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReplies as X4DatatypesGetReplies
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetRepliesResponse as X4DatatypesGetRepliesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReportCount as X4DatatypesGetReportCount
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetReportCountResponse as X4DatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteMetadata as X4DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteMetadataResponse as X4DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetSiteResponse as X4DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetUnreadCountResponse as X4DatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.GetUnreadRegistrationApplicationCountResponse as X4DatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.HideCommunity as X4DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.HidePost as X4DatatypesHidePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Instance as X4DatatypesInstance
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.InstanceWithFederationState as X4DatatypesInstanceWithFederationState
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Language as X4DatatypesLanguage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LinkMetadata as X4DatatypesLinkMetadata
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommentLikes as X4DatatypesListCommentLikes
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommentLikesResponse as X4DatatypesListCommentLikesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommentReports as X4DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommunities as X4DatatypesListCommunities
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListCommunitiesResponse as X4DatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListMedia as X4DatatypesListMedia
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListMediaResponse as X4DatatypesListMediaResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPostLikes as X4DatatypesListPostLikes
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPostLikesResponse as X4DatatypesListPostLikesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPostReports as X4DatatypesListPostReports
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListPrivateMessageReports as X4DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListRegistrationApplications as X4DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ListRegistrationApplicationsResponse as X4DatatypesListRegistrationApplicationsResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalImage as X4DatatypesLocalImage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalImageView as X4DatatypesLocalImageView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalSite as X4DatatypesLocalSite
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalSiteRateLimit as X4DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalSiteUrlBlocklist as X4DatatypesLocalSiteUrlBlocklist
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalUser as X4DatatypesLocalUser
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalUserView as X4DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LocalUserVoteDisplayMode as X4DatatypesLocalUserVoteDisplayMode
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LockPost as X4DatatypesLockPost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Login as X4DatatypesLogin
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LoginResponse as X4DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.LoginToken as X4DatatypesLoginToken
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkCommentReplyAsRead as X4DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkPersonMentionAsRead as X4DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkPostAsRead as X4DatatypesMarkPostAsRead
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MarkPrivateMessageAsRead as X4DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAdd as X4DatatypesModAdd
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddCommunity as X4DatatypesModAddCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddCommunityView as X4DatatypesModAddCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModAddView as X4DatatypesModAddView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBan as X4DatatypesModBan
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanFromCommunity as X4DatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanFromCommunityView as X4DatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModBanView as X4DatatypesModBanView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModFeaturePost as X4DatatypesModFeaturePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModFeaturePostView as X4DatatypesModFeaturePostView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModHideCommunity as X4DatatypesModHideCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModHideCommunityView as X4DatatypesModHideCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModLockPost as X4DatatypesModLockPost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModLockPostView as X4DatatypesModLockPostView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveComment as X4DatatypesModRemoveComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommentView as X4DatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommunity as X4DatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemoveCommunityView as X4DatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemovePost as X4DatatypesModRemovePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModRemovePostView as X4DatatypesModRemovePostView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModTransferCommunity as X4DatatypesModTransferCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ModTransferCommunityView as X4DatatypesModTransferCommunityView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.MyUserInfo as X4DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PasswordChangeAfterReset as X4DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PasswordReset as X4DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Person as X4DatatypesPerson
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonAggregates as X4DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonMentionView as X4DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PersonView as X4DatatypesPersonView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Post as X4DatatypesPost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostAggregates as X4DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReport as X4DatatypesPostReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReportResponse as X4DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostReportView as X4DatatypesPostReportView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostResponse as X4DatatypesPostResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PostView as X4DatatypesPostView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessage as X4DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReport as X4DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReportResponse as X4DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageReportView as X4DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageResponse as X4DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessageView as X4DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PrivateMessagesResponse as X4DatatypesPrivateMessagesResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgeComment as X4DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgeCommunity as X4DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgePerson as X4DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.PurgePost as X4DatatypesPurgePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ReadableFederationState as X4DatatypesReadableFederationState
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Register as X4DatatypesRegister
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplication as X4DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplicationResponse as X4DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RegistrationApplicationView as X4DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemoveComment as X4DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemoveCommunity as X4DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.RemovePost as X4DatatypesRemovePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveCommentReport as X4DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveObject as X4DatatypesResolveObject
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolveObjectResponse as X4DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolvePostReport as X4DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.ResolvePrivateMessageReport as X4DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SaveComment as X4DatatypesSaveComment
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SavePost as X4DatatypesSavePost
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SaveUserSettings as X4DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Search as X4DatatypesSearch
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SearchResponse as X4DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Site as X4DatatypesSite
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteAggregates as X4DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteResponse as X4DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.SiteView as X4DatatypesSiteView
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.Tagline as X4DatatypesTagline
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.TransferCommunity as X4DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.UpdateTotp as X4DatatypesUpdateTotp
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.UpdateTotpResponse as X4DatatypesUpdateTotpResponse
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.VerifyEmail as X4DatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0.x19.x4.datatypes.VoteView as X4DatatypesVoteView

// Based on tags/0.19.4
internal class Transformer : MapperGenerator {
    override fun toUni(d: X4DatatypesAddAdminResponse): LemmyapiDatatypesAddAdminResponse =
        LemmyapiDatatypesAddAdminResponse(
            admins = d.admins.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesAddModToCommunityResponse): LemmyapiDatatypesAddModToCommunityResponse = LemmyapiDatatypesAddModToCommunityResponse(
        moderators = d.moderators.map { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesAdminPurgeComment): LemmyapiDatatypesAdminPurgeComment =
        LemmyapiDatatypesAdminPurgeComment(
            id = d.id,
            admin_person_id = d.admin_person_id,
            post_id = d.post_id,
            reason = d.reason ?: "",
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesAdminPurgeCommentView): LemmyapiDatatypesAdminPurgeCommentView =
        LemmyapiDatatypesAdminPurgeCommentView(
            admin_purge_comment = this.toUni(d = d.admin_purge_comment),
            admin = d.admin?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
        )

    override fun toUni(d: X4DatatypesAdminPurgeCommunity): LemmyapiDatatypesAdminPurgeCommunity =
        LemmyapiDatatypesAdminPurgeCommunity(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason ?: "",
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesAdminPurgeCommunityView): LemmyapiDatatypesAdminPurgeCommunityView = LemmyapiDatatypesAdminPurgeCommunityView(
        admin_purge_community = this.toUni(d = d.admin_purge_community),
        admin = d.admin?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesAdminPurgePerson): LemmyapiDatatypesAdminPurgePerson =
        LemmyapiDatatypesAdminPurgePerson(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason ?: "",
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesAdminPurgePersonView): LemmyapiDatatypesAdminPurgePersonView =
        LemmyapiDatatypesAdminPurgePersonView(
            admin_purge_person = this.toUni(d = d.admin_purge_person),
            admin = d.admin?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesAdminPurgePost): LemmyapiDatatypesAdminPurgePost =
        LemmyapiDatatypesAdminPurgePost(
            id = d.id,
            admin_person_id = d.admin_person_id,
            community_id = d.community_id,
            reason = d.reason ?: "",
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesAdminPurgePostView): LemmyapiDatatypesAdminPurgePostView =
        LemmyapiDatatypesAdminPurgePostView(
            admin_purge_post = this.toUni(d = d.admin_purge_post),
            admin = d.admin?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesBanFromCommunityResponse): LemmyapiDatatypesBanFromCommunityResponse = LemmyapiDatatypesBanFromCommunityResponse(
        person_view = this.toUni(d = d.person_view),
        banned = d.banned,
    )

    override fun toUni(d: X4DatatypesBannedPersonsResponse): LemmyapiDatatypesBannedPersonsResponse =
        LemmyapiDatatypesBannedPersonsResponse(
            banned = d.banned.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesBanPersonResponse): LemmyapiDatatypesBanPersonResponse =
        LemmyapiDatatypesBanPersonResponse(
            person_view = this.toUni(d = d.person_view),
            banned = d.banned,
        )

    override fun toUni(d: X4DatatypesBlockCommunityResponse): LemmyapiDatatypesBlockCommunityResponse =
        LemmyapiDatatypesBlockCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            blocked = d.blocked,
        )

    override fun toUni(d: X4DatatypesBlockPersonResponse): LemmyapiDatatypesBlockPersonResponse =
        LemmyapiDatatypesBlockPersonResponse(
            person_view = this.toUni(d = d.person_view),
            blocked = d.blocked,
        )

    override fun toUni(d: X4DatatypesCaptchaResponse): LemmyapiDatatypesCaptchaResponse =
        LemmyapiDatatypesCaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid,
        )

    override fun toUni(d: X4DatatypesComment, counts: X4DatatypesCommentAggregates): LemmyapiDatatypesComment = LemmyapiDatatypesComment(
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

    override fun toUni(d: X4DatatypesCommentReport): LemmyapiDatatypesCommentReport =
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

    override fun toUni(d: X4DatatypesCommentReportResponse): LemmyapiDatatypesCommentReportResponse =
        LemmyapiDatatypesCommentReportResponse(
            comment_report_view = this.toUni(d = d.comment_report_view),
        )

    override fun toUni(d: X4DatatypesCommentReportView): LemmyapiDatatypesCommentReportView =
        LemmyapiDatatypesCommentReportView(
            comment_report = this.toUni(d = d.comment_report),
            comment = this.toUni(d = d.comment, d.counts),
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            comment_creator = this.toUni(d = d.comment_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            resolver = d.resolver?.let { this.toUni(d = it) },
            creator_banned = d.creator.banned,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X4DatatypesCommentResponse): LemmyapiDatatypesCommentResponse =
        LemmyapiDatatypesCommentResponse(
            comment_view = this.toUni(d = d.comment_view),
        )

    override fun toUni(d: X4DatatypesCommentView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            post_tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    override fun toUni(d: X4DatatypesCommunity, counts: X4DatatypesCommunityAggregates): LemmyapiDatatypesCommunity =
        LemmyapiDatatypesCommunity(
            id = d.id,
            name = d.name,
            title = d.title,
            description = d.description,
            removed = d.removed,
            published_at = d.published,
            updated_at = d.updated,
            deleted = d.deleted,
            nsfw = d.nsfw,
            ap_id = d.actor_id,
            local = d.local,
            icon = d.icon,
            banner = d.banner,
            hidden = d.hidden,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            instance_id = d.instance_id,
            visibility = d.visibility,
            subscribers = counts.subscribers,
            posts = counts.posts,
            comments = counts.comments,
            users_active_day = counts.users_active_day,
            users_active_week = counts.users_active_week,
            users_active_month = counts.users_active_month,
            users_active_half_year = counts.users_active_half_year,
            subscribers_local = counts.subscribers_local,
            report_count = -1,
            unresolved_report_count = -1,
            local_removed = false,
        )

    override fun toUni(d: X4DatatypesCommunityFollowerView): LemmyapiDatatypesCommunityFollowerView =
        LemmyapiDatatypesCommunityFollowerView(
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            follower = this.toUni(d = d.follower),
        )

    override fun toUni(d: X4DatatypesCommunityModeratorView): LemmyapiDatatypesCommunityModeratorView =
        LemmyapiDatatypesCommunityModeratorView(
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            moderator = this.toUni(d = d.moderator),
        )

    override fun toUni(d: X4DatatypesCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X4DatatypesCommunityView): LemmyapiDatatypesCommunityView =
        LemmyapiDatatypesCommunityView(
            community = this.toUni(d = d.community, d.counts),
            can_mod = false,
            post_tags = emptyList(),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed), if (d.blocked) "" else null, null, if (d.banned_from_community) "" else null, if (d.banned_from_community) "" else null),
        )

    override fun toUni(d: X4DatatypesCustomEmoji): LemmyapiDatatypesCustomEmoji =
        LemmyapiDatatypesCustomEmoji(
            id = d.id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X4DatatypesCustomEmojiKeyword): LemmyapiDatatypesCustomEmojiKeyword =
        LemmyapiDatatypesCustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword,
        )

    override fun toUni(d: X4DatatypesCustomEmojiResponse): LemmyapiDatatypesCustomEmojiResponse =
        LemmyapiDatatypesCustomEmojiResponse(
            custom_emoji = this.toUni(d = d.custom_emoji),
        )

    override fun toUni(d: X4DatatypesCustomEmojiView): LemmyapiDatatypesCustomEmojiView =
        LemmyapiDatatypesCustomEmojiView(
            custom_emoji = this.toUni(d = d.custom_emoji),
            keywords = d.keywords.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesFederatedInstances): LemmyapiDatatypesFederatedInstances =
        LemmyapiDatatypesFederatedInstances(
            linked = d.linked.map { this.toUni(d = it) },
            allowed = d.allowed.map { this.toUni(d = it) },
            blocked = d.blocked.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesGenerateTotpSecretResponse): LemmyapiDatatypesGenerateTotpSecretResponse = LemmyapiDatatypesGenerateTotpSecretResponse(
        totp_secret_url = d.totp_secret_url,
    )

    override fun toUni(d: X4DatatypesGetCaptchaResponse): LemmyapiDatatypesGetCaptchaResponse =
        LemmyapiDatatypesGetCaptchaResponse(
            ok = d.ok?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesGetCommentsResponse): LemmyapiDatatypesGetCommentsResponse =
        LemmyapiDatatypesGetCommentsResponse(
            comments = d.comments.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesGetCommunityResponse): LemmyapiDatatypesGetCommunityResponse =
        LemmyapiDatatypesGetCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            site = d.site?.let { this.toUni(d = it) },
            moderators = d.moderators.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toUni(d: X4DatatypesGetFederatedInstancesResponse): LemmyapiDatatypesGetFederatedInstancesResponse =
        LemmyapiDatatypesGetFederatedInstancesResponse(
            federated_instances = d.federated_instances?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesGetModlogResponse): LemmyapiDatatypesGetModlogResponse {
        val modlogList = mutableListOf<it.vercruysse.lemmyapi.datatypes.ModlogCombinedView>()

        // Add ModRemovePost entries
        modlogList.addAll(
            d.removed_posts.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModRemovePost(mod_remove_post = this.toUni(d = view))
            },
        )

        // Add ModLockPost entries
        modlogList.addAll(
            d.locked_posts.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModLockPost(mod_lock_post = this.toUni(d = view))
            },
        )

        // Add ModFeaturePost entries
        modlogList.addAll(
            d.featured_posts.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModFeaturePost(mod_feature_post = this.toUni(d = view))
            },
        )

        // Add ModRemoveComment entries
        modlogList.addAll(
            d.removed_comments.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModRemoveComment(mod_remove_comment = this.toUni(d = view))
            },
        )

        // Add ModRemoveCommunity entries
        modlogList.addAll(
            d.removed_communities.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminRemoveCommunity(admin_remove_community = this.toUni(d = view))
            },
        )

        // Add ModBanFromCommunity entries
        modlogList.addAll(
            d.banned_from_community.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModBanFromCommunity(mod_ban_from_community = this.toUni(d = view))
            },
        )

        // Add ModBan entries
        modlogList.addAll(
            d.banned.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminBan(admin_ban = this.toUni(d = view))
            },
        )

        // Add ModAddCommunity entries
        modlogList.addAll(
            d.added_to_community.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModAddToCommunity(mod_add_to_community = this.toUni(d = view))
            },
        )

        // Add ModTransferCommunity entries
        modlogList.addAll(
            d.transferred_to_community.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModTransferCommunity(mod_transfer_community = this.toUni(d = view))
            },
        )

        // Add ModAdd entries
        modlogList.addAll(
            d.added.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminAdd(admin_add = this.toUni(d = view))
            },
        )

        // Add AdminPurgePerson entries
        modlogList.addAll(
            d.admin_purged_persons.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminPurgePerson(admin_purge_person = this.toUni(d = view))
            },
        )

        // Add AdminPurgeCommunity entries
        modlogList.addAll(
            d.admin_purged_communities.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminPurgeCommunity(admin_purge_community = this.toUni(d = view))
            },
        )

        // Add AdminPurgePost entries
        modlogList.addAll(
            d.admin_purged_posts.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminPurgePost(admin_purge_post = this.toUni(d = view))
            },
        )

        // Add AdminPurgeComment entries
        modlogList.addAll(
            d.admin_purged_comments.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.AdminPurgeComment(admin_purge_comment = this.toUni(d = view))
            },
        )

        // Add ModHideCommunity entries (mapped to ModChangeCommunityVisibility)
        modlogList.addAll(
            d.hidden_communities.map { view ->
                it.vercruysse.lemmyapi.datatypes.ModlogCombinedView.ModChangeCommunityVisibility(mod_change_community_visibility = this.toUni(d = view))
            },
        )

        return it.vercruysse.lemmyapi.datatypes.GetModlogResponse(
            modlog = modlogList,
            next_page = null,
            prev_page = null,
        )
    }

    override fun toUni(d: X4DatatypesGetPersonDetailsResponse): LemmyapiDatatypesGetPersonDetailsResponse = LemmyapiDatatypesGetPersonDetailsResponse(
        person_view = this.toUni(d = d.person_view),
        site = d.site?.let { this.toUni(d = it) },
        comments = d.comments.map { this.toUni(d = it) },
        posts = d.posts.map { this.toUni(d = it) },
        moderates = d.moderates.map { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesGetPostResponse): LemmyapiDatatypesGetPostResponse =
        LemmyapiDatatypesGetPostResponse(
            post_view = this.toUni(d = d.post_view),
            community_view = this.toUni(d = d.community_view),
            moderators = d.moderators.map { this.toUni(d = it) },
            cross_posts = d.cross_posts.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesGetPostsResponse): LemmyapiDatatypesGetPostsResponse =
        LemmyapiDatatypesGetPostsResponse(
            posts = d.posts.map { this.toUni(d = it) },
            next_page = d.next_page,
        )

    fun toUni(d: X4DatatypesGetRepliesResponse): LemmyapiDatatypesListNotificationsResponse =
        ListNotificationsResponse(
            notifications = d.replies.map { this.toUni(d = it) },
        )

    fun toUni(d: X4DatatypesCommentReplyView): NotificationView =
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
            data = NotificationData.Comment(
                comment = this.toUniCV(d),
            ),
        )

    fun toUniCV(d: X4DatatypesCommentReplyView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            post_tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUni(d: X4DatatypesGetPersonMentionsResponse): LemmyapiDatatypesListNotificationsResponse =
        LemmyapiDatatypesListNotificationsResponse(
            notifications = d.mentions.map { this.toUni(d = it) },
        )

    fun toUni(d: X4DatatypesPersonMentionView): NotificationView =
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
            data = NotificationData.Comment(
                comment = this.toUniPV(d),
            ),
        )

    fun toUniPV(d: X4DatatypesPersonMentionView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment, d.counts),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
            post_tags = emptyList(),
            creator_banned = d.creator.banned,
            creator_ban_expires_at = d.creator.ban_expires,
            can_mod = false,
            person_actions = PersonActions(if (d.creator_blocked) "" else null),
            comment_actions = CommentActions(d.my_vote, null, if (d.saved) "" else null),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
        )

    fun toUni(d: X4DatatypesPrivateMessagesResponse): LemmyapiDatatypesListNotificationsResponse =
        LemmyapiDatatypesListNotificationsResponse(
            notifications = d.private_messages.map { this.toUniPMV(d = it) },
        )

    fun toUniPMV(d: X4DatatypesPrivateMessageView): NotificationView =
        NotificationView(
            notification = Notification(
                id = d.private_message.id,
                recipient_id = d.private_message.recipient_id,
                read = d.private_message.read,
                published_at = d.private_message.published,
                kind = NotificationType.PrivateMessage,
            ),
            data = NotificationData.PrivateMessage(
                private_message = this.toUni(d),
            ),
        )

    override fun toUni(d: X4DatatypesGetReportCountResponse): LemmyapiDatatypesGetReportCountResponse =
        LemmyapiDatatypesGetReportCountResponse(
            count = d.post_reports + d.comment_reports + (d.private_message_reports ?: 0),
        )

    override fun toUni(d: X4DatatypesGetSiteMetadataResponse): LemmyapiDatatypesGetSiteMetadataResponse = LemmyapiDatatypesGetSiteMetadataResponse(
        metadata = this.toUni(d = d.metadata),
    )

    override fun toUni(d: X4DatatypesGetSiteResponse): LemmyapiDatatypesGetSiteResponse =
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

    override fun toUni(d: X4DatatypesGetUnreadCountResponse): LemmyapiDatatypesGetUnreadCountResponse =
        LemmyapiDatatypesGetUnreadCountResponse(
            count = d.replies + d.mentions + d.private_messages,
        )

    override fun toUni(d: X4DatatypesGetUnreadRegistrationApplicationCountResponse): LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse =
        LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse(
            registration_applications = d.registration_applications,
        )

    override fun toUni(d: X4DatatypesInstance): LemmyapiDatatypesInstance = LemmyapiDatatypesInstance(
        id = d.id,
        domain = d.domain,
        published_at = d.published,
        updated_at = d.updated,
        software = d.software,
        version = d.version,
    )

    override fun toUni(d: X4DatatypesInstanceWithFederationState): LemmyapiDatatypesInstanceWithFederationState = LemmyapiDatatypesInstanceWithFederationState(
        id = d.id,
        domain = d.domain,
        published_at = d.published,
        updated_at = d.updated,
        software = d.software,
        version = d.version,
        federation_state = d.federation_state?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesLanguage): LemmyapiDatatypesLanguage = LemmyapiDatatypesLanguage(
        id = d.id,
        code = d.code,
        name = d.name,
    )

    override fun toUni(d: X4DatatypesLinkMetadata): LemmyapiDatatypesLinkMetadata =
        LemmyapiDatatypesLinkMetadata(
            title = d.title,
            description = d.description,
            image = d.image,
            embed_video_url = d.embed_video_url,
            content_type = d.content_type,
        )

    override fun toUni(d: X4DatatypesListCommentLikesResponse): LemmyapiDatatypesListCommentLikesResponse = LemmyapiDatatypesListCommentLikesResponse(
        comment_likes = d.comment_likes.map { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesListCommunitiesResponse): LemmyapiDatatypesListCommunitiesResponse = LemmyapiDatatypesListCommunitiesResponse(
        communities = d.communities.map { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesListMediaResponse): LemmyapiDatatypesListMediaResponse =
        LemmyapiDatatypesListMediaResponse(
            images = d.images.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesListPostLikesResponse): LemmyapiDatatypesListPostLikesResponse =
        LemmyapiDatatypesListPostLikesResponse(
            post_likes = d.post_likes.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesListRegistrationApplicationsResponse): LemmyapiDatatypesListRegistrationApplicationsResponse =
        LemmyapiDatatypesListRegistrationApplicationsResponse(
            registration_applications = d.registration_applications.map { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesLocalImage): LemmyapiDatatypesLocalImage =
        LemmyapiDatatypesLocalImage(
            person_id = d.local_user_id,
            pictrs_alias = d.pictrs_alias,
            pictrs_delete_token = d.pictrs_delete_token,
            published_at = d.published,
        )

    override fun toUni(d: X4DatatypesLocalImageView): LemmyapiDatatypesLocalImageView =
        LemmyapiDatatypesLocalImageView(
            local_image = this.toUni(d = d.local_image),
            person = this.toUni(d = d.person),
        )

    override fun toUni(d: X4DatatypesLocalSite, counts: X4DatatypesSiteAggregates): LemmyapiDatatypesLocalSite =
        LemmyapiDatatypesLocalSite(
            id = d.id,
            site_id = d.site_id,
            site_setup = d.site_setup,
            community_creation_admin_only = d.community_creation_admin_only,
            require_email_verification = d.require_email_verification,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = d.default_post_listing_type,
            legal_information = d.legal_information,
            application_email_admins = d.application_email_admins,
            slur_filter_regex = d.slur_filter_regex,
            federation_enabled = d.federation_enabled,
            captcha_enabled = d.captcha_enabled,
            captcha_difficulty = d.captcha_difficulty,
            published_at = d.published,
            updated_at = d.updated,
            registration_mode = d.registration_mode,
            reports_email_admins = d.reports_email_admins,
            federation_signed_fetch = d.federation_signed_fetch,
            default_post_listing_mode = d.default_post_listing_mode,
            default_sort_type = d.default_sort_type,
            disallow_nsfw_content = !d.enable_nsfw,
            oauth_registration = false,
            disable_email_notifications = false,
            suggested_communities = null,
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

    override fun toUni(d: X4DatatypesLocalSiteRateLimit): LemmyapiDatatypesLocalSiteRateLimit =
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

    override fun toUni(d: X4DatatypesLocalSiteUrlBlocklist): LemmyapiDatatypesLocalSiteUrlBlocklist =
        LemmyapiDatatypesLocalSiteUrlBlocklist(
            id = d.id,
            url = d.url,
            published_at = d.published,
            updated_at = d.updated,
        )

    override fun toUni(d: X4DatatypesLocalUser, e: X4DatatypesLocalUserVoteDisplayMode): LemmyapiDatatypesLocalUser =
        LemmyapiDatatypesLocalUser(
            id = d.id,
            person_id = d.person_id,
            email = d.email,
            show_nsfw = d.show_nsfw,
            theme = d.theme,
            default_post_sort_type = d.default_sort_type,
            default_listing_type = d.default_listing_type,
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
            post_listing_mode = d.post_listing_mode,
            totp_2fa_enabled = d.totp_2fa_enabled,
            enable_keyboard_navigation = d.enable_keyboard_navigation,
            enable_animated_images = d.enable_animated_images,
            collapse_bot_comments = d.collapse_bot_comments,
            last_donation_notification_at = "",
            show_score = e.score,
            show_upvotes = e.upvotes,
            show_person_votes = e.score,
            show_upvote_percentage = e.upvote_percentage,
            show_downvotes = if (e.downvotes) VoteShow.Show else VoteShow.Hide,
            hide_media = false,
            enable_private_messages = true,
            default_comment_sort_type = SortType.Active,
            auto_mark_fetched_posts_as_read = false,
            default_post_time_range_seconds = null,
            default_items_per_page = 20,

        )

    override fun toUni(d: X4DatatypesLocalUserView): LemmyapiDatatypesLocalUserView =
        LemmyapiDatatypesLocalUserView(
            local_user = this.toUni(d = d.local_user, d.local_user_vote_display_mode),
            person = this.toUni(d = d.person, d.counts),
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,
        )

    override fun toUni(d: X4DatatypesLoginToken): LemmyapiDatatypesLoginToken =
        LemmyapiDatatypesLoginToken(
            user_id = d.user_id,
            published_at = d.published,
            ip = d.ip,
            user_agent = d.user_agent,
        )

    override fun toUni(d: X4DatatypesLoginResponse): LemmyapiDatatypesLoginResponse =
        LemmyapiDatatypesLoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent,
        )

    override fun toUni(d: X4DatatypesModAdd): LemmyapiDatatypesModAdd = LemmyapiDatatypesModAdd(
        id = d.id,
        mod_person_id = d.mod_person_id,
        other_person_id = d.other_person_id,
        removed = d.removed,
        published_at = d.when_,
    )

    override fun toUni(d: X4DatatypesModAddCommunity): LemmyapiDatatypesModAddCommunity =
        LemmyapiDatatypesModAddCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            removed = d.removed,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModAddCommunityView): LemmyapiDatatypesModAddCommunityView =
        LemmyapiDatatypesModAddCommunityView(
            mod_add_to_community = this.toUni(d = d.mod_add_community),
            moderator = d.moderator?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            other_person = this.toUni(d = d.modded_person),
        )

    override fun toUni(d: X4DatatypesModAddView): LemmyapiDatatypesModAddView =
        LemmyapiDatatypesModAddView(
            admin_add = this.toUni(d = d.mod_add),
            moderator = d.moderator?.let { this.toUni(d = it) },
            other_person = this.toUni(d = d.modded_person),
        )

    override fun toUni(d: X4DatatypesModBan): LemmyapiDatatypesModBan = LemmyapiDatatypesModBan(
        id = d.id,
        mod_person_id = d.mod_person_id,
        other_person_id = d.other_person_id,
        reason = d.reason,
        banned = d.banned,
        expires_at = d.expires,
        published_at = d.when_,
        instance_id = -1,
    )

    override fun toUni(d: X4DatatypesModBanFromCommunity): LemmyapiDatatypesModBanFromCommunity =
        LemmyapiDatatypesModBanFromCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            reason = d.reason ?: "",
            banned = d.banned,
            expires_at = d.expires,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModBanFromCommunityView): LemmyapiDatatypesModBanFromCommunityView = LemmyapiDatatypesModBanFromCommunityView(
        mod_ban_from_community = this.toUni(d = d.mod_ban_from_community),
        moderator = d.moderator?.let { this.toUni(d = it) },
        community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        other_person = this.toUni(d = d.banned_person),
    )

    override fun toUni(d: X4DatatypesModBanView): LemmyapiDatatypesModBanView =
        LemmyapiDatatypesModBanView(
            admin_ban = this.toUni(d = d.mod_ban),
            moderator = d.moderator?.let { this.toUni(d = it) },
            other_person = this.toUni(d = d.banned_person),
        )

    override fun toUni(d: X4DatatypesModFeaturePost): LemmyapiDatatypesModFeaturePost =
        LemmyapiDatatypesModFeaturePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            featured = d.featured,
            published_at = d.when_,
            is_featured_community = d.is_featured_community,
        )

    override fun toUni(d: X4DatatypesModFeaturePostView): LemmyapiDatatypesModFeaturePostView =
        LemmyapiDatatypesModFeaturePostView(
            mod_feature_post = this.toUni(d = d.mod_feature_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModHideCommunity): LemmyapiDatatypesModChangeCommunityVisibility =
        LemmyapiDatatypesModChangeCommunityVisibility(
            id = d.id,
            community_id = d.community_id,
            mod_person_id = d.mod_person_id,
            published_at = d.when_,
            reason = d.reason,
            visibility = if (d.hidden) {
                it.vercruysse.lemmyapi.dto.CommunityVisibility.Unlisted
            } else {
                it.vercruysse.lemmyapi.dto.CommunityVisibility.Public
            },
        )

    override fun toUni(d: X4DatatypesModHideCommunityView): LemmyapiDatatypesModChangeCommunityVisibilityView =
        LemmyapiDatatypesModChangeCommunityVisibilityView(
            mod_change_community_visibility = this.toUni(d = d.mod_hide_community),
            moderator = d.admin?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModLockPost): LemmyapiDatatypesModLockPost =
        LemmyapiDatatypesModLockPost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            locked = d.locked,
            published_at = d.when_,
            reason = "",
        )

    override fun toUni(d: X4DatatypesModLockPostView): LemmyapiDatatypesModLockPostView =
        LemmyapiDatatypesModLockPostView(
            mod_lock_post = this.toUni(d = d.mod_lock_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModRemoveComment): LemmyapiDatatypesModRemoveComment =
        LemmyapiDatatypesModRemoveComment(
            id = d.id,
            mod_person_id = d.mod_person_id,
            comment_id = d.comment_id,
            reason = d.reason ?: "",
            removed = d.removed,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModRemoveCommentView): LemmyapiDatatypesModRemoveCommentView =
        LemmyapiDatatypesModRemoveCommentView(
            mod_remove_comment = this.toUni(d = d.mod_remove_comment),
            moderator = d.moderator?.let { this.toUni(d = it) },
            comment = this.toUni(d = d.comment, X4DatatypesCommentAggregates(-1, -1, -1, -1, "", -1)),
            other_person = this.toUni(d = d.commenter),
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModRemoveCommunity): LemmyapiDatatypesModRemoveCommunity =
        LemmyapiDatatypesModRemoveCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            community_id = d.community_id,
            reason = d.reason,
            removed = d.removed,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModRemoveCommunityView): LemmyapiDatatypesModRemoveCommunityView =
        LemmyapiDatatypesModRemoveCommunityView(
            admin_remove_community = this.toUni(d = d.mod_remove_community),
            moderator = d.moderator?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModRemovePost): LemmyapiDatatypesModRemovePost =
        LemmyapiDatatypesModRemovePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            reason = d.reason ?: "",
            removed = d.removed,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModRemovePostView): LemmyapiDatatypesModRemovePostView =
        LemmyapiDatatypesModRemovePostView(
            mod_remove_post = this.toUni(d = d.mod_remove_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post, counts = X4DatatypesPostAggregates(-1, -1, -1, -1, -1, "", "")),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        )

    override fun toUni(d: X4DatatypesModTransferCommunity): LemmyapiDatatypesModTransferCommunity =
        LemmyapiDatatypesModTransferCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            published_at = d.when_,
        )

    override fun toUni(d: X4DatatypesModTransferCommunityView): LemmyapiDatatypesModTransferCommunityView = LemmyapiDatatypesModTransferCommunityView(
        mod_transfer_community = this.toUni(d = d.mod_transfer_community),
        moderator = d.moderator?.let { this.toUni(d = it) },
        community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        other_person = this.toUni(d = d.modded_person),
    )

    override fun toUni(d: X4DatatypesMyUserInfo): LemmyapiDatatypesMyUserInfo =
        LemmyapiDatatypesMyUserInfo(
            local_user_view = this.toUni(d = d.local_user_view),
            follows = d.follows.map { this.toUni(d = it) },
            moderates = d.moderates.map { this.toUni(d = it) },
            community_blocks = d.community_blocks.map { this.toUni(d = it.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)) },
            instance_community_blocks = d.instance_blocks.map { this.toUni(d = it.instance) },
            instance_person_blocks = emptyList(),
            person_blocks = d.person_blocks.map { this.toUni(d = it.target) },
            discussion_languages = d.discussion_languages,
        )

    fun toUni(d: X4DatatypesPerson) = this.toUni(d, X4DatatypesPersonAggregates(-1, -1, -1))

    override fun toUni(d: X4DatatypesPerson, counts: X4DatatypesPersonAggregates): LemmyapiDatatypesPerson = LemmyapiDatatypesPerson(
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
    )

    override fun toUni(d: X4DatatypesPersonView): LemmyapiDatatypesPersonView =
        LemmyapiDatatypesPersonView(
            person = this.toUni(d = d.person, d.counts),
            is_admin = d.is_admin,
            person_actions = null,
            banned = d.person.banned,
            ban_expires_at = d.person.ban_expires,
        )

    override fun toUni(d: X4DatatypesPost, counts: X4DatatypesPostAggregates): LemmyapiDatatypesPost = LemmyapiDatatypesPost(
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

    override fun toUni(d: X4DatatypesPostReport): LemmyapiDatatypesPostReport =
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

    override fun toUni(d: X4DatatypesPostReportResponse): LemmyapiDatatypesPostReportResponse =
        LemmyapiDatatypesPostReportResponse(
            post_report_view = this.toUni(d = d.post_report_view),
        )

    override fun toUni(d: X4DatatypesPostReportView): LemmyapiDatatypesPostReportView =
        LemmyapiDatatypesPostReportView(
            post_report = this.toUni(d = d.post_report),
            post = this.toUni(d = d.post, d.counts),
            community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
            creator = this.toUni(d = d.creator),
            post_creator = this.toUni(d = d.post_creator),
            post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, d.my_vote, toAt(d.hidden)),
            person_actions = PersonActions(toAt(d.creator_blocked)),
            community_actions = CommunityActions(null, CommunityFollowerState.from(d.subscribed)),
            resolver = d.resolver?.let { this.toUni(d = it) },
            creator_banned_from_community = d.creator_banned_from_community,
            creator_banned = d.creator.banned,
            creator_is_moderator = d.creator_is_moderator,
            creator_is_admin = d.creator_is_admin,
        )

    override fun toUni(d: X4DatatypesPostResponse): LemmyapiDatatypesPostResponse =
        LemmyapiDatatypesPostResponse(
            post_view = this.toUni(d = d.post_view),
        )

    override fun toUni(d: X4DatatypesPostView): LemmyapiDatatypesPostView = LemmyapiDatatypesPostView(
        post = this.toUni(d = d.post, d.counts),
        creator = this.toUni(d = d.creator),
        community = this.toUni(d = d.community, counts = X4DatatypesCommunityAggregates(-1, -1, -1, -1, "", -1, -1, -1, -1, -1)),
        post_actions = PostActions(toAt(d.read), null, d.counts.comments - d.unread_comments, toAt(d.saved), null, d.my_vote, toAt(d.hidden)),
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

    override fun toUni(d: X4DatatypesPrivateMessage): LemmyapiDatatypesPrivateMessage =
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

    override fun toUni(d: X4DatatypesPrivateMessageReport): LemmyapiDatatypesPrivateMessageReport =
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

    override fun toUni(d: X4DatatypesPrivateMessageReportResponse): LemmyapiDatatypesPrivateMessageReportResponse = LemmyapiDatatypesPrivateMessageReportResponse(
        private_message_report_view = this.toUni(d = d.private_message_report_view),
    )

    override fun toUni(d: X4DatatypesPrivateMessageReportView): LemmyapiDatatypesPrivateMessageReportView = LemmyapiDatatypesPrivateMessageReportView(
        private_message_report = this.toUni(d = d.private_message_report),
        private_message = this.toUni(d = d.private_message),
        private_message_creator = this.toUni(d = d.private_message_creator),
        creator = this.toUni(d = d.creator),
        resolver = d.resolver?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesPrivateMessageResponse): LemmyapiDatatypesPrivateMessageResponse =
        LemmyapiDatatypesPrivateMessageResponse(
            private_message_view = this.toUni(d = d.private_message_view),
        )

    override fun toUni(d: X4DatatypesPrivateMessageView): LemmyapiDatatypesPrivateMessageView =
        LemmyapiDatatypesPrivateMessageView(
            private_message = this.toUni(d = d.private_message),
            creator = this.toUni(d = d.creator),
            recipient = this.toUni(d = d.recipient),
        )

    override fun toUni(d: X4DatatypesReadableFederationState): LemmyapiDatatypesReadableFederationState = LemmyapiDatatypesReadableFederationState(
        instance_id = d.instance_id,
        last_successful_id = d.last_successful_id,
        last_successful_published_time_at = d.last_successful_published_time,
        fail_count = d.fail_count,
        last_retry_at = d.last_retry,
        next_retry_at = d.next_retry,
    )

    override fun toUni(d: X4DatatypesRegistrationApplication): LemmyapiDatatypesRegistrationApplication = LemmyapiDatatypesRegistrationApplication(
        id = d.id,
        local_user_id = d.local_user_id,
        answer = d.answer,
        admin_id = d.admin_id,
        deny_reason = d.deny_reason,
        published_at = d.published,
    )

    override fun toUni(d: X4DatatypesRegistrationApplicationResponse): LemmyapiDatatypesRegistrationApplicationResponse =
        LemmyapiDatatypesRegistrationApplicationResponse(
            registration_application = this.toUni(d = d.registration_application),
        )

    override fun toUni(d: X4DatatypesRegistrationApplicationView): LemmyapiDatatypesRegistrationApplicationView = LemmyapiDatatypesRegistrationApplicationView(
        registration_application = this.toUni(d = d.registration_application),
        creator_local_user = this.toUni(d = d.creator_local_user, e = X4DatatypesLocalUserVoteDisplayMode(-1, true, true, true, true)),
        creator = this.toUni(d = d.creator),
        admin = d.admin?.let { this.toUni(d = it) },
    )

    override fun toUni(d: X4DatatypesResolveObjectResponse): LemmyapiDatatypesResolveObjectResponse =
        LemmyapiDatatypesResolveObjectResponse(
            comment = d.comment?.let { this.toUni(d = it) },
            post = d.post?.let { this.toUni(d = it) },
            community = d.community?.let { this.toUni(d = it) },
            person = d.person?.let { this.toUni(d = it) },
        )

    override fun toUni(d: X4DatatypesSearchResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            results = buildList {
                addAll(d.comments.map { LemmyapiDatatypesSearchCombinedView.Comment(comment = this@Transformer.toUni(d = it)) })
                addAll(d.posts.map { LemmyapiDatatypesSearchCombinedView.Post(post = this@Transformer.toUni(d = it)) })
                addAll(d.communities.map { LemmyapiDatatypesSearchCombinedView.Community(community = this@Transformer.toUni(d = it)) })
                addAll(d.users.map { LemmyapiDatatypesSearchCombinedView.Person(person = this@Transformer.toUni(d = it)) })
            },
        )

    override fun toUni(d: X4DatatypesSite): LemmyapiDatatypesSite = LemmyapiDatatypesSite(
        id = d.id,
        name = d.name,
        sidebar = d.sidebar,
        published_at = d.published,
        updated_at = d.updated,
        icon = d.icon,
        banner = d.banner,
        description = d.description,
        ap_id = d.actor_id,
        last_refreshed_at = d.last_refreshed_at,
        inbox_url = d.inbox_url,
        instance_id = d.instance_id,
        content_warning = d.content_warning,
    )

    override fun toUni(d: X4DatatypesSiteResponse): LemmyapiDatatypesSiteResponse =
        LemmyapiDatatypesSiteResponse(
            site_view = this.toUni(d = d.site_view),
        )

    override fun toUni(d: X4DatatypesSiteView): LemmyapiDatatypesSiteView = LemmyapiDatatypesSiteView(
        site = this.toUni(d = d.site),
        local_site = this.toUni(d = d.local_site, counts = d.counts),
        local_site_rate_limit = this.toUni(d = d.local_site_rate_limit),
        instance = null,
    )

    override fun toUni(d: X4DatatypesTagline): LemmyapiDatatypesTagline = LemmyapiDatatypesTagline(
        id = d.id,
        content = d.content,
        published_at = d.published,
        updated_at = d.updated,
    )

    override fun toUni(d: X4DatatypesUpdateTotpResponse): LemmyapiDatatypesUpdateTotpResponse =
        LemmyapiDatatypesUpdateTotpResponse(
            enabled = d.enabled,
        )

    override fun toUni(d: X4DatatypesVoteView): LemmyapiDatatypesVoteView = LemmyapiDatatypesVoteView(
        creator = this.toUni(d = d.creator),
        creator_banned = d.creator.banned,
        creator_banned_from_community = d.creator_banned_from_community,
        score = d.score,
    )

    override fun fromUni(d: LemmyapiDatatypesAddAdmin): X4DatatypesAddAdmin = X4DatatypesAddAdmin(
        person_id = d.person_id,
        added = d.added,
    )

    override fun fromUni(d: LemmyapiDatatypesAddModToCommunity): X4DatatypesAddModToCommunity =
        X4DatatypesAddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
        )

    override fun fromUni(d: LemmyapiDatatypesApproveRegistrationApplication): X4DatatypesApproveRegistrationApplication = X4DatatypesApproveRegistrationApplication(
        id = d.id,
        approve = d.approve,
        deny_reason = d.deny_reason,
    )

    override fun fromUni(d: LemmyapiDatatypesBanFromCommunity): X4DatatypesBanFromCommunity =
        X4DatatypesBanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_or_restore_data,
            reason = d.reason,
            expires = d.expires_at,
        )

    override fun fromUni(d: LemmyapiDatatypesBanPerson): X4DatatypesBanPerson = X4DatatypesBanPerson(
        person_id = d.person_id,
        ban = d.ban,
        remove_data = d.remove_or_restore_data,
        reason = d.reason,
        expires = d.expires_at,
    )

    override fun fromUni(d: LemmyapiDatatypesBlockCommunity): X4DatatypesBlockCommunity =
        X4DatatypesBlockCommunity(
            community_id = d.community_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockInstance): X4DatatypesBlockInstance =
        X4DatatypesBlockInstance(
            instance_id = d.instance_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesBlockPerson): X4DatatypesBlockPerson =
        X4DatatypesBlockPerson(
            person_id = d.person_id,
            block = d.block,
        )

    override fun fromUni(d: LemmyapiDatatypesChangePassword): X4DatatypesChangePassword =
        X4DatatypesChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateComment): X4DatatypesCreateComment =
        X4DatatypesCreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentLike): X4DatatypesCreateCommentLike =
        X4DatatypesCreateCommentLike(
            comment_id = d.comment_id,
            score = d.score,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentReport): X4DatatypesCreateCommentReport =
        X4DatatypesCreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommunity): X4DatatypesCreateCommunity =
        X4DatatypesCreateCommunity(
            name = d.name,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            visibility = d.visibility,
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCustomEmoji): X4DatatypesCreateCustomEmoji =
        X4DatatypesCreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePost): X4DatatypesCreatePost =
        X4DatatypesCreatePost(
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

    override fun fromUni(d: LemmyapiDatatypesCreatePostLike): X4DatatypesCreatePostLike =
        X4DatatypesCreatePostLike(
            post_id = d.post_id,
            score = d.score,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostReport): X4DatatypesCreatePostReport =
        X4DatatypesCreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessage): X4DatatypesCreatePrivateMessage =
        X4DatatypesCreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessageReport): X4DatatypesCreatePrivateMessageReport = X4DatatypesCreatePrivateMessageReport(
        private_message_id = d.private_message_id,
        reason = d.reason,
    )

    override fun fromUni(d: LemmyapiDatatypesCreateSite): X4DatatypesCreateSite =
        X4DatatypesCreateSite(
            name = d.name,
            sidebar = d.sidebar,
            description = d.description,
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
            default_post_listing_type = d.default_post_listing_type,
            default_sort_type = d.default_post_sort_type,
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
            registration_mode = d.registration_mode,
            content_warning = d.content_warning,
            default_post_listing_mode = d.default_post_listing_mode,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteAccount): X4DatatypesDeleteAccount =
        X4DatatypesDeleteAccount(
            password = d.password,
            delete_content = d.delete_content,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteComment): X4DatatypesDeleteComment =
        X4DatatypesDeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCommunity): X4DatatypesDeleteCommunity =
        X4DatatypesDeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCustomEmoji): X4DatatypesDeleteCustomEmoji =
        X4DatatypesDeleteCustomEmoji(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePost): X4DatatypesDeletePost =
        X4DatatypesDeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePrivateMessage): X4DatatypesDeletePrivateMessage =
        X4DatatypesDeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
        )

    override fun fromUni(d: LemmyapiDatatypesDistinguishComment): X4DatatypesDistinguishComment =
        X4DatatypesDistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
        )

    override fun fromUni(d: LemmyapiDatatypesEditComment): X4DatatypesEditComment =
        X4DatatypesEditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCommunity): X4DatatypesEditCommunity =
        X4DatatypesEditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            visibility = d.visibility,
        )

    override fun fromUni(d: LemmyapiDatatypesEditCustomEmoji): X4DatatypesEditCustomEmoji =
        X4DatatypesEditCustomEmoji(
            id = d.id,
            category = d.category,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
        )

    override fun fromUni(d: LemmyapiDatatypesEditPost): X4DatatypesEditPost = X4DatatypesEditPost(
        post_id = d.post_id,
        name = d.name,
        url = d.url,
        body = d.body,
        alt_text = d.alt_text,
        nsfw = d.nsfw,
        language_id = d.language_id,
        custom_thumbnail = d.custom_thumbnail,
    )

    override fun fromUni(d: LemmyapiDatatypesEditPrivateMessage): X4DatatypesEditPrivateMessage =
        X4DatatypesEditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
        )

    override fun fromUni(d: LemmyapiDatatypesEditSite): X4DatatypesEditSite = X4DatatypesEditSite(
        name = d.name,
        sidebar = d.sidebar,
        description = d.description,
        icon = d.icon,
        banner = d.banner,
        enable_downvotes = d.enable_downvotes,
        enable_nsfw = d.enable_nsfw,
        community_creation_admin_only = d.community_creation_admin_only,
        require_email_verification = d.require_email_verification,
        application_question = d.application_question,
        private_instance = d.private_instance,
        default_theme = d.default_theme,
        default_post_listing_type = d.default_post_listing_type,
        default_sort_type = d.default_sort_type,
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
        registration_mode = d.registration_mode,
        reports_email_admins = d.reports_email_admins,
        content_warning = d.content_warning,
        default_post_listing_mode = d.default_post_listing_mode,
    )

    override fun fromUni(d: LemmyapiDatatypesFeaturePost): X4DatatypesFeaturePost =
        X4DatatypesFeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = d.feature_type,
        )

    override fun fromUni(d: LemmyapiDatatypesFollowCommunity): X4DatatypesFollowCommunity =
        X4DatatypesFollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComment): X4DatatypesGetComment =
        X4DatatypesGetComment(
            id = d.id,
        )

    override fun fromUni(d: LemmyapiDatatypesGetComments): X4DatatypesGetComments =
        X4DatatypesGetComments(
            type_ = d.type_,
            sort = d.sort,
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

    override fun fromUni(d: LemmyapiDatatypesGetCommunity): X4DatatypesGetCommunity =
        X4DatatypesGetCommunity(
            id = d.id,
            name = d.name,
        )

    override fun fromUni(d: LemmyapiDatatypesGetModlog): X4DatatypesGetModlog = X4DatatypesGetModlog(
        mod_person_id = d.mod_person_id,
        community_id = d.community_id,
        page = d.page,
        limit = d.limit,
        type_ = d.type_,
        other_person_id = d.other_person_id,
        post_id = d.post_id,
        comment_id = d.comment_id,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPersonDetails): X4DatatypesGetPersonDetails =
        X4DatatypesGetPersonDetails(
            person_id = d.person_id,
            username = d.username,
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            community_id = d.community_id,
            saved_only = d.saved_only,
        )

    override fun fromUni(d: LemmyapiDatatypesGetPost): X4DatatypesGetPost = X4DatatypesGetPost(
        id = d.id,
        comment_id = d.comment_id,
    )

    override fun fromUni(d: LemmyapiDatatypesGetPosts): X4DatatypesGetPosts = X4DatatypesGetPosts(
        type_ = d.type_,
        sort = d.sort,
        page = d.page,
        limit = d.limit,
        community_id = d.community_id,
        community_name = d.community_name,
        show_hidden = d.show_hidden,
        page_cursor = d.page_cursor,
    )

    fun fromUniR(d: LemmyapiDatatypesListNotifications): X4DatatypesGetReplies =
        X4DatatypesGetReplies(
            sort = CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniM(d: LemmyapiDatatypesListNotifications): X4DatatypesGetPersonMentions =
        X4DatatypesGetPersonMentions(
            sort = CommentSortType.New,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    fun fromUniP(d: LemmyapiDatatypesListNotifications): X4DatatypesGetPrivateMessages =
        X4DatatypesGetPrivateMessages(
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
        )

    override fun fromUni(d: LemmyapiDatatypesGetReportCount): X4DatatypesGetReportCount =
        X4DatatypesGetReportCount(
            community_id = d.community_id,
        )

    override fun fromUni(d: LemmyapiDatatypesGetSiteMetadata): X4DatatypesGetSiteMetadata =
        X4DatatypesGetSiteMetadata(
            url = d.url,
        )

    override fun fromUni(d: LemmyapiDatatypesHideCommunity): X4DatatypesHideCommunity =
        X4DatatypesHideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
        )

    override fun fromUniC(d: it.vercruysse.lemmyapi.datatypes.ListReports): X4DatatypesListCommentReports =
        X4DatatypesListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
        )

    override fun fromUniP(d: it.vercruysse.lemmyapi.datatypes.ListReports): X4DatatypesListPostReports =
        X4DatatypesListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
        )

    override fun fromUniPm(d: it.vercruysse.lemmyapi.datatypes.ListReports): X4DatatypesListPrivateMessageReports =
        X4DatatypesListPrivateMessageReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
        )

    override fun fromUni(d: LemmyapiDatatypesHidePost): X4DatatypesHidePost = X4DatatypesHidePost(
        post_ids = d.post_ids,
        hide = d.hide,
    )

    override fun fromUni(d: LemmyapiDatatypesListCommentLikes): X4DatatypesListCommentLikes =
        X4DatatypesListCommentLikes(
            comment_id = d.comment_id,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListCommunities): X4DatatypesListCommunities =
        X4DatatypesListCommunities(
            type_ = d.type_,
            sort = d.sort,
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListMedia): X4DatatypesListMedia = X4DatatypesListMedia(
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesListPostLikes): X4DatatypesListPostLikes =
        X4DatatypesListPostLikes(
            post_id = d.post_id,
            page = d.page,
            limit = d.limit,
        )

    override fun fromUni(d: LemmyapiDatatypesListRegistrationApplications): X4DatatypesListRegistrationApplications = X4DatatypesListRegistrationApplications(
        unread_only = d.unread_only,
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesLockPost): X4DatatypesLockPost = X4DatatypesLockPost(
        post_id = d.post_id,
        locked = d.locked,
    )

    override fun fromUni(d: LemmyapiDatatypesLogin): X4DatatypesLogin = X4DatatypesLogin(
        username_or_email = d.username_or_email,
        password = d.password,
        totp_2fa_token = d.totp_2fa_token,
    )

    fun fromUniR(d: MarkNotificationAsRead): X4DatatypesMarkCommentReplyAsRead = X4DatatypesMarkCommentReplyAsRead(
        comment_reply_id = d.notification_id,
        read = d.read,
    )

    fun fromUniM(d: MarkNotificationAsRead): X4DatatypesMarkPersonMentionAsRead = X4DatatypesMarkPersonMentionAsRead(
        person_mention_id = d.notification_id,
        read = d.read,
    )

    fun fromUniP(d: MarkNotificationAsRead): X4DatatypesMarkPrivateMessageAsRead = X4DatatypesMarkPrivateMessageAsRead(
        private_message_id = d.notification_id,
        read = d.read,
    )

    override fun fromUni(d: LemmyapiDatatypesMarkPostAsRead): X4DatatypesMarkPostAsRead =
        X4DatatypesMarkPostAsRead(
            post_ids = d.post_ids,
            read = d.read,
        )

    override fun fromUni(d: LemmyapiDatatypesPasswordChangeAfterReset): X4DatatypesPasswordChangeAfterReset = X4DatatypesPasswordChangeAfterReset(
        token = d.token,
        password = d.password,
        password_verify = d.password_verify,
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordReset): X4DatatypesPasswordReset =
        X4DatatypesPasswordReset(
            email = d.email,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeComment): X4DatatypesPurgeComment =
        X4DatatypesPurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeCommunity): X4DatatypesPurgeCommunity =
        X4DatatypesPurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePerson): X4DatatypesPurgePerson =
        X4DatatypesPurgePerson(
            person_id = d.person_id,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePost): X4DatatypesPurgePost = X4DatatypesPurgePost(
        post_id = d.post_id,
        reason = d.reason,
    )

    override fun fromUni(d: LemmyapiDatatypesRegister): X4DatatypesRegister = X4DatatypesRegister(
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

    override fun fromUni(d: LemmyapiDatatypesRemoveComment): X4DatatypesRemoveComment =
        X4DatatypesRemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemoveCommunity): X4DatatypesRemoveCommunity =
        X4DatatypesRemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesRemovePost): X4DatatypesRemovePost =
        X4DatatypesRemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveCommentReport): X4DatatypesResolveCommentReport =
        X4DatatypesResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolveObject): X4DatatypesResolveObject =
        X4DatatypesResolveObject(
            q = d.q,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePostReport): X4DatatypesResolvePostReport =
        X4DatatypesResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePrivateMessageReport): X4DatatypesResolvePrivateMessageReport = X4DatatypesResolvePrivateMessageReport(
        report_id = d.report_id,
        resolved = d.resolved,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveComment): X4DatatypesSaveComment =
        X4DatatypesSaveComment(
            comment_id = d.comment_id,
            save = d.save,
        )

    override fun fromUni(d: LemmyapiDatatypesSavePost): X4DatatypesSavePost = X4DatatypesSavePost(
        post_id = d.post_id,
        save = d.save,
    )

    override fun fromUni(d: LemmyapiDatatypesSaveUserSettings): X4DatatypesSaveUserSettings =
        X4DatatypesSaveUserSettings(
            show_nsfw = d.show_nsfw,
            blur_nsfw = d.blur_nsfw,
            theme = d.theme,
            default_sort_type = d.default_post_sort_type,
            default_listing_type = d.default_listing_type,
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
            post_listing_mode = d.post_listing_mode,
            enable_keyboard_navigation = d.enable_keyboard_navigation,
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

    override fun fromUni(d: LemmyapiDatatypesSearch): X4DatatypesSearch = X4DatatypesSearch(
        q = d.q,
        community_id = d.community_id,
        community_name = d.community_name,
        creator_id = d.creator_id,
        type_ = d.type_,
        sort = d.sort,
        listing_type = d.listing_type,
        page = d.page,
        limit = d.limit,
    )

    override fun fromUni(d: LemmyapiDatatypesTransferCommunity): X4DatatypesTransferCommunity =
        X4DatatypesTransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
        )

    override fun fromUni(d: LemmyapiDatatypesUpdateTotp): X4DatatypesUpdateTotp =
        X4DatatypesUpdateTotp(
            totp_token = d.totp_token,
            enabled = d.enabled,
        )

    override fun fromUni(d: LemmyapiDatatypesVerifyEmail): X4DatatypesVerifyEmail =
        X4DatatypesVerifyEmail(
            token = d.token,
        )
}
