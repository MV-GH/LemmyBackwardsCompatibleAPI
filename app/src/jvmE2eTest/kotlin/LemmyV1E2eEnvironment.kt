import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyAuth
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.datatypes.CreateComment
import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreatePost
import it.vercruysse.lemmyapi.datatypes.EditSite
import it.vercruysse.lemmyapi.datatypes.Login
import it.vercruysse.lemmyapi.datatypes.Register
import it.vercruysse.lemmyapi.enums.RegistrationMode
import kotlinx.coroutines.runBlocking
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.Network
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.utility.DockerImageName
import org.testcontainers.utility.MountableFile
import java.time.Duration
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.Duration.Companion.seconds

class E2eUser(val api: LemmyApiBaseController, val username: String, val personId: Long)

/** Docker stack (Postgres + pict-rs + Lemmy) plus the data every test class relies on. */
internal class LemmyV1E2eEnvironment {
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
    private val userCounter = AtomicInteger()
    private val version = LemmyVersion(LEMMY_VERSION)

    lateinit var anon: LemmyApiBaseController
        private set
    lateinit var admin: LemmyApiBaseController
        private set
    lateinit var user: E2eUser
        private set

    var communityId = 0L
        private set
    var postId = 0L
        private set
    var commentId = 0L
        private set
    var seededPostIds: List<Long> = emptyList()
        private set
    var seededCommentIds: List<Long> = emptyList()
        private set

    fun start() {
        try {
            postgres.start()
            pictrs.start()
            lemmy.start()
            runBlocking { configureSite() }
            // Lemmy only reads its rate limits at startup, so restart it to pick up the change
            lemmy.stop()
            lemmy.start()
            runBlocking { seed() }
        } catch (t: Throwable) {
            stop()
            throw t
        }
    }

    suspend fun newUser(): E2eUser {
        val username = "e2eu${userCounter.incrementAndGet()}"
        val jwt = anon.register(Register(username, USER_PASSWORD, USER_PASSWORD)).getOrThrow().jwt
        checkNotNull(jwt) { "Registration for $username did not return a token" }
        val api = connect(LemmyAuth.Bearer(jwt))
        return E2eUser(api, username, api.getMyUser().getOrThrow().local_user_view.person.id)
    }

    private fun connect(auth: LemmyAuth = LemmyAuth.Anonymous): LemmyApiBaseController {
        val instance = LemmyInstance("http://${lemmy.host}:${lemmy.getMappedPort(LEMMY_PORT)}")
        return client.connectForVersion(instance, auth, version).getOrThrow()
    }

    private suspend fun loginAdmin(): LemmyApiBaseController {
        val jwt = connect().login(Login(ADMIN_USERNAME, ADMIN_PASSWORD)).getOrThrow().jwt
        checkNotNull(jwt) { "Lemmy did not return a token for the admin user" }
        return connect(LemmyAuth.Bearer(jwt))
    }

    // Open registration and lift the rate limits, all tests come from the same IP
    private suspend fun configureSite() {
        loginAdmin().editSite(
            EditSite(
                registration_mode = RegistrationMode.Open,
                rate_limit_message_max_requests = UNLIMITED,
                rate_limit_post_max_requests = UNLIMITED,
                rate_limit_register_max_requests = UNLIMITED,
                rate_limit_comment_max_requests = UNLIMITED,
                rate_limit_search_max_requests = UNLIMITED,
            ),
        ).getOrThrow()
    }

    private suspend fun seed() {
        anon = connect()
        admin = loginAdmin()

        communityId =
            admin.createCommunity(CreateCommunity(name = SEED_COMMUNITY_NAME, title = "E2E Test Community"))
                .getOrThrow().community_view.community.id

        val posts = mutableListOf<Long>()
        posts += admin.createSeedPost(SEED_POST_TITLE, SEED_POST_BODY)
        postId = posts.single()
        repeat(SEED_PAGING_COUNT) { posts += admin.createSeedPost("$SEED_PAGING_POST_PREFIX ${it + 1}", null) }
        seededPostIds = posts

        val comments = mutableListOf<Long>()
        comments += admin.createSeedComment(SEED_COMMENT_CONTENT)
        commentId = comments.single()
        repeat(SEED_PAGING_COUNT) { comments += admin.createSeedComment("$SEED_PAGING_COMMENT_PREFIX ${it + 1}") }
        seededCommentIds = comments

        user = newUser()
    }

    private suspend fun LemmyApiBaseController.createSeedPost(
        title: String,
        body: String?,
    ): Long =
        createPost(CreatePost(name = title, body = body, community_id = communityId))
            .getOrThrow().post_view.post.id

    private suspend fun LemmyApiBaseController.createSeedComment(content: String): Long =
        createComment(CreateComment(content = content, post_id = postId)).getOrThrow().comment_view.comment.id

    fun stop() {
        runCatching { client.close() }
        runCatching { lemmy.stop() }
        runCatching { pictrs.stop() }
        runCatching { postgres.stop() }
        runCatching { network.close() }
    }

    private class LemmyContainer(image: String) : GenericContainer<LemmyContainer>(DockerImageName.parse(image))

    companion object {
        const val LEMMY_VERSION = "1.0.0-beta.2"
        const val ADMIN_USERNAME = "lemmy"
        const val ADMIN_PASSWORD = "lemmylemmy"
        const val USER_PASSWORD = "e2e-user-password"
        const val SEED_COMMUNITY_NAME = "e2ebasic"
        const val SEED_POST_TITLE = "E2E seeded post"
        const val SEED_POST_BODY = "A post created through the public unified API."
        const val SEED_COMMENT_CONTENT = "An E2E comment created through the public unified API."
        const val SEED_PAGING_POST_PREFIX = "E2E paging post"
        const val SEED_PAGING_COMMENT_PREFIX = "E2E paging comment"
        const val SEED_PAGING_COUNT = 5

        private const val UNLIMITED = 1_000_000L
        private const val LEMMY_PORT = 8536
        private const val PICTRS_PORT = 8080
        private const val POSTGRES_PORT = 5432
    }
}
