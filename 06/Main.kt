package `06`

import java.io.File

fun main() {
    var iterator = 0
    val input = File("06/input").bufferedReader().readText()
    val packet = mutableListOf<Char>()

    for (char in input) {
        if (packet.size == 4) {
            if (checkForStarterPacket(packet)) {
                println("Part 1 solution: $iterator")
                break
            }
            packet.removeFirst()
        }
        iterator++
        packet.add(char)
    }
    iterator = 0

    for (char in input) {
        if (packet.size == 14) {
            if (checkForMessagePacket(packet)) {
                println("Part 2 solution: $iterator")
                break
            }
            packet.removeFirst()
        }
        iterator++
        packet.add(char)
    }
}

fun checkForStarterPacket(packet: MutableList<Char>): Boolean {
    for (char in packet) {
        if (packet.indexOf(char) != packet.lastIndexOf(char)) {
            return false
        }
    }
    return true
}

fun checkForMessagePacket(packet: MutableList<Char>): Boolean {
    for (char in packet) {
        if (packet.indexOf(char) != packet.lastIndexOf(char)) {
            return false
        }
    }
    return true
}