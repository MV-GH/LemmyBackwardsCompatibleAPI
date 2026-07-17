import it.vercruysse.lemmyapi.LemmyApiFactory
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

class GetCorrectControllerTest {

    @Test
    fun `create should return the correct LemmyApiBaseController`() {
        val factory = LemmyApiFactory()
        val controller = factory.create(instance = "lemmy.world", version = "0.19.3-3-g25987dba3")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller)

        val controller2 = factory.create(instance = "lemmy.world", version = "0.19.3")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller2)

        val controller3 = factory.create(instance = "lemmy.world", version = "0.19.1")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper::class.java, controller3)

        val controller4 = factory.create(instance = "lemmy.world", version = "0.19.9")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper::class.java, controller4)

        val controller5 = factory.create(instance = "lemmy.world", version = "0.19.2-alpha")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller5)

        val controller6 = factory.create(instance = "lemmy.world", version = "0.19.11")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller6)

        val controller7 = factory.create(instance = "infosec.pub", version = "0.19.11-n.1")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller7)
        factory.close()
    }
}
