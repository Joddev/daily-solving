package leetcode

fun main() {
    val a = intArrayOf(1,1,1,2,2,3)
    RemoveDuplicatesFromSortedArrayII().removeDuplicates(a)
    println(a.joinToString(","))
}

class RemoveDuplicatesFromSortedArrayII {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var slow = 2
        var fast = 2
        var last = nums[1]
        var successive = nums[0] == nums[1]
        while (fast < nums.size) {
            if (last == nums[fast]) {
                if (successive) {
                    fast++
                } else {
                    nums[slow++] = nums[fast++]
                    successive = true
                }
            } else {
                last = nums[fast]
                nums[slow++] = nums[fast++]
                successive = false
            }
        }

        return slow
    }
}