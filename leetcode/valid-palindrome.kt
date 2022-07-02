package leetcode

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val target = convert(s)
        (0 until target.length / 2).forEach {
            if (target[it] != target[target.length - it - 1]) {
                return false
            }
        }
        return true
    }

    private fun convert(s: String): String {
        return s.toLowerCase().fold("") { acc, c ->
            if (!c.isLetter()) {
                acc
            } else {
                acc + c
            }
        }
    }
}