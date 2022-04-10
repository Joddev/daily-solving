package leetcode

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.forEachIndexed { index, it ->
            if (0 > it || it > nums.size) nums[index] = 0
        }
        nums.forEach {
            var num = it - 1
            while (num > -1) {
                val next = nums[num] - 1
                nums[num] = -1
                num = next
            }
        }
        nums.forEachIndexed { index, it ->
            if (it != -1) {
                return index + 1
            }
        }
        return nums.size + 1
    }
}