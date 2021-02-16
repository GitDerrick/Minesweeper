class IceCreamOrder {
    var price: Int = 0

    constructor(popsicles: Int) {
        this.price = price + popsicles * 7
    }

    constructor(scoops: Int, toppings: Int) {
        this.price = price + scoops * 5 + toppings * 2
    }
}