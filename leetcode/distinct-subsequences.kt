package leetcode

class DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int {
        val cache = Array(s.length) { IntArray(t.length) { -1 } }
        return numDistinct(s, t, 0, 0, cache)
    }

    private fun numDistinct(s: String, t: String, si: Int, ti: Int, cache: Array<IntArray>): Int {
        if (ti == t.length) return 1
        if (si == s.length) return 0

        if (cache[si][ti] != -1) return cache[si][ti]

        var ret = 0
        if (s[si] == t[ti]) {
            ret += numDistinct(s, t, si + 1, ti + 1, cache)
        }
        ret += numDistinct(s, t, si + 1, ti, cache)
        cache[si][ti] = ret
        return ret
    }
}