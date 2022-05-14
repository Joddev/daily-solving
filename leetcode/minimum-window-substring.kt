package leetcode

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val countMap = s.countMap()
        val targetMap = t.countMap()

        targetMap.forEach {
            if (countMap.getOrDefault(it.key, 0) < it.value) {
                return ""
            }
        }

        var left = 0
        var right = s.length - 1
        while (true) {
            val found = s[right]
            if (!targetMap.containsKey(found)) {
                right--
                continue
            }
            if (countMap.getValue(found) > targetMap.getValue(found)) {
                countMap[found] = countMap.getValue(found) - 1
                right--
                continue
            }
            break
        }

        var ret = s.substring(left, right + 1)
        while (true) {
            var target = ' '
            while (true) {
                val found = s[left]
                left++
                if (!targetMap.containsKey(found)) continue

                countMap[found] = countMap.getValue(found) - 1
                if (countMap.getValue(found) < targetMap.getValue(found)) {
                    val value = s.substring(left - 1, right + 1)
                    if (ret.length > value.length) ret = value
                    target = found
                    break
                }
            }

            right++
            while (right < s.length) {
                val found = s[right]
                right++
                if (!targetMap.containsKey(found)) continue
                countMap[found] = countMap.getValue(found) + 1
                if (found == target) {
                    right--
                    break
                }
            }
            if (right == s.length) break
        }

        return ret
    }

    private fun String.countMap(): MutableMap<Char, Int> {
        return fold(mutableMapOf()) { acc, c ->
            if (acc.containsKey(c)) {
                acc[c] = acc.getValue(c) + 1
            } else {
                acc[c] = 1
            }
            acc
        }
    }
}