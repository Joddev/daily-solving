package leetcode

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        return permute(nums.toSet(), emptyList())
    }

    private fun permute(left: Set<Int>, acc: List<Int>): List<List<Int>> {
        if (left.isEmpty()) return listOf(acc)
        return left.flatMap {
            permute(left - it, acc + it)
        }
    }
}