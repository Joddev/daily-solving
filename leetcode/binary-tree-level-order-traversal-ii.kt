package leetcode

import leetcode.utils.TreeNode

class BinaryTreeLevelOrderTraversalII {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        return merge(levelOrderBottom(root.left), levelOrderBottom(root.right)) + listOf(listOf(root.`val`))
    }

    private fun merge(a: List<List<Int>>, b: List<List<Int>>): List<List<Int>> {
        val maxSize = maxOf(a.size, b.size)
        return (0..maxSize).map {
            (a.getOrNull(a.size - maxSize + it) ?: emptyList()) +
                    (b.getOrNull(b.size - maxSize + it) ?: emptyList())
        }.filter {
            it.isNotEmpty()
        }
    }
}