import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var ans = 0
    while (true) {
        val input = scanner.nextInt()
        if (input == 0) break
        ans += input
    }
    println(ans)
}