data class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            val defaultTemp = when (name) {
                "Moscow" -> 5
                "Hanoi" -> 20
                "Dubai" -> 30
                else -> 0
            }
            field = when {
                value < -92 -> defaultTemp
                value > 57 -> defaultTemp
                else -> value
            }
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    var coldestCity = firstCity
    var secondColdestCity = firstCity
    if (secondCity.degrees < firstCity.degrees && secondCity.degrees < thirdCity.degrees) {
        secondColdestCity = coldestCity
        coldestCity = secondCity
    }
    if (thirdCity.degrees < secondCity.degrees && thirdCity.degrees < firstCity.degrees) {
        secondColdestCity = coldestCity
        coldestCity = thirdCity
    }

    if (coldestCity.degrees == secondColdestCity.degrees) print("neither") else print(coldestCity.name)
}