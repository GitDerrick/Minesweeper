fun main() {
    val color = readLine()!!
    println(RainbowColors.valueOf(color.toUpperCase()).ordinal + 1)
}

enum class RainbowColors(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet"),
}