package leetcode

class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var ret = 0
        val visited = mutableMapOf<Int, Int>()
        set.forEach {
            var now = 1
            while (set.contains(it + now) && !visited.containsKey(it + now)) {
                visited[it + now] = 0
                now++
            }
            visited[it] = now + (visited[it + now] ?: 0)
            ret = maxOf(ret, visited.getValue(it))
        }
        return ret
    }
}