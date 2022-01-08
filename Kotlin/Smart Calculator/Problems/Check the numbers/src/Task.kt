import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val s = scanner.nextInt()
    val array = IntArray(s)
    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    var ans = "YES"
    for (i in 0 until array.lastIndex) {
        if (array[i] == n && array[i + 1] == m || array[i] == m && array[i + 1] == n) {
            ans = "NO"
            break
        }
    }
    println(ans)
}