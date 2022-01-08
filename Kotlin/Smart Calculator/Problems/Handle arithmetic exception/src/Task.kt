import java.util.*

fun main(args: Array<String>) {
    // put your code here
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    println(if (b == 0) "Division by zero, please fix the second argument!" else a / b)
}