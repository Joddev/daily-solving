package leetcode

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val list = mutableListOf<String>()
        generateParenthesis("", n, n, list)
        return list
    }

    private fun generateParenthesis(prev: String, left: Int, right: Int, result: MutableList<String>) {
        if (left == 0) {
            result.add("$prev${")".repeat(right)}")
            return
        }
        if (left == right) {
            generateParenthesis("$prev(", left-1, right, result)
        } else {
            generateParenthesis("$prev(", left-1, right, result)
            generateParenthesis("$prev)", left, right-1, result)
        }
    }
}