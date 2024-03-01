package it.vercruysse.lemmyapi.v0x18

import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalUser
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalUserView
import it.vercruysse.lemmyapi.v0x18.datatypes.AddAdmin as V0x18DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0x18.datatypes.AddAdminResponse as V0x18DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.AddModToCommunity as V0x18DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.AddModToCommunityResponse as V0x18DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgeComment as V0x18DatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgeCommentView as V0x18DatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgeCommunity as V0x18DatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgeCommunityView as V0x18DatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgePerson as V0x18DatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgePersonView as V0x18DatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgePost as V0x18DatatypesAdminPurgePost
import it.vercruysse.lemmyapi.v0x18.datatypes.AdminPurgePostView as V0x18DatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.v0x18.datatypes.ApproveRegistrationApplication as V0x18DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0x18.datatypes.BanFromCommunity as V0x18DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.BanFromCommunityResponse as V0x18DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.BanPerson as V0x18DatatypesBanPerson
import it.vercruysse.lemmyapi.v0x18.datatypes.BanPersonResponse as V0x18DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.BannedPersonsResponse as V0x18DatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.BlockCommunity as V0x18DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.BlockCommunityResponse as V0x18DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.BlockPerson as V0x18DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0x18.datatypes.BlockPersonResponse as V0x18DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CaptchaResponse as V0x18DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ChangePassword as V0x18DatatypesChangePassword
import it.vercruysse.lemmyapi.v0x18.datatypes.Comment as V0x18DatatypesComment
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentAggregates as V0x18DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReply as V0x18DatatypesCommentReply
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReplyResponse as V0x18DatatypesCommentReplyResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReplyView as V0x18DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReport as V0x18DatatypesCommentReport
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReportResponse as V0x18DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentReportView as V0x18DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentResponse as V0x18DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CommentView as V0x18DatatypesCommentView
import it.vercruysse.lemmyapi.v0x18.datatypes.Community as V0x18DatatypesCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityAggregates as V0x18DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityBlockView as V0x18DatatypesCommunityBlockView
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityFollowerView as V0x18DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityModeratorView as V0x18DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityResponse as V0x18DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CommunityView as V0x18DatatypesCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateComment as V0x18DatatypesCreateComment
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommentLike as V0x18DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommentReport as V0x18DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommunity as V0x18DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateCustomEmoji as V0x18DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0x18.datatypes.CreatePost as V0x18DatatypesCreatePost
import it.vercruysse.lemmyapi.v0x18.datatypes.CreatePostLike as V0x18DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0x18.datatypes.CreatePostReport as V0x18DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0x18.datatypes.CreatePrivateMessage as V0x18DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0x18.datatypes.CreatePrivateMessageReport as V0x18DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0x18.datatypes.CreateSite as V0x18DatatypesCreateSite
import it.vercruysse.lemmyapi.v0x18.datatypes.CustomEmoji as V0x18DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0x18.datatypes.CustomEmojiKeyword as V0x18DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0x18.datatypes.CustomEmojiResponse as V0x18DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.CustomEmojiView as V0x18DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0x18.datatypes.DeleteAccount as V0x18DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0x18.datatypes.DeleteComment as V0x18DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0x18.datatypes.DeleteCommunity as V0x18DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.DeleteCustomEmoji as V0x18DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0x18.datatypes.DeletePost as V0x18DatatypesDeletePost
import it.vercruysse.lemmyapi.v0x18.datatypes.DeletePrivateMessage as V0x18DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0x18.datatypes.DistinguishComment as V0x18DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0x18.datatypes.EditComment as V0x18DatatypesEditComment
import it.vercruysse.lemmyapi.v0x18.datatypes.EditCommunity as V0x18DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.EditCustomEmoji as V0x18DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0x18.datatypes.EditPost as V0x18DatatypesEditPost
import it.vercruysse.lemmyapi.v0x18.datatypes.EditPrivateMessage as V0x18DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0x18.datatypes.EditSite as V0x18DatatypesEditSite
import it.vercruysse.lemmyapi.v0x18.datatypes.FeaturePost as V0x18DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0x18.datatypes.FederatedInstances as V0x18DatatypesFederatedInstances
import it.vercruysse.lemmyapi.v0x18.datatypes.FollowCommunity as V0x18DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.GetCaptchaResponse as V0x18DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetComment as V0x18DatatypesGetComment
import it.vercruysse.lemmyapi.v0x18.datatypes.GetComments as V0x18DatatypesGetComments
import it.vercruysse.lemmyapi.v0x18.datatypes.GetCommentsResponse as V0x18DatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetCommunity as V0x18DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.GetCommunityResponse as V0x18DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetFederatedInstancesResponse as V0x18DatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetModlog as V0x18DatatypesGetModlog
import it.vercruysse.lemmyapi.v0x18.datatypes.GetModlogResponse as V0x18DatatypesGetModlogResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonDetails as V0x18DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonDetailsResponse as V0x18DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonMentions as V0x18DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonMentionsResponse as V0x18DatatypesGetPersonMentionsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPost as V0x18DatatypesGetPost
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPostResponse as V0x18DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPosts as V0x18DatatypesGetPosts
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPostsResponse as V0x18DatatypesGetPostsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetPrivateMessages as V0x18DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0x18.datatypes.GetReplies as V0x18DatatypesGetReplies
import it.vercruysse.lemmyapi.v0x18.datatypes.GetRepliesResponse as V0x18DatatypesGetRepliesResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetReportCount as V0x18DatatypesGetReportCount
import it.vercruysse.lemmyapi.v0x18.datatypes.GetReportCountResponse as V0x18DatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetSiteMetadata as V0x18DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0x18.datatypes.GetSiteMetadataResponse as V0x18DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetSiteResponse as V0x18DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetUnreadCountResponse as V0x18DatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.GetUnreadRegistrationApplicationCountResponse as V0x18DatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.HideCommunity as V0x18DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.Instance as V0x18DatatypesInstance
import it.vercruysse.lemmyapi.v0x18.datatypes.Language as V0x18DatatypesLanguage
import it.vercruysse.lemmyapi.v0x18.datatypes.ListCommentReports as V0x18DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0x18.datatypes.ListCommentReportsResponse as V0x18DatatypesListCommentReportsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ListCommunities as V0x18DatatypesListCommunities
import it.vercruysse.lemmyapi.v0x18.datatypes.ListCommunitiesResponse as V0x18DatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ListPostReports as V0x18DatatypesListPostReports
import it.vercruysse.lemmyapi.v0x18.datatypes.ListPostReportsResponse as V0x18DatatypesListPostReportsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ListPrivateMessageReports as V0x18DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0x18.datatypes.ListPrivateMessageReportsResponse as V0x18DatatypesListPrivateMessageReportsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ListRegistrationApplications as V0x18DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0x18.datatypes.ListRegistrationApplicationsResponse as V0x18DatatypesListRegistrationApplicationsResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalSite as V0x18DatatypesLocalSite
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalSiteRateLimit as V0x18DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalUser as V0x18DatatypesLocalUser
import it.vercruysse.lemmyapi.v0x18.datatypes.LocalUserView as V0x18DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0x18.datatypes.LockPost as V0x18DatatypesLockPost
import it.vercruysse.lemmyapi.v0x18.datatypes.Login as V0x18DatatypesLogin
import it.vercruysse.lemmyapi.v0x18.datatypes.LoginResponse as V0x18DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.MarkCommentReplyAsRead as V0x18DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0x18.datatypes.MarkPersonMentionAsRead as V0x18DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0x18.datatypes.MarkPrivateMessageAsRead as V0x18DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0x18.datatypes.ModAdd as V0x18DatatypesModAdd
import it.vercruysse.lemmyapi.v0x18.datatypes.ModAddCommunity as V0x18DatatypesModAddCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.ModAddCommunityView as V0x18DatatypesModAddCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModAddView as V0x18DatatypesModAddView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModBan as V0x18DatatypesModBan
import it.vercruysse.lemmyapi.v0x18.datatypes.ModBanFromCommunity as V0x18DatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.ModBanFromCommunityView as V0x18DatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModBanView as V0x18DatatypesModBanView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModFeaturePost as V0x18DatatypesModFeaturePost
import it.vercruysse.lemmyapi.v0x18.datatypes.ModFeaturePostView as V0x18DatatypesModFeaturePostView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModHideCommunity as V0x18DatatypesModHideCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.ModHideCommunityView as V0x18DatatypesModHideCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModLockPost as V0x18DatatypesModLockPost
import it.vercruysse.lemmyapi.v0x18.datatypes.ModLockPostView as V0x18DatatypesModLockPostView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemoveComment as V0x18DatatypesModRemoveComment
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemoveCommentView as V0x18DatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemoveCommunity as V0x18DatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemoveCommunityView as V0x18DatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemovePost as V0x18DatatypesModRemovePost
import it.vercruysse.lemmyapi.v0x18.datatypes.ModRemovePostView as V0x18DatatypesModRemovePostView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModTransferCommunity as V0x18DatatypesModTransferCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.ModTransferCommunityView as V0x18DatatypesModTransferCommunityView
import it.vercruysse.lemmyapi.v0x18.datatypes.ModlogListParams as V0x18DatatypesModlogListParams
import it.vercruysse.lemmyapi.v0x18.datatypes.MyUserInfo as V0x18DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0x18.datatypes.PasswordChangeAfterReset as V0x18DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0x18.datatypes.PasswordReset as V0x18DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0x18.datatypes.Person as V0x18DatatypesPerson
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonAggregates as V0x18DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonBlockView as V0x18DatatypesPersonBlockView
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonMention as V0x18DatatypesPersonMention
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonMentionResponse as V0x18DatatypesPersonMentionResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonMentionView as V0x18DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0x18.datatypes.PersonView as V0x18DatatypesPersonView
import it.vercruysse.lemmyapi.v0x18.datatypes.Post as V0x18DatatypesPost
import it.vercruysse.lemmyapi.v0x18.datatypes.PostAggregates as V0x18DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0x18.datatypes.PostReport as V0x18DatatypesPostReport
import it.vercruysse.lemmyapi.v0x18.datatypes.PostReportResponse as V0x18DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PostReportView as V0x18DatatypesPostReportView
import it.vercruysse.lemmyapi.v0x18.datatypes.PostResponse as V0x18DatatypesPostResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PostView as V0x18DatatypesPostView
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessage as V0x18DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessageReport as V0x18DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessageReportResponse as V0x18DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessageReportView as V0x18DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessageResponse as V0x18DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessageView as V0x18DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0x18.datatypes.PrivateMessagesResponse as V0x18DatatypesPrivateMessagesResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.PurgeComment as V0x18DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0x18.datatypes.PurgeCommunity as V0x18DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.PurgePerson as V0x18DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0x18.datatypes.PurgePost as V0x18DatatypesPurgePost
import it.vercruysse.lemmyapi.v0x18.datatypes.Register as V0x18DatatypesRegister
import it.vercruysse.lemmyapi.v0x18.datatypes.RegistrationApplication as V0x18DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0x18.datatypes.RegistrationApplicationResponse as V0x18DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.RegistrationApplicationView as V0x18DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0x18.datatypes.RemoveComment as V0x18DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0x18.datatypes.RemoveCommunity as V0x18DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.RemovePost as V0x18DatatypesRemovePost
import it.vercruysse.lemmyapi.v0x18.datatypes.ResolveCommentReport as V0x18DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0x18.datatypes.ResolveObject as V0x18DatatypesResolveObject
import it.vercruysse.lemmyapi.v0x18.datatypes.ResolveObjectResponse as V0x18DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.ResolvePostReport as V0x18DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0x18.datatypes.ResolvePrivateMessageReport as V0x18DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0x18.datatypes.SaveComment as V0x18DatatypesSaveComment
import it.vercruysse.lemmyapi.v0x18.datatypes.SavePost as V0x18DatatypesSavePost
import it.vercruysse.lemmyapi.v0x18.datatypes.SaveUserSettings as V0x18DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0x18.datatypes.Search as V0x18DatatypesSearch
import it.vercruysse.lemmyapi.v0x18.datatypes.SearchResponse as V0x18DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.Site as V0x18DatatypesSite
import it.vercruysse.lemmyapi.v0x18.datatypes.SiteAggregates as V0x18DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0x18.datatypes.SiteMetadata as V0x18DatatypesSiteMetadata
import it.vercruysse.lemmyapi.v0x18.datatypes.SiteResponse as V0x18DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0x18.datatypes.SiteView as V0x18DatatypesSiteView
import it.vercruysse.lemmyapi.v0x18.datatypes.Tagline as V0x18DatatypesTagline
import it.vercruysse.lemmyapi.v0x18.datatypes.TransferCommunity as V0x18DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0x18.datatypes.VerifyEmail as V0x18DatatypesVerifyEmail
import it.vercruysse.lemmyapi.v0x19.datatypes.AddAdmin as V0x19DatatypesAddAdmin
import it.vercruysse.lemmyapi.v0x19.datatypes.AddAdminResponse as V0x19DatatypesAddAdminResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.AddModToCommunity as V0x19DatatypesAddModToCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.AddModToCommunityResponse as V0x19DatatypesAddModToCommunityResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeComment as V0x19DatatypesAdminPurgeComment
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommentView as V0x19DatatypesAdminPurgeCommentView
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunity as V0x19DatatypesAdminPurgeCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunityView as V0x19DatatypesAdminPurgeCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePerson as V0x19DatatypesAdminPurgePerson
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePersonView as V0x19DatatypesAdminPurgePersonView
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePost as V0x19DatatypesAdminPurgePost
import it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePostView as V0x19DatatypesAdminPurgePostView
import it.vercruysse.lemmyapi.v0x19.datatypes.ApproveRegistrationApplication as V0x19DatatypesApproveRegistrationApplication
import it.vercruysse.lemmyapi.v0x19.datatypes.BanFromCommunity as V0x19DatatypesBanFromCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.BanFromCommunityResponse as V0x19DatatypesBanFromCommunityResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.BanPerson as V0x19DatatypesBanPerson
import it.vercruysse.lemmyapi.v0x19.datatypes.BanPersonResponse as V0x19DatatypesBanPersonResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.BannedPersonsResponse as V0x19DatatypesBannedPersonsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.BlockCommunity as V0x19DatatypesBlockCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.BlockCommunityResponse as V0x19DatatypesBlockCommunityResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.BlockPerson as V0x19DatatypesBlockPerson
import it.vercruysse.lemmyapi.v0x19.datatypes.BlockPersonResponse as V0x19DatatypesBlockPersonResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CaptchaResponse as V0x19DatatypesCaptchaResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ChangePassword as V0x19DatatypesChangePassword
import it.vercruysse.lemmyapi.v0x19.datatypes.Comment as V0x19DatatypesComment
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentAggregates as V0x19DatatypesCommentAggregates
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReply as V0x19DatatypesCommentReply
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyResponse as V0x19DatatypesCommentReplyResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyView as V0x19DatatypesCommentReplyView
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReport as V0x19DatatypesCommentReport
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportResponse as V0x19DatatypesCommentReportResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportView as V0x19DatatypesCommentReportView
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentResponse as V0x19DatatypesCommentResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CommentView as V0x19DatatypesCommentView
import it.vercruysse.lemmyapi.v0x19.datatypes.Community as V0x19DatatypesCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityAggregates as V0x19DatatypesCommunityAggregates
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityBlockView as V0x19DatatypesCommunityBlockView
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityFollowerView as V0x19DatatypesCommunityFollowerView
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityModeratorView as V0x19DatatypesCommunityModeratorView
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityResponse as V0x19DatatypesCommunityResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CommunityView as V0x19DatatypesCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateComment as V0x19DatatypesCreateComment
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommentLike as V0x19DatatypesCreateCommentLike
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommentReport as V0x19DatatypesCreateCommentReport
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateCommunity as V0x19DatatypesCreateCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateCustomEmoji as V0x19DatatypesCreateCustomEmoji
import it.vercruysse.lemmyapi.v0x19.datatypes.CreatePost as V0x19DatatypesCreatePost
import it.vercruysse.lemmyapi.v0x19.datatypes.CreatePostLike as V0x19DatatypesCreatePostLike
import it.vercruysse.lemmyapi.v0x19.datatypes.CreatePostReport as V0x19DatatypesCreatePostReport
import it.vercruysse.lemmyapi.v0x19.datatypes.CreatePrivateMessage as V0x19DatatypesCreatePrivateMessage
import it.vercruysse.lemmyapi.v0x19.datatypes.CreatePrivateMessageReport as V0x19DatatypesCreatePrivateMessageReport
import it.vercruysse.lemmyapi.v0x19.datatypes.CreateSite as V0x19DatatypesCreateSite
import it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmoji as V0x19DatatypesCustomEmoji
import it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiKeyword as V0x19DatatypesCustomEmojiKeyword
import it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiResponse as V0x19DatatypesCustomEmojiResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiView as V0x19DatatypesCustomEmojiView
import it.vercruysse.lemmyapi.v0x19.datatypes.DeleteAccount as V0x19DatatypesDeleteAccount
import it.vercruysse.lemmyapi.v0x19.datatypes.DeleteComment as V0x19DatatypesDeleteComment
import it.vercruysse.lemmyapi.v0x19.datatypes.DeleteCommunity as V0x19DatatypesDeleteCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.DeleteCustomEmoji as V0x19DatatypesDeleteCustomEmoji
import it.vercruysse.lemmyapi.v0x19.datatypes.DeletePost as V0x19DatatypesDeletePost
import it.vercruysse.lemmyapi.v0x19.datatypes.DeletePrivateMessage as V0x19DatatypesDeletePrivateMessage
import it.vercruysse.lemmyapi.v0x19.datatypes.DistinguishComment as V0x19DatatypesDistinguishComment
import it.vercruysse.lemmyapi.v0x19.datatypes.EditComment as V0x19DatatypesEditComment
import it.vercruysse.lemmyapi.v0x19.datatypes.EditCommunity as V0x19DatatypesEditCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.EditCustomEmoji as V0x19DatatypesEditCustomEmoji
import it.vercruysse.lemmyapi.v0x19.datatypes.EditPost as V0x19DatatypesEditPost
import it.vercruysse.lemmyapi.v0x19.datatypes.EditPrivateMessage as V0x19DatatypesEditPrivateMessage
import it.vercruysse.lemmyapi.v0x19.datatypes.EditSite as V0x19DatatypesEditSite
import it.vercruysse.lemmyapi.v0x19.datatypes.FeaturePost as V0x19DatatypesFeaturePost
import it.vercruysse.lemmyapi.v0x19.datatypes.FederatedInstances as V0x19DatatypesFederatedInstances
import it.vercruysse.lemmyapi.v0x19.datatypes.FollowCommunity as V0x19DatatypesFollowCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.GetCaptchaResponse as V0x19DatatypesGetCaptchaResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetComment as V0x19DatatypesGetComment
import it.vercruysse.lemmyapi.v0x19.datatypes.GetComments as V0x19DatatypesGetComments
import it.vercruysse.lemmyapi.v0x19.datatypes.GetCommentsResponse as V0x19DatatypesGetCommentsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetCommunity as V0x19DatatypesGetCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.GetCommunityResponse as V0x19DatatypesGetCommunityResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetFederatedInstancesResponse as V0x19DatatypesGetFederatedInstancesResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetModlog as V0x19DatatypesGetModlog
import it.vercruysse.lemmyapi.v0x19.datatypes.GetModlogResponse as V0x19DatatypesGetModlogResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonDetails as V0x19DatatypesGetPersonDetails
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonDetailsResponse as V0x19DatatypesGetPersonDetailsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonMentions as V0x19DatatypesGetPersonMentions
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonMentionsResponse as V0x19DatatypesGetPersonMentionsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPost as V0x19DatatypesGetPost
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPostResponse as V0x19DatatypesGetPostResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPosts as V0x19DatatypesGetPosts
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPostsResponse as V0x19DatatypesGetPostsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPrivateMessages as V0x19DatatypesGetPrivateMessages
import it.vercruysse.lemmyapi.v0x19.datatypes.GetReplies as V0x19DatatypesGetReplies
import it.vercruysse.lemmyapi.v0x19.datatypes.GetRepliesResponse as V0x19DatatypesGetRepliesResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetReportCount as V0x19DatatypesGetReportCount
import it.vercruysse.lemmyapi.v0x19.datatypes.GetReportCountResponse as V0x19DatatypesGetReportCountResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteMetadata as V0x19DatatypesGetSiteMetadata
import it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteMetadataResponse as V0x19DatatypesGetSiteMetadataResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteResponse as V0x19DatatypesGetSiteResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadCountResponse as V0x19DatatypesGetUnreadCountResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadRegistrationApplicationCountResponse as V0x19DatatypesGetUnreadRegistrationApplicationCountResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.HideCommunity as V0x19DatatypesHideCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.Instance as V0x19DatatypesInstance
import it.vercruysse.lemmyapi.v0x19.datatypes.InstanceWithFederationState as V0x19DatatypesInstanceWithFederationState
import it.vercruysse.lemmyapi.v0x19.datatypes.Language as V0x19DatatypesLanguage
import it.vercruysse.lemmyapi.v0x19.datatypes.ListCommentReports as V0x19DatatypesListCommentReports
import it.vercruysse.lemmyapi.v0x19.datatypes.ListCommentReportsResponse as V0x19DatatypesListCommentReportsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ListCommunities as V0x19DatatypesListCommunities
import it.vercruysse.lemmyapi.v0x19.datatypes.ListCommunitiesResponse as V0x19DatatypesListCommunitiesResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ListPostReports as V0x19DatatypesListPostReports
import it.vercruysse.lemmyapi.v0x19.datatypes.ListPostReportsResponse as V0x19DatatypesListPostReportsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ListPrivateMessageReports as V0x19DatatypesListPrivateMessageReports
import it.vercruysse.lemmyapi.v0x19.datatypes.ListPrivateMessageReportsResponse as V0x19DatatypesListPrivateMessageReportsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ListRegistrationApplications as V0x19DatatypesListRegistrationApplications
import it.vercruysse.lemmyapi.v0x19.datatypes.ListRegistrationApplicationsResponse as V0x19DatatypesListRegistrationApplicationsResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.LocalSite as V0x19DatatypesLocalSite
import it.vercruysse.lemmyapi.v0x19.datatypes.LocalSiteRateLimit as V0x19DatatypesLocalSiteRateLimit
import it.vercruysse.lemmyapi.v0x19.datatypes.LocalUser as V0x19DatatypesLocalUser
import it.vercruysse.lemmyapi.v0x19.datatypes.LocalUserView as V0x19DatatypesLocalUserView
import it.vercruysse.lemmyapi.v0x19.datatypes.LockPost as V0x19DatatypesLockPost
import it.vercruysse.lemmyapi.v0x19.datatypes.Login as V0x19DatatypesLogin
import it.vercruysse.lemmyapi.v0x19.datatypes.LoginResponse as V0x19DatatypesLoginResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.MarkCommentReplyAsRead as V0x19DatatypesMarkCommentReplyAsRead
import it.vercruysse.lemmyapi.v0x19.datatypes.MarkPersonMentionAsRead as V0x19DatatypesMarkPersonMentionAsRead
import it.vercruysse.lemmyapi.v0x19.datatypes.MarkPrivateMessageAsRead as V0x19DatatypesMarkPrivateMessageAsRead
import it.vercruysse.lemmyapi.v0x19.datatypes.ModAdd as V0x19DatatypesModAdd
import it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunity as V0x19DatatypesModAddCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunityView as V0x19DatatypesModAddCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModAddView as V0x19DatatypesModAddView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModBan as V0x19DatatypesModBan
import it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunity as V0x19DatatypesModBanFromCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunityView as V0x19DatatypesModBanFromCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModBanView as V0x19DatatypesModBanView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePost as V0x19DatatypesModFeaturePost
import it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePostView as V0x19DatatypesModFeaturePostView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunity as V0x19DatatypesModHideCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunityView as V0x19DatatypesModHideCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPost as V0x19DatatypesModLockPost
import it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPostView as V0x19DatatypesModLockPostView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveComment as V0x19DatatypesModRemoveComment
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommentView as V0x19DatatypesModRemoveCommentView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunity as V0x19DatatypesModRemoveCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunityView as V0x19DatatypesModRemoveCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePost as V0x19DatatypesModRemovePost
import it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePostView as V0x19DatatypesModRemovePostView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunity as V0x19DatatypesModTransferCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunityView as V0x19DatatypesModTransferCommunityView
import it.vercruysse.lemmyapi.v0x19.datatypes.ModlogListParams as V0x19DatatypesModlogListParams
import it.vercruysse.lemmyapi.v0x19.datatypes.MyUserInfo as V0x19DatatypesMyUserInfo
import it.vercruysse.lemmyapi.v0x19.datatypes.PasswordChangeAfterReset as V0x19DatatypesPasswordChangeAfterReset
import it.vercruysse.lemmyapi.v0x19.datatypes.PasswordReset as V0x19DatatypesPasswordReset
import it.vercruysse.lemmyapi.v0x19.datatypes.Person as V0x19DatatypesPerson
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonAggregates as V0x19DatatypesPersonAggregates
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonBlockView as V0x19DatatypesPersonBlockView
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonMention as V0x19DatatypesPersonMention
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionResponse as V0x19DatatypesPersonMentionResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionView as V0x19DatatypesPersonMentionView
import it.vercruysse.lemmyapi.v0x19.datatypes.PersonView as V0x19DatatypesPersonView
import it.vercruysse.lemmyapi.v0x19.datatypes.Post as V0x19DatatypesPost
import it.vercruysse.lemmyapi.v0x19.datatypes.PostAggregates as V0x19DatatypesPostAggregates
import it.vercruysse.lemmyapi.v0x19.datatypes.PostReport as V0x19DatatypesPostReport
import it.vercruysse.lemmyapi.v0x19.datatypes.PostReportResponse as V0x19DatatypesPostReportResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PostReportView as V0x19DatatypesPostReportView
import it.vercruysse.lemmyapi.v0x19.datatypes.PostResponse as V0x19DatatypesPostResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PostView as V0x19DatatypesPostView
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessage as V0x19DatatypesPrivateMessage
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReport as V0x19DatatypesPrivateMessageReport
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportResponse as V0x19DatatypesPrivateMessageReportResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportView as V0x19DatatypesPrivateMessageReportView
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageResponse as V0x19DatatypesPrivateMessageResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageView as V0x19DatatypesPrivateMessageView
import it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessagesResponse as V0x19DatatypesPrivateMessagesResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.PurgeComment as V0x19DatatypesPurgeComment
import it.vercruysse.lemmyapi.v0x19.datatypes.PurgeCommunity as V0x19DatatypesPurgeCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.PurgePerson as V0x19DatatypesPurgePerson
import it.vercruysse.lemmyapi.v0x19.datatypes.PurgePost as V0x19DatatypesPurgePost
import it.vercruysse.lemmyapi.v0x19.datatypes.Register as V0x19DatatypesRegister
import it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplication as V0x19DatatypesRegistrationApplication
import it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationResponse as V0x19DatatypesRegistrationApplicationResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationView as V0x19DatatypesRegistrationApplicationView
import it.vercruysse.lemmyapi.v0x19.datatypes.RemoveComment as V0x19DatatypesRemoveComment
import it.vercruysse.lemmyapi.v0x19.datatypes.RemoveCommunity as V0x19DatatypesRemoveCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.RemovePost as V0x19DatatypesRemovePost
import it.vercruysse.lemmyapi.v0x19.datatypes.ResolveCommentReport as V0x19DatatypesResolveCommentReport
import it.vercruysse.lemmyapi.v0x19.datatypes.ResolveObject as V0x19DatatypesResolveObject
import it.vercruysse.lemmyapi.v0x19.datatypes.ResolveObjectResponse as V0x19DatatypesResolveObjectResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.ResolvePostReport as V0x19DatatypesResolvePostReport
import it.vercruysse.lemmyapi.v0x19.datatypes.ResolvePrivateMessageReport as V0x19DatatypesResolvePrivateMessageReport
import it.vercruysse.lemmyapi.v0x19.datatypes.SaveComment as V0x19DatatypesSaveComment
import it.vercruysse.lemmyapi.v0x19.datatypes.SavePost as V0x19DatatypesSavePost
import it.vercruysse.lemmyapi.v0x19.datatypes.SaveUserSettings as V0x19DatatypesSaveUserSettings
import it.vercruysse.lemmyapi.v0x19.datatypes.Search as V0x19DatatypesSearch
import it.vercruysse.lemmyapi.v0x19.datatypes.SearchResponse as V0x19DatatypesSearchResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.Site as V0x19DatatypesSite
import it.vercruysse.lemmyapi.v0x19.datatypes.SiteAggregates as V0x19DatatypesSiteAggregates
import it.vercruysse.lemmyapi.v0x19.datatypes.SiteMetadata as V0x19DatatypesSiteMetadata
import it.vercruysse.lemmyapi.v0x19.datatypes.SiteResponse as V0x19DatatypesSiteResponse
import it.vercruysse.lemmyapi.v0x19.datatypes.SiteView as V0x19DatatypesSiteView
import it.vercruysse.lemmyapi.v0x19.datatypes.Tagline as V0x19DatatypesTagline
import it.vercruysse.lemmyapi.v0x19.datatypes.TransferCommunity as V0x19DatatypesTransferCommunity
import it.vercruysse.lemmyapi.v0x19.datatypes.VerifyEmail as V0x19DatatypesVerifyEmail

