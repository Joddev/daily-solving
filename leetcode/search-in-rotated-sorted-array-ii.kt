package leetcode

class SearchInRotatedSortedArrayII {
    fun search(nums: IntArray, target: Int): Boolean {
        var k = 1
        while (k < nums.size && nums[k - 1] <= nums[k]) k++
        return binarySearch(nums, target, 0, nums.size, k)
    }

    private fun binarySearch(nums: IntArray, target: Int, begin: Int, end: Int, padding: Int): Boolean {
        val mid = (begin + end) / 2
        val midValue = nums[(mid + padding) % nums.size]
        if (target == midValue) return true
        if (begin == end) return false

        if (target < midValue) return binarySearch(nums, target, begin, mid, padding)
        return binarySearch(nums, target, mid + 1, end, padding)
    }
}