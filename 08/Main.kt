package `08`


fun main() {
    val forest = Forest()

    forest.makeForest()
    println("Part 1 solution: ${forest.countVisible()}")
    println("Part 2 solution: ${forest.maxScenicScore()}")
}