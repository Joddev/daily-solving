package leetcode

class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>): Unit {
        val sudokuMap = SudokuMap(board)
        sudokuMap.solve()
    }

    class SudokuMap(
        private val board: Array<CharArray>
    ) {
        private val rowSets = List(9) { mutableSetOf('1','2','3','4','5','6','7','8','9') }
        private val columnSets = List(9) { mutableSetOf('1','2','3','4','5','6','7','8','9') }
        private val districtSets = List(9) { mutableSetOf('1','2','3','4','5','6','7','8','9') }

        init {
            (0 until 9).forEach { y ->
                (0 until 9).forEach { x ->
                    if (board[y][x] != '.') {
                        mark(y, x, board[y][x])
                    }
                }
            }
        }

        fun solve() {
            fillSingleCandidate()
            if (done()) {
                return
            }
            backtracking()
            return
        }

        private fun fillSingleCandidate() {
            var marked = true
            while (marked) {
                marked = false
                (0 until 9).forEach { y ->
                    (0 until 9).forEach { x ->
                        val candidates = findCandidates(y, x)
                        if (board[y][x] == '.' && candidates.size == 1) {
                            val num = candidates.single()
                            board[y][x] = num
                            mark(y, x, num)
                            marked = true
                        }
                    }
                }
            }
        }

        private fun backtracking(): Boolean {
            if (done()) return true
            val (y, x) = findFirst()
            val candidates = findCandidates(y, x)
            candidates.forEach {
                board[y][x] = it
                mark(y, x, it)
                if (backtracking()) return true
                unmark(y, x, it)
                board[y][x] = '.'
            }
            return false
        }

        private fun findFirst(): Pair<Int, Int> {
            (0 until 9).forEach { y ->
                (0 until 9).forEach { x ->
                    if (board[y][x] == '.') return y to x
                }
            }
            return -1 to -1
        }

        private fun mark(y: Int, x: Int, num: Char) {
            rowSets[y].remove(num)
            columnSets[x].remove(num)
            districtSets[district(y, x)].remove(num)
        }

        private fun unmark(y: Int, x: Int, num: Char) {
            rowSets[y].add(num)
            columnSets[x].add(num)
            districtSets[district(y, x)].add(num)
        }

        private fun findCandidates(y: Int, x: Int): Set<Char> {
            return rowSets[y].intersect(columnSets[x]).intersect(districtSets[district(y, x)])
        }

        private fun district(y: Int, x: Int) = (y/3*3) + (x/3)

        private fun done() = board.all { row -> row.all { it != '.' } }
    }
}