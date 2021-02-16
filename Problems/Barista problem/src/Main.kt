class EspressoMachine{
    var costPerServing: Float = 0F

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        this.costPerServing = totalCost / coffeeCapsulesCount.toFloat()
    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) {
        this.costPerServing = totalCost / (coffeeBeansWeight / 10.6F).toInt()
    }
}