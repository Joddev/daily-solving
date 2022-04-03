package leetcode

class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        val min = binaryLowerBound(nums, 0, nums.size - 1, target)
        if (nums[min] != target) {
            return intArrayOf(-1, -1)
        }
        val max = binaryUpperBound(nums, 0, nums.size - 1, target)
        return if (nums[max] == target) {
            intArrayOf(min, max)
        } else {
            intArrayOf(min, max - 1)
        }
    }

    private fun binaryLowerBound(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start >= end) {
            return start
        }
        val mid = (start + end) / 2
        return if (nums[mid] >= target) {
            binaryLowerBound(nums, start, mid, target)
        } else {
            binaryLowerBound(nums, mid + 1, end, target)
        }
    }

    private fun binaryUpperBound(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start >= end) {
            return start
        }
        val mid = (start + end) / 2
        return if (nums[mid] > target) {
            binaryUpperBound(nums, start, mid, target)
        } else {
            binaryUpperBound(nums, mid + 1, end, target)
        }
    }
}