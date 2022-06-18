package leetcode

import leetcode.utils.TreeNode

class MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        return if (left == 0 || right == 0) {
            maxOf(left, right) + 1
        } else {
            minOf(left, right) + 1
        }
    }
}