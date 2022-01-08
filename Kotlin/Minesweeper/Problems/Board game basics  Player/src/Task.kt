class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var idCount = 1
        fun create(name: String): Player {
            return Player(idCount++, name, 100)
        }
    }
}