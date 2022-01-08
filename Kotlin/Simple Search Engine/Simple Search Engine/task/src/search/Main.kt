package search

import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val fullData = ArrayList<String>()
    val invertedIndex = HashMap<String, ArrayList<Int>>()
    readData(args, fullData, invertedIndex)
    displayMenu(fullData, invertedIndex)
    println("Bye!")
}

fun readData(args: Array<String>, fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>) {
    val index = args.indexOf("--data")
    val fileName = args[index + 1]
    val file = File(fileName)
    file.forEachLine { fullData.add(it.trim()) }
    for (i in fullData.indices) {
        fullData[i].split(" ").forEach { token ->
            val upper = token.toUpperCase()
            if (invertedIndex.containsKey(upper)) {
                invertedIndex[upper]!!.add(i)
            } else {
                invertedIndex[upper] = arrayListOf(i)
            }
        }
    }
}

fun displayMenu(fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>) {
    loop@ while (true) {
        when (getMenuInput()) {
            0 -> break@loop
            1 -> findPeople(fullData, invertedIndex)
            2 -> printPeople(fullData)
            else -> exitProcess(-1)
        }
    }
}

fun getMenuInput(): Int {
    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all people")
    println("0. Exit")
    var input = readLine()!!.toInt()
    println()
    while (input !in 0..2) {
        println("Incorrect option! Try again.")
        println()
        input = readLine()!!.toInt()
    }
    println()
    return input
}

fun findPeople(fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>) {
    println("Select a matching strategy: ALL, ANY, NONE")
    val strategy = readLine()!!
    println()

    println("Enter a name or email to search all suitable people.")
    val query = readLine()!!
    println()

    // TODO: search
    val result = when (strategy) {
        "ALL" -> findAll(query, fullData, invertedIndex)
        "ANY" -> findAny(query, fullData, invertedIndex)
        "NONE" -> findNone(query, fullData, invertedIndex)
        else -> intArrayOf()
    }
    if (result.isEmpty()) {
        println("No matching people found.")
    } else {
        println("${result.size} people found:")
        result.forEach { println(fullData[it]) }
    }
    println()
}

fun findAll(query: String, fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>): IntArray {
    val upperQuery = query.trim().toUpperCase()
    val result = ArrayList<Int>()
    upperQuery.split(" ").forEach { token ->
        invertedIndex[token]?.forEach { index ->
            if (containsAll(fullData[index].toUpperCase(), upperQuery)) result.add(index)
        }
    }
    return result.sorted().distinct().toIntArray()
}

fun findAny(query: String, fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>): IntArray {
    val upperQuery = query.trim().toUpperCase()
    val result = ArrayList<Int>()
    upperQuery.split(" ").forEach { token ->
        invertedIndex[token]?.forEach { index -> result.add(index) }
    }
    return result.sorted().distinct().toIntArray()
}

fun findNone(query: String, fullData: ArrayList<String>, invertedIndex: HashMap<String, ArrayList<Int>>): IntArray {
    val result = findAny(query, fullData, invertedIndex)
    val noneResult = ArrayList<Int>()
    for (i in fullData.indices) {
        if (!result.contains(i)) noneResult.add(i)
    }
    return noneResult.toIntArray()
}

fun containsAll(target: String, tokens: String): Boolean {
    tokens.split(" ").forEach {
        if (!target.contains(it)) return false
    }
    return true
}

fun printPeople(fullData: ArrayList<String>) {
    println("=== List of people ===")
    fullData.forEach { println(it) }
    println()
}