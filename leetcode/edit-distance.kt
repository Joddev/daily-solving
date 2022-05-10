package leetcode

class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length) { IntArray(word2.length) { -1 } }
        return innerMinDistance(dp, word1, 0, word2, 0)
    }

    private fun innerMinDistance(dp: Array<IntArray>, word1: String, idx1: Int, word2: String, idx2: Int): Int {
        if (word1.length == idx1 || word2.length == idx2) {
            return maxOf(word1.length - idx1, word2.length - idx2)
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2]
        }
        if (word1[idx1] == word2[idx2]) {
            dp[idx1][idx2] = innerMinDistance(dp, word1, idx1 + 1, word2, idx2 + 1)
            return dp[idx1][idx2]
        }
        var ret = Int.MAX_VALUE
        ret = minOf(ret, innerMinDistance(dp, word1, idx1 + 1, word2, idx2))
        ret = minOf(ret, innerMinDistance(dp, word1, idx1, word2, idx2 + 1))
        ret = minOf(ret, innerMinDistance(dp, word1, idx1 + 1, word2, idx2 + 1))
        dp[idx1][idx2] = ret + 1
        return ret + 1
    }
}