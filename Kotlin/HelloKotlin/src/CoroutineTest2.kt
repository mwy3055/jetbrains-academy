import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicReference
import kotlin.system.measureTimeMillis

val counter = AtomicReference(0)


suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.getAndUpdate { it + 1 }
        }
    }
    println("Counter = $counter")
}