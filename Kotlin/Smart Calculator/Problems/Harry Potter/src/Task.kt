import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    println(when (scanner.nextLine()) {
        "gryffindor" -> "bravery"
        "hufflepuff" -> "loyalty"
        "slytherin" -> "cunning"
        "ravenclaw" -> "intellect"
        else -> "not a valid house"
    })
}