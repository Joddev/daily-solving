package leetcode

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { str -> str.groupBy { it }.mapValues { it.value.size } }.values.toList()
    }
}