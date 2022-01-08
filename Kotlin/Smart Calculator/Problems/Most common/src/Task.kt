import java.util.*

fun main() {
    val words = mutableMapOf<String, Int>()
    val scanner = Scanner(System.`in`)
    while (true) {
        val input = scanner.nextLine()!!
        if (input.contentEquals("stop")) break
        if (words.containsKey(input)) words[input] = words[input]!! + 1
        else words[input] = 1
    }
    var ans = "null"
    var maxval = 0
    for ((key, value) in words) {
        if (maxval < value) {
            ans = key
            maxval = value
        }
    }
    print(ans)
}