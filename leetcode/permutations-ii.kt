package leetcode

class PermutationsII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permuteUnique(nums.groupBy { it }.mapValues { it.value.size }, emptyList())
    }

    private fun permuteUnique(left: Map<Int, Int>, acc: List<Int>): List<List<Int>> {
        if (left.all { it.value == 0 }) return listOf(acc)
        return left.flatMap {
            if (it.value > 0) {
                permuteUnique(left + (it.key to it.value), acc + it.key)
            } else {
                emptyList()
            }
        }
    }
}