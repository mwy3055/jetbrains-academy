import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val hour = scanner.nextInt()
    val min = scanner.nextInt()
    val sec = scanner.nextInt()
    val day = scanner.nextInt()
    val month = scanner.nextInt()
    val year = scanner.nextInt()
    println("$hour:$min:$sec $day/$month/$year")
}