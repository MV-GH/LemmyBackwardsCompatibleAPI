import io.github.z4kn4fein.semver.toVersion
import it.vercruysse.lemmyapi.LemmyApiFactory
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.exception.NotSupportedException
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

class GetCorrectControllerTest {

    @Test
    fun `create should return the correct LemmyApiBaseController`() {
        val factory = LemmyApiFactory()
        val controller = factory.createForVersion(instance = "lemmy.world", version = "0.19.3-3-g25987dba3").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller)

        val controller2 = factory.createForVersion(instance = "lemmy.world", version = "0.19.3").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller2)

        val controller3 = factory.createForVersion(instance = "lemmy.world", version = "0.19.1").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper::class.java, controller3)

        val controller4 = factory.createForVersion(instance = "lemmy.world", version = "0.19.9").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper::class.java, controller4)

        val controller5 = factory.createForVersion(instance = "lemmy.world", version = "0.19.2-alpha").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller5)

        val controller6 = factory.createForVersion(instance = "lemmy.world", version = "0.19.11").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller6)

        val controller7 = factory.createForVersion(instance = "infosec.pub", version = "0.19.11-n.1").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller7)

        val controller8 = factory.createForVersion(instance = "lemmy.world", version = "1.0.0").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper::class.java, controller8)

        val compatibilityFallback = factory.createForVersion(instance = "lemmy.world", version = "0.19.12").getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, compatibilityFallback)

        assertEquals(MINIMUM_API_VERSION, "0.18.0".toVersion())

        factory.close()
    }

    @Test
    fun `create returns explicit failures for invalid and unsupported versions`() {
        LemmyApiFactory().use { factory ->
            val invalidVersion = factory.createForVersion("lemmy.world", "invalid")
            val unsupportedVersion = factory.createForVersion("lemmy.world", "200.0.0")

            assertTrue(invalidVersion.isFailure)
            assertIs<NotSupportedException>(unsupportedVersion.exceptionOrNull())
        }
    }

    @Test
    fun `getSupportedEntries uses the controller version`() {
        LemmyApiFactory().use { factory ->
            val oldController = factory.createForVersion("lemmy.world", "0.18.5").getOrThrow()
            val newController = factory.createForVersion("lemmy.world", "0.19.0").getOrThrow()

            assertTrue(SortType.Scaled !in oldController.getSupportedEntries<SortType>())
            assertTrue(SortType.Scaled in newController.getSupportedEntries<SortType>())
        }
    }

    @Test
    fun `FF uses the controller version`() {
        LemmyApiFactory().use { factory ->
            val oldController = factory.createForVersion("lemmy.world", "0.18.5").getOrThrow()
            val newController = factory.createForVersion("lemmy.world", "0.19.0").getOrThrow()

            assertEquals(oldController.version, oldController.FF.version)
            assertEquals(newController.version, newController.FF.version)
            assertFalse(oldController.FF.instanceBlock())
            assertTrue(newController.FF.instanceBlock())
        }
    }
}
