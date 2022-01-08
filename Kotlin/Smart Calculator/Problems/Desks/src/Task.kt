import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    var ans = 0
    for (i in 0 until 3) {
        val inp = scanner.nextInt()
        if (inp == 0) continue
        ans += (inp - 1) / 2 + 1
    }
    println(ans)
}