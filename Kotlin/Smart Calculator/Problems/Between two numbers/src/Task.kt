import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    println(a in b..c)
}