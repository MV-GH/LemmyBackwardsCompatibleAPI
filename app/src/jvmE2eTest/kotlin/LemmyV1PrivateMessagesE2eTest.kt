import it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage
import it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage
import it.vercruysse.lemmyapi.datatypes.EditPrivateMessage
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LemmyV1PrivateMessagesE2eTest : LemmyV1E2eTest() {
    @Test
    fun `sender can edit a private message`() =
        runBlocking<Unit> {
            val sender = newUser()
            val message = sender.api.createPrivateMessage(CreatePrivateMessage("Original", newUser().personId))
                .getOrThrow().private_message_view.private_message

            val edited = sender.api.editPrivateMessage(EditPrivateMessage(message.id, "Edited")).getOrThrow()

            assertEquals("Edited", edited.private_message_view.private_message.content)
        }

    @Test
    fun `sender can delete and restore a private message`() =
        runBlocking<Unit> {
            val sender = newUser()
            val message = sender.api.createPrivateMessage(CreatePrivateMessage("Delete me", newUser().personId))
                .getOrThrow().private_message_view.private_message

            val deleted = sender.api.deletePrivateMessage(DeletePrivateMessage(message.id, true)).getOrThrow()
            assertTrue(deleted.private_message_view.private_message.deleted)

            val restored = sender.api.deletePrivateMessage(DeletePrivateMessage(message.id, false)).getOrThrow()
            assertFalse(restored.private_message_view.private_message.deleted)
        }
}
