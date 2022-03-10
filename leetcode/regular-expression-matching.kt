package leetcode

class RegularExpressionMatching {
    class Expression(
        private val value: Char,
        val multiple: Boolean
    ) {
        fun match(c: Char): Boolean {
            return value == c || value == '.'
        }
    }

    private fun String.toExpressions(): List<Expression> {
        var idx = 0
        val expressions = mutableListOf<Expression>()
        while (idx < length - 1) {
            idx += if (this[idx + 1] == '*') {
                expressions.add(Expression(this[idx], true))
                2
            } else {
                expressions.add(Expression(this[idx], false))
                1
            }
        }
        if (idx < length) {
            expressions.add(Expression(this[idx], false))
        }
        return expressions
    }

    fun isMatch(s: String, p: String): Boolean {
        val expressions = p.toExpressions()
        val dp = Array(s.length + 1) { BooleanArray(expressions.size + 1) }

        (0 .. s.length).forEach { a ->
            (0..expressions.size).forEach { b ->
                if (a == 0 && b == 0) {
                    dp[a][b] = true
                } else if (b - 1 <0) {
                    dp[a][b] = false
                } else if (a - 1 < 0) {
                    dp[a][b] = expressions[b - 1].multiple && dp[a][b - 1]
                } else if (expressions[b - 1].match(s[a - 1]) && dp[a - 1][b - 1]) {
                    dp[a][b] = true
                } else if (expressions[b - 1].multiple) {
                    dp[a][b] = (dp[a - 1][b] && expressions[b -1].match(s[a - 1])) || dp[a][b - 1]
                } else {
                    dp[a][b] = false
                }
            }
        }
        return dp[s.length][expressions.size]
    }
}