import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val str = scanner.nextLine()
    val n = scanner.nextInt()
    println("Symbol # $n of the string \"$str\" is \'${str[n - 1]}\'")
}