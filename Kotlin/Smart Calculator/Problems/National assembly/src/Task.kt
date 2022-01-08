import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val input = scanner.nextDouble()
    val rtn = Math.cbrt(input)
    println(rtn.toInt())
}