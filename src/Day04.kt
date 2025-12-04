fun main() {
    fun part1(input: List<String>): Int {
        fun getChar(x: Int, y: Int) = input.getOrNull(x)?.getOrNull(y)

        var count = 0
        input.forEachIndexed { x, row ->
            row.forEachIndexed { y, char ->
                if (char == '@' && listOfNotNull(
                        getChar(x - 1, y - 1),
                        getChar(x - 1, y),
                        getChar(x - 1, y + 1),
                        getChar(x, y - 1),
                        getChar(x, y + 1),
                        getChar(x + 1, y - 1),
                        getChar(x + 1, y),
                        getChar(x + 1, y + 1),
                    ).count { it == '@' } < 4
                ) count++
            }
        }
        return count
    }

    fun part2(input: List<String>): Int {
        val chars = input.toMutableList().map { it.toMutableList() }
        fun getChar(x: Int, y: Int) = chars.getOrNull(x)?.getOrNull(y)

        var count = 0
        var prevCount = -1
        while (count != prevCount) {
            prevCount = count
            chars.forEachIndexed { x, row ->
                row.forEachIndexed { y, char ->
                    if (char == '@' && listOfNotNull(
                            getChar(x - 1, y - 1),
                            getChar(x - 1, y),
                            getChar(x - 1, y + 1),
                            getChar(x, y - 1),
                            getChar(x, y + 1),
                            getChar(x + 1, y - 1),
                            getChar(x + 1, y),
                            getChar(x + 1, y + 1),
                        ).count { it == '@' } < 4
                    ) {
                        count++
                        chars.getOrNull(x)?.set(y, ' ')
                    }
                }
            }
        }
        return count
    }

    val input = readInput("Day04")
    //part1(input).println()
    part2(input).println()
}
