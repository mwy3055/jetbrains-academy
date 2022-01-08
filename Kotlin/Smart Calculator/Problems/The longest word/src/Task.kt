import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    var ans = 0
    var answord = ""
    for (word in scanner.nextLine().split(" ")) {
        if (ans < word.length) {
            ans = word.length
            answord = word
        }
    }
    println(answord)
}