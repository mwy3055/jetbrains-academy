import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val split = scanner.nextLine().split(" ").sorted()
    println(split.last())
}