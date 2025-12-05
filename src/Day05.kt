fun main() {
    fun part1(input: List<String>): Int {
        val ranges = input
            .takeWhile { it.isNotEmpty() }
            .map { it.split("-").let { it.first().toLong()..it.last().toLong() } }
        return input
            .dropWhile { it.isNotEmpty() }
            .drop(1)
            .count { id ->
                ranges.any { id.toLong() in it }
            }
    }

    fun part2(input: List<String>): Long {
        return 0L
    }

    val input = readInput("Day05")
    //part1(input).println()
    part2(input).println()
}
