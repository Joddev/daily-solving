package leetcode

class MinimumPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        grid.indices.forEach { y ->
            grid[0].indices.forEach { x ->
                if (y == 0) {
                    if (x != 0) {
                        grid[y][x] = grid[y][x - 1] + grid[y][x]
                    }
                } else {
                    grid[y][x] += minOf(grid.safeGet(y - 1, x), grid.safeGet(y, x - 1))
                }
            }
        }
        return grid[grid.size - 1][grid[0].size - 1]
    }

    private fun Array<IntArray>.safeGet(y: Int, x: Int): Int {
        if (y >= 0 && y < size && x >= 0 && x < this[0].size) {
            return this[y][x]
        }
        return Int.MAX_VALUE
    }
}