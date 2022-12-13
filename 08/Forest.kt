package `08`

import java.io.File

class Forest {
    private val forest: MutableList<MutableList<Int>> = mutableListOf()
    fun makeForest() {
        File("08/input").bufferedReader().forEachLine {
            val line: MutableList<Int> = mutableListOf()
            for (num in it) {
                line.add(num.toString().toInt())
            }
            forest.add(line)
        }
    }

    fun getForest(): MutableList<MutableList<Int>> {
        return forest
    }

    fun countVisible(): Int {
        var sum = 0
        for ((row, line) in forest.withIndex()) {
            for ((column, tree) in line.withIndex()) {
                // Is it visible from the left?
                val toLeft: MutableList<Int> = line.subList(0, column)

                //Is it visible from the right?
                val toRight: MutableList<Int> = line.subList(column + 1, line.size)

                //Is it visible from above?
                val above: MutableList<Int> = mutableListOf()
                for (l in 0 until row) {
                    above.add(forest[l][column])
                }

                //Is it visible from below?
                val below: MutableList<Int> = mutableListOf()
                for (l in row + 1 until forest.size) {
                    below.add(forest[l][column])
                }

                if (toLeft.isEmpty() || toRight.isEmpty() || above.isEmpty() || below.isEmpty()) {
                    sum++
                } else if (tree > toLeft.max() || tree > toRight.max() || tree > above.max() || tree > below.max()) {
                    sum++
                }
            }
        }
        return sum
    }

    fun maxScenicScore(): Int {
        var currentScore: Int
        var maxScore = 0
        var scoreLeft = 0
        var scoreRight = 0
        var scoreAbove = 0
        var scoreBelow = 0

        for ((row, line) in forest.withIndex()) {
            for ((column, tree) in line.withIndex()) {
                // Is it visible from the left?
                val toLeft: MutableList<Int> = line.subList(0, column)

                // Is it visible from the right?
                val toRight: MutableList<Int> = line.subList(column + 1, line.size)

                // Is it visible from above?
                val above: MutableList<Int> = mutableListOf()
                for (l in 0 until row) {
                    above.add(forest[l][column])
                }

                // Is it visible from below?
                val below: MutableList<Int> = mutableListOf()
                for (l in row + 1 until forest.size) {
                    below.add(forest[l][column])
                }

                // Go left
                for (height in toLeft.reversed()) {
                    if (height < tree) {
                        scoreLeft++
                    } else {
                        scoreLeft++
                        break
                    }
                }

                // Go right
                for (height in toRight) {
                    if (height < tree) {
                        scoreRight++
                    } else {
                        scoreRight++
                        break
                    }
                }
                // Go up
                for (height in above.reversed()) {
                    if (height < tree) {
                        scoreAbove++
                    } else {
                        scoreAbove++
                        break
                    }
                }
                // Go down
                for (height in below) {
                    if (height < tree) {
                        scoreBelow++
                    } else {
                        scoreBelow++
                        break
                    }
                }

                currentScore = scoreLeft * scoreRight * scoreAbove * scoreBelow

                scoreLeft = 0
                scoreRight = 0
                scoreAbove = 0
                scoreBelow = 0

                if (currentScore > maxScore) {
                    maxScore = currentScore
                }
            }
        }
        return maxScore
    }
}