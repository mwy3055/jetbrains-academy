import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val h = scanner.nextInt()
    val result = if (h in a..b) {
        "Normal"
    } else if (h < a) {
        "Deficiency"
    } else {
        "Excess"
    }
    println(result)
}