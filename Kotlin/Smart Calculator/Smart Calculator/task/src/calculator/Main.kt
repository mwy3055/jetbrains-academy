package calculator

import java.util.*
import java.math.BigInteger
import kotlin.math.pow

const val operators = "*/-+^"
fun main() {
    val scanner = Scanner(System.`in`)
    val variables = hashMapOf<String, BigInteger>()
    loop@ while (true) {
        val input = scanner.nextLine()!!
        when (checkInput(input)) {
            0 -> break@loop
            1 -> println("The program calculates the sum of numbers")
            2 -> continue@loop
            3 -> println("Unknown command")
            4 -> {
                when (assignValue(input, variables)) {
                    1 -> println("Invalid identifier")
                    2 -> println("Invalid assignment")
                    3 -> println("Unknown variable")
                }
            }
            else -> {
                try {
                    println(getResult(input, variables))
                } catch (e: ArithmeticException) {
                    println("Invalid expression")
                } catch (e: NoSuchElementException) {
                    println("Unknown variable")
                }
            }
        }
    }
    println("Bye!")
}

fun checkInput(input: String): Int {
    when (input) {
        "/exit" -> return 0
        "/help" -> return 1
        "" -> return 2
    }
    if (input.startsWith("/")) return 3
    if (input.contains("=")) return 4
    return 5
}

fun assignValue(input: String, variables: HashMap<String, BigInteger>): Int {
    val tokens = input.split(" ").joinToString("").split("=")
    if (tokens.size != 2) return 2
    val target = tokens[0]
    val value = tokens[1]
    if (!isAlphabet(target)) {
        return 1
    } else if (isAlphabet(value)) {
        if (hasVariable(value, variables)) variables[target] = variables[value]!!
        else return 3
    } else if (isNumber(value)) {
        variables[target] = BigInteger(value)
    } else if (!isAlphabet(value) && !isNumber(value)) {
        return 2
    }
    return 0
}

fun hasVariable(variable: String, variables: HashMap<String, BigInteger>) = variables.containsKey(variable)

fun getResult(input: String, variables: HashMap<String, BigInteger>): BigInteger {
    val modifiedInput = StringBuilder()
    val parentheses = "()"
    var i = 0
    while (i in input.indices) {
        if (operators.contains(input[i])) {
            val op = input[i]
            modifiedInput.append(' ')
            while (i in input.indices && input[i] == op) modifiedInput.append(input[i++])
            modifiedInput.append(' ')
        } else if (parentheses.contains(input[i])) {
            modifiedInput.append(" ${input[i++]} ")
        } else {
            modifiedInput.append(input[i++])
        }
    }

    val tokens = parseToken(modifiedInput.toString())
    val stack = Stack<BigInteger>()
    for (token in tokens) {
        if (isNumber(token)) {
            stack.push(BigInteger(token))
        } else if (isAlphabet(token)) {
            if (variables.containsKey(token)) {
                stack.push(variables[token]!!)
            } else throw NoSuchElementException()
        } else if (operators.contains(token)) {
            val right = stack.pop()
            val left = stack.pop()
            stack.push(calculate(left, right, token[0]))
        }
    }
    return stack.pop()
}

fun parseToken(input: String): List<String> {
    val priority = hashMapOf('(' to 0, ')' to 0, '+' to 1, '-' to 1, '*' to 2, '/' to 2, '^' to 3)
    val postfix = arrayListOf<String>()
    val stack = Stack<Char>()
    for (token in input.split(" ")) {
        if (token.isEmpty()) continue
        else if (isNumber(token) || isAlphabet(token)) {
            postfix.add(token)
        } else if (operators.contains(token[0])) {
            val reduced = getReducedOperator(token)
            while (!stack.empty() && priority[reduced]!! <= priority[stack.peek()]!!) {
                postfix.add(stack.pop().toString())
            }
            stack.add(reduced)
        } else if (token[0] == '(') {
            stack.push(token[0])
        } else if (token[0] == ')') {
            while (!stack.empty() && stack.peek() != '(') postfix.add(stack.pop().toString())
            if (stack.empty() || stack.peek() != '(') throw ArithmeticException()
            stack.pop()
        } else {
            throw ArithmeticException()
        }
    }

    while (!stack.empty()) {
        val left = stack.pop()
        if (left == '(') throw ArithmeticException()
        postfix.add(left.toString())
    }
    return postfix.toList()
}

fun getReducedOperator(operator: String): Char {
    if (operator.length == 1) return operator[0]
    for (i in operator.indices) {
        if (operator[0] != operator[i]) throw ArithmeticException()
    }
    return when (operator[0]) {
        '+', '(', ')', '^' -> operator[0]
        '-' -> if (operator.length % 2 == 1) '-' else '+'
        '*', '/' -> throw ArithmeticException()
        else -> throw ArithmeticException()
    }
}

fun calculate(left: BigInteger, right: BigInteger, op: Char): BigInteger {
    return (when (op) {
        '+' -> left + right
        '-' -> left - right
        '*' -> left * right
        '/' -> left / right
        '^' -> left.pow(right.toInt())
        else -> throw ArithmeticException()
    })
}

fun isAlphabet(str: String): Boolean {
    for (c in str) {
        if (!c.isLetter()) return false
    }
    return str.isNotEmpty()
}

fun isNumber(str: String): Boolean {
    if (str.isEmpty()) return false
    if (str[0] == '-' || str[0] == '+') {
        for (i in 1..str.lastIndex) {
            if (!str[i].isDigit()) return false
        }
        return 1 < str.length
    }
    for (c in str) {
        if (!c.isDigit())
            return false
    }
    return true
}

