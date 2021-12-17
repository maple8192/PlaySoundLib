package io.github.maple8192.playsoundlib.util

object MathUtil {
    tailrec fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a

        return gcd(b, b % a)
    }

    tailrec fun gcd(numbers: List<Int>): Int {
        if (numbers.isEmpty()) return 0
        if (numbers.size == 1) return numbers[0]

        val lastGCD = gcd(numbers[numbers.lastIndex], numbers[numbers.lastIndex - 1])
        return gcd(numbers.dropLast(2).toMutableList().also { it.add(lastGCD) }.toList())
    }
}