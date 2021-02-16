fun main() {
    val color = readLine()!!
    println(Rainbow.findByColor(color))
}

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    companion object {
        fun findByColor(color: String): Boolean {
            for (enum in values()) {
                if (color.toUpperCase() == enum.toString()) return true
            }
            return false
        }
    }
}