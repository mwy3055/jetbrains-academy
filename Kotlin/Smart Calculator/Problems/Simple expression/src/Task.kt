import java.math.BigInteger
import java.util.*

fun main() {
    // write your code here
    val scanner = Scanner(System.`in`)
    val a = BigInteger(scanner.nextLine())
    val b = BigInteger(scanner.nextLine())
    val c = BigInteger(scanner.nextLine())
    val d = BigInteger(scanner.nextLine())
    println(-a * b + c - d)
}