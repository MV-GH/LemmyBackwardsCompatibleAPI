import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage
import it.vercruysse.lemmyapi.datatypes.ListNotifications
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.PrivateMessageView
import it.vercruysse.lemmyapi.enums.NotificationDataType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1NotificationsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `private message creates a notification for the recipient`() =
        runBlocking {
            val sender = newUser()
            val recipient = newUser()

            val sent = sender.api.createPrivateMessage(CreatePrivateMessage("Hello e2e", recipient.personId)).getOrThrow()
            assertEquals(sender.username, sent.private_message_view.creator.name)

            val notification =
                eventually {
                    recipient.api.listNotifications(ListNotifications(NotificationDataType.PrivateMessage)).getOrThrow().items.single()
                }
            assertEquals("Hello e2e", (notification.data as PrivateMessageView).private_message.content)
        }

    @Test
    fun `reply to a comment creates a notification`() =
        runBlocking {
            val author = newUser()
            val replier = newUser()
            val post = author.api.newPost()
            val comment = author.api.newComment(onPost = post.post.id)

            replier.api.newComment(content = "A reply", onPost = post.post.id, parent = comment.comment.id)

            val notifications =
                eventually {
                    author.api.listNotifications(ListNotifications(NotificationDataType.Reply)).getOrThrow().items.also {
                        assertTrue(it.isNotEmpty())
                    }
                }
            assertTrue(notifications.any { (it.data as? CommentView)?.comment?.content == "A reply" })
        }

    @Test
    fun `notifications can be marked as read`() =
        runBlocking {
            val sender = newUser()
            val recipient = newUser()
            sender.api.createPrivateMessage(CreatePrivateMessage("Read me", recipient.personId)).getOrThrow()
            val notification =
                eventually {
                    recipient.api.listNotifications(ListNotifications(NotificationDataType.All, unread_only = true)).getOrThrow().items.single()
                }
            assertEquals(1, recipient.api.getUnreadCounts().getOrThrow().notification_count)

            recipient.api.markNotificationAsRead(MarkNotificationAsRead(notification.notification.id, read = true)).getOrThrow()

            assertEquals(0, recipient.api.getUnreadCounts().getOrThrow().notification_count)
            val unread = recipient.api.listNotifications(ListNotifications(NotificationDataType.All, unread_only = true)).getOrThrow()
            assertTrue(unread.items.isEmpty())
        }

    @Test
    fun `all notifications can be marked as read`() =
        runBlocking {
            val sender = newUser()
            val recipient = newUser()
            repeat(2) { sender.api.createPrivateMessage(CreatePrivateMessage("Message $it", recipient.personId)).getOrThrow() }
            eventually { assertEquals(2, recipient.api.getUnreadCounts().getOrThrow().notification_count) }

            recipient.api.markAllNotificationsAsRead().getOrThrow()

            assertEquals(0, recipient.api.getUnreadCounts().getOrThrow().notification_count)
        }
}
