package leetcode

class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val grid = Array(obstacleGrid.size + 1) { IntArray(obstacleGrid[0].size + 1) }
        if (obstacleGrid[0][0] == 1) {
            return 0
        }
        grid[1][1] = 1
        obstacleGrid.indices.forEach { y ->
            obstacleGrid[0].indices.forEach { x ->
                if (obstacleGrid[y][x] != 1 && grid[y + 1][x + 1] == 0) {
                    grid[y + 1][x + 1] = grid[y][x + 1] + grid[y + 1][x]
                }
            }
        }
        return grid[obstacleGrid.size][obstacleGrid[0].size]
    }
}