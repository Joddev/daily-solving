package leetcode

import java.util.*

class SearchA2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val tree = TreeMap<Int, Int>()
        matrix.forEachIndexed { idx, it -> tree[it[0]] = idx }
        if (tree.contains(target)) return true
        val idx = tree.lowerEntry(target)?.value ?: return false
        return matrix[idx].binarySearch(target) >= 0
    }
}