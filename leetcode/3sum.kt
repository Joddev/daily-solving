package leetcode

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val map = toMap(nums)
        val result = mutableSetOf<List<Int>>()
        nums.indices.forEach { x ->
            if (nums[x] <= 0) {
                (x + 1 until nums.size).forEach { y ->
                    val candidate = (nums[x] + nums[y]) * -1
                    if (map[candidate]?.any { it != x && it != y } == true) {
                        result.add(listOf(nums[x], nums[y], candidate).sorted())
                    }
                }
            }
        }
        return result.toList()
    }

    private fun toMap(nums: IntArray): Map<Int, List<Int>> {
        val map = mutableMapOf<Int, List<Int>>()
        nums.forEachIndexed { index, i ->
            if (map.containsKey(i)) {
                map[i] = map.getValue(i).plus(index)
            } else {
                map[i] = listOf(index)
            }
        }
        return map
    }
}