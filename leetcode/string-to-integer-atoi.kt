package leetcode

class StringToInteger {
    fun myAtoi(s: String): Int {
        var beforeDigit = true
        var stack = 0
        var coefficient = 1
        s.forEach {
            if (beforeDigit) {
                when (it) {
                    '-' -> {
                        beforeDigit = false
                        coefficient = -1
                    }
                    '+' -> {
                        beforeDigit = false
                    }
                    in '0'..'9' -> {
                        beforeDigit = false
                        stack = append(stack, (it - '0') * coefficient)
                    }
                    ' ' -> {
                    }
                    else -> {
                        return 0
                    }
                }
            } else {
                when (it) {
                    in '0'..'9' -> {
                        stack = append(stack, (it - '0') * coefficient)
                    }
                    else -> {
                        return stack
                    }
                }
            }
        }
        return stack
    }

    private fun append(stack: Int, cur: Int): Int {
        if (stack > Int.MAX_VALUE / 10) return Int.MAX_VALUE
        if (stack < Int.MIN_VALUE / 10) return Int.MIN_VALUE
        if (stack == Int.MAX_VALUE / 10 && cur >= 7) return Int.MAX_VALUE
        if (stack == Int.MIN_VALUE / 10 && cur <= -8) return Int.MIN_VALUE
        return stack * 10 + cur
    }
}