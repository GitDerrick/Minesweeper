fun main() {
    val input = readLine()!!
    var output = ""

    for (i in input) {
        repeat(2) {
            output += i
        }
    }

    println(output)
}