package leetcode

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        var (i, j) = 1 to 2
        var cur = 2
        while (cur < n) {
            if (cur % 2 == 0) {
                i += j
            } else {
                j += i
            }
            cur++
        }

        return if (cur % 2 == 0) j else i
    }
}