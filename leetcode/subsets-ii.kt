package leetcode

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            if (map.containsKey(it)) {
                map[it] = map.getValue(it) + 1
            } else {
                map[it] = 1
            }
        }

        return map.entries.fold(listOf(listOf())) { acc, entry ->
            (0..entry.value).map { size ->
                acc.flatMap {
                    it + List(size) { entry.key }
                }
            }
        }
    }
}
