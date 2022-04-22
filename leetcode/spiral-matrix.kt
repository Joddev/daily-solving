package leetcode

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val direction = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var step = 1
        var cur = 0 to 0
        var acc = 0
        var left = matrix[0].size
        val ret = mutableListOf<Int>()
        (0 until matrix.size * matrix[0].size).forEach {
            ret.add(matrix[cur.first][cur.second])
            left--
            if (left == 0) {
                step += 1
                val pad = step / 2
                acc = (acc + 1) % 4
                left = if (acc % 2 == 0) matrix[0].size - pad else matrix.size - pad
            }
            cur = cur.first + direction[acc].first to cur.second + direction[acc].second
        }
        return ret
    }
}