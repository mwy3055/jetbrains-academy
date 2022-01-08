import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine()
    val tokens = input.split("?").toTypedArray()[1].split("&")

    var password = ""
    for (word in tokens) {
        val argval = word.split("=").toTypedArray()
        if (argval[1].contentEquals("")) {
            println("${argval[0]} : not found")
        } else {
            println("${argval[0]} : ${argval[1]}")
        }

        if (argval[0].contentEquals("pass") && argval.size == 2) {
            password = argval[1]
        }
    }

    if (!password.contentEquals("")) {
        println("password : $password")
    }
}