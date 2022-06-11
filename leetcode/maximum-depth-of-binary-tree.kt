package leetcode

import leetcode.utils.TreeNode

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}