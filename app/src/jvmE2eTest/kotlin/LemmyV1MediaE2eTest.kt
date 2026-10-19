import it.vercruysse.lemmyapi.datatypes.DeleteImageParams
import it.vercruysse.lemmyapi.datatypes.ListMedia
import kotlinx.coroutines.runBlocking
import java.util.Base64
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1MediaE2eTest : LemmyV1E2eTest() {
    @Test
    fun `user can upload an image and list it`() =
        runBlocking {
            val uploader = newUser()

            val upload = uploader.api.uploadImage(PNG).getOrThrow()

            assertTrue(upload.image_url.contains(upload.filename), "Image url ${upload.image_url} should contain ${upload.filename}")
            val media = uploader.api.listMedia(ListMedia()).getOrThrow().items
            assertEquals(listOf(upload.filename), media.map { it.local_image.pictrs_alias })
            assertEquals(uploader.username, media.single().person.name)
        }

    @Test
    fun `user can delete an uploaded image`() =
        runBlocking {
            val uploader = newUser()
            val upload = uploader.api.uploadImage(PNG).getOrThrow()

            uploader.api.deleteMedia(DeleteImageParams(upload.delete_filename)).getOrThrow()

            assertTrue(uploader.api.listMedia(ListMedia()).getOrThrow().items.isEmpty())
        }

    @Test
    fun `uploaded images can be paged`() =
        runBlocking {
            val uploader = newUser()
            val filenames = List(3) { uploader.api.uploadImage(PNG).getOrThrow().filename }

            val pages = fetchPages { cursor -> uploader.api.listMedia(ListMedia(limit = 2, page_cursor = cursor)) }

            assertEquals(2, pages.size)
            assertEquals(2, pages.first().size)
            assertEquals(filenames.toSet(), pages.flatten().map { it.local_image.pictrs_alias }.toSet())
        }

    @Test
    fun `user can upload an avatar and banner`() =
        runBlocking {
            val uploader = newUser()

            val avatar = uploader.api.uploadUserAvatar(PNG).getOrThrow()
            val banner = uploader.api.uploadUserBanner(PNG).getOrThrow()

            val person = uploader.api.getMyUser().getOrThrow().local_user_view.person
            assertEquals(avatar.image_url, person.avatar)
            assertEquals(banner.image_url, person.banner)
        }

    @Test
    fun `anonymous user cannot upload an image`() =
        runBlocking {
            assertTrue(anonApi.uploadImage(PNG).isFailure)
        }

    @Test
    fun `uploading something that is not an image fails`() =
        runBlocking {
            val result = newUser().api.uploadImage("definitely not an image".encodeToByteArray())

            assertTrue(result.isFailure)
        }

    private companion object {
        // 1x1 transparent PNG
        val PNG: ByteArray =
            Base64.getDecoder().decode(
                "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNkYPhfDwAChwGA60e6kgAAAABJRU5ErkJggg==",
            )
    }
}
