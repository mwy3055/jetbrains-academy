import java.math.BigInteger
import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val a = BigInteger(scanner.nextLine())
    val b = BigInteger(scanner.nextLine())
    val sum = a + b
    val hundred = BigInteger("100")
    println("${a.times(hundred) / sum}% ${b.times(hundred) / sum}%")
}