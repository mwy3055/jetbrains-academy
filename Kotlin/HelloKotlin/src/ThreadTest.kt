class SimpleThread : Thread() {
    override fun run() {
        println("Hello! This is thread ${currentThread()}")
    }
}

class SimpleRunnable : Runnable {
    override fun run() {
        println("Hello! This is runnable ${hashCode()}")
    }
}

fun main() {
    val thread = SimpleThread()
    thread.start()

    val runnable = SimpleRunnable()
    val thread2 = Thread(runnable)
    thread2.start()

    object : Thread() {
        override fun run() {
            println("Hello! This is object Thread ${currentThread()}")
        }
    }.start()

    Thread {
        println("Hello! This is lambda thread ${Thread.currentThread()}")
    }.start()
}

fun makeThread(
    start: Boolean = true,
    isDaemon: Boolean = false,
    contextClassLoader: ClassLoader? = null,
    name: String? = null,
    priority: Int = -1,
    block: () -> Unit
): Thread {
    val thread = object : Thread() {
        override fun run() {
            block()
        }
    }
    if (isDaemon)
        thread.isDaemon = true
    if (priority > 0)
        thread.priority = priority
    name?.let { thread.name = it }
    contextClassLoader?.let { thread.contextClassLoader = it }
    if (start) thread.start()
    return thread
}