package parking

import java.util.*

class ParkingLot(val size: Int) {
    val parkingLot = BooleanArray(this.size) { false }
    val parkingRegNum = Array(this.size) { "" }
    val parkingCarColor = Array(this.size) { "" }

    fun park(regNumber: String, color: String) {
        when (val spot = findParkingSpot()) {
            -1 -> println("Sorry, the parking lot is full.")
            else -> {
                println("$color car parked in spot ${spot + 1}.")
                parkingLot[spot] = true
                parkingRegNum[spot] = regNumber
                parkingCarColor[spot] = color.toUpperCase()
            }
        }
    }

    fun leave(spot: Int) {
        if (parkingLot[spot - 1]) {
            println("Spot $spot is free.")
            parkingLot[spot - 1] = false
        } else {
            println("There is no car in spot $spot.")
        }
    }

    fun printStatus() {
        var empty = true
        for (i in parkingLot.indices) {
            if (parkingLot[i]) {
                println("${i + 1} ${parkingRegNum[i]} ${parkingCarColor[i]}")
                empty = false
            }
        }
        if (empty) println("Parking lot is empty.")
    }

    fun findParkingSpot(): Int {
        for (i in parkingLot.indices) {
            if (!parkingLot[i]) {
                return i
            }
        }
        return -1
    }

    fun regByColor(color: String) {
        val array = ArrayList<String>()
        for (i in parkingLot.indices) {
            if (parkingLot[i] && parkingCarColor[i] == color.toUpperCase()) {
                array.add(parkingRegNum[i])
            }
        }
        if (array.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            for (reg in array) {
                print(reg)
                if (reg != array.last()) print(", ")
            }
            println()
        }
    }

    fun spotByColor(color: String) {
        val array = ArrayList<Int>()
        for (i in parkingLot.indices) {
            if (parkingLot[i] && parkingCarColor[i] == color.toUpperCase()) {
                array.add(i + 1)
            }
        }
        if (array.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            for (reg in array) {
                print(reg)
                if (reg != array.last()) print(", ")
            }
            println()
        }
    }

    fun spotByReg(reg: String) {
        var spot = -1
        for (i in parkingLot.indices) {
            if (parkingLot[i] && parkingRegNum[i] == reg) {
                spot = i + 1
                break
            }
        }
        println(when (spot) {
            -1 -> "No cars with registration number $reg were found."
            else -> spot
        })
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    var parkingLot: ParkingLot? = null

    val sorry = "Sorry, a parking lot has not been created."
    loop@ while (true) {
        when (scanner.next()) {
            "create" -> {
                val size = scanner.nextInt()
                parkingLot = ParkingLot(size)
                println("Created a parking lot with $size spots.")
            }
            "park" -> {
                val regNumber = scanner.next()
                val color = scanner.next()
                parkingLot?.park(regNumber, color) ?: println(sorry)
            }
            "leave" -> {
                val spot = scanner.nextInt()
                parkingLot?.leave(spot) ?: println(sorry)
            }
            "status" -> {
                parkingLot?.printStatus() ?: println(sorry)
            }
            "reg_by_color" -> {
                val reg = scanner.next()
                parkingLot?.regByColor(reg) ?: println(sorry)
            }
            "spot_by_color" -> {
                val color = scanner.next()
                parkingLot?.spotByColor(color) ?: println(sorry)
            }
            "spot_by_reg" -> {
                val reg = scanner.next()
                parkingLot?.spotByReg(reg) ?: println(sorry)
            }
            "exit" -> {
                break@loop
            }
        }
    }
}