package leetcode

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return (0..8).all { y ->
            val set = mutableSetOf<Char>()
            if (!(0..8).all { x -> board[y][x].let { it == '.' || set.add(it) }}) return false
            set.clear()
            if (!(0..8).all { x -> board[x][y].let { it == '.' || set.add(it) }}) return false
            set.clear()
            (0..8).all { x -> board[y/3*3+x/3][y%3*3+x%3].let { it == '.' || set.add(it) }}
        }
    }
}