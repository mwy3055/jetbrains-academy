import kotlin.math.max
import kotlin.math.min

fun main() {
    var rooms = readLine()!!.toInt()
    var price = readLine()!!.toInt()
    rooms = min(10, max(1, rooms))
    price = min(1_000_000, max(0, price))
    val coefficient = when (rooms) {
        1 -> 1.0
        in 2..3 -> 1.2
        4 -> 1.25
        in 5..7 -> 1.4
        10 -> 1.6
        else -> 0.0
    }
    println((coefficient * price).toInt())
}

class House(val rooms: Int, val price: Int) {}