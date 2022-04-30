package leetcode

class UniquePaths {
    private val primeNumbers = getPrimeNumbers(100)

    fun uniquePaths(m: Int, n: Int): Int {
        val mid = minOf(m, n) - 1

        val left = IntArray(mid)
        repeat(mid) { left[it] = m + n - 2 - it }
        val right = IntArray(mid)
        repeat(mid) { right[it] = it + 1 }

        val map = minus(destruct(left), destruct(right))
        if (map.isEmpty()) {
            return 1
        }

        return map.map {
            var cur = 1
            var ret = it.key
            while (cur < it.value) {
                cur++
                ret *= it.key
            }
            ret
        }.reduce { acc, it -> acc * it }
    }

    private fun destruct(array: IntArray): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        array.forEach {
            var cur = it
            while (cur > 1) {
                var idx = 0
                while (cur % primeNumbers[idx] != 0) idx++
                val prime = primeNumbers[idx]
                if (map.contains(prime)) {
                    map[prime] = map.getValue(prime) + 1
                } else {
                    map[prime] = 1
                }
                cur /= prime
            }
        }
        return map
    }

    private fun minus(a: Map<Int, Int>, b: Map<Int, Int>): Map<Int, Int> {
        val ret = a.toMutableMap()
        b.forEach {
            ret[it.key] = a.getValue(it.key) - it.value
        }
        return ret.filterValues { it > 0 }
    }

    private fun getPrimeNumbers(n: Int): List<Int> {
        val map = BooleanArray(n + 1) { true }
        map[0] = false
        map[1] = false
        var cur = 2
        while (cur <= n) {
            if (map[cur]) {
                var now = n * 2
                while (now <= n) {
                    map[now] = false
                    now += n
                }
            }
            cur++
        }
        return map.mapIndexed { index, b -> if (b) index else 0  }.filter { it != 0 }
    }
}