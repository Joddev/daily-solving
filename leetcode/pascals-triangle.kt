package leetcode

class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        (1..numRows).forEach { cur ->
            if (cur <= 2) {
                ret.add(List(cur) { 1 })
            } else {
                val prev = ret.last()
                val now = prev.windowed(2).map { it.sum() }
                ret.add(listOf(1) + now + listOf(1))
            }
        }
        return ret
    }
}