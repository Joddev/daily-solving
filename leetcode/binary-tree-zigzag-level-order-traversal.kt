package leetcode

import leetcode.utils.TreeNode

class BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        return levelOrder(root).mapIndexed { index, ints ->
            if (index % 2 == 0) ints else ints.reversed()
        }
    }

    private fun levelOrder(root: TreeNode?): List<List<Int>> {
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