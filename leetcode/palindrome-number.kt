package leetcode

class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var cur = x
        var reversed = 0
        while (cur > 0) {
            reversed = reversed * 10 + cur % 10
            cur /= 10
        }
        return reversed == x
    }
}