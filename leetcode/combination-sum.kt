package leetcode

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        combinationSum(candidates, 0, target, emptyList(), result)
        return result
    }

    private fun combinationSum(candidates: IntArray, idx: Int, target: Int, stack: List<Int>, result: MutableList<List<Int>>) {
        if (target == 0) {
            result.add(stack)
            return
        }

        (idx until candidates.size).forEach {
            if (candidates[it] <= target) {
                combinationSum(candidates, it, target - candidates[it], stack + candidates[it], result)
            }
        }
    }
}
