package leetcode

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        val set = mutableSetOf<Pair<Int,Int>>()
        (matrix.indices).forEach { y ->
            (matrix.indices).forEach { x ->
                var (cy, cx) = y to x
                var prev = matrix[cy][cx]
                while (!set.contains(cy to cx)) {
                    val (ny, nx) = convert(cy, cx, matrix)
                    if (ny == cy && nx == cx) {
                        set.add(ny to nx)
                    } else {
                        val tmp = matrix[ny][nx]
                        matrix[ny][nx] = prev
                        set.add(cy to cx)
                        cy = ny
                        cx = nx
                        prev = tmp
                    }
                }
            }
        }
    }

    private fun  convert(y: Int, x: Int, matrix: Array<IntArray>): Pair<Int, Int> {
        return x to (matrix.size - y - 1)
    }
}