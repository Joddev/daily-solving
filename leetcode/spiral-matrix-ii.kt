package leetcode

class SpiralMatrixII {
    fun generateMatrix(n: Int): Array<IntArray> {
        val direction = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var step = 1
        var cur = 0 to 0
        var acc = 0
        var left = n
        val ret = Array(n) { IntArray(n) }
        (0 until n * n).forEach {
            ret[cur.first][cur.second] = it + 1
            left--
            if (left == 0) {
                step += 1
                val pad = step / 2
                acc = (acc + 1) % 4
                left = if (acc % 2 == 0) n - pad else n - pad
            }
            cur = cur.first + direction[acc].first to cur.second + direction[acc].second
        }
        return ret
    }
}