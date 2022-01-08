import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val n = scanner.nextInt()
    var ans = 0
    repeat(n) {
        if (scanner.nextInt() > 0) {
            ans++
        }
    }
    println(ans)
}