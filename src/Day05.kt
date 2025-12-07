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
        var position = 0L
        var sum = 0L

        input
            .takeWhile { it.isNotEmpty() }
            .map { it.split("-").let { it.first().toLong()..it.last().toLong() } }
            .sortedBy { it.first }
            .forEach { range ->
                if (range.last >= position) {
                    sum += range.last - maxOf(range.first, position) + 1
                    position = range.last + 1
                }
            }

        return sum
    }

    val input = readInput("Day05")
    //part1(input).println()
    part2(input).println()
}
