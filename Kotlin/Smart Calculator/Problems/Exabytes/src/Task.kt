import java.math.BigInteger
import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val n = BigInteger(scanner.nextLine())
    val op = BigInteger("9223372036854775808")
    println(op.times(n))
}