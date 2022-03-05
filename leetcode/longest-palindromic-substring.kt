package leetcode

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        val dp = Array(s.length) { IntArray(s.length) }
        var longest = ""
        s.indices.forEach { i ->
            (i until s.length).forEach { j ->
                if (searchPalindromes(s, i, j, dp)) {
                    if (j - i + 1 > longest.length) {
                        longest = s.substring(i, j + 1)
                    }
                }
            }
        }
        return longest
    }

    fun searchPalindromes(s: String, start: Int, end: Int, dp: Array<IntArray>): Boolean {
        if (start == end) {
            dp[start][end] = 1
        }
        if (dp[start][end] != 0) {
            return dp[start][end] == 1
        }
        if (start + 1 >= end - 1) {
            dp[start][end] = if (s[start] == s[end]) 1 else -1
        } else {
            dp[start][end] = if (searchPalindromes(s, start + 1, end - 1, dp) && s[start] == s[end]) 1 else -1
        }
        return dp[start][end] == 1
    }
}
