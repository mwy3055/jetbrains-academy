import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    var ans = 0
    for (i in a..b) {
        ans += i
    }
    println(ans)
}