internal class Transformer(var auth: String) : DatatypesMapper {
    private fun mapLocalUserTotp(l: LocalUser): Boolean = l.totp_2fa_url != null

    private fun addTimezoneOffset(d: String): String = d + "Z"

    private fun addTimezoneOffsetNullable(d: String?): String? = d?.let { d + "Z" }

    // Admin flag moved from Person to LocalUser in v0.19
    // https://github.com/LemmyNet/lemmy/pull/3403
    private fun mapLocalUserView(l: LocalUserView): V0x19DatatypesLocalUserView =
        V0x19DatatypesLocalUserView(
            local_user =
                V0x19DatatypesLocalUser(
                    id = l.local_user.id,
                    person_id = l.local_user.person_id,
                    email = l.local_user.email,
                    show_nsfw = l.local_user.show_nsfw,
                    theme = l.local_user.theme,
                    default_sort_type = l.local_user.default_sort_type,
                    default_listing_type = l.local_user.default_listing_type,
                    interface_language = l.local_user.interface_language,
                    show_avatars = l.local_user.show_avatars,
                    send_notifications_to_email = l.local_user.send_notifications_to_email,
                    show_scores = l.local_user.show_scores,
                    show_bot_accounts = l.local_user.show_bot_accounts,
                    show_read_posts = l.local_user.show_read_posts,
                    email_verified = l.local_user.email_verified,
                    accepted_application = l.local_user.accepted_application,
                    open_links_in_new_tab = l.local_user.open_links_in_new_tab,
                    blur_nsfw = false,
                    auto_expand = false,
                    infinite_scroll_enabled = true,
                    admin = l.person.admin,
                    post_listing_mode = PostListingMode.Card,
                    totp_2fa_enabled = l.local_user.let { this.mapLocalUserTotp(it) },
                    enable_keyboard_navigation = false,
                    enable_animated_images = true,
                    collapse_bot_comments = false,
                ),
            person = this.toV0x19(l.person),
            counts = this.toV0x19(l.counts),
        )

