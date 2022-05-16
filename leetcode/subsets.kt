package leetcode

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        return subsets(nums, 0, listOf())
    }

    private fun subsets(nums: IntArray, idx: Int, acc: List<Int>): List<List<Int>> {
        if (idx == nums.size) return listOf(acc)

        return subsets(nums, idx + 1, acc.plus(nums[idx]))
            .plus(subsets(nums, idx + 1, acc))
    }
}