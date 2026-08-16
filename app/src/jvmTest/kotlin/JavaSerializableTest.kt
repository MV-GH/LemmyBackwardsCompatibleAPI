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
            published_at = "published",
            deleted = false,
            nsfw = false,
            ap_id = "ap_id",
            local = false,
            language_id = 1,
            featured_community = false,
            featured_local = false,
            url_content_type = null,
            alt_text = null,
            scheduled_publish_time_at = null,
            comments = 0L,
            score = 0L,
            upvotes = 0L,
            downvotes = 0,
            newest_comment_time_at = "newest_comment_time",
            report_count = 0,
            unresolved_report_count = 0,
            federation_pending = false,
        )

        assertInstanceOf(Serializable::class.java, post)
    }
}
