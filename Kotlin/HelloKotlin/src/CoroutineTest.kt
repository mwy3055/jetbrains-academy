import kotlinx.coroutines.*

fun main() = runBlocking {
    // 메인 스레드에서 작동중
    launch {
        // 메인 스레드에서 작동
        delay(200L)
        println("World")
    }

    // 메인 스레드는 이 코루틴이 멈출 때까지 기다려줌
    coroutineScope {
        // 별도의 스레드(T1)에서 작동
        launch {
            // T1에서 작동
            delay(500L)
            println("Task from coroutineScope.launch")
        }
        delay(100L)
        println("Task from coroutineScope")
    }

    // coroutineScope이 종료된 후에 실행됨
    println("Last")

    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("sleeping $i...")
            delay(500L)
        }
        "Done"
    }
    println("Result: $result")
}

private fun workTest(): Job {
    return GlobalScope.launch {
        val one = work1()
        val two = work2()
        println("work 1: $one")
        println("work 2: $two")
    }
}

private suspend fun workTest2() {
    val one = GlobalScope.async {
        work1()
    }
    val two = GlobalScope.async {
        work2()
    }
    val result = "${one.await()}, ${two.await()}"
    println("Result: $result")
}

suspend fun work1(): String {
    delay(3000)
    return "work1"
}

suspend fun work2(): String {
    delay(1000)
    return "work2"
}

suspend fun doSomething() {
    println("Do something...")
}