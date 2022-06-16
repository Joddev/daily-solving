package leetcode

import leetcode.utils.TreeNode
import kotlin.math.absoluteValue

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        if ((root.left.height() - root.right.height()).absoluteValue > 1) {
            return false
        }
        return isBalanced(root.left) && isBalanced(root.right)
    }

    private fun TreeNode?.height(): Int {
        if (this == null) return 0
        return maxOf(left.height(), right.height()) + 1
    }
}