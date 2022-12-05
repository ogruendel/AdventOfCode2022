package `05`

import java.io.File

class Crane9000 {
    fun start() {
        val crates = Crates()

        val counts: MutableList<Int> = mutableListOf()
        File("05/operations").forEachLine {
            if (it.substring(6, 7) == " ") {
                counts.add(it.substring(5, 6).toInt())
            } else {
                counts.add(it.substring(5, 7).toInt())
            }
        }
        val starts: MutableList<Int> = mutableListOf()
        File("05/operations").forEachLine {
            starts.add(it.substring(it.length - 6, it.length - 5).toInt())
        }
        val ends: MutableList<Int> = mutableListOf()
        File("05/operations").forEachLine {
            ends.add(it.substring(it.length - 1).toInt())
        }

        var i = 0

        while (i != counts.size) {
            move(counts[i], starts[i], ends[i], crates)
            i++
        }

        solve(crates)
    }

    private fun move(count: Int, start: Int, end: Int, crates: Crates) {
        var amount = count
        while (amount != 0) {
            val toMove = crates.crates[start - 1][crates.crates[start - 1].size - 1]
            crates.crates[end - 1].add(toMove)
            crates.crates[start - 1].removeLast()

            amount--
        }
    }

    private fun solve(crates: Crates) {
        var solution = ""
        for (line in crates.crates) {
            if (line.size != 0) {
                solution += line[line.size - 1]
            }
        }
        println("Part 1 solution: $solution")
    }
}