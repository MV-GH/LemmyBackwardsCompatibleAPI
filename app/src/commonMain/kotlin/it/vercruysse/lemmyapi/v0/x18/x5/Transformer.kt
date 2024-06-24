package it.vercruysse.lemmyapi.v0.x18.x5

import it.vercruysse.lemmyapi.datatypes.InstanceWithFederationState
import it.vercruysse.lemmyapi.datatypes.LinkMetadata
import it.vercruysse.lemmyapi.dto.CommunityVisibility
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.SubscribedType
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUser
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteMetadata
import it.vercruysse.lemmyapi.datatypes.AddAdminResponse as LemmyapiDatatypesAddAdminResponse
import it.vercruysse.lemmyapi.datatypes.AddAdmin as LemmyapiDatatypesAddAdmin
import it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse as LemmyapiDatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.datatypes.AddModToCommunity as LemmyapiDatatypesAddModToCommunity
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommentView as LemmyapiDatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.datatypes.AdminPurgeComment as LemmyapiDatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunityView as LemmyapiDatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.datatypes.AdminPurgeCommunity as LemmyapiDatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.datatypes.AdminPurgePersonView as LemmyapiDatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.datatypes.AdminPurgePerson as LemmyapiDatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.datatypes.AdminPurgePostView as LemmyapiDatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.datatypes.AdminPurgePost as LemmyapiDatatypesAdminPurgePost
import it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication as LemmyapiDatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.BanFromCommunityResponse as LemmyapiDatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.datatypes.BanFromCommunity as LemmyapiDatatypesBanFromCommunity
import it.vercruysse.lemmyapi.datatypes.BanPersonResponse as LemmyapiDatatypesBanPersonResponse
import it.vercruysse.lemmyapi.datatypes.BanPerson as LemmyapiDatatypesBanPerson
import it.vercruysse.lemmyapi.datatypes.BannedPersonsResponse as LemmyapiDatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.datatypes.BlockCommunityResponse as LemmyapiDatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.datatypes.BlockCommunity as LemmyapiDatatypesBlockCommunity
import it.vercruysse.lemmyapi.datatypes.BlockPersonResponse as LemmyapiDatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.datatypes.BlockPerson as LemmyapiDatatypesBlockPerson
import it.vercruysse.lemmyapi.datatypes.CaptchaResponse as LemmyapiDatatypesCaptchaResponse
import it.vercruysse.lemmyapi.datatypes.ChangePassword as LemmyapiDatatypesChangePassword
import it.vercruysse.lemmyapi.datatypes.CommentAggregates as LemmyapiDatatypesCommentAggregates
import it.vercruysse.lemmyapi.datatypes.CommentReplyResponse as LemmyapiDatatypesCommentReplyResponse
import it.vercruysse.lemmyapi.datatypes.CommentReplyView as LemmyapiDatatypesCommentReplyView
import it.vercruysse.lemmyapi.datatypes.CommentReply as LemmyapiDatatypesCommentReply
import it.vercruysse.lemmyapi.datatypes.CommentReportResponse as LemmyapiDatatypesCommentReportResponse
import it.vercruysse.lemmyapi.datatypes.CommentReportView as LemmyapiDatatypesCommentReportView
import it.vercruysse.lemmyapi.datatypes.CommentReport as LemmyapiDatatypesCommentReport
import it.vercruysse.lemmyapi.datatypes.CommentResponse as LemmyapiDatatypesCommentResponse
import it.vercruysse.lemmyapi.datatypes.CommentView as LemmyapiDatatypesCommentView
import it.vercruysse.lemmyapi.datatypes.Comment as LemmyapiDatatypesComment
import it.vercruysse.lemmyapi.datatypes.CommunityAggregates as LemmyapiDatatypesCommunityAggregates
import it.vercruysse.lemmyapi.datatypes.CommunityBlockView as LemmyapiDatatypesCommunityBlockView
import it.vercruysse.lemmyapi.datatypes.CommunityFollowerView as LemmyapiDatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.datatypes.CommunityModeratorView as LemmyapiDatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.datatypes.CommunityResponse as LemmyapiDatatypesCommunityResponse
import it.vercruysse.lemmyapi.datatypes.CommunityView as LemmyapiDatatypesCommunityView
import it.vercruysse.lemmyapi.datatypes.Community as LemmyapiDatatypesCommunity
import it.vercruysse.lemmyapi.datatypes.CreateCommentLike as LemmyapiDatatypesCreateCommentLike
import it.vercruysse.lemmyapi.datatypes.CreateCommentReport as LemmyapiDatatypesCreateCommentReport
import it.vercruysse.lemmyapi.datatypes.CreateComment as LemmyapiDatatypesCreateComment
import it.vercruysse.lemmyapi.datatypes.CreateCommunity as LemmyapiDatatypesCreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji as LemmyapiDatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.datatypes.CreatePostLike as LemmyapiDatatypesCreatePostLike
import it.vercruysse.lemmyapi.datatypes.CreatePostReport as LemmyapiDatatypesCreatePostReport
import it.vercruysse.lemmyapi.datatypes.CreatePost as LemmyapiDatatypesCreatePost
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport as LemmyapiDatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage as LemmyapiDatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.datatypes.CreateSite as LemmyapiDatatypesCreateSite
import it.vercruysse.lemmyapi.datatypes.CustomEmojiKeyword as LemmyapiDatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse as LemmyapiDatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.datatypes.CustomEmojiView as LemmyapiDatatypesCustomEmojiView
import it.vercruysse.lemmyapi.datatypes.CustomEmoji as LemmyapiDatatypesCustomEmoji
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
import it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse as LemmyapiDatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.datatypes.GetCommentsResponse as LemmyapiDatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.datatypes.GetComments as LemmyapiDatatypesGetComments
import it.vercruysse.lemmyapi.datatypes.GetComment as LemmyapiDatatypesGetComment
import it.vercruysse.lemmyapi.datatypes.GetCommunityResponse as LemmyapiDatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.datatypes.GetCommunity as LemmyapiDatatypesGetCommunity
import it.vercruysse.lemmyapi.datatypes.GetFederatedInstancesResponse as LemmyapiDatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.datatypes.GetModlogResponse as LemmyapiDatatypesGetModlogResponse
import it.vercruysse.lemmyapi.datatypes.GetModlog as LemmyapiDatatypesGetModlog
import it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse as LemmyapiDatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails as LemmyapiDatatypesGetPersonDetails
import it.vercruysse.lemmyapi.datatypes.GetPersonMentionsResponse as LemmyapiDatatypesGetPersonMentionsResponse
import it.vercruysse.lemmyapi.datatypes.GetPersonMentions as LemmyapiDatatypesGetPersonMentions
import it.vercruysse.lemmyapi.datatypes.GetPostResponse as LemmyapiDatatypesGetPostResponse
import it.vercruysse.lemmyapi.datatypes.GetPostsResponse as LemmyapiDatatypesGetPostsResponse
import it.vercruysse.lemmyapi.datatypes.GetPosts as LemmyapiDatatypesGetPosts
import it.vercruysse.lemmyapi.datatypes.GetPost as LemmyapiDatatypesGetPost
import it.vercruysse.lemmyapi.datatypes.GetPrivateMessages as LemmyapiDatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.datatypes.GetRepliesResponse as LemmyapiDatatypesGetRepliesResponse
import it.vercruysse.lemmyapi.datatypes.GetReplies as LemmyapiDatatypesGetReplies
import it.vercruysse.lemmyapi.datatypes.GetReportCountResponse as LemmyapiDatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.datatypes.GetReportCount as LemmyapiDatatypesGetReportCount
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse as LemmyapiDatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.datatypes.GetSiteMetadata as LemmyapiDatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.datatypes.GetSiteResponse as LemmyapiDatatypesGetSiteResponse
import it.vercruysse.lemmyapi.datatypes.GetUnreadCountResponse as LemmyapiDatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.datatypes.GetUnreadRegistrationApplicationCountResponse as LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.datatypes.HideCommunity as LemmyapiDatatypesHideCommunity
import it.vercruysse.lemmyapi.datatypes.Instance as LemmyapiDatatypesInstance
import it.vercruysse.lemmyapi.datatypes.Language as LemmyapiDatatypesLanguage
import it.vercruysse.lemmyapi.datatypes.ListCommentReportsResponse as LemmyapiDatatypesListCommentReportsResponse
import it.vercruysse.lemmyapi.datatypes.ListCommentReports as LemmyapiDatatypesListCommentReports
import it.vercruysse.lemmyapi.datatypes.ListCommunitiesResponse as LemmyapiDatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.datatypes.ListCommunities as LemmyapiDatatypesListCommunities
import it.vercruysse.lemmyapi.datatypes.ListPostReportsResponse as LemmyapiDatatypesListPostReportsResponse
import it.vercruysse.lemmyapi.datatypes.ListPostReports as LemmyapiDatatypesListPostReports
import it.vercruysse.lemmyapi.datatypes.ListPrivateMessageReportsResponse as LemmyapiDatatypesListPrivateMessageReportsResponse
import it.vercruysse.lemmyapi.datatypes.ListPrivateMessageReports as LemmyapiDatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplicationsResponse as LemmyapiDatatypesListRegistrationApplicationsResponse
import it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications as LemmyapiDatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.datatypes.LocalSiteRateLimit as LemmyapiDatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.datatypes.LocalSite as LemmyapiDatatypesLocalSite
import it.vercruysse.lemmyapi.datatypes.LocalUserView as LemmyapiDatatypesLocalUserView
import it.vercruysse.lemmyapi.datatypes.LocalUser as LemmyapiDatatypesLocalUser
import it.vercruysse.lemmyapi.datatypes.LockPost as LemmyapiDatatypesLockPost
import it.vercruysse.lemmyapi.datatypes.LoginResponse as LemmyapiDatatypesLoginResponse
import it.vercruysse.lemmyapi.datatypes.Login as LemmyapiDatatypesLogin
import it.vercruysse.lemmyapi.datatypes.MarkCommentReplyAsRead as LemmyapiDatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.datatypes.MarkPersonMentionAsRead as LemmyapiDatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.datatypes.MarkPrivateMessageAsRead as LemmyapiDatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.datatypes.ModAddCommunityView as LemmyapiDatatypesModAddCommunityView
import it.vercruysse.lemmyapi.datatypes.ModAddCommunity as LemmyapiDatatypesModAddCommunity
import it.vercruysse.lemmyapi.datatypes.ModAddView as LemmyapiDatatypesModAddView
import it.vercruysse.lemmyapi.datatypes.ModAdd as LemmyapiDatatypesModAdd
import it.vercruysse.lemmyapi.datatypes.ModBanFromCommunityView as LemmyapiDatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.datatypes.ModBanFromCommunity as LemmyapiDatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.datatypes.ModBanView as LemmyapiDatatypesModBanView
import it.vercruysse.lemmyapi.datatypes.ModBan as LemmyapiDatatypesModBan
import it.vercruysse.lemmyapi.datatypes.ModFeaturePostView as LemmyapiDatatypesModFeaturePostView
import it.vercruysse.lemmyapi.datatypes.ModFeaturePost as LemmyapiDatatypesModFeaturePost
import it.vercruysse.lemmyapi.datatypes.ModHideCommunityView as LemmyapiDatatypesModHideCommunityView
import it.vercruysse.lemmyapi.datatypes.ModHideCommunity as LemmyapiDatatypesModHideCommunity
import it.vercruysse.lemmyapi.datatypes.ModLockPostView as LemmyapiDatatypesModLockPostView
import it.vercruysse.lemmyapi.datatypes.ModLockPost as LemmyapiDatatypesModLockPost
import it.vercruysse.lemmyapi.datatypes.ModRemoveCommentView as LemmyapiDatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.datatypes.ModRemoveComment as LemmyapiDatatypesModRemoveComment
import it.vercruysse.lemmyapi.datatypes.ModRemoveCommunityView as LemmyapiDatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.datatypes.ModRemoveCommunity as LemmyapiDatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.ModRemovePostView as LemmyapiDatatypesModRemovePostView
import it.vercruysse.lemmyapi.datatypes.ModRemovePost as LemmyapiDatatypesModRemovePost
import it.vercruysse.lemmyapi.datatypes.ModTransferCommunityView as LemmyapiDatatypesModTransferCommunityView
import it.vercruysse.lemmyapi.datatypes.ModTransferCommunity as LemmyapiDatatypesModTransferCommunity
import it.vercruysse.lemmyapi.datatypes.ModlogListParams as LemmyapiDatatypesModlogListParams
import it.vercruysse.lemmyapi.datatypes.MyUserInfo as LemmyapiDatatypesMyUserInfo
import it.vercruysse.lemmyapi.datatypes.PasswordChangeAfterReset as LemmyapiDatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.datatypes.PasswordReset as LemmyapiDatatypesPasswordReset
import it.vercruysse.lemmyapi.datatypes.PersonAggregates as LemmyapiDatatypesPersonAggregates
import it.vercruysse.lemmyapi.datatypes.PersonBlockView as LemmyapiDatatypesPersonBlockView
import it.vercruysse.lemmyapi.datatypes.PersonMentionResponse as LemmyapiDatatypesPersonMentionResponse
import it.vercruysse.lemmyapi.datatypes.PersonMentionView as LemmyapiDatatypesPersonMentionView
import it.vercruysse.lemmyapi.datatypes.PersonMention as LemmyapiDatatypesPersonMention
import it.vercruysse.lemmyapi.datatypes.PersonView as LemmyapiDatatypesPersonView
import it.vercruysse.lemmyapi.datatypes.Person as LemmyapiDatatypesPerson
import it.vercruysse.lemmyapi.datatypes.PostAggregates as LemmyapiDatatypesPostAggregates
import it.vercruysse.lemmyapi.datatypes.PostReportResponse as LemmyapiDatatypesPostReportResponse
import it.vercruysse.lemmyapi.datatypes.PostReportView as LemmyapiDatatypesPostReportView
import it.vercruysse.lemmyapi.datatypes.PostReport as LemmyapiDatatypesPostReport
import it.vercruysse.lemmyapi.datatypes.PostResponse as LemmyapiDatatypesPostResponse
import it.vercruysse.lemmyapi.datatypes.PostView as LemmyapiDatatypesPostView
import it.vercruysse.lemmyapi.datatypes.Post as LemmyapiDatatypesPost
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse as LemmyapiDatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView as LemmyapiDatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReport as LemmyapiDatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse as LemmyapiDatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.datatypes.PrivateMessageView as LemmyapiDatatypesPrivateMessageView
import it.vercruysse.lemmyapi.datatypes.PrivateMessagesResponse as LemmyapiDatatypesPrivateMessagesResponse
import it.vercruysse.lemmyapi.datatypes.PrivateMessage as LemmyapiDatatypesPrivateMessage
import it.vercruysse.lemmyapi.datatypes.PurgeComment as LemmyapiDatatypesPurgeComment
import it.vercruysse.lemmyapi.datatypes.PurgeCommunity as LemmyapiDatatypesPurgeCommunity
import it.vercruysse.lemmyapi.datatypes.PurgePerson as LemmyapiDatatypesPurgePerson
import it.vercruysse.lemmyapi.datatypes.PurgePost as LemmyapiDatatypesPurgePost
import it.vercruysse.lemmyapi.datatypes.Register as LemmyapiDatatypesRegister
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse as LemmyapiDatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView as LemmyapiDatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.datatypes.RegistrationApplication as LemmyapiDatatypesRegistrationApplication
import it.vercruysse.lemmyapi.datatypes.RemoveComment as LemmyapiDatatypesRemoveComment
import it.vercruysse.lemmyapi.datatypes.RemoveCommunity as LemmyapiDatatypesRemoveCommunity
import it.vercruysse.lemmyapi.datatypes.RemovePost as LemmyapiDatatypesRemovePost
import it.vercruysse.lemmyapi.datatypes.ResolveCommentReport as LemmyapiDatatypesResolveCommentReport
import it.vercruysse.lemmyapi.datatypes.ResolveObjectResponse as LemmyapiDatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.datatypes.ResolveObject as LemmyapiDatatypesResolveObject
import it.vercruysse.lemmyapi.datatypes.ResolvePostReport as LemmyapiDatatypesResolvePostReport
import it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport as LemmyapiDatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.SaveComment as LemmyapiDatatypesSaveComment
import it.vercruysse.lemmyapi.datatypes.SavePost as LemmyapiDatatypesSavePost
import it.vercruysse.lemmyapi.datatypes.SaveUserSettings as LemmyapiDatatypesSaveUserSettings
import it.vercruysse.lemmyapi.datatypes.SearchResponse as LemmyapiDatatypesSearchResponse
import it.vercruysse.lemmyapi.datatypes.Search as LemmyapiDatatypesSearch
import it.vercruysse.lemmyapi.datatypes.SiteAggregates as LemmyapiDatatypesSiteAggregates
import it.vercruysse.lemmyapi.datatypes.SiteResponse as LemmyapiDatatypesSiteResponse
import it.vercruysse.lemmyapi.datatypes.SiteView as LemmyapiDatatypesSiteView
import it.vercruysse.lemmyapi.datatypes.Site as LemmyapiDatatypesSite
import it.vercruysse.lemmyapi.datatypes.Tagline as LemmyapiDatatypesTagline
import it.vercruysse.lemmyapi.datatypes.TransferCommunity as LemmyapiDatatypesTransferCommunity
import it.vercruysse.lemmyapi.datatypes.VerifyEmail as LemmyapiDatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddAdminResponse as X5DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddAdmin as X5DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddModToCommunityResponse as X5DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AddModToCommunity as X5DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgeCommentView as X5DatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgeComment as X5DatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgeCommunityView as X5DatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgeCommunity as X5DatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgePersonView as X5DatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgePerson as X5DatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgePostView as X5DatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.AdminPurgePost as X5DatatypesAdminPurgePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ApproveRegistrationApplication as X5DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanFromCommunityResponse as X5DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanFromCommunity as X5DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanPersonResponse as X5DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BanPerson as X5DatatypesBanPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BannedPersonsResponse as X5DatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockCommunityResponse as X5DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockCommunity as X5DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockPersonResponse as X5DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.BlockPerson as X5DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CaptchaResponse as X5DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ChangePassword as X5DatatypesChangePassword
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentAggregates as X5DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReplyResponse as X5DatatypesCommentReplyResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReplyView as X5DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReply as X5DatatypesCommentReply
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReportResponse as X5DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReportView as X5DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentReport as X5DatatypesCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentResponse as X5DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommentView as X5DatatypesCommentView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Comment as X5DatatypesComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityAggregates as X5DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityBlockView as X5DatatypesCommunityBlockView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityFollowerView as X5DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityModeratorView as X5DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityResponse as X5DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CommunityView as X5DatatypesCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Community as X5DatatypesCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommentLike as X5DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommentReport as X5DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateComment as X5DatatypesCreateComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCommunity as X5DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateCustomEmoji as X5DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePostLike as X5DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePostReport as X5DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePost as X5DatatypesCreatePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePrivateMessageReport as X5DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreatePrivateMessage as X5DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CreateSite as X5DatatypesCreateSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiKeyword as X5DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiResponse as X5DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmojiView as X5DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.CustomEmoji as X5DatatypesCustomEmoji
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
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.FederatedInstances as X5DatatypesFederatedInstances
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.FollowCommunity as X5DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCaptchaResponse as X5DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommentsResponse as X5DatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetComments as X5DatatypesGetComments
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetComment as X5DatatypesGetComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommunityResponse as X5DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCommunity as X5DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetFederatedInstancesResponse as X5DatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetModlogResponse as X5DatatypesGetModlogResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetModlog as X5DatatypesGetModlog
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetailsResponse as X5DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetails as X5DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonMentionsResponse as X5DatatypesGetPersonMentionsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonMentions as X5DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPostResponse as X5DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPostsResponse as X5DatatypesGetPostsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPosts as X5DatatypesGetPosts
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPost as X5DatatypesGetPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPrivateMessages as X5DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetRepliesResponse as X5DatatypesGetRepliesResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetReplies as X5DatatypesGetReplies
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetReportCountResponse as X5DatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetReportCount as X5DatatypesGetReportCount
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteMetadataResponse as X5DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteMetadata as X5DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSiteResponse as X5DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetUnreadCountResponse as X5DatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetUnreadRegistrationApplicationCountResponse as X5DatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.HideCommunity as X5DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Instance as X5DatatypesInstance
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Language as X5DatatypesLanguage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommentReportsResponse as X5DatatypesListCommentReportsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommentReports as X5DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommunitiesResponse as X5DatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListCommunities as X5DatatypesListCommunities
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPostReportsResponse as X5DatatypesListPostReportsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPostReports as X5DatatypesListPostReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPrivateMessageReportsResponse as X5DatatypesListPrivateMessageReportsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListPrivateMessageReports as X5DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListRegistrationApplicationsResponse as X5DatatypesListRegistrationApplicationsResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ListRegistrationApplications as X5DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalSiteRateLimit as X5DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalSite as X5DatatypesLocalSite
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUserView as X5DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LocalUser as X5DatatypesLocalUser
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LockPost as X5DatatypesLockPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LoginResponse as X5DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Login as X5DatatypesLogin
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkCommentReplyAsRead as X5DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkPersonMentionAsRead as X5DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkPrivateMessageAsRead as X5DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModAddCommunityView as X5DatatypesModAddCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModAddCommunity as X5DatatypesModAddCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModAddView as X5DatatypesModAddView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModAdd as X5DatatypesModAdd
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModBanFromCommunityView as X5DatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModBanFromCommunity as X5DatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModBanView as X5DatatypesModBanView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModBan as X5DatatypesModBan
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModFeaturePostView as X5DatatypesModFeaturePostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModFeaturePost as X5DatatypesModFeaturePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModHideCommunityView as X5DatatypesModHideCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModHideCommunity as X5DatatypesModHideCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModLockPostView as X5DatatypesModLockPostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModLockPost as X5DatatypesModLockPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemoveCommentView as X5DatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemoveComment as X5DatatypesModRemoveComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemoveCommunityView as X5DatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemoveCommunity as X5DatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemovePostView as X5DatatypesModRemovePostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModRemovePost as X5DatatypesModRemovePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModTransferCommunityView as X5DatatypesModTransferCommunityView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModTransferCommunity as X5DatatypesModTransferCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ModlogListParams as X5DatatypesModlogListParams
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MyUserInfo as X5DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PasswordChangeAfterReset as X5DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PasswordReset as X5DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonAggregates as X5DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonBlockView as X5DatatypesPersonBlockView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonMentionResponse as X5DatatypesPersonMentionResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonMentionView as X5DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonMention as X5DatatypesPersonMention
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PersonView as X5DatatypesPersonView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Person as X5DatatypesPerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostAggregates as X5DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReportResponse as X5DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReportView as X5DatatypesPostReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostReport as X5DatatypesPostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostResponse as X5DatatypesPostResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PostView as X5DatatypesPostView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Post as X5DatatypesPost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReportResponse as X5DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReportView as X5DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageReport as X5DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageResponse as X5DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessageView as X5DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessagesResponse as X5DatatypesPrivateMessagesResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PrivateMessage as X5DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgeComment as X5DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgeCommunity as X5DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgePerson as X5DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.PurgePost as X5DatatypesPurgePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Register as X5DatatypesRegister
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplicationResponse as X5DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplicationView as X5DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RegistrationApplication as X5DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemoveComment as X5DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemoveCommunity as X5DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.RemovePost as X5DatatypesRemovePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveCommentReport as X5DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveObjectResponse as X5DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolveObject as X5DatatypesResolveObject
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolvePostReport as X5DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.ResolvePrivateMessageReport as X5DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SaveComment as X5DatatypesSaveComment
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SavePost as X5DatatypesSavePost
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SaveUserSettings as X5DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SearchResponse as X5DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Search as X5DatatypesSearch
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteAggregates as X5DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteResponse as X5DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.SiteView as X5DatatypesSiteView
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.Site as X5DatatypesSite
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
            default_sort_type = d.default_sort_type,
            default_listing_type = d.default_listing_type,
            interface_language = d.interface_language,
            show_avatars = d.show_avatars,
            send_notifications_to_email = d.send_notifications_to_email,
            show_scores = d.show_scores,
            show_bot_accounts = d.show_bot_accounts,
            show_read_posts = d.show_read_posts,
            email_verified = d.email_verified,
            accepted_application = d.accepted_application,
            open_links_in_new_tab = d.open_links_in_new_tab,
            blur_nsfw = false,
            auto_expand = false,
            infinite_scroll_enabled = true,
            admin = false,
            post_listing_mode = PostListingMode.Card,
            totp_2fa_enabled = d.let { this.mapLocalUserTotp(it) },
            enable_keyboard_navigation = false,
            enable_animated_images = true,
            collapse_bot_comments = false
        )

    override fun toUni(d: X5DatatypesMyUserInfo): LemmyapiDatatypesMyUserInfo =
        LemmyapiDatatypesMyUserInfo(
            local_user_view = this.toUni(d = d.local_user_view),
            follows = d.follows.map { this.toUni(d = it) },
            moderates = d.moderates.map { this.toUni(d = it) },
            community_blocks = d.community_blocks.map { this.toUni(d = it) },
            instance_blocks = listOf(),
            person_blocks = d.person_blocks.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages
        )

    override fun toUni(d: X5DatatypesLocalSiteRateLimit): LemmyapiDatatypesLocalSiteRateLimit =
        LemmyapiDatatypesLocalSiteRateLimit(
            local_site_id = d.local_site_id,
            message = d.message,
            message_per_second = d.message_per_second,
            post = d.post,
            post_per_second = d.post_per_second,
            register = d.register,
            register_per_second = d.register_per_second,
            image = d.image,
            image_per_second = d.image_per_second,
            comment = d.comment,
            comment_per_second = d.comment_per_second,
            search = d.search,
            search_per_second = d.search_per_second,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            import_user_settings = -1,
            import_user_settings_per_second = -1
        )

    override fun toUni(d: X5DatatypesCommentReplyView): LemmyapiDatatypesCommentReplyView =
        LemmyapiDatatypesCommentReplyView(
            comment_reply = this.toUni(d = d.comment_reply),
            comment = this.toUni(d = d.comment),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community),
            recipient = this.toUni(d = d.recipient),
            counts = this.toUni(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            banned_from_community = false,
            creator_is_moderator = false,
            creator_is_admin = false,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote
        )

    override fun toUni(d: X5DatatypesCommentReportView): LemmyapiDatatypesCommentReportView =
        LemmyapiDatatypesCommentReportView(
            comment_report = this.toUni(d = d.comment_report),
            comment = this.toUni(d = d.comment),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community),
            creator = this.toUni(d = d.creator),
            comment_creator = this.toUni(d = d.comment_creator),
            counts = this.toUni(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            creator_blocked = false,
            subscribed = SubscribedType.NotSubscribed,
            saved = false,
            my_vote = d.my_vote,
            resolver = d.resolver?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesCommentView): LemmyapiDatatypesCommentView =
        LemmyapiDatatypesCommentView(
            comment = this.toUni(d = d.comment),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community),
            counts = this.toUni(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            banned_from_community = false,
            creator_is_moderator = false,
            creator_is_admin = false,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote
        )

    override fun toUni(d: X5DatatypesCommunity): LemmyapiDatatypesCommunity =
        LemmyapiDatatypesCommunity(
            id = d.id,
            name = d.name,
            title = d.title,
            description = d.description,
            removed = d.removed,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            deleted = d.deleted,
            nsfw = d.nsfw,
            actor_id = d.actor_id,
            local = d.local,
            icon = d.icon,
            banner = d.banner,
            hidden = d.hidden,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            instance_id = d.instance_id,
            visibility = CommunityVisibility.Public
        )

    override fun toUni(d: X5DatatypesCommunityAggregates): LemmyapiDatatypesCommunityAggregates =
        LemmyapiDatatypesCommunityAggregates(
            community_id = d.community_id,
            subscribers = d.subscribers,
            posts = d.posts,
            comments = d.comments,
            published = addTimezoneOffset(d.published),
            users_active_day = d.users_active_day,
            users_active_week = d.users_active_week,
            users_active_month = d.users_active_month,
            users_active_half_year = d.users_active_half_year,
            subscribers_local = -1
        )

    override fun toUni(d: X5DatatypesCommunityView): LemmyapiDatatypesCommunityView =
        LemmyapiDatatypesCommunityView(
            community = this.toUni(d = d.community),
            subscribed = d.subscribed,
            blocked = d.blocked,
            counts = this.toUni(d = d.counts),
            banned_from_community = false
        )

    override fun toUni(d: SiteMetadata): LinkMetadata = super.toUni(d)

    override fun toUni(d: X5DatatypesGetSiteResponse): LemmyapiDatatypesGetSiteResponse =
        LemmyapiDatatypesGetSiteResponse(
            site_view = this.toUni(d = d.site_view),
            admins = d.admins.map { this.toUni(d = it) },
            version = d.version,
            my_user = d.my_user?.let { this.toUni(d = it) },
            all_languages = d.all_languages.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages,
            taglines = d.taglines.map { this.toUni(d = it) },
            custom_emojis = d.custom_emojis.map { this.toUni(d = it) },
            blocked_urls = listOf()
        )

    override fun toUni(d: X5DatatypesLocalSite): LemmyapiDatatypesLocalSite =
        LemmyapiDatatypesLocalSite(
            id = d.id,
            site_id = d.site_id,
            site_setup = d.site_setup,
            enable_downvotes = d.enable_downvotes,
            enable_nsfw = d.enable_nsfw,
            community_creation_admin_only = d.community_creation_admin_only,
            require_email_verification = d.require_email_verification,
            application_question = d.application_question,
            private_instance = d.private_instance,
            default_theme = d.default_theme,
            default_post_listing_type = d.default_post_listing_type,
            legal_information = d.legal_information,
            hide_modlog_mod_names = d.hide_modlog_mod_names,
            application_email_admins = d.application_email_admins,
            slur_filter_regex = d.slur_filter_regex,
            actor_name_max_length = d.actor_name_max_length,
            federation_enabled = d.federation_enabled,
            captcha_enabled = d.captcha_enabled,
            captcha_difficulty = d.captcha_difficulty,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            registration_mode = d.registration_mode,
            reports_email_admins = d.reports_email_admins,
            federation_signed_fetch = false,
            default_post_listing_mode = PostListingMode.Card,
            default_sort_type = SortType.Active
        )

    override fun toUni(d: X5DatatypesPersonMentionView): LemmyapiDatatypesPersonMentionView =
        LemmyapiDatatypesPersonMentionView(
            person_mention = this.toUni(d = d.person_mention),
            comment = this.toUni(d = d.comment),
            creator = this.toUni(d = d.creator),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community),
            recipient = this.toUni(d = d.recipient),
            counts = this.toUni(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            banned_from_community = false,
            creator_is_moderator = false,
            creator_is_admin = false,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote
        )

    override fun toUni(d: X5DatatypesPersonView, is_admin: Boolean): LemmyapiDatatypesPersonView =
        LemmyapiDatatypesPersonView(
            person = this.toUni(d = d.person),
            counts = this.toUni(d = d.counts),
            is_admin = is_admin
        )

    override fun toUni(d: X5DatatypesPostReportView): LemmyapiDatatypesPostReportView =
        LemmyapiDatatypesPostReportView(
            post_report = this.toUni(d = d.post_report),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community),
            creator = this.toUni(d = d.creator),
            post_creator = this.toUni(d = d.post_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            creator_is_moderator = false,
            creator_is_admin = false,
            subscribed = SubscribedType.NotSubscribed,
            saved = false,
            read = false,
            hidden = false,
            creator_blocked = false,
            my_vote = d.my_vote,
            unread_comments = 0,
            counts = this.toUni(d = d.counts),
            resolver = d.resolver?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesPostView): LemmyapiDatatypesPostView = LemmyapiDatatypesPostView(
        post = this.toUni(d = d.post),
        creator = this.toUni(d = d.creator),
        community = this.toUni(d = d.community),
        creator_banned_from_community = d.creator_banned_from_community,
        banned_from_community = false,
        creator_is_moderator = false,
        creator_is_admin = false,
        counts = this.toUni(d = d.counts),
        subscribed = d.subscribed,
        saved = d.saved,
        read = d.read,
        hidden = false,
        creator_blocked = d.creator_blocked,
        my_vote = d.my_vote,
        unread_comments = d.unread_comments
    )

    override fun toUni(d: X5DatatypesAddAdminResponse): LemmyapiDatatypesAddAdminResponse =
        LemmyapiDatatypesAddAdminResponse(
            admins = d.admins.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesAddModToCommunityResponse):
        LemmyapiDatatypesAddModToCommunityResponse = LemmyapiDatatypesAddModToCommunityResponse(
        moderators = d.moderators.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesAdminPurgeComment): LemmyapiDatatypesAdminPurgeComment =
        LemmyapiDatatypesAdminPurgeComment(
            id = d.id,
            admin_person_id = d.admin_person_id,
            post_id = d.post_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesAdminPurgeCommentView): LemmyapiDatatypesAdminPurgeCommentView =
        LemmyapiDatatypesAdminPurgeCommentView(
            admin_purge_comment = this.toUni(d = d.admin_purge_comment),
            admin = d.admin?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post)
        )

    override fun toUni(d: X5DatatypesAdminPurgeCommunity): LemmyapiDatatypesAdminPurgeCommunity =
        LemmyapiDatatypesAdminPurgeCommunity(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesAdminPurgeCommunityView):
        LemmyapiDatatypesAdminPurgeCommunityView = LemmyapiDatatypesAdminPurgeCommunityView(
        admin_purge_community = this.toUni(d = d.admin_purge_community),
        admin = d.admin?.let { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesAdminPurgePerson): LemmyapiDatatypesAdminPurgePerson =
        LemmyapiDatatypesAdminPurgePerson(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesAdminPurgePersonView): LemmyapiDatatypesAdminPurgePersonView =
        LemmyapiDatatypesAdminPurgePersonView(
            admin_purge_person = this.toUni(d = d.admin_purge_person),
            admin = d.admin?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesAdminPurgePost): LemmyapiDatatypesAdminPurgePost =
        LemmyapiDatatypesAdminPurgePost(
            id = d.id,
            admin_person_id = d.admin_person_id,
            community_id = d.community_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesAdminPurgePostView): LemmyapiDatatypesAdminPurgePostView =
        LemmyapiDatatypesAdminPurgePostView(
            admin_purge_post = this.toUni(d = d.admin_purge_post),
            admin = d.admin?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesBanFromCommunityResponse):
        LemmyapiDatatypesBanFromCommunityResponse = LemmyapiDatatypesBanFromCommunityResponse(
        person_view = this.toUni(d = d.person_view),
        banned = d.banned
    )

    override fun toUni(d: X5DatatypesBannedPersonsResponse): LemmyapiDatatypesBannedPersonsResponse =
        LemmyapiDatatypesBannedPersonsResponse(
            banned = d.banned.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesBanPersonResponse): LemmyapiDatatypesBanPersonResponse =
        LemmyapiDatatypesBanPersonResponse(
            person_view = this.toUni(d = d.person_view),
            banned = d.banned
        )

    override fun toUni(d: X5DatatypesBlockCommunityResponse): LemmyapiDatatypesBlockCommunityResponse
        = LemmyapiDatatypesBlockCommunityResponse(
        community_view = this.toUni(d = d.community_view),
        blocked = d.blocked
    )

    override fun toUni(d: X5DatatypesBlockPersonResponse): LemmyapiDatatypesBlockPersonResponse =
        LemmyapiDatatypesBlockPersonResponse(
            person_view = this.toUni(d = d.person_view),
            blocked = d.blocked
        )

    override fun toUni(d: X5DatatypesCaptchaResponse): LemmyapiDatatypesCaptchaResponse =
        LemmyapiDatatypesCaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid
        )

    override fun toUni(d: X5DatatypesComment): LemmyapiDatatypesComment = LemmyapiDatatypesComment(
        id = d.id,
        creator_id = d.creator_id,
        post_id = d.post_id,
        content = d.content,
        removed = d.removed,
        published = addTimezoneOffset(d.published),
        updated = addTimezoneOffsetNullable(d.updated),
        deleted = d.deleted,
        ap_id = d.ap_id,
        local = d.local,
        path = d.path,
        distinguished = d.distinguished,
        language_id = d.language_id
    )

    override fun toUni(d: X5DatatypesCommentAggregates): LemmyapiDatatypesCommentAggregates =
        LemmyapiDatatypesCommentAggregates(
            comment_id = d.comment_id,
            score = d.score,
            upvotes = d.upvotes,
            downvotes = d.downvotes,
            published = addTimezoneOffset(d.published),
            child_count = d.child_count
        )

    override fun toUni(d: X5DatatypesCommentReply): LemmyapiDatatypesCommentReply =
        LemmyapiDatatypesCommentReply(
            id = d.id,
            recipient_id = d.recipient_id,
            comment_id = d.comment_id,
            read = d.read,
            published = d.published
        )

    override fun toUni(d: X5DatatypesCommentReplyResponse): LemmyapiDatatypesCommentReplyResponse =
        LemmyapiDatatypesCommentReplyResponse(
            comment_reply_view = this.toUni(d = d.comment_reply_view)
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
            published = addTimezoneOffset(d.published),
            updated = d.updated
        )

    override fun toUni(d: X5DatatypesCommentReportResponse): LemmyapiDatatypesCommentReportResponse =
        LemmyapiDatatypesCommentReportResponse(
            comment_report_view = this.toUni(d = d.comment_report_view)
        )

    override fun toUni(d: X5DatatypesCommentResponse): LemmyapiDatatypesCommentResponse =
        LemmyapiDatatypesCommentResponse(
            comment_view = this.toUni(d = d.comment_view),
            recipient_ids = d.recipient_ids
        )

    override fun toUni(d: X5DatatypesCommunityBlockView): LemmyapiDatatypesCommunityBlockView =
        LemmyapiDatatypesCommunityBlockView(
            person = this.toUni(d = d.person),
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesCommunityFollowerView): LemmyapiDatatypesCommunityFollowerView =
        LemmyapiDatatypesCommunityFollowerView(
            community = this.toUni(d = d.community),
            follower = this.toUni(d = d.follower)
        )

    override fun toUni(d: X5DatatypesCommunityModeratorView): LemmyapiDatatypesCommunityModeratorView
        = LemmyapiDatatypesCommunityModeratorView(
        community = this.toUni(d = d.community),
        moderator = this.toUni(d = d.moderator)
    )

    override fun toUni(d: X5DatatypesCommunityResponse): LemmyapiDatatypesCommunityResponse =
        LemmyapiDatatypesCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            discussion_languages = d.discussion_languages
        )

    override fun toUni(d: X5DatatypesCustomEmoji): LemmyapiDatatypesCustomEmoji =
        LemmyapiDatatypesCustomEmoji(
            id = d.id,
            local_site_id = d.local_site_id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published = addTimezoneOffset(d.published),
            updated = d.updated
        )

    override fun toUni(d: X5DatatypesCustomEmojiKeyword): LemmyapiDatatypesCustomEmojiKeyword =
        LemmyapiDatatypesCustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword
        )

    override fun toUni(d: X5DatatypesCustomEmojiResponse): LemmyapiDatatypesCustomEmojiResponse =
        LemmyapiDatatypesCustomEmojiResponse(
            custom_emoji = this.toUni(d = d.custom_emoji)
        )

    override fun toUni(d: X5DatatypesCustomEmojiView): LemmyapiDatatypesCustomEmojiView =
        LemmyapiDatatypesCustomEmojiView(
            custom_emoji = this.toUni(d = d.custom_emoji),
            keywords = d.keywords.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesFederatedInstances): LemmyapiDatatypesFederatedInstances =
        LemmyapiDatatypesFederatedInstances(
            linked = d.linked.map { this.toUniF(d = it) },
            allowed = d.allowed.map { this.toUniF(d = it) },
            blocked = d.blocked.map { this.toUniF(d = it) }
        )

    override fun toUni(d: X5DatatypesGetCaptchaResponse): LemmyapiDatatypesGetCaptchaResponse =
        LemmyapiDatatypesGetCaptchaResponse(
            ok = d.ok?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetCommentsResponse): LemmyapiDatatypesGetCommentsResponse =
        LemmyapiDatatypesGetCommentsResponse(
            comments = d.comments.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetCommunityResponse): LemmyapiDatatypesGetCommunityResponse =
        LemmyapiDatatypesGetCommunityResponse(
            community_view = this.toUni(d = d.community_view),
            site = d.site?.let { this.toUni(d = it) },
            moderators = d.moderators.map { this.toUni(d = it) },
            discussion_languages = d.discussion_languages
        )

    override fun toUni(d: X5DatatypesGetFederatedInstancesResponse):
        LemmyapiDatatypesGetFederatedInstancesResponse =
        LemmyapiDatatypesGetFederatedInstancesResponse(
            federated_instances = d.federated_instances?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetModlogResponse): LemmyapiDatatypesGetModlogResponse =
        LemmyapiDatatypesGetModlogResponse(
            removed_posts = d.removed_posts.map { this.toUni(d = it) },
            locked_posts = d.locked_posts.map { this.toUni(d = it) },
            featured_posts = d.featured_posts.map { this.toUni(d = it) },
            removed_comments = d.removed_comments.map { this.toUni(d = it) },
            removed_communities = d.removed_communities.map { this.toUni(d = it) },
            banned_from_community = d.banned_from_community.map { this.toUni(d = it) },
            banned = d.banned.map { this.toUni(d = it) },
            added_to_community = d.added_to_community.map { this.toUni(d = it) },
            transferred_to_community = d.transferred_to_community.map { this.toUni(d = it) },
            added = d.added.map { this.toUni(d = it) },
            admin_purged_persons = d.admin_purged_persons.map { this.toUni(d = it) },
            admin_purged_communities = d.admin_purged_communities.map { this.toUni(d = it) },
            admin_purged_posts = d.admin_purged_posts.map { this.toUni(d = it) },
            admin_purged_comments = d.admin_purged_comments.map { this.toUni(d = it) },
            hidden_communities = d.hidden_communities.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetPersonDetailsResponse):
        LemmyapiDatatypesGetPersonDetailsResponse = LemmyapiDatatypesGetPersonDetailsResponse(
        person_view = this.toUni(d = d.person_view),
        comments = d.comments.map { this.toUni(d = it) },
        posts = d.posts.map { this.toUni(d = it) },
        moderates = d.moderates.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesGetPersonMentionsResponse):
        LemmyapiDatatypesGetPersonMentionsResponse = LemmyapiDatatypesGetPersonMentionsResponse(
        mentions = d.mentions.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesGetPostResponse): LemmyapiDatatypesGetPostResponse =
        LemmyapiDatatypesGetPostResponse(
            post_view = this.toUni(d = d.post_view),
            community_view = this.toUni(d = d.community_view),
            moderators = d.moderators.map { this.toUni(d = it) },
            cross_posts = d.cross_posts.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetPostsResponse): LemmyapiDatatypesGetPostsResponse =
        LemmyapiDatatypesGetPostsResponse(
            posts = d.posts.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetRepliesResponse): LemmyapiDatatypesGetRepliesResponse =
        LemmyapiDatatypesGetRepliesResponse(
            replies = d.replies.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesGetReportCountResponse): LemmyapiDatatypesGetReportCountResponse
        = LemmyapiDatatypesGetReportCountResponse(
        community_id = d.community_id,
        comment_reports = d.comment_reports,
        post_reports = d.post_reports,
        private_message_reports = d.private_message_reports
    )

    override fun toUni(d: X5DatatypesGetSiteMetadataResponse):
        LemmyapiDatatypesGetSiteMetadataResponse = LemmyapiDatatypesGetSiteMetadataResponse(
        metadata = this.toUni(d = d.metadata)
    )

    override fun toUni(d: X5DatatypesGetUnreadCountResponse): LemmyapiDatatypesGetUnreadCountResponse
        = LemmyapiDatatypesGetUnreadCountResponse(
        replies = d.replies,
        mentions = d.mentions,
        private_messages = d.private_messages
    )

    override fun toUni(d: X5DatatypesGetUnreadRegistrationApplicationCountResponse):
        LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse =
        LemmyapiDatatypesGetUnreadRegistrationApplicationCountResponse(
            registration_applications = d.registration_applications
        )

    override fun toUni(d: X5DatatypesInstance): LemmyapiDatatypesInstance = LemmyapiDatatypesInstance(
        id = d.id,
        domain = d.domain,
        published = addTimezoneOffset(d.published),
        updated = addTimezoneOffsetNullable(d.updated),
        software = d.software,
        version = d.version
    )

    override fun toUni(d: X5DatatypesLanguage): LemmyapiDatatypesLanguage = LemmyapiDatatypesLanguage(
        id = d.id,
        code = d.code,
        name = d.name
    )

    override fun toUni(d: X5DatatypesListCommentReportsResponse):
        LemmyapiDatatypesListCommentReportsResponse = LemmyapiDatatypesListCommentReportsResponse(
        comment_reports = d.comment_reports.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesListCommunitiesResponse):
        LemmyapiDatatypesListCommunitiesResponse = LemmyapiDatatypesListCommunitiesResponse(
        communities = d.communities.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesListPostReportsResponse):
        LemmyapiDatatypesListPostReportsResponse = LemmyapiDatatypesListPostReportsResponse(
        post_reports = d.post_reports.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesListPrivateMessageReportsResponse):
        LemmyapiDatatypesListPrivateMessageReportsResponse =
        LemmyapiDatatypesListPrivateMessageReportsResponse(
            private_message_reports = d.private_message_reports.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesListRegistrationApplicationsResponse):
        LemmyapiDatatypesListRegistrationApplicationsResponse =
        LemmyapiDatatypesListRegistrationApplicationsResponse(
            registration_applications = d.registration_applications.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesLocalUserView): LemmyapiDatatypesLocalUserView =
        LemmyapiDatatypesLocalUserView(
            local_user = this.toUni(d = d.local_user),
            person = this.toUni(d = d.person),
            counts = this.toUni(d = d.counts)
        )

    override fun toUni(d: X5DatatypesLoginResponse): LemmyapiDatatypesLoginResponse =
        LemmyapiDatatypesLoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent
        )

    override fun toUni(d: X5DatatypesModAdd): LemmyapiDatatypesModAdd = LemmyapiDatatypesModAdd(
        id = d.id,
        mod_person_id = d.mod_person_id,
        other_person_id = d.other_person_id,
        removed = d.removed,
        when_ = addTimezoneOffset(d.when_),
    )

    override fun toUni(d: X5DatatypesModAddCommunity): LemmyapiDatatypesModAddCommunity =
        LemmyapiDatatypesModAddCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModAddCommunityView): LemmyapiDatatypesModAddCommunityView =
        LemmyapiDatatypesModAddCommunityView(
            mod_add_community = this.toUni(d = d.mod_add_community),
            moderator = d.moderator?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community),
            modded_person = this.toUni(d = d.modded_person)
        )

    override fun toUni(d: X5DatatypesModAddView): LemmyapiDatatypesModAddView =
        LemmyapiDatatypesModAddView(
            mod_add = this.toUni(d = d.mod_add),
            moderator = d.moderator?.let { this.toUni(d = it) },
            modded_person = this.toUni(d = d.modded_person)
        )

    override fun toUni(d: X5DatatypesModBan): LemmyapiDatatypesModBan = LemmyapiDatatypesModBan(
        id = d.id,
        mod_person_id = d.mod_person_id,
        other_person_id = d.other_person_id,
        reason = d.reason,
        banned = d.banned,
        expires = addTimezoneOffsetNullable(d.expires),
        when_ = addTimezoneOffset(d.when_),
    )

    override fun toUni(d: X5DatatypesModBanFromCommunity): LemmyapiDatatypesModBanFromCommunity =
        LemmyapiDatatypesModBanFromCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            reason = d.reason,
            banned = d.banned,
            expires = addTimezoneOffsetNullable(d.expires),
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModBanFromCommunityView):
        LemmyapiDatatypesModBanFromCommunityView = LemmyapiDatatypesModBanFromCommunityView(
        mod_ban_from_community = this.toUni(d = d.mod_ban_from_community),
        moderator = d.moderator?.let { this.toUni(d = it) },
        community = this.toUni(d = d.community),
        banned_person = this.toUni(d = d.banned_person)
    )

    override fun toUni(d: X5DatatypesModBanView): LemmyapiDatatypesModBanView =
        LemmyapiDatatypesModBanView(
            mod_ban = this.toUni(d = d.mod_ban),
            moderator = d.moderator?.let { this.toUni(d = it) },
            banned_person = this.toUni(d = d.banned_person)
        )

    override fun toUni(d: X5DatatypesModFeaturePost): LemmyapiDatatypesModFeaturePost =
        LemmyapiDatatypesModFeaturePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            featured = d.featured,
            when_ = addTimezoneOffset(d.when_),
            is_featured_community = d.is_featured_community
        )

    override fun toUni(d: X5DatatypesModFeaturePostView): LemmyapiDatatypesModFeaturePostView =
        LemmyapiDatatypesModFeaturePostView(
            mod_feature_post = this.toUni(d = d.mod_feature_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesModHideCommunity): LemmyapiDatatypesModHideCommunity =
        LemmyapiDatatypesModHideCommunity(
            id = d.id,
            community_id = d.community_id,
            mod_person_id = d.mod_person_id,
            when_ = addTimezoneOffset(d.when_),
            reason = d.reason,
            hidden = d.hidden
        )

    override fun toUni(d: X5DatatypesModHideCommunityView): LemmyapiDatatypesModHideCommunityView =
        LemmyapiDatatypesModHideCommunityView(
            mod_hide_community = this.toUni(d = d.mod_hide_community),
            admin = d.admin?.let { this.toUni(d = it) },
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesModLockPost): LemmyapiDatatypesModLockPost =
        LemmyapiDatatypesModLockPost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            locked = d.locked,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModLockPostView): LemmyapiDatatypesModLockPostView =
        LemmyapiDatatypesModLockPostView(
            mod_lock_post = this.toUni(d = d.mod_lock_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesModlogListParams): LemmyapiDatatypesModlogListParams =
        LemmyapiDatatypesModlogListParams(
            community_id = d.community_id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            page = d.page,
            limit = d.limit,
            hide_modlog_names = d.hide_modlog_names
        )

    override fun toUni(d: X5DatatypesModRemoveComment): LemmyapiDatatypesModRemoveComment =
        LemmyapiDatatypesModRemoveComment(
            id = d.id,
            mod_person_id = d.mod_person_id,
            comment_id = d.comment_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModRemoveCommentView): LemmyapiDatatypesModRemoveCommentView =
        LemmyapiDatatypesModRemoveCommentView(
            mod_remove_comment = this.toUni(d = d.mod_remove_comment),
            moderator = d.moderator?.let { this.toUni(d = it) },
            comment = this.toUni(d = d.comment),
            commenter = this.toUni(d = d.commenter),
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesModRemoveCommunity): LemmyapiDatatypesModRemoveCommunity =
        LemmyapiDatatypesModRemoveCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            community_id = d.community_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModRemoveCommunityView): LemmyapiDatatypesModRemoveCommunityView
        = LemmyapiDatatypesModRemoveCommunityView(
        mod_remove_community = this.toUni(d = d.mod_remove_community),
        moderator = d.moderator?.let { this.toUni(d = it) },
        community = this.toUni(d = d.community)
    )

    override fun toUni(d: X5DatatypesModRemovePost): LemmyapiDatatypesModRemovePost =
        LemmyapiDatatypesModRemovePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModRemovePostView): LemmyapiDatatypesModRemovePostView =
        LemmyapiDatatypesModRemovePostView(
            mod_remove_post = this.toUni(d = d.mod_remove_post),
            moderator = d.moderator?.let { this.toUni(d = it) },
            post = this.toUni(d = d.post),
            community = this.toUni(d = d.community)
        )

    override fun toUni(d: X5DatatypesModTransferCommunity): LemmyapiDatatypesModTransferCommunity =
        LemmyapiDatatypesModTransferCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toUni(d: X5DatatypesModTransferCommunityView):
        LemmyapiDatatypesModTransferCommunityView = LemmyapiDatatypesModTransferCommunityView(
        mod_transfer_community = this.toUni(d = d.mod_transfer_community),
        moderator = d.moderator?.let { this.toUni(d = it) },
        community = this.toUni(d = d.community),
        modded_person = this.toUni(d = d.modded_person)
    )

    override fun toUni(d: X5DatatypesPerson): LemmyapiDatatypesPerson = LemmyapiDatatypesPerson(
        id = d.id,
        name = d.name,
        display_name = d.display_name,
        avatar = d.avatar,
        banned = d.banned,
        published = addTimezoneOffset(d.published),
        updated = addTimezoneOffsetNullable(d.updated),
        actor_id = d.actor_id,
        bio = d.bio,
        local = d.local,
        banner = d.banner,
        deleted = d.deleted,
        matrix_user_id = d.matrix_user_id,
        bot_account = d.bot_account,
        ban_expires = addTimezoneOffsetNullable(d.ban_expires),
        instance_id = d.instance_id
    )

    override fun toUni(d: X5DatatypesPersonAggregates): LemmyapiDatatypesPersonAggregates =
        LemmyapiDatatypesPersonAggregates(
            person_id = d.person_id,
            post_count = d.post_count,
            comment_count = d.comment_count
        )

    override fun toUni(d: X5DatatypesPersonBlockView): LemmyapiDatatypesPersonBlockView =
        LemmyapiDatatypesPersonBlockView(
            person = this.toUni(d = d.person),
            target = this.toUni(d = d.target)
        )

    override fun toUni(d: X5DatatypesPersonMention): LemmyapiDatatypesPersonMention =
        LemmyapiDatatypesPersonMention(
            id = d.id,
            recipient_id = d.recipient_id,
            comment_id = d.comment_id,
            read = d.read,
            published = d.published
        )

    override fun toUni(d: X5DatatypesPersonMentionResponse): LemmyapiDatatypesPersonMentionResponse =
        LemmyapiDatatypesPersonMentionResponse(
            person_mention_view = this.toUni(d = d.person_mention_view)
        )

    override fun toUni(d: X5DatatypesPost): LemmyapiDatatypesPost = LemmyapiDatatypesPost(
        id = d.id,
        name = d.name,
        url = d.url,
        body = d.body,
        creator_id = d.creator_id,
        community_id = d.community_id,
        removed = d.removed,
        locked = d.locked,
        published = addTimezoneOffset(d.published),
        updated = addTimezoneOffsetNullable(d.updated),
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
        featured_local = d.featured_local
    )

    override fun toUni(d: X5DatatypesPostAggregates): LemmyapiDatatypesPostAggregates =
        LemmyapiDatatypesPostAggregates(
            post_id = d.post_id,
            comments = d.comments,
            score = d.score,
            upvotes = d.upvotes,
            downvotes = d.downvotes,
            published = addTimezoneOffset(d.published),
            newest_comment_time = addTimezoneOffset(d.newest_comment_time),
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
            published = addTimezoneOffset(d.published),
            updated = d.updated
        )

    override fun toUni(d: X5DatatypesPostReportResponse): LemmyapiDatatypesPostReportResponse =
        LemmyapiDatatypesPostReportResponse(
            post_report_view = this.toUni(d = d.post_report_view)
        )

    override fun toUni(d: X5DatatypesPostResponse): LemmyapiDatatypesPostResponse =
        LemmyapiDatatypesPostResponse(
            post_view = this.toUni(d = d.post_view)
        )

    override fun toUni(d: X5DatatypesPrivateMessage): LemmyapiDatatypesPrivateMessage =
        LemmyapiDatatypesPrivateMessage(
            id = d.id,
            creator_id = d.creator_id,
            recipient_id = d.recipient_id,
            content = d.content,
            deleted = d.deleted,
            read = d.read,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            ap_id = d.ap_id,
            local = d.local
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
            published = addTimezoneOffset(d.published),
            updated = d.updated
        )

    override fun toUni(d: X5DatatypesPrivateMessageReportResponse):
        LemmyapiDatatypesPrivateMessageReportResponse = LemmyapiDatatypesPrivateMessageReportResponse(
        private_message_report_view = this.toUni(d = d.private_message_report_view)
    )

    override fun toUni(d: X5DatatypesPrivateMessageReportView):
        LemmyapiDatatypesPrivateMessageReportView = LemmyapiDatatypesPrivateMessageReportView(
        private_message_report = this.toUni(d = d.private_message_report),
        private_message = this.toUni(d = d.private_message),
        private_message_creator = this.toUni(d = d.private_message_creator),
        creator = this.toUni(d = d.creator),
        resolver = d.resolver?.let { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesPrivateMessageResponse): LemmyapiDatatypesPrivateMessageResponse
        = LemmyapiDatatypesPrivateMessageResponse(
        private_message_view = this.toUni(d = d.private_message_view)
    )

    override fun toUni(d: X5DatatypesPrivateMessagesResponse):
        LemmyapiDatatypesPrivateMessagesResponse = LemmyapiDatatypesPrivateMessagesResponse(
        private_messages = d.private_messages.map { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesPrivateMessageView): LemmyapiDatatypesPrivateMessageView =
        LemmyapiDatatypesPrivateMessageView(
            private_message = this.toUni(d = d.private_message),
            creator = this.toUni(d = d.creator),
            recipient = this.toUni(d = d.recipient)
        )

    override fun toUni(d: X5DatatypesRegistrationApplication):
        LemmyapiDatatypesRegistrationApplication = LemmyapiDatatypesRegistrationApplication(
        id = d.id,
        local_user_id = d.local_user_id,
        answer = d.answer,
        admin_id = d.admin_id,
        deny_reason = d.deny_reason,
        published = d.published
    )

    override fun toUni(d: X5DatatypesRegistrationApplicationResponse):
        LemmyapiDatatypesRegistrationApplicationResponse =
        LemmyapiDatatypesRegistrationApplicationResponse(
            registration_application = this.toUni(d = d.registration_application)
        )

    override fun toUni(d: X5DatatypesRegistrationApplicationView):
        LemmyapiDatatypesRegistrationApplicationView = LemmyapiDatatypesRegistrationApplicationView(
        registration_application = this.toUni(d = d.registration_application),
        creator_local_user = this.toUni(d = d.creator_local_user),
        creator = this.toUni(d = d.creator),
        admin = d.admin?.let { this.toUni(d = it) }
    )

    override fun toUni(d: X5DatatypesResolveObjectResponse): LemmyapiDatatypesResolveObjectResponse =
        LemmyapiDatatypesResolveObjectResponse(
            comment = d.comment?.let { this.toUni(d = it) },
            post = d.post?.let { this.toUni(d = it) },
            community = d.community?.let { this.toUni(d = it) },
            person = d.person?.let { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesSearchResponse): LemmyapiDatatypesSearchResponse =
        LemmyapiDatatypesSearchResponse(
            type_ = d.type_,
            comments = d.comments.map { this.toUni(d = it) },
            posts = d.posts.map { this.toUni(d = it) },
            communities = d.communities.map { this.toUni(d = it) },
            users = d.users.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesSite): LemmyapiDatatypesSite = LemmyapiDatatypesSite(
        id = d.id,
        name = d.name,
        sidebar = d.sidebar,
        published = addTimezoneOffset(d.published),
        updated = addTimezoneOffsetNullable(d.updated),
        icon = d.icon,
        banner = d.banner,
        description = d.description,
        actor_id = d.actor_id,
        last_refreshed_at = addTimezoneOffset(d.last_refreshed_at),
        inbox_url = d.inbox_url,
        instance_id = d.instance_id
    )

    override fun toUni(d: X5DatatypesSiteAggregates): LemmyapiDatatypesSiteAggregates =
        LemmyapiDatatypesSiteAggregates(
            site_id = d.site_id,
            users = d.users,
            posts = d.posts,
            comments = d.comments,
            communities = d.communities,
            users_active_day = d.users_active_day,
            users_active_week = d.users_active_week,
            users_active_month = d.users_active_month,
            users_active_half_year = d.users_active_half_year
        )

    override fun toUni(d: X5DatatypesSiteResponse): LemmyapiDatatypesSiteResponse =
        LemmyapiDatatypesSiteResponse(
            site_view = this.toUni(d = d.site_view),
            taglines = d.taglines.map { this.toUni(d = it) }
        )

    override fun toUni(d: X5DatatypesSiteView): LemmyapiDatatypesSiteView = LemmyapiDatatypesSiteView(
        site = this.toUni(d = d.site),
        local_site = this.toUni(d = d.local_site),
        local_site_rate_limit = this.toUni(d = d.local_site_rate_limit),
        counts = this.toUni(d = d.counts)
    )

    override fun toUni(d: X5DatatypesTagline): LemmyapiDatatypesTagline = LemmyapiDatatypesTagline(
        id = d.id,
        local_site_id = d.local_site_id,
        content = d.content,
        published = addTimezoneOffset(d.published),
        updated = d.updated
    )

    override fun toUniF(d: X5DatatypesInstance): InstanceWithFederationState = super.toUniF(d)

    override fun fromUni(d: LemmyapiDatatypesAddAdmin): X5DatatypesAddAdmin = X5DatatypesAddAdmin(
        person_id = d.person_id,
        added = d.added,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesAddModToCommunity): X5DatatypesAddModToCommunity =
        X5DatatypesAddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesApproveRegistrationApplication):
        X5DatatypesApproveRegistrationApplication = X5DatatypesApproveRegistrationApplication(
        id = d.id,
        approve = d.approve,
        deny_reason = d.deny_reason,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesBanFromCommunity): X5DatatypesBanFromCommunity =
        X5DatatypesBanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_data,
            reason = d.reason,
            expires = d.expires,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesBanPerson): X5DatatypesBanPerson = X5DatatypesBanPerson(
        person_id = d.person_id,
        ban = d.ban,
        remove_data = d.remove_data,
        reason = d.reason,
        expires = d.expires,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesBlockCommunity): X5DatatypesBlockCommunity =
        X5DatatypesBlockCommunity(
            community_id = d.community_id,
            block = d.block,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesBlockPerson): X5DatatypesBlockPerson =
        X5DatatypesBlockPerson(
            person_id = d.person_id,
            block = d.block,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesChangePassword): X5DatatypesChangePassword =
        X5DatatypesChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreateComment): X5DatatypesCreateComment =
        X5DatatypesCreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentLike): X5DatatypesCreateCommentLike =
        X5DatatypesCreateCommentLike(
            comment_id = d.comment_id,
            score = d.score,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommentReport): X5DatatypesCreateCommentReport =
        X5DatatypesCreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCommunity): X5DatatypesCreateCommunity =
        X5DatatypesCreateCommunity(
            name = d.name,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreateCustomEmoji): X5DatatypesCreateCustomEmoji =
        X5DatatypesCreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
            auth = auth
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
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostLike): X5DatatypesCreatePostLike =
        X5DatatypesCreatePostLike(
            post_id = d.post_id,
            score = d.score,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePostReport): X5DatatypesCreatePostReport =
        X5DatatypesCreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessage): X5DatatypesCreatePrivateMessage =
        X5DatatypesCreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesCreatePrivateMessageReport):
        X5DatatypesCreatePrivateMessageReport = X5DatatypesCreatePrivateMessageReport(
        private_message_id = d.private_message_id,
        reason = d.reason,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesCreateSite): X5DatatypesCreateSite =
        X5DatatypesCreateSite(
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
            legal_information = d.legal_information,
            application_email_admins = d.application_email_admins,
            hide_modlog_mod_names = d.hide_modlog_mod_names,
            discussion_languages = d.discussion_languages,
            slur_filter_regex = d.slur_filter_regex,
            actor_name_max_length = d.actor_name_max_length,
            rate_limit_message = d.rate_limit_message,
            rate_limit_message_per_second = d.rate_limit_message_per_second,
            rate_limit_post = d.rate_limit_post,
            rate_limit_post_per_second = d.rate_limit_post_per_second,
            rate_limit_register = d.rate_limit_register,
            rate_limit_register_per_second = d.rate_limit_register_per_second,
            rate_limit_image = d.rate_limit_image,
            rate_limit_image_per_second = d.rate_limit_image_per_second,
            rate_limit_comment = d.rate_limit_comment,
            rate_limit_comment_per_second = d.rate_limit_comment_per_second,
            rate_limit_search = d.rate_limit_search,
            rate_limit_search_per_second = d.rate_limit_search_per_second,
            federation_enabled = d.federation_enabled,
            federation_debug = d.federation_debug,
            captcha_enabled = d.captcha_enabled,
            captcha_difficulty = d.captcha_difficulty,
            allowed_instances = d.allowed_instances,
            blocked_instances = d.blocked_instances,
            taglines = d.taglines,
            registration_mode = d.registration_mode,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteAccount): X5DatatypesDeleteAccount =
        X5DatatypesDeleteAccount(
            password = d.password,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteComment): X5DatatypesDeleteComment =
        X5DatatypesDeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCommunity): X5DatatypesDeleteCommunity =
        X5DatatypesDeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeleteCustomEmoji): X5DatatypesDeleteCustomEmoji =
        X5DatatypesDeleteCustomEmoji(
            id = d.id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePost): X5DatatypesDeletePost =
        X5DatatypesDeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDeletePrivateMessage): X5DatatypesDeletePrivateMessage =
        X5DatatypesDeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesDistinguishComment): X5DatatypesDistinguishComment =
        X5DatatypesDistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesEditComment): X5DatatypesEditComment =
        X5DatatypesEditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesEditCommunity): X5DatatypesEditCommunity =
        X5DatatypesEditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesEditCustomEmoji): X5DatatypesEditCustomEmoji =
        X5DatatypesEditCustomEmoji(
            id = d.id,
            category = d.category,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesEditPost): X5DatatypesEditPost = X5DatatypesEditPost(
        post_id = d.post_id,
        name = d.name,
        url = d.url,
        body = d.body,
        nsfw = d.nsfw,
        language_id = d.language_id,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesEditPrivateMessage): X5DatatypesEditPrivateMessage =
        X5DatatypesEditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesEditSite): X5DatatypesEditSite = X5DatatypesEditSite(
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
        legal_information = d.legal_information,
        application_email_admins = d.application_email_admins,
        hide_modlog_mod_names = d.hide_modlog_mod_names,
        discussion_languages = d.discussion_languages,
        slur_filter_regex = d.slur_filter_regex,
        actor_name_max_length = d.actor_name_max_length,
        rate_limit_message = d.rate_limit_message,
        rate_limit_message_per_second = d.rate_limit_message_per_second,
        rate_limit_post = d.rate_limit_post,
        rate_limit_post_per_second = d.rate_limit_post_per_second,
        rate_limit_register = d.rate_limit_register,
        rate_limit_register_per_second = d.rate_limit_register_per_second,
        rate_limit_image = d.rate_limit_image,
        rate_limit_image_per_second = d.rate_limit_image_per_second,
        rate_limit_comment = d.rate_limit_comment,
        rate_limit_comment_per_second = d.rate_limit_comment_per_second,
        rate_limit_search = d.rate_limit_search,
        rate_limit_search_per_second = d.rate_limit_search_per_second,
        federation_enabled = d.federation_enabled,
        federation_debug = d.federation_debug,
        captcha_enabled = d.captcha_enabled,
        captcha_difficulty = d.captcha_difficulty,
        allowed_instances = d.allowed_instances,
        blocked_instances = d.blocked_instances,
        taglines = d.taglines,
        registration_mode = d.registration_mode,
        reports_email_admins = d.reports_email_admins,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesFeaturePost): X5DatatypesFeaturePost =
        X5DatatypesFeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = d.feature_type,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesFollowCommunity): X5DatatypesFollowCommunity =
        X5DatatypesFollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetComment): X5DatatypesGetComment =
        X5DatatypesGetComment(
            id = d.id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetComments): X5DatatypesGetComments =
        X5DatatypesGetComments(
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
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetCommunity): X5DatatypesGetCommunity =
        X5DatatypesGetCommunity(
            id = d.id,
            name = d.name,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetModlog): X5DatatypesGetModlog = X5DatatypesGetModlog(
        mod_person_id = d.mod_person_id,
        community_id = d.community_id,
        page = d.page,
        limit = d.limit,
        type_ = d.type_,
        other_person_id = d.other_person_id,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesGetPersonDetails): X5DatatypesGetPersonDetails =
        X5DatatypesGetPersonDetails(
            person_id = d.person_id,
            username = d.username,
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            community_id = d.community_id,
            saved_only = d.saved_only,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetPersonMentions): X5DatatypesGetPersonMentions =
        X5DatatypesGetPersonMentions(
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetPost): X5DatatypesGetPost = X5DatatypesGetPost(
        id = d.id,
        comment_id = d.comment_id,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesGetPosts): X5DatatypesGetPosts = X5DatatypesGetPosts(
        type_ = d.type_,
        sort = d.sort,
        page = d.page,
        limit = d.limit,
        community_id = d.community_id,
        community_name = d.community_name,
        saved_only = d.saved_only,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesGetPrivateMessages): X5DatatypesGetPrivateMessages =
        X5DatatypesGetPrivateMessages(
            unread_only = d.unread_only,
            page = d.page,
            limit = d.limit,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetReplies): X5DatatypesGetReplies =
        X5DatatypesGetReplies(
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetReportCount): X5DatatypesGetReportCount =
        X5DatatypesGetReportCount(
            community_id = d.community_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesGetSiteMetadata): X5DatatypesGetSiteMetadata =
        X5DatatypesGetSiteMetadata(
            url = d.url
        )

    override fun fromUni(d: LemmyapiDatatypesHideCommunity): X5DatatypesHideCommunity =
        X5DatatypesHideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesListCommentReports): X5DatatypesListCommentReports =
        X5DatatypesListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesListCommunities): X5DatatypesListCommunities =
        X5DatatypesListCommunities(
            type_ = d.type_,
            sort = d.sort,
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesListPostReports): X5DatatypesListPostReports =
        X5DatatypesListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesListPrivateMessageReports):
        X5DatatypesListPrivateMessageReports = X5DatatypesListPrivateMessageReports(
        page = d.page,
        limit = d.limit,
        unresolved_only = d.unresolved_only,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesListRegistrationApplications):
        X5DatatypesListRegistrationApplications = X5DatatypesListRegistrationApplications(
        unread_only = d.unread_only,
        page = d.page,
        limit = d.limit,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesLockPost): X5DatatypesLockPost = X5DatatypesLockPost(
        post_id = d.post_id,
        locked = d.locked,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesLogin): X5DatatypesLogin = X5DatatypesLogin(
        username_or_email = d.username_or_email,
        password = d.password,
        totp_2fa_token = d.totp_2fa_token
    )

    override fun fromUni(d: LemmyapiDatatypesMarkCommentReplyAsRead):
        X5DatatypesMarkCommentReplyAsRead = X5DatatypesMarkCommentReplyAsRead(
        comment_reply_id = d.comment_reply_id,
        read = d.read,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesMarkPersonMentionAsRead):
        X5DatatypesMarkPersonMentionAsRead = X5DatatypesMarkPersonMentionAsRead(
        person_mention_id = d.person_mention_id,
        read = d.read,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesMarkPrivateMessageAsRead):
        X5DatatypesMarkPrivateMessageAsRead = X5DatatypesMarkPrivateMessageAsRead(
        private_message_id = d.private_message_id,
        read = d.read,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordChangeAfterReset):
        X5DatatypesPasswordChangeAfterReset = X5DatatypesPasswordChangeAfterReset(
        token = d.token,
        password = d.password,
        password_verify = d.password_verify
    )

    override fun fromUni(d: LemmyapiDatatypesPasswordReset): X5DatatypesPasswordReset =
        X5DatatypesPasswordReset(
            email = d.email
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeComment): X5DatatypesPurgeComment =
        X5DatatypesPurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesPurgeCommunity): X5DatatypesPurgeCommunity =
        X5DatatypesPurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePerson): X5DatatypesPurgePerson =
        X5DatatypesPurgePerson(
            person_id = d.person_id,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesPurgePost): X5DatatypesPurgePost = X5DatatypesPurgePost(
        post_id = d.post_id,
        reason = d.reason,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesRegister): X5DatatypesRegister = X5DatatypesRegister(
        username = d.username,
        password = d.password,
        password_verify = d.password_verify,
        show_nsfw = d.show_nsfw,
        email = d.email,
        captcha_uuid = d.captcha_uuid,
        captcha_answer = d.captcha_answer,
        honeypot = d.honeypot,
        answer = d.answer
    )

    override fun fromUni(d: LemmyapiDatatypesRemoveComment): X5DatatypesRemoveComment =
        X5DatatypesRemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesRemoveCommunity): X5DatatypesRemoveCommunity =
        X5DatatypesRemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesRemovePost): X5DatatypesRemovePost =
        X5DatatypesRemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesResolveCommentReport): X5DatatypesResolveCommentReport =
        X5DatatypesResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesResolveObject): X5DatatypesResolveObject =
        X5DatatypesResolveObject(
            q = d.q,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePostReport): X5DatatypesResolvePostReport =
        X5DatatypesResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesResolvePrivateMessageReport):
        X5DatatypesResolvePrivateMessageReport = X5DatatypesResolvePrivateMessageReport(
        report_id = d.report_id,
        resolved = d.resolved,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesSaveComment): X5DatatypesSaveComment =
        X5DatatypesSaveComment(
            comment_id = d.comment_id,
            save = d.save,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesSavePost): X5DatatypesSavePost = X5DatatypesSavePost(
        post_id = d.post_id,
        save = d.save,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesSaveUserSettings): X5DatatypesSaveUserSettings =
        X5DatatypesSaveUserSettings(
            show_nsfw = d.show_nsfw,
            show_scores = d.show_scores,
            theme = d.theme,
            default_sort_type = d.default_sort_type,
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
            auth = auth,
            open_links_in_new_tab = d.open_links_in_new_tab
        )

    override fun fromUni(d: LemmyapiDatatypesSearch): X5DatatypesSearch = X5DatatypesSearch(
        q = d.q,
        community_id = d.community_id,
        community_name = d.community_name,
        creator_id = d.creator_id,
        type_ = d.type_,
        sort = d.sort,
        listing_type = d.listing_type,
        page = d.page,
        limit = d.limit,
        auth = auth
    )

    override fun fromUni(d: LemmyapiDatatypesTransferCommunity): X5DatatypesTransferCommunity =
        X5DatatypesTransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            auth = auth
        )

    override fun fromUni(d: LemmyapiDatatypesVerifyEmail): X5DatatypesVerifyEmail =
        X5DatatypesVerifyEmail(
            token = d.token
        )
}
