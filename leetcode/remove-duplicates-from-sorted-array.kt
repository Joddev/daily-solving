package leetcode

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        return nums.fold((Int.MIN_VALUE to 0)) { prev, cur ->
            if (prev.first == cur) {
                prev
            } else {
                nums[prev.second] = cur
                cur to prev.second + 1
            }
        }.second
    }
}