    override fun toV0x19(d: V0x18DatatypesLocalUserView): V0x19DatatypesLocalUserView = this.mapLocalUserView(d)

    // Generated
    override fun toV0x19(d: V0x18DatatypesLocalUser): V0x19DatatypesLocalUser =
        it.vercruysse.lemmyapi.v0x19.datatypes.LocalUser(
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
            collapse_bot_comments = false,
        )

    override fun toV0x19(d: V0x18DatatypesMyUserInfo): V0x19DatatypesMyUserInfo =
        it.vercruysse.lemmyapi.v0x19.datatypes.MyUserInfo(
            local_user_view = this.toV0x19(d = d.local_user_view),
            follows = d.follows.map { this.toV0x19(d = it) },
            moderates = d.moderates.map { this.toV0x19(d = it) },
            community_blocks = d.community_blocks.map { this.toV0x19(d = it) },
            instance_blocks = listOf(),
            person_blocks = d.person_blocks.map { this.toV0x19(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toV0x19(d: V0x18DatatypesLocalSiteRateLimit): V0x19DatatypesLocalSiteRateLimit =
        it.vercruysse.lemmyapi.v0x19.datatypes.LocalSiteRateLimit(
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
            import_user_settings_per_second = -1,
        )

    override fun toV0x19(d: V0x18DatatypesAddAdminResponse): V0x19DatatypesAddAdminResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.AddAdminResponse(
            admins = d.admins.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesAddModToCommunityResponse): V0x19DatatypesAddModToCommunityResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.AddModToCommunityResponse(
            moderators = d.moderators.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgeComment): V0x19DatatypesAdminPurgeComment =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeComment(
            id = d.id,
            admin_person_id = d.admin_person_id,
            post_id = d.post_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgeCommentView): V0x19DatatypesAdminPurgeCommentView =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommentView(
            admin_purge_comment = this.toV0x19(d = d.admin_purge_comment),
            admin = d.admin?.let { this.toV0x19(d = it) },
            post = this.toV0x19(d = d.post),
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgeCommunity): V0x19DatatypesAdminPurgeCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunity(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgeCommunityView): V0x19DatatypesAdminPurgeCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgeCommunityView(
            admin_purge_community = this.toV0x19(d = d.admin_purge_community),
            admin = d.admin?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgePerson): V0x19DatatypesAdminPurgePerson =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePerson(
            id = d.id,
            admin_person_id = d.admin_person_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgePersonView): V0x19DatatypesAdminPurgePersonView =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePersonView(
            admin_purge_person = this.toV0x19(d = d.admin_purge_person),
            admin = d.admin?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgePost): V0x19DatatypesAdminPurgePost =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePost(
            id = d.id,
            admin_person_id = d.admin_person_id,
            community_id = d.community_id,
            reason = d.reason,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesAdminPurgePostView): V0x19DatatypesAdminPurgePostView =
        it.vercruysse.lemmyapi.v0x19.datatypes.AdminPurgePostView(
            admin_purge_post = this.toV0x19(d = d.admin_purge_post),
            admin = d.admin?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesBanFromCommunityResponse): V0x19DatatypesBanFromCommunityResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.BanFromCommunityResponse(
            person_view = this.toV0x19(d = d.person_view),
            banned = d.banned,
        )

    override fun toV0x19(d: V0x18DatatypesBannedPersonsResponse): V0x19DatatypesBannedPersonsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.BannedPersonsResponse(
            banned = d.banned.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesBanPersonResponse): V0x19DatatypesBanPersonResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.BanPersonResponse(
            person_view = this.toV0x19(d = d.person_view),
            banned = d.banned,
        )

    override fun toV0x19(d: V0x18DatatypesBlockCommunityResponse): V0x19DatatypesBlockCommunityResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.BlockCommunityResponse(
            community_view = this.toV0x19(d = d.community_view),
            blocked = d.blocked,
        )

    override fun toV0x19(d: V0x18DatatypesBlockPersonResponse): V0x19DatatypesBlockPersonResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.BlockPersonResponse(
            person_view = this.toV0x19(d = d.person_view),
            blocked = d.blocked,
        )

    override fun toV0x19(d: V0x18DatatypesCaptchaResponse): V0x19DatatypesCaptchaResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CaptchaResponse(
            png = d.png,
            wav = d.wav,
            uuid = d.uuid,
        )

    override fun toV0x19(d: V0x18DatatypesComment): V0x19DatatypesComment =
        it.vercruysse.lemmyapi.v0x19.datatypes.Comment(
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
            language_id = d.language_id,
        )

    override fun toV0x19(d: V0x18DatatypesCommentAggregates): V0x19DatatypesCommentAggregates =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentAggregates(
            comment_id = d.comment_id,
            score = d.score,
            upvotes = d.upvotes,
            downvotes = d.downvotes,
            published = addTimezoneOffset(d.published),
            child_count = d.child_count,
        )

    override fun toV0x19(d: V0x18DatatypesCommentReply): V0x19DatatypesCommentReply =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReply(
            id = d.id,
            recipient_id = d.recipient_id,
            comment_id = d.comment_id,
            read = d.read,
            published = addTimezoneOffset(d.published),
        )

    override fun toV0x19(d: V0x18DatatypesCommentReplyResponse): V0x19DatatypesCommentReplyResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyResponse(
            comment_reply_view = this.toV0x19(d = d.comment_reply_view),
        )

    override fun toV0x19(d: V0x18DatatypesCommentReplyView): V0x19DatatypesCommentReplyView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReplyView(
            comment_reply = this.toV0x19(d = d.comment_reply),
            comment = this.toV0x19(d = d.comment),
            creator = this.toV0x19(d = d.creator),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
            recipient = this.toV0x19(d = d.recipient),
            counts = this.toV0x19(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote,
            creator_is_admin = false,
            creator_is_moderator = false,
        )

    override fun toV0x19(d: V0x18DatatypesCommentReport): V0x19DatatypesCommentReport =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReport(
            id = d.id,
            creator_id = d.creator_id,
            comment_id = d.comment_id,
            original_comment_text = d.original_comment_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
        )

    override fun toV0x19(d: V0x18DatatypesCommentReportResponse): V0x19DatatypesCommentReportResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportResponse(
            comment_report_view = this.toV0x19(d = d.comment_report_view),
        )

    override fun toV0x19(d: V0x18DatatypesCommentReportView): V0x19DatatypesCommentReportView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentReportView(
            comment_report = this.toV0x19(d = d.comment_report),
            comment = this.toV0x19(d = d.comment),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
            creator = this.toV0x19(d = d.creator),
            comment_creator = this.toV0x19(d = d.comment_creator),
            counts = this.toV0x19(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            my_vote = d.my_vote,
            resolver = d.resolver?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesCommentResponse): V0x19DatatypesCommentResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentResponse(
            comment_view = this.toV0x19(d = d.comment_view),
            recipient_ids = d.recipient_ids,
        )

    override fun toV0x19(d: V0x18DatatypesCommentView): V0x19DatatypesCommentView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommentView(
            comment = this.toV0x19(d = d.comment),
            creator = this.toV0x19(d = d.creator),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
            counts = this.toV0x19(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote,
            creator_is_admin = false,
            creator_is_moderator = false,
        )

    override fun toV0x19(d: V0x18DatatypesCommunity): V0x19DatatypesCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.Community(
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
        )

    override fun toV0x19(d: V0x18DatatypesCommunityAggregates): V0x19DatatypesCommunityAggregates =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityAggregates(
            community_id = d.community_id,
            subscribers = d.subscribers,
            posts = d.posts,
            comments = d.comments,
            published = addTimezoneOffset(d.published),
            users_active_day = d.users_active_day,
            users_active_week = d.users_active_week,
            users_active_month = d.users_active_month,
            users_active_half_year = d.users_active_half_year,
            subscribers_local = null,
        )

    override fun toV0x19(d: V0x18DatatypesCommunityBlockView): V0x19DatatypesCommunityBlockView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityBlockView(
            person = this.toV0x19(d = d.person),
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesCommunityFollowerView): V0x19DatatypesCommunityFollowerView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityFollowerView(
            community = this.toV0x19(d = d.community),
            follower = this.toV0x19(d = d.follower),
        )

    override fun toV0x19(d: V0x18DatatypesCommunityModeratorView): V0x19DatatypesCommunityModeratorView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityModeratorView(
            community = this.toV0x19(d = d.community),
            moderator = this.toV0x19(d = d.moderator),
        )

    override fun toV0x19(d: V0x18DatatypesCommunityResponse): V0x19DatatypesCommunityResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityResponse(
            community_view = this.toV0x19(d = d.community_view),
            discussion_languages = d.discussion_languages,
        )

    override fun toV0x19(d: V0x18DatatypesCommunityView): V0x19DatatypesCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CommunityView(
            community = this.toV0x19(d = d.community),
            subscribed = d.subscribed,
            blocked = d.blocked,
            counts = this.toV0x19(d = d.counts),
        )

    override fun toV0x19(d: V0x18DatatypesCustomEmoji): V0x19DatatypesCustomEmoji =
        it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmoji(
            id = d.id,
            local_site_id = d.local_site_id,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            category = d.category,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
        )

    override fun toV0x19(d: V0x18DatatypesCustomEmojiKeyword): V0x19DatatypesCustomEmojiKeyword =
        it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiKeyword(
            custom_emoji_id = d.custom_emoji_id,
            keyword = d.keyword,
        )

    override fun toV0x19(d: V0x18DatatypesCustomEmojiResponse): V0x19DatatypesCustomEmojiResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiResponse(
            custom_emoji = this.toV0x19(d = d.custom_emoji),
        )

    override fun toV0x19(d: V0x18DatatypesCustomEmojiView): V0x19DatatypesCustomEmojiView =
        it.vercruysse.lemmyapi.v0x19.datatypes.CustomEmojiView(
            custom_emoji = this.toV0x19(d = d.custom_emoji),
            keywords = d.keywords.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesFederatedInstances): V0x19DatatypesFederatedInstances =
        it.vercruysse.lemmyapi.v0x19.datatypes.FederatedInstances(
            linked = d.linked.map { this.toV0x19F(d = it) },
            allowed = d.allowed.map { this.toV0x19F(d = it) },
            blocked = d.blocked.map { this.toV0x19F(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetCaptchaResponse): V0x19DatatypesGetCaptchaResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetCaptchaResponse(
            ok = d.ok?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetCommentsResponse): V0x19DatatypesGetCommentsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetCommentsResponse(
            comments = d.comments.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetCommunityResponse): V0x19DatatypesGetCommunityResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetCommunityResponse(
            community_view = this.toV0x19(d = d.community_view),
            site = d.site?.let { this.toV0x19(d = it) },
            moderators = d.moderators.map { this.toV0x19(d = it) },
            discussion_languages = d.discussion_languages,
        )

    override fun toV0x19(d: V0x18DatatypesGetFederatedInstancesResponse): V0x19DatatypesGetFederatedInstancesResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetFederatedInstancesResponse(
            federated_instances = d.federated_instances?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetModlogResponse): V0x19DatatypesGetModlogResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetModlogResponse(
            removed_posts = d.removed_posts.map { this.toV0x19(d = it) },
            locked_posts = d.locked_posts.map { this.toV0x19(d = it) },
            featured_posts = d.featured_posts.map { this.toV0x19(d = it) },
            removed_comments = d.removed_comments.map { this.toV0x19(d = it) },
            removed_communities = d.removed_communities.map { this.toV0x19(d = it) },
            banned_from_community = d.banned_from_community.map { this.toV0x19(d = it) },
            banned = d.banned.map { this.toV0x19(d = it) },
            added_to_community = d.added_to_community.map { this.toV0x19(d = it) },
            transferred_to_community = d.transferred_to_community.map { this.toV0x19(d = it) },
            added = d.added.map { this.toV0x19(d = it) },
            admin_purged_persons = d.admin_purged_persons.map { this.toV0x19(d = it) },
            admin_purged_communities = d.admin_purged_communities.map { this.toV0x19(d = it) },
            admin_purged_posts = d.admin_purged_posts.map { this.toV0x19(d = it) },
            admin_purged_comments = d.admin_purged_comments.map { this.toV0x19(d = it) },
            hidden_communities = d.hidden_communities.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetPersonDetailsResponse): V0x19DatatypesGetPersonDetailsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonDetailsResponse(
            person_view = this.toV0x19(d = d.person_view),
            comments = d.comments.map { this.toV0x19(d = it) },
            posts = d.posts.map { this.toV0x19(d = it) },
            moderates = d.moderates.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetPersonMentionsResponse): V0x19DatatypesGetPersonMentionsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetPersonMentionsResponse(
            mentions = d.mentions.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetPostResponse): V0x19DatatypesGetPostResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetPostResponse(
            post_view = this.toV0x19(d = d.post_view),
            community_view = this.toV0x19(d = d.community_view),
            moderators = d.moderators.map { this.toV0x19(d = it) },
            cross_posts = d.cross_posts.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetPostsResponse): V0x19DatatypesGetPostsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetPostsResponse(
            posts = d.posts.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetRepliesResponse): V0x19DatatypesGetRepliesResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetRepliesResponse(
            replies = d.replies.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetReportCountResponse): V0x19DatatypesGetReportCountResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetReportCountResponse(
            community_id = d.community_id,
            comment_reports = d.comment_reports,
            post_reports = d.post_reports,
            private_message_reports = d.private_message_reports,
        )

    override fun toV0x19(d: V0x18DatatypesGetSiteMetadataResponse): V0x19DatatypesGetSiteMetadataResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteMetadataResponse(
            metadata = this.toV0x19(d = d.metadata),
        )

    override fun toV0x19(d: V0x18DatatypesGetSiteResponse): V0x19DatatypesGetSiteResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetSiteResponse(
            site_view = this.toV0x19(d = d.site_view),
            admins = d.admins.map { this.toV0x19(d = it) },
            version = d.version,
            my_user = d.my_user?.let { this.toV0x19(d = it) },
            all_languages = d.all_languages.map { this.toV0x19(d = it) },
            discussion_languages = d.discussion_languages,
            taglines = d.taglines.map { this.toV0x19(d = it) },
            custom_emojis = d.custom_emojis.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesGetUnreadCountResponse): V0x19DatatypesGetUnreadCountResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadCountResponse(
            replies = d.replies,
            mentions = d.mentions,
            private_messages = d.private_messages,
        )

    override fun toV0x19(
        d: V0x18DatatypesGetUnreadRegistrationApplicationCountResponse,
    ): V0x19DatatypesGetUnreadRegistrationApplicationCountResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.GetUnreadRegistrationApplicationCountResponse(
            registration_applications = d.registration_applications,
        )

    override fun toV0x19(d: V0x18DatatypesInstance): V0x19DatatypesInstance =
        it.vercruysse.lemmyapi.v0x19.datatypes.Instance(
            id = d.id,
            domain = d.domain,
            published = addTimezoneOffset(d.published),
            updated = d.updated,
            software = d.software,
            version = d.version,
        )

    override fun toV0x19F(d: V0x18DatatypesInstance): V0x19DatatypesInstanceWithFederationState =
        it.vercruysse.lemmyapi.v0x19.datatypes.InstanceWithFederationState(
            id = d.id,
            domain = d.domain,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            software = d.software,
            version = d.version,
        )

    override fun toV0x19(d: V0x18DatatypesLanguage): V0x19DatatypesLanguage =
        it.vercruysse.lemmyapi.v0x19.datatypes.Language(
            id = d.id,
            code = d.code,
            name = d.name,
        )

    override fun toV0x19(d: V0x18DatatypesListCommentReportsResponse): V0x19DatatypesListCommentReportsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ListCommentReportsResponse(
            comment_reports = d.comment_reports.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesListCommunitiesResponse): V0x19DatatypesListCommunitiesResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ListCommunitiesResponse(
            communities = d.communities.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesListPostReportsResponse): V0x19DatatypesListPostReportsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ListPostReportsResponse(
            post_reports = d.post_reports.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesListPrivateMessageReportsResponse): V0x19DatatypesListPrivateMessageReportsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ListPrivateMessageReportsResponse(
            private_message_reports = d.private_message_reports.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesListRegistrationApplicationsResponse): V0x19DatatypesListRegistrationApplicationsResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ListRegistrationApplicationsResponse(
            registration_applications = d.registration_applications.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesLocalSite): V0x19DatatypesLocalSite =
        it.vercruysse.lemmyapi.v0x19.datatypes.LocalSite(
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
        )

    override fun toV0x19(d: V0x18DatatypesLoginResponse): V0x19DatatypesLoginResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.LoginResponse(
            jwt = d.jwt,
            registration_created = d.registration_created,
            verify_email_sent = d.verify_email_sent,
        )

    override fun toV0x19(d: V0x18DatatypesModAdd): V0x19DatatypesModAdd =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModAdd(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModAddCommunity): V0x19DatatypesModAddCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModAddCommunityView): V0x19DatatypesModAddCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModAddCommunityView(
            mod_add_community = this.toV0x19(d = d.mod_add_community),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
            modded_person = this.toV0x19(d = d.modded_person),
        )

    override fun toV0x19(d: V0x18DatatypesModAddView): V0x19DatatypesModAddView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModAddView(
            mod_add = this.toV0x19(d = d.mod_add),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            modded_person = this.toV0x19(d = d.modded_person),
        )

    override fun toV0x19(d: V0x18DatatypesModBan): V0x19DatatypesModBan =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModBan(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            reason = d.reason,
            banned = d.banned,
            expires = addTimezoneOffsetNullable(d.expires),
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModBanFromCommunity): V0x19DatatypesModBanFromCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            reason = d.reason,
            banned = d.banned,
            expires = addTimezoneOffsetNullable(d.expires),
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModBanFromCommunityView): V0x19DatatypesModBanFromCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModBanFromCommunityView(
            mod_ban_from_community = this.toV0x19(d = d.mod_ban_from_community),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
            banned_person = this.toV0x19(d = d.banned_person),
        )

    override fun toV0x19(d: V0x18DatatypesModBanView): V0x19DatatypesModBanView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModBanView(
            mod_ban = this.toV0x19(d = d.mod_ban),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            banned_person = this.toV0x19(d = d.banned_person),
        )

    override fun toV0x19(d: V0x18DatatypesModFeaturePost): V0x19DatatypesModFeaturePost =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            featured = d.featured,
            when_ = addTimezoneOffset(d.when_),
            is_featured_community = d.is_featured_community,
        )

    override fun toV0x19(d: V0x18DatatypesModFeaturePostView): V0x19DatatypesModFeaturePostView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModFeaturePostView(
            mod_feature_post = this.toV0x19(d = d.mod_feature_post),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModHideCommunity): V0x19DatatypesModHideCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunity(
            id = d.id,
            community_id = d.community_id,
            mod_person_id = d.mod_person_id,
            when_ = addTimezoneOffset(d.when_),
            reason = d.reason,
            hidden = d.hidden,
        )

    override fun toV0x19(d: V0x18DatatypesModHideCommunityView): V0x19DatatypesModHideCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModHideCommunityView(
            mod_hide_community = this.toV0x19(d = d.mod_hide_community),
            admin = d.admin?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModLockPost): V0x19DatatypesModLockPost =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            locked = d.locked,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModLockPostView): V0x19DatatypesModLockPostView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModLockPostView(
            mod_lock_post = this.toV0x19(d = d.mod_lock_post),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModlogListParams): V0x19DatatypesModlogListParams =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModlogListParams(
            community_id = d.community_id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            page = d.page,
            limit = d.limit,
            hide_modlog_names = d.hide_modlog_names,
        )

    override fun toV0x19(d: V0x18DatatypesModRemoveComment): V0x19DatatypesModRemoveComment =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveComment(
            id = d.id,
            mod_person_id = d.mod_person_id,
            comment_id = d.comment_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModRemoveCommentView): V0x19DatatypesModRemoveCommentView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommentView(
            mod_remove_comment = this.toV0x19(d = d.mod_remove_comment),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            comment = this.toV0x19(d = d.comment),
            commenter = this.toV0x19(d = d.commenter),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModRemoveCommunity): V0x19DatatypesModRemoveCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            community_id = d.community_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModRemoveCommunityView): V0x19DatatypesModRemoveCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemoveCommunityView(
            mod_remove_community = this.toV0x19(d = d.mod_remove_community),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModRemovePost): V0x19DatatypesModRemovePost =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePost(
            id = d.id,
            mod_person_id = d.mod_person_id,
            post_id = d.post_id,
            reason = d.reason,
            removed = d.removed,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModRemovePostView): V0x19DatatypesModRemovePostView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModRemovePostView(
            mod_remove_post = this.toV0x19(d = d.mod_remove_post),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
        )

    override fun toV0x19(d: V0x18DatatypesModTransferCommunity): V0x19DatatypesModTransferCommunity =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunity(
            id = d.id,
            mod_person_id = d.mod_person_id,
            other_person_id = d.other_person_id,
            community_id = d.community_id,
            when_ = addTimezoneOffset(d.when_),
        )

    override fun toV0x19(d: V0x18DatatypesModTransferCommunityView): V0x19DatatypesModTransferCommunityView =
        it.vercruysse.lemmyapi.v0x19.datatypes.ModTransferCommunityView(
            mod_transfer_community = this.toV0x19(d = d.mod_transfer_community),
            moderator = d.moderator?.let { this.toV0x19(d = it) },
            community = this.toV0x19(d = d.community),
            modded_person = this.toV0x19(d = d.modded_person),
        )

    override fun toV0x19(d: V0x18DatatypesPerson): V0x19DatatypesPerson =
        it.vercruysse.lemmyapi.v0x19.datatypes.Person(
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
            instance_id = d.instance_id,
        )

    override fun toV0x19(d: V0x18DatatypesPersonAggregates): V0x19DatatypesPersonAggregates =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonAggregates(
            person_id = d.person_id,
            post_count = d.post_count,
            comment_count = d.comment_count,
        )

    override fun toV0x19(d: V0x18DatatypesPersonBlockView): V0x19DatatypesPersonBlockView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonBlockView(
            person = this.toV0x19(d = d.person),
            target = this.toV0x19(d = d.target),
        )

    override fun toV0x19(d: V0x18DatatypesPersonMention): V0x19DatatypesPersonMention =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonMention(
            id = d.id,
            recipient_id = d.recipient_id,
            comment_id = d.comment_id,
            read = d.read,
            published = addTimezoneOffset(d.published),
        )

    override fun toV0x19(d: V0x18DatatypesPersonMentionResponse): V0x19DatatypesPersonMentionResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionResponse(
            person_mention_view = this.toV0x19(d = d.person_mention_view),
        )

    override fun toV0x19(d: V0x18DatatypesPersonMentionView): V0x19DatatypesPersonMentionView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonMentionView(
            person_mention = this.toV0x19(d = d.person_mention),
            comment = this.toV0x19(d = d.comment),
            creator = this.toV0x19(d = d.creator),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
            recipient = this.toV0x19(d = d.recipient),
            counts = this.toV0x19(d = d.counts),
            creator_banned_from_community = d.creator_banned_from_community,
            subscribed = d.subscribed,
            saved = d.saved,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote,
            creator_is_admin = false,
            creator_is_moderator = false,
        )

    override fun toV0x19(d: V0x18DatatypesPersonView): V0x19DatatypesPersonView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PersonView(
            person = this.toV0x19(d = d.person),
            counts = this.toV0x19(d = d.counts),
            // TODO could possibly be done better in some places
            is_admin = false,
        )

    override fun toV0x19(d: V0x18DatatypesPost): V0x19DatatypesPost =
        it.vercruysse.lemmyapi.v0x19.datatypes.Post(
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
            featured_local = d.featured_local,
        )

    override fun toV0x19(d: V0x18DatatypesPostAggregates): V0x19DatatypesPostAggregates =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostAggregates(
            post_id = d.post_id,
            comments = d.comments,
            score = d.score,
            upvotes = d.upvotes,
            downvotes = d.downvotes,
            published = addTimezoneOffset(d.published),
        )

    override fun toV0x19(d: V0x18DatatypesPostReport): V0x19DatatypesPostReport =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostReport(
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
            updated = addTimezoneOffsetNullable(d.updated),
        )

    override fun toV0x19(d: V0x18DatatypesPostReportResponse): V0x19DatatypesPostReportResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostReportResponse(
            post_report_view = this.toV0x19(d = d.post_report_view),
        )

    override fun toV0x19(d: V0x18DatatypesPostReportView): V0x19DatatypesPostReportView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostReportView(
            post_report = this.toV0x19(d = d.post_report),
            post = this.toV0x19(d = d.post),
            community = this.toV0x19(d = d.community),
            creator = this.toV0x19(d = d.creator),
            post_creator = this.toV0x19(d = d.post_creator),
            creator_banned_from_community = d.creator_banned_from_community,
            my_vote = d.my_vote,
            counts = this.toV0x19(d = d.counts),
            resolver = d.resolver?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesPostResponse): V0x19DatatypesPostResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostResponse(
            post_view = this.toV0x19(d = d.post_view),
        )

    override fun toV0x19(d: V0x18DatatypesPostView): V0x19DatatypesPostView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PostView(
            post = this.toV0x19(d = d.post),
            creator = this.toV0x19(d = d.creator),
            community = this.toV0x19(d = d.community),
            creator_banned_from_community = d.creator_banned_from_community,
            counts = this.toV0x19(d = d.counts),
            subscribed = d.subscribed,
            saved = d.saved,
            read = d.read,
            creator_blocked = d.creator_blocked,
            my_vote = d.my_vote,
            unread_comments = d.unread_comments,
            creator_is_admin = false,
            creator_is_moderator = false,
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessage): V0x19DatatypesPrivateMessage =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessage(
            id = d.id,
            creator_id = d.creator_id,
            recipient_id = d.recipient_id,
            content = d.content,
            deleted = d.deleted,
            read = d.read,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
            ap_id = d.ap_id,
            local = d.local,
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessageReport): V0x19DatatypesPrivateMessageReport =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReport(
            id = d.id,
            creator_id = d.creator_id,
            private_message_id = d.private_message_id,
            original_pm_text = d.original_pm_text,
            reason = d.reason,
            resolved = d.resolved,
            resolver_id = d.resolver_id,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessageReportResponse): V0x19DatatypesPrivateMessageReportResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportResponse(
            private_message_report_view = this.toV0x19(d = d.private_message_report_view),
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessageReportView): V0x19DatatypesPrivateMessageReportView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageReportView(
            private_message_report = this.toV0x19(d = d.private_message_report),
            private_message = this.toV0x19(d = d.private_message),
            private_message_creator = this.toV0x19(d = d.private_message_creator),
            creator = this.toV0x19(d = d.creator),
            resolver = d.resolver?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessageResponse): V0x19DatatypesPrivateMessageResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageResponse(
            private_message_view = this.toV0x19(d = d.private_message_view),
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessagesResponse): V0x19DatatypesPrivateMessagesResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessagesResponse(
            private_messages = d.private_messages.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesPrivateMessageView): V0x19DatatypesPrivateMessageView =
        it.vercruysse.lemmyapi.v0x19.datatypes.PrivateMessageView(
            private_message = this.toV0x19(d = d.private_message),
            creator = this.toV0x19(d = d.creator),
            recipient = this.toV0x19(d = d.recipient),
        )

    override fun toV0x19(d: V0x18DatatypesRegistrationApplication): V0x19DatatypesRegistrationApplication =
        it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplication(
            id = d.id,
            local_user_id = d.local_user_id,
            answer = d.answer,
            admin_id = d.admin_id,
            deny_reason = d.deny_reason,
            published = addTimezoneOffset(d.published),
        )

    override fun toV0x19(d: V0x18DatatypesRegistrationApplicationResponse): V0x19DatatypesRegistrationApplicationResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationResponse(
            registration_application = this.toV0x19(d = d.registration_application),
        )

    override fun toV0x19(d: V0x18DatatypesRegistrationApplicationView): V0x19DatatypesRegistrationApplicationView =
        it.vercruysse.lemmyapi.v0x19.datatypes.RegistrationApplicationView(
            registration_application = this.toV0x19(d = d.registration_application),
            creator_local_user = this.toV0x19(d = d.creator_local_user),
            creator = this.toV0x19(d = d.creator),
            admin = d.admin?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesResolveObjectResponse): V0x19DatatypesResolveObjectResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.ResolveObjectResponse(
            comment = d.comment?.let { this.toV0x19(d = it) },
            post = d.post?.let { this.toV0x19(d = it) },
            community = d.community?.let { this.toV0x19(d = it) },
            person = d.person?.let { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesSearchResponse): V0x19DatatypesSearchResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.SearchResponse(
            type_ = d.type_,
            comments = d.comments.map { this.toV0x19(d = it) },
            posts = d.posts.map { this.toV0x19(d = it) },
            communities = d.communities.map { this.toV0x19(d = it) },
            users = d.users.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesSite): V0x19DatatypesSite =
        it.vercruysse.lemmyapi.v0x19.datatypes.Site(
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
            private_key = d.private_key,
            public_key = d.public_key,
            instance_id = d.instance_id,
        )

    override fun toV0x19(d: V0x18DatatypesSiteAggregates): V0x19DatatypesSiteAggregates =
        it.vercruysse.lemmyapi.v0x19.datatypes.SiteAggregates(
            site_id = d.site_id,
            users = d.users,
            posts = d.posts,
            comments = d.comments,
            communities = d.communities,
            users_active_day = d.users_active_day,
            users_active_week = d.users_active_week,
            users_active_month = d.users_active_month,
            users_active_half_year = d.users_active_half_year,
        )

    override fun toV0x19(d: V0x18DatatypesSiteMetadata): V0x19DatatypesSiteMetadata =
        it.vercruysse.lemmyapi.v0x19.datatypes.SiteMetadata(
            title = d.title,
            description = d.description,
            image = d.image,
            embed_video_url = d.embed_video_url,
        )

    override fun toV0x19(d: V0x18DatatypesSiteResponse): V0x19DatatypesSiteResponse =
        it.vercruysse.lemmyapi.v0x19.datatypes.SiteResponse(
            site_view = this.toV0x19(d = d.site_view),
            taglines = d.taglines.map { this.toV0x19(d = it) },
        )

    override fun toV0x19(d: V0x18DatatypesSiteView): V0x19DatatypesSiteView =
        it.vercruysse.lemmyapi.v0x19.datatypes.SiteView(
            site = this.toV0x19(d = d.site),
            local_site = this.toV0x19(d = d.local_site),
            local_site_rate_limit = this.toV0x19(d = d.local_site_rate_limit),
            counts = this.toV0x19(d = d.counts),
        )

    override fun toV0x19(d: V0x18DatatypesTagline): V0x19DatatypesTagline =
        it.vercruysse.lemmyapi.v0x19.datatypes.Tagline(
            id = d.id,
            local_site_id = d.local_site_id,
            content = d.content,
            published = addTimezoneOffset(d.published),
            updated = addTimezoneOffsetNullable(d.updated),
        )

    override fun toV0x18(d: V0x19DatatypesAddAdmin): V0x18DatatypesAddAdmin =
        it.vercruysse.lemmyapi.v0x18.datatypes.AddAdmin(
            person_id = d.person_id,
            added = d.added,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesAddModToCommunity): V0x18DatatypesAddModToCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.AddModToCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            added = d.added,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesApproveRegistrationApplication): V0x18DatatypesApproveRegistrationApplication =
        it.vercruysse.lemmyapi.v0x18.datatypes.ApproveRegistrationApplication(
            id = d.id,
            approve = d.approve,
            deny_reason = d.deny_reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesBanFromCommunity): V0x18DatatypesBanFromCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.BanFromCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_data,
            reason = d.reason,
            expires = d.expires,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesBanPerson): V0x18DatatypesBanPerson =
        it.vercruysse.lemmyapi.v0x18.datatypes.BanPerson(
            person_id = d.person_id,
            ban = d.ban,
            remove_data = d.remove_data,
            reason = d.reason,
            expires = d.expires,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesBlockCommunity): V0x18DatatypesBlockCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.BlockCommunity(
            community_id = d.community_id,
            block = d.block,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesBlockPerson): V0x18DatatypesBlockPerson =
        it.vercruysse.lemmyapi.v0x18.datatypes.BlockPerson(
            person_id = d.person_id,
            block = d.block,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesChangePassword): V0x18DatatypesChangePassword =
        it.vercruysse.lemmyapi.v0x18.datatypes.ChangePassword(
            new_password = d.new_password,
            new_password_verify = d.new_password_verify,
            old_password = d.old_password,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateComment): V0x18DatatypesCreateComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateComment(
            content = d.content,
            post_id = d.post_id,
            parent_id = d.parent_id,
            language_id = d.language_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateCommentLike): V0x18DatatypesCreateCommentLike =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommentLike(
            comment_id = d.comment_id,
            score = d.score,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateCommentReport): V0x18DatatypesCreateCommentReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommentReport(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateCommunity): V0x18DatatypesCreateCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateCommunity(
            name = d.name,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateCustomEmoji): V0x18DatatypesCreateCustomEmoji =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateCustomEmoji(
            category = d.category,
            shortcode = d.shortcode,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreatePost): V0x18DatatypesCreatePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreatePost(
            name = d.name,
            community_id = d.community_id,
            url = d.url,
            body = d.body,
            honeypot = d.honeypot,
            nsfw = d.nsfw,
            language_id = d.language_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreatePostLike): V0x18DatatypesCreatePostLike =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreatePostLike(
            post_id = d.post_id,
            score = d.score,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreatePostReport): V0x18DatatypesCreatePostReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreatePostReport(
            post_id = d.post_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreatePrivateMessage): V0x18DatatypesCreatePrivateMessage =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreatePrivateMessage(
            content = d.content,
            recipient_id = d.recipient_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreatePrivateMessageReport): V0x18DatatypesCreatePrivateMessageReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreatePrivateMessageReport(
            private_message_id = d.private_message_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesCreateSite): V0x18DatatypesCreateSite =
        it.vercruysse.lemmyapi.v0x18.datatypes.CreateSite(
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
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeleteAccount): V0x18DatatypesDeleteAccount =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeleteAccount(
            password = d.password,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeleteComment): V0x18DatatypesDeleteComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeleteComment(
            comment_id = d.comment_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeleteCommunity): V0x18DatatypesDeleteCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeleteCommunity(
            community_id = d.community_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeleteCustomEmoji): V0x18DatatypesDeleteCustomEmoji =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeleteCustomEmoji(
            id = d.id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeletePost): V0x18DatatypesDeletePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeletePost(
            post_id = d.post_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDeletePrivateMessage): V0x18DatatypesDeletePrivateMessage =
        it.vercruysse.lemmyapi.v0x18.datatypes.DeletePrivateMessage(
            private_message_id = d.private_message_id,
            deleted = d.deleted,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesDistinguishComment): V0x18DatatypesDistinguishComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.DistinguishComment(
            comment_id = d.comment_id,
            distinguished = d.distinguished,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditComment): V0x18DatatypesEditComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditComment(
            comment_id = d.comment_id,
            content = d.content,
            language_id = d.language_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditCommunity): V0x18DatatypesEditCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditCommunity(
            community_id = d.community_id,
            title = d.title,
            description = d.description,
            icon = d.icon,
            banner = d.banner,
            nsfw = d.nsfw,
            posting_restricted_to_mods = d.posting_restricted_to_mods,
            discussion_languages = d.discussion_languages,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditCustomEmoji): V0x18DatatypesEditCustomEmoji =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditCustomEmoji(
            id = d.id,
            category = d.category,
            image_url = d.image_url,
            alt_text = d.alt_text,
            keywords = d.keywords,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditPost): V0x18DatatypesEditPost =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditPost(
            post_id = d.post_id,
            name = d.name,
            url = d.url,
            body = d.body,
            nsfw = d.nsfw,
            language_id = d.language_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditPrivateMessage): V0x18DatatypesEditPrivateMessage =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditPrivateMessage(
            private_message_id = d.private_message_id,
            content = d.content,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesEditSite): V0x18DatatypesEditSite =
        it.vercruysse.lemmyapi.v0x18.datatypes.EditSite(
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
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesFeaturePost): V0x18DatatypesFeaturePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.FeaturePost(
            post_id = d.post_id,
            featured = d.featured,
            feature_type = d.feature_type,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesFollowCommunity): V0x18DatatypesFollowCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.FollowCommunity(
            community_id = d.community_id,
            follow = d.follow,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetComment): V0x18DatatypesGetComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetComment(
            id = d.id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetComments): V0x18DatatypesGetComments =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetComments(
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
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetCommunity): V0x18DatatypesGetCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetCommunity(
            id = d.id,
            name = d.name,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetModlog): V0x18DatatypesGetModlog =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetModlog(
            mod_person_id = d.mod_person_id,
            community_id = d.community_id,
            page = d.page,
            limit = d.limit,
            type_ = d.type_,
            other_person_id = d.other_person_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetPersonDetails): V0x18DatatypesGetPersonDetails =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonDetails(
            person_id = d.person_id,
            username = d.username,
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            community_id = d.community_id,
            saved_only = d.saved_only,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetPersonMentions): V0x18DatatypesGetPersonMentions =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetPersonMentions(
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetPost): V0x18DatatypesGetPost =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetPost(
            id = d.id,
            comment_id = d.comment_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetPosts): V0x18DatatypesGetPosts =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetPosts(
            type_ = d.type_,
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            community_id = d.community_id,
            community_name = d.community_name,
            saved_only = d.saved_only,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetPrivateMessages): V0x18DatatypesGetPrivateMessages =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetPrivateMessages(
            unread_only = d.unread_only,
            page = d.page,
            limit = d.limit,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetReplies): V0x18DatatypesGetReplies =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetReplies(
            sort = d.sort,
            page = d.page,
            limit = d.limit,
            unread_only = d.unread_only,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetReportCount): V0x18DatatypesGetReportCount =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetReportCount(
            community_id = d.community_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesGetSiteMetadata): V0x18DatatypesGetSiteMetadata =
        it.vercruysse.lemmyapi.v0x18.datatypes.GetSiteMetadata(
            url = d.url,
        )

    override fun toV0x18(d: V0x19DatatypesHideCommunity): V0x18DatatypesHideCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.HideCommunity(
            community_id = d.community_id,
            hidden = d.hidden,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesListCommentReports): V0x18DatatypesListCommentReports =
        it.vercruysse.lemmyapi.v0x18.datatypes.ListCommentReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesListCommunities): V0x18DatatypesListCommunities =
        it.vercruysse.lemmyapi.v0x18.datatypes.ListCommunities(
            type_ = d.type_,
            sort = d.sort,
            show_nsfw = d.show_nsfw,
            page = d.page,
            limit = d.limit,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesListPostReports): V0x18DatatypesListPostReports =
        it.vercruysse.lemmyapi.v0x18.datatypes.ListPostReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            community_id = d.community_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesListPrivateMessageReports): V0x18DatatypesListPrivateMessageReports =
        it.vercruysse.lemmyapi.v0x18.datatypes.ListPrivateMessageReports(
            page = d.page,
            limit = d.limit,
            unresolved_only = d.unresolved_only,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesListRegistrationApplications): V0x18DatatypesListRegistrationApplications =
        it.vercruysse.lemmyapi.v0x18.datatypes.ListRegistrationApplications(
            unread_only = d.unread_only,
            page = d.page,
            limit = d.limit,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesLockPost): V0x18DatatypesLockPost =
        it.vercruysse.lemmyapi.v0x18.datatypes.LockPost(
            post_id = d.post_id,
            locked = d.locked,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesLogin): V0x18DatatypesLogin =
        it.vercruysse.lemmyapi.v0x18.datatypes.Login(
            username_or_email = d.username_or_email,
            password = d.password,
            totp_2fa_token = d.totp_2fa_token,
        )

