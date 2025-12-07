fun main() {
    fun part1(input: List<String>): Long {
        val matrix = input.map { it.split(" ").filter(String::isNotEmpty) }
        return matrix.last().mapIndexed { index, operation ->
            val numbers = matrix.dropLast(1).map { it[index].toLong() }
            if (operation == "+") numbers.sum() else numbers.fold(1L, Long::times)
        }.sum()
    }

    fun part2(input: List<String>): Long {
        return 0L
    }

    val input = readInput("Day06")
    part1(input).println()
    //part2(input).println()
}
