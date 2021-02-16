fun usedCarPriceCalculator(old: Int = 5, passed: Int = 100_000, speed: Int = 120, auto: Int = 0) {
    var carPrice = 20_000
    val yearlyDepreciation = 2000 * old
    val mileageDepreciation = 200 * (passed / 10_000)
    val speedFactor = (speed - 120) * 100
    val transFactor = if (auto == 1) 1500 else 0

    carPrice = carPrice - yearlyDepreciation - mileageDepreciation + speedFactor + transFactor
    println(carPrice)
}

fun main() {
    val parameter = readLine()!!.toString()
    val value = readLine()!!.toInt()

    when (parameter) {
        "old" -> usedCarPriceCalculator(old = value)
        "passed" -> usedCarPriceCalculator(passed = value)
        "speed" -> usedCarPriceCalculator(speed = value)
        "auto" -> usedCarPriceCalculator(auto = value)
    }
}