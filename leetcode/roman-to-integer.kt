package leetcode

class RomanToInteger {
    fun romanToInt(s: String): Int {
        return s.foldIndexed(0) { idx, stack, cur ->
            val curValue = toInt(cur)
            if (idx + 1 == s.length) {
                stack + curValue
            } else {
                val nextValue = toInt(s[idx + 1])
                if (curValue < nextValue) {
                    stack - curValue
                } else {
                    stack + curValue
                }
            }
        }
    }

    private fun toInt(c: Char): Int {
        return when (c) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}