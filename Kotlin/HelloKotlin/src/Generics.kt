fun <T : Any> genericTest(arg: T) {
    println("arg: $arg, class: ${arg::class}")
}

fun main() {
    genericTest(listOf("1", "2"))
}