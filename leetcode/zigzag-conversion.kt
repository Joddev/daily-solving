package leetcode

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val stack = CharArray(s.length) { '0' }
        var idx = 0
        (0 until numRows).forEach {
            val downCycle = (numRows - it - 1) * 2
            val upCycle = it * 2
            var down = true
            var cur = it
            while (cur < s.length) {
                val diff = if (down) downCycle else upCycle
                down = !down
                if (diff != 0) {
                    stack[idx++] = s[cur]
                    cur += diff
                }
            }
        }
        return stack.joinToString("")
    }
}
