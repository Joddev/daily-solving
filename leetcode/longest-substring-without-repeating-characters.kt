import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    return s.foldIndexed(0 to 0) { idx, (lastIdx, length), c ->
        val found = map[c]
        map[c] = idx
        if (found != null && found >= lastIdx) {
            (found + 1) to maxOf(length, idx - lastIdx)
        } else {
            lastIdx to max(length, idx - lastIdx + 1)
        }
    }.second
}
