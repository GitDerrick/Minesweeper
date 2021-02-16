import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val n = scanner.nextInt()

    val upperCase = ('A'..'Z').joinToString("")
    val lowerCase = ('a'..'z').joinToString("")
    val numbers = ('0'..'9').joinToString("")
    val leftovers = upperCase.substring(a % upperCase.length) +
            lowerCase.substring(b % lowerCase.length) + numbers.substring(c % numbers.length)

    val extra = n - a - b - c

    var output = charArrayOf()

    for (i in 0 until a) output += upperCase[i % upperCase.length]
    for (i in 0 until b) output += lowerCase[i % lowerCase.length]
    for (i in 0 until c) output += numbers[i % numbers.length]
    for (i in 0 until extra) output += leftovers[i % leftovers.length]

    println(String(output))
}