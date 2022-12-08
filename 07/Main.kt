package `07`

import java.io.File

fun main() {
    val cmd: MutableList<String> = mutableListOf()
    var currentDir: String
    val previousDirs: MutableList<String> = mutableListOf()
    val dirs: MutableMap<String, Int> = mutableMapOf()
    val visited: MutableList<String> = mutableListOf()
    var sum = 0
    var doubledDirs = 0
    File("07/input").bufferedReader().forEachLine { cmd.add(it) }

    for (l in cmd) {
        if (l.startsWith("$ cd")) {
            if (!l.endsWith("..")) {
                currentDir = l.substring(l.lastIndexOf(" ") + 1, l.length)
                if (currentDir in visited) {
                    doubledDirs++
                    if (currentDir.substring(currentDir.length - 1).toIntOrNull() == null) {
                        currentDir += doubledDirs.toString()
                        visited.add(currentDir)
                    }
                }
                previousDirs.add(currentDir)
            } else {
                visited.add(previousDirs.last())
                previousDirs.removeLast()
            }
        } else if (l.substring(0, 1).toIntOrNull() != null) {
            for (d in previousDirs) {
                if (dirs[d] == null) {
                    dirs[d] = 0
                }
                dirs[d] = dirs.getValue(d) + l.substring(0, l.indexOf(" ")).toInt()
            }
        }
    }

    for (d in dirs) {
        if (d.value < 100000) {
            sum += d.value
        }
    }
    println("Part 1 solution: $sum")

    val spaceTotal = 70000000
    val spaceUpdate = 30000000
    val freeSpace = spaceTotal - dirs.getValue("/")
    val toClear = spaceUpdate - freeSpace
    var smallestDir = "/"

    for (d in dirs) {
        if (d.value >= toClear && d.value < dirs.getValue(smallestDir)) {
            smallestDir = d.key
        }
    }
    println("Part 2 solution: ${dirs.getValue(smallestDir)}")
}