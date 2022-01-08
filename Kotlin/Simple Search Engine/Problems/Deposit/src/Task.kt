import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val param = scanner.nextLine()
    val value = scanner.nextInt()
    println(when (param) {
        "amount" -> getFinalAmount(startingAmount = value)
        "percent" -> getFinalAmount(yearlyPercent = value)
        else -> getFinalAmount(years = value)
    })
}

fun getFinalAmount(startingAmount: Int = 1000, yearlyPercent: Int = 5, years: Int = 10): Int {
    return (startingAmount * (1 + yearlyPercent.toDouble() / 100.0).pow(years)).toInt()
}