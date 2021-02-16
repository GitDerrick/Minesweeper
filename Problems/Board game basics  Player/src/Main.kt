import kotlin.random.Random

class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        fun create(name: String) = Player(Random.nextInt(), name, 100)
    }
}