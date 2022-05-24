package leetcode

class MaximalRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        var ret = 0
        matrix.indices.forEach { y ->
            matrix[0].indices.forEach { x ->
                var prev = matrix[0].size - x - 1
                var cur = y
                while (prev > 0 && cur < matrix.size) {
                    var idx = 0
                    while (idx <= prev && matrix[cur][x + idx] == '1') idx++
                    prev = idx - 1
                    ret = maxOf(ret, (cur - y + 1) * prev)
                    cur++
                }
            }
        }

        return ret
    }
}