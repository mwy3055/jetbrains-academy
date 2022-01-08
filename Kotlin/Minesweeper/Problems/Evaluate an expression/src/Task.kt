import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val x = scanner.nextDouble()
    println(x.pow(3) + x.pow(2) + x + 1)
}