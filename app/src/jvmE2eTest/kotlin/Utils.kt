import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

/** Retries [block] until it stops throwing an assertion/check failure, for state that is not instantly visible. */
suspend fun <T> eventually(
    timeoutSeconds: Int = 10,
    block: suspend () -> T,
): T {
    val deadline = System.nanoTime() + timeoutSeconds * 1_000_000_000L
    while (true) {
        try {
            return block()
        } catch (e: AssertionError) {
            if (System.nanoTime() > deadline) throw e
        } catch (e: NoSuchElementException) {
            if (System.nanoTime() > deadline) throw e
        } catch (e: IllegalStateException) {
            if (System.nanoTime() > deadline) throw e
        }
        delay(500.milliseconds)
    }
}
