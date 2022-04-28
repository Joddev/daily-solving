package leetcode

class PermutationSequence {
    fun getPermutation(n: Int, k: Int): String {
        val array = IntArray(n) { 0 }
        repeat(n) { array[it] = it + 1 }
        return getPermutation(n, k - 1, array, "")
    }

    private fun getPermutation(n: Int, k: Int, array: IntArray, result: String): String {
        if (n == 0) return result

        val sd = factorial(n - 1)
        val nth = k / sd
        val left = k % sd
        return getPermutation(n - 1, left, array, result + getNth(nth, array))
    }

    private fun getNth(n: Int, array: IntArray): Int {
        var cnt = 0
        var idx = 0
        while (cnt < n) {
            val cur = array[idx]
            if (cur != 0) {
                cnt++
            }
            idx++
        }
        val ret = array[idx - 1]
        array[idx - 1] = 0
        return ret
    }

    private fun factorial(n: Int): Int {
        var cur = 2
        var ret = 1
        while (cur <= n) {
            ret *= cur
            cur++
        }
        return ret
    }
}