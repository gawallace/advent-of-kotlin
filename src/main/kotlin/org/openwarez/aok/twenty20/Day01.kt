package org.openwarez.aok.twenty20

import org.openwarez.aok.readInput

fun main() {
    val sumTarget = 2020

    fun part1(input: List<Int>): Int {
        val sumPair = findPairWithSum(input, sumTarget)

        if (sumPair != null) {
            return sumPair.first * sumPair.second
        }

        return 0
    }

    fun part2(input: List<Int>): Int {
        val sumTriple = findTripleWithSum(input, sumTarget)

        if (sumTriple != null) {
            return sumTriple.first * sumTriple.second * sumTriple.third
        }

        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("2020/01/part1.txt")
    println(part1(testInput1.map { it.toInt() }))
    println(part2(testInput1.map { it.toInt() }))
}

fun findPairWithSum(numbers: List<Int>, target: Int): Pair<Int, Int>? {
    val numMap = mutableMapOf<Int, Int>()

    for (num in numbers) {
        val complement = target - num
        if (numMap.containsKey(complement)) {
            return Pair(complement, num)
        }
        numMap[num] = num
    }

    return null
}

fun findTripleWithSum(numbers: List<Int>, target: Int): Triple<Int, Int, Int>? {
    val numMap = mutableMapOf<Int, Int>()

    for (i in numbers.indices) {
        for (j in i + 1 until numbers.size) {
            val complement = target - numbers[i] - numbers[j]
            if (numMap.containsKey(complement)) {
                return Triple(complement, numbers[i], numbers[j])
            }
        }
        numMap[numbers[i]] = i
    }

    return null
}
