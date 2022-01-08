import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val z1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    val z2 = scanner.nextInt()

    val b1 = intArrayOf(x1, y1, z1)
    val b2 = intArrayOf(x2, y2, z2)
    b1.sort()
    b2.sort()
    if (b1.contentEquals(b2)) {
        println("Box 1 = Box 2")
    } else if (b1[0] <= b2[0] && b1[1] <= b2[1] && b1[2] <= b2[2]) {
        println("Box 1 < Box 2")
    } else if (b1[0] >= b2[0] && b1[1] >= b2[1] && b1[2] >= b2[2]) {
        println("Box 1 > Box 2")
    } else {
        println("Incomparable")
    }
}