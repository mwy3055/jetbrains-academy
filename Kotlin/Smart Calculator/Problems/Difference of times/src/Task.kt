import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here

    val h1 = scanner.nextInt()
    val m1 = scanner.nextInt()
    val s1 = scanner.nextInt()

    val h2 = scanner.nextInt()
    val m2 = scanner.nextInt()
    val s2 = scanner.nextInt()

    val sec1 = 3600 * h1 + 60 * m1 + s1
    val sec2 = 3600 * h2 + 60 * m2 + s2
    println(sec2 - sec1)
}