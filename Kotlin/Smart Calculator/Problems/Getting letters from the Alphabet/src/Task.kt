import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val c = input.next()[0]
    var cur = 'a'
    while (true) {
        if (c == cur) return
        print(cur)
        cur++
    }
}