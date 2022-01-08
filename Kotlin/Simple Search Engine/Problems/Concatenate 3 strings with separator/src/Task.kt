fun main() {
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!
    val sep = readLine()!!
    println(when (sep) {
        "NO SEPARATOR" -> concatenate(a, b, c)
        else -> concatenate(a, b, c, sep)
    })
}

fun concatenate(a: String, b: String, c: String, sep: String = " "): String {
    return "$a$sep$b$sep$c"
}