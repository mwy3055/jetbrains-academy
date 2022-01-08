package minesweeper

import java.util.*
import kotlin.random.Random

class Field {
    val size = 9
    private val field = Array(size) { ".".repeat(size).toCharArray() }
    private val adjMineNumber = Array(size) { IntArray(size) { 0 } }
    private val markField = Array(size) { BooleanArray(size) { false } }
    private val visit = Array(size) { BooleanArray(size) { false } }
    private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    var left = 0
    var wrongMark = 0

    fun init(mineNum: Int) {
        left = mineNum
        repeat(mineNum) {
            var x = 0
            var y = 0
            do {
                x = Random.nextInt(size)
                y = Random.nextInt(size)
            } while (field[x][y] == 'X')
            field[x][y] = 'X'
        }

        for (x in 0 until size) {
            for (y in 0 until size) {
                for (k in dy.indices) {
                    val cx = x + dx[k]
                    val cy = x + dy[k]
                    if (isIn(cx, cy) && field[cx][cy] == 'X') {
                        adjMineNumber[x][y]++
                    }
                }
            }
        }
    }

    fun printField() {
        println(" |123456789|")
        println("-|---------|")
        for (x in 0 until size) {
            print("${x + 1}|")
            for (y in 0 until size) {
                print(when {
                    !visit[x][y] -> '.'
                    adjMineNumber[x][y] > 0 -> adjMineNumber[x][y]
                    field[x][y] != 'X' -> '/'
                    field[x][y] == 'X' -> 'X'
                    else -> '*'
                })
            }
            println("|")
        }
        println("-|---------|")
    }

    fun continueGame(): Boolean {
        return left != 0 && wrongMark != 0
    }

    fun isValid(x: Int, y: Int): Boolean {
        return isIn(x, y) && field[x][y] != 'X'
    }

    fun isIn(x: Int, y: Int): Boolean {
        return x in 0 until size && y in 0 until size
    }

    fun markOrUnmark(x: Int, y: Int) {
        if (markField[x][y]) {
            if (field[x][y] == 'X') {
                left++
            } else {
                wrongMark--
            }
        } else {
            if (field[x][y] == 'X') {
                left--
            } else {
                wrongMark++
            }
        }
        markField[x][y] = !markField[x][y]
    }

    fun explore(x: Int, y: Int): Boolean {
        if (field[x][y] == 'X') {
            return false
        } else if (adjMineNumber[x][y] != 0) {
            visit[x][y] = true
            return true
        } else {
            bfs(x, y)
            return true
        }
    }

    fun bfs(x: Int, y: Int) {
        data class Coord(val x: Int, val y: Int)

        val q = ArrayDeque<Coord>()
        visit[x][y] = true
        q.addLast(Coord(x, y))
        while (!q.isEmpty()) {
            val to = q.removeFirst()
            val cx = to.x
            val cy = to.y
            if (adjMineNumber[cx][cy] != 0) continue
            for (k in dx.indices) {
                val nx = cx + dx[k]
                val ny = cy + dy[k]
                if (isIn(nx, ny) && field[nx][ny] != 'X' && !visit[nx][ny]) {
                    visit[nx][ny] = true
                    q.addLast(Coord(nx, ny))
                }
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val field = Field()

    print("How many mines do you want on the field?")
    val n = scanner.nextInt()
    field.init(n)
    var result = true
    while (field.continueGame() && result) {
        var x = 0
        var y = 0
        var command = ""
        while (true) {
            print("Set/delete mines marks (x and y coordinates): ")
            x = scanner.nextInt()
            y = scanner.nextInt()
            command = scanner.next()
            if (field.isValid(--x, --y)) break
            println("There is a number here!")
        }
        when (command) {
            "mine" -> field.markOrUnmark(x, y)
            "free" -> result = field.explore(x, y)
        }
    }
    println(if (result) "Congratulations! You found all the mines!" else "You stepped on a mine and failed!")
}
