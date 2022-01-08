import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val n = scanner.nextInt()
    val array = IntArray(n)
    for (i in 0 until n) {
        array[i] = scanner.nextInt()
    }

    var ans = 0
    for (i in 0..array.lastIndex - 2) {
        if (array[i] + 1 == array[i + 1] && array[i + 1] + 1 == array[i + 2]) {
            ans++
        }
    }
    println(ans)
}