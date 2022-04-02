package leetcode

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        val offset = searchOffset(nums, 0, nums.size - 1)
        return binarySearch(nums, 0, nums.size - 1, target, offset)
    }

    private fun searchOffset(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) {
            return start
        }
        val mid = (start + end) / 2
        return if (nums[end] > nums[mid]) {
            searchOffset(nums, start, mid)
        } else {
            searchOffset(nums, mid + 1, end)
        }
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int, offset: Int): Int {
        if (start == end) {
            return if (nums[(start+offset)%nums.size] == target) (start+offset)%nums.size else -1
        }

        val mid = (start + end) / 2
        return if (nums[(mid+offset)%nums.size] >= target) {
            binarySearch(nums, start, mid, target, offset)
        } else {
            binarySearch(nums, mid + 1, end, target, offset)
        }
    }
}