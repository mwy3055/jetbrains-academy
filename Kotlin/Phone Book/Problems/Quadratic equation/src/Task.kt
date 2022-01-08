import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val a = scanner.nextDouble()
    val b = scanner.nextDouble()
    val c = scanner.nextDouble()
    val discr = sqrt(b.pow(2) - 4 * a * c)
    var x1 = (-b - discr) / (2 * a)
    var x2 = (-b + discr) / (2 * a)
    if (x1 > x2) x1 = x2.also { x2 = x1 }
    println("$x1 $x2")
}