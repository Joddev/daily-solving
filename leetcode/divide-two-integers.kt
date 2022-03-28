package leetcode

class DivideTwoIntegers {
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 0) return 0
        if (dividend == Int.MIN_VALUE) {
            if (divisor == 1) return Int.MIN_VALUE
            if (divisor == -1) return Int.MAX_VALUE
            if (divisor == Int.MIN_VALUE) return 1
        }
        if (divisor == Int.MIN_VALUE) {
            return 0
        }
        val a = if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) -1 else 1
        var ret = 0
        var cur = dividend
        val cut = if (a > 0) divisor else -divisor
        if (dividend > 0) {
            while (cur >= cut) {
                cur -= cut
                ret += 1
            }
        } else {
            while (cur <= cut) {
                cur -= cut
                ret += 1
            }
        }
        println(ret)
        return if (a > 0) ret else -ret
    }
}