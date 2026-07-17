import it.vercruysse.lemmyapi.LemmyApiFactory
import it.vercruysse.lemmyapi.exception.NotSupportedException
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import kotlin.test.assertIs
import kotlin.test.assertTrue

class GetCorrectControllerTest {

    @Test
    fun `create should return the correct LemmyApiBaseController`() {
        val factory = LemmyApiFactory()
        val controller = factory.create(instance = "lemmy.world", version = "0.19.3-3-g25987dba3").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller)

        val controller2 = factory.create(instance = "lemmy.world", version = "0.19.3").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller2)

        val controller3 = factory.create(instance = "lemmy.world", version = "0.19.1").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper::class.java, controller3)

        val controller4 = factory.create(instance = "lemmy.world", version = "0.19.9").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper::class.java, controller4)

        val controller5 = factory.create(instance = "lemmy.world", version = "0.19.2-alpha").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller5)

        val controller6 = factory.create(instance = "lemmy.world", version = "0.19.11").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller6)

        val controller7 = factory.create(instance = "infosec.pub", version = "0.19.11-n.1").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller7)

        val controller8 = factory.create(instance = "lemmy.world", version = "1.0.0").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper::class.java, controller8)

        factory.close()
    }

    @Test
    fun `create returns explicit failures for invalid and unsupported versions`() {
        LemmyApiFactory().use { factory ->
            val invalidVersion = factory.create("lemmy.world", "invalid")
            val unsupportedVersion = factory.create("lemmy.world", "2.0.0")

            assertTrue(invalidVersion.isFailure)
            assertIs<NotSupportedException>(unsupportedVersion.exceptionOrNull())
        }
    }
}
