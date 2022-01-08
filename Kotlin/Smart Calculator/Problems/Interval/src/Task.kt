import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()
    val result = if (n in -14..12 || n in 15..16 || 19 <= n) "True" else "False"
    println(result)
}