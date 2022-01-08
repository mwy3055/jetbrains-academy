import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val n = scanner.nextLong()
    val b = scanner.nextBoolean()
    if (b) {
        println(n in 15..25)
    } else {
        println(n in 10..20)
    }
}