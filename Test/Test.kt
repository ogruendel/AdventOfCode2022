package Test

fun main() {
    val list: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)
    val list2: MutableList<Int> = mutableListOf()
    val end = 3

    val toMove = list.subList(list.size - end, list.size)

    for (e in toMove) {
        list2.add(e)
    }

}