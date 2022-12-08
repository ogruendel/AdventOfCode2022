package Test

fun main() {
    val test: MutableMap<String, Int> = mutableMapOf("a" to 123)
    if (test["b"] == null) {
        test["b"] = 0
    }
    test["b"] = test.getValue("b") + 1
    println(test.getValue("b"))

}