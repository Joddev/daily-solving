package leetcode

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var ret = 0
        var minDiff = Int.MAX_VALUE
        nums.indices.forEach { a ->
            (a + 1 until nums.size).forEach { b ->
                (b + 1 until nums.size).forEach { c ->
                    val threeSum = nums[a] + nums[b] + nums[c]
                    val value = kotlin.math.abs(threeSum - target)
                    if (value < minDiff) {
                        minDiff = value
                        ret = threeSum
                    }
                }
            }
        }
        return ret
    }
}