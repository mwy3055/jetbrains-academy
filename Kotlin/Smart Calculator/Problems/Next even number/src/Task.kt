import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val n = scanner.nextInt()
    val result = if (n % 2 == 1) n + 1 else n + 2
    println(result)
}