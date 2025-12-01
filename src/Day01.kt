import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {
    fun part1(input: List<String>): Int {
        var zeroCounter = 0
        var currentPos = 50
        for (line in input) {
            val offset = line.replace("L", "-").replace("R", "").toInt()
            currentPos = (currentPos + offset).mod(100)
            if (currentPos == 0) zeroCounter++
        }
        return zeroCounter
    }

    fun part2(input: List<String>): Int {
        var zeroCounter = 0
        var currentPos = 50
        for (line in input) {
            val offset = line.replace("L", "-").replace("R", "").toInt()
            repeat (offset.absoluteValue) {
                currentPos = (currentPos + offset.sign).mod(100)
                if (currentPos == 0) zeroCounter++
            }
        }
        return zeroCounter
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
