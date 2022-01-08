import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val string = scanner.nextLine()
    val substr = scanner.nextLine()
    println(string.split(substr).size - 1)
}