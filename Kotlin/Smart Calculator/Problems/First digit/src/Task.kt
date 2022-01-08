import java.util.*

fun main() {
    // put your code here
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
    for (c in input) {
        if (c.isDigit()) {
            println(c)
            break
        }
    }
}