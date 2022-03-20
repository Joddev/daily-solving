package leetcode

import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach { cur ->
            if ("([{".contains(cur)) {
                stack.push(cur)
            } else {
                if (stack.isEmpty() || stack.pop().let { if (it == '(') it + 1 else it + 2 } != cur) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}