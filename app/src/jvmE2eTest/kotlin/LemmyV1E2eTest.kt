import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.CreateComment
import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreatePost
import it.vercruysse.lemmyapi.datatypes.Login
import kotlinx.coroutines.runBlocking
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.Network
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile
import java.time.Duration
import kotlin.time.Duration.Companion.seconds

abstract class LemmyV1E2eTest {
    protected val api: LemmyApiBaseController get() = env.api
    protected val postId: Long get() = env.postId

    private class Environment {
        private val network = Network.newNetwork()
        private val postgres =
            LemmyContainer("postgres:16.4-alpine")
                .withNetwork(network)
                .withNetworkAliases("postgres")
                .withEnv("POSTGRES_USER", "lemmy")
                .withEnv("POSTGRES_PASSWORD", "password")
                .withEnv("POSTGRES_DB", "lemmy")
                .withExposedPorts(POSTGRES_PORT)
                .waitingFor(Wait.forListeningPort())
        private val pictrs =
            LemmyContainer("asonix/pictrs:0.5.16")
                .withNetwork(network)
                .withNetworkAliases("pictrs")
                .withEnv("PICTRS__SERVER__API_KEY", "lemmy-e2e-pictrs-key")
                .withExposedPorts(PICTRS_PORT)
                .waitingFor(Wait.forListeningPort())
        private val lemmy =
            LemmyContainer("dessalines/lemmy:$LEMMY_VERSION")
                .withNetwork(network)
                .withEnv("LEMMY_DISABLE_ACTIVITY_SENDING", "true")
                .withEnv("RUST_LOG", "warn")
                .withCopyFileToContainer(
                    MountableFile.forClasspathResource("lemmy-e2e-config.hjson"),
                    "/config/config.hjson",
                )
                .withExposedPorts(LEMMY_PORT)
                .waitingFor(
                    Wait.forHttp("/api/v4/site")
                        .forStatusCode(200)
                        .withStartupTimeout(Duration.ofMinutes(4)),
                )

        private val client =
            LemmyApiClient(
                options =
                LemmyApiOptions(
                    requestTimeout = 30.seconds,
                    maxRetries = 5,
                    userAgent = "LemmyBackwardsCompatibleAPI-E2E",
                ),
            )

        lateinit var api: LemmyApiBaseController
            private set
        var postId = 0L
            private set

        fun start() {
            try {
                postgres.start()
                pictrs.start()
                lemmy.start()
                seed()
            } catch (t: Throwable) {
                stop()
                throw t
            }
        }

        private fun seed() =
            runBlocking {
                val instance = LemmyInstance("http://${lemmy.host}:${lemmy.getMappedPort(LEMMY_PORT)}")
                val version = LemmyVersion(LEMMY_VERSION)

                val admin = client.connectForVersion(instance, version).getOrThrow()
                val jwt = admin.login(Login(ADMIN_USERNAME, ADMIN_PASSWORD)).getOrThrow().jwt
                checkNotNull(jwt) { "Lemmy did not return a token for the admin user" }
                admin.updateAuth(LemmyAuth.Bearer(jwt))

                val community =
                    admin.createCommunity(CreateCommunity(name = SEED_COMMUNITY_NAME, title = "E2E Test Community"))
                        .getOrThrow().community_view.community
                val post =
                    admin.createPost(
                        CreatePost(name = SEED_POST_TITLE, body = SEED_POST_BODY, community_id = community.id),
                    ).getOrThrow().post_view.post
                admin.createComment(CreateComment(content = SEED_COMMENT_CONTENT, post_id = post.id)).getOrThrow()

                postId = post.id
                api = client.connectForVersion(instance, version).getOrThrow()
            }

        fun stop() {
            runCatching { client.close() }
            runCatching { lemmy.stop() }
            runCatching { pictrs.stop() }
            runCatching { postgres.stop() }
            runCatching { network.close() }
        }
    }

    private class LemmyContainer(image: String) : GenericContainer<LemmyContainer>(DockerImageName.parse(image))

    protected companion object {
        const val LEMMY_VERSION = "1.0.0-beta.2"
        const val ADMIN_USERNAME = "lemmy"
        const val ADMIN_PASSWORD = "lemmylemmy"
        const val SEED_COMMUNITY_NAME = "e2ebasic"
        const val SEED_POST_TITLE = "E2E seeded post"
        const val SEED_POST_BODY = "A post created through the public unified API."
        const val SEED_COMMENT_CONTENT = "An E2E comment created through the public unified API."

        private const val LEMMY_PORT = 8536
        private const val PICTRS_PORT = 8080
        private const val POSTGRES_PORT = 5432

        private val env: Environment by lazy {
            Environment().also {
                Runtime.getRuntime().addShutdownHook(Thread { it.stop() })
                it.start()
            }
        }
    }
}
