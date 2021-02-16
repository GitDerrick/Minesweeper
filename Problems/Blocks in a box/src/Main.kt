class Block(val color: String) {
    object DimProperties {
        var length = 6
        var width = 4

        fun blocksInBox(boxLength: Int, boxWidth: Int): Int {
            val blockInBoxWidth = boxWidth / DimProperties.width
            val blockInBoxLength = boxLength / DimProperties.length
            return blockInBoxWidth * blockInBoxLength
        }
    }
}