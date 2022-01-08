fun main() {
    val arr = arrayOf(1, 2, "3", false) // Array<Any> (Java?)
    val charArray = charArrayOf('1', 'a') // CharArray (Kotlin)
    println(arr.contentToString())
    println(arr.contentDeepToString())
}