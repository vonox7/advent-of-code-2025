fun main() {
    fun part1(input: List<String>): Int {
        var beamPositions = setOf(input.first().indexOf('S'))
        var splits = 0
        input.drop(1).forEach { line ->
            val newBeamPositions = beamPositions.toMutableSet()
            line.forEachIndexed { pos, char ->
                if (char == '^') {
                    if (pos in beamPositions) {
                        newBeamPositions.remove(pos)
                        newBeamPositions.add(pos - 1)
                        newBeamPositions.add(pos + 1)
                        splits++
                    }
                }
            }
            beamPositions = newBeamPositions
        }
        return splits
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day07")
    part1(input).println()
    //part2(input).println()
}
