package leetcode

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var idx = 0
        val minLength = strs.fold(Integer.MAX_VALUE) { acc, s -> minOf(acc, s.length) }
        if (minLength == 0 || minLength == Integer.MAX_VALUE) return ""
        while (idx < minLength && strs.map { it[idx] }.distinct().size == 1) {
            idx++
        }
        return strs[0].substring(0, idx)
    }
}