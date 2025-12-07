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

    fun part2(input: List<String>): Long {
        var beams = input.first().map { if (it == 'S') 1L else 0L }.toMutableList()
        var beamCount = 1L
        input.drop(1).forEach { line ->
            val newBeams = beams.toMutableList()
            line.forEachIndexed { pos, char ->
                if (char == '^') {
                    newBeams[pos] = 0L
                    newBeams[pos - 1] += beams[pos]
                    newBeams[pos + 1] += beams[pos]
                    beamCount += beams[pos]
                }
            }
            beams = newBeams
        }
        return beamCount
    }

    val input = readInput("Day07")
    //part1(input).println()
    part2(input).println()
}
