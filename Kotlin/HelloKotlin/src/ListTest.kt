fun main() {
    val list = listOf("a", 1, 3, 4.0)
    println(list)

    for (item in list) {
        println(item)
    }

    for (index in list.indices) {
        println("$index: ${list[index]}")
    }

    val list2 = listOf("1", "2", "3")
    val newList = list2.onEach { it.toInt() }
    println(newList)

    val list3 = listOf(1, 2, 3)
    val result = list3.fold(10) { total, next ->
        total + next
    }
    println(result)

}