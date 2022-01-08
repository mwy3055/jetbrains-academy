import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()

    var maxval = scanner.nextInt()
    var ans = 0
    for (i in 1 until n) {
        val input = scanner.nextInt()
        if (maxval < input) {
            maxval = input
            ans = i
        }
    }
    println(ans)
}