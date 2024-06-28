import it.vercruysse.lemmyapi.datatypes.Post
import org.junit.jupiter.api.Assertions.assertInstanceOf
import java.io.Serializable
import kotlin.test.Test

class JavaSerializableTest {

    @Test
    fun `verify that datatype is java serializable`() {
        val post = Post(
            id = 1,
            name = "name",
            creator_id = 1,
            community_id = 1,
            removed = false,
            locked = false,
            published = "published",
            deleted = false,
            nsfw = false,
            ap_id = "ap_id",
            local = false,
            language_id = 1,
            featured_community = false,
            featured_local = false,
        )

        assertInstanceOf(Serializable::class.java, post)
    }
}
