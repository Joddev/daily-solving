package leetcode

class NQueensII {
    fun totalNQueens(n: Int): Int {
        val map = Array(n) { Array(n) { 0 } }
        return solve(0, map)
    }

    fun solve(depth: Int, map: Array<Array<Int>>): Int {
        if (depth == map.size) {
            return 1
        }

        return map[depth].mapIndexed { index, i ->
            if (map[depth][index] == 0) {
                mark(depth, index, map)
                val sol = solve(depth + 1, map)
                unmark(depth, index, map)
                sol
            } else {
                0
            }
        }.sum()
    }

    fun mark(y: Int, x: Int, map: Array<Array<Int>>) {
        map.indices.forEach { map[y][it] += 1 }
        map.indices.forEach { map[it][x] += 1 }
        map.indices.forEach {
            if (y + it < map.size && x + it < map.size) {
                map[y + it][x + it] += 1
            }
        }
        map.indices.forEach {
            if (y - it >= 0 && x - it >= 0) {
                map[y - it][x - it] += 1
            }
        }
        map.indices.forEach {
            if (y + it < map.size && x - it >=0) {
                map[y + it][x - it] += 1
            }
        }
        map.indices.forEach {
            if (y - it >= 0 && x + it < map.size) {
                map[y - it][x + it] += 1
            }
        }
        map[y][x] = -1
    }

    fun unmark(y: Int, x: Int, map: Array<Array<Int>>) {
        map.indices.forEach { map[y][it] -= 1 }
        map.indices.forEach { map[it][x] -= 1 }
        map.indices.forEach {
            if (y + it < map.size && x + it < map.size) {
                map[y + it][x + it] -= 1
            }
        }
        map.indices.forEach {
            if (y - it >= 0 && x - it >= 0) {
                map[y - it][x - it] -= 1
            }
        }
        map.indices.forEach {
            if (y + it < map.size && x - it >=0) {
                map[y + it][x - it] -= 1
            }
        }
        map.indices.forEach {
            if (y - it >= 0 && x + it < map.size) {
                map[y - it][x + it] -= 1
            }
        }
        map[y][x] = 0
    }
}