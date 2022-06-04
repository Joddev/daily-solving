package leetcode

class InterleavingString {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        return isInterleave(s1, s2, s3, 0, 0, Array(s1.length + 1) { IntArray(s2.length + 1) { -1 } })
    }
    private fun isInterleave(s1: String, s2: String, s3: String, i: Int, j: Int, dp: Array<IntArray>): Boolean {
        if (i + j == s3.length) return true
        if (dp[i][j] != -1) return dp[i][j] == 1

        val c1 = if (i < s1.length) s1[i] else null
        val c2 = if (j < s2.length) s2[j] else null
        val c3 = s3[i + j]

        var result = false
        if (c1 == c3) {
            result = result || isInterleave(s1, s2, s3, i + 1, j, dp)
        }

        if (c2 == c3) {
            result = result || isInterleave(s1, s2, s3, i, j + 1, dp)
        }
        dp[i][j] = if (result) 1 else 0
        return result
    }
}