package leetcode

class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        if (!arrange(nums, 0)) {
            nums.sort()
        }
    }

    private fun arrange(nums: IntArray, from: Int): Boolean {
        val isLastPermutation = (1 until nums.size).all { nums[it - 1] >= nums[it] }
        if (isLastPermutation) return false

        val idx = reversedIndex(nums, from)
        if (idx == -1) {
            var cur = nums.size - 1
            while (from <= cur && nums[cur] == nums[nums.size - 1]) cur--
            if (from > cur) return false
            nums.swap(cur, nums.size - 1)
            nums.sort(cur + 1)
        } else {
            if (!arrange(nums, idx)) {
                changeOver(nums, idx - 1)
            }
        }
        return true
    }

    private fun changeOver(nums: IntArray, idx: Int) {
        if (idx == -1) {
            nums.sort()
            return
        }
        val isLastPermutation = (idx + 1 until nums.size).all { nums[it - 1] >= nums[it] }
        if (isLastPermutation) return changeOver(nums, idx - 1)

        val next = (idx + 1 until nums.size).reduce { prev, cur ->
            if (nums[cur] > nums[idx] && nums[prev] > nums[cur]) {
                cur
            } else {
                prev
            }
        }
        nums.swap(idx, next)
        nums.sort(idx + 1)
    }

    private fun reversedIndex(nums: IntArray, from: Int): Int {
        return (from + 1 until nums.size).find { nums[it - 1] > nums[it] } ?: -1
    }

    private fun IntArray.swap(a: Int, b: Int) {
        val tmp = this[a]
        this[a] = this[b]
        this[b] = tmp
    }
}
