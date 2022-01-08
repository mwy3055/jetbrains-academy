import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    for (i in 0 until 4) {
        val c = scanner.next()[0]
        print(c.isDigit())
        if (i != 3) print('\\')
    }
}