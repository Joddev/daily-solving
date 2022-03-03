package leetcode

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        (nums.indices).forEach { a ->
            (a + 1 until nums.size).forEach { b ->
                if (nums[a] + nums[b] == target) {
                    return intArrayOf(a, b)
                }
            }
        }
        return intArrayOf()
    }
}
