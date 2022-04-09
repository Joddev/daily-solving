package leetcode

class CombinationSum2 {
    fun combinationSum2 (candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        val list = mutableListOf<Int>()
        candidates.forEachIndexed { idx, cur ->
            if (idx <= 0 || candidates[idx - 1] != cur) {
                list.add(0)
            } else {
                list.add(list.last() + 1)
            }
        }
        combinationSum2(candidates, list, -1, target, emptyList(), result)
        return result
    }

    private fun combinationSum2(candidates: IntArray, list: List<Int>, idx: Int, target: Int, stack: List<Int>, result: MutableList<List<Int>>) {
        if (target == 0) {
            result.add(stack)
            return
        }

        val last = stack.lastOrNull() ?: 0
        (idx + 1 until candidates.size).forEach {
            if (candidates[it] <= target && (list[it] == 0 || (stack.size - list[it] >= 0 && stack[stack.size - list[it]] == candidates[it]))) {
                combinationSum2(candidates, list, it, target - candidates[it], stack + candidates[it], result)
            }
        }
    }
}
