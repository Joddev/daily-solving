package leetcode

class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val firstCol = matrix.any { it[0] == 0 }
        val firstRow = matrix[0].any { it == 0 }

        (1 until matrix.size).forEach { y ->
            (1 until matrix[0].size).forEach { x ->
                if (matrix[y][x] == 0) {
                    matrix[y][0] = 0
                    matrix[0][x] = 0
                }
            }
        }

        (1 until matrix.size).forEach { y ->
            (1 until matrix[0].size).forEach { x ->
                if (matrix[y][0] == 0 || matrix[0][x] == 0) {
                    matrix[y][x] = 0
                }
            }
        }

        if (firstCol) matrix.forEach { it[0] = 0 }
        if (firstRow) matrix[0].indices.forEach { matrix[0][it] = 0 }
    }
}