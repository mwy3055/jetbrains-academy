import java.util.*

fun main() {
    // put your code here
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
    val arr = IntArray(26)
    for (c in input) {
        arr[c.toInt() - 'a'.toInt()]++
    }
    var ans = 0
    for (a in arr) {
        if (a == 1) ans++
    }
    println(ans)
}