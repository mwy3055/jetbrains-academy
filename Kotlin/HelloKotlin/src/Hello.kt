fun main() {
    temp(10, 20) { x, y -> x + y }

/*    inlineLambda(3, 5) { a, b ->
        if (a + b > 10) return@inlineLambda
        println("D")
    }*/

/*    val message = lambda@{ num: Int ->
        if (num !in 1 until 100) "Fail" else "Success"
    }
    println(message(50))

    val message2 = fun(num: Int): String {
        return if (num !in 1 until 100) "Fail" else "Success"
    }
    println(message(101))

    labelbreak()*/

/*
    var a = 3
    val b = 0
    val c: Int
    try {
        c = a / b
    } catch (e: ArithmeticException) {
        println("Division by zero")
    } finally {
        println("finally")
    }
*/

    var a = 3
/*    a = a?.let { it + 2 }.let {
        it + 1
    }
    println("A = $a")*/

    // let
    var x = "Kotlin"
    x = x.let { outer ->
        outer.let { inner ->
            println("Inner: $inner, Outer: $outer")
            "Inner Kotlin"
        }
    }
    println("X = $x")

    // also
    var m = 1
/*    m = m.also { it + 3 }
    println("m = $m") // 1*/

    data class Person(var name: String, var skills: String)

    var person = Person("HSK", "Kotlin")
/*    var b = person.also {
        it.skills = "Android"
        "ba"
    }
    println(b) // not "ba"  */

/*    person.apply { skills = "C++" }
    println(person)

    person.apply {
        name = "AA"
        skills = "Python"
    }
    println(person)*/

/*    var skill = "Kotlin"
    skill = run {
        val level = "Kotlin level: " + a
        level
    }
    println("Skill: $skill")*/

/*    var rtn = person.run {
        name = "HSK"
        skills = "Machine Learning"
        skills
    }
    println("rtn: $rtn")
    println("Person: $person")*/

/*    var result = with(person) {
        skills = "Kotlin Programming"
        "Success"
    }
    println("result: $result")
    println("person: $person")*/

/*    var readline = BufferedReader(InputStreamReader(System.`in`)).use { it.readLine() }
    println(readline)*/

/*    var t: Int? = 3
    t?.takeIf { t == 3 }?.apply { println("t = $this") }

    val input = "Kotlin"
    val pattern = "in"
    input.indexOf(pattern).takeIf { it >= 0 } ?: error("Pattern not found")*/

/*    // 시간 측정
    val curTime = measureTimeMillis {
        for (i in 1..320)
            println(i)
    }
    println("curTime: $curTime")*/

/*    // 멀티 플랫폼 난수 생성 함수
    val randomNum = Random.nextInt(320)
    println("random: $randomNum")*/

    // tictactoe()
}

fun temp(a: Int, b: Int, func: (Int, Int) -> Int) {
    println(func(a, b))
    println(func)
}

inline fun inlineLambda(a: Int, b: Int, out: (Int, Int) -> Unit) {
    println(out(a, b))
}

fun labelbreak() {
    first@ for (i in 1 until 6) {
        second@ for (j in 1 until 6) {
            if (j == 3) continue@first
            println("i: $i, j: $j")
        }
    }
}

fun tictactoe() {
    val array = Array(3) { CharArray(3) { ' ' } }

    var turn = 1 // 홀수: O, 짝수: X
    while (true) {
        println("$turn 번째 턴")

        println("======")
        for (row in array) {
            for (elem in row) {
                print("$elem ")
            }
            println()
        }
        println("======")

        val player = if (turn % 2 == 1) 1 else 2
        var row: Int = -1
        var col: Int = -1
        do {
            print("Player $player 입력 (줄, 칸): ")
            val input = readLine()
            row = input!![0] - '0'
            col = input[2] - '0'
        } while (row in 0..2 && col in 0..2 && array[row][col] != ' ')
        array[row][col] = if (player == 1) 'O' else 'X'

        if (checkWin(player, array)) {
            println("Player $player win!")
            break
        }
        println()
        turn++
    }
    println("Final state")
    for (row in array) {
        for (elem in row) {
            print("$elem ")
        }
        println()
    }
}

fun checkWin(player: Int, array: Array<CharArray>): Boolean {
    val c = if (player == 1) 'O' else 'X'
    for (row in array) {
        var check = true
        for (ch in row) {
            if (ch != c) {
                check = false
                break
            }
        }
        if (check) return true
    }

    for (j in array[0].indices) {
        var check = true
        for (i in 0 until 3) {
            if (array[i][j] != c) {
                check = false
                break
            }
        }
        if (check) return true
    }

    if (array[0][0] == c && array[1][1] == c && array[2][2] == c) return true
    if (array[0][2] == c && array[1][1] == c && array[2][0] == c) return true
    return false
}