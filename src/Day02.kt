fun main() {
    fun part1(input: List<String>): Long {
        return input[0]
            .split(",")
            .sumOf { section ->
                section
                    .split("-")
                    .let { it[0].toLong()..it[1].toLong() }
                    .filter {
                        val str = it.toString()
                        (1..str.length).any {
                            str == str.take(it).repeat(2)
                        }
                    }
                    .sum()
            }
    }

    fun part2(input: List<String>): Long {
        return input[0]
            .split(",")
            .sumOf { section ->
                section
                    .split("-")
                    .let { it[0].toLong()..it[1].toLong() }
                    .filter {
                        val str = it.toString()
                        (1..str.length).any { substr ->
                            (2..str.length).any { repeat ->
                                str == str.take(substr).repeat(repeat)
                            }
                        }
                    }
                    .sum()
            }
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
