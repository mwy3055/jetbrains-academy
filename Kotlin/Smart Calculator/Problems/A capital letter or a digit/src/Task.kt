import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val c = scanner.next()[0]
    println(c.isUpperCase() || c in '1'..'9')
}