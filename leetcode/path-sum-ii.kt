package leetcode

import leetcode.utils.TreeNode

class PathSumII {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        if (root.left == null && root.right == null) {
            return if (root.`val` == targetSum) {
                listOf(listOf(targetSum))
            } else {
                emptyList()
            }
        }
        val prev = pathSum(root.left, targetSum - root.`val`) + pathSum(root.right, targetSum - root.`val`)
        return prev.map { listOf(root.`val`) + it }
    }
}