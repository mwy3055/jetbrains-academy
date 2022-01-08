import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val a = scanner.nextLong()
    val b = scanner.nextLong()
    val c = scanner.nextLong()

    if (a <= c) println(b in a..c) else println(b in c..a)
}