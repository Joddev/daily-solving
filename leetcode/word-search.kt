package leetcode

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        return board.indices.any { y ->
            board[0].indices.any { x ->
                exist(board, word, y, x)
            }
        }
    }

    private fun exist(board: Array<CharArray>, word: String, y: Int, x: Int): Boolean {
        if (word.isEmpty()) return true
        if (y < 0 || y >= board.size || x < 0 || x >= board[0].size) return false
        if (board[y][x] != word.first()) return false

        return listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1).any { (dy, dx) ->
            val prev = board[y][x]
            board[y][x] = '.'
            val value = exist(board, word.substring(1), y + dy, x + dx)
            board[y][x] = prev
            value
        }
    }
}