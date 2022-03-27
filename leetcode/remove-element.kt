package leetcode

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right && nums[left] != `val`) left++
        while (right > left && nums[right] == `val`) right--
        while (left < right) {
            nums[left] = nums[right]
            nums[right] = `val`
            while (left < right && nums[left] != `val`) left++
            while (right > left && nums[right] == `val`) right--
        }
        return left
    }
}