package leetcode

class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        nums.reduce { acc, i ->
            val ret = if (acc > 0) acc + i else i
            max = maxOf(ret, max)
            ret
        }
        return max
    }
}