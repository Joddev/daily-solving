package leetcode

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        digits[digits.size - 1] += 1
        var cur = digits.size - 1
        while (cur > 0 && digits[cur] == 10) {
            digits[cur] = 0
            digits[cur - 1] += 1
            cur--
        }
        return if (digits[0] == 10) {
            val ret = IntArray(digits.size + 1)
            digits.indices.forEach {
                ret[it + 1] = digits[it]
            }
            ret[0] = 1
            ret[1] = 0
            ret
        } else {
            digits
        }
    }
}