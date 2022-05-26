package leetcode

class ScrambleString {
    fun isScramble(s1: String, s2: String): Boolean {
        val dp = Array(s1.length + 1) { Array(s1.length + 1) { Array(s2.length + 1) { IntArray(s2.length + 1) { -1 } } } }
        return isScramble(s1, s2, 0, s1.length, 0, s2.length, dp)
    }

    private fun isScramble(s1: String, s2: String, b1: Int, e1: Int, b2: Int, e2: Int, dp: Array<Array<Array<IntArray>>>): Boolean {
        if (dp[b1][e1][b2][e2] != -1) return dp[b1][e1][b2][e2] == 1
        val a = s1.substring(b1, e1)
        val b = s2.substring(b2, e2)
        if (a == b) {
            dp[b1][e1][b2][e2] = 1
            return true
        }
        if (a.length == 1) return false

        return (1 until a.length).any {
            (isScramble(s1, s2, b1, b1 + it, b2, b2 + it, dp) && isScramble(s1, s2, b1 + it, e1, b2 + it, e2, dp))
                    || (isScramble(s1, s2, b1, b1 + it, e2 - it, e2, dp) && isScramble(s1, s2, b1 + it, e1, b2, e2 - it, dp))
        }.also {
            dp[b1][e1][b2][e2] = if (it) 1 else 0
        }
    }
}