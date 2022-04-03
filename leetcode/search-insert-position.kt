package leetcode

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        return binarySearch(nums, 0, nums.size, target)
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start == end) {
            return start
        }
        val mid = (start + end) / 2
        return if (nums[mid] > target) {
            binarySearch(nums, start, mid, target)
        } else {
            binarySearch(nums, mid + 1, end, target)
        }
    }
}