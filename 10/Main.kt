package `10`

import java.io.File

fun main() {
    var x = 1
    var cycle = 0
    var sum = 0
    val screen: MutableList<String> = mutableListOf()
    File("10/input").bufferedReader().forEachLine {
        if (it == "noop") {
            checkPixel(x, cycle, screen)
            sum += checkStrength(cycle, x)
            cycle++
        } else {
            checkPixel(x, cycle, screen)
            sum += checkStrength(cycle, x)
            cycle++
            checkPixel(x, cycle, screen)
            sum += checkStrength(cycle, x)
            cycle++
            x += it.substring(5, it.length).toInt()
        }
    }
    println("Part 1 solution: $sum")
    println(screen)
}

fun checkStrength(cycle: Int, x: Int): Int {
    when (cycle) {
        20 -> return x * cycle
        60 -> return x * cycle
        100 -> return x * cycle
        140 -> return x * cycle
        180 -> return x * cycle
        220 -> return x * cycle
    }
    return 0
}

fun checkPixel(x: Int, cycle: Int, screen: MutableList<String>) {
    var spriteCycle = cycle

    if (cycle >= 200) {
        spriteCycle -= 200
    } else if (cycle >= 160) {
        spriteCycle -= 160
    } else if (cycle >= 120) {
        spriteCycle -= 120
    } else if (cycle >= 80) {
        spriteCycle -= 80
    } else if (cycle >= 40) {
        spriteCycle -= 40
    }

    when (cycle) {
        40 -> screen.add("\n")
        80 -> screen.add("\n")
        120 -> screen.add("\n")
        160 -> screen.add("\n")
        200 -> screen.add("\n")
        240 -> screen.add("\n")
    }

    if (x in (spriteCycle - 1)..(spriteCycle + 1)) {
        screen.add("#")
    } else {
        screen.add(".")
    }
}