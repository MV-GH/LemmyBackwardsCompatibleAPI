import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.BanFromCommunity
import it.vercruysse.lemmyapi.datatypes.BanPerson
import it.vercruysse.lemmyapi.datatypes.CommentReportView
import it.vercruysse.lemmyapi.datatypes.CommunityReportView
import it.vercruysse.lemmyapi.datatypes.CreateCommentReport
import it.vercruysse.lemmyapi.datatypes.CreateCommunityReport
import it.vercruysse.lemmyapi.datatypes.CreatePostReport
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport
import it.vercruysse.lemmyapi.datatypes.FeaturePost
import it.vercruysse.lemmyapi.datatypes.GetModlog
import it.vercruysse.lemmyapi.datatypes.GetPost
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.LockPost
import it.vercruysse.lemmyapi.datatypes.ModlogView
import it.vercruysse.lemmyapi.datatypes.PostReportView
import it.vercruysse.lemmyapi.datatypes.PrivateMessageReportView
import it.vercruysse.lemmyapi.datatypes.RemoveComment
import it.vercruysse.lemmyapi.datatypes.RemovePost
import it.vercruysse.lemmyapi.datatypes.ReportCombinedView
import it.vercruysse.lemmyapi.datatypes.ResolveCommentReport
import it.vercruysse.lemmyapi.datatypes.ResolveCommunityReport
import it.vercruysse.lemmyapi.datatypes.ResolvePostReport
import it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport
import it.vercruysse.lemmyapi.enums.ModlogKind
import it.vercruysse.lemmyapi.enums.PostFeatureType
import it.vercruysse.lemmyapi.enums.ReportType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class LemmyV1ModerationE2eTest : LemmyV1E2eTest() {
    private suspend fun LemmyApiBaseController.reports(
        type: ReportType = ReportType.All,
        unresolvedOnly: Boolean = false,
    ): List<ReportCombinedView> =
        fetchPages { listReports(ListReports(type_ = type, unresolved_only = unresolvedOnly, page_cursor = it)) }.flatten()

    private suspend fun LemmyApiBaseController.modlog(form: GetModlog = GetModlog()): List<ModlogView> =
        fetchPages { getModlog(form.copy(page_cursor = it)) }.flatten()

    @Test
    fun `post report can be listed and resolved`() =
        runBlocking {
            val post = adminApi.newPost()
            val reporter = newUser()

            val report = reporter.api.createPostReport(CreatePostReport(post.post.id, "e2e post report"))
                .getOrThrow().post_report_view
            assertEquals("e2e post report", report.post_report.reason)
            assertEquals(post.post.id, report.post.id)

            val listed = adminApi.reports(ReportType.Posts, unresolvedOnly = true)
                .filterIsInstance<PostReportView>().single { it.post_report.id == report.post_report.id }
            assertEquals(reporter.personId, listed.creator.id)

            val resolved = adminApi.resolvePostReport(ResolvePostReport(report.post_report.id, true))
                .getOrThrow().post_report_view
            assertTrue(resolved.post_report.resolved)
            assertNotNull(resolved.resolver)
            assertFalse(
                adminApi.reports(ReportType.Posts, unresolvedOnly = true)
                    .filterIsInstance<PostReportView>().any { it.post_report.id == report.post_report.id },
            )
        }

    @Test
    fun `comment report can be listed and resolved`() =
        runBlocking {
            val comment = adminApi.newComment()
            val reporter = newUser()

            val report = reporter.api.createCommentReport(CreateCommentReport(comment.comment.id, "e2e comment report"))
                .getOrThrow().comment_report_view
            assertEquals(comment.comment.id, report.comment.id)

            assertTrue(
                adminApi.reports(ReportType.Comments)
                    .filterIsInstance<CommentReportView>().any { it.comment_report.id == report.comment_report.id },
            )

            val resolved = adminApi.resolveCommentReport(ResolveCommentReport(report.comment_report.id, true))
                .getOrThrow().comment_report_view
            assertTrue(resolved.comment_report.resolved)
        }

    @Test
    fun `community report can be listed and resolved`() =
        runBlocking {
            val community = adminApi.newCommunity()
            val reporter = newUser()

            val report = reporter.api.createCommunityReport(CreateCommunityReport(community, "e2e community report"))
                .getOrThrow().community_report_view
            assertEquals(community, report.community.id)

            assertTrue(
                adminApi.reports(ReportType.Communities)
                    .filterIsInstance<CommunityReportView>().any { it.community_report.id == report.community_report.id },
            )

            val resolved = adminApi.resolveCommunityReport(ResolveCommunityReport(report.community_report.id, true))
                .getOrThrow().community_report_view
            assertTrue(resolved.community_report.resolved)
        }

    @Test
    fun `private message report can be listed and resolved`() =
        runBlocking {
            val sender = newUser()
            val recipient = newUser()
            val message = sender.api.createPrivateMessage(CreatePrivateMessage("e2e reported message", recipient.personId))
                .getOrThrow().private_message_view.private_message

            val report = recipient.api.createPrivateMessageReport(CreatePrivateMessageReport(message.id, "e2e pm report"))
                .getOrThrow().private_message_report_view
            assertEquals(message.id, report.private_message.id)

            assertTrue(
                adminApi.reports(ReportType.PrivateMessages)
                    .filterIsInstance<PrivateMessageReportView>()
                    .any { it.private_message_report.id == report.private_message_report.id },
            )

            val resolved = adminApi.resolvePrivateMessageReport(ResolvePrivateMessageReport(report.private_message_report.id, true))
                .getOrThrow().private_message_report_view
            assertTrue(resolved.private_message_report.resolved)
        }

    @Test
    fun `combined report list contains every report type`() =
        runBlocking {
            val reporter = newUser()
            val recipient = newUser()
            val post = adminApi.newPost()
            val comment = adminApi.newComment()
            val community = adminApi.newCommunity()
            val message = reporter.api.createPrivateMessage(CreatePrivateMessage("e2e combined report", recipient.personId))
                .getOrThrow().private_message_view.private_message

            reporter.api.createPostReport(CreatePostReport(post.post.id, "combined")).getOrThrow()
            reporter.api.createCommentReport(CreateCommentReport(comment.comment.id, "combined")).getOrThrow()
            reporter.api.createCommunityReport(CreateCommunityReport(community, "combined")).getOrThrow()
            recipient.api.createPrivateMessageReport(CreatePrivateMessageReport(message.id, "combined")).getOrThrow()

            val all = adminApi.reports(unresolvedOnly = true)

            assertTrue(all.filterIsInstance<PostReportView>().any { it.post.id == post.post.id })
            assertTrue(all.filterIsInstance<CommentReportView>().any { it.comment.id == comment.comment.id })
            assertTrue(all.filterIsInstance<CommunityReportView>().any { it.community.id == community })
            assertTrue(all.filterIsInstance<PrivateMessageReportView>().any { it.private_message.id == message.id })
        }

    @Test
    fun `remove, lock and feature post are applied and logged`() =
        runBlocking {
            // Its own community, so the featured post doesn't end up in the shared seed community
            val post = user.api.newPost(inCommunity = adminApi.newCommunity()).post

            val locked = adminApi.lockPost(LockPost(post.id, true, "e2e lock")).getOrThrow().post_view.post
            assertTrue(locked.locked)
            val featured = adminApi.featurePost(FeaturePost(post.id, true, PostFeatureType.Community)).getOrThrow().post_view.post
            assertTrue(featured.featured_community)
            val removed = adminApi.removePost(RemovePost(post.id, true, "e2e remove")).getOrThrow().post_view.post
            assertTrue(removed.removed)
            assertTrue(adminApi.getPost(GetPost(id = post.id)).getOrThrow().post_view.post.removed)

            val kinds = adminApi.modlog(GetModlog(post_id = post.id)).map { it.modlog.kind }.toSet()
            assertTrue(ModlogKind.ModLockPost in kinds, "$kinds")
            assertTrue(ModlogKind.ModFeaturePostCommunity in kinds, "$kinds")
            assertTrue(ModlogKind.ModRemovePost in kinds, "$kinds")

            val restored = adminApi.removePost(RemovePost(post.id, false, "e2e restore")).getOrThrow().post_view.post
            assertFalse(restored.removed)
        }

    @Test
    fun `removed comment is logged with its target`() =
        runBlocking {
            val comment = user.api.newComment().comment

            val removed = adminApi.removeComment(RemoveComment(comment.id, true, "e2e comment removal"))
                .getOrThrow().comment_view.comment
            assertTrue(removed.removed)

            val entry = adminApi.modlog(GetModlog(comment_id = comment.id)).first { it.modlog.kind == ModlogKind.ModRemoveComment }
            assertEquals("e2e comment removal", entry.modlog.reason)
            assertEquals(comment.id, entry.target_comment?.id)
        }

    @Test
    fun `community ban is applied and logged`() =
        runBlocking {
            val target = newUser()

            val banned = adminApi.banFromCommunity(BanFromCommunity(communityId, target.personId, true, reason = "e2e community ban"))
                .getOrThrow().person_view
            assertEquals(target.personId, banned.person.id)
            assertTrue(target.api.newPostResult().isFailure)

            val entry = adminApi.modlog(GetModlog(other_person_id = target.personId))
                .first { it.modlog.kind == ModlogKind.ModBanFromCommunity }
            assertEquals(target.personId, entry.target_person?.id)
            assertEquals(communityId, entry.target_community?.id)
        }

    @Test
    fun `site ban is applied and reverted`() =
        runBlocking {
            val target = newUser()

            assertTrue(adminApi.banPerson(BanPerson(target.personId, true, reason = "e2e site ban")).getOrThrow().person_view.banned)
            assertTrue(target.api.newPostResult().isFailure)
            assertFalse(adminApi.banPerson(BanPerson(target.personId, false, reason = "e2e unban")).getOrThrow().person_view.banned)

            val kinds = adminApi.modlog(GetModlog(other_person_id = target.personId)).filter { it.modlog.kind == ModlogKind.AdminBan }
            assertTrue(kinds.any { !it.modlog.is_revert } && kinds.any { it.modlog.is_revert }, "$kinds")
        }

    @Test
    fun `modlog is readable anonymously`() =
        runBlocking {
            assertTrue(anonApi.getModlog(GetModlog()).isSuccess)
        }

    private suspend fun LemmyApiBaseController.newPostResult() =
        createPost(it.vercruysse.lemmyapi.datatypes.CreatePost(name = unique("E2E banned post"), community_id = communityId))
}
