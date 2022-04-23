package leetcode

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val dp = BooleanArray(nums.size)
        dp[nums.size - 1] = true
        (2.. nums.size).forEach { a ->
            val idx = nums.size - a
            dp[idx] = (idx + 1..minOf(nums.size - 1, idx + nums[idx])).any { dp[it] }
        }
        return dp[0]
    }
}