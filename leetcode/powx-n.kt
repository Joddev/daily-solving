package leetcode

class PowxN {
    fun myPow(x: Double, n: Int): Double {
        if (x == 0.0 || x == 1.0) {
            return x
        }
        if (n < 0) {
            if (n == Int.MIN_VALUE) {
                return myPow(1 / x, Int.MAX_VALUE) / x
            }
            return myPow(1 / x, -n)
        }
        var ret = 1.0
        var base = x
        (0..31).forEach {
            repeat(n.shr(it).and(1)) { ret *= base }
            base *= base
        }
        return ret
    }
}