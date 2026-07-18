import io.github.z4kn4fein.semver.toVersion
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
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
        val client = LemmyApiClient()
        val instance = LemmyInstance("lemmy.world")
        val controller = client.connectForVersion(instance, LemmyVersion("0.19.3-3-g25987dba3")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller)

        val controller2 = client.connectForVersion(instance, LemmyVersion("0.19.3")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller2)

        val controller3 = client.connectForVersion(instance, LemmyVersion("0.19.1")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper::class.java, controller3)

        val controller4 = client.connectForVersion(instance, LemmyVersion("0.19.9")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper::class.java, controller4)

        val controller5 = client.connectForVersion(instance, LemmyVersion("0.19.2-alpha")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller5)

        val controller6 = client.connectForVersion(instance, LemmyVersion("0.19.11")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller6)

        val controller7 = client.connectForVersion(LemmyInstance("infosec.pub"), LemmyVersion("0.19.11-n.1")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller7)

        val controller8 = client.connectForVersion(instance, LemmyVersion("1.0.0")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v1.x0.x0.LemmyApiUniWrapper::class.java, controller8)

        val compatibilityFallback = client.connectForVersion(instance, LemmyVersion("0.19.12")).getOrThrow()
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, compatibilityFallback)

        assertEquals(MINIMUM_API_VERSION, "0.18.0".toVersion())

        client.close()
    }

    @Test
    fun `connect returns an explicit failure for unsupported versions`() {
        LemmyApiClient().use { client ->
            val unsupportedVersion = client.connectForVersion(LemmyInstance("lemmy.world"), LemmyVersion("200.0.0"))

            assertIs<NotSupportedException>(unsupportedVersion.exceptionOrNull())
        }
    }

    @Test
    fun `getSupportedEntries uses the controller version`() {
        LemmyApiClient().use { client ->
            val instance = LemmyInstance("lemmy.world")
            val oldController = client.connectForVersion(instance, LemmyVersion("0.18.5")).getOrThrow()
            val newController = client.connectForVersion(instance, LemmyVersion("0.19.0")).getOrThrow()

            assertTrue(SortType.Scaled !in oldController.getSupportedEntries<SortType>())
            assertTrue(SortType.Scaled in newController.getSupportedEntries<SortType>())
        }
    }

    @Test
    fun `FF uses the controller version`() {
        LemmyApiClient().use { client ->
            val instance = LemmyInstance("lemmy.world")
            val oldController = client.connectForVersion(instance, LemmyVersion("0.18.5")).getOrThrow()
            val newController = client.connectForVersion(instance, LemmyVersion("0.19.0")).getOrThrow()

            assertEquals(oldController.version, oldController.FF.version)
            assertEquals(newController.version, newController.FF.version)
            assertFalse(oldController.FF.instanceBlock())
            assertTrue(newController.FF.instanceBlock())
        }
    }
}
