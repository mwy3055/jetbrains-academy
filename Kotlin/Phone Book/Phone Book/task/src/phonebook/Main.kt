package phonebook

import java.io.File
import kotlin.math.min
import kotlin.math.sqrt

data class Entry(val phone: String, val name: String)

fun main() {

    val directoryFileName = "src/phonebook/directory.txt"
//    val directoryFileName = "E:\\code\\Kotlin\\Phone Book\\Phone Book\\task\\src\\phonebook\\directory.txt"
    val directoryFile = File(directoryFileName)
    var allEntries = MutableList(0) { Entry("", "") }
    directoryFile.forEachLine { line ->
        val index = line.indexOfFirst { it == ' ' }
        allEntries.add(Entry(line.substring(0, index), line.substring(index + 1)))
    }

    val findFileName = "src/phonebook/find.txt"
//    val findFileName = "E:\\code\\Kotlin\\Phone Book\\Phone Book\\task\\src\\phonebook\\find.txt"
    val findFile = File(findFileName)
    val findList = findFile.readLines()
    val findSize = findList.size

    /* linear search */
    println("Start searching (linear search)...")
    var startTime = System.currentTimeMillis()
    var found = linearSearch(allEntries, findList)
    var endTime = System.currentTimeMillis()
    val linearSearchTime = endTime - startTime
    println("Found $found / $findSize entries. Time taken: ${getTimeString(startTime, endTime)}")
    println()

    /* bubble sort + jump search */
    println("Start searching (bubble sort + jump search)...")
    startTime = System.currentTimeMillis()
    val allEntriesBackup = allEntries
    var sortEndTime = bubbleSort(allEntries, linearSearchTime, startTime)

    var isStopped = ""
    if (!isSorted(allEntries)) {
        allEntries = allEntriesBackup
        found = linearSearch(allEntries, findList)
        endTime = System.currentTimeMillis()
        isStopped = " - STOPPED, moved to linear search"
    } else {
        found = jumpSearch(allEntries, findList)
        endTime = System.currentTimeMillis()
    }
    println("Found $found / $findSize entries. Time taken: ${getTimeString(startTime, endTime)}")
    println("Sorting time: ${getTimeString(startTime, sortEndTime)}" + isStopped)
    println("Searching time: ${getTimeString(sortEndTime, endTime)}")
    println()

    /* quick sort + binary search */
    println("Start searching (quick sort + binary search)...")
    allEntries = allEntriesBackup
    startTime = System.currentTimeMillis()
    allEntries.sortBy { it.name }
    sortEndTime = System.currentTimeMillis()
    found = 0
    findList.forEach { if (binarySearch(allEntries, it, 0, allEntries.lastIndex) != -1) found++ }
    endTime = System.currentTimeMillis()
    println("Found $found / $findSize entries. Time taken: ${getTimeString(startTime, endTime)}")
    println("Sorting time: ${getTimeString(startTime, sortEndTime)}")
    println("Searching time: ${getTimeString(sortEndTime, endTime)}")

    /* hash table */
    println("Start searching (hash table)...")
    allEntries = allEntriesBackup
    val hashTable = hashMapOf<String, String>()
    startTime = System.currentTimeMillis()
    allEntries.forEach { hashTable[it.name] = it.phone }
    val createEndTime = System.currentTimeMillis()
    found = 0
    findList.forEach { if (hashTable.contains(it)) found++ }
    endTime = System.currentTimeMillis()
    println("Found $found / $findSize entries. Time taken: ${getTimeString(startTime, endTime)}")
    println("Creating time: ${getTimeString(startTime, createEndTime)}")
    println("Searching time: ${getTimeString(createEndTime, endTime)}")
}

fun getTimeString(startTime: Long, endTime: Long): String {
    val timeDiff = endTime - startTime
    val min = timeDiff / 60000
    val sec = (timeDiff % 60000) / 1000
    val ms = timeDiff % 1000
    return "$min min. ${sec.toString().padStart(2, '0')} sec. $ms ms."
}

fun linearSearch(allEntries: List<Entry>, findList: List<String>): Int {
    var found = 0
    findList.forEach { target ->
        allEntries.forEach inner@{
            if (it.name == target) {
                found++
                return@inner
            }
        }
    }
    return found
}

fun bubbleSort(allEntries: MutableList<Entry>, linearSearchTime: Long, startTime: Long): Long {
    var sortEndTime = 0L
    for (i in allEntries.indices) {
        for (j in allEntries.indices) {
            if (allEntries[i].name > allEntries[j].name) allEntries[i] = allEntries[j].also { allEntries[j] = allEntries[i] }
        }
        sortEndTime = System.currentTimeMillis()
        if (10 * linearSearchTime < sortEndTime - startTime) return sortEndTime
    }
    return sortEndTime
}

fun jumpSearch(allEntries: List<Entry>, findList: List<String>): Int {
    var found = 0
    val jump = sqrt(allEntries.size.toDouble()).toInt()
    findList.forEach { target ->
        var index = 0
        var beforeIndex = 0
        while (index < allEntries.lastIndex) {
            if (allEntries[index].name < target) {
                beforeIndex = index
                index = min(index + jump, allEntries.lastIndex)
            }
        }
        for (i in index downTo beforeIndex + 1) {
            if (allEntries[i].name == target) {
                found++
                break
            }
        }
    }
    return found
}

fun binarySearch(allEntries: List<Entry>, target: String, left: Int, right: Int): Int {
    // [left, right]
    if (left == right) {
        return if (allEntries[left].name == target) left else -1
    } else if (left + 1 == right) {
        return when {
            allEntries[left].name == target -> left
            allEntries[right].name == target -> right
            else -> -1
        }
    }
    val mid = (left + right) / 2
    return when {
        allEntries[mid].name == target -> mid
        allEntries[mid].name < target -> binarySearch(allEntries, target, mid + 1, right)
        else -> binarySearch(allEntries, target, left, mid - 1)
    }
}

fun isSorted(list: List<Entry>): Boolean {
    for (i in 0 until list.lastIndex) {
        if (list[i].name > list[i + 1].name) return false
    }
    return true
}
