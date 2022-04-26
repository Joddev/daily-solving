package leetcode

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.split(" ").last { it.isNotBlank() }.length
    }
}