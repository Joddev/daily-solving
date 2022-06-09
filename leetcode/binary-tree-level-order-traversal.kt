package leetcode

import leetcode.utils.TreeNode

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        return listOf(listOf(root.`val`)) + merge(levelOrder(root.left), levelOrder(root.right))
    }

    private fun merge(a: List<List<Int>>, b: List<List<Int>>): List<List<Int>> {
        return (0..maxOf(a.size, b.size)).map {
            (a.getOrNull(it) ?: emptyList()) + (b.getOrNull(it) ?: emptyList())
        }.filter {
            it.isNotEmpty()
        }
    }
}