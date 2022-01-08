import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val letters = mutableMapOf<Int, String>()
    var i = 0
    while (true) {
        val input = scanner.nextLine()
        letters[i++] = input
        if (input == "z") break
    }
    println(if (4 <= i) letters[3] else "null")
}