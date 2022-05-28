package leetcode

class DecodeWays {
    fun numDecodings(s: String): Int {
        return numDecodings(s, 0, IntArray(s.length) { -1 })
    }

    private fun numDecodings(s: String, from: Int, dp: IntArray): Int {
        if (from == s.length) return 1
        if (dp[from] != -1) return dp[from]

        var ret = 0
        val single = s[from]
        if (single != '0') {
            ret += numDecodings(s, from + 1, dp)
        }

        if (from + 1 < s.length) {
            val value = s.substring(from, from + 2).toInt()
            if (value in 10..26) ret += numDecodings(s, from + 2, dp)
        }
        dp[from] = ret
        return ret
    }
}