package leetcode

class WildcardMatching {
    fun isMatch(s: String, p: String): Boolean {
        val dp = Array(s.length) { Array(p.length) { 0 } }
        return isMatch(s, p, 0, 0, dp)
    }

    fun isMatch(s: String, p: String, si: Int, pi: Int, dp: Array<Array<Int>>): Boolean {
        if (pi == p.length) {
            return si == s.length
        }
        if (si == s.length) {
            return p[pi] == '*' && isMatch(s, p, si, pi+1, dp)
        }
        if (dp[si][pi] != 0) {
            return dp[si][pi] == 1
        }
        val value = when (p[pi]) {
            '*' -> {
                isMatch(s, p, si, pi+1, dp) || isMatch(s, p, si+1, pi, dp)
            }
            '?' -> {
                isMatch(s, p, si+1, pi+1, dp)
            }
            else -> {
                s[si] == p[pi] && isMatch(s, p, si+1, pi+1, dp)
            }
        }
        dp[si][pi] = if (value) 1 else -1
        return value
    }
}
