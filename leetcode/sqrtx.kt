package leetcode

class Sqrtx {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        var (low, high) = 1 to 46340
        while (high - low > 1) {
            val mid = (low + high) / 2
            val cur = mid * mid
            if (x == cur) {
                return mid
            } else if (x > cur) {
                low = mid
            } else {
                high = mid - 1
            }
        }
        if (high * high <= x) return high
        return low
    }
}