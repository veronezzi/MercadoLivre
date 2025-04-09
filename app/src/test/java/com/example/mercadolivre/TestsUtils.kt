// TestExtensions.kt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import org.junit.Assert.fail

suspend fun <T> Flow<T>.getOrAwaitValue(
    testScope: TestScope,
    timeout: Long = 1000,
    onTimeout: () -> Unit = { fail("Timeout waiting for flow value") }
): T {
    val results = mutableListOf<T>()
    val job = testScope.backgroundScope.launch {
        this@getOrAwaitValue.toList(results)
    }

    kotlinx.coroutines.delay(timeout)
    job.cancel()

    return results.lastOrNull() ?: onTimeout().let { throw IllegalStateException("No value received") }
}