package Test

fun main() {
    val list = mutableListOf<Char>('A', 'B', 'B', 'C')
    var i = 0

    for (char in list) {
        i++
        if (list.lastIndexOf(char) != list.indexOf(char)) {
            println(i)
        }
    }
}