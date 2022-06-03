package leetcode

class UniqueBinarySearchTrees {
    fun numTrees(n: Int): Int {
        return numTrees(n, IntArray(n + 1))
    }

    private fun numTrees(n: Int, dp: IntArray): Int {
        if (n <= 1) {
            return 1
        }

        if (dp[n] != 0) {
            return dp[n]
        }

        return (0 until n).map { idx ->
            numTrees(idx) * numTrees(n - idx - 1)
        }.sum().also { dp[n] = it }
    }
}