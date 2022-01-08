import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    var amount = scanner.nextInt()
    var ans = true
    while (scanner.hasNextInt()) {
        val input = scanner.nextInt()
        if (amount - input >= 0) {
            amount -= input
        } else {
            println("Error, insufficient funds for the purchase. You have $amount, but you need $input.")
            ans = false
            break
        }
    }
    if (ans) {
        println("Thank you for choosing us to manage your account! You have $amount money.")
    }
}