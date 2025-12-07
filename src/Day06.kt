fun main() {
    fun part1(input: List<String>): Long {
        val matrix = input.map { it.split(" ").filter(String::isNotEmpty) }
        return matrix.last().mapIndexed { index, operation ->
            val numbers = matrix.dropLast(1).map { it[index].toLong() }
            if (operation == "+") numbers.sum() else numbers.fold(1L, Long::times)
        }.sum()
    }

    fun part2(input: List<String>): Long {
        val transposed = input.last().indices.map { col -> input.indices.map { row -> input[row][col] } }

        var sum = 0L
        val numbers = mutableListOf<Long>()
        transposed.reversed().forEach { column ->
            column.dropLast(1).joinToString("").trim().toLongOrNull()?.let { numbers += it }
            if (column.last() == '+') {
                sum += numbers.sum()
                numbers.clear()
            } else if (column.last() == '*') {
                sum += numbers.fold(1L, Long::times)
                numbers.clear()
            }
        }
        return sum
    }

    val input = readInput("Day06")
    //part1(input).println()
    part2(input).println()
}