    override fun toV0x18(d: V0x19DatatypesMarkCommentReplyAsRead): V0x18DatatypesMarkCommentReplyAsRead =
        it.vercruysse.lemmyapi.v0x18.datatypes.MarkCommentReplyAsRead(
            comment_reply_id = d.comment_reply_id,
            read = d.read,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesMarkPersonMentionAsRead): V0x18DatatypesMarkPersonMentionAsRead =
        it.vercruysse.lemmyapi.v0x18.datatypes.MarkPersonMentionAsRead(
            person_mention_id = d.person_mention_id,
            read = d.read,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesMarkPrivateMessageAsRead): V0x18DatatypesMarkPrivateMessageAsRead =
        it.vercruysse.lemmyapi.v0x18.datatypes.MarkPrivateMessageAsRead(
            private_message_id = d.private_message_id,
            read = d.read,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesPasswordChangeAfterReset): V0x18DatatypesPasswordChangeAfterReset =
        it.vercruysse.lemmyapi.v0x18.datatypes.PasswordChangeAfterReset(
            token = d.token,
            password = d.password,
            password_verify = d.password_verify,
        )

    override fun toV0x18(d: V0x19DatatypesPasswordReset): V0x18DatatypesPasswordReset =
        it.vercruysse.lemmyapi.v0x18.datatypes.PasswordReset(
            email = d.email,
        )

