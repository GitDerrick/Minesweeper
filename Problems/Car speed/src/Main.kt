fun speedChecker(carSpeed: Int, speedLimit: Int = 60) {
    if (carSpeed <= speedLimit) println("Within the limit") else {
        println("Exceeds the limit by ${carSpeed - speedLimit} kilometers per hour")
    }
}

fun main() {
    val carSpeed = readLine()!!.toInt()
    val speedLimit = readLine()!!

    if (speedLimit == "no limit") speedChecker(carSpeed) else speedChecker(carSpeed, speedLimit.toInt())
}