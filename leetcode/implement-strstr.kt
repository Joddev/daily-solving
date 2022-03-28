package leetcode

class ImplementStrstr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        (0..(haystack.length - needle.length)).forEach { pad ->
            if (needle.indices.all { haystack[pad + it] == needle[it] }) {
                return pad
            }
        }
        return -1
    }
}