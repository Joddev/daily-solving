package leetcode

import java.util.*

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        var max = 0
        var validFrom = Stack<Int>()
        s.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(index)
                if (stack.size > validFrom.size) {
                    validFrom.push(index)
                }
            } else {
                if (stack.isEmpty()) {
                    stack.clear()
                    validFrom.clear()
                } else {
                    stack.pop()
                    if (stack.size < validFrom.size - 1) {
                        validFrom.pop()
                    }
                    max = maxOf(max, index - validFrom.peek() + 1)
                }
            }
        }
        return max
    }
}