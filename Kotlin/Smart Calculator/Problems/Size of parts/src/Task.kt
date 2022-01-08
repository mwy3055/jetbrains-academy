import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val ans = IntArray(3)
    repeat(scanner.nextInt()) {
        ans[scanner.nextInt() + 1]++
    }
    println("${ans[1]} ${ans[2]} ${ans[0]}")
}