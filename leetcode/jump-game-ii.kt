package leetcode

class JumpGameII {
    fun jump(nums: IntArray): Int {
        val dp = Array(nums.size) { 0 }
        (1 until nums.size).forEach {
            val idx = nums.size - it - 1
            dp[idx] = (1..nums[idx]).fold(Int.MAX_VALUE) { acc, i ->
                if (idx + i < dp.size && dp[idx + i] >= 0) {
                    minOf(acc, dp[idx + i])
                } else {
                    acc
                }
            } + 1
        }
        return dp[0]
    }
}