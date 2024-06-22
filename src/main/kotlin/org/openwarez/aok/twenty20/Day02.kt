package org.openwarez.aok.twenty20

import org.openwarez.aok.readInput

val regex = Regex("""(\d+)-(\d+) ([a-z]): (.+)""")

fun main() {
    fun part1(input: List<String>): Int {
        return input.count { pwd ->
            val (min, max, character, password) = transformPasswordPolicy(pwd)
            val count = password.count { it == character }
            count in min..max
        }
    }

    fun part2(input: List<String>): Int {
        return input.count { pwd ->
            val (pos1, pos2, character, password) = transformPasswordPolicy(pwd)
            (password[pos1 - 1] == character) xor (password[pos2 - 1] == character)
        }
    }

    val input = readInput("2020/02/input.txt")
    println(part1(input))
    println(part2(input))
}

fun transformPasswordPolicy(input: String): Quadruple<Int, Int, Char, String> {
    val matchResult = regex.find(input)
        ?: throw IllegalArgumentException("Input string is not in the expected format")

    val (int1, int2, character, password) = matchResult.destructured
    return Quadruple(int1.toInt(), int2.toInt(), character[0], password)
}

data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