    override fun toV0x18(d: V0x19DatatypesPurgeComment): V0x18DatatypesPurgeComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.PurgeComment(
            comment_id = d.comment_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesPurgeCommunity): V0x18DatatypesPurgeCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.PurgeCommunity(
            community_id = d.community_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesPurgePerson): V0x18DatatypesPurgePerson =
        it.vercruysse.lemmyapi.v0x18.datatypes.PurgePerson(
            person_id = d.person_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesPurgePost): V0x18DatatypesPurgePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.PurgePost(
            post_id = d.post_id,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesRegister): V0x18DatatypesRegister =
        it.vercruysse.lemmyapi.v0x18.datatypes.Register(
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

    override fun toV0x18(d: V0x19DatatypesRemoveComment): V0x18DatatypesRemoveComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.RemoveComment(
            comment_id = d.comment_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesRemoveCommunity): V0x18DatatypesRemoveCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.RemoveCommunity(
            community_id = d.community_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesRemovePost): V0x18DatatypesRemovePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.RemovePost(
            post_id = d.post_id,
            removed = d.removed,
            reason = d.reason,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesResolveCommentReport): V0x18DatatypesResolveCommentReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.ResolveCommentReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesResolveObject): V0x18DatatypesResolveObject =
        it.vercruysse.lemmyapi.v0x18.datatypes.ResolveObject(
            q = d.q,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesResolvePostReport): V0x18DatatypesResolvePostReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.ResolvePostReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesResolvePrivateMessageReport): V0x18DatatypesResolvePrivateMessageReport =
        it.vercruysse.lemmyapi.v0x18.datatypes.ResolvePrivateMessageReport(
            report_id = d.report_id,
            resolved = d.resolved,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesSaveComment): V0x18DatatypesSaveComment =
        it.vercruysse.lemmyapi.v0x18.datatypes.SaveComment(
            comment_id = d.comment_id,
            save = d.save,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesSavePost): V0x18DatatypesSavePost =
        it.vercruysse.lemmyapi.v0x18.datatypes.SavePost(
            post_id = d.post_id,
            save = d.save,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesSaveUserSettings): V0x18DatatypesSaveUserSettings =
        it.vercruysse.lemmyapi.v0x18.datatypes.SaveUserSettings(
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
            open_links_in_new_tab = d.open_links_in_new_tab,
        )

    override fun toV0x18(d: V0x19DatatypesSearch): V0x18DatatypesSearch =
        it.vercruysse.lemmyapi.v0x18.datatypes.Search(
            q = d.q,
            community_id = d.community_id,
            community_name = d.community_name,
            creator_id = d.creator_id,
            type_ = d.type_,
            sort = d.sort,
            listing_type = d.listing_type,
            page = d.page,
            limit = d.limit,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesTransferCommunity): V0x18DatatypesTransferCommunity =
        it.vercruysse.lemmyapi.v0x18.datatypes.TransferCommunity(
            community_id = d.community_id,
            person_id = d.person_id,
            auth = auth,
        )

    override fun toV0x18(d: V0x19DatatypesVerifyEmail): V0x18DatatypesVerifyEmail =
        it.vercruysse.lemmyapi.v0x18.datatypes.VerifyEmail(
            token = d.token,
        )
}
