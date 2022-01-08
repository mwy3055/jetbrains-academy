import java.util.*

enum class Currency(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar")
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val country1 = input.next()
    val country2 = input.next()
    try {
        println(if (Currency.valueOf(country1).currency == Currency.valueOf(country2).currency) "true" else "false")
    } catch (e: IllegalArgumentException) {
        println("false")
    }
}