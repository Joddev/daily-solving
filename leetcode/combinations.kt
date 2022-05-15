package leetcode

class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        return combine(listOf(), n, k)
    }

    private fun combine(acc: List<Int>, max: Int, limit: Int): List<List<Int>> {
        val size = acc.size
        if (size == limit) return listOf(acc)

        val last = acc.lastOrNull() ?: 0
        return (1..max-last).flatMap {
            combine(acc.plus(last + it), max, limit)
        }
    }
}