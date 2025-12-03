fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            val numbers = line.map(Char::digitToInt)
            (0 .. numbers.size - 2).maxOf { i ->
                10 * numbers[i] + numbers.drop(i + 1).max()
            }
        }
    }

    fun part2(input: List<String>): Long {
        fun getMaxJoltage(numbers: List<Int>, batteryCount: Int): Long {
            return if (batteryCount == 1) {
                1L * numbers.max()
            } else {
                val next = numbers.dropLast(batteryCount - 1).max()
                val exp = (1..<batteryCount).fold(1L) { acc, _ -> acc * 10 }
                exp * next + getMaxJoltage(numbers.drop(numbers.indexOf(next) + 1), batteryCount - 1)
            }
        }

        return input.sumOf { line ->
            getMaxJoltage(line.map(Char::digitToInt), 12)
        }
